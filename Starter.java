import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Starter {

    static JFrame frame;
    static JComponent_ draw;

    static Random random = new Random(42);

    static {
        frame = new JFrame("Recursion visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Constants.WIDTH, Constants.HEIGHT);

        int i = 0x2b2b2b;

        frame.getContentPane().setBackground(new Color((i >> 16) & 0xFF, (i >> 8) & 0xFF, i & 0xFF));
        draw = new JComponent_();
        draw.setForeground(Color.red);
        frame.getContentPane().add(draw);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        int centerX = Constants.WIDTH / 2;
        int centerY = Constants.WIDTH / 2;
        int size = 200;
        draw(centerX, centerY, size, 1, 3);
    }


    static void draw(int x, int y, int height, int depth, int limit) {
        delay(20);
        draw.addLast(x, y, height);

        if (depth <= limit) {
            draw(x - height / 2, y - height / 2, height / 2, depth + 1, limit);
            draw(x - height / 2, y + height / 2, height / 2, depth + 1, limit);
            draw(x + height / 2, y - height / 2, height / 2, depth + 1, limit);
            draw(x + height / 2, y + height / 2, height / 2, depth + 1, limit);
        }
        delay(20);
        draw.removeLast();

    }


    static class JComponent_ extends JComponent {

        LinkedList<Square> list = new LinkedList<>();

        public void addLast(int x, int y, int height) {
            list.addLast(new Square(x, y, height));
            repaint();
        }

        public void removeLast() {
            list.removeLast();
            repaint();
        }



        @Override
        public void paint(Graphics g) {
            for (Square s : list) {
                int x = s.x;
                int y = s.y;
                int height = s.height;

                if (s.b) {
                    g.drawRect(x - height / 2, y - height / 2, height, height);
                } else {
                    g.drawOval(x - height / 2, y - height / 2, height, height);
                }
            }
        }

    }

    static class Square {
        int x;
        int y;
        int height;
        boolean b = random.nextBoolean();

        public Square(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }

    static void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignore) {

        }
    }

}
/**
 * TODO Example of recursion.
 * TODO Fibonachi
 * TODO Fractal with squares
 * TODO Fractal with rotated squares
 */
