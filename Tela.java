import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class Tela extends JPanel implements KeyListener, Runnable {
    private Jogo jogo;
    private boolean cima, baixo, esquerda, direita;

    public Tela() {
        this.jogo = new Jogo();
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        jogo.desenhar(g);
        if (cima) jogo.getJogador().cima();
        if (baixo) jogo.getJogador().baixo();
        if (esquerda) jogo.getJogador().esquerda();
        if (direita) jogo.getJogador().direita();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (Character.toLowerCase(e.getKeyChar())) {
            case 'w': cima = true; break;
            case 's': baixo = true; break;
            case 'a': esquerda = true; break;
            case 'd': direita = true; break;
            case 'r':
                jogo.reiniciar();

                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (Character.toLowerCase(e.getKeyChar())) {
            case 'w': cima = false; 
            break;
            case 's': baixo = false; 
            break;
            case 'a': esquerda = false; 
            break;
            case 'd': direita = false;
            break;
        }
    }

    @Override public void keyTyped(KeyEvent e) {}

    @Override
    public void run() {
        while (true) {
            try {
                jogo.atualizar();
                repaint();
                Thread.sleep(16);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}