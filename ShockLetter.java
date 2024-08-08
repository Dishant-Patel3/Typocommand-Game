import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShockLetter extends Letter {
    private boolean on = true;
    private TypoCommand typo;
    public ShockLetter(TypoCommand typo) {
        super(typo);
    }

    public ShockLetter(int size, Color color, String font, int speed, TypoCommand typo) {
        super(21, new Color(Color.HSBtoRGB((float) Math.random(), (float) Math.random(), 0.5F + ((float) Math.random())/2F)), "Koulen", 3, typo);
        Timer timer = new Timer(70, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                on = !on;
              }
            });
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.start();
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        if (!on) {
          g2d.setComposite(AlphaComposite.SrcOver.derive(0f));
        } else {
          g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
        }
        super.paint(g2d);
        g2d.dispose();
      }
    
}