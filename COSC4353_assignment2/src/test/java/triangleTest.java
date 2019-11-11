import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Test;

public class triangleTest {
    @Test
    public void testIfTriangle(){
        triangle t = new triangle(-1,-2,-3);
        assertEquals("Is triangle for all negative values",false, t.checkIfTriangle(t.getA(),t.getB(),t.getC()));
        t.setA(1);
        assertEquals("Is triangle for positive a",false, t.checkIfTriangle(t.getA(),t.getB(),t.getC()));
        t.setB(2);
        assertEquals("Is triangle for positive a and b",false,t.checkIfTriangle(t.getA(),t.getB(),t.getC()));
        t.setC(4);
        assertEquals("Is triangle for all positive values, but sum of two sides is less than  third side.",false,t.checkIfTriangle(t.getA(),t.getB(),t.getC()));
        t.setA(3);
        assertEquals("Is triangle for all positive values and sum of 2 sides is greater than 3rd side",true,t.checkIfTriangle(t.getA(),t.getB(),t.getC()));
    }

    @Test
    public void testTrueTriangle() {
        setTriangleHelper(true);
    }
    @Test
    public void testFalseTriangle(){
        setTriangleHelper(false);
    }
    @Test
    public void testEquilateral() {
        triangle t = new triangle(4,4,4);
        assertEquals("Is triangle in equilateral test.",true,t.isTriangle());
        assertEquals("Is equilateral triangle",true,t.isEquilateral());
        t.setA(3);// no longer an equilateral triangle
        assertEquals("Should not be an equilateral triangle",false,t.isEquilateral());
        t.setTriangle(false); // changing a value could lead to triangle no longer being one
        assertEquals("Should not be a triangle, in equilateral",false,t.isEquilateral());
    }

    @Test
    public void testIsosceles() {
        triangle t = new triangle(2,4,4);
        assertEquals("Is triangle in isosceles test.",true,t.isTriangle());
        assertEquals("Is isosceles triangle",true,t.isIsosceles());
        t.setA(3);// no longer an isosceles triangle
        assertEquals("Should not be an isosceles triangle",false,t.isIsosceles());
        t.setTriangle(false); // changing a value could lead to triangle no longer being one
        assertEquals("Should not be a triangle, in isosceles",false,t.isIsosceles());
    }

    @Test
    public void testScalene() {
        triangle t = new triangle(2,3,4);
        assertEquals("Is triangle in equilateral test.",true,t.isTriangle());
        assertEquals("Is scalene triangle",true,t.isScalene());
        t.setA(3);// no longer a scalene triangle
        assertEquals("Should not be an equilateral triangle",false,t.isScalene());
        t.setTriangle(false); // changing a value could lead to triangle no longer being one
        assertEquals("Should not be a triangle, in scalene",false,t.isScalene());
    }

    @Test
    public void testRight() {
        triangle t = new triangle(3,4,5);
        assertEquals("Is triangle in right test.",true,t.isTriangle());
        assertEquals("Is right triangle",true,t.isRight());
        t.setA(4);// no longer an equilateral triangle
        assertEquals("Should not be an right triangle",false,t.isRight());
        t.setTriangle(false); // changing a value could lead to triangle no longer being one
        assertEquals("Should not be a triangle, in equilateral",false,t.isRight());
    }
    private void setTriangleHelper(boolean isTriangle){
        triangle t = new triangle();
        t.setTriangle(isTriangle);
        assertEquals(isTriangle, t.isTriangle());
    }
}
