class Solution {
    public void reverse(int start,int end,int[] nums){
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }
    public void nextPermutation(int[] a) {
        //finding the break point
        int ind=-1;
        int n=a.length;
        for(int i=n-2;i>=0;i--){
            if(a[i]<a[i+1]){
                ind=i;
                break;
            }
        }
        if(ind==-1){
            reverse(0,n-1,a);
            return;
        }
        //find the next greater number of element in index position
        for(int i=n-1;i>=ind;i--){
            if(a[i]>a[ind]){
                int temp=a[i];
                a[i]=a[ind];
                a[ind]=temp;
                break;
            }
        }
        reverse(ind+1,n-1,a);
    }
}