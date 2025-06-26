# 🎮 SpeechControlsGame

**SpeechControlsGame** is an innovative voice control system for Minecraft that lets players control in-game actions using spoken commands in **English, Hindi**, and **Hinglish**. The project includes both a **Fabric-based mod version** and a **standalone Java version (no Fabric)**.

---

## 🚀 Features

- 🎙️ Offline voice recognition with [CMU Sphinx](https://cmusphinx.github.io/)
- 🌐 Multilingual support: English, Hindi, and Hinglish
- 🧠 Custom grammar (`.gram`) and dictionary (`.dic`) files
- 🔧 Configurable speech-to-keybind mapping
- 🕹️ Control Minecraft in real time using voice
- 🧩 Includes both a Fabric mod and standalone Java implementation

---

## 📦 Versions

### ✅ `SpeechControl(No Fabric)`
- No mod loader required.
- Built using pure Java and `java.awt.Robot`.
- Ideal for testing on vanilla Minecraft or outside of the game engine.

### ✅ `speechcontrolsgame-template-1.21`
- Requires **Fabric loader** and **Fabric API**.
- Compatible with **Minecraft 1.21+**.
- Packaged as a full Minecraft mod (`.jar` file).

---

## 🧪 How It Works

1. The microphone captures voice input.
2. Speech is matched against the custom grammar (`commands.gram`) and dictionary (`commands.dic`).
3. When matched, it triggers a key or mouse action using `java.awt.Robot` or Minecraft's internal systems.
4. Custom voice commands can be added by modifying the `.gram` and `.dic` files.

---

## 🧰 Requirements

### ✅ For Both Versions:
- **Java 21+**
- **CMU Sphinx** libraries
- Microphone connected to the system
- Basic Java knowledge (for customization)

### ✅ For Fabric Mod Version:
- **Minecraft 1.21+**
- **Fabric Loader 0.16.14+**
- **Fabric API Depends on MC version**

---

## 📂 File Structure to Run Mod in Minecraft

Ensure these files are placed in the correct locations:

<pre>.minecraft/
├── mods/ 
    └── speechcontrolsgame-1.0.0-remapped.jar
</pre>
    
> 🎤 Make sure your microphone is properly connected and configured before launching the game.

---

## 🧠 Voice Commands

| Spoken Command                                                     | Action                          |
| ------------------------------------------------------------------ | ------------------------------- |
| `jump` / `ucho koodo` / `kood jao`                                 | Jump (Space key)                |
| `dheere chalo` / `chupke chalo` / `slow chalo`                     | Sneak Walk (Shift + W)          |
| `udna band karo` / `neeche utro` / `fly mode off karo`             | Disable Fly                     |
| `command likho` / `command kholo` / `type command`                 | Open Command Prompt             |
| `item girao` / `samaan girao` / `drop item`                        | Drop Item (Q key)               |
| `debug screen band karo` / `close debug screen` / `f3 wapas dabao` | Close Debug Screen              |
| `player list chhupao` / `hide player list`                         | Hide Player List (Tab)          |
| `haath badlo` / `swap hands` / `haathon ka saman badlo`            | Swap Hands (F)                  |
| `chat kholo` / `open chat` / `chat on karo`                        | Open Chat (T)                   |
| `view badlo` / `perspective change karo` / `camera`                | Change Perspective (F5)         |
| `screenshot` / `tasveer lo` / `photo lelo`                         | Take Screenshot (F2)            |
| `slot one` / `pehla slot chuno` / `ek number slot lo`              | Select Slot 1                   |
| `slot two` / `doosra slot chuno` / `do number slot lo`             | Select Slot 2                   |
| `slot three` / `teesra slot chuno` / `teen number slot lo`         | Select Slot 3                   |
| `slot four` / `chautha slot chuno` / `chaar number slot lo`        | Select Slot 4                   |
| `slot five` / `paanchva slot chuno` / `paanch number slot lo`      | Select Slot 5                   |
| `slot six` / `chhatha slot chuno` / `cheh number slot lo`          | Select Slot 6                   |
| `slot seven` / `saatva slot chuno` / `saat number slot lo`         | Select Slot 7                   |
| `slot eight` / `aathva slot chuno` / `aath number slot lo`         | Select Slot 8                   |
| `slot nine` / `nauva slot chuno` / `nau number slot lo`            | Select Slot 9                   |
| `inventory kholo` / `samaan dekho` / `open inventory`              | Open Inventory (E)              |
| `inventory band karo` / `samaan chhupao` / `close inventory`       | Close Inventory                 |
| `menu kholo` / `open menu`                                         | Open Menu (Esc)                 |
| `menu band karo` / `menu chhupao`                                  | Close Menu (Esc)                |
| `hide hud` / `hud hatao` / `display clean karo`                    | Hide HUD (F1)                   |
| `show hud` / `hud wapas lao` / `screen dikhao`                     | Show HUD (F1)                   |
| `debug screen` / `debug dekho` / `f3 dabao`                        | Show Debug Screen (F3)          |
| `players dikhao` / `player list kholo` / `show player list`        | Show Player List                |
| `debug info hatao` / `hide debug info`                             | Hide Debug Info (F3 + H)        |
| `debug info dikhao` / `show debug info`                            | Show Debug Info (F3 + H)        |
| `hitbox hatao` / `target box chhupao` / `hide hitbox`              | Hide Hitbox (F3 + B)            |
| `hitbox dikhao` / `show hitbox`                                    | Show Hitbox (F3 + B)            |
| `chunk border hatao` / `hide chunk borders`                        | Hide Chunk Borders (F3 + G)     |
| `chunk border dikhao` / `chunk limit dikhao` / `show chunk border` | Show Chunk Borders              |
| `pura gira do` / `saari items girao` / `drop stack`                | Drop Stack (Ctrl + Q)           |
| `chunks reload karo` / `reload chunks`                             | Reload Chunks (F3 + A)          |
| `chat clear karo` / `clear chat` / `messages hatao`                | Clear Chat (Ctrl + A + Delete)  |
| `use karo` / `use item` / `place item` / `block lagao`             | Use/Place Item (Right Click)    |
| `interact karo` / `attack` / `attack karo` / `hamla karo`          | Attack (Left Click)             |
| `move forward` / `aage jao` / `aage badho`                         | Move Forward (W)                |
| `move back` / `peeche jao` / `peeche hat jao`                      | Move Backward (S)               |
| `move left` / `baaye muro` / `baaye jao`                           | Move Left (A)                   |
| `move right` / `daaye muro` / `daaye jao`                          | Move Right (D)                  |
| `daud lagao` / `tez bhaago` / `sprint`                             | Sprint (Ctrl)                   |
| `upar ud jao` / `ooncha jao` / `fly up`                            | Fly Up (Space)                  |
| `neeche ud jao` / `neeche jao` / `land karo`                       | Fly Down (Shift)                |
| `tod do` / `maaro`                                                 | Break/Attack Block (Left Click) |
| `stop` / `ruk jao` / `band karo`                                   | Stop Movement                   |


---

## 📄 License

MIT License — Free to use, modify, and distribute.  
Please credit [@tilakgupta2005](https://github.com/tilakgupta2005) in any derivative works.

---

## 👤 Author

**Tilak Gupta**  
🔗 [Linktree](https://linktr.ee/tilakgupta2005)  
📬 [GitHub Profile](https://github.com/tilakgupta2005)

---

## 📬 Contributions Welcome!

Pull requests and feedback are welcome!  
For bugs, issues, or feature suggestions, open an issue here:  
👉 [GitHub Issues](https://github.com/tilakgupta2005/SpeechControlsGame/issues)

---


