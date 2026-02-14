package ru.stqa.geometry.figures;

import static java.lang.Math.sqrt;

public class Triangle {

    public static void printAreaTriangle(double a, double b, double c) {
        var text = String.format("площадь треугольника со сторонами %f и %f и %f =%f", a, b, c, areaTriangle(a, b, c));
        System.out.println(text);
    }

    private static double areaTriangle(double a, double b, double c) {
        return sqrt(((a + b + c) / 2) * (((a + b + c) / 2) - a) * (((a + b + c) / 2) - b) * (((a + b + c) / 2) - c));
    }

    public static void printPerimetrTriangle(double a, double b, double c){
       var text = String.format("периметр треугольника со сторонами %f и %f и %f =%f", a, b, c, perimetrTriangle(a, b, c));
        System.out.println(text);
    }

    private static double perimetrTriangle(double a, double b, double c) {
        return a + b + c;
    }
}

