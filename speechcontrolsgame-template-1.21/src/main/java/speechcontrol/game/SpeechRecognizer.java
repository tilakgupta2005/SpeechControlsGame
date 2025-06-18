package speechcontrol.game;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;


public class SpeechRecognizer extends Thread {

    private LiveSpeechRecognizer recognizer;
    private boolean active = true;
    private CommandExecuter executer;

    public SpeechRecognizer(CommandExecuter executer) {

        this.executer = executer;

        try {
            String basePath = System.getProperty("user.home") + "/AppData/Roaming/.minecraft/config/speechcontrolsgame";
            System.out.println(basePath);

            Configuration configuration = new Configuration();
            configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
            configuration.setDictionaryPath("file:" + basePath + "/commands.dic");
            configuration.setGrammarPath("file:" + basePath);
            configuration.setGrammarName("commands");
            configuration.setUseGrammar(true);


            recognizer = new LiveSpeechRecognizer(configuration);
        } catch (Exception e) {
            System.err.println("Failed to initialize recognizer: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            recognizer.startRecognition(true);
            System.out.println("Voice control started. Speak your command...");

            while (active) {
                SpeechResult result = recognizer.getResult();
                if (result != null) {
                    String command = result.getHypothesis();
                    System.out.println("Recognized: " + command);

                    executer.executeCommand(command); // Use instance method properly

                    MinecraftClient.getInstance().execute(() -> {
                        MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.of("Recognized: " + command));
                    });
                }
            }

            recognizer.stopRecognition();
        } catch (Exception e) {
            System.out.println("Error during recognition: " + e.getMessage());
        }
    }

    public void stopRecognizer() {
    	active = false;
    }
}
