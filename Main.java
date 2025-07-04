import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Jogo de Fases - OO");
        Tela tela = new Tela();
        frame.setSize(900,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(tela);
        frame.setVisible(true);
        tela.requestFocusInWindow();
        new Thread(tela).start();
    }
}