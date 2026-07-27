public class Arrayexample
{
    public static void main(String[] args)
    {
        int[] number = {10, 20, 30, 40, 50};

        // Using normal for loop
        System.out.println("Array elements using for loop:");

        for (int i = 0; i < number.length; i++)
        {
            System.out.println(number[i]);
        }

        // Using enhanced for-each loop
        System.out.println("\nArray elements using for-each loop:");

        for (int num : number)
        {
            System.out.println(num);
        }
    } 
}