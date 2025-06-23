package speechcontrol.game;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCreation {
    public void checkfile(String basePath) {
        String dic = "koodo K UW D OW\n" +
                "chupke CH UH P K EY\n" +
                "saman S AH M AH N\n" +
                "dikhao D IH K HH AA OW\n" +
                "bhaago B AA G OW\n" +
                "ooncha UH N CH AA\n" +
                "show SH OW\n" +
                "gira G IH R AA\n" +
                "aage AA G EY\n" +
                "aath AA TH\n" +
                "aathva AA TH V AA\n" +
                "area EH R IY AH\n" +
                "attack AH T AE K\n" +
                "baaye B AA Y EY\n" +
                "back B AE K\n" +
                "badho B AH D HH OW\n" +
                "badlo B AH D L OW\n" +
                "band B AH N D\n" +
                "block B L AA K\n" +
                "border B AO R D ER\n" +
                "borders B AO R D ER Z\n" +
                "box B AA K S\n" +
                "camera K AE M R AH\n" +
                "chaar CH AA R\n" +
                "chalo CH AH L OW\n" +
                "change CH EY N JH\n" +
                "chat CH AE T\n" +
                "chautha CH AO TH AA\n" +
                "cheh CH EH\n" +
                "chhatha CH AH TH AA\n" +
                "chhupao CH UH P AA OW\n" +
                "chunk CH AH NG K\n" +
                "chunks CH AH NG K S\n" +
                "chuno CH UH N OW\n" +
                "clean K L IY N\n" +
                "clear K L IH R\n" +
                "close K L OW S\n" +
                "command K AH M AE N D\n" +
                "daaye D AA Y EY\n" +
                "dabao D AH B AA OW\n" +
                "daud D AO D\n" +
                "debug D IH B AH G\n" +
                "dekho D EH K HH OW\n" +
                "dheere D IH R EH\n" +
                "disable D IH S EY B AH L\n" +
                "display D IH S P L EY\n" +
                "do D OW\n" +
                "doosra D OW S R AA\n" +
                "drop D R AO P\n" +
                "eight EY T\n" +
                "ek EY K\n" +
                "f3 EH F TH R IY\n" +
                "feko F EH K OW\n" +
                "five F AY V\n" +
                "fly F L AY\n" +
                "forward F AO R W ER D\n" +
                "four F AO R\n" +
                "girao G IH R AA OW\n" +
                "haath HH AA TH\n" +
                "haathon HH AA TH OW N\n" +
                "hamla HH AH M L AA\n" +
                "hands HH AE N D Z\n" +
                "hat HH AH T\n" +
                "hatao HH AH T AA OW\n" +
                "hide HH AY D\n" +
                "hitbox HH IH T B AA K S\n" +
                "hud HH AH D\n" +
                "info IH N F OW\n" +
                "interact IH N T ER AE K T\n" +
                "inventory IH N V EH N T ER IY\n" +
                "item AY T AH M\n" +
                "items AY T AH M Z\n" +
                "jao JH AA OW\n" +
                "jump JH AH M P\n" +
                "ka K AH\n" +
                "karo K AA R OW\n" +
                "kholo K HH OW L OW\n" +
                "kood K UW D\n" +
                "kuch K UH CH\n" +
                "lagao L AH G AA OW\n" +
                "land L AE N D\n" +
                "lao L AA OW\n" +
                "left L EH F T\n" +
                "lelo L EH L OW\n" +
                "likho L IH K HH OW\n" +
                "limit L IH M IH T\n" +
                "list L IH S T\n" +
                "lo L OW\n" +
                "maaro M AA R OW\n" +
                "map M AE P\n" +
                "menu M EH N Y UW\n" +
                "messages M EH S AH JH IH Z\n" +
                "mode M OW D\n" +
                "move M UW V\n" +
                "muro M UH R OW\n" +
                "nau N OW\n" +
                "nauva N OW V AA\n" +
                "neeche N IY CH EY\n" +
                "niche N IY CH EY\n" +
                "nine N AY N\n" +
                "number N AH M B ER\n" +
                "off AO F\n" +
                "on AA N\n" +
                "one W AH N\n" +
                "open OW P AH N\n" +
                "paanch P AA N CH\n" +
                "paanchva P AA N CH V AA\n" +
                "pause P AO Z\n" +
                "peeche P IY CH EY\n" +
                "pehla P EH L AA\n" +
                "perspective P ER S P EH K T IH V\n" +
                "photo F OW T OW\n" +
                "place P L EY S\n" +
                "player P L EY ER\n" +
                "players P L EY ER Z\n" +
                "pura P UH R AA\n" +
                "rakho R AH K HH OW\n" +
                "reload R IY L OW D\n" +
                "right R AY T\n" +
                "ruk R UH K\n" +
                "saaf S AA F\n" +
                "saari S AA R IY\n" +
                "saat S AA T\n" +
                "saatva S AA T V AA\n" +
                "sab S AH B\n" +
                "samaan S AH M AA N\n" +
                "screen S K R IY N\n" +
                "screenshot S K R IY N SH AA T\n" +
                "seven S EH V AH N\n" +
                "six S IH K S\n" +
                "swim  S W IH M\n" +
                "sky S K AY\n" +
                "slot S L AA T\n" +
                "slow S L OW\n" +
                "sprint S P R IH N T\n" +
                "stack S T AE K\n" +
                "stop S T AA P\n" +
                "swap S W AA P\n" +
                "taraf T AH R AH F\n" +
                "target T AA R G EH T\n" +
                "tasveer T AH S V IY R\n" +
                "teen T IY N\n" +
                "teesra T IY S R AA\n" +
                "tez T EY Z\n" +
                "three TH R IY\n" +
                "tod T OW D\n" +
                "two T UW\n" +
                "type T AY P\n" +
                "ucho UH CH OW\n" +
                "ud UH D\n" +
                "udna UH D N AH\n" +
                "up AH P\n" +
                "upar UW P AA R\n" +
                "use Y UW S\n" +
                "utro UH T R OW\n" +
                "view V Y UW\n" +
                "wapas W AA P AH S";
        String gram = "#JSGF V1.0;\n" +
        "\n" +
                "grammar commands;\n" +
                "\n" +
                "public <command> = \n" +
                "  jump | ucho koodo | kood jao\n" +
                "| dheere chalo | chupke chalo | slow chalo | udna band karo | neeche utro | fly mode off karo\n" +
                "| command likho | command kholo | type command\n" +
                "| item girao | samaan girao | drop item\n" +
                "| debug screen band karo | close debug screen | f3 wapas dabao\n" +
                "| player list chhupao | hide player list\n" +
                "| haath badlo | swap hands | haathon ka saman badlo\n" +
                "| chat kholo | open chat | chat on karo\n" +
                "| view badlo | perspective change karo | camera\n" +
                "| screenshot | tasveer lo | photo lelo\n" +
                "| pehla slot chuno | slot one | ek number slot lo\n" +
                "| doosra slot chuno | slot two | do number slot lo\n" +
                "| teesra slot chuno | slot three | teen number slot lo\n" +
                "| chautha slot chuno | slot four | chaar number slot lo\n" +
                "| paanchva slot chuno | slot five | paanch number slot lo\n" +
                "| chhatha slot chuno | slot six | cheh number slot lo\n" +
                "| saatva slot chuno | slot seven | saat number slot lo\n" +
                "| aathva slot chuno | slot eight | aath number slot lo\n" +
                "| nauva slot chuno | slot nine | nau number slot lo\n" +
                "| inventory kholo | samaan dekho | open inventory | inventory band karo | samaan chhupao | close inventory\n" +
                "| menu kholo | menu band karo | menu chhupao | open menu\n" +
                "| hide hud | show hud | hud hatao | display clean karo | hud wapas lao | screen dikhao | display wapas karo\n" +
                "| debug screen | debug dekho | f3 dabao\n" +
                "| players dikhao | player list kholo | show player list\n" +
                "| debug info hatao | hide debug info\n" +
                "| hitbox hatao | target box chhupao | hide hitbox\n" +
                "| chunk border hatao | hide chunk borders\n" +
                "| pura gira do | saari items girao | drop stack\n" +
                "| chunks reload karo | reload chunks\n" +
                "| chat clear karo | clear chat | messages hatao\n" +
                "| debug info dikhao | show debug info\n" +
                "| hitbox dikhao | show hitbox\n" +
                "| chunk border dikhao | chunk limit dikhao | show chunk border\n" +
                "| use karo | use item | item rakho | place item | block lagao | interact karo | attack | attack karo | hamla karo\n" +
                "| move forward | aage jao | aage badho\n" +
                "| move back | peeche jao | peeche hat jao\n" +
                "| move left | baaye muro | baaye jao\n" +
                "| move right | daaye muro | daaye jao\n" +
                "| daud lagao | tez bhaago | sprint\n" +
                "| upar ud jao | ooncha jao | fly up\n" +
                "| neeche ud jao | neeche jao | land karo\n" +
                "| tod do | maaro | attack karo\n" +
                "| stop | ruk jao | band karo | swim | disable;\n";


        File file1 = new File(basePath + "/commands.gram");
        File file2 = new File(basePath + "/commands.dic");

        if (file1.exists()) {
            boolean deleted = file1.delete();
            if (deleted) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete file.");
            }
        } else {
            System.out.println("File does not exist.");
        }

        if (file2.exists()) {
            boolean deleted = file2.delete();
            if (deleted) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete file.");
            }
        } else {
            System.out.println("File does not exist.");
        }

        // Create parent directories if they don't exist
        file1.getParentFile().mkdirs();
        file2.getParentFile().mkdirs();

        if (!file1.exists()) {
            try {
                // Create the file
                if (file1.createNewFile()) {
                    System.out.println("File created at: " + file1.getAbsolutePath());

                    // Optionally write some default content:
                    try (FileWriter writer = new FileWriter(file1)) {
                        writer.write(gram);
                    }
                } else {
                    System.out.println("Could not create file.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File already exists at: " + file1.getAbsolutePath());
        }

        if (!file2.exists()) {
            try {
                // Create the file
                if (file2.createNewFile()) {
                    System.out.println("File created at: " + file2.getAbsolutePath());

                    // Optionally write some default content:
                    try (FileWriter writer = new FileWriter(file2)) {
                        writer.write(dic);
                    }
                } else {
                    System.out.println("Could not create file.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File already exists at: " + file2.getAbsolutePath());
        }
    }
}
