package main.Peças;
import main.Peca;
import main.Tabuleiro;

public class Torre extends Peca{

    public Torre(boolean cor, int lin, int col) {
        super(cor, lin, col);
        if(cor)
            Tabuleiro.getCasa(lin, col).setPeca('♖');
        else
            Tabuleiro.getCasa(lin, col).setPeca('♜');
    }
}
