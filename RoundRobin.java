import java.util.Scanner;

class Process{
    int processId, burstTime, priority, remainingTime, waitingTime, turnAroundTime;
    Process next;

    public Process(int processId, int burstTime, int priority){
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
        this.waitingTime = 0;
        this.turnAroundTime = 0;
        this.next = null;
    }
}

class RoundRobinScheduler{
    private Process head, tail;
    private int totalProcesses = 0, totalWaitingTime = 0, totalTurnAroundTime = 0;

    public void addProcess(int processId, int burstTime, int priority){
        Process newProcess = new Process(processId, burstTime, priority);
        if(head == null){
            head = tail = newProcess;
            tail.next = head;
        }
		else{
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
        totalProcesses++;
    }

    public void removeProcess(int processId){
        if(head == null){
			return;
		}

        Process temp = head, prev = null;
        do{
            if(temp.processId == processId){
                if(temp==head && temp==tail){
                    head = tail = null;
                }
				else if(temp == head){
                    tail.next = head.next;
                    head = head.next;
                }
				else if (temp == tail){
                    prev.next = tail.next;
                    tail = prev;
                }
				else{
                    prev.next = temp.next;
                }
                totalProcesses--;
                return;
            }
            prev = temp;
            temp = temp.next;
        }while(temp != head);
    }

    public void executeRoundRobin(int timeQuantum){
        if(head == null){
            System.out.println("No processes in the queue");
            return;
        }

        int currentTime = 0;
        Process current = head;

        while(totalProcesses > 0){
            if(current.remainingTime > 0){
                
				int execTime = Math.min(current.remainingTime, timeQuantum);
                current.remainingTime -= execTime;
                currentTime += execTime;

                if(current.remainingTime == 0){
                    current.turnAroundTime = currentTime;
                    current.waitingTime = current.turnAroundTime - current.burstTime;
                    totalWaitingTime += current.waitingTime;
                    totalTurnAroundTime += current.turnAroundTime;
                    int processId = current.processId;
                    current = current.next;
                    removeProcess(processId);
                }
				
				else{
                    current = current.next;
                }
                displayProcesses();
            }
        }

        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / totalProcesses);
        System.out.println("Average Turnaround Time: " + (double) totalTurnAroundTime / totalProcesses);
    }

    public void displayProcesses(){
        if(head == null){
            System.out.println("No processes in the queue");
            return;
        }
        Process temp = head;
        System.out.println("Process Queue:");
        do{
            System.out.println("PID: " + temp.processId + ", Burst: " + temp.burstTime + ", Remaining: " + temp.remainingTime);
            temp = temp.next;
        }while(temp != head);
        System.out.println();
    }
}

public class RoundRobin{
    public static void main(String[] args){
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n1. Add Process\n2. Execute Round Robin\n3. Display Processes\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter Process ID, Burst Time, and Priority: ");
                    scheduler.addProcess(sc.nextInt(), sc.nextInt(), sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter Time Quantum: ");
                    scheduler.executeRoundRobin(sc.nextInt());
                    break;
                case 3:
                    scheduler.displayProcesses();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}