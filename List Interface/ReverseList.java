import java.util.ArrayList;
import java.util.LinkedList;

public class ReverseList{
    public static ArrayList<Integer> reverseArrayList(ArrayList<Integer> list){
        ArrayList<Integer> reverse = new ArrayList<>();
        for(int i=list.size()-1; i>=0; i--){
            reverse.add(list.get(i));
        }
        return reverse;
    }

    public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list){
        LinkedList<Integer> reverse = new LinkedList<>();
        for(int i=list.size()-1; i>=0; i--){
            reverse.add(list.get(i));
        }
        return reverse;
    }

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("Original ArrayList: " + list);
        ArrayList<Integer> reversedArrayList = reverseArrayList(list);
        System.out.println("Reversed ArrayList: " + reversedArrayList);

        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        System.out.println("Original LinkedList: " + ll);
        LinkedList<Integer> reversedLinkedList = reverseLinkedList(ll);
        System.out.println("Reversed LinkedList: " + reversedLinkedList);
    }
}