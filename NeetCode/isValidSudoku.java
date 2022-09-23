class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> sudo = new HashSet<>();
        int temp =0;
        for(int i = 0; i<9;  i++){
            for(int j = 0; j<9;  j++){
                if(sudo.contains(board[i][j])){
                    return false;
                }
                else if(board[i][j] != '.'){
                    sudo.add(board[i][j]);
                }
            }
            //sudo.forEach(System.out::print);
            //System.out.println();
            sudo.clear();
        }
        
        for(int i = 0; i<9;  i++){
            for(int j = 0; j<9;  j++){
                if(sudo.contains(board[j][i])){
                    return false;
                }
                else if(board[j][i] != '.'){
                    sudo.add(board[j][i]);
                }
            }
            //sudo.forEach(System.out::print);
            //System.out.println();
            sudo.clear();
        }
        
        for(int x = 0; x<9; x++){
                    int start = x/3 * 3;
                    int end = x%3 * 3;
                    System.out.println(start +" "+end);
                for(int i = 0; i<3;  i++){

                    for(int j = 0; j<3;  j++){
                        //System.out.println(board[i+start][j+end]);
                        if(sudo.contains(board[i+start][j+end])){
                            return false;
                        }
                        else if(board[i+start][j+end] != '.'){
                            sudo.add(board[i+start][j+end]);
                        }
                    }
                }
            //sudo.forEach(System.out::print);
                    //System.out.println();
                    sudo.clear();
            
            }
        
        return true;
    }
}