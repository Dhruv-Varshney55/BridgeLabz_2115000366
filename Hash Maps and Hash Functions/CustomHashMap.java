import java.util.*;
class CustomHashMap{
    private static class Node{
        int key, value;
        Node next;
        Node(int key, int value){ 
			this.key = key; 
			this.value = value; 
		}
    }

    private final int SIZE = 1000;
    private Node[] table;

    CustomHashMap(){ 
		table = new Node[SIZE]; 
	}

    void put(int key, int value){
        int index = key % SIZE;
        if(table[index] == null){
            table[index] = new Node(-1, -1);
        }
        Node prev = find(table[index], key);
        if(prev.next == null){
			prev.next = new Node(key, value);
		}
        else prev.next.value = value;
    }

    int get(int key){
        int index = key % SIZE;
        if(table[index] == null){
			return -1;
		}
        Node prev = find(table[index], key);
        return prev.next == null ? -1 : prev.next.value;
    }

    void remove(int key){
        int index = key % SIZE;
        if(table[index] == null){
			return;
		}
        Node prev = find(table[index], key);
        if(prev.next != null){
			prev.next = prev.next.next;
		}
    }

    private Node find(Node bucket, int key){
        Node cur = bucket;
        while(cur.next != null && cur.next.key != key){
			cur = cur.next;
		}
        return cur;
    }

    public static void main(String[] args){
        CustomHashMap map = new CustomHashMap();
        map.put(1, 10);
        map.put(2, 20);
        System.out.println(map.get(1));
        map.remove(2);
        System.out.println(map.get(2));
    }
}