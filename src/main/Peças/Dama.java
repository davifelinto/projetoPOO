package main.Peças;
import java.util.ArrayList;
import java.util.List;

import main.Movimento;
import main.Peca;
import main.Tabuleiro;

public class Dama extends Peca{

    public Dama(boolean cor, int lin, int col) {
        super(cor, lin, col);
        //if(cor)
        //    Tabuleiro.getCasa(lin, col).setPeca('♕');
        //else
        //    Tabuleiro.getCasa(lin, col).setPeca('♛');
    }

    @Override
    public List<Movimento> movimentosValidos() {
        List<Movimento> moveValido = new ArrayList<>();
        //diagonal Nordeste 
        int col = this.getPosicao().getColuna()+1;
        int lin = this.getPosicao().getLinha()+1;
        while(lin < 8 && col < 8 && Tabuleiro.getCasa(lin, col).getPeca() == ' '){
            Movimento move = new Movimento(this.getPosicao(), Tabuleiro.getCasa(lin, col), this);
            moveValido.add(move);
            lin++;
            col++;;
        }
		//captura
		if(lin < 8 && col < 8 && eInimigo(this.getPosicao().getPeca(), Tabuleiro.getCasa(lin, col).getPeca())){
            Movimento move = new Movimento(this.getPosicao(), Tabuleiro.getCasa(lin, col), this
			,Tabuleiro.getCasa(lin, col).getObj_peca());
            moveValido.add(move);
		}
		//diagonal Sudoeste 
		col = this.getPosicao().getColuna() - 1; lin = this.getPosicao().getLinha() - 1;
		while(lin >= 0 && col >= 0 && Tabuleiro.getCasa(lin, col).getPeca() == ' '){
			Movimento move = new Movimento(this.getPosicao(), Tabuleiro.getCasa(lin, col), this);
			moveValido.add(move);
			col--;	
			lin--; 
		}
		//captura
		if(lin >= 0 && col >= 0 && eInimigo(this.getPosicao().getPeca(), Tabuleiro.getCasa(lin, col).getPeca())){
            Movimento move = new Movimento(this.getPosicao(), Tabuleiro.getCasa(lin, col), this
			,Tabuleiro.getCasa(lin, col).getObj_peca());
            moveValido.add(move);
		}
		//diagonal Noroeste 
		col = this.getPosicao().getColuna() - 1; lin = this.getPosicao().getLinha() + 1;
		while(lin < 8 && col >= 0 && Tabuleiro.getCasa(lin, col).getPeca() == ' '){
            Movimento move = new Movimento(this.getPosicao(), Tabuleiro.getCasa(lin, col), this
			,Tabuleiro.getCasa(lin, col).getObj_peca());
			moveValido.add(move);
			col--; 
			lin++;
		}
		//captura
		if(lin < 8 && col >= 0 && eInimigo(this.getPosicao().getPeca(), Tabuleiro.getCasa(lin, col).getPeca())){
            Movimento move = new Movimento(this.getPosicao(), Tabuleiro.getCasa(lin, col), this
			,Tabuleiro.getCasa(lin, col).getObj_peca());
            moveValido.add(move);
		}
		//diagonal Sudeste
		col = this.getPosicao().getColuna() + 1; lin = this.getPosicao().getLinha() - 1;
		while(lin >= 0 && col < 8 && Tabuleiro.getCasa(lin, col).getPeca() == ' '){
			Movimento move = new Movimento(this.getPosicao(), Tabuleiro.getCasa(lin, col), this);
			moveValido.add(move);
			col++;
			lin--;
		}
		//captura
		if(lin >= 0 && col < 8 && eInimigo(this.getPosicao().getPeca(), Tabuleiro.getCasa(lin, col).getPeca())){
            Movimento move = new Movimento(this.getPosicao(), Tabuleiro.getCasa(lin, col), this
			,Tabuleiro.getCasa(lin, col).getObj_peca());
            moveValido.add(move);
		}
        col = this.getPosicao().getColuna();
        lin = this.getPosicao().getLinha()+1;
        //ate onde ele pode se movimentar verticalmente pra cima
        while(lin < 8 && Tabuleiro.getCasa(lin, col).getPeca() == ' '){
            Movimento move = new Movimento(this.getPosicao(), Tabuleiro.getCasa(lin, col), this);
            moveValido.add(move);
            lin++;
        }
        //captura
        if(lin < 8 && eInimigo(this.getPosicao().getPeca(), Tabuleiro.getCasa(lin, col).getPeca())){
            Movimento move = new Movimento(this.getPosicao(), Tabuleiro.getCasa(lin, col), this
			,Tabuleiro.getCasa(lin, col).getObj_peca());
            moveValido.add(move);
        }
        //ate onde ele pode se movimentar horizontalmente pra direita
        lin = this.getPosicao().getLinha();
        col = this.getPosicao().getColuna()+1;
        while(col < 8 && Tabuleiro.getCasa(lin, col).getPeca() == ' '){
            Movimento move = new Movimento(this.getPosicao(), Tabuleiro.getCasa(lin, col), this);
            moveValido.add(move);
            col++;
        }
        //captura
        if(col < 8 && eInimigo(this.getPosicao().getPeca(), Tabuleiro.getCasa(lin, col).getPeca())){
            Movimento move = new Movimento(this.getPosicao(), Tabuleiro.getCasa(lin, col), this
			,Tabuleiro.getCasa(lin, col).getObj_peca());
            moveValido.add(move);
        }
        //ate onde ele pode se movimentar verticalmente pra baixo
        lin = this.getPosicao().getLinha()-1;
        col = this.getPosicao().getColuna();
        while(lin >= 0 && Tabuleiro.getCasa(lin, col).getPeca() == ' '){
            Movimento move = new Movimento(this.getPosicao(), Tabuleiro.getCasa(lin, col), this);
            moveValido.add(move);
            lin--;
        }
        //captura
        if(lin >= 0 && eInimigo(this.getPosicao().getPeca(), Tabuleiro.getCasa(lin, col).getPeca())){
            Movimento move = new Movimento(this.getPosicao(), Tabuleiro.getCasa(lin, col), this
			,Tabuleiro.getCasa(lin, col).getObj_peca());
            moveValido.add(move);
        }

        //ate onde ele pode se movimentar horizontalmente pra esquerda
        lin = this.getPosicao().getLinha();
        col = this.getPosicao().getColuna()-1;
        while(col >= 0 && Tabuleiro.getCasa(lin, col).getPeca() == ' '){
            Movimento move = new Movimento(this.getPosicao(), Tabuleiro.getCasa(lin, col), this);
            moveValido.add(move);
            col--;
        }
        //captura
        if(col >= 0 && eInimigo(this.getPosicao().getPeca(), Tabuleiro.getCasa(lin, col).getPeca())){
            Movimento move = new Movimento(this.getPosicao(), Tabuleiro.getCasa(lin, col), this
			,Tabuleiro.getCasa(lin, col).getObj_peca());
            moveValido.add(move);
        }
        return moveValido;
    }
}
