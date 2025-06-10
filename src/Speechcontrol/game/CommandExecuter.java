package Speechcontrol.game;

public class CommandExecuter {
	    public static void executeCommand(String command) {
	        switch (command.toLowerCase()) {
	            case "forward":
	                System.out.println("➡ Moving forward");
	                break;
	            case "jump":
	                System.out.println("⬆ Jumping");
	                break;
	            case "attack":
	                System.out.println("⚔ Attacking");
	                break;
	            case "stop":
	                System.out.println("⛔ Stopping");
	                break;
	            // Add other command actions here
	            default:
	                System.out.println("❓ Unknown command: " + command);
	        }
	    }
	}