class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        long ans=0;
        int inc=0;
        int dec=0;
        for(int i=0;i<nums.length;i++){
            int diff=nums[i]-target[i];
            if(diff>0){
                if(inc<diff){
                    ans+=(diff-inc);
                }
                inc=diff;
                dec=0;
            }
            else if(diff<0){
                if(dec<-diff){
                    ans+=(-diff-dec);
                }
                dec=-diff;
                inc=0;
            }
            else{
                inc=0;
                dec=0;
            }
        }
        return ans;
    }
}