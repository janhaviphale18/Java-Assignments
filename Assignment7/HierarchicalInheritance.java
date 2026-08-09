class Animal{
    void eat(){
        System.out.println("This is an animal");
    }
}
class Dog extends Animal{
    void barks(){
        System.out.println("This is a dog");
    }
}
class Cat extends Animal{
    void meows(){
        System.out.println("This is a cat");
    }
}
public class HierarchicalInheritance {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.eat();
        Dog d = new Dog();
        d.eat();
        d.barks();
        Cat c = new Cat();
        c.eat();
        c.meows();
    }
}