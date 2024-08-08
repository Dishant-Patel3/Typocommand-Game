import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class City extends JPanel {
    private Image img;
    private TypoCommand typo;
    private int x, y, w, h, live;
    public City(int x, int y, int w, int h, TypoCommand typo) {
        img = getToolkit().getImage("City1.png");
        this.typo = typo;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void Lives() {
        live = live + 1;
    }

    public int getLive() {
        return live;
    }

    public void paint(Graphics g) {
        g.setColor(new Color(51,108,132));
        if(live == 0) {
            g.drawImage(img, x, y, w, h, null);
            g.drawRect(x+79, y+31, 15, 15);
            g.fillRect(x+79, y+31, 15, 15);
            g.drawRect(x+112, y+31, 15, 15);
            g.fillRect(x+112, y+31, 15, 15);
            g.drawRect(x+79, y+56, 15, 15);
            g.fillRect(x+79, y+56, 15, 15);
            g.drawRect(x+112, y+56, 15, 15);
            g.fillRect(x+112, y+56, 15, 15);
        } else if(live == 1) {
            g.drawImage(img, x, y, w, h, null);
            g.drawRect(x+112, y+31, 15, 15);
            g.fillRect(x+112, y+31, 15, 15);
            g.drawRect(x+79, y+56, 15, 15);
            g.fillRect(x+79, y+56, 15, 15);
            g.drawRect(x+112, y+56, 15, 15);
            g.fillRect(x+112, y+56, 15, 15);
        } else if(live == 2) {
            g.drawImage(img, x, y, w, h, null);
            g.drawRect(x+79, y+56, 15, 15);
            g.fillRect(x+79, y+56, 15, 15);
            g.drawRect(x+112, y+56, 15, 15);
            g.fillRect(x+112, y+56, 15, 15);
        } else if(live == 3) {
            g.drawImage(img, x, y, w, h, null);
            g.drawRect(x+112, y+56, 15, 15);
            g.fillRect(x+112, y+56, 15, 15);
        }
    }
}