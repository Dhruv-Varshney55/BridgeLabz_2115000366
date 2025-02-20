import java.util.*;
public class CircularBuffer{
    int[] buffer;
    int size, front, rear, count;

    public CircularBuffer(int size){
        this.size = size;
        buffer = new int[size];
        front = rear = count = 0;
    }

    public void insert(int x){
        if(count == size){
			front = (front + 1) % size;
		}
        else count++;
        buffer[rear] = x;
        rear = (rear + 1) % size;
    }

    public List<Integer> getBuffer(){
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<count; i++){
			result.add(buffer[(front + i) % size]);
		}
        return result;
    }

    public static void main(String[] args){
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.insert(4);
        System.out.println("Buffer: " + cb.getBuffer());
    }
}