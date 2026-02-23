package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculateArea() {
        var s = new Triangle(5.0, 7.0, 11.0);
        double result = s.area();
        Assertions.assertEquals(12.968712349342937, result);

    }

    @Test
    void canCalculatePerimetr() {
        Assertions.assertEquals(23, new Triangle(5.0, 7.0, 11.0).perimetr());
    }

    @Test
    void cannotCreateTriangleWithNegativeSideA() {
        try {
            new Triangle(-5.0, 7.0, 11.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            // OK
        }
    }

    @Test
    void cannotCreateTriangleWithNegativeSideB() {
        try {
            new Triangle(5.0, -7.0, 11.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //OK
        }
    }

    @Test
    void cannotCreateTriangleWithNegativeSideC() {
        try {
            new Triangle(5.0, 7.0, -11.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //OK
        }
    }


    @Test
    void cannotCreateTriangleInequality() {
        try {
            new Triangle(5.0, 7.0, 19.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //OK
        }
    }

    @Test
    void testEquality() {
        var t1 = new Triangle(5.0, 7.0, 11.0);
        var t2 = new Triangle(5.0, 7.0, 11.0);
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void testEquality2() {
        var t1 = new Triangle(5.0, 7.0, 11.0);
        var t2 = new Triangle(11.0, 5.0, 7.0);
        Assertions.assertEquals(t1, t2);
    }


    @Test
    void testNonEquality() {
        var t1 = new Triangle(5.0, 7.0, 11.0);
        var t2 = new Triangle(5.0, 6.0, 11.0);
        Assertions.assertNotEquals(t1, t2);
    }

    @Test
    void testPass() {
        var t1 = new Triangle(5.0, 7.0, 11.0);
        var t2 = new Triangle(5.0, 7.0, 11.0);
        Assertions.assertTrue(t1.equals(t2));
    }

}
