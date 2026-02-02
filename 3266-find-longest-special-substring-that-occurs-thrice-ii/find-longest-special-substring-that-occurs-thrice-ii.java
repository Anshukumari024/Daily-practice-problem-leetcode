class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int[][] matrix = new int[26][n + 1];
        char prevChar = s.charAt(0);
        int length = 0;
        for (int i = 0; i < n; i++) {
            char currChar = s.charAt(i);

            if (currChar == prevChar) {
                length += 1;
                matrix[currChar - 'a'][length] += 1;
            } else {
                length = 1;
                matrix[currChar - 'a'][length] += 1;
                prevChar = currChar;
            }
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            int cumSum = 0;
            for (int j = n; j >= 1; j--) {
                cumSum += matrix[i][j];
                if (cumSum >= 3) {
                    result = Math.max(result, j);
                    break;
                }
            }
        }

        return result == 0 ? -1 : result;
    }
}