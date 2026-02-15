package ru.stqa.geometry.figures;

import static java.lang.Math.sqrt;

public record Triangle (double a, double b, double c){


    public static void printAreaTriangle(Triangle s) {
        String text = String.format("площадь треугольника со сторонами %f и %f и %f =%f", s.a, s.b, s.c, s.area());
        System.out.println(text);
    }

      public double area() {
        return sqrt(((this.a + this.b + this.c) / 2) * (((this.a + this.b + this.c) / 2) - this.a) * (((this.a + this.b + this.c) / 2) - this.b) * (((this.a + this.b + this.c) / 2) - this.c));
    }

    public double perimetr() {
        return this.a + this.b + this.c;
    }
}

