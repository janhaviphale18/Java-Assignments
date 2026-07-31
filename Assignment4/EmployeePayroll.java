import java.util.Scanner;

public class EmployeePayroll
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        String empId = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        String salary = sc.nextLine();

        System.out.print("Enter Bonus: ");
        String bonus = sc.nextLine();

        // Convert String to Wrapper Objects
        Double basicSalary = Double.valueOf(salary);
        Double bonusAmount = Double.valueOf(bonus);

        
        if (basicSalary < 0 || bonusAmount < 0)
        {
            System.out.println("Invalid Salary or Bonus.");
        }
        else
        {
            double netSalary = basicSalary + bonusAmount;

            System.out.println("\nEmployee ID : " + empId);
            System.out.println("Basic Salary : " + basicSalary);
            System.out.println("Bonus : " + bonusAmount);
            System.out.println("Net Salary : " + netSalary);
        }

        sc.close();
    }
}