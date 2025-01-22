public class Program7{
    public static void main(String[] args){
        int radius = 6378;
        double volumeKm = (4.0 / 3) * 3.14 * Math.pow(radius, 3);
        double volumeMiles = volumeKm / Math.pow(1.6, 3);
        System.out.println("The volume of earth in cubic kilometers is " + volumeKm + " and cubic miles is " + volumeMiles);
    }
}