import java.util.*;
class CircularTour{
	public static void main(String[] args){
        int[] petrol = {1, 2, 3, 4, 5};
		int[] distance = {3, 4, 5, 1, 2};
        int startPoint = findStartingPoint(petrol, distance);
        System.out.println(startPoint);
    }
	
    public static int findStartingPoint(int[] petrol, int[] distance){
        int n = petrol.length;
        Queue<Integer> q = new LinkedList<>();
        int surplus = 0, deficit = 0, start = 0;
        for(int i=0; i<n; i++){
            surplus += petrol[i] - distance[i];
            q.offer(i);
            while(surplus<0 && !q.isEmpty()){
                int removed = q.poll();
                deficit += petrol[removed] - distance[removed];
                start = removed + 1;
                surplus = 0;
            }
        }
		if(surplus + deficit >= 0){
			return start;
		}
		return -1;
    }
}