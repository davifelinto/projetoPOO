package main;
// import java.awt.event.KeyListener;
import java.util.Scanner;

public class Jogo /*implements KeyListener*/ {
    public static void main(String[] args) {
        int lin = 6, col = 0, index = 0;
        Scanner ler = new Scanner(System.in);
        Tabuleiro.carregaTabuleiro("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq");//inicia o tabuleiro nesta posicao
        while(true){
            Tabuleiro.limpaTela();
            Tabuleiro.imprimeTabuleiro(ControlaJogo.isTurno_Branco(), lin, col);
            if(ler.nextInt() == 6){
                index++;
            }else
                index--;
            //clicar enter para selecionar peca
                //criar uma lista de movimentos possiveis para ir iterando por ela
                //imprimir tabuleiro com movimentos possiveis e destacar a casa que voce esta selecionando
                //clica enter para confirmar selecao
                    //adiciona o movimento feito dentro do ControlaJogo.pgn, faz as alterações no tabuleiro, na/nas peca/pecas e nas casas;]
                    //ControlaJogo.setTurnoBranco() = !ControlaJogo.isTurno_Branco(); //alterna o turno das pecas
            Peca peca = Tabuleiro.getSetPecas(ControlaJogo.isTurno_Branco()).get(index);
            lin = peca.getPosicao().getLinha();
            col = peca.getPosicao().getColuna();
            
        }
    }
    /**
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
            movimento.left = true;
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
            movimento.right = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
            player.left = false;
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
            player.right = false;
        }
    }
**/
}