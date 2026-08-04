import java.util.*;
public class VectorLists{
public static void main(String[] args)
{
    Vector<Integer> rollno = new Vector<>();
        rollno.add(1);
        rollno.add(2);
        rollno.add(3);
        System.out.println("Roll No: " +rollno);    
        System.out.println("Size: " +rollno.size());
        rollno.remove(1);
        System.out.println("Roll No: " +rollno);
        System.out.println("Size: " +rollno.size());
        System.out.println("RollNo at index 0: " +rollno.get(0));
        System.out.println("RollNo at index 1: " +rollno.get(1));
        System.out.println("RollNo at index 2: " +rollno.get(2));

    Vector<Double> marks = new Vector<>();
        marks.add(87.65);
        marks.add(45.23);
        marks.add(88.34);
        System.out.println("Marks: " +marks);
        System.out.println("Size: " +marks.size());
        marks.remove(1);
        System.out.println("Marks: " +marks);
        System.out.println("Size: " +marks.size());
        System.out.println("Marks at index 0: " +marks.get(0));
        System.out.println("Marks at index 1: " +marks.get(1));
        System.out.println("Marks at index 2: " +marks.get(2));

}
}