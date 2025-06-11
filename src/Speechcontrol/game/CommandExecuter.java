package Speechcontrol.game;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.*;

public class CommandExecuter {

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
    }

    void loadCommands() {
        // Single key bindings
        singleKeyMap.put("aage jao", KeyEvent.VK_W);
        singleKeyMap.put("peeche jao", KeyEvent.VK_S);
        singleKeyMap.put("baaye muro", KeyEvent.VK_A);
        singleKeyMap.put("daaye muro", KeyEvent.VK_D);
        singleKeyMap.put("jump", KeyEvent.VK_SPACE);
        singleKeyMap.put("maar", KeyEvent.VK_SPACE);
        singleKeyMap.put("dheere chalo", KeyEvent.VK_SHIFT);
        singleKeyMap.put("daud lagao", KeyEvent.VK_CONTROL);
        singleKeyMap.put("inventory kholo", KeyEvent.VK_E);
        singleKeyMap.put("chat kholo", KeyEvent.VK_T);
        singleKeyMap.put("command likho", KeyEvent.VK_SLASH);
        singleKeyMap.put("item girao", KeyEvent.VK_Q);
        singleKeyMap.put("haath badlo", KeyEvent.VK_F);
        singleKeyMap.put("menu kholo", KeyEvent.VK_ESCAPE);
        singleKeyMap.put("menu kholo ya band karo", KeyEvent.VK_ESCAPE);
        singleKeyMap.put("view badlo", KeyEvent.VK_F5);
        singleKeyMap.put("debug screen kholo", KeyEvent.VK_F3);
        singleKeyMap.put("message bhejo", KeyEvent.VK_ENTER);
        singleKeyMap.put("private message bhejo", KeyEvent.VK_ENTER);
        singleKeyMap.put("saare players dikhao", KeyEvent.VK_TAB);
        singleKeyMap.put("social screen kholo", KeyEvent.VK_P);
        singleKeyMap.put("udna shuru karo", KeyEvent.VK_SPACE);
        singleKeyMap.put("udna band karo", KeyEvent.VK_SPACE);
        singleKeyMap.put("upar ud jao", KeyEvent.VK_SPACE);
        singleKeyMap.put("neeche ud jao", KeyEvent.VK_SHIFT);
        singleKeyMap.put("screen se sab hatao", KeyEvent.VK_F1);
        singleKeyMap.put("screenshot lo", KeyEvent.VK_F2);
        singleKeyMap.put("camera view badlo", KeyEvent.VK_F5);
        singleKeyMap.put("fullscreen on off karo", KeyEvent.VK_F11);
        singleKeyMap.put("pehla slot chuno", KeyEvent.VK_1);
        singleKeyMap.put("doosra slot chuno", KeyEvent.VK_2);
        singleKeyMap.put("teesra slot chuno", KeyEvent.VK_3);
        singleKeyMap.put("chautha slot chuno", KeyEvent.VK_4);
        singleKeyMap.put("paanchva slot chuno", KeyEvent.VK_5);
        singleKeyMap.put("chhatha slot chuno", KeyEvent.VK_6);
        singleKeyMap.put("saatva slot chuno", KeyEvent.VK_7);
        singleKeyMap.put("aathva slot chuno", KeyEvent.VK_8);
        singleKeyMap.put("nauva slot chuno", KeyEvent.VK_9);

        // Combo keys
        comboKeyMap.put("pura gira do", new int[]{KeyEvent.VK_CONTROL, KeyEvent.VK_Q});
        comboKeyMap.put("chunks reload karo", new int[]{KeyEvent.VK_F3, KeyEvent.VK_A});
        comboKeyMap.put("hitbox dikhao", new int[]{KeyEvent.VK_F3, KeyEvent.VK_B});
        comboKeyMap.put("chat clear karo", new int[]{KeyEvent.VK_F3, KeyEvent.VK_D});
        comboKeyMap.put("chunk border dikhao", new int[]{KeyEvent.VK_F3, KeyEvent.VK_G});
    }

    public void executeCommand(String voiceCommand) {
        voiceCommand = voiceCommand.trim().toLowerCase();
        try {
            if (singleKeyMap.containsKey(voiceCommand)) {
                int keyCode = singleKeyMap.get(voiceCommand);
                System.out.println("✅ Single Key: " + voiceCommand + " → " + KeyEvent.getKeyText(keyCode));
                robot.keyPress(keyCode);
                robot.delay(100);
                robot.keyRelease(keyCode);
            } else if (comboKeyMap.containsKey(voiceCommand)) {
                int[] combo = comboKeyMap.get(voiceCommand);
                System.out.println("✅ Combo Keys: " + voiceCommand + " → " + Arrays.toString(combo));
                for (int key : combo) robot.keyPress(key);
                robot.delay(100);
                for (int i = combo.length - 1; i >= 0; i--) robot.keyRelease(combo[i]);
            } else if (voiceCommand.equals("item rakho") || voiceCommand.equals("use karo")) {
                System.out.println("✅ Mouse Right Click: " + voiceCommand);
                robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
            } else if (voiceCommand.equals("tod do") || voiceCommand.equals("maaro")) {
                System.out.println("✅ Mouse Left Click: " + voiceCommand);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            } else if (voiceCommand.equals("block uthao")) {
                System.out.println("✅ Mouse Middle Click: " + voiceCommand);
                robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
            } else {
                System.out.println("❌ Unknown command: " + voiceCommand);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
