class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String,Integer>> st=new Stack();
        int i=0;
        st.push(new HashMap<>());
        int n=formula.length();
        while(i<n){
            if(formula.charAt(i)=='('){
                st.push(new HashMap<>());
                i++;
            }
            else if(formula.charAt(i)==')'){
                Map<String,Integer> top=st.pop();
                i++;
                int start=i;
                int multiplier;
                while(i<n && Character.isDigit(formula.charAt(i))){
                    i++;
                }
                if(i>start){
                    multiplier=Integer.parseInt(formula.substring(start,i));
                }else{
                    multiplier=1;
                }
                for (String atom : top.keySet()) {
                    top.put(atom, top.get(atom) * multiplier);
                }
                Map<String, Integer> peek = st.peek();
                for (String atom : top.keySet()) {
                    peek.put(atom, peek.getOrDefault(atom, 0) + top.get(atom));
                }             
            }else{
                int start=i;
                i++;
                while(i<n && Character.isLowerCase(formula.charAt(i))){
                    i++;
                }
                String element=formula.substring(start,i);
                start=i;
                while(i<n && Character.isDigit(formula.charAt(i))){
                    i++;
                }
                int multiplier;
                if(i>start){
                    multiplier=Integer.parseInt(formula.substring(start,i));
                }else{
                    multiplier=1;
                }
                Map<String, Integer> peek = st.peek();
                peek.put(element, peek.getOrDefault(element, 0) + multiplier);
            }
        }
        Map<String,Integer> result=st.pop();
        List<String> elements=new ArrayList<>(result.keySet());
        StringBuilder ans=new StringBuilder();
        Collections.sort(elements);
        for(String element: elements){
            ans.append(element);
            int count=result.get(element);
            if(count>1){
                ans.append(count);
            }
        }
        return ans.toString();
    }
}