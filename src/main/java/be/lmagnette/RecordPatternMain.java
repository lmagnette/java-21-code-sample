package be.lmagnette;

record Point(int x, int y) { }
enum Color {RED, GREEN, BLUE}
record ColoredPoint(Point p, Color c) { }
record Rectangle(ColoredPoint upperLeft, ColoredPoint lowerRight) { }
record Pair(Object x, Object y) {}

public class RecordPatternMain {

    public static void main(String[] args) {
        System.out.println("---- Record Pattern START ----");
        var rectangle = new Rectangle(
                new ColoredPoint(new Point(1, 2), Color.RED),
                new ColoredPoint(new Point(3, 4), Color.BLUE)
        );
        printUpperLeftColoredPoint(rectangle);
        printColorOfUpperLeftPoint(rectangle);
        printXCoordOfUpperLeftPointWithPatterns(rectangle);
        failingMatching(rectangle);
        System.out.println("---- Record Pattern STOP ----");
    }

    static void printUpperLeftColoredPoint(Object r) {
        if (r instanceof Rectangle(ColoredPoint ul, ColoredPoint lr)) {
            System.out.println(ul.c());
        }
    }

    static void printColorOfUpperLeftPoint(Object r) {
        if (r instanceof Rectangle(
                ColoredPoint(Point p, Color c),
                ColoredPoint lr
        )) {
            System.out.println(c);
        }
    }
    static void printXCoordOfUpperLeftPointWithPatterns(Rectangle r) {
        if (r instanceof Rectangle(ColoredPoint(Point(var x, var y), var c),
                                   var lr)) {
            System.out.println("Upper-left corner: " + x);
        }
    }

    static void failingMatching(Object o){
        Pair p = new Pair(42, 42);

        if (p instanceof Pair(String s, String t)) {
            System.out.println(s + ", " + t);
        } else {
            System.out.println("Not a pair of strings");
        }
    }
}
