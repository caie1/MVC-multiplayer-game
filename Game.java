package Midterm.Local_version.Instage;

import java.awt.event.*;

// Game is a Model.
// In original Model we assume there are one state needed to begin.
// Since it is a multiplayer game, each player should begin the game at the same time.
// That's why we rewrite actionPerformed.
public class Game extends Model {
    public Game(int delay, State state) {
        super(delay, state);
    }
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        for (Controller c : this.clients) {
            c.teh(this.state);
        }
    }
}