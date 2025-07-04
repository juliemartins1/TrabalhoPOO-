import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Jogador {
    private Ponto posicao;
    private int velocidade = 2;
    private int largura = 20;
    private int altura = 20;
    private Color cor = Color.BLUE;

    public Jogador(int x, int y) {
        this.posicao = new Ponto(x, y);
    }

    public void cima() {
        if (posicao.getY() > 0) posicao.mover(0, -velocidade);
    }

    public void baixo() {
        if (posicao.getY() <=648 - altura) posicao.mover(0, velocidade);
    }

    public void esquerda() {
        if (posicao.getX() >= 0) posicao.mover(-velocidade, 0);
    }

    public void direita() {
        if (posicao.getX() <=900 - largura) posicao.mover(velocidade, 0);
    }

    public void desenhar(Graphics g) {
        g.setColor(cor);
        g.fillRect(posicao.getX(), posicao.getY(), largura, altura);
    }

    public Rectangle getBound() {
        return new Rectangle(posicao.getX(), posicao.getY(), largura, altura);
    }

    public void setVelocidade(int v) { 
        velocidade = v;
     }
    public int getVelocidade() {
         return velocidade; 
        }
}