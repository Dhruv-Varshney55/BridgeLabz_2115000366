public class ConcatenateStrings{
    public static void main(String[] args){
        String[] arr = {"Honesty ", "is ", "the ", "best ", "policy"};
        String ans = concatenateStrings(arr);
        System.out.println("Concatenated String: " + ans);
    }

    public static String concatenateStrings(String[] arr){
        StringBuffer sb = new StringBuffer();
        for(String s : arr){
            sb.append(s);
        }
        return sb.toString();
    }
}