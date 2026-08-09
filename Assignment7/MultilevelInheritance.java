class Grandparent{
    void showGrandparent(){
        System.out.println("This is Grandparent class");
    }
}
class Parent extends Grandparent{
    void showParent(){
        System.out.println("This is Parent class");
    }
}
class Child extends Parent{
    void showChild(){
        System.out.println("This is Child class");
    }
}
public class MultilevelInheritance {
    public static void main(String[] args) {
        Child c = new Child();
        c.showGrandparent();
        c.showParent();
        c.showChild();
    }
}