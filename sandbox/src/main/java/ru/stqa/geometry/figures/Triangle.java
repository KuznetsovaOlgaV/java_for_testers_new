package ru.stqa.geometry.figures;

public class Triangle {
    /// //  Треугольник площадь пока ПРЯМОУГОЛЬНОГО
    public static void printAreaTriangle(double a, double b, double c) {
        var text = String.format("площадь ПРЯМОУГОЛЬНОГО треугольника со сторонами %f и %f и %f =%f", a, b, c, areaTriangle(a, b, c));
        System.out.println(text);
    }
    /// //  Треугольник площадь пока ПРЯМОУГОЛЬНОГО
    private static double areaTriangle(double a, double b, double c) {
        return (a * b)/2;
    }

    public static void printPerimetrTriangle(double a, double b, double c){
       var text = String.format("периметр треугольника со сторонами %f и %f и %f =%f", a, b, c, perimetrTriangle(a, b, c));
        System.out.println(text);
    }

    private static double perimetrTriangle(double a, double b, double c) {
        return a + b + c;
    }
}

