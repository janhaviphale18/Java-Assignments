final Class FinalClass {
    void display(){
        System.out.println("This is final class");
    }
};
//class subclass extends FinalClass{} Hence Compilation Error
public class FinalClass {
    public static void main(String[] args) {
        FinalClass obj = new FinalClass();
        obj.display();
    }
};