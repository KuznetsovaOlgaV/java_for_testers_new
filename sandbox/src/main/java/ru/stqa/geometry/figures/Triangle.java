package ru.stqa.geometry.figures;

public class Triangle {
    /// //  Треугольник площадь пока ПРЯМОУГОЛЬНОГО
    public static void printAreaTriangle(double a, double b, double c) {
        System.out.println("площадь ПРЯМОУГОЛЬНОГО треугольника со сторонами " + a +"; " + b +"; "  + c +  " = " + areaTriangle(a, b, c));
    }
    /// //  Треугольник площадь пока ПРЯМОУГОЛЬНОГО
    private static double areaTriangle(double a, double b, double c) {
        return (a * b)/2;
    }

    public static void printPerimetrTriangle(double a, double b, double c){
        System.out.println("периметр треугольника со сторонами " + a +"; " + b +"; "  + c +  " = " + perimetrTriangle(a, b, c));
    }

    private static double perimetrTriangle(double a, double b, double c) {
        return a + b + c;
    }
}

