package week11;

public class TokenPass {
    private int[] board;
    private int currentPlayer;

    //Part A
    public TokenPass(int playerCount){
        board = new int[playerCount];
        currentPlayer = (int)(Math.random()*playerCount);
        
        for(int i = 0; i < board.length; i++){
            board[i] = (int)(Math.random()*10)+1;
        }
        
    }


    //Part B
    public void distributeCurrentPlayerTokens(){
        int tokensLeft = board[currentPlayer];
        board[currentPlayer] = 0;
        int player = currentPlayer + 1;
        while(tokensLeft > 0){
            if(player == board.length)
                player = 0;
            board[player]++;
            tokensLeft--;
        }
    }
}
