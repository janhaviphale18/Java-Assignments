final class ExaminationConfig {

    // final variable: value can be assigned only once
    final double examinationFee = 1500.0;

    // final method: cannot be overridden
    final double calculateResult(double marks) {
        if (marks >= 40) {
            return marks;
        } else {
            return 0;
        }
    }
    
    void displayFee() {
        System.out.println("Examination Fee: " + examinationFee);
    }
}


// Main class
public class Main {
    public static void main(String[] args) {

        // TC1: Creating object of final class
        ExaminationConfig config = new ExaminationConfig();

        System.out.println("Examination Configuration Created");
        config.displayFee();

        double result = config.calculateResult(75);
        System.out.println("Result: " + result);

        /*
         * TC2: Attempt to change final variable
         *
         * config.examinationFee = 2000;
         *
         * Compilation Error:
         * cannot assign a value to final variable examinationFee
         */


        /*
         * TC3: Attempt to override final method
         *
         * class NewConfig extends ExaminationConfig {
         *
         *     @Override
         *     double calculateResult(double marks) {
         *         return marks + 10;
         *     }
         * }
         *
         * Compilation Error:
         * cannot inherit from final ExaminationConfig
         *
         * Also, a final method cannot be overridden.
         */
    }
}