class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int length=nums.length;
        int[] min=new int[length];

        int tempMin=nums[length-1];
        for(int i=length-1;i>=0;i--){
            tempMin=Math.min(tempMin,nums[i]);
            min[i]=tempMin;

            
        }

        int max=nums[0];


        for(int i=0;i<length;i++){

            max=Math.max(max,nums[i]);
            if(max-min[i]<=k){
                return i;
            }


        }




        return -1;
        
    }
}