class Solution {
    public boolean isPalindrome(int x) {
      if(x<0){
        return false;
      }
      int n=x;
      int res=0;
      while(n>0){
        int d=n%10;
        res=res*10+d;
        n=n/10;
      }
      if(res==x){
        return true;

      }
      else{
        return false;
      }
        
    }
}