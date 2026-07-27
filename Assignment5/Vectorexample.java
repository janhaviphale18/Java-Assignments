import java.util.Vector;

public class Vectorexample
{
    public static void main(String[] args)
    {
        Vector<Integer> number = new Vector<>();

        // Adding elements
        number.add(100);
        number.add(200);
        number.add(300);

        System.out.println("Vector: " + number);

        // Removing element at index 1
        number.remove(1);

        System.out.println("After removing index 1: " + number);

        // Displaying size
        System.out.println("Size: " + number.size());

        // Displaying element at index 0
        System.out.println("Element at index 0: " + number.get(0));
    }
}