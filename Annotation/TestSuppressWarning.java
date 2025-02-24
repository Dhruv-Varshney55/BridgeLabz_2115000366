import java.util.ArrayList;
public class TestSuppressWarning{
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        ArrayList list = new ArrayList();
        list.add("Dhruv");
        list.add(366);
        for(Object item : list){
            System.out.println(item);
        }
    }
}