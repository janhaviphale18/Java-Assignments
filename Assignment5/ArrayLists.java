import java.util.ArrayList;
public class ArrayLists{
public static void main(String[] args)
{
    ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Banana");

        System.out.println("Fruits: " +fruits); 
        fruits.remove("Banana");
        System.out.println("Fruits: " +fruits);
        fruits.add("Grapes");
        System.out.println("Fruits: " +fruits);
        System.out.println("Size: " +fruits.size());

    ArrayList<Integer> rollno = new ArrayList<>();
        rollno.add(1);
        rollno.add(2);
        rollno.add(3);
        System.out.println("Roll No: " +rollno);    
        System.out.println("Size: " +rollno.size());
        rollno.remove(1);
        System.out.println("Roll No: " +rollno);
        System.out.println("Size: " +rollno.size());

    ArrayList<Double> marks = new ArrayList<>();
        marks.add(87.65);
        marks.add(45.23);
        marks.add(88.34);
        System.out.println("Marks: " +marks);
        System.out.println("Size: " +marks.size());
        marks.remove(1);
        System.out.println("Marks: " +marks);
        System.out.println("Size: " +marks.size());

}
}