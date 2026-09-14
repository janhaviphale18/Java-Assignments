interface P1{
    void display();
}
interface P2{
    void show();
}
class A implements P1 , P2{
    public void display(){
        System.out.println("P1 interface method");
    }
    public void show(){
        System.out.println("P2 interface method");
    }
}
public class Interface {
    public static void main(String[] args){
        
    }
}