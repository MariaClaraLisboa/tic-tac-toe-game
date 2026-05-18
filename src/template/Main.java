package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.core.utils.ColorUtils;

import java.awt.*;

public class Main extends EngineFrame {

    static final int TAMANHO_PECA = 150;
    static final int TAMANHO_FONTE = 60;
    static final Color COR_DO_FUNDO = Color.BLACK;
    static final Color COR_TELA_FINAL = new Color(255, 235, 242);
    static final Color COR_X = new Color(252, 197, 228);
    static final Color COR_O = new Color(255, 255, 255);

    Tabuleiro tabuleiro;
    EstadoDoJogo estadoDoJogo;
    Peca pecaX;
    Peca pecaO;
    PosicaoPeca posicaoPecaX;
    PosicaoPeca posicaoPecaO;

    String textoTelaFinal;

    double larguraDoTextoFinal;
    double larguraDoTextoX;
    double larguraDoTextoO;

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
        estadoDoJogo = new EstadoDoJogo(tabuleiro);
        pecaX = new Peca(1);
        pecaO = new Peca(2);

        xVenceu = false;
        oVenceu = false;
        fimDeJogo = false;

    }

    @Override
    public void update(double delta) {

        if (!fimDeJogo) {

            if (tabuleiro.getRodadas() % 2 == 0) {           //Coloca peca 'X', incrementa a rodada e vê se 'X' venceu
                if (isMouseButtonPressed(MOUSE_BUTTON_LEFT)) {
                    posicaoPecaX = new PosicaoPeca(
                            getMouseX(),
                            getMouseY(),
                            tabuleiro,
                            pecaX
                    );
                    posicaoPecaX.setPosicao(getScreenWidth());

                    if (estadoDoJogo.verificarVitoriaDoX()) {
                        xVenceu = true;
                        fimDeJogo = true;
                    }
                }
            } else {    //Coloca peca 'O', incrementa a rodada e vê se 'O' venceu
                if (isMouseButtonPressed(MOUSE_BUTTON_LEFT)) {
                    posicaoPecaO = new PosicaoPeca(
                            getMouseX(),
                            getMouseY(),
                            tabuleiro,
                            pecaO
                    );
                    posicaoPecaO.setPosicao(getScreenWidth());

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

        if (tabuleiro.updateTabuleiro(this, delta)) { // Quando reinicia reseta tudo
            fimDeJogo = false;
            xVenceu = false;
            oVenceu = false;
        }
    }

    @Override
    public void draw() {

        clearBackground(COR_DO_FUNDO);
        tabuleiro.desenharTabuleiro(this);

        for (int i = 0; i < 9; i++) {

            if (tabuleiro.getCelulas()[i] == 1) {
                larguraDoTextoX = measureText("⨉", TAMANHO_PECA);
                pecaX.desenharPeca(this, i, "⨉", larguraDoTextoX, TAMANHO_PECA, COR_X);

            } else if (tabuleiro.getCelulas()[i] == 2) {
                larguraDoTextoO = measureText("○", TAMANHO_PECA);
                pecaO.desenharPeca(this, i, "○", larguraDoTextoO, TAMANHO_PECA, COR_O);

            }
        }

        if (xVenceu && fimDeJogo || oVenceu && fimDeJogo) {
            if (xVenceu) {
                textoTelaFinal = "X WINS!";
            } else {
                textoTelaFinal = "○ WINS!";
            }

            estadoDoJogo.desenharLinhaDaVitoria(this);

            larguraDoTextoFinal = measureText(textoTelaFinal, TAMANHO_FONTE);

            fillRectangle(0, getScreenHeight() / 2.0 - TAMANHO_FONTE, getScreenWidth(), TAMANHO_FONTE * 2, ColorUtils.fade(PINK, 0.5));
            drawText(textoTelaFinal, getScreenWidth() / 2.0 - larguraDoTextoFinal / 2, getScreenHeight() / 2.0 - TAMANHO_FONTE / 3.0, TAMANHO_FONTE, BLACK);

        } else if (fimDeJogo) {

            textoTelaFinal = "GAME OVER!";
            larguraDoTextoFinal = measureText(textoTelaFinal, TAMANHO_FONTE);

            fillRectangle(0, getScreenHeight() / 2.0 - TAMANHO_FONTE, getScreenWidth(), TAMANHO_FONTE * 2, ColorUtils.fade(PINK, 0.3));
            drawText(textoTelaFinal, getScreenWidth() / 2.0 - larguraDoTextoFinal / 2, getScreenHeight() / 2.0 - TAMANHO_FONTE / 3.0, TAMANHO_FONTE, BLACK);

        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
