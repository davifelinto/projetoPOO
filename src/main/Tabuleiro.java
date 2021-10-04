package main;

import java.util.ArrayList;
import java.util.List;

import main.Peças.*;

public class Tabuleiro {
    private static Casa[][] casa = new Casa[8][8];
    private static List<Peca> pecasBrancas = new ArrayList<>();
    private static List<Peca> pecasPretas = new ArrayList<>();

    //Getters and setters
    public static List<Peca> getSetPecas(boolean cor_Branca) {
        if(cor_Branca)
            return pecasBrancas;
        else
            return pecasPretas;
    }
    public static Casa getCasa(int lin, int col) {
        return casa[lin][col];
    }
    public static void setCasa(Casa peca, int lin, int col) {
        Tabuleiro.casa[lin][col] = peca;
    }   
    
    //Metodos
    public static void carregaTabuleiro(String n){
        char notacao[] = n.toCharArray();
        boolean flag = true;
        int col = 0, lin = 0;

        for(char i : notacao){
            if(flag){
                if(Character.isLetter(i)){
                    Casa novaCasa = new Casa(lin, col, i);
                    casa[lin][col] = novaCasa;
                    casa[lin][col].setObj_peca(instanciaPeca(i, lin, col));
                    col++;
                }else if(i == '/'){
                    lin++;
                    col = 0;
                }else if(Character.isDigit(i)){
                    int max = col + Character.getNumericValue(i);
                    for(; col < max; col++){
                        Casa novaCasa = new Casa(lin, col, ' ');
                        casa[lin][col] = novaCasa;
                    }
                }else if(i == ' '){
                    flag = false;
                }
            }else{
                switch (i) {
                    case 'w':
                        ControlaJogo.setTurno_Branco(true);
                        break;
                    case 'b':
                        ControlaJogo.setTurno_Branco(false);
                        break;
                    case 'K':
                        ControlaJogo.setRoque_Rei_b(true);
                        break;
                    case 'Q':
                        ControlaJogo.setRoque_Dama_b(true);
                        break;
                    case 'k':
                        ControlaJogo.setRoque_Rei_p(true);
                        break;
                    case 'q':
                        ControlaJogo.setRoque_Dama_p(true);     
                        break;               
                    default:
                        break;
                }
            }
        }
        ControlaJogo.fen_Atual = n;
    }
    public static void gravaTabuleiro(){
        //Funcao para salvar a partida; 

    }
    public static Peca instanciaPeca(char p, int lin, int col){
        boolean corB;
        Peca peca;
        if(Character.isLowerCase(p))
            corB = false;
        else
            corB = true;
        switch (Character.toLowerCase(p)){
            case 'p':
                peca = new Peao(corB, lin, col);
                break;
            case 'r':
                peca = new Torre(corB, lin, col);
                break;
            case 'n':
                peca = new Cavalo(corB, lin, col);
                break;
            case 'b':
                peca = new Bispo(corB, lin, col);
                break;
            case 'q':
                peca = new Dama(corB, lin, col);
                break;
            case 'k':
                peca = new Rei(corB, lin, col);
                break;
            default:
                peca = null;
                break;
        }
        adicionarPecaLista(peca);
        return peca;
    }
    public static void adicionarPecaLista(Peca p){
        if(p.isCor_Branca())
            getSetPecas(true).add(p);
        else
            getSetPecas(false).add(p);
    }
    public static void limpaTela (){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void limpaMovimentos(){
        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++)
                if(Tabuleiro.getCasa(i, j).getPeca() == '.')
                    Tabuleiro.getCasa(i, j).setPeca(' ');
    }
    public static void imprimeTabuleiro(boolean turn_W, int lin, int col){
            int cor = 0;
            if(turn_W)
                //tabuleiro branco
                for(int i = 0; i < 8; i++){
                    for(int j = 0; j < 8; j++){
                        if(i == lin && j == col)
                            System.out.print("\u001B[32m");
                        else
                            if(Character.isUpperCase(Tabuleiro.getCasa(i, j).getPeca()))
                                System.out.print("\u001B[37m");
                            else
                                System.out.print("\u001B[30m");
                        System.out.print(Tabuleiro.getCasa(i, j).getPeca() + " ");
                    }
                    System.out.println();
                    cor = (cor == 0) ? 1 : 0;
                }
            else
                //tabuleiro preto
                for(int i = 7; i >= 0; i--){
                    for(int j = 7; j >= 0; j--){
                        if(i == lin && j == col)
                            System.out.print("\u001B[32m");
                        else
                            if(Character.isUpperCase(Tabuleiro.getCasa(i, j).getPeca()))
                                System.out.print("\u001B[37m");
                            else
                                System.out.print("\u001B[30m");
                        System.out.print(Tabuleiro.getCasa(i, j).getPeca() + " ");
                    }   
                    System.out.println();     
                }
            System.out.print("\u001B[0m");
        }
    
}