import java.util.Scanner;

class Student{
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int rollNumber, String name, int age, char grade){
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList{
    private Student head;

    public void addAtBeginning(int rollNumber, String name, int age, char grade){
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addAtEnd(int rollNumber, String name, int age, char grade){
        Student newStudent = new Student(rollNumber, name, age, grade);
        if(head == null){
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    public void addAtPosition(int rollNumber, String name, int age, char grade, int position){
        Student newStudent = new Student(rollNumber, name, age, grade);
        if(position == 1){
            newStudent.next = head;
            head = newStudent;
            return;
        }
        Student temp = head;
        for(int i=1; temp!=null && i<position-1; i++){
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("Position out of range");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    public void deleteByRollNumber(int rollNumber){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        if(head.rollNumber == rollNumber){
            head = head.next;
            return;
        }
        Student temp = head, prev = null;
        while(temp!=null && temp.rollNumber!=rollNumber){
            prev = temp;
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("Student with Roll Number " + rollNumber + " not found");
            return;
        }
        prev.next = temp.next;
    }

    public Student searchByRollNumber(int rollNumber){
        Student temp = head;
        while(temp != null){
            if(temp.rollNumber == rollNumber){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void updateGrade(int rollNumber, char newGrade){
        Student student = searchByRollNumber(rollNumber);
        if(student != null){
            student.grade = newGrade;
        }
		else{
            System.out.println("Student with Roll Number " + rollNumber + " not found");
        }
    }

    public void displayRecords(){
        if(head == null){
            System.out.println("No student records available");
            return;
        }
        Student temp = head;
        while(temp != null){
            System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentManagement{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StudentLinkedList studentList = new StudentLinkedList();
        while(true){
            System.out.println("\nStudent Record Management System");
            System.out.println("1. Add Student at Beginning");
            System.out.println("2. Add Student at End");
            System.out.println("3. Add Student at Specific Position");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Search Student by Roll Number");
            System.out.println("6. Update Student Grade");
            System.out.println("7. Display All Students");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter Roll Number, Name, Age, Grade: ");
                    studentList.addAtBeginning(sc.nextInt(), sc.next(), sc.nextInt(), sc.next().charAt(0));
                    break;
                case 2:
                    System.out.print("Enter Roll Number, Name, Age, Grade: ");
                    studentList.addAtEnd(sc.nextInt(), sc.next(), sc.nextInt(), sc.next().charAt(0));
                    break;
                case 3:
                    System.out.print("Enter Roll Number, Name, Age, Grade, Position: ");
                    studentList.addAtPosition(sc.nextInt(), sc.next(), sc.nextInt(), sc.next().charAt(0), sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter Roll Number to delete: ");
                    studentList.deleteByRollNumber(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter Roll Number to search: ");
                    Student student = studentList.searchByRollNumber(sc.nextInt());
                    if(student != null){
                        System.out.println("Student Found - Roll Number: " + student.rollNumber + ", Name: " + student.name + ", Age: " + student.age + ", Grade: " + student.grade);
                    }
					else{
                        System.out.println("Student not found");
                    }
                    break;
                case 6:
                    System.out.print("Enter Roll Number and New Grade: ");
                    studentList.updateGrade(sc.nextInt(), sc.next().charAt(0));
                    break;
                case 7:
                    studentList.displayRecords();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid choice, Try again");
            }
        }
    }
}