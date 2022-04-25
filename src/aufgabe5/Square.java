package aufgabe5;

public class Square {
    public static final int delta = 30;
    public static final double w = 0.16;
    public static final double SCHWELLENWERT = 0.002;

    public static void main(String[] args) {
        StdDraw.show(0);
        StdDraw.setPenRadius(0.002);
        drawSquare(0.6, 0.2, w, 0);
        StdDraw.show(0);
    }

    public static void drawSquare(double ax, double ay, double length, double drehung) {
        // Kleine Quadrate grün
        if (length < SCHWELLENWERT)
            StdDraw.setPenColor(StdDraw.GREEN);
        else
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);

        // Eckpunkte berechnen
        double s = length * Math.sin(Math.toRadians(drehung));
        double c = length * Math.cos(Math.toRadians(drehung));

        double bx = ax + c;
        double by = ay + s;
        double cx = ax + c - s;
        double cy = ay + s + c;
        double dx = ax - s;
        double dy = ay + c;

        // Untere Linie
        //StdDraw.line(ax, ay, bx, by);

        // Rechte Linie
        StdDraw.line(bx, by, cx, cy);

        // Obere Linie
        //StdDraw.line(cx, cy, dx, dy);

        // Linke Linie
        StdDraw.line(dx, dy, ax, ay);

        // Eckpunkt E berechnen
        double u = length * Math.cos(Math.toRadians(delta));
        double v = length * Math.sin(Math.toRadians(delta));

        double ex = dx + u * Math.cos(Math.toRadians(delta + drehung));
        double ey = dy + u * Math.sin(Math.toRadians(delta + drehung));

        if (length > SCHWELLENWERT) {
            // Quadrat an Kante u
            drawSquare(dx, dy, u, drehung + delta);
            // Quadrat an Kante v
            drawSquare(ex, ey, v, drehung + delta - 90);
        }
    }
}
