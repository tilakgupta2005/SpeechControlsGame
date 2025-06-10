package Speechcontrol.game;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class SpeechRecognizer implements Runnable {

    private LiveSpeechRecognizer recognizer;
    private boolean active = true;

    public SpeechRecognizer() {
        try {
            Configuration configuration = new Configuration();

            // Path to acoustic model
            configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");

            // Path to dictionary and grammar files (inside your resources folder)
            configuration.setDictionaryPath("file:resources/commands.dic");
            configuration.setGrammarPath("file:resources/");
            configuration.setGrammarName("commands");
            configuration.setUseGrammar(true);

            recognizer = new LiveSpeechRecognizer(configuration);
        } catch (Exception e) {
            System.err.println("❌ Failed to initialize recognizer: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            recognizer.startRecognition(true);
            System.out.println("🎤 Voice control started. Speak your command...");

            while (active) {
                SpeechResult result = recognizer.getResult();
                if (result != null) {
                    String command = result.getHypothesis();
                    System.out.println("🗣 Recognized: " + command);

                    // Handle recognized command
                    CommandExecuter.executeCommand(command);
                }
            }

            recognizer.stopRecognition();
        } catch (Exception e) {
            System.err.println("❌ Error during recognition: " + e.getMessage());
        }
    }

    public void stop() {
        active = false;
    }
}
