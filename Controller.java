package Midterm.Local_version.Instage;

import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

// Controller coordinates view and model,
// and it listen to the keyboard and actions.
// Each controller is also an observer/player.
public class Controller implements KeyListener {
    Model world;
    View view;
    JFrame frame;

    public Controller(Model world, View view) {
        this.world = world;
        this.world.register(this);
        frame = new JFrame();
        frame.setSize(new Dimension(400, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        this.view = view;
        this.view.setController(this);
        frame.add(this.view);
        frame.addKeyListener(this);
        frame.setBackground(Color.PINK);
        frame.setVisible(true);
    }

    public void keyPressed(KeyEvent e) {
        this.keh(e);
    }

    public void keh(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void setTitle(String title) {
        this.frame.setTitle(title);
    }

    public void teh(State state) {
    }
}