package Regex.AdvancedProblem;

import java.util.regex.*;

public class ValidateIPAddress {
    public static boolean isValidIPv4(String ip) {
        String regex = "^((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])\\.){3}" + "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] testIPs = {"255.255.255.255", "192.168.1.1", "256.100.50.25", "0.0.0.0", "192.168.1", "abc.def.ghi.jkl"};
        for (String ip : testIPs) {
            System.out.println(ip + " -> " + (isValidIPv4(ip) ? "Valid" : "Invalid"));
        }
    }
}