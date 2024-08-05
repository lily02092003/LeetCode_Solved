class Solution(object):
    def rangeSum(self, nums, n, left, right):
        l=[]
        for i in range(n):
            for j in range(i+1,n+1):
                s=0
                s=sum(nums[i:j])
                l.append(s)
        print(l)
        l.sort()
        s=sum(l[left-1:right])%(pow(10,9)+7)
        return s
