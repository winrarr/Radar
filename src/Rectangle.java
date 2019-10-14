import java.util.*;

public class Rectangle {
    private int lowX;
    private int highX;
    private int lowY;
    private int highY;

    public Rectangle(int lx, int hx, int ly, int hy) {
        lowX = lx;
        highX = hx;
        lowY = ly;
        highY = hy;
    }

    public int getLowX() {
        return lowX;
    }

    public int getHighX() {
        return highX;
    }

    public int getLowY() {
        return lowY;
    }

    public int getHighY() {
        return highY;
    }

    public ArrayList<Point> getPoints() {
        ArrayList<Point> points = new ArrayList<>();
        int closeX, farX, closeY, farY;
        if (Math.abs(lowX) <= Math.abs(highX)) {
            closeX = lowX;
            farX = highX;
        } else {
            closeX = highX;
            farX = lowX;
        }
        if (Math.abs(lowY) <= Math.abs(highY)) {
            closeY = lowY;
            farY = highY;
        } else {
            closeY = highY;
            farY = lowY;
        }
        points.add(new Point(closeX, closeY));
        points.add(new Point(farX, farY));
        points.add(new Point(farX, closeY));
        points.add(new Point(closeX, farY));

        return points;
    }
}
