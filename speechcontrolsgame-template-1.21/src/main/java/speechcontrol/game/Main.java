package speechcontrol.game;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class Main implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        new Thread(() -> {
            try {
                //JVM to disable "headless" mode, allowing Java AWT features like Robot, mouse, keyboard, and display interactions to work.
                System.setProperty("java.awt.headless", "false");

                //thread sleep for 60 sec so game can start smoothly
                Thread.sleep(60000);

                //Adds a chat message to the player's chat UI
                MinecraftClient.getInstance().execute(() -> {
                    MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.of("Speech control mod starting"));
                });

                System.out.println("[SpeechControlsGame] ClientModInitializer has been triggered!");

                System.out.println("Headless mode: " + java.awt.GraphicsEnvironment.isHeadless());

                CommandExecuter executer = new CommandExecuter();
                SpeechRecognizer recognizer = new SpeechRecognizer(executer);
                recognizer.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "SpeechRecognizerInitThread").start();
    }

}
