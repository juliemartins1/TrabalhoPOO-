import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


public class Jogo {
    private Jogador jogador;
    private List<Fase> fases = new ArrayList<>();
    private int faseAtual = 0;
    private int vidas = 3;
    private boolean gameOver = false;

    public Jogo() {
        jogador = new Jogador(100, 100);
        fases.add(new Fase(1));
    }

    public void atualizar() {
        if (gameOver) return;

        Fase fase = fases.get(faseAtual);
        fase.atualizar();

        for (Inimigo inimigo : fase.getInimigos()) {
            if (jogador.getBound().intersects(inimigo.getBound())) {
                vidas--;
            if (vidas <= 0) {
            gameOver = true;
    } else {
        jogador = new Jogador(100, 100); 
        fases.set(faseAtual, new Fase(faseAtual + 1)); 
    }
                return;
            }
        }
        for (Objetivo objetivo : fase.getObjetivos()) {
            if (!objetivo.isColetado() && jogador.getBound().intersects(objetivo.getBound())) objetivo.coletar();
        }
        if (fase.isCompleta()) {
            faseAtual++;
            fases.add(new Fase(faseAtual + 1));
            jogador.setVelocidade(jogador.getVelocidade() + 1);
        }
    }

    public void desenhar(Graphics g) {
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, 900, 700);
    
    if (gameOver) {
        g.setColor(Color.WHITE);
        g.drawString("GAME OVER! Pressione R para reiniciar", 300, 300);
        return;
    }

    fases.get(faseAtual).desenhar(g);
    jogador.desenhar(g);

    g.setColor(Color.WHITE);
    g.drawString("Fase: " + (faseAtual + 1), 40, 20);

    g.drawString("Vidas: " + vidas, 40, 60);
    }

    public Jogador getJogador() {
        return jogador;
    }
    public boolean isGameOver() {
        return gameOver;
    }

    public void reiniciar() {
    faseAtual = 0;
    jogador = new Jogador(100, 100);
    fases.clear();
    fases.add(new Fase(1));
    gameOver = false;
    vidas = 3;
    }
}
