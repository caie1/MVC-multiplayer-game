package Midterm.Local_version.Instage;

import javax.swing.JComponent;
import java.awt.Graphics;

// View will have a reference to a controller/player.
// View is responsible to painting every state,
// which needs it to call the function draw in state.
// The frame is in the controller thou.
public class View extends JComponent {
    Controller controller;
    State state;
    public void setController(Controller controller) {
        this.controller = controller;
    }
    public void set(State state) {
        this.state = state;
    }
    public void paintComponent(Graphics g) {
        if (this.state != null)
            this.state.draw(g);
    }
}
