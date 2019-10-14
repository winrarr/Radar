public class Driver {

    public static void main(String[] args) {
        Radar radar = new Radar(16);
        radar.addRectangle(new Rectangle(10, 15, 5, 10));
        radar.printIntersects();
    }
}
