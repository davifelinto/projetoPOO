package main.Peças;
import java.util.ArrayList;
import java.util.List;

import main.Movimento;
import main.Peca;
import main.Tabuleiro;

public class Peao extends Peca{

    public Peao(boolean cor, int lin, int col) {
        super(cor, lin, col);
        //if(cor)
        //    Tabuleiro.getCasa(lin, col).setPeca('♙');
        //else
        //    Tabuleiro.getCasa(lin, col).setPeca('♟');
    }

    @Override
    public List<Movimento> movimentosValidos() {
        int indice;
        int pos_ini;
        List<Movimento> moveValido = new ArrayList<>();
        if(this.isCor_Branca()){
            indice = -1;
            pos_ini = 6;
        }
        else{
            indice = +1;
            pos_ini = 1;
        }
        int lin = this.getPosicao().getLinha();
        int col = this.getPosicao().getColuna();
        if(Tabuleiro.getCasa(lin+indice, col).getPeca() == ' '){
                Movimento move = new Movimento(this.getPosicao(), Tabuleiro.getCasa(lin+indice, col), this);
                moveValido.add(move);
            if(lin == pos_ini && Tabuleiro.getCasa(lin+(indice*2), col).getPeca() == ' '){
                move = new Movimento(this.getPosicao(), Tabuleiro.getCasa(lin+(indice*2), col), this);
                moveValido.add(move);
            }
        }
        //capturas
        if(col + indice < 8 && col + indice >= 0 && eInimigo(this.getPosicao().getPeca(), Tabuleiro.getCasa(lin+indice, col+indice).getPeca())){
            Movimento move = new Movimento(this.getPosicao(), Tabuleiro.getCasa(lin+indice, col+indice), this
            ,Tabuleiro.getCasa(lin+indice, col+indice).getObj_peca());
            moveValido.add(move);
        }
        if(col - indice < 8 && col - indice >= 0 && eInimigo(this.getPosicao().getPeca(), Tabuleiro.getCasa(lin+indice, col-indice).getPeca())){    
            Movimento move = new Movimento(this.getPosicao(), Tabuleiro.getCasa(lin+indice, col-indice), this
            ,Tabuleiro.getCasa(lin+indice, col-indice).getObj_peca());
            moveValido.add(move);
        }
        return moveValido;
    }
}
/**
function pawn_movement(position_letter, position_number, color){
	//capturas
	if(position_letter != letra_1 && global.tabletop[position_letter+indice][position_number+indice] != " "
	&& (string_char_at(color, 1) != string_char_at(global.tabletop[position_letter+indice][position_number + indice], 1))){
		allow[tam] = pos[position_letter+indice][position_number+indice];
		tam++;
	}
	if(position_letter != letra_2 && global.tabletop[position_letter-indice][position_number+indice] != " "
	&& (string_char_at(color, 1) != string_char_at(global.tabletop[position_letter-indice][position_number + indice], 1))){
		allow[tam] = pos[position_letter-indice][position_number+indice];
		tam++;
	}
	//capturas en passant
	num = letra_1-(3*indice);
	if(position_letter != letra_1 && position_number == num && global.tabletop[position_letter+indice][position_number] == roc + "pawn"
	&& turn_control.notation[turn_control.c_turn] == string(position_letter+indice)+string(position_number+indice*2)+string(position_letter+indice)+string(position_number)){
		allow[tam] = pos[position_letter+indice][position_number+indice];
		tam++;
	}
	if(position_letter != letra_2 && position_number == num && global.tabletop[position_letter-indice][position_number] == roc + "pawn"
	&& turn_control.notation[turn_control.c_turn] == string(position_letter-indice)+string(position_number+indice*2)+string(position_letter-indice)+string(position_number)){
		allow[tam] = pos[position_letter-indice][position_number+indice];
		tam++;
	}

} */