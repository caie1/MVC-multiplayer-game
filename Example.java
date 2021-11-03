package Midterm.Local_version.Instage;

import java.awt.*;

class Example {
    public static void main(String[] args) {
        Model world = new Game(100, new Counter<Circle>());
        Controller p1 = new Player(Color.getHSBColor(0.18F,0.9F,0.4f), "Larry", world, new Screen());
        Controller p2 = new Player(Color.getHSBColor(0.1F,0.9F, 0.9F), "Leslie", world, new Screen());
        Controller p3 = new Player(Color.ORANGE, "Laura", world, new Screen());
        Controller p4 = new Player(Color.PINK, "Lucy", world, new Screen());
        world.start();
    }
}
