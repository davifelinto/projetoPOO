package main;
import java.util.List;
import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        int lin = 0, col = 0, index = 0, indexMove = 0, leOperacoes = 0;
        Scanner ler = new Scanner(System.in);
        List<Movimento> moveValido = null;

        Tabuleiro.carregaTabuleiro("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");//inicia o tabuleiro nesta posicao
        while(true){
            Tabuleiro.limpaTela();
            Peca peca = Tabuleiro.getSetPecas(ControlaJogo.isTurno_Branco()).get(index);
            if(leOperacoes != 5){
                lin = peca.getPosicao().getLinha();
                col = peca.getPosicao().getColuna(); 
            }
            else{
                if(moveValido.size() == 0)
                    leOperacoes = 0;
                else{
                    Movimento move = moveValido.get(indexMove);
                    lin = move.getCasaDestino().getLinha();
                    col = move.getCasaDestino().getColuna();
                }
            }
            Tabuleiro.imprimeTabuleiro(ControlaJogo.isTurno_Branco(), lin, col);
            if(leOperacoes != 5){
                leOperacoes = ler.nextInt();
                switch (leOperacoes) {
                    case 6:
                        index++;
                        break;
                    case 4:
                        index--;
                        break;
                    case 5:
                        moveValido = peca.movimentosValidos();
                        for(Movimento move : moveValido){
                            if(move.getCasaDestino().getPeca() == ' ')
                                move.getCasaDestino().setPeca('.');
                        }
                    break;
                }
            }else{
                switch(ler.nextInt()) {
                    case 6:
                        indexMove++;
                        break;
                    case 4:
                        indexMove--;
                        if(indexMove < 0){
                            indexMove = 0;
                            leOperacoes = 0;
                            Tabuleiro.limpaMovimentos(); 
                        }
                        break;
                    case 5:
                        leOperacoes = 0;
                        Tabuleiro.limpaMovimentos();
                        index = 0;
                        Movimento move = moveValido.get(indexMove);
                        peca.setPosicao(move.getCasaDestino());
                        move.getCasaDestino().setObj_peca(peca);
                        move.getCasaInicial().setObj_peca(null);
                        move.getCasaDestino().setPeca(move.getCasaInicial().getPeca());
                        move.getCasaInicial().setPeca(' ');
                        if(move.getPecaCapturada() != null){
                            Tabuleiro.getSetPecas(ControlaJogo.isTurno_Branco()).remove(move.getPecaCapturada());
                        }
                        ControlaJogo.adicionarMovimento(move);
                        ControlaJogo.setTurno_Branco(!ControlaJogo.isTurno_Branco());
                    break;
                }
            }
        }
    }
}