class Animal{
    void eat(){
        System.out.println("This is an animal");
    }
}
class Dog extends Animal{
    void eat(){
        System.out.println("This is a dog");
    }
}

public class SingleInheritance {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.eat();
        Dog d = new Dog();
        d.eat();
    }
}