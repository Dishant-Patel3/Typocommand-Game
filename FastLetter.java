import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FastLetter extends Letter {
    private TypoCommand typo;
    public FastLetter(TypoCommand typo) {
        super(typo);
    }

    public FastLetter(int size, Color color, String font, int speed, TypoCommand typo) {
        super(40, Color.RED, "Monospaced", 5, typo);
    }
}