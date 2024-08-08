import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class Letter {
    private int y;
    private int x;
    private double speed;
    private int size;
    private String font, letter;
    private Color color;
    private int random;
    private TypoCommand typo;
    private String[] let = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    public Letter(TypoCommand typo) {
        random = (int) ((Math.random()*26));
        letter = let[random];
        x = (int) ((Math.random()*975) + 1);
        y = 0;
        this.typo = typo;
    }

    public Letter(int size, Color color, String font, int speed, TypoCommand typo) {
        this.font = font;
        this.color = color;
        this.size = size;
        this.speed = speed;
        random = (int) ((Math.random()*26));
        letter = let[random];
        x = (int) ((Math.random()*960) + 5);
        y = 0;
        this.typo = typo;
    }

    public void paint(Graphics g) {
        g.setFont(new Font(font, Font.BOLD, size));
        g.setColor(color);
        g.drawString(letter, x, y);
    }

    public void move() {
        y += speed;
    }

    public boolean collision() {
        return typo.getCannon().shapePolygon().intersects(getBounds());
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 5, 5);
    }

    public String getAlpha() {
        return letter;
    }

    public int getLX() {
        return x;
    }

    public int getLY() {
        return y;
    }
}