import java.util.Scanner;

class Item{
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    public Item(int id, String name, int quantity, double price){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory{
    private Item head;

    public void addItemAtBeginning(int id, String name, int quantity, double price){
        Item newItem = new Item(id, name, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addItemAtEnd(int id, String name, int quantity, double price){
        Item newItem = new Item(id, name, quantity, price);
        if(head == null){
            head = newItem;
            return;
        }
        Item temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void addItemAtPosition(int id, String name, int quantity, double price, int position){
        Item newItem = new Item(id, name, quantity, price);
        if(position == 1){
            newItem.next = head;
            head = newItem;
            return;
        }
        Item temp = head;
        for(int i=1; temp!=null && i<position-1; i++){
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("Position out of bounds");
            return;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeItem(int id){
        if(head == null){
            System.out.println("Inventory is empty");
            return;
        }
        if(head.id == id){
            head = head.next;
            return;
        }
        Item temp = head;
        while(temp.next!=null && temp.next.id!=id){
            temp = temp.next;
        }
        if(temp.next == null){
            System.out.println("Item not found");
            return;
        }
        temp.next = temp.next.next;
    }

    public void updateQuantity(int id, int newQuantity){
        Item temp = head;
        while(temp != null){
            if(temp.id == id){
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    public void searchById(int id){
        Item temp = head;
        while(temp != null){
            if(temp.id == id){
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    public void searchByName(String name){
        Item temp = head;
        while(temp != null){
            if(temp.name.equalsIgnoreCase(name)){
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    public double calculateTotalValue(){
        double total = 0;
        Item temp = head;
        while(temp != null){
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        return total;
    }

    public void sortByName(){
        head = mergeSortByName(head);
    }

    public void sortByPrice(){
        head = mergeSortByPrice(head);
    }

    private Item mergeSortByName(Item head){
        if(head==null || head.next==null){
			return head;
		}
        Item middle = getMiddle(head);
        Item nextToMiddle = middle.next;
        middle.next = null;
        Item left = mergeSortByName(head);
        Item right = mergeSortByName(nextToMiddle);
        return mergeByName(left, right);
    }

    private Item mergeByName(Item left, Item right){
        if(left == null){
			return right;
		}
        if(right == null){
			return left;
		}
        if(left.name.compareToIgnoreCase(right.name) < 0){
            left.next = mergeByName(left.next, right);
            return left;
        }
		else{
            right.next = mergeByName(left, right.next);
            return right;
        }
    }

    private Item mergeSortByPrice(Item head){
        if(head==null || head.next==null){
			return head;
		}
        Item middle = getMiddle(head);
        Item nextToMiddle = middle.next;
        middle.next = null;
        Item left = mergeSortByPrice(head);
        Item right = mergeSortByPrice(nextToMiddle);
        return mergeByPrice(left, right);
    }

    private Item mergeByPrice(Item left, Item right){
        if(left == null){
			return right;
		}
        if(right == null){
			return left;
		}
        if(left.price < right.price){
            left.next = mergeByPrice(left.next, right);
            return left;
        }
		else{
            right.next = mergeByPrice(left, right.next);
            return right;
        }
    }

    private Item getMiddle(Item head){
        if(head == null){
			return head;
		}
        Item slow = head, fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private void displayItem(Item item){
        System.out.println("ID: " + item.id + ", Name: " + item.name + ", Quantity: " + item.quantity + ", Price: " + item.price);
    }

    public void displayInventory(){
        if(head == null){
            System.out.println("Inventory is empty");
            return;
        }
        Item temp = head;
        while(temp != null){
            displayItem(temp);
            temp = temp.next;
        }
    }
}

public class InventoryManagement{
    public static void main(String[] args){
        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n1. Add Item at Beginning\n2. Add Item at End\n3. Add Item at Position\n4. Remove Item\n5. Update Quantity\n6. Search by ID\n7. Search by Name\n8. Calculate Total Value\n9. Sort by Name\n10. Sort by Price\n11. Display Inventory\n12. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter ID, Name, Quantity, Price: ");
                    inventory.addItemAtBeginning(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter ID, Name, Quantity, Price: ");
                    inventory.addItemAtEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter ID, Name, Quantity, Price, Position: ");
                    inventory.addItemAtPosition(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter Item ID to Remove: ");
                    inventory.removeItem(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter Item ID and New Quantity: ");
                    inventory.updateQuantity(sc.nextInt(), sc.nextInt());
                    break;
                case 6:
                    System.out.print("Enter Item ID to Search: ");
                    inventory.searchById(sc.nextInt());
                    break;
                case 7:
                    System.out.print("Enter Item Name to Search: ");
                    inventory.searchByName(sc.next());
                    break;
                case 8:
                    System.out.println("Total Inventory Value: " + inventory.calculateTotalValue());
                    break;
                case 9:
                    inventory.sortByName();
                    System.out.println("Inventory Sorted by Name");
                    break;
                case 10:
                    inventory.sortByPrice();
                    System.out.println("Inventory Sorted by Price");
                    break;
                case 11:
                    inventory.displayInventory();
                    break;
                case 12:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}