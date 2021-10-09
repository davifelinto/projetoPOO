package main;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import main.Peças.*;

public class Jogo {
    public static void main(String[] args) throws IOException {
        int lin = 0, col = 0, index = 0, indexMove = 0, leOperacoes = 0;
        Scanner ler = new Scanner(System.in);
        List<Movimento> moveValido = null;
        boolean verificouCheque = false;
        boolean isCheque = false;
        boolean flag = true;
        char c;
        
        do{
            Tabuleiro.limpaTela();
            System.out.println("Deseja continuar um jogo salvo(s) ou iniciar um novo(n)?");
            c = ler.next().charAt(0);
            if(c == 'n'){
                Tabuleiro.carregaTabuleiro("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");//inicia o tabuleiro nesta posicao
                flag= !flag;
            }
            else if (c == 's'){
                Tabuleiro.carregaTabuleiro(Tabuleiro.leTabuleiro());//inicia tabuleiro com o que ta salvo no arquivo
                flag= !flag;
            }
        } while (flag);
        
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
                    case 9:
                        Tabuleiro.gravaTabuleiro(Tabuleiro.tabuleiroParaString(ControlaJogo.isTurno_Branco()));
                        
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
                        
                        // capturas en passant - não funcionando
                        /*
                        else if(move.getCasaInicial().getObj_peca().verifica_peao() && (move.getCasaInicial().getObj_peca().getPosicao().getLinha() == 1 || move.getCasaInicial().getObj_peca().getPosicao().getLinha() == 6)){
                            Casa casa = new Casa(lin, col, c);
                            casa = move.getCasaDestino();
                            casa.setColuna(casa.getColuna()-1);
                            if(casa.getColuna() > 0 && casa.getObj_peca() != null)
                                Tabuleiro.getSetPecas(!(ControlaJogo.isTurno_Branco())).remove(casa.getObj_peca());
                            else
                                casa.setColuna(casa.getColuna()+2);
                            if(casa.getColuna()<8&& casa.getObj_peca() != null)
                                Tabuleiro.getSetPecas(!(ControlaJogo.isTurno_Branco())).remove(casa.getObj_peca());
                        }
                        */

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
        ler.close();
    }
}