public class Triangle {
    public static void main(String[] args) {

        printPerimetrTriangle(5.0,7.0,15.0);
        printPerimetrTriangle(6.0,7.0,19.0);
        printPerimetrTriangle(5.0,8.0,20.0);
        System.out.println("hello, world!");

        printAreaTriangle(5.0,7.0,15.0);
        printAreaTriangle(6.0,7.0,15.0);

//        var side_a = 5.0;
//        var side_b = 7.0;
//        var sibe_c = 15.0;
//
//        System.out.println("периметр треугольника со сторонами " + side_a  +";"+ side_b  +";"+ sibe_c +  "=" + (side_a + side_b + sibe_c));
//        System.out.println("полупериметр треугольника со сторонами " + side_a + side_b + sibe_c + "=" + (side_a + side_b + sibe_c) / 2);
//        System.out.println("площадь треугольника со сторонами " + side_a + side_b + sibe_c + "=" + "здесь будет формула Герона");
    }

    private static void printAreaTriangle(double a, double b, double c) {
        System.out.println("площадь ПРЯМОУГОЛЬНОГО треугольника со сторонами " + a +"; " + b +"; "  + c +  " = " + areaTriangle(a, b, c));
    }

    private static double areaTriangle(double a, double b, double c) {
        return (a * b)/2;
    }

    static void printPerimetrTriangle(double a, double b, double c){
        System.out.println("периметр треугольника со сторонами " + a +"; " + b +"; "  + c +  " = " + perimetrTriangle(a, b, c));
    }

    private static double perimetrTriangle(double a, double b, double c) {
        return a + b + c;
    }

}

