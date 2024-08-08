import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Result extends JPanel {
    private TypoCommand typo;

    public Result(TypoCommand typo) {
        setSize(610, 100);
        setLocation(205, 250);
        setLayout(null);
        this.typo = typo;
    }
    public void paint(Graphics g) {
        super.paint(g);
        if(typo.total() == 24 || typo.Over() == 1) {
            setBackground(Color.WHITE);
            setBorder(BorderFactory.createLineBorder((new Color(51,108,132)), 5));
            g.setFont(new Font("Oswald", Font.BOLD, 40));
            g.drawString("GAME OVER, YOU TOOK AN L", 15, 65);
        } else if(typo.Over() == 2) {
            setBackground(new Color(21, 198, 242));
            setBorder(BorderFactory.createLineBorder((new Color(214,233,43)), 5));
            g.setFont(new Font("Oswald", Font.BOLD, 40));
            g.drawString("#1 VICTORY ROYALE", 95, 65);
        }
    }
}
