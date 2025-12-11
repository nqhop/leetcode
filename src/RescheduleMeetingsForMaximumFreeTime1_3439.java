import java.util.Comparator;
import java.util.PriorityQueue;

public class RescheduleMeetingsForMaximumFreeTime1_3439 {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        PriorityQueue<int[]> pg = new PriorityQueue<>(new SpaceComparator());

        int n = startTime.length, index = 0, currentStartTime = 0, gap;
        while (index <= n){
            try {
                gap = startTime[index] - currentStartTime;
                if(gap > 0)
                    pg.offer(new int[] {currentStartTime, gap});
                currentStartTime = endTime[index];
                index++;
            }catch (IndexOutOfBoundsException e){
                gap = eventTime - currentStartTime;
                if(gap > 0)
                    pg.offer(new int[] {currentStartTime, gap});
                index++;
            }
        }

//        while (!pg.isEmpty()){
//            int[] tem = pg.poll();
//            System.out.println(tem[0] + " " + tem[1]);
//        }

        int kCount = 1, maxGap = 0;
        while (kCount <= k){
            for (int i = 0; i < n - kCount + 1; i++){
                int totalGap = calculateGap(eventTime, i, kCount, new PriorityQueue<int[]>(pg), startTime, endTime);
                if (maxGap < totalGap) maxGap = totalGap;
            }
            kCount++;
        }
        return maxGap;
    }

    public int calculateGap(int eventTime, int index, int kCount, PriorityQueue<int[]> pg, int[] startTime, int[] endTime){
        PriorityQueue<int[]> meetings = new PriorityQueue<>(new SpaceComparator());
        int tmpIndex = index;
        for(int i = 0; i < kCount; i++, tmpIndex++){
            meetings.offer(new int[] {tmpIndex, endTime[tmpIndex] - startTime[tmpIndex]});
        }

        int[] maxGapCanHave = new int[2];
        int subtract = 0;
        maxGapCanHave[0] = index >= 1 ? endTime[index - 1] : 0;
        maxGapCanHave[1] = index < endTime.length - 1 ? startTime[index + 1] : eventTime;
        for(int i = 0; i < kCount; i++){
            int[] maxGap = pg.poll();
            while (maxGap != null && maxGap[0] >= maxGapCanHave[0] && maxGap[0] + maxGap[1] <= maxGapCanHave[1]){
                maxGap =  pg.poll();
            }
            if(maxGap == null) {
                subtract += meetings.poll()[1];
                continue;
            }
            int[] maxMeeting = meetings.peek();
            if(maxGap[1] < maxMeeting[1]) {
                subtract += maxMeeting[1];
            }else {
                meetings.poll();
            }
        }
        return maxGapCanHave[1] - maxGapCanHave[0] -subtract;
    }

    public static void main(String[] args) {
//        System.out.println(new RescheduleMeetingsForMaximumFreeTime1_3439().maxFreeTime(5, 1, new int[] {1, 3}, new int[]{2, 5}));
        System.out.println(new RescheduleMeetingsForMaximumFreeTime1_3439().maxFreeTime(15, 2, new int[] {1, 4, 7, 9, 12}, new int[]{2, 6, 8, 11, 13}));
    }
}

    /*
    compare for gap and meeting time
     */
class SpaceComparator implements Comparator<int[]>{
    @Override
    public int compare(int[] o1, int[] o2) {
        if(o1[1] < o2[1]) return 1;
        else if (o1[1] > o2[1]) return -1;
        else return 0;
    }
}