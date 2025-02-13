import java.util.Stack;
public class SortStackRecursively{
    public static void sortStack(Stack<Integer> st){
        if(!st.isEmpty()){
            int temp = st.pop();
            sortStack(st);
            insertSorted(st, temp);
        }
    }

    public static void insertSorted(Stack<Integer> st, int element){
        if(st.isEmpty() || element>st.peek()){
            st.push(element);
            return;
        }
        int temp = st.pop();
        insertSorted(st, element);
        st.push(temp);
    }

    public static void main(String[] args){
        Stack<Integer> st = new Stack<>();
        st.push(4);
        st.push(2);
        st.push(3);
        st.push(5);
        st.push(1);
        System.out.println("Original Stack: " + st);
        sortStack(st);
        System.out.println("Sorted Stack: " + st);
    }
}