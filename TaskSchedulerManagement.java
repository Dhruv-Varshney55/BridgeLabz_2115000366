import java.util.Scanner;

class Task{
    int taskId, priority;
    String taskName, dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate){
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler{
    private Task head = null, tail = null;
    private Task currentTask = null;

    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate){
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if(head == null){
            head = tail = newTask;
            newTask.next = head;
        }
		else{
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    public void addAtEnd(int taskId, String taskName, int priority, String dueDate){
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if(head == null){
            head = tail = newTask;
            newTask.next = head;
        }
		else{
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    public void addAtPosition(int taskId, String taskName, int priority, String dueDate, int position){
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if(position == 1){
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Task temp = head;
        for(int i=1; i<position-1 && temp.next!=head; i++){
            temp = temp.next;
        }
        newTask.next = temp.next;
        temp.next = newTask;
        if(temp == tail){
			tail = newTask;
		}
        tail.next = head;
    }

    public void removeByTaskId(int taskId){
        if(head == null){
				return;
		}
        if(head.taskId == taskId){
            if(head == tail){
                head = tail = null;
            }
			else{
                head = head.next;
                tail.next = head;
            }
            return;
        }
        Task temp = head;
        do{
            if(temp.next.taskId == taskId){
                temp.next = temp.next.next;
                if(tail.taskId == taskId){
					tail = temp;
				}
                return;
            }
            temp = temp.next;
        }while(temp != head);
    }

    public void viewCurrentTask(){
        if(currentTask == null){
			currentTask = head;
		}
        if(currentTask != null){
            System.out.println("Task ID: " + currentTask.taskId + ", Name: " + currentTask.taskName + ", Priority: " + currentTask.priority + ", Due Date: " + currentTask.dueDate);
        }
		else{
            System.out.println("No tasks available");
        }
    }

    public void moveToNextTask(){
        if(currentTask != null){
            currentTask = currentTask.next;
            viewCurrentTask();
        }
    }

    public void displayAllTasks(){
        if(head == null){
            System.out.println("No tasks available");
            return;
        }
        Task temp = head;
        do{
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        }while(temp != head);
    }

    public void searchByPriority(int priority){
        if(head == null){
            System.out.println("No tasks available");
            return;
        }
        Task temp = head;
        boolean found = false;
        do{
            if(temp.priority == priority){
                System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        }while(temp != head);
        if(!found){
			System.out.println("No tasks found with priority " + priority);
		}
    }
}

public class TaskSchedulerManagement{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        TaskScheduler ts = new TaskScheduler();
        while(true){
            System.out.println("\n1. Add Task at Beginning\n2. Add Task at End\n3. Add Task at Position");
            System.out.println("4. Remove Task by ID\n5. View Current Task\n6. Move to Next Task");
            System.out.println("7. Display All Tasks\n8. Search Task by Priority\n9. Exit");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter Task ID, Name, Priority, Due Date: ");
                    ts.addAtBeginning(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;
                case 2:
                    System.out.print("Enter Task ID, Name, Priority, Due Date: ");
                    ts.addAtEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
                    break;
                case 3:
                    System.out.print("Enter Task ID, Name, Priority, Due Date, Position: ");
                    ts.addAtPosition(sc.nextInt(), sc.next(), sc.nextInt(), sc.next(), sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    ts.removeByTaskId(sc.nextInt());
                    break;
                case 5:
                    ts.viewCurrentTask();
                    break;
                case 6:
                    ts.moveToNextTask();
                    break;
                case 7:
                    ts.displayAllTasks();
                    break;
                case 8:
                    System.out.print("Enter Priority: ");
                    ts.searchByPriority(sc.nextInt());
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}