class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        for(int i = 0; i<nums.length-1; i++){
            int temp = nums[i];
            for(int j = i+1; j<nums.length; j++){
                temp = temp + nums[j];
                if(temp == target){
                    indices[0]  = i;
                    indices[1]  = j;
                    return indices;
                }
                temp = temp - nums[j];
            }
        }
        return indices;
    }
}