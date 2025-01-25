import java.util.Scanner;
public class Program9{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows and columns:");
        int row = sc.nextInt();
        int col = sc.nextInt();
        int [][] arr = new int[row][col];
        System.out.println("Enter the elements:");
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int [] array = new int[row * col];
        int index = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                array[index++] = arr[i][j];
            }
        }
        System.out.println("1D Array:");
        for(int ele : array){
            System.out.print(ele + " ");
        }
    }
}