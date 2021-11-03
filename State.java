package Midterm.Local_version.Instage;

import java.awt.Graphics;

// This is an interface include draw method, to draw itself, and time event handler.
interface State<T> {
    public void teh();
    public void draw(Graphics g);
}
