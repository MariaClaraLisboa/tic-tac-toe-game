package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.math.Vector2;

public class CellPositions {

    private Vector2[] positions = new Vector2[9];

    private int fontSize;
    private double cellSize;
    private double cellCenter;

    public CellPositions( EngineFrame e, int fontSize, int boardSize) {

        this.fontSize = fontSize;

        cellSize = boardSize / 3.0;
        cellCenter = cellSize / 2;

    }

    public Vector2 getCellPositionVector(int cellNumber, double symbolTextSize) {
        return getPosition(cellNumber, symbolTextSize);
    }

    private Vector2 getPosition(int cellNumber, double symbolTextSize) {      // Gets the cell's center position Vector2 considering the text's size to place the symbols better

        positions[0] = new Vector2(cellCenter - (symbolTextSize / 2), cellCenter - fontSize / 3.4);
        positions[1] = new Vector2((cellCenter + cellSize) - (symbolTextSize / 2), cellCenter - fontSize / 3.4);
        positions[2] = new Vector2((cellCenter + cellSize * 2) - (symbolTextSize / 2), cellCenter - fontSize / 3.4);
        positions[3] = new Vector2(cellCenter - (symbolTextSize / 2), (cellCenter + cellSize) - fontSize / 3.4);
        positions[4] = new Vector2((cellCenter + cellSize) - (symbolTextSize / 2), (cellCenter + cellSize) - fontSize / 3.4);
        positions[5] = new Vector2((cellCenter + cellSize * 2) - (symbolTextSize / 2), (cellCenter + cellSize) - fontSize / 3.4);
        positions[6] = new Vector2(cellCenter - (symbolTextSize / 2), (cellCenter + cellSize * 2) - fontSize / 3.4);
        positions[7] = new Vector2((cellCenter + cellSize) - (symbolTextSize / 2), (cellCenter + cellSize * 2) - fontSize / 3.4);
        positions[8] = new Vector2((cellCenter + cellSize * 2) - (symbolTextSize / 2), (cellCenter + cellSize * 2) - fontSize / 3.4);

        return positions[cellNumber];
    }
}
