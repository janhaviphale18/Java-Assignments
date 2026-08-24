class Parent {
    Parent() {
        System.out.println("Parent 1 Class Constructor");
    }
    Parent(int x) {
        System.out.println("Parent 2 Class Constrcutor");
    }
}
class Child extends Parent {
    Child(){
        super();
        System.out.println("Child Constructor");
    }
}
public class Main {
    public static void main(String[] args){
        new Child();
    }
}