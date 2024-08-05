class Solution:
    def kthDistinct(self, arr: List[str], k: int) -> str:
        d={}
        for i in arr:
            if i in d:
                d[str(i)]+=1
            else:
                d[str(i)]=1
        l=[i for i in d if d[i]==1]
        if(len(l)<k):
            return ""
        return l[k-1]
        

        