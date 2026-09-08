class Solution {
    public int lengthOfLastWord(String s) {
        int n=s.length(),len=0;
        boolean untilSpace=false;
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) != ' '){
                len++;
                untilSpace=true;
            }
            else if(untilSpace)
            break;
        }
        return len;
        
    }
}