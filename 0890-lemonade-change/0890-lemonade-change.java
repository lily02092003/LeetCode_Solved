class Solution {
    public boolean lemonadeChange(int[] bills) {
        int total_five=0;
        int total_ten=0;
        for(int i:bills){
            if(i==5){
                total_five++;
            }
            else if(i==10){
                if(total_five>0){
                    total_five--;
                    total_ten++;
                }else{
                    return false;
                }
            }else if(i==20){
                if(total_ten>0 && total_five>0){
                    total_ten--;
                    total_five--;
                }else if(total_five>=3){
                    total_five-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}