import java.io.File;

public class Hello {
    public static void main(String[] args) {
        System.out.println("hello, world!");

//        System.out.println(2+2);
//        System.out.println(2*2);
//        System.out.println(2-2);
//        System.out.println(2/2);
//        System.out.println((2+2)*2);
//
//        System.out.println("hello, "+"world");
//        System.out.println("2 + 2 = " + 4);
//        System.out.println("2 + 2 = " + 2 + 2);
//        System.out.println("2 + 2 = " + (2 + 2));

        var configFile = new File("build.gradle");
        System.out.println(configFile.getAbsolutePath());
        System.out.println(configFile.exists());



    }
}
