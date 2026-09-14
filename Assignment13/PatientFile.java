import java.io.*;
import java.util.*;

public class PatientFile
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String fileName = "patients.txt";

        try
        {
            // ---------------- WRITE DATA TO FILE ----------------

            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);

            System.out.print("Enter number of patients: ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 1; i <= n; i++)
            {
                System.out.println("\nEnter details of Patient " + i);

                System.out.print("Patient ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Patient Name: ");
                String name = sc.nextLine();

                System.out.print("Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Diagnosis: ");
                String diagnosis = sc.nextLine();

                // Write patient details to file
                bw.write(id + "," + name + "," + age + "," + diagnosis);

                bw.newLine();
            }

            bw.close();

            System.out.println("\nPatient details written successfully.");

            // ---------------- READ DATA FROM FILE ----------------

            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            System.out.println("\n========== PATIENT DETAILS ==========");

            String line;

            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(",");

                System.out.println("-------------------------------------");
                System.out.println("Patient ID   : " + data[0]);
                System.out.println("Patient Name : " + data[1]);
                System.out.println("Age          : " + data[2]);
                System.out.println("Diagnosis    : " + data[3]);
            }

            System.out.println("-------------------------------------");

            br.close();
        }
        catch (IOException e)
        {
            System.out.println("File Error: " + e.getMessage());
        }

        sc.close();
    }
}