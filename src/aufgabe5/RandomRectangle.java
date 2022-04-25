package aufgabe5;

public class RandomRectangle {
    public static final int delta = 30;
    public static final double w = 0.09;
    public static final double SCHWELLENWERT = 0.002;

    public static void main(String[] args) {
        Point A = new Point(0.5, 0.15);

        StdDraw.show(0);

        StdDraw.setCanvasSize(800, 800);
        StdDraw.setPenRadius(0.002);

        drawSquare(A, w, 0);

        StdDraw.show(0);
    }

    public static void drawSquare(Point A, double width, double drehung) {
        // Zufällige Höhe des Rechtecks zwischen breite und Breite * 2
        double height = Math.random() * width + width;
        // Zufälliger Winkel zwischen 10 und 40 Grad
        int winkel = (int) (Math.random() * 45 + 10);

        // Kleine Quadrate grün
        if (width < SCHWELLENWERT)
            StdDraw.setPenColor(StdDraw.GREEN);
        else
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);

        // Eckpunkte berechnen
        double s = width * Math.sin(Math.toRadians(drehung));
        double c = width * Math.cos(Math.toRadians(drehung));
        double r = height * Math.sin(Math.toRadians(drehung));
        double t = height * Math.cos(Math.toRadians(drehung));

        Point B = new Point(A.x + c, A.y + s);
        Point C = new Point(A.x + c -r, A.y + s + t);
        Point D = new Point(A.x - r, A.y + t);

        // Untere Linie
        //StdDraw.line(A.x, A.y, B.x, B.y);

        // Rechte Linie
        StdDraw.line(B.x, B.y, C.x, C.y);

        // Obere Linie
        //StdDraw.line(C.x, C.y, D.x, D.y);

        // Linke Linie
        StdDraw.line(D.x, D.y, A.x, A.y);

        // Eckpunkt E berechnen
        double u = width * Math.cos(Math.toRadians(winkel));
        double v = width * Math.sin(Math.toRadians(winkel));

        Point E = new Point(D.x + u * Math.cos(Math.toRadians(winkel + drehung)),
                D.y + u * Math.sin(Math.toRadians(winkel + drehung)));

        if (width > SCHWELLENWERT) {
            // Quadrat an Kante u
            drawSquare(D, u, drehung + winkel);
            // Quadrat an Kante v
            drawSquare(E, v, drehung + winkel - 90);
        }
    }
}
