package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.core.utils.ColorUtils;

import java.awt.*;

public class GamePanel {
    private static final Color FINAL_SCREEN_COLOR = new Color(245, 132, 190);

    public void drawGameOver(EngineFrame e, String text, int fontSize, int boardSize){
        double finalTextWidth = e.measureText(text, fontSize);

        e.fillRectangle(0, boardSize / 2.0 - fontSize, boardSize, fontSize * 2, ColorUtils.fade(FINAL_SCREEN_COLOR, 0.9));
        e.drawText(text, boardSize / 2.0 - finalTextWidth / 2, boardSize / 2.0 - fontSize / 3.0, fontSize, e.WHITE);

    }
}
