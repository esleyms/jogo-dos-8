package com.bempaggo.service;

import com.bempaggo.models.Peca;
import com.bempaggo.models.Tabuleiro;

import java.util.List;

public interface IJogoService {
    Tabuleiro gerarEstadoInicial();
    List<Integer> encontrarPecasAdjacentes(Peca[][] pecas);
    Tabuleiro moverPecaNoTabuleiro(Tabuleiro tabuleiro, Integer pecaMovida);
    Peca[][] redefinirPecasAdjacentes(Peca[][] pecas, int indiceLinhaEspacoVazio, int indiceColunaEspacoVazio);
}
