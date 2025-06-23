package Speechcontrol.game;

public class Main {
	public static void main(String[] args) {

		FileCreation filecheck = new FileCreation();
		filecheck.checkfile();

		CommandExecuter executer = new CommandExecuter();
		SpeechRecognizer recognizer = new SpeechRecognizer(executer);

		Thread speechThread = new Thread(recognizer);
		speechThread.start();
	}
}
