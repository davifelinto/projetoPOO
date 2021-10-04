package main;

import java.util.List;
//import java.util.ArrayList;

public abstract class Peca {
    private Casa posicao;
    private boolean cor_Branca;
    
    public Peca(boolean cor ,int lin, int col){
        setPosicao(Tabuleiro.getCasa(lin, col));
        this.cor_Branca = cor;
    }
    
    public boolean eInimigo(char atual, char outro){
        if(Character.isLowerCase(atual))
            if(Character.isUpperCase(outro))
                return true;
            else   
                return false;
        else if(Character.isUpperCase(atual))
            if(Character.isLowerCase(outro))
                return true;
            else
                return false;
        return false;
    }
    //getters and setters
    public void setCor_Branca(boolean cor_Branca){
        this.cor_Branca = cor_Branca;
    }
    public boolean isCor_Branca() {
        return cor_Branca;
    }
    public void setPosicao(Casa posicao){
        this.posicao = posicao;
    }
    public void setPosicao(int lin, int col){
        this.posicao.setColuna(col);
        this.posicao.setLinha(lin);
    }
    public Casa getPosicao() {
        return posicao;
    }
    public abstract List<Movimento> movimentosValidos();
    //public abscract boolean isAtacada(){}
}
