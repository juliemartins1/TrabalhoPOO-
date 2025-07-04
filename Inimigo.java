import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class Inimigo {
    private Ponto posicao;
    private int velocidade;
    private int largura = 15;
    private int altura = 15;
    private Color cor = Color.RED;
    private int direcaoX;
    private int direcaoY;
    private Random random = new Random();

    public Inimigo(int x, int y) {
        this.posicao = new Ponto(x, y);
        this.velocidade = 1;
        if (random.nextBoolean()) {
    this.direcaoX = 1;
} else {
    this.direcaoX = -1;
}

if (random.nextBoolean()) {
    this.direcaoY = 1;
} else {
    this.direcaoY = -1;
}

    }

    public void mover() {
        int novoX = posicao.getX() + (velocidade * direcaoX);
        int novoY = posicao.getY() + (velocidade * direcaoY);

        if (novoX <= 0 || novoX >= 800 - largura) direcaoX = -direcaoX;
        if (novoY <= 0 || novoY >= 600 - altura) direcaoY = -direcaoY;

        posicao.mover(velocidade * direcaoX, velocidade * direcaoY);
    }

    public void desenhar(Graphics g) {
        g.setColor(cor);
        g.fillRect(posicao.getX(), posicao.getY(), largura, altura);
    }

    public Rectangle getBound() {
        return new Rectangle(posicao.getX(), posicao.getY(), largura, altura);
    }
}
