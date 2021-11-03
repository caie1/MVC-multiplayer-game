package Midterm.Local_version.Instage;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Counter will implement how the game changes overtime,
// and the method to draw itself.
// Now Counter has a hashmap of states for each player.
class Counter<T extends Avatar> implements State {
    int count = 0;
    HashMap<Player,Integer> states = new HashMap<>();
    ArrayList<Enemy> enemies = new ArrayList<>();
    HashMap<Player,ArrayList<Bullet>> hashBullets = new HashMap<>();

    public void teh() {
        for(int i=0; i<enemies.size(); i++){
            Enemy e = enemies.get(i);
            e.timePast();
            if (e.getY()>600){
                enemies.remove(e);
                enemies.add(new Enemy());
            }
        }
        for (ArrayList<Bullet> bullets : this.hashBullets.values()){
            for(int i=0; i<bullets.size();i++){
                Bullet b = bullets.get(i);
                b.timePast();
                if (b.getY()<0){
                    bullets.remove(b);
                }
            }
        }
        for(int i=0;i< enemies.size();i++){
            for (Player p : this.hashBullets.keySet()){
                ArrayList<Bullet> bullets = this.hashBullets.get(p);
                for(int j=0; j<bullets.size();j++){
                    if (isHit(enemies.get(i),bullets.get(j))){
                        enemies.remove(i);
                        enemies.add(new Enemy());
                        bullets.remove(j);
                        states.put(p, states.get(p)+10);
                    }
                }
            }
        }
        this.count += 1;
    }
    public Counter(){
        for(int i=0; i<25; i++){
            enemies.add(new Enemy());
        }
    }
    public void update(Player player) {
        if (this.states.get(player)==null){
            this.states.put(player,0);
        }
        hashBullets.put(player,player.bullets);
    }
    public Boolean isHit(Enemy e, Bullet b){
        // Enemy area
        Rectangle rect1 = new Rectangle(e.getX(),e.getY(),e.getWidth(), e.getHeight());
        // Bullet area
        Rectangle rect2 = new Rectangle(b.getX(),b.getY(),b.getWidth(), b.getHeight());
        return rect1.contains(rect2);
    }
    public String toString() {
        return this.count + "";
    }
    public void draw(Graphics g) {
        g.setColor(Color.getHSBColor(0.0F, 0.5F, 0.8F));
        Iterator iterator = states.entrySet().iterator();
        for (int i=0; i<states.size(); i++){
            Map.Entry pair = (Map.Entry) iterator.next();
            g.drawString(pair.getKey()+" scores: "+pair.getValue(),5, 17*(i+2));
        }

        g.drawString("World time: " + this.count + "", 5, 15);
        for (Enemy e : this.enemies){
            e.draw(g);
        }
        for (Player p : states.keySet()){
            p.circle.draw(g);
            for(Bullet b : p.bullets){
                b.draw(g);
            }
        }
    }
}
