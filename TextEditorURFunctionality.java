import java.util.Scanner;

class TextState{
    String content;
    TextState prev, next;

    public TextState(String content){
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor{
    private TextState current;
    private int historyLimit = 10;
    private int size = 0;

    public void addState(String newText){
        TextState newState = new TextState(newText);
        if(current != null){
            newState.prev = current;
            current.next = newState;
        }
        current = newState;
        size++;

        if(size > historyLimit){
            trimOldHistory();
        }
    }

    private void trimOldHistory(){
        TextState temp = current;
        while(temp.prev != null){
            temp = temp.prev;
        }
        temp.next.prev = null;
        size--;
    }

    public void undo(){
        if(current!=null && current.prev!=null){
            current = current.prev;
            System.out.println("Undo: " + current.content);
        }
		else{
            System.out.println("No more undo actions available");
        }
    }

    public void redo(){
        if(current!=null && current.next!=null){
            current = current.next;
            System.out.println("Redo: " + current.content);
        }
		else{
            System.out.println("No more redo actions available");
        }
    }

    public void displayCurrentState(){
        if(current == null){
            System.out.println("Text Editor is empty");
        }
		else{
            System.out.println("Current State: " + current.content);
        }
    }
}

public class TextEditorURFunctionality{
    public static void main(String[] args){
        TextEditor editor = new TextEditor();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n1. Add Text\n2. Undo\n3. Redo\n4. Display Current State\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch(choice){
                case 1:
                    System.out.print("Enter new text: ");
                    editor.addState(sc.nextLine());
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrentState();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}