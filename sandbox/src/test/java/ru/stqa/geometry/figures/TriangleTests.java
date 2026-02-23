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
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(-5.0, 7.0, 11.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //OK
        }
        try {
            new Triangle(5.0, -7.0, 11.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //OK
        }
        try {
            new Triangle(5.0, 7.0, -11.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //OK
        }
    }
  }
