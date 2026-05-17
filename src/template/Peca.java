package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;

import java.awt.*;

public class Peca {

    private static final int tamanhoFonte = 150;
    private static final Color corX = new Color(252, 197, 228);
    private static final Color corO = new Color(255, 255, 255);
    private int jogador;
    private CentroCelulas centro;

    public Peca(int jogador) {
        this.jogador = jogador;
    }

    public int getJogador() {
        return jogador;
    }

    public void desenharPeca(EngineFrame e, int i) {

        centro = new CentroCelulas(tamanhoFonte, e);
        double tamanhoDoTextoX = e.measureText("⨉", tamanhoFonte);
        double tamanhoDoTextoO = e.measureText("○", tamanhoFonte);

        if (i == 0) {
            if (jogador == 1) {
                e.drawText("⨉", centro.getPosicao0(tamanhoDoTextoX), tamanhoFonte, corX);
            } else if (jogador == 2) {
                e.drawText("○", centro.getPosicao0(tamanhoDoTextoO) , tamanhoFonte, corO);
            }
        } else if (i == 1) {
            if (jogador == 1) {
                e.drawText("⨉", centro.getPosicao1(tamanhoDoTextoX), tamanhoFonte, corX);
            } else if (jogador == 2) {
                e.drawText("○", centro.getPosicao1(tamanhoDoTextoO), tamanhoFonte, corO);
            }
        } else if (i == 2) {
            if (jogador == 1) {
                e.drawText("⨉", centro.getPosicao2(tamanhoDoTextoX), tamanhoFonte, corX);
            } else if (jogador == 2) {
                e.drawText("○", centro.getPosicao2(tamanhoDoTextoO), tamanhoFonte, corO);
            }
        } else if (i == 3) {
            if (jogador == 1) {
                e.drawText("⨉", centro.getPosicao3(tamanhoDoTextoX), tamanhoFonte, corX);
            } else if (jogador == 2) {
                e.drawText("○", centro.getPosicao3(tamanhoDoTextoO), tamanhoFonte, corO);
            }
        } else if (i == 4) {
            if (jogador == 1) {
                e.drawText("⨉", centro.getPosicao4(tamanhoDoTextoX), tamanhoFonte, corX);
            } else if (jogador == 2) {
                e.drawText("○", centro.getPosicao4(tamanhoDoTextoO), tamanhoFonte, corO);
            }
        } else if (i == 5) {
            if (jogador == 1) {
                e.drawText("⨉", centro.getPosicao5(tamanhoDoTextoX), tamanhoFonte, corX);
            } else if (jogador == 2) {
                e.drawText("○", centro.getPosicao5(tamanhoDoTextoO), tamanhoFonte, corO);
            }
        } else if (i == 6) {
            if (jogador == 1) {
                e.drawText("⨉", centro.getPosicao6(tamanhoDoTextoX), tamanhoFonte, corX);
            } else if (jogador == 2) {
                e.drawText("○", centro.getPosicao6(tamanhoDoTextoO), tamanhoFonte, corO);
            }
        } else if (i == 7) {
            if (jogador == 1) {
                e.drawText("⨉", centro.getPosicao7(tamanhoDoTextoX), tamanhoFonte, corX);
            } else if (jogador == 2) {
                e.drawText("○", centro.getPosicao7(tamanhoDoTextoO), tamanhoFonte, corO);
            }
        } else if (i == 8) {
            if (jogador == 1) {
                e.drawText("⨉", centro.getPosicao8(tamanhoDoTextoX), tamanhoFonte, corX);
            } else if (jogador == 2) {
                e.drawText("○", centro.getPosicao8(tamanhoDoTextoO), tamanhoFonte, corO);
            }
        }

    }

}
