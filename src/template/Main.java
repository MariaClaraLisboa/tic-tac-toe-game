package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.core.utils.ColorUtils;

import java.awt.*;

public class Main extends EngineFrame {

    static final Color corDoFundo = new Color(255, 235, 242);

    Tabuleiro tabuleiro;
    Peca pecaX;
    Peca pecaO;
    PosicaoPeca posicaoPecaX;
    PosicaoPeca posicaoPecaO;
    EstadoDoJogo estadoDoJogo;

    boolean xVenceu;
    boolean oVenceu;
    boolean fimDeJogo;

    public Main() {
        super(
                500,                 // largura                      / width
                500,                 // altura                       / height
                "Tic Tac Toe",      // título                       / title
                60,                  // quadros por segundo desejado / target FPS
                true,                // suavização                   / antialiasing
                false,               // redimensionável              / resizable
                false,               // tela cheia                   / full screen
                false,               // sem decoração                / undecorated
                false,               // sempre no topo               / always on top
                false                // fundo invisível              / invisible background
        );
    }

    @Override
    public void create() {

        tabuleiro = new Tabuleiro();
        pecaX = new Peca(1);
        pecaO = new Peca(2);
        estadoDoJogo = new EstadoDoJogo(tabuleiro);

        fimDeJogo = false;
        xVenceu = false;
        oVenceu = false ;

    }

    @Override
    public void update(double delta) {

        if (!fimDeJogo) {

            if (tabuleiro.getRodadas() % 2 == 0) {           //Coloca peca 'X', incrementa a rodada e vê se 'X' venceu
                if (isMouseButtonPressed(MOUSE_BUTTON_LEFT)) {
                    posicaoPecaX = new PosicaoPeca(getMouseX(), getMouseY(), tabuleiro, pecaX);
                    posicaoPecaX.setPosicao(getScreenHeight());

                    System.out.println("\nRodada:" + tabuleiro.getRodadas());

                    if (estadoDoJogo.verificarVitoriaDoX()) {
                        xVenceu = true;
                        fimDeJogo = true;
                    }
                }
            }

            else if (tabuleiro.getRodadas() % 2 != 0) {          //Coloca peca 'O', incrementa a rodada e vê se 'O' venceu
                if (isMouseButtonPressed(MOUSE_BUTTON_LEFT)) {
                    posicaoPecaO = new PosicaoPeca(getMouseX(), getMouseY(), tabuleiro, pecaO);
                    posicaoPecaO.setPosicao(getScreenHeight());

                    System.out.println("\nRodada:" + tabuleiro.getRodadas());

                    if (estadoDoJogo.verificarVitoriaDoO()) {
                        oVenceu = true;
                        fimDeJogo = true;
                    }
                }
            }

        }

        if (tabuleiro.getRodadas() > 8) {   // Verifica se houve empate
            fimDeJogo = true;
        }

        if(tabuleiro.updateTabuleiro(this, delta)){
            fimDeJogo = false;
        }
    }

    @Override
    public void draw() {

        clearBackground(corDoFundo);
        tabuleiro.desenharTabuleiro(this);

        for (int i = 0; i < 9; i++) {

            if (tabuleiro.getCelulas()[i] == 1) {
                pecaX.desenharPeca(this, i);
            } else if (tabuleiro.getCelulas()[i] == 2) {
                pecaO.desenharPeca(this, i);
            }

        }

        if (xVenceu && fimDeJogo) {

            String texto = "X - WINS!";
            int tamanhoFonte = 60;

            int tamanhovertical = measureText(texto, tamanhoFonte);

            estadoDoJogo.desenharLinhaDaVitoria(this);

            fillRectangle(0, getScreenHeight() / 2 - tamanhoFonte, getScreenWidth(), tamanhoFonte * 2, ColorUtils.fade(BLACK, 0.3));
            drawText(texto, getScreenWidth() / 2 - tamanhovertical / 2, getScreenHeight() / 2 - tamanhoFonte / 3, tamanhoFonte, corDoFundo);

        } else if (oVenceu && fimDeJogo) {

            String texto = "○ - WINS!";
            int tamanhoFonte = 60;

            int tamanhovertical = measureText(texto, tamanhoFonte);

            estadoDoJogo.desenharLinhaDaVitoria(this);

            fillRectangle(0, getScreenHeight() / 2 - tamanhoFonte, getScreenWidth(), tamanhoFonte * 2, ColorUtils.fade(BLACK, 0.3));
            drawText(texto, getScreenWidth() / 2 - tamanhovertical / 2, getScreenHeight() / 2 - tamanhoFonte / 3, tamanhoFonte, corDoFundo);

        } else if (fimDeJogo) {

            String texto = "GAME OVER!";
            int tamanhoFonte = 60;
            int tamanhovertical = measureText(texto, tamanhoFonte);

            fillRectangle(0, getScreenHeight() / 2 - tamanhoFonte, getScreenWidth(), tamanhoFonte * 2, ColorUtils.fade(BLACK, 0.3));
            drawText(texto, getScreenWidth() / 2 - tamanhovertical / 2, getScreenHeight() / 2 - tamanhoFonte / 3, tamanhoFonte, corDoFundo);

        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
