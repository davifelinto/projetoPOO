public /*abscract */class Peça {
    private Casa posicao;
    private boolean cor_Branca;
    
    public void Peca(boolean cor ,int lin, int col){
        this.posicao.setColuna(col);
        this.posicao.setLinha(lin);
        this.cor_Branca = cor;
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
    //public abstract void movimentosValidos();
}
