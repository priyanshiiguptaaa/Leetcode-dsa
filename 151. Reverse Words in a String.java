class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder rev = new StringBuilder();
        int n = words.length;
        for(int i = n - 1 ; i >= 0 ; i--){
            rev.append(words[i]);
            if(i != 0){
                rev.append(" ");
            }
        }
        return rev.toString();
    }
}
