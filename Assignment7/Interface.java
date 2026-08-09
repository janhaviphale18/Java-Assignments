interface Animal{
    void sound();
}
class Dog implements Animal{
    public void sound(){
        System.out.println("This is a dog");
    }
}
public class Interface{
    public static void main(String[] args)
    {
        Animal a = new Dog();
        a.sound();
    }
}