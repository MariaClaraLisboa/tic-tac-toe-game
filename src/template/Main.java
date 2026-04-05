package template;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;

import java.util.Scanner;

public class Main extends EngineFrame {

    int[][] tabuleiro;
    int posicaoLinha;
    int posicaoColuna;
    int rodada;

    int comecoLinhaPosiVencedora;
    int comecoColPosiVencedora;
    int fimLinhaPosiVencedora;
    int fimColPosiVencedora;

    boolean oVenceu;
    boolean xVenceu;
    boolean empatou;

    boolean vertical;
    boolean horizontal;
    boolean diagonalEsquerda;
    boolean diagonalDireita;

    public Main() {
        super(
            400,                 // largura                      / width
            400,                 // altura                       / height
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
    public void create() { //inicializa as variáveis somente uma vez, nos outros métodos nao funciona pois eles ficam rodando 60fps

        tabuleiro = new int[3][3];
        rodada = 0; //serve pra decidir qual jogador irá jogar

        oVenceu = false;
        xVenceu = false;
        empatou = false;

        //Para colocar uma linha sob os 3 símbolos responsáveis pela vitória
        vertical = false;
        horizontal = false;
        diagonalEsquerda = false;
        diagonalDireita = false;
    }

    @Override
    public void update( double delta ) { //A lógica do código ta toda aqui

        Scanner scan = new Scanner(System.in);

        if( rodada > 0 ) {  //Se a rodada for a 0, ela nao roda, ela pula pro metodo draw() pra aparecer o tabuleiro primeiro antes de perguntar no terminal

            if ( rodada % 2 == 0 ) {  //se o numero da rodada for par, o X joga

                while ( posicaoLinha > 2 || posicaoColuna > 2 || tabuleiro[posicaoLinha][posicaoColuna] != 0 ){ //While evita colocar em posições repetidas ou inválidas, só coloca se o número for 0
                     System.out.printf("\nRodada %d \n(X) Qual posição você deseja?\n", rodada);

                     System.out.println("Linha:");
                     posicaoLinha = Integer.parseInt(scan.nextLine());
                     System.out.println("Coluna:");
                     posicaoColuna = Integer.parseInt(scan.nextLine());
                 }

                 tabuleiro[posicaoLinha][posicaoColuna] = 1; //Depois de passar pelo while, ele preenche o numero 1 no array, peça X é colocada

            }

            else{ //senao o jogador O joga

                System.out.printf("\nRodada %d \n(O) Qual posição você deseja?\n", rodada);

                System.out.println("Linha:"); //aqui, o O é o primeiro a jogar, entao ele pergunta fora antes, ai caso seja repetido, ele entra no while
                posicaoLinha = Integer.parseInt(scan.nextLine());
                System.out.println("Coluna:");
                posicaoColuna = Integer.parseInt(scan.nextLine());

                while ( posicaoLinha > 2 || posicaoColuna > 2 || tabuleiro[posicaoLinha][posicaoColuna] != 0 ){ //A ORDEM IMPORTA DENTRO DOS WHILE, senao pode dar erro, caso ele teste um array que não pode existir
                    System.out.printf("\nRodada %d \n(O) Qual posição você deseja?\n", rodada);

                    System.out.println("Linha:");
                    posicaoLinha = Integer.parseInt(scan.nextLine());
                    System.out.println("Coluna:");
                    posicaoColuna = Integer.parseInt(scan.nextLine());
                }

                tabuleiro[posicaoLinha][posicaoColuna] = 2; //preenche a célula com o numero 2, correspondente à bolinha

            }
        }

        //**********************************************************
        //Aqui entra no bloco que vai verificar se houve uma vitória

        //VITÓRIAS DA BOLINHA
        //vitória horizontal da bolinha
        for ( int i = 0; i < 3; i++ ) {

            for ( int j = 0; j < 1; j++ ) {

                if( tabuleiro[i][j] == 2 && tabuleiro[i][j+1] == 2 && tabuleiro[i][j+2]==2 ){
                    horizontal = true;
                    oVenceu = true;

                    comecoLinhaPosiVencedora = i;
                    comecoColPosiVencedora = j;
                    fimLinhaPosiVencedora = i;
                    fimColPosiVencedora = j+2;

                }
            }
        }

        //vitória vertical da bolinha
        for ( int i = 0; i < 1; i++ ) {

            for ( int j = 0; j < 3; j++ ) {

                if( tabuleiro[i][j] == 2 && tabuleiro[i+1][j] == 2 && tabuleiro[i+2][j]==2 ){
                    vertical = true;
                    oVenceu = true;

                    comecoLinhaPosiVencedora = i;
                    comecoColPosiVencedora = j;
                    fimLinhaPosiVencedora = i+2;
                    fimColPosiVencedora = j;

                }
            }
        }

        //Casos específicos de diagonal
        //vitória diagonal esquerda da bolinha
        if( tabuleiro[0][0] == 2 && tabuleiro[1][1] == 2 && tabuleiro[2][2] == 2 ){
            diagonalEsquerda = true;
            oVenceu = true;
        }

        //vitória diagonal direita da bolinha
        if( tabuleiro[0][2] == 2 && tabuleiro[1][1] == 2 && tabuleiro[2][0] == 2 ){
            diagonalDireita = true;
            oVenceu = true;
        }

        //VITÓRIAS DO X
        //vitória horizontal do X
        for ( int i = 0; i < 3; i++ ) {

            for ( int j = 0; j < 1; j++ ) {

                if( tabuleiro[i][j] == 1 && tabuleiro[i][j+1] == 1 && tabuleiro[i][j+2]==1 ){
                    horizontal = true;
                    xVenceu = true;

                    comecoLinhaPosiVencedora = i;
                    comecoColPosiVencedora = j;
                    fimLinhaPosiVencedora = i;
                    fimColPosiVencedora = j+2;

                }
            }
        }
        //vitória vertical do X
        for ( int i = 0; i < 1; i++ ) {

            for ( int j = 0; j < 3; j++ ) {

                if( tabuleiro[i][j] == 1 && tabuleiro[i+1][j] == 1 && tabuleiro[i+2][j]==1 ){
                    vertical = true;
                    xVenceu = true;

                    comecoLinhaPosiVencedora = i;
                    comecoColPosiVencedora = j;
                    fimLinhaPosiVencedora = i+2;
                    fimColPosiVencedora = j;

                }
            }
        }

        //Casos específicos de diagonal
        //vitória diagonal esquerda do X
        if( tabuleiro[0][0] == 1 && tabuleiro[1][1] == 1 && tabuleiro[2][2] == 1 ){
            diagonalEsquerda = true;
            xVenceu = true;
        }

        //vitória diagonal direita do X
        if( tabuleiro[0][2] == 1 && tabuleiro[1][1] == 1 && tabuleiro[2][0] == 1 ){
            diagonalDireita = true;
            xVenceu = true;
        }

        //****************************************************************
        //Só podem ter até 9 rodadas, se passa disso é porque houve empate
        if ( rodada >= 9 ) {
            empatou = true;
        }

        if( empatou || xVenceu || oVenceu ){
            if( rodada !=0 ) System.out.println("Fim de jogo!");
            rodada = 0; //Nunca mais entra no primeiro if e para o jogo!
        }
        else {
            rodada++; // Próxima rodada
        }

    }

    @Override
    public void draw() {

        //Monta o tabuleiro
        drawLine(133, 0, 133, getScreenHeight(), BLACK);
        drawLine(266, 0, 266, getScreenHeight(), BLACK);
        drawLine(0, 133, getScreenWidth(), 133, BLACK);
        drawLine(0, 266, getScreenWidth(), 266, BLACK);

        //Desenha es peças que foram colocadas, no tabuleiro
        for ( int i = 0; i < 3; i++ ) {

            for ( int j = 0; j < 3; j++ ) {

                if ( tabuleiro[i][j] == 1 ) {
                    drawText("X", (getScreenWidth() / 3 * j) + 21, (getScreenHeight() / 3 * i) + 16, 150, RED);
                }

                else if ( tabuleiro[i][j] == 2 ) {
                    drawText("O", (getScreenWidth() / 3 * j) + 21, (getScreenHeight() / 3 * i) + 16, 150, SKYBLUE);
                }

            }
        }

        //Tanto faz quem venceu, a linha que vai ser desenhada pra simbolizar onde foi feita a vitória é a mesma, oque importa é se houve vitória ou não
        if ( xVenceu || oVenceu ) {

            if( vertical ) {
                drawLine((getScreenWidth() / 3 * comecoColPosiVencedora) + 67, (getScreenHeight() / 2 * comecoLinhaPosiVencedora) + 15, (getScreenWidth() / 3 * fimColPosiVencedora) + 67, (getScreenHeight() / 2 * fimLinhaPosiVencedora) - 15, BLACK);
            }

            if ( horizontal ) {
                drawLine((getScreenWidth() / 2 * comecoColPosiVencedora) + 15, (getScreenHeight() / 3 * comecoLinhaPosiVencedora) + 67, (getScreenWidth() / 2 * fimColPosiVencedora) - 15, (getScreenHeight() / 3 * fimLinhaPosiVencedora) + 67, BLACK);
            }

            if( diagonalEsquerda ){
                drawLine(30, 30, getScreenWidth()-30 , getScreenHeight()-30 , BLACK);
            }

            if( diagonalDireita ){
                drawLine(getScreenWidth() - 30, 30, 30 , getScreenHeight()-30 , BLACK);
            }

        }

        //Se der empate ou vitória, escreve na tela o acontecimento
        if( empatou ){
            fillRectangle(7,getScreenHeight()/2-35,386, 70, BLACK);
            drawText("     EMPATE!", getScreenWidth()/3-110,getScreenHeight()/2-14,35,PURPLE);
        }

        if ( xVenceu ){
            fillRectangle(7,getScreenHeight()/2-35,386, 70, BLACK);
            drawText("JOGADOR X VENCEU!", getScreenWidth()/3-110,getScreenHeight()/2-14,35,RED);
        }

        if( oVenceu ) {
            fillRectangle(7,getScreenHeight()/2-35,386, 70, BLACK);
            drawText("JOGADOR O VENCEU!", getScreenWidth() / 3 - 110, getScreenHeight() / 2-14, 35, SKYBLUE);
        }

    }

    public static void main( String[] args ) {
        new Main();
    }
}
