class Sort {
    public static void sortShapes(Shape[] array,
                                  List<Shape> shapes,
                                  List<Polygon> polygons,
                                  List<Square> squares,
                                  List<Circle> circles) {
       for (Shape s : array) {
           if (s.getClass() == Polygon.class) {
               polygons.add((Polygon)s);
           } else if (s.getClass() == Square.class) {
               squares.add((Square)s);
           } else if (s.getClass() == Circle.class) {
               circles.add((Circle)s);
           } else if (s.getClass() == Shape.class) {
               shapes.add(s);
           }
       }
    }
}

//Don't change classes below
class Shape { }
class Polygon extends Shape { }
class Square extends Polygon { }
class Circle extends Shape { }