# SpeechControl (No Fabric)

🎮 **SpeechControl (No Fabric)** is a standalone version of the voice control mod for Minecraft that doesn't rely on the Fabric mod loader. This version allows players to control Minecraft actions using speech commands, supporting Hindi, English, and Hinglish voice inputs.

---

## 📂 Directory: `SpeechControl(No Fabric)`

This folder contains a version of the Speech Control system that works without Fabric API. Ideal for testing or integrating into a custom Minecraft environment.

---

## 🧠 Features

- 🎙️ Voice command recognition using CMU Sphinx
- 🧩 Java Robot API integration for keyboard/mouse simulation
- 🌐 Multi-language support: English, Hindi, and Hinglish
- 🎮 Customizable keybind command mapping
- 🧪 Suitable for standalone testing without mod frameworks

---

## 🚀 How to Run

1. Open terminal
2. Locate the file "SpeechControlsGameUniversal.jar" and copy the path of file
3. Run `cd path of file` in the terminal
4. Run `Java -jar SpeechControlsGameUniversal.jar`
5. Speak commands like:
   - `"jump"` → triggers the space key
   - `"chod do"` → triggers the drop key
   - `"attack"` → simulates left click
  
     or

1. Open the project in Eclipse or any Java IDE.
2. Ensure you have:
   - Java 8 or higher
   - CMU Sphinx libraries added to the classpath
3. Modify `commands.gram` and `commands.dic` if needed.
4. Run the main Java class.
5. Speak commands like:
   - `"jump"` → triggers the space key
   - `"chod do"` → triggers the drop key
   - `"attack"` → simulates left click

---

## 🛠️ Customization

- Edit `commands.dic` to add new voice commands and their phonetic representations.
- Update `commands.gram` to define the grammar and allowed phrases.
- Map new commands in the Java code using `Robot.keyPress()` / `keyRelease()`.

---

## 📄 License

This project is part of the [SpeechControlsGame](https://github.com/tilakgupta2005/SpeechControlsGame) repository by [@tilakgupta2005](https://github.com/tilakgupta2005).  
Feel free to fork, modify, and use it for educational and personal purposes.

---

## 🙌 Contribute or Report Issues

Found a bug or have suggestions?  
Open an issue or pull request on the main repo:  
🔗 [https://github.com/tilakgupta2005/SpeechControlsGame](https://github.com/tilakgupta2005/SpeechControlsGame)

---

