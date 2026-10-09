class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> res=new ArrayList<>();
      int top=0,botton=matrix.length-1;
      int left=0,right=matrix[0].length-1;
        while(top<=botton && left<=right){
            for(int i=left; i<=right; i++){
                res.add(matrix[top][i]);
            }
            top++;
            //right column
            for(int i=top; i<=botton; i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(top<=botton){
                // botton row
                for(int i=right; i>=left; i--){
                    res.add(matrix[botton] [i]);
                }
                botton--;
            
        }
        if(left<=right){
            // left column
            for(int i=botton; i>=top; i--){
                res.add(matrix[i][left]);
            }
            left++;
        }
        

    }
    return res;
}
}