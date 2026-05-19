package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;

import java.awt.*;

public class Peca {

    private int jogador;
    private CentroCelulas centro;

    public Peca(int jogador) {
        this.jogador = jogador;
    }

    public int getJogador() {
        return jogador;
    }

    public void desenharPeca(EngineFrame e, int celula, String texto, double tamanhoDoTexto, int tamanhoPeca, Color cor) {

        centro = new CentroCelulas(tamanhoPeca, e);

        e.drawText(texto, centro.getVetorPosicao(celula, tamanhoDoTexto), tamanhoPeca, cor);

    }
}
