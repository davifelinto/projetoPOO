package main;
import java.util.List;
import java.util.Scanner;
import main.Peças.*;

public class Jogo {
    public static void main(String[] args) {
        int lin = 0, col = 0, index = 0, indexMove = 0, leOperacoes = 0;
        Scanner ler = new Scanner(System.in);
        List<Movimento> moveValido = null;
        boolean verificouCheque = false;
        boolean isCheque = false;
        
        Tabuleiro.carregaTabuleiro("r1bqkbnr/pppp1ppp/8/4p2Q/2BnP3/8/PPPP1PPP/RNB1K1NR w KQkq - 4 4");//inicia o tabuleiro nesta posicao
        while(true){
            Peca rei = null;
            Tabuleiro.limpaTela();
            List<Peca> setdePecas = Tabuleiro.getSetPecas(ControlaJogo.isTurno_Branco());
            Peca peca = setdePecas.get(index);
            for(Peca procuraRei : setdePecas){
                if(procuraRei instanceof Rei){
                    rei = procuraRei;
                    break;
                }
            }
            if(!verificouCheque){
                isCheque = rei.verificaAtaque();
                verificouCheque = true;
                if(isCheque){//Se o seu rei estiver em cheque verifica se está em mate6
                    for(Peca pecaVerifica : setdePecas){
                        moveValido = pecaVerifica.filtraLista(rei);
                        if(!moveValido.isEmpty())
                            break;
                    }
                    if(moveValido.isEmpty()){
                        System.out.println("Chequemate");
                        break;
                    }
                }
            }
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
            Tabuleiro.imprimeTabuleiro(lin, col, isCheque, rei);
            if(leOperacoes != 5){
                leOperacoes = ler.nextInt();
                switch (leOperacoes) {
                    case 6:
                        index = (index + 1) % setdePecas.size();
                        break;
                    case 2:
                        index+=8;
                        if(index > setdePecas.size()){
                            index = index % setdePecas.size();
                        }
                        break;
                    case 8:
                        index-=8;
                        if(index < 0){
                            index = 0; 
                        }
                        break;
                    case 4:
                        index--;
                        if(index < 0)
                            index = setdePecas.size()-1;
                        break;
                    case 5:
                        moveValido = peca.filtraLista(rei);
                        for(Movimento move : moveValido){
                            if(move.getCasaDestino().getPeca() == ' ')
                                move.getCasaDestino().setPeca('.');
                        }
                    break;
                }
            }else{
                switch(ler.nextInt()) {
                    case 6:
                        indexMove = (indexMove + 1) % moveValido.size();
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
                        Movimento move = moveValido.get(indexMove);
                        peca.setPosicao(move.getCasaDestino());
                        if(move.getCasaDestino().getObj_peca() != null)
                            Tabuleiro.getSetPecas(!(ControlaJogo.isTurno_Branco())).remove(move.getCasaDestino().getObj_peca());//remove a peca da lista adversaria 
                        move.getCasaDestino().setObj_peca(peca);
                        move.getCasaInicial().setObj_peca(null);
                        move.getCasaDestino().setPeca(move.getCasaInicial().getPeca());
                        move.getCasaInicial().setPeca(' ');
                        ControlaJogo.adicionarMovimento(move);
                        ControlaJogo.setTurno_Branco(!ControlaJogo.isTurno_Branco());
                        index = 0;
                        indexMove = 0;
                        verificouCheque = false;
                        break;
                }
            }
        }
    }
}