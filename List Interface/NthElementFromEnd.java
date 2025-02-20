import java.util.LinkedList;
public class NthElementFromEnd{
    public static String findNthFromEnd(LinkedList<String> list, int n){
        if(list.isEmpty() || n<=0){
            return "Invalid N";
        }
        int fast = 0;
        int slow = 0;
        while(fast < n){
            if(fast >= list.size()){
                return "Invalid N";
            }
            fast++;
        }
        while(fast < list.size()){
            fast++;
            slow++;
        }
        return list.get(slow);
    }

    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        int N = 3;
        System.out.println("Original List: " + list + ", N=3");
        String ans = findNthFromEnd(list, N);
        System.out.println("Nth Element from End: " + ans);
    }
}