package main;
public class Casa{
    private int linha;
    private int coluna;
    private char peca;
    
    public Casa(int linha, int coluna, char peca){
        this.linha = linha;
        this.coluna = coluna;
        this.peca = peca;
    }
    public char getPeca(){
        return peca;
    }
    public void setPeca(char peca){
        this.peca = peca;
    }
    public int getLinha() {
        return linha;
    }
    public int getColuna() {
        return coluna;
    }
    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
    public void setLinha(int linha) {
        this.linha = linha;
    }
}