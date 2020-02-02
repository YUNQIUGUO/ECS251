import java.util.*;	
import java.io.*;	
import java.lang.*; 


class IntervalScheduling {
    public static int maxNumberEvents(int[] arrival, int[] duration) {
        // make intervals array
        int n = arrival.length;
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            int[] interval = new int[2];
            interval[0] = arrival[i];
            interval[1] = duration[i];
            intervals[i] = interval;
        }
        // sort by the ending time
        Arrays.sort(intervals,new myComparator());
        int count = 0;  // maximum number of non-overlapping intervals
        int end = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++)  {
            if (intervals[i][0] >= end)  { // non- overlapping
                count++;
                end = intervals[i][1];
            }
        }
        return count;
        
    }
    
    public static class myComparator implements Comparator<int[]> {
        public int compare(int[] a , int[] b) {
            return a[1] - b[1];
        }
    }

    public static void main(String[] args) {
        /*int[] arrival = {1,3,3,5,7};
        int[] duration = {2,2,1,2,1};*/

        int[] arrival = {3,1,3,5};
        int[] duration = {3,2,2,2};
        System.out.println(maxNumberEvents(arrival, duration));
    }
    
    
}