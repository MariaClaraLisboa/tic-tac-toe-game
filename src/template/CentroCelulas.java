package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.math.Vector2;

public class CentroCelulas {

    private Vector2[] posicoes = new Vector2[9];

    private int tamanhoTela;
    private int tamanhoFonte;

    private double tamanhoCelula;
    private double meioDaCelula;

    public CentroCelulas(int tamanhoFonte, EngineFrame e) {

        this.tamanhoTela = e.getScreenWidth();
        this.tamanhoFonte = tamanhoFonte;

        tamanhoCelula = tamanhoTela / 3.0;
        meioDaCelula = tamanhoCelula / 2;

    }

    public Vector2 getVetorPosicao(int celula, double tamanhoDoTexto) {
        return getPosicao(celula, tamanhoDoTexto);
    }

    public Vector2 getPosicao(int indice, double tamanhoDoTexto) { //acho que da pra deixar esse metodo privado depois, usando so o de cima

        posicoes[0] = new Vector2(meioDaCelula - (tamanhoDoTexto / 2), meioDaCelula - tamanhoFonte / 3.4);
        posicoes[1] = new Vector2((meioDaCelula + tamanhoCelula) - (tamanhoDoTexto / 2), meioDaCelula - tamanhoFonte / 3.4);
        posicoes[2] = new Vector2((meioDaCelula + tamanhoCelula * 2) - (tamanhoDoTexto / 2), meioDaCelula - tamanhoFonte / 3.4);
        posicoes[3] = new Vector2(meioDaCelula - (tamanhoDoTexto / 2), (meioDaCelula + tamanhoCelula) - tamanhoFonte / 3.4);
        posicoes[4] = new Vector2((meioDaCelula + tamanhoCelula) - (tamanhoDoTexto / 2), (meioDaCelula + tamanhoCelula) - tamanhoFonte / 3.4);
        posicoes[5] = new Vector2((meioDaCelula + tamanhoCelula * 2) - (tamanhoDoTexto / 2), (meioDaCelula + tamanhoCelula) - tamanhoFonte / 3.4);
        posicoes[6] = new Vector2(meioDaCelula - (tamanhoDoTexto / 2), (meioDaCelula + tamanhoCelula * 2) - tamanhoFonte / 3.4);
        posicoes[7] = new Vector2((meioDaCelula + tamanhoCelula) - (tamanhoDoTexto / 2), (meioDaCelula + tamanhoCelula * 2) - tamanhoFonte / 3.4);
        posicoes[8] = new Vector2((meioDaCelula + tamanhoCelula * 2) - (tamanhoDoTexto / 2), (meioDaCelula + tamanhoCelula * 2) - tamanhoFonte / 3.4);

        return posicoes[indice];
    }
}
