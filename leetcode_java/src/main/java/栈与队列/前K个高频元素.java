package 栈与队列;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 前K个高频元素 {

    public static void main(String[] args) {
        int[] rs = new 前K个高频元素().topKFrequent(new int[]{1,1,1,2,2,3},2);

        for(int i = 0;i<rs.length;i++){
            System.out.println(rs[i]);
        }
    }

    /**
     * 优先级队列
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            queue.offer(entry);
            if(queue.size() > k){
                queue.poll();
            }
        }

        for(int i = k - 1;i>= 0;i--){
            result[i] = queue.poll().getKey();
        }
        return result;
    }

}
