import java.util.ArrayList;
import java.util.List;

public class ControlaJogo {
    public static String fen_Atual;
    private static final List<Movimento> pgn = new ArrayList<>();
    public static Jogador jogador[] = new Jogador[2];
    private static boolean turno_Branco = true;
    private static boolean roque_Rei_b = false;
    private static boolean roque_Dama_b = false;
    private static boolean roque_Rei_p = false;
    private static boolean roque_Dama_p = false;

    public static void adicionarMovimento(Movimento m){
        getPgn().add(m);
    }
    public static void lerFen(String n){
        char notacao[] = n.toCharArray();
        boolean flag = true;
        int col = 0, lin = 0;

        for(char i : notacao){
            if(flag){ 
                if(Character.isLetter(i)){
                    Tabuleiro.setCasa_Char(i, lin, col);
                    //Instanciar a peça e coloca em Tabuleiro.pecasPretas/pecasBrancas
                    col++;
                }else if(i == '/'){
                    lin++;
                    col = 0;
                }else if(Character.isDigit(i)){
                    int max = col + Character.getNumericValue(i);
                    for(; col < max; col++)
                        Tabuleiro.setCasa_Char(' ', lin, col);
                }else if(i == ' '){
                    flag = false;
                }
            }else{
                switch (i) {
                    case 'w':
                        ControlaJogo.turno_Branco = true;
                        break;
                    case 'b':
                        setTurno_Branco(false);
                        break;
                    case 'K':
                        setRoque_Rei_b(true);
                        break;
                    case 'Q':
                        setRoque_Dama_b(true);
                        break;
                    case 'k':
                        setRoque_Rei_p(true);
                        break;
                    case 'q':
                        setRoque_Dama_p(true);     
                        break;               
                    default:
                        break;
                }
            }
        }
        fen_Atual = n;
    }
    public static void gravarFen(){
        //Funcao para salvar a partida; 

    }
    //getters and setters
    public static List<Movimento> getPgn() {
        return pgn;
    }
    public static boolean isRoque_Rei_b() {
        return roque_Rei_b;
    }
    public static boolean isTurno_Branco() {
        return turno_Branco;
    }
    public static void setTurno_Branco(boolean turno_Branco) {
        ControlaJogo.turno_Branco = turno_Branco;
    }
    public static boolean isRoque_dama_p() {
        return roque_Dama_p;
    }
    public static void setRoque_Dama_p(boolean roque_Dama_p) {
        ControlaJogo.roque_Dama_p = roque_Dama_p;
    }
    public static boolean isRoque_Rei_p() {
        return roque_Rei_p;
    }
    public static void setRoque_Rei_p(boolean roque_Rei_p) {
        ControlaJogo.roque_Rei_p = roque_Rei_p;
    }
    public static boolean isRoque_Dama_b() {
        return roque_Dama_b;
    }
    public static void setRoque_Dama_b(boolean roque_Dama_b) {
        ControlaJogo.roque_Dama_b = roque_Dama_b;
    }
    public static void setRoque_Rei_b(boolean roque_Rei_b) {
        ControlaJogo.roque_Rei_b = roque_Rei_b;
    }
    
}
