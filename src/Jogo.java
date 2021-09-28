// import java.awt.event.KeyListener;

public class Jogo /*implements KeyListener*/ {
    public static void main(String[] args) {
        System.out.println("teste\u001B[30m");
        System.out.print("\033[H\033[2J");
        System.out.flush();
        /*imprimir na tela o tabuleiro*/
        /*pegar o imput do player da vez*/
        /*checar se o imput é uma jogada válida*/
        /*atualizar o tabuleiro*/
        /*checar regras (check e chekmate)*/
        /*finalizar o jogo caso checkmate*/
        /*caso continue o jogo, pegar proximo imput e repetir o processo*/
    }


    /**
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
            movimento.left = true;
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
            movimento.right = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
            player.left = false;
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
            player.right = false;
        }

    }
**/
}
