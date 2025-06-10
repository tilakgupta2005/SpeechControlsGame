package Speechcontrol.game;

public class Main {
	public static void main(String[] args) {
        SpeechRecognizer recognizer = new SpeechRecognizer();
        Thread speechThread = new Thread(recognizer);
        speechThread.start();

        // You can continue other tasks here
    }
}
