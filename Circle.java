package Midterm.Local_version.Instage;


import java.awt.*;
class Circle implements Avatar {
    String name;
    int x, y, radius;
    Color c;
    public Circle(Color c, String name, int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.name = name;
        this.c = c;
    }
    public void draw(Graphics g) {
        g.setColor(c);
        g.drawOval(this.x - this.radius, this.y - this.radius, this.radius * 2, this.radius * 2);
        g.fillOval(this.x - this.radius, this.y - this.radius, this.radius * 2, this.radius * 2);
        g.setColor(Color.BLACK);
        g.drawString(this.name, this.x - 18, this.y + 25);
    }
}
