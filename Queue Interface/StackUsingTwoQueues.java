import java.util.*;
public class StackUsingTwoQueues{
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int x){
        q1.add(x);
    }

    public int pop(){
        while(q1.size() > 1){
			q2.add(q1.remove());
		}
        int removed = q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return removed;
    }

    public int top(){
        while(q1.size() > 1){
			q2.add(q1.remove());
		}
        int top = q1.peek();
        q2.add(q1.remove());
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return top;
    }

    public static void main(String[] args){
        StackUsingTwoQueues st = new StackUsingTwoQueues();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st.pop());
    }
}