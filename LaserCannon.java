import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LaserCannon extends JPanel{
    private int x, y;
    private TypoCommand typo;
    public LaserCannon(TypoCommand typo) {
        x = 490;
        y = 520;
        this.typo = typo;
    }

    public void paint(Graphics g) {
        if(typo.Over() == 1) {
            g.setColor(new Color(51,108,132));
        } else {
            g.setColor(new Color(51,108,132));
            g.drawPolygon(new int[] {410, x, 570}, new int[] {700, y, 700}, 3);
            g.fillPolygon(new int[] {410, x, 570}, new int[] {700, y, 700}, 3);
        }
        
    }
    public Polygon shapePolygon() {
        return new Polygon(new int[] {410, 490, 570}, new int[] {700, 520, 700}, 3);
    }

    public int getCX() {
        return x;
    }

    public int getCY() {
        return y;
    }
}