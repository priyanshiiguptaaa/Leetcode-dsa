class Solution {
    ArrayList<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        int l = digits.length();
        if(l == 0) return ans;
        HashMap<Character , String> hp = new HashMap<>();
        hp.put('2' , "abc");
        hp.put('3' , "def");
        hp.put('4' , "ghi");
        hp.put('5' , "jkl");
        hp.put('6' , "mno");
        hp.put('7' , "pqrs");
        hp.put('8' , "tuv");
        hp.put('9' , "wxyz");
        String temp = "";
        helper(0 , digits, temp , hp);
        return ans;
    }

    public void helper(int idx , String digits , String temp , HashMap<Character , String> hp){
            int l = digits.length();
            if(idx >= l){
                ans.add(temp);
                return;
            }
            char ch = digits.charAt(idx);
            String phone = hp.get(ch);
            for(int i = 0 ; i < phone.length(); i++){
                helper(idx + 1 , digits , temp + phone.charAt(i) , hp);
            }
        }
}
