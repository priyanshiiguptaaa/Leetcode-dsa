class Solution {
    public String convert(String s, int numRows) {
        int length = s.length();
        if (numRows == 1 || numRows == length) return s;
        char[] ans = new char[length];
        int count = 0;
        int inc = 2 * (numRows - 1);

        for (int i = 0; i < numRows; i++) { //fill one row at a time
            int j = i;
            while (j < length) {
                ans[count++] = s.charAt(j);
                if (i == 0 || i == numRows - 1) j += inc; //first and last rows don't have diagonal elements, so do full increments without worrying
                else {
                    j += (inc - (2 * i)); //if there is/are diagonal element(/s) in the row, then use this formula to get the next diagonal element
                    if (j < length) { //if index is in the bounds, then put that element in the answer array, andincrement j for the next diagonal element
                        ans[count++] = s.charAt(j);
                        j += (2 * i);
                    }
                }
            }
        }

        return String.valueOf(ans);
    }
}
