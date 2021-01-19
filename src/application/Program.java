package application;

import java.util.Scanner;
import layerboard.Board;

public class Program {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Board board = new Board(1);
        boolean win = false;
        char sinal;
        int linha = 0, coluna = 0;

        System.out.println("Jogador 1 = X");
        System.out.println("Jogador 2 = O");
        
        while (!win) {

            if (board.turn % 2 == 1) {
                System.out.println("Jogador 1. Escolha a linha e coluna (1-3).");
                sinal = 'X';
            } else {
                System.out.println("Jogador 2. Escolha a linha e coluna (1-3).");
                sinal = 'O';
            }

            //Ler linha
            boolean linhaValida = false;
            while (!linhaValida) {
                System.out.print("Informe linha: ");
                linha = input.nextInt();
                if (linha >= 1 && linha < 4) {
                    linhaValida = true;
                } else {
                    System.out.println("Linha Invalida. Tente Novamente");
                }
            }

            //Ler coluna
            boolean colunaValida = false;
            while (!colunaValida) {
                System.out.print("Informe coluna: ");
                coluna = input.nextInt();
                if (coluna >= 1 && coluna < 4) {
                    colunaValida = true;
                } else {
                    System.out.println("Coluna Invalida. Tente Novamente");
                }
            }

            if (!board.validarJogada(--linha, --coluna, sinal)) {
                System.out.println("Posição já usada. Tente Novamente");
            }

            board.showBoard();
            win = board.verificarGanhador(sinal);
            if(win==true && sinal == 'X'){
                System.out.println("GAMER 1 IS WINNER!!");
            }
            else if(win==true && sinal == 'O'){
                System.out.println("GAMER 2 IS WINNER!!");
            }
        }
    }
}
