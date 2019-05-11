

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BaseScreen {

    private JFrame window;
    private JPanel panel;
    private JLabel dock;

    public BaseScreen() {
        window = new JFrame();
        panel = new JPanel();
        dock = new JLabel();
        initialize();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BaseScreen();
            }
        });
    }

    private void initialize() {
        window.setSize(800, 600);
        window.setContentPane(panel);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        dock = new JLabel();
        dock.setText("Click me to generate a random color and number!");
        dock.setOpaque(true);
        dock.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                float r = (float) Math.random();
                float g = (float) Math.random();
                float b = (float) Math.random();
                dock.setBackground(new Color(r, g, b));
                dock.setText("R: " + (int) r * 255 + " G: " + (int) g * 255 + " B:" + (int) b * 255);
            }
        });
        dock.setCursor(new Cursor(Cursor.HAND_CURSOR));
        dock.setHorizontalAlignment(SwingConstants.CENTER);
        dock.setBounds(0, 0, 800, 600);
        panel.add(dock);
    }
}
