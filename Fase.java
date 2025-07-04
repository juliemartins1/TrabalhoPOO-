import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class Fase {
    private int numero;
    private List<Inimigo> inimigos = new ArrayList<>();
    private List<Objetivo> objetivos = new ArrayList<>();
    private boolean completa = false;

    public Fase(int numero) {
        this.numero = numero;
        inicializar();
    }

    private void inicializar() {
        for (int i = 0; i < Math.min(1 + numero, 8); i++) {
            Inimigo inimigo = new Inimigo(100 + i * 80, 50 + i * 40);
            inimigo.mover();
            inimigos.add(inimigo);
        }
        for (int i = 0; i < 1 + numero / 4; i++) {
            objetivos.add(new Objetivo(200 + i * 100, 300 + (i % 2) * 100));
        }
    }

    public void atualizar() {
        for (Inimigo i : inimigos) i.mover();
       completa = true;
        for (Objetivo o : objetivos) {
        if (!o.isColetado()) {
        completa = false;
        break;
    }
}

    }

    public void desenhar(Graphics g) {
        g.setColor(Color.WHITE);
       int restantes = 0;
        for (Objetivo o : objetivos) {
        if (!o.isColetado()) {
        restantes++;
    }
}
g.drawString("Objetivos restantes: " + restantes, 10, 40);

        for (Inimigo i : inimigos) {
             i.desenhar(g);
}
        for (Objetivo o : objetivos) {
            o.desenhar(g);
}
    }

    public boolean isCompleta() { 
        return completa; 
    }
    public List<Inimigo> getInimigos() { 
        return inimigos;
     }
    public List<Objetivo> getObjetivos() { 
        return objetivos; 
    }
}