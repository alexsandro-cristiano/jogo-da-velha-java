package layerboard;

public class Board {
    
    private char[][] board;
    private int turn;
    
    public Board (){ }
    
    public Board(int value){
        this.board = new char [3][3];
        this.turn = value;
        startBoard();
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
        
    private void startBoard(){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                board[i][j] = ' ';
            }
        }
    }
    
    private boolean verificarEspacoLivre(int linha,int coluna){        
        return board[linha][coluna]== ' ';
    }
    
    public boolean  validarJogada(int linha,int coluna, char sinal){
        if(verificarEspacoLivre(linha, coluna)){
            board[linha][coluna] = sinal;
            turn++;
            return true;
        }
        return false;
    }
    
    public void showBoard(){
        for (char[] board1 : board) {
            for (int j = 0; j<board.length; j++) {
                System.out.print(board1[j] + " | ");
            }
            System.out.println();
        }
    }
    
    public boolean verificarGanhador(char sinal){
        if ((board[0][0] == sinal) && (board[0][1] == sinal) && (board[0][2] == sinal)//linha 1
                || (board[1][0] == sinal) && (board[1][1] == sinal) && (board[1][2] == sinal) //linha 2
                || (board[2][0] == sinal) && (board[2][1] == sinal) && (board[2][2] == sinal)//linha 3
                || (board[0][0] == sinal) && (board[1][0] == sinal) && (board[2][0] == sinal)//coluna 1
                || (board[0][1] == sinal) && (board[1][1] == sinal) && (board[2][1] == sinal)//coluna 2
                || (board[0][2] == sinal) && (board[1][2] == sinal) && (board[2][2] == sinal)//coluna 3
                || (board[0][0] == sinal) && (board[1][1] == sinal) && (board[2][2] == sinal)// diagonal
                || (board[0][2] == sinal) && (board[1][1] == sinal) && (board[2][0] == sinal)//diagonal inversa
                ) {
            return true;
        }
        return false;
    }
    
}