import java.util.StringTokenizer;
public class StringToken{
    
public static void main(String[] args){
    
        StringTokenizer st = new StringTokenizer("I am Janhavi Phale");
        while (st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }

}