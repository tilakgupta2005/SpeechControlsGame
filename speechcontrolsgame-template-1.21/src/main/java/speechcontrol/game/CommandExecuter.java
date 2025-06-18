package speechcontrol.game;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.*;

public class CommandExecuter {

	Set<Integer> activeKeys = new HashSet<>();
	Set<Integer> activeMouseButtons = new HashSet<>();
	HashMap<String, Integer> singleKeyMap;
	HashMap<String, int[]> comboKeyMap;
	Robot robot;

	CommandExecuter() {
	    singleKeyMap = new HashMap<>();
	    comboKeyMap = new HashMap<>();
	    try {
	        robot = new Robot();
	        robot.setAutoDelay(20);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    loadCommands();

	    //Emergency shutdown hook to stop all keys on program exit
	    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
	        System.out.println("Program is shutting down... Releasing all keys and buttons.");
	        stopkey();
	    }));

	    // Periodic safety timer to release keys every 60 seconds (fail-safe)
	    Timer timer = new Timer(true); // true = run as daemon (won't block shutdown)
	    timer.schedule(new TimerTask() {
	        public void run() {
	            System.out.println("Auto-stop safety triggered: releasing all keys/buttons.");
	            stopkey();
	        }
	    }, 60000, 60000); // first after 60s, then every 60s
	}

	void loadCommands() {
		// Space - Jump
		singleKeyMap.put("jump", KeyEvent.VK_SPACE);
		singleKeyMap.put("ucho koodo", KeyEvent.VK_SPACE);
		singleKeyMap.put("kood jao", KeyEvent.VK_SPACE);

		// Shift - Sneak
		singleKeyMap.put("dheere chalo", KeyEvent.VK_SHIFT);
		singleKeyMap.put("chupke chalo", KeyEvent.VK_SHIFT);
		singleKeyMap.put("slow chalo", KeyEvent.VK_SHIFT);
		singleKeyMap.put("udna band karo", KeyEvent.VK_SHIFT);
		singleKeyMap.put("neeche utro", KeyEvent.VK_SHIFT);
		singleKeyMap.put("fly mode off karo", KeyEvent.VK_SHIFT);

		// / - Open Command Input
		singleKeyMap.put("command likho", KeyEvent.VK_SLASH);
		singleKeyMap.put("command kholo", KeyEvent.VK_SLASH);
		singleKeyMap.put("type command", KeyEvent.VK_SLASH);

		// Q - Drop Item
		singleKeyMap.put("item girao", KeyEvent.VK_Q);
		singleKeyMap.put("samaan girao", KeyEvent.VK_Q);
		singleKeyMap.put("drop item", KeyEvent.VK_Q);

		// F3 - Close Debug Screen
		singleKeyMap.put("debug screen band karo", KeyEvent.VK_F3);
		singleKeyMap.put("close debug screen", KeyEvent.VK_F3);
		singleKeyMap.put("f3 wapas dabao", KeyEvent.VK_F3);

		// Tab - Hide Player List
		singleKeyMap.put("player list chhupao", KeyEvent.VK_TAB);
		singleKeyMap.put("hide player list", KeyEvent.VK_TAB);

		// F - Swap Hands
		singleKeyMap.put("haath badlo", KeyEvent.VK_F);
		singleKeyMap.put("swap hands", KeyEvent.VK_F);
		singleKeyMap.put("haathon ka saman badlo", KeyEvent.VK_F);

		// T - Open Chat
		singleKeyMap.put("chat kholo", KeyEvent.VK_T);
		singleKeyMap.put("open chat", KeyEvent.VK_T);
		singleKeyMap.put("chat on karo", KeyEvent.VK_T);

		// F5 - Toggle Perspective
		singleKeyMap.put("view badlo", KeyEvent.VK_F5);
		singleKeyMap.put("perspective change karo", KeyEvent.VK_F5);
		singleKeyMap.put("camera", KeyEvent.VK_F5);

		// F2 - Take Screenshot
		singleKeyMap.put("screenshot", KeyEvent.VK_F2);
		singleKeyMap.put("tasveer lo", KeyEvent.VK_F2);
		singleKeyMap.put("photo lelo", KeyEvent.VK_F2);

		// 1 to 9 - Hotbar Slots
		singleKeyMap.put("pehla slot chuno", KeyEvent.VK_1);
		singleKeyMap.put("slot one", KeyEvent.VK_1);
		singleKeyMap.put("ek number slot lo", KeyEvent.VK_1);

		singleKeyMap.put("doosra slot chuno", KeyEvent.VK_2);
		singleKeyMap.put("slot two", KeyEvent.VK_2);
		singleKeyMap.put("do number slot lo", KeyEvent.VK_2);

		singleKeyMap.put("teesra slot chuno", KeyEvent.VK_3);
		singleKeyMap.put("slot three", KeyEvent.VK_3);
		singleKeyMap.put("teen number slot lo", KeyEvent.VK_3);

		singleKeyMap.put("chautha slot chuno", KeyEvent.VK_4);
		singleKeyMap.put("slot four", KeyEvent.VK_4);
		singleKeyMap.put("chaar number slot lo", KeyEvent.VK_4);

		singleKeyMap.put("paanchva slot chuno", KeyEvent.VK_5);
		singleKeyMap.put("slot five", KeyEvent.VK_5);
		singleKeyMap.put("paanch number slot lo", KeyEvent.VK_5);

		singleKeyMap.put("chhatha slot chuno", KeyEvent.VK_6);
		singleKeyMap.put("slot six", KeyEvent.VK_6);
		singleKeyMap.put("cheh number slot lo", KeyEvent.VK_6);

		singleKeyMap.put("saatva slot chuno", KeyEvent.VK_7);
		singleKeyMap.put("slot seven", KeyEvent.VK_7);
		singleKeyMap.put("saat number slot lo", KeyEvent.VK_7);

		singleKeyMap.put("aathva slot chuno", KeyEvent.VK_8);
		singleKeyMap.put("slot eight", KeyEvent.VK_8);
		singleKeyMap.put("aath number slot lo", KeyEvent.VK_8);

		singleKeyMap.put("nauva slot chuno", KeyEvent.VK_9);
		singleKeyMap.put("slot nine", KeyEvent.VK_9);
		singleKeyMap.put("nau number slot lo", KeyEvent.VK_9);

		// E - Open/Close Inventory
		singleKeyMap.put("inventory kholo", KeyEvent.VK_E);
		singleKeyMap.put("samaan dekho", KeyEvent.VK_E);
		singleKeyMap.put("open inventory", KeyEvent.VK_E);
		singleKeyMap.put("inventory band karo", KeyEvent.VK_E);
		singleKeyMap.put("samaan chhupao", KeyEvent.VK_E);
		singleKeyMap.put("close inventory", KeyEvent.VK_E);

		// Esc - Open/Close Menu
		singleKeyMap.put("menu kholo", KeyEvent.VK_ESCAPE);
		singleKeyMap.put("menu band karo", KeyEvent.VK_ESCAPE);
		singleKeyMap.put("menu chhupao", KeyEvent.VK_ESCAPE);
		singleKeyMap.put("open menu", KeyEvent.VK_ESCAPE);

		// F1 - Hide/Show HUD
		singleKeyMap.put("hide hud", KeyEvent.VK_F1);
		singleKeyMap.put("show hud", KeyEvent.VK_F1);
		singleKeyMap.put("hud hatao", KeyEvent.VK_F1);
		singleKeyMap.put("display clean karo", KeyEvent.VK_F1);
		singleKeyMap.put("hud wapas lao", KeyEvent.VK_F1);
		singleKeyMap.put("screen dikhao", KeyEvent.VK_F1);
		singleKeyMap.put("display wapas karo", KeyEvent.VK_F1);

		// F3 - Open Debug Screen
		singleKeyMap.put("debug screen", KeyEvent.VK_F3);
		singleKeyMap.put("debug dekho", KeyEvent.VK_F3);
		singleKeyMap.put("f3 dabao", KeyEvent.VK_F3);

		// Tab - Show Player List
		singleKeyMap.put("players dikhao", KeyEvent.VK_TAB);
		singleKeyMap.put("player list kholo", KeyEvent.VK_TAB);
		singleKeyMap.put("show player list", KeyEvent.VK_TAB);



		// F3 + H - Hide Debug Info
		comboKeyMap.put("debug info hatao", new int[] {KeyEvent.VK_F3, KeyEvent.VK_H});
		comboKeyMap.put("hide debug info", new int[] {KeyEvent.VK_F3, KeyEvent.VK_H});

		// F3 + B - Hide Hitboxes
		comboKeyMap.put("hitbox hatao", new int[] {KeyEvent.VK_F3, KeyEvent.VK_B});
		comboKeyMap.put("target box chhupao", new int[] {KeyEvent.VK_F3, KeyEvent.VK_B});
		comboKeyMap.put("hide hitbox", new int[] {KeyEvent.VK_F3, KeyEvent.VK_B});

		// F3 + G - Hide Chunk Borders
		comboKeyMap.put("chunk border hatao", new int[] {KeyEvent.VK_F3, KeyEvent.VK_G});
		comboKeyMap.put("hide chunk borders", new int[] {KeyEvent.VK_F3, KeyEvent.VK_G});
		
		// Ctrl + Q - Drop Stack
		comboKeyMap.put("pura gira do", new int[] {KeyEvent.VK_CONTROL, KeyEvent.VK_Q});
		comboKeyMap.put("saari items girao", new int[] {KeyEvent.VK_CONTROL, KeyEvent.VK_Q});
		comboKeyMap.put("drop stack", new int[] {KeyEvent.VK_CONTROL, KeyEvent.VK_Q});

		// F3 + A - Reload Chunks
		comboKeyMap.put("chunks reload karo", new int[] {KeyEvent.VK_F3, KeyEvent.VK_A});
		comboKeyMap.put("reload chunks", new int[] {KeyEvent.VK_F3, KeyEvent.VK_A});
		
		// F3 + D - Clear Chat History
		comboKeyMap.put("chat clear karo", new int[] {KeyEvent.VK_F3, KeyEvent.VK_D});
		comboKeyMap.put("clear chat", new int[] {KeyEvent.VK_F3, KeyEvent.VK_D});
		comboKeyMap.put("messages hatao", new int[] {KeyEvent.VK_F3, KeyEvent.VK_D});

		// F3 + H - Show Debug Info
		comboKeyMap.put("debug info dikhao", new int[] {KeyEvent.VK_F3, KeyEvent.VK_H});
		comboKeyMap.put("show debug info", new int[] {KeyEvent.VK_F3, KeyEvent.VK_H});

		// F3 + B - Show Hitboxes
		comboKeyMap.put("hitbox dikhao", new int[] {KeyEvent.VK_F3, KeyEvent.VK_B});
		comboKeyMap.put("show hitbox", new int[] {KeyEvent.VK_F3, KeyEvent.VK_B});

		// F3 + G - Show Chunk Borders
		comboKeyMap.put("chunk border dikhao", new int[] {KeyEvent.VK_F3, KeyEvent.VK_G});
		comboKeyMap.put("chunk limit dikhao", new int[] {KeyEvent.VK_F3, KeyEvent.VK_G});
		comboKeyMap.put("show chunk border", new int[] {KeyEvent.VK_F3, KeyEvent.VK_G});



		// Right Click - Use Item
		singleKeyMap.put("use karo", InputEvent.BUTTON3_DOWN_MASK);
		singleKeyMap.put("use item", InputEvent.BUTTON3_DOWN_MASK);
		
		// Right Click - Place Item
		singleKeyMap.put("item rakho", InputEvent.BUTTON3_DOWN_MASK);
		singleKeyMap.put("place item", InputEvent.BUTTON3_DOWN_MASK);
		singleKeyMap.put("block lagao", InputEvent.BUTTON3_DOWN_MASK);

		// Right Click - Interact
		singleKeyMap.put("interact karo", InputEvent.BUTTON3_DOWN_MASK);

		// Right Click - Attack
		singleKeyMap.put("attack", InputEvent.BUTTON3_DOWN_MASK);
		singleKeyMap.put("attack karo", InputEvent.BUTTON3_DOWN_MASK);
		singleKeyMap.put("hamla karo", InputEvent.BUTTON3_DOWN_MASK);



		// Movement Keys
		singleKeyMap.put("move forward", KeyEvent.VK_W);
		singleKeyMap.put("aage jao", KeyEvent.VK_W);
		singleKeyMap.put("aage badho", KeyEvent.VK_W);

		singleKeyMap.put("move back", KeyEvent.VK_S);
		singleKeyMap.put("peeche jao", KeyEvent.VK_S);
		singleKeyMap.put("peeche hat jao", KeyEvent.VK_S);

		singleKeyMap.put("move left", KeyEvent.VK_A);
		singleKeyMap.put("baaye muro", KeyEvent.VK_A);
		singleKeyMap.put("baaye jao", KeyEvent.VK_A);

		singleKeyMap.put("move right", KeyEvent.VK_D);
		singleKeyMap.put("daaye muro", KeyEvent.VK_D);
		singleKeyMap.put("daaye jao", KeyEvent.VK_D);

		// Ctrl + A - Sprint
		singleKeyMap.put("daud lagao", KeyEvent.VK_CONTROL);
		singleKeyMap.put("tez bhaago", KeyEvent.VK_CONTROL);
		singleKeyMap.put("sprint", KeyEvent.VK_CONTROL);

		// Space - Fly Up
		singleKeyMap.put("upar ud jao", KeyEvent.VK_SPACE);
		singleKeyMap.put("ooncha jao", KeyEvent.VK_SPACE);
		singleKeyMap.put("fly up", KeyEvent.VK_SPACE);

		// Shift - Fly Down
		singleKeyMap.put("neeche ud jao", KeyEvent.VK_SHIFT);
		singleKeyMap.put("neeche jao", KeyEvent.VK_SHIFT);
		singleKeyMap.put("land karo", KeyEvent.VK_SHIFT);

		// Shift - Sneak (same key, different intent)
		singleKeyMap.put("dheere chalo", KeyEvent.VK_SHIFT);
		singleKeyMap.put("chupke chalo", KeyEvent.VK_SHIFT);
		singleKeyMap.put("slow chalo", KeyEvent.VK_SHIFT);

		// Left Click - Attack / Break Block
		singleKeyMap.put("tod do", InputEvent.BUTTON1_DOWN_MASK);
		singleKeyMap.put("maaro", InputEvent.BUTTON1_DOWN_MASK);

		singleKeyMap.put("stop", -9468113);
		singleKeyMap.put("ruk jao", -9468113);
		singleKeyMap.put("band karo", -9468113);
		singleKeyMap.put("disable", -9468113);

	}

	public void stopkey() {
		System.out.println("Stopping all active keys and buttons...");
		for (int key : activeKeys) {
			if (key == InputEvent.BUTTON1_DOWN_MASK)
				robot.mouseRelease(key);
			robot.keyRelease(key);
		}
		activeKeys.clear();

		for (int button : activeMouseButtons) {
			robot.mouseRelease(button);
		}
		activeMouseButtons.clear();
	}

	public void executeCommand(String voiceCommand) {
		voiceCommand = voiceCommand.trim().toLowerCase();
		try {
			//STOP KEY
			if (singleKeyMap.containsKey(voiceCommand) && singleKeyMap.get(voiceCommand) == -9468113) {
				stopkey();
			}
			//SINGLE KEY
			if (singleKeyMap.containsKey(voiceCommand)) {
				int keyCode = singleKeyMap.get(voiceCommand);
				//RIGHT CLICK FOR 2 SEC
				if (keyCode == InputEvent.BUTTON3_DOWN_MASK) {
					System.out.println("Mouse Right Click: " + voiceCommand);
					robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
					robot.delay(2000);
					robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
				}
				//CONTINOUS PRESS KEY A,W,S,D,SPACE,SHIFT
				else if(keyCode == KeyEvent.VK_A ||keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_D || voiceCommand.equals("sky ki taraf jao") || voiceCommand.equals("ooncha jao")|| voiceCommand.equals("upar ud jao") || voiceCommand.equals("fly up") || keyCode == KeyEvent.VK_SHIFT) {
					robot.keyPress(keyCode);
					activeKeys.add(keyCode);
					System.out.println("Holding key: " + voiceCommand + " -> " + KeyEvent.getKeyText(keyCode));
				}
				//CONTINOUS LEFT CLICK PRESS
				else if(keyCode == InputEvent.BUTTON1_DOWN_MASK) {
					System.out.println("Mouse Left Click: " + voiceCommand);
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					activeKeys.add(keyCode);
				}
				//CONTINOUS Ctrl + A
				else if(keyCode == KeyEvent.VK_CONTROL) {
					robot.keyPress(keyCode);
					robot.keyPress(KeyEvent.VK_W);
					activeKeys.add(keyCode);
					activeKeys.add(KeyEvent.VK_W);
					System.out.println("Holding key: " + voiceCommand + " -> " + KeyEvent.getKeyText(keyCode) + "+ A");

				}
				//REST ONE TIME KEY
				else {
					System.out.println("Single Key: " + voiceCommand + " -> " + KeyEvent.getKeyText(keyCode));
					robot.keyPress(keyCode);
					robot.delay(100);
					robot.keyRelease(keyCode);
				}
			}
			else if (comboKeyMap.containsKey(voiceCommand)) {
				int[] combo = comboKeyMap.get(voiceCommand);
				System.out.println("Combo Keys: " + voiceCommand + " -> " + Arrays.toString(combo));
				for (int key : combo) robot.keyPress(key);
				robot.delay(100);
				for (int i = combo.length - 1; i >= 0; i--) robot.keyRelease(combo[i]);
			}

			//continous keys A,W,S,D,SPACE,SHIFT,Ctrl +A,left-click;

			else {
				System.out.println("Unknown command: " + voiceCommand);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
