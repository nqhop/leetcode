import java.util.*;

public class MaximumPathQualityofaGraph_2065 {

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < values.length; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int from = edge[0], to = edge[1], time = edge[2];
            graph.get(from).add(new int[]{to, time});
            graph.get(to).add(new int[]{from, time});
        }

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(values[0], 0, 0, 0));

        int maxQuality = values[0];
        while(!queue.isEmpty()){
            List<Integer> cur = queue.poll();
            int curQuality = cur.get(0), curTime = cur.get(1), curNode = cur.get(2);
            List<Integer> visited = new ArrayList<>(cur.subList(3, cur.size()));

            for(int[] next : graph.get(curNode)){
                int nextNode = next[0], nextTime = next[1];
                boolean isVisited = visited.contains(nextNode);
                if(curTime + nextTime > maxTime) continue;

                if(nextNode == 0 && (maxQuality < curQuality + (isVisited ? 0 : values[nextNode]))){
                    maxQuality = curQuality + (isVisited ? 0 : values[nextNode]);
                    System.out.println(maxQuality + " " + (curQuality + curNode));
                }

                if(!isVisited) visited.add(nextNode);
                List<Integer> nextQueueItem = new ArrayList<>();
                nextQueueItem.add(curQuality + (isVisited ? 0 : values[nextNode]));
                nextQueueItem.add(curTime + nextTime);
                nextQueueItem.add(nextNode);
                nextQueueItem.addAll(visited);
                queue.offer(nextQueueItem);
            }
        }

    return maxQuality;
    }
    public static void main(String[] args) {
        MaximumPathQualityofaGraph_2065 maximumPathQualityofaGraph = new MaximumPathQualityofaGraph_2065();
//        int maxQuality =  maximumPathQualityofaGraph.maximalPathQuality(new int[]{0,32,10,43}, new int[][]{{0,1,10},{1,2,15},{0,3,10}}, 49);
//        int maxQuality =  maximumPathQualityofaGraph.maximalPathQuality(new int[]{5,10,15,20}, new int[][]{{0,1,10},{1,2,10},{0,3,10}}, 30);
//        int maxQuality =  maximumPathQualityofaGraph.maximalPathQuality(new int[]{1,2,3,4}, new int[][]{{0,1,10},{1,2,11},{1,3,13}}, 50);
//        int maxQuality =  maximumPathQualityofaGraph.maximalPathQuality(new int[]{0,1,2}, new int[][]{{1,2,10}}, 10);

        //Expected 61 but output is 50
        int maxQuality =  maximumPathQualityofaGraph.maximalPathQuality(new int[]{8,16,26,11,6}, new int[][]{{1,2,36},{0,3,75},{2,3,10},{0,2,18},{0,4,11},{2,4,19},{3,4,41},{0,1,10},{1,3,48}}, 76);
        System.out.println(maxQuality);
    }
}
