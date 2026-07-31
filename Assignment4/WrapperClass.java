import java.util.Scanner;
public class WrapperClass{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter first number: ");
    String str1 = sc.nextLine();
    System.out.println("Enter second number: ");
    String str2 = sc.nextLine();
    Integer num1 = Integer.valueOf(str1);
    Integer num2 = Integer.valueOf(str2);

    //Wrapper Object to Primitive (Unboxing)
    int a = num1;
    int b = num2;
    //Basic Operations
    System.out.println("Addition: " +(a+b));
    System.out.println("Subtraction: " + (a-b));
    System.out.println("Multiplication: " +(a*b));

    //Primitve to Wrapper Class (Autoboxing)
    int x = 100;
    Integer wrapperX= x;
    System.out.println("Primitive Value: " +x);
    System.out.println("Wrapper Object: " +wrapperX);
    
    //Unboxing + Widening
    Integer object1 = 25;
    double d = object1;
    System.out.println(d);
    //Unboxing + Narrowing
    Double object2 = 25.75;
    int i = object2.intValue();
    System.out.println(i); 
    //Typecasting 
    Double object3 = 25.75;
    int j = (int)(double)object3;
    System.out.println(j);
    sc.close();

    }
}