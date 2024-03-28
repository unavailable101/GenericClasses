package Arithmetic;

import java.util.Scanner;

public class Arithmetic <N extends Number>  {
    private final N num1;
    private final N num2;

    public Arithmetic(N num1, N num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public Number add(){
        return num1.doubleValue() + num2.doubleValue();
    }

    public Number subtract(){
        return num1.doubleValue() - num2.doubleValue();
    }

    public Number multiply(){
        return num1.doubleValue() * num2.doubleValue();
    }

    public Number divide(){
        try {
            if (num2.doubleValue() == 0) throw new ArithmeticException("Cannot be divided by 0");
            return num1.doubleValue() / num2.doubleValue();
        } catch (ArithmeticException ae){
            System.err.println(ae.getMessage());
        }
        return null; //ambot, null nlng ako i return, pero pwede sd zero, pero ehh ambot
    }

    public Number getMin(){
        return num1.doubleValue()>num2.doubleValue() ? num2 : num1;
    }

    public Number getMax(){
        return num1.doubleValue()>num2.doubleValue() ? num1 : num2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two numbers: ");
        Number a = sc.nextBigDecimal(); //questions about bigdecimal laturrrr
        Number b = sc.nextBigDecimal(); //i google mamsh haaa kng kinsa ni sila

        Arithmetic<Number> art = new Arithmetic<Number>(a, b);

        System.out.println("Addition: " + art.add());
        System.out.println("Subtraction: " + art.subtract());
        System.out.println("Multiplication: " + art.multiply());
        System.out.println("Division: " + art.divide());
        System.out.println("Minimum: " + art.getMin());
        System.out.println("Maximum: " + art.getMax());
    }
}