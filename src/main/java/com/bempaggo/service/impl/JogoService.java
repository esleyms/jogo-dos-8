package com.bempaggo.service.impl;

import com.bempaggo.models.Peca;
import com.bempaggo.models.Tabuleiro;
import com.bempaggo.service.IJogoService;

import java.util.ArrayList;
import java.util.List;

public class JogoService implements IJogoService {

    @Override
    public Tabuleiro gerarEstadoInicial() {
        // logica para criar estado inicial do tabuleiro
        Tabuleiro tabuleiro = new Tabuleiro();
        Peca[][] pecas = new Peca[3][3];
        pecas[0][0] = new Peca(1, false);
        pecas[0][1] = new Peca(2, false);
        pecas[0][2] = new Peca(3, false);
        pecas[1][0] = new Peca(4, false);
        pecas[1][1] = new Peca(8, false);
        pecas[1][2] = new Peca(6, true);
        pecas[2][0] = new Peca(7, false);
        pecas[2][1] = new Peca(5, true);
        pecas[2][2] = null;
        tabuleiro.setPecas(pecas);
        tabuleiro.setIndiceLinhaEspacoVazio(2);
        tabuleiro.setIndiceColunaEspacoVazio(2);
        return tabuleiro;
    }

    @Override
    public List<Integer> encontrarPecasAdjacentes(Peca[][] pecas) {
        List<Integer> pecasAdjacentes = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(pecas[i][j] != null && pecas[i][j].isAdjacente()){
                    pecasAdjacentes.add(pecas[i][j].getNumeroPeca());
                }
            }
        }
        return pecasAdjacentes;
    }

    @Override
    public Tabuleiro moverPecaNoTabuleiro(Tabuleiro tabuleiro, Integer pecaSelecionada) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(tabuleiro.getPecas()[i][j] != null && tabuleiro.getPecas()[i][j].getNumeroPeca() == pecaSelecionada){
                    Peca[][] pecas = tabuleiro.getPecas();
                    //troca espaco vazio pela pecaSelecionada
                    pecas[tabuleiro.getIndiceLinhaEspacoVazio()][tabuleiro.getIndiceColunaEspacoVazio()] = pecas[i][j];
                    // indice da peca selecionada convertido no espaco vazio
                    tabuleiro.setIndiceLinhaEspacoVazio(i);
                    tabuleiro.setIndiceColunaEspacoVazio(j);
                    pecas[i][j] = null;
                    // setar novos adjacentes
                    tabuleiro.setPecas(redefinirPecasAdjacentes(pecas, i, j));

                    return tabuleiro;
                }
            }
        }
        return tabuleiro;
    }

    @Override
    public Peca[][] redefinirPecasAdjacentes(Peca[][] pecas, int indiceLinhaEspacoVazio, int indiceColunaEspacoVazio) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(pecas[i][j] != null && pecas[i][j].isAdjacente()){
                    pecas[i][j].setAdjacente(false);
                }
            }
        }
        try{
            // peca a esquerda
            Peca peca = pecas[indiceLinhaEspacoVazio][indiceColunaEspacoVazio-1];
            peca.setAdjacente(true);
            pecas[indiceLinhaEspacoVazio][indiceColunaEspacoVazio-1] = peca;
        }catch(ArrayIndexOutOfBoundsException e){

        }
        try{
            // peca a direita
            Peca peca = pecas[indiceLinhaEspacoVazio][indiceColunaEspacoVazio+1];
            peca.setAdjacente(true);
            pecas[indiceLinhaEspacoVazio][indiceColunaEspacoVazio+1] = peca;
        }catch(ArrayIndexOutOfBoundsException e){

        }
        try{
            // peca acima
            pecas[indiceLinhaEspacoVazio-1][indiceColunaEspacoVazio].setAdjacente(true);
        }catch(ArrayIndexOutOfBoundsException e){

        }
        try{
            // peca abaixo
            pecas[indiceLinhaEspacoVazio+1][indiceColunaEspacoVazio].setAdjacente(true);
        }catch(ArrayIndexOutOfBoundsException e){

        }

        return pecas;
    }


}
