class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Stack<Integer> st = new Stack<>();
        int n = positions.length;
        Integer[] ind = new Integer[n];

        for (int i = 0; i < n; i++) {
            ind[i] = i;
        }

        Arrays.sort(ind, new Comparator<Integer>() {
            public int compare(Integer m1, Integer m2) {
                return Integer.compare(positions[m1], positions[m2]);
            }
        });

        for (int i : ind) {
            if (directions.charAt(i) == 'R') {
                st.push(i); // Push index instead of health
            } else {
                while (!st.isEmpty() && healths[i] > 0) {
                    int topIndex = st.peek();
                    if (healths[topIndex] < healths[i]) {
                        healths[i]--;
                        healths[topIndex] = 0;
                        st.pop();
                    } else if (healths[topIndex] > healths[i]) {
                        healths[topIndex]--;
                        healths[i] = 0;
                    } else {
                        healths[topIndex] = 0;
                        healths[i] = 0;
                        st.pop();
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < healths.length; i++) {
            if (healths[i] != 0) {
                ans.add(healths[i]);
            }
        }
        return ans;
    }
}