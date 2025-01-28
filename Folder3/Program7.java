import java.util.Scanner;
public class Program7{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int [] otps = new int[10];
        System.out.println("Generating 10 OTPs...");
        for(int i=0; i<10; i++){
            otps[i] = generateOTP();
            System.out.println("Generated OTP " + (i + 1) + ": " + otps[i]);
        }
        if(areOTPsUnique(otps)){
            System.out.println("All OTPs are unique");
        } 
		else{
            System.out.println("There are duplicate OTPs");
        }		
    }
	
	public static int generateOTP(){
        int otp = (int) (Math.random() * 1000000);
        return otp < 100000 ? otp + 100000 : otp;
    }

    public static boolean areOTPsUnique(int[] otps){
        for(int i=0; i<otps.length; i++){
            for(int j=i+1; j<otps.length; j++){
                if(otps[i] == otps[j]){ 
                    return false;
                }
            }
        }
        return true;
    }
}