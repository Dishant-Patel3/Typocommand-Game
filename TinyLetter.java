import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TinyLetter extends Letter {
    private TypoCommand typo;
    public TinyLetter(TypoCommand typo) {
        super(typo);
    }

    public TinyLetter(int size, Color color, String font, int speed, TypoCommand typo) {
        super(15, Color.WHITE, "Merriweather", 1, typo);
    }
}