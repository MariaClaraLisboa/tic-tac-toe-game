package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.core.utils.ColorUtils;

import java.awt.*;

public class Main extends EngineFrame {

    static final Color BACKGROUND_COLOR = Color.BLACK;
    static final Color FINAL_SCREEN_COLOR = new Color(245, 132, 190);
    static final Color X_COLOR = new Color(252, 197, 228);
    static final Color O_COLOR = new Color(255, 255, 255);

    static final int SYMBOL_SIZE = 150;
    static final int FONT_SIZE = 60;
    static final int BOARD_SIZE = 500;

    Board board;
    GameState gameState;
    Symbol symbolX;
    Symbol symbolO;
    String finalScreenText;

    double finalTextWidth;
    boolean xWon;
    boolean oWon;
    boolean gameOver;

    public Main() {
        super(
                800,                 // largura                      / width
                BOARD_SIZE,                 // altura                       / height
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

        board = new Board(BOARD_SIZE);
        gameState = new GameState(board);

        xWon = false;
        oWon = false;
        gameOver = false;

    }

    @Override
    public void update(double delta) {

        if (!gameOver) {

            if (board.getRows() % 2 == 0) {     // Places 'X', increments the row and checks if 'X' won
                if (isMouseButtonPressed(MOUSE_BUTTON_LEFT)) {
                    symbolX = new Symbol(
                            getMouseX(),
                            getMouseY(),
                            board
                    );
                    symbolX.setSymbolPosition(this, 1);

                    if (gameState.victory(1)) {
                        xWon = true;
                        gameOver = true;
                    }
                }
            } else {    // Places 'O', increments the row and checks if 'O' won
                if (isMouseButtonPressed(MOUSE_BUTTON_LEFT)) {
                    symbolO = new Symbol(
                            getMouseX(),
                            getMouseY(),
                            board
                    );
                    symbolO.setSymbolPosition(this,2);

                    if (gameState.victory(2)) {
                        oWon = true;
                        gameOver = true;
                    }
                }
            }
        }

        if (board.getRows() > 8) {   // Checks draw
            gameOver = true;
        }

        if (board.updateBoard(this)) { // Resets everything
            gameOver = false;
            xWon = false;
            oWon = false;
        }
    }

    @Override
    public void draw() {

        clearBackground(BACKGROUND_COLOR);
        board.drawBoard(this);

        for (int i = 0; i < 9; i++) {

            if (board.getCells()[i] == 1) {
                symbolX.drawSymbol(this, i, "⨉", SYMBOL_SIZE, X_COLOR);

            } else if (board.getCells()[i] == 2) {
                symbolO.drawSymbol(this, i, "○", SYMBOL_SIZE, O_COLOR);

            }
        }

        if (xWon && gameOver || oWon && gameOver) {
            if (xWon) {
                finalScreenText = "X WINS!";
            } else {
                finalScreenText = "○ WINS!";
            }

            gameState.drawWinnerCells(this);

            finalTextWidth = measureText(finalScreenText, FONT_SIZE);

            fillRectangle(0, BOARD_SIZE / 2.0 - FONT_SIZE, BOARD_SIZE, FONT_SIZE * 2, ColorUtils.fade(FINAL_SCREEN_COLOR, 0.9));
            drawText(finalScreenText, BOARD_SIZE / 2.0 - finalTextWidth / 2, BOARD_SIZE / 2.0 - FONT_SIZE / 3.0, FONT_SIZE, WHITE);

        } else if (gameOver) {

            finalScreenText = "DRAW!";
            finalTextWidth = measureText(finalScreenText, FONT_SIZE);

            fillRectangle(0, BOARD_SIZE / 2.0 - FONT_SIZE, BOARD_SIZE, FONT_SIZE * 2, ColorUtils.fade(FINAL_SCREEN_COLOR, 0.6));
            drawText(finalScreenText, BOARD_SIZE / 2.0 - finalTextWidth / 2, BOARD_SIZE / 2.0 - FONT_SIZE / 3.0, FONT_SIZE, WHITE);

        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
