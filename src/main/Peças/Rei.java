package main.Peças;
import java.util.ArrayList;
import java.util.List;

import main.Movimento;
import main.Peca;
import main.Tabuleiro;

public class Rei extends Peca{

    public Rei(boolean cor, int lin, int col) {
        super(cor, lin, col);
        //if(cor)
        //    Tabuleiro.getCasa(lin, col).setPeca('♔');
        //else
        //    Tabuleiro.getCasa(lin, col).setPeca('♚');
    }

    @Override
    public List<Movimento> movimentosValidos() {
        List<Movimento> moveValido = new ArrayList<>();
        int[] lin_k = {1, 1, 1, 0, 0, -1, -1, -1};
        int[] col_k = {-1, 0, 1, -1, 1, -1, 0, 1};
        for(int i = 0; i < 8; i++){
            int lin = this.getPosicao().getLinha() + lin_k[i];
            int col = this.getPosicao().getColuna() + col_k[i];
            if(col < 8 && col >= 0 && lin < 8 && lin >= 0){
                if(eInimigo(this.getPosicao().getPeca(), Tabuleiro.getCasa(lin, col).getPeca())){
                    Movimento move = new Movimento(this.getPosicao(), Tabuleiro.getCasa(lin, col), this
                    ,Tabuleiro.getCasa(lin, col).getObj_peca());
                    moveValido.add(move);
                }else 
                if(Tabuleiro.getCasa(lin, col).getPeca() == ' '){
                    Movimento move = new Movimento(this.getPosicao(), Tabuleiro.getCasa(lin, col), this);
                    moveValido.add(move);
                }
            }
        }
        return moveValido;
    }
}
