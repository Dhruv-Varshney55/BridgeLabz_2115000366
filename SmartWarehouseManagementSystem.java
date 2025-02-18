import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem{
    private String str;

    public WarehouseItem(String str){
        this.str = str;
    }

    public String getstr(){
        return str;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + ": " + str;
    }
}

class Electronics extends WarehouseItem{
    public Electronics(String str){
        super(str);
    }
}

class Groceries extends WarehouseItem{
    public Groceries(String str){
        super(str);
    }
}

class Furniture extends WarehouseItem{
    public Furniture(String str){
        super(str);
    }
}

class Storage<T extends WarehouseItem>{
    private List<T> list = new ArrayList<>();

    public void add(T item){
        list.add(item);
    }

    public List<T> getlist(){
        return list;
    }

    public static void displaylist(List<? extends WarehouseItem> list){
        for(WarehouseItem item : list){
            System.out.println(item);
        }
    }
}

public class SmartWarehouseManagementSystem{
    public static void main(String[] args){
        Storage<Electronics> es = new Storage<>();
        Storage<Groceries> gs = new Storage<>();
        Storage<Furniture> fs = new Storage<>();
        es.add(new Electronics("Tablet"));
        es.add(new Electronics("Mobile"));
        gs.add(new Groceries("Pulses"));
        gs.add(new Groceries("Banana"));
        fs.add(new Furniture("Sofa"));
        fs.add(new Furniture("Dining Table"));
        System.out.println("Electronics Storage:");
        Storage.displaylist(es.getlist());
        System.out.println("\nGroceries Storage:");
        Storage.displaylist(gs.getlist());
        System.out.println("\nFurniture Storage:");
        Storage.displaylist(fs.getlist());
    }
}