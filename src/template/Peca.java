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

        if (celula == 0) {
            e.drawText(texto, centro.getPosicao0(tamanhoDoTexto), tamanhoPeca, cor);
        } else if (celula == 1) {
            e.drawText(texto, centro.getPosicao1(tamanhoDoTexto), tamanhoPeca, cor);
        } else if (celula == 2) {
            e.drawText(texto, centro.getPosicao2(tamanhoDoTexto), tamanhoPeca, cor);
        } else if (celula == 3) {
            e.drawText(texto, centro.getPosicao3(tamanhoDoTexto), tamanhoPeca, cor);
        } else if (celula == 4) {
            e.drawText(texto, centro.getPosicao4(tamanhoDoTexto), tamanhoPeca, cor);
        } else if (celula == 5) {
            e.drawText(texto, centro.getPosicao5(tamanhoDoTexto), tamanhoPeca, cor);
        } else if (celula == 6) {
            e.drawText(texto, centro.getPosicao6(tamanhoDoTexto), tamanhoPeca, cor);
        } else if (celula == 7) {
            e.drawText(texto, centro.getPosicao7(tamanhoDoTexto), tamanhoPeca, cor);
        } else if (celula == 8) {
            e.drawText(texto, centro.getPosicao8(tamanhoDoTexto), tamanhoPeca, cor);
        }
    }
}
