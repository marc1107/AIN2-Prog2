package aufgabe5;

public class RandomRectangle {
    public static final int delta = 30;
    public static final double w = 0.09;
    public static final double SCHWELLENWERT = 0.002;

    public static void main(String[] args) {
        StdDraw.show(0);
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setPenRadius(0.002);
        drawSquare(0.5, 0.15, w, 0);
        StdDraw.show(0);
    }

    public static void drawSquare(double ax, double ay, double length, double drehung) {
        // Zufällige Höhe des Rechtecks zwischen breite und Breite * 2
        double height = Math.random() * length + length;
        // Zufälliger Winkel zwischen 10 und 40 Grad
        int winkel = (int) (Math.random() * 45 + 10);

        // Kleine Quadrate grün
        if (length < SCHWELLENWERT)
            StdDraw.setPenColor(StdDraw.GREEN);
        else
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);

        // Eckpunkte berechnen
        double s = length * Math.sin(Math.toRadians(drehung));
        double c = length * Math.cos(Math.toRadians(drehung));
        double r = height * Math.sin(Math.toRadians(drehung));
        double t = height * Math.cos(Math.toRadians(drehung));

        double bx = ax + c;
        double by = ay + s;
        double cx = ax + c - r;
        double cy = ay + s + t;
        double dx = ax - r;
        double dy = ay + t;

        // Untere Linie
        //StdDraw.line(ax, ay, bx, by);

        // Rechte Linie
        StdDraw.line(bx, by, cx, cy);

        // Obere Linie
        //StdDraw.line(cx, cy, dx, dy);

        // Linke Linie
        StdDraw.line(dx, dy, ax, ay);

        // Eckpunkt E berechnen
        double u = length * Math.cos(Math.toRadians(winkel));
        double v = length * Math.sin(Math.toRadians(winkel));

        double ex = dx + u * Math.cos(Math.toRadians(winkel + drehung));
        double ey = dy + u * Math.sin(Math.toRadians(winkel + drehung));

        if (length > SCHWELLENWERT) {
            // Quadrat an Kante u
            drawSquare(dx, dy, u, drehung + winkel);
            // Quadrat an Kante v
            drawSquare(ex, ey, v, drehung + winkel - 90);
        }
    }
}
