package problem;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        Map<Character,Integer>  row = new HashMap<>();
        Map<Character,Integer>  col = new HashMap<>();
        Map<Character,Integer>[]  box = new HashMap[9];
        for(int i = 0;i < 9;i++){
            box[i] = new HashMap<>();
        }
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] != '.'){
                    //当board[i][j] ！=‘.’
                    row.put(board[i][j],row.getOrDefault(board[i][j],0)+1);
                    if(board[j][i] != '.'){ //但是board[j][i] != '.' 也必须判断不为空，但是如果
                        col.put(board[j][i],col.getOrDefault(board[j][i],0)+1);
                    }

                    int index = (i/3)*3 + j/3;
                    box[index].put(board[i][j],box[index].getOrDefault(board[i][j],0)+1);
                    if(row.get(board[i][j]) > 1 ||  box[index].get(board[i][j]) > 1){
                        System.out.println(board[i][j]);
                        System.out.println(i);
                        System.out.println(j);
                        System.out.println(row.get(board[i][j]));
                        System.out.println(col.get(board[j][i]));
                        System.out.println(box[index].get(board[i][j]));
                        System.out.println(board[j][i]);
                        return false;
                    }
                    if(board[j][i] != '.' && col.get(board[j][i]) > 1){
                        return false;
                    }
                }
                if(board[j][i] != '.' && board[i][j] == '.'){
                    col.put(board[j][i],col.getOrDefault(board[j][i],0)+1);
                    if(board[j][i] != '.' && col.get(board[j][i]) > 1){
                        return false;
                    }
                }
            }
            col.clear();
            row.clear();
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'.','.','4','.','.','.','6','3','.'},
                            {'.','.','.','.','.','.','.','.','.'},
                            {'5','.','.','.','.','.','.','9','.'},
                            {'.','.','.','5','6','.','.','.','.'},
                            {'4','.','3','.','.','.','.','.','1'},
                            {'.','.','.','7','.','.','.','.','.'},
                            {'.','.','.','5','.','.','.','.','.'},
                            {'.','.','.','.','.','.','.','.','.'},
                            {'.','.','.','.','.','.','.','.','.'}};
        boolean result = isValidSudoku(board);
        System.out.println(result);
    }
}
