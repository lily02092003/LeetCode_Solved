class Solution {
    public int minimumPushes(String word) {
        int[] nums=new int[26];

        for(char c:word.toCharArray()){
            nums[c-'a']++;
        }
        Integer[] freq=new Integer[26];
        for(int i=0;i<26;i++){
            freq[i]=nums[i];
        }

        Arrays.sort(freq,Collections.reverseOrder());
        int minpush=0;
        for(int i=0;i<26;i++){
            if(freq[i]==0){
                break;
            }
            minpush+=((i/8)+1)*freq[i];
        }
        return minpush;
    }
}