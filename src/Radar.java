import java.util.ArrayList;

public class Radar {
    private ArrayList<Rectangle> rects = new ArrayList<>();
    private double radius;

    public Radar(double radius) {
        this.radius = radius;
    }

    public void addRectangle(Rectangle rect) {
        rects.add(rect);
    }

    public void expandRadius(float amount) {
        radius += amount;
    }

    public double getRadius() {
        return radius;
    }

    public void printIntersects() {
        for (Rectangle rect : rects) {
            ArrayList<Point> points = rect.getPoints();
            if (dist(points.get(0)) <= radius && dist(points.get(1)) >= radius) {
                double angle1 = Math.atan2(points.get(2).y, points.get(2).x);
                double angle2 = Math.atan2(points.get(3).y, points.get(3).x);
                double firstAngle, lastAngle;
                if (angle1 <= angle2) {
                    firstAngle = angle1;
                    lastAngle = angle2;
                } else {
                    firstAngle = angle2;
                    lastAngle = angle1;
                }
                for (double i = firstAngle; i < lastAngle; i += 0.03) {
                    double x = radius * Math.cos(i);
                    double y = radius * Math.sin(i);
                    if (x >= rect.getLowX() && x <= rect.getHighX() && y >= rect.getLowY() && y <= rect.getHighY()) {
                        System.out.println("x: " + x + "     y: " + y);
                    }
                }
            }
        }
    }

    private double dist(Point target) {
        return Math.sqrt(target.x * target.x + target.y * target.y);
    }
}
