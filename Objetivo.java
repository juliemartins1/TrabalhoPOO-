import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Objetivo {
    private Ponto posicao;
    private boolean coletado = false;
    private int largura = 12;
    private int altura = 12;
    private Color cor = Color.YELLOW;

    public Objetivo(int x, int y) {
        this.posicao = new Ponto(x, y);
    }

    public void desenhar(Graphics g) {
        if (!coletado) {
            g.setColor(cor);
            g.fillOval(posicao.getX(), posicao.getY(), largura, altura);
        }
    }

    public boolean isColetado() { 
        return coletado; 
    }
    public void coletar() {
         coletado = true;
         }
    public Rectangle getBound() {
        return new Rectangle(posicao.getX(), posicao.getY(), largura, altura);
    }
}