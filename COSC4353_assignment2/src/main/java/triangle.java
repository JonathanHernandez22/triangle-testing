import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;


public class triangle {
    // sides of triangle
    private double a;
    private double b;
    private double c;
    // vertices
    private point v1;
    private point v2;
    private point v3;
    private boolean isTriangle;

    // Uses the vertices to calculate sides of the triangle
    private void setA(point aTemp, point bTemp) {
        double changeX = bTemp.getX() - aTemp.getX();
        double changeY = bTemp.getY() - aTemp.getY();
        setA((Math.sqrt(Math.pow(changeX, 2) + Math.pow(changeY, 2))));
    }
    private void setB(point aTemp, point cTemp) {
        setB(cTemp.getX() - aTemp.getX());
    }
    private void setC(point bTemp, point cTemp) {
        int changeX = cTemp.getX() - bTemp.getX();
        int changeY = cTemp.getY() - bTemp.getY();
        setC(Math.sqrt(Math.pow(changeX, 2)+ Math.pow(changeY, 2)));
    }
    // end of using vertices to calculate sides of a triangle
    public boolean checkIfTriangle(double sideA, double sideB, double sideC) {
        if( sideA <= 0 || sideB <= 0 || sideC <= 0) { // Checking for negative values
            return false;
        }
        else if(sideA + sideB < sideC || sideA + sideC < sideB || sideB + sideC < sideA ) { // Triangle Inequality Theorem
            return false;
        }
        else {
            return true;
        }
    }

    private void printTriangleType(){
        if (isTriangle()) {
            if (isEquilateral()) {
                System.out.println("The triangle is an equilateral triangle.");
            } else if (isIsosceles()) {
                if (isRight()) {
                    System.out.println("The triangle is an isosceles right triangle.");
                } else {
                    System.out.println("The triangle is an isosceles triangle.");
                }
            } else if (isScalene()) {
                if (isRight()) {
                    System.out.println("The triangle is a scalene right triangle");
                } else {
                    System.out.println("The triangle is a scalene triangle.");
                }
            } else if (isRight()) {
                System.out.println("The triangle is a right triangle.");
            }
        }
        else {
            System.out.println("Error: Not a valid triangle");
        }
    }
    private double getArea(double sideA, double sideB, double sideC) {
        double s = (sideA + sideB + sideC)/2;
        return Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
    }
    public double getArea(){
        return getArea(a,b,c);
    }

    public triangle() {
        setA(0);
        setB(0);
        setC(0);
        setTriangle(false);
    }
    public triangle(double a, double b, double c) {
        setA(a);
        setB(b);
        setC(c);
        setTriangle(checkIfTriangle(a,b,c));
        printTriangleType();
    }
    public triangle(int x1, int y1, int x2, int y2, int x3, int y3){
        v1 = new point(x1,y1);
        v2 = new point(x2,y2);
        v3 = new point(x3,y3);
        setA(v1,v2);
        setB(v1,v3);
        setC(v2,v3);
        setTriangle(checkIfTriangle(a,b,c));
        printTriangleType();
    }
    public double getA() {
        return a;
    }
    public void setA(double a) {
        this.a = a;
    }
    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
    }
    public double getC() {
        return c;
    }
    public void setC(double c) {
        this.c = c;
    }
    public boolean isTriangle() {
        return isTriangle;
    }
    public void setTriangle(boolean isTriangle) {
        this.isTriangle = isTriangle;
    }
    public boolean isEquilateral() { /*All sides are equal */
        if(isTriangle) {
            if(a ==b && b == c) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    public boolean isIsosceles() { /*Two sides are equal */
        if(isTriangle) {
            if(a == b || b == c || a == c) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    public boolean isScalene() { /* No sides are equal */
        if(isTriangle) {
            if(a != b && b !=c && a != c) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    public boolean isRight() { /*Right triangle iff a^2 + b^2 = c^2 => c = (a^2 + b^2)^(1/2)  */
        if(isTriangle) {

            double aSquared =Math.pow(a, 2);
            double bSquared = Math.pow(b, 2);
            double abSqroot = Math.sqrt(aSquared+bSquared);
			/*System.out.println(abSqroot);
			System.out.println(c);*/

            Double tobeTruncated = new Double(abSqroot);
            Double truncatedDouble = BigDecimal.valueOf(tobeTruncated).setScale(3,RoundingMode.HALF_UP).doubleValue();
			/*
			 I found the code of truncating double here: https://stackoverflow.com/questions/14845937/java-how-to-set-precision-for-double-value
			 it is the second answer
			 */
            /*System.out.println(truncatedDouble);*/
            if(truncatedDouble == c) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    public class point{
        private int x;
        private int y;
        point(){
            setX(0);
            setY(0);
        }
        point(int x, int y){
            setX(x);
            setY(y);
        }
        public void setX(int x){
            this.x = x;
        }
        public void setY(int y){
            this.y = y;
        }
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }

    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Select From Options Below:\n1. Enter Vertices of a Triangle\n2. Enter Sides of a Triangle\n");
        // Checking for Int input
        int inputVal = myObj.nextInt();
        if (inputVal == 1) {
            System.out.print("Enter three vertices of a triangle: Ex \n0 0 = A\t\t\tB \n2 3 = B\t\tA\t\tC\n4 0 = C\nSet the values to be only positive integers. (Ignore = and letters for input)\n");
            int[] arr = new int[6];
            for(int i =0; i <6; i++){
                if(!myObj.hasNextInt()){
                    System.out.println("Error: Did not receive int value.\n");
                    System.exit(-1);
                }
                arr[i] = myObj.nextInt();
            }
            triangle Triangle = new triangle(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]);
            //System.out.println("Area of triangle: \n" + Triangle.getArea());
        }
        else if (inputVal == 2) {
            System.out.println("Enter three sides of a triangle: Ex. 1 2 3\nSet precision to 3 decimal values. Ex. 1.414\n");
                // Numerical input
            double[] arr = new double[3];
            for(int i = 0 ; i < 3; i++){
                if(!myObj.hasNextDouble()){
                    System.out.println("Error: Did not receive number as input.\n");
                    System.exit(-1);
                }
                arr[i] = myObj.nextDouble();
            }
            double sideA = arr[0];
            double sideB = arr[1];
            double sideC = arr[2];
            triangle Triangle = new triangle(sideA, sideB, sideC); //Creates triangle object
            //System.out.println("Area of triangle: \n" + Triangle.getArea());
        }
        else{
            System.out.println("Error: Invalid Input\n");
        }
    }
}
