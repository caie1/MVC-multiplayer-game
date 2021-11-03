package Midterm.Local_version.Instage;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.util.ArrayList;

// Model which is a game keeps a list of Controller (player).
// Just like Big Bang, it has a beginning(start method).
public class Model implements ActionListener {
    // a reference to state which is a interface which has a time event handler and draw function.
    State state;
    Timer timer;
    ArrayList<Controller> clients = new ArrayList<>();
    public void register(Controller client) {
        this.clients.add(client);
    }
    public Model(int delay, State state) {
        this.state = state;
        this.timer = new Timer(delay, this);
    }
    public void start() {
        this.timer.start();
    }
    public void actionPerformed(ActionEvent e) {
        this.state.teh();
    }
}