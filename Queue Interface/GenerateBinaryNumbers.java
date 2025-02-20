import java.util.*;
public class GenerateBinaryNumbers{
	public static void main(String[] args){
        int n = 5;
        System.out.println("Binary Numbers: " + generateBinary(n));
    }
	
    public static List<String> generateBinary(int n){
        List<String> list = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("1");
        for(int i=0; i<n; i++){
            String str = q.remove();
            list.add(str);
            q.add(str + "0");
            q.add(str + "1");
        }
        return list;
    }
}