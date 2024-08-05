class Solution {
    boolean ispalindrome(String s,int l,int h){
        while(l<h){
            if(s.charAt(l)!=s.charAt(h)){
                return false;
            }
            l++;
            h--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int up=0;
        int l=0;
        int maxdiff=0;
        if(s.length()==0){
            return "";
        }
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(ispalindrome(s,i,j)){
                    if((j-i)>maxdiff){
                        l=i;
                        up=j;
                        maxdiff=j-i;
                    }

                }
            }
        }
        String ans=s.substring(l,up+1);
        return ans;
    }
}