public class D_02_Push_Dominos {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        String dominoes1 = "RR.L";
        String dominoes2 = ".L.R...LR..L..";
        
        // Output results
        System.out.println("Input: " + dominoes1);
        System.out.println("Output: " + solution.pushDominoes(dominoes1));
        
        System.out.println("Input: " + dominoes2);
        System.out.println("Output: " + solution.pushDominoes(dominoes2));
    }

    static class Solution {
        public String pushDominoes(String dominoes) {
            char[] doms = dominoes.toCharArray();
            int last_R = -1, last_L = -1, n = doms.length;

            for (int i = 0; i < n; i++) { // "" for all 3 cases covered
                if (doms[i] == 'R') {
                    if (last_R != -1 && last_R > last_L) { // case- "..L..R..."
                        int k = last_R + 1;
                        while (k < i) doms[k++] = 'R';
                    }
                    last_R = i;
                } else if (doms[i] == 'L') {
                    if (last_R == -1 || last_L > last_R) { // case- "..L.."
                        for (int k = last_L + 1; k < i; k++) // start from 0 or last seen L
                            doms[k] = 'L';
                    } else { // case- "..R...L.."
                        int r = last_R + 1, l = i - 1;
                        while (r < l) {
                            doms[r++] = 'R';
                            doms[l--] = 'L';
                        }
                    }
                    last_L = i;
                }
            }
            if (last_R > last_L) { // case- "..R..."
                while (last_R < n) doms[last_R++] = 'R'; // update till end
            }
            return new String(doms);
        }
    }
}
