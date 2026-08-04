public class StringLists{
public static void main(String[] args){
    
    String str1 = " Janhavi Umesh Phale ";
    String str2 = new String(" Dhyana Vinay Desai ");
    String str3 = "Java";
    
    System.out.println(str1);
    System.out.println(str2);

    System.out.println(str1.length());
    System.out.println(str2.length());

    System.out.println(str1.toUpperCase());
    System.out.println(str2.toLowerCase());

    System.out.println("Trimmed String 1: " +str1.trim());
    System.out.println("Trimmed String 2: " +str2.trim());

    System.out.println("Substring(2,3): " +str1.substring(2,3));
    System.out.println("Substring(2,4): " +str2.substring(2,4));

    System.out.println("String before replacement: " +str3);
    System.out.println("Replaced Java with Python: " +str3.replace("Java","Python"));

    
}
}