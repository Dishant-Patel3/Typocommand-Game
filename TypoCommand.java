import java.awt.Color;
import java.awt.Font;
import java.awt.Stroke;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class TypoCommand extends JPanel{
    private LaserCannon cannon;
    private static City city1, city2, city3, city4, city5, city6;
    private static int k = 0;
    private static int random, total, over, xx, yy, xxx, yyy;
    private static Boolean check;
    private String letters;
    private static ArrayList<Letter> alpha;

    public static void main(String[] args) throws InterruptedException {
        int fTime = 0;
        JFrame frame = new JFrame();
        TypoCommand frame1 = new TypoCommand();
        Result result = new Result(frame1);
        frame.setSize(1000, 700);
        frame.setTitle("TypoCommand - Patel");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.add(frame1);
        frame.add(result);
        frame.setVisible(true);

        // game loops
        while (check) {
            random = (int) (Math.random() * 4 + 1);
            if(k == 20) {
                if(random == 1) {
                    FastLetter fast = new FastLetter(40, Color.RED, "Monospaced", 5, frame1);
                    alpha.add(fast);    
                } else if(random == 2) {
                    ShockLetter shock = new ShockLetter(21, new Color(Color.HSBtoRGB((float) Math.random(), (float) Math.random(), 0.5F + ((float) Math.random())/2F)), "Koulen", 3, frame1);
                    alpha.add(shock);
                } else if(random == 3) {
                    TinyLetter tiny = new TinyLetter(15, Color.WHITE, "Merriweather", 1, frame1);
                    alpha.add(tiny);
                } else if(random == 4) {
                    Letter normal = new Letter(30, Color.GREEN, "Arial", 2, frame1);
                    alpha.add(normal);
                }
                k=0;
            }
            for(Letter alpha1 : alpha) {
                alpha1.move();
            }
            if(fTime == 3500) {
                over = 2;
                check = false;
            }
            Thread.sleep(10);
            frame1.repaint();
            k++;
            fTime++;
        }
        result.repaint();
    }

    public TypoCommand() {
        setBounds(0, 0, 1000, 700);
        setBackground(Color.BLACK);
        alpha = new ArrayList<Letter>();
        cannon = new LaserCannon(this);
        city1 = new City(-20, 540, 200, 150, this);
        city2 = new City(110, 540, 200, 150, this);
        city3 = new City(240, 540, 200, 150, this);
        city4 = new City(535, 540, 200, 150, this);
        city5 = new City(665, 540, 200, 150, this);
        city6 = new City(795, 540, 200, 150, this);
        check = true;
        random = 0;
        xx = 0;
        yy = 0;
        xxx = 0;
        yyy = 0;
        over = 0;
        addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }
            public void keyPressed(KeyEvent e) {
                letters = Character.toString(e.getKeyChar());
            }
            public void keyReleased(KeyEvent e) {
                letters = "";
            }
        });
        setFocusable(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        for(int x = 0; x < alpha.size(); x++) {
            alpha.get(x).paint(g);
            xx = alpha.get(x).getLX() - 13;
            yy = alpha.get(x).getLY() - 38;
            xxx = alpha.get(x).getLX();
            yyy = alpha.get(x).getLY();
            total = city1.getLive() + city2.getLive() + city3.getLive() + city4.getLive() + city5.getLive() + city6.getLive();
            g.setColor(new Color(Color.HSBtoRGB((float) Math.random(), (float) Math.random(), 0.5F + ((float) Math.random())/2F)));
            if(alpha.get(x).getLY() <= 539 && alpha.get(x).getLY() >= 15) {
                if(alpha.get(x).getAlpha().equals(letters)) {
                    g.drawLine(cannon.getCX(), cannon.getCY(), alpha.get(x).getLX(), alpha.get(x).getLY());
                    g.drawOval(xx, yy, 45, 45);
                    g.fillOval(xx, yy, 45, 45);
                    alpha.remove(x);
                }
            } else if(yyy == 540) {
                if(xxx > 10 && xxx < 130 && city1.getLive() < 4) {
                    city1.Lives();
                    alpha.remove(x);
                } else if(xxx > 130 && xxx < 270 && city2.getLive() < 4) {
                    city2.Lives();
                    alpha.remove(x);
                } else if(xxx > 270 && xxx < 400 && city3.getLive() < 4) {
                    city3.Lives();
                    alpha.remove(x);
                } else if(xxx > 575 && xxx < 695 && city4.getLive() < 4) {
                    city4.Lives();
                    alpha.remove(x);
                } else if(xxx > 695 && xxx < 815 && city5.getLive() < 4) {
                    city5.Lives();
                    alpha.remove(x);
                } else if(xxx > 815 && xxx < 970 && city6.getLive() < 4) {
                    city6.Lives();
                    alpha.remove(x);
                } 
            } else if (alpha.get(x).collision()) {
                over = 1;
                alpha.remove(x);
                check = false;
            } else if(total == 24) {
                alpha.remove(x);
                check = false;
            }
        }
        cannon.paint(g);
        city1.paint(g);
        city2.paint(g);
        city3.paint(g);
        city4.paint(g);
        city5.paint(g);
        city6.paint(g);
    }

    public ArrayList<Letter> getLetter() {
        return alpha;
    }

    public LaserCannon getCannon() {
        return cannon;
    }

    public int getTX() {
        return xxx;
    }

    public int getTY() {
        return yyy;
    }

    public int Over() {
        return over;
    }

    public int total() {
        return total;
    }
}