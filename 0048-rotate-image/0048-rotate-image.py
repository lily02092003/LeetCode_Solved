class Solution(object):
    def rotate(self, a):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        n=len(a)
        for i in range(n):
            for j in range(i+1,n):
                a[i][j],a[j][i]=a[j][i],a[i][j]
        for i in range(len(a)):
            a[i].reverse()
        return a
        
