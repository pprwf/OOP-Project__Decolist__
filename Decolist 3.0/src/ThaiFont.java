import java.io.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThaiFont {
    public Font thFont, thBold, thItalic, thBoldItalic;
    public ThaiFont () {
        try {
            thFont = Font.createFont(Font.TRUETYPE_FONT, new File("resource/font/THSarabunNew.ttf"));
            thBold = Font.createFont(Font.TRUETYPE_FONT, new File("resource/font/THSarabunNew Bold.ttf"));
            thItalic = Font.createFont(Font.TRUETYPE_FONT, new File("resource/font/THSarabunNew Italic.ttf"));
            thBoldItalic = Font.createFont(Font.TRUETYPE_FONT, new File("resource/font/THSarabunNew BoldItalic.ttf"));
        } catch (FontFormatException ex) {
            Logger.getLogger(ThaiFont.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ThaiFont.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Font getThFont() {
        return thFont;
    }

    public Font getThBold() {
        return thBold;
    }

    public Font getThItalic() {
        return thItalic;
    }

    public Font getThBoldItalic() {
        return thBoldItalic;
    }
}
