package Porgrammers;

public class 가장큰정사각형찾기 {
    public int solution(int[][] board){
        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    answer = 1;
                    break;
                }
            }
            if (answer == 1)
                break;
        }
        if (answer == 0)
            return answer;
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++){
                if (board[i][j] == 1){
                    int min = Math.min(board[i][j - 1], board[i -1][j]);
                    min = Math.min(min, board[i - 1][ j - 1]);
                    min++;
                    board[i][j] = min;
                    if (min > answer)
                        answer = min;
                }
            }
        }
        return answer * answer;
    }
}
