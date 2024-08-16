class Solution:
    def maxDistance(self, arrays: List[List[int]]) -> int:
        maxi=arrays[0][-1]
        mini=arrays[0][0]
        max_distance=0
        for i in range(1,len(arrays)):
                max_distance=max(max_distance,abs(arrays[i][-1]-mini),abs(maxi-arrays[i][0]))
                maxi=max(maxi,arrays[i][-1])        
                mini=min(mini,arrays[i][0])

        return max_distance