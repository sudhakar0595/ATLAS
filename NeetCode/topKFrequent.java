class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for(int i= 0; i<nums.length; i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i], 0);
            }
            hm.put(nums[i],hm.get(nums[i])+1);
        }
         System.out.println(hm);
         int[] ans = new int[k];
        
        //System.out.println(max);
        for(int j=0; j<k; j++){
            int max = Collections.max(hm.values());
            for(HashMap.Entry<Integer, Integer> entry: hm.entrySet())
            {
                if(entry.getValue() == max) 
                {
                    ans[j] = entry.getKey();
                    hm.remove(entry.getKey());
                    break;
                }
            }
        
        }return ans;
    }
}