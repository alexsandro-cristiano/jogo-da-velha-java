package application;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        char[][] board = new char[3][3]; //declarando matriz e instanciando a matriz 3x3
        boolean win = false;
        
        System.out.println("Jogador 1 = X");
        System.out.println("Jogador 2 = O");
        
        //iniciar tabuleiro
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                board[i][j] = ' ';
            }
        }
        /*
            loop do jogo
                pedir para entrar com uma jogada
                ler informacao
                verificar se espaco esta livre
                    sim - adiciona valor
                    nao - da erro e apresenta de novo
                como finalizar o jogo (?)
        */
        
        int turn = 1;
        char sinal;
        int linha=0,coluna=0;
        System.out.println();
        while(!win){
            //Verificando de quem é a vez
            if(turn % 2 == 1) {
                System.out.println("Jogador 1. Escolha a linha e coluna (1-3).");
                sinal = 'X';
            } else {
                System.out.println("Jogador 2.  Escolha a linha e coluna (1-3).");
                sinal = 'O';
            }
            
            //Lendo Linha
            boolean linhaValida = false;
            while(!linhaValida){
                System.out.print("Informe linha: ");
                linha = input.nextInt();
                if(linha >= 1 && linha < 4){
                    linhaValida = true;
                }else{
                    System.out.println("Linha Invalida. Tente Novamente");
                }
            }
            //Lendo Coluna
            boolean colunaValida = false;
            while(!colunaValida){
                System.out.print("Informe coluna: ");
                coluna = input.nextInt();
                if(coluna >= 1 && coluna < 4){
                    colunaValida = true;
                }else{
                    System.out.println("Coluna Invalida. Tente Novamente");
                }
            }
            --linha;
            --coluna;
            if(board[linha][coluna] == ' '){
                board[linha][coluna] = sinal;
                turn++;
            }else{
                System.out.println("Posição já usada. Tente Novamente");
            }
            
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board.length; j++){
                    System.out.print(board[i][j] + " | ");
                }
                System.out.println();
            }
            
            if((board[1][1] == 'X')&&(board[1][2] == 'X')&&(board[1][3] == 'X')||
               (board[2][1] == 'X')&&(board[2][2] == 'X')&&(board[2][3] == 'X')||
               (board[3][1] == 'X')&&(board[3][2] == 'X')&&(board[3][3] == 'X')||
               (board[1][1] == 'X')&&(board[2][1] == 'X')&&(board[3][1] == 'X')||
               (board[1][2] == 'X')&&(board[2][2] == 'X')&&(board[3][2] == 'X')||
               (board[1][3] == 'X')&&(board[2][3] == 'X')&&(board[3][3] == 'X')) {
                
                System.out.println("Game 1 is Winner!");
                
            }else if((board[1][1] == 'O')&&(board[1][2] == 'O')&&(board[1][3] == 'O')||
                    (board[2][1] == 'O')&&(board[2][2] == 'O')&&(board[2][3] == 'O')||
                    (board[3][1] == 'O')&&(board[3][2] == 'O')&&(board[3][3] == 'O')||
                    (board[1][1] == 'O')&&(board[2][1] == 'O')&&(board[3][1] == 'O')||
                    (board[1][2] == 'O')&&(board[2][2] == 'O')&&(board[3][2] == 'O')||
                    (board[1][3] == 'O')&&(board[2][3] == 'O')&&(board[3][3] == 'O')) {

            }else {
                System.out.println("No Winner!");
            }
        }
        
    }
}
