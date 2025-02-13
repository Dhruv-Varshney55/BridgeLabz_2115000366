import java.util.Stack;
public class QueueUsingStacks{
    private Stack<Integer> st1;
    private Stack<Integer> st2;

    public QueueUsingStacks(){
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void enqueue(int data){
        st1.push(data);
    }

    public int dequeue(){
        if(st2.isEmpty()){
            if(st1.isEmpty()){
                throw new RuntimeException("Queue is empty");
            }
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }

    public int peek(){
        if(st2.isEmpty()){
            if(st1.isEmpty()){
                throw new RuntimeException("Queue is empty");
            }
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
        }
        return st2.peek();
    }

    public boolean isEmpty(){
        return st1.isEmpty() && st2.isEmpty();
    }

    public static void main(String[] args){
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty());
        System.out.println(!queue.isEmpty());
		
    }
}