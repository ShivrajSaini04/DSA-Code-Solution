class Pair{
    int key ;
    int freq;
    Pair(int key , int freq){
        this.key = key;
        this.freq = freq;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Pair> maxheap = new PriorityQueue<>( ( a, b) -> b.freq - a.freq);
        for(int ele : nums) map.put(ele, map.getOrDefault(ele, 0) + 1);

        for(int key : map.keySet()) {
              maxheap.add(new Pair(key , map.get(key)));
        }

        for (int i=0;i<k;i++){
            Pair top = maxheap.poll();
            res[i] = top.key;
        }
      return res;

    }
}