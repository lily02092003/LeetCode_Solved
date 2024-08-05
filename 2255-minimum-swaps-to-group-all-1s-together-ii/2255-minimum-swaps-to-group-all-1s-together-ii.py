class Solution:
    def minSwaps(self, nums: List[int]) -> int:
        k=sum(nums)
        n=len(nums)
        mx=cnt=sum(nums[:k])
        for i in range(k,n+k):
            cnt+=nums[i%n]
            cnt-=nums[(i-k+n)%n]
            mx=max(mx,cnt)
        return k-mx