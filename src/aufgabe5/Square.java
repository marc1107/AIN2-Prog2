package aufgabe5;

public class Square {
    public static final int delta = 30;
    public static final double w = 0.16;
    public static final double SCHWELLENWERT = 0.002;

    public static void main(String[] args) {
        Point A = new Point(0.6, 0.2);

        StdDraw.show(0);

        StdDraw.setCanvasSize(800, 800);
        StdDraw.setPenRadius(0.002);

        drawSquare(A, w, 0);

        StdDraw.show(0);
    }

    public static void drawSquare(Point A, double length, double drehung) {
        // Kleine Quadrate grün
        if (length < SCHWELLENWERT)
            StdDraw.setPenColor(StdDraw.GREEN);
        else
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);

        // Eckpunkte berechnen
        double s = length * Math.sin(Math.toRadians(drehung));
        double c = length * Math.cos(Math.toRadians(drehung));

        Point B = new Point(A.x + c, A.y + s);
        Point C = new Point(A.x + c - s, A.y + s + c);
        Point D = new Point(A.x - s, A.y + c);

        // Untere Linie
        //StdDraw.line(A.x, A.y, B.x, B.y);

        // Rechte Linie
        StdDraw.line(B.x, B.y, C.x, C.y);

        // Obere Linie
        //StdDraw.line(C.x, C.y, D.x, D.y);

        // Linke Linie
        StdDraw.line(D.x, D.y, A.x, A.y);

        // Eckpunkt E berechnen
        double u = length * Math.cos(Math.toRadians(delta));
        double v = length * Math.sin(Math.toRadians(delta));

        Point E = new Point(D.x + u * Math.cos(Math.toRadians(delta + drehung)),
                D.y + u * Math.sin(Math.toRadians(delta + drehung)));

        if (length > SCHWELLENWERT) {
            // Quadrat an Kante u
            drawSquare(D, u, drehung + delta);
            // Quadrat an Kante v
            drawSquare(E, v, drehung + delta - 90);
        }
    }
}
