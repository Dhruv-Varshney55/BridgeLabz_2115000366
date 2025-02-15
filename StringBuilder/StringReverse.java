public class StringReverse{
    public static void main(String[] args){
        String str = "Dhruv";
        System.out.println("Original String: " + str);
        String ans = reversedString(str);
        System.out.println("Reversed String: " + ans);
    }

    public static String reversedString(String str){
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}