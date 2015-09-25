package ziegler.projectile;

import java.text.DecimalFormat;

public class Projectile {
    private double velocity;
    private double time;
    private double radians;

    private DecimalFormat formatter = new DecimalFormat("#,##0.##");

    public Projectile(double angle, double velocity, double time) {
        this.velocity = velocity;
        this.time = time;
        radians = Math.toRadians(angle);
    }

    public String getX() {
        return formatter.format(Math.sin(radians) * velocity * time);
    }

    public String getY() {
        return formatter.format(Math.cos(radians) * velocity * time - (.5 * 9.8 * time * time));
    }
}
