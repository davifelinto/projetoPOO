public class Tabuleiro {
    public void limpaTela (){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    Casa[][] casa = new Casa[8][8];

}
