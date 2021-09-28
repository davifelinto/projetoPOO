import java.util.ArrayList;
import java.util.List;
public class Tabuleiro {
    private static Casa[][] casa = new Casa[8][8];
    private static char[][] casa_Char = new char[8][8];
    private static List<Peça> pecasBrancas = new ArrayList<>();
    private static List<Peça> pecasPretas = new ArrayList<>();

    //Getters and setters
    public static List<Peça> getPecasB() {
        return pecasBrancas;
    }
    public static List<Peça> getPecasP() {
        return pecasPretas;
    }
    public static char getCasa_Char(int lin, int col) {
        return casa_Char[lin][col];
    }
    public static void setCasa_Char(char peca, int lin, int col) {
        Tabuleiro.casa_Char[lin][col] = peca;
    }
    public static Casa getCasa(int lin, int col) {
        return casa[lin][col];
    }
    public static void setCasa(Casa peca, int lin, int col) {
        Tabuleiro.casa[lin][col] = peca;
    }   
    
    //Metodos
    public static void adicionarPecaListas(Peça p){
        if(p.isCor_Branca())
            getPecasB().add(p);
        else
            getPecasP().add(p);
    }
    public static void limpaTela (){
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    public static void imprimeTabuleiro(boolean turn_W){
            if(turn_W)
                //tabuleiro branco
                for(int i = 0; i < 8; i++){
                    for(int j = 0; j < 8; j++){
                        if(Character.isUpperCase(Tabuleiro.getCasa_Char(i, j)))
                            System.out.print("\u001B[37m");
                        else
                            System.out.print("\u001B[30m");
                        System.out.print(Tabuleiro.getCasa_Char(i, j) + " ");
                    }
                    System.out.println();
                }
            else
                //tabuleiro preto
                for(int i = 7; i >= 0; i--){
                    for(int j = 7; j >= 0; j--){
                        if(Character.isUpperCase(Tabuleiro.getCasa_Char(i, j)))
                            System.out.print("\u001B[37m");
                        else
                            System.out.print("\u001B[30m");
                        System.out.print(Tabuleiro.getCasa_Char(i, j) + " ");
                    }   
                    System.out.println();     
                }
            System.out.print("\u001B[0m");
        }
}