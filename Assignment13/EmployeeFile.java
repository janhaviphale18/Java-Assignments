import java.io.*;
import java.util.*;

public class EmployeeFile
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String fileName = "employees.txt";

        try
        {
            // ---------------- WRITE DATA TO FILE ----------------

            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);

            System.out.print("Enter number of employees: ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 1; i <= n; i++)
            {
                System.out.println("\nEnter details of Employee " + i);

                System.out.print("Employee ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Employee Name: ");
                String name = sc.nextLine();

                System.out.print("Department: ");
                String department = sc.nextLine();

                System.out.print("Designation: ");
                String designation = sc.nextLine();

                System.out.print("Salary: ");
                double salary = sc.nextDouble();
                sc.nextLine();

                // Write employee details to file
                bw.write(id + "," + name + "," + department + ","
                        + designation + "," + salary);

                bw.newLine();
            }

            bw.close();

            System.out.println("\nEmployee details written successfully.");

            // ---------------- READ DATA FROM FILE ----------------

            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            System.out.println("\n========== EMPLOYEE DETAILS ==========");

            String line;

            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(",");

                System.out.println("--------------------------------------");
                System.out.println("Employee ID   : " + data[0]);
                System.out.println("Employee Name : " + data[1]);
                System.out.println("Department    : " + data[2]);
                System.out.println("Designation   : " + data[3]);
                System.out.println("Salary        : " + data[4]);
            }

            System.out.println("--------------------------------------");

            br.close();
        }
        catch (IOException e)
        {
            System.out.println("File Error: " + e.getMessage());
        }

        sc.close();
    }
}