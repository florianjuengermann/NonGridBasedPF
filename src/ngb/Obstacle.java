package ngb;

import java.awt.*;
import java.util.Scanner;

public class Obstacle {

    public final float x, y, width, height;
    private int xRound, yRound, wRound, hRound;

    public Obstacle(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    public static Obstacle createFromFile(String line) {
        Scanner sc = new Scanner(line);
        float x, y, width, height;
        x = Float.parseFloat(sc.next());
        y = Float.parseFloat(sc.next());
        width = Float.parseFloat(sc.next());
        height = Float.parseFloat(sc.next());
        System.out.println("Obstacle erstellt: " + x + ", " + y + " | " + width + ", " + height);
        sc.close();
        return new Obstacle(x, y, width, height);
    }

    public void draw(Graphics g, float scale) {
        g.setColor(Color.BLACK);
        g.fillRect(xRound, yRound, wRound, hRound);
    }

    public void updateScale(float scale) {
        xRound = Math.round(x * scale);
        yRound = Math.round(y * scale);
        //                      actSize Right Coor| drawed left Coor
        wRound = Math.round((x + width) * scale) - xRound;
        hRound = Math.round((y + height) * scale) - yRound;
    }

}
