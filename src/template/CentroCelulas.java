package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.math.Vector2;

public class CentroCelulas {
    //Depois transforma tudo isso aqui em 1 array só
    private Vector2 posicao0;
    private Vector2 posicao1;
    private Vector2 posicao2;
    private Vector2 posicao3;
    private Vector2 posicao4;
    private Vector2 posicao5;
    private Vector2 posicao6;
    private Vector2 posicao7;
    private Vector2 posicao8;

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

        if (celula == 0) { return getPosicao0(tamanhoDoTexto); } //coloca um for aqui depois
        else if (celula == 1) { return getPosicao1(tamanhoDoTexto); }
        else if (celula == 2) { return getPosicao2(tamanhoDoTexto); }
        else if (celula == 3) { return getPosicao3(tamanhoDoTexto); }
        else if (celula == 4) { return getPosicao4(tamanhoDoTexto); }
        else if (celula == 5) { return getPosicao5(tamanhoDoTexto); }
        else if (celula == 6) { return getPosicao6(tamanhoDoTexto); }
        else if (celula == 7) { return getPosicao7(tamanhoDoTexto); }
        else { return getPosicao8(tamanhoDoTexto); }

    }

    public Vector2 getPosicao0(double tamanhoDoTexto) {
            posicao0 = new Vector2(meioDaCelula - (tamanhoDoTexto / 2), meioDaCelula - tamanhoFonte / 3.4);
            return posicao0;
    }

    public Vector2 getPosicao1(double tamanhoDoTexto) {

            posicao1 = new Vector2((meioDaCelula + tamanhoCelula) - (tamanhoDoTexto / 2), meioDaCelula - tamanhoFonte / 3.4);
            return posicao1;

    }

    public Vector2 getPosicao2(double tamanhoDoTexto) {

            posicao2 = new Vector2((meioDaCelula + tamanhoCelula * 2) - (tamanhoDoTexto / 2), meioDaCelula - tamanhoFonte / 3.4);
            return posicao2;

    }

    public Vector2 getPosicao3(double tamanhoDoTexto) {
            posicao3 = new Vector2(meioDaCelula - (tamanhoDoTexto / 2), (meioDaCelula + tamanhoCelula) - tamanhoFonte / 3.4);
            return posicao3;
    }

    public Vector2 getPosicao4(double tamanhoDoTexto) {
            posicao4 = new Vector2((meioDaCelula + tamanhoCelula) - (tamanhoDoTexto / 2), (meioDaCelula + tamanhoCelula) - tamanhoFonte / 3.4);
            return posicao4;
    }

    public Vector2 getPosicao5(double tamanhoDoTexto) {
            posicao5 = new Vector2((meioDaCelula + tamanhoCelula * 2) - (tamanhoDoTexto / 2), (meioDaCelula + tamanhoCelula) - tamanhoFonte / 3.4);
            return posicao5;
    }

    public Vector2 getPosicao6(double tamanhoDoTexto) {
            posicao6 = new Vector2(meioDaCelula - (tamanhoDoTexto / 2), (meioDaCelula + tamanhoCelula * 2) - tamanhoFonte / 3.4);
            return posicao6;
    }

    public Vector2 getPosicao7(double tamanhoDoTexto) {
            posicao7 = new Vector2((meioDaCelula + tamanhoCelula) - (tamanhoDoTexto / 2), (meioDaCelula + tamanhoCelula * 2) - tamanhoFonte / 3.4);
            return posicao7;
    }

    public Vector2 getPosicao8(double tamanhoDoTexto) {
            posicao8 = new Vector2((meioDaCelula + tamanhoCelula * 2) - (tamanhoDoTexto / 2), (meioDaCelula + tamanhoCelula * 2) - tamanhoFonte / 3.4);
            return posicao8;
    }
}
