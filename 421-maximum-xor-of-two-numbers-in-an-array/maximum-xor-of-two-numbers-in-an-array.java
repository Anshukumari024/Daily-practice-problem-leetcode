class Solution {

    class Trie {

        class Node {
            Node zero;
            Node one;
        }

        private Node root = new Node();

        public void add(int val) {
            Node curr = root;

            for (int i = 31; i >= 0; i--) {
                int bit = (val >> i) & 1;

                if (bit == 0) {
                    if (curr.zero == null) {
                        curr.zero = new Node();
                    }
                    curr = curr.zero;
                } else {
                    if (curr.one == null) {
                        curr.one = new Node();
                    }
                    curr = curr.one;
                }
            }
        }

        public int getMaxXOR(int x) {
            int ans = 0;
            Node curr = root;

            for (int i = 31; i >= 0; i--) {
                int bit = (x >> i) & 1;

                if (bit == 0) {
                    if (curr.one != null) {
                        ans |= (1 << i);
                        curr = curr.one;
                    } else {
                        curr = curr.zero;
                    }
                } else {
                    if (curr.zero != null) {
                        ans |= (1 << i);
                        curr = curr.zero;
                    } else {
                        curr = curr.one;
                    }
                }
            }

            return ans;
        }
    }
 public int findMaximumXOR(int[] arr) {
        Trie t = new Trie();

        for (int x : arr) {
            t.add(x);
        }

        int ans = 0;

        for (int x : arr) {
            ans = Math.max(ans, t.getMaxXOR(x));
        }

        return ans;
    }
}