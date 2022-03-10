package com.bempaggo.service.impl;

import com.bempaggo.models.Tabuleiro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JogoServiceTest {

    private JogoService jogoService;
    private Tabuleiro tabuleiro;

    @Before
    public void iniciarTestes(){
        jogoService = new JogoService();
        tabuleiro  = jogoService.gerarEstadoInicial();
    }

    @Test
    public void testEncontrarPecasAdjacentesEstadoInicial(){
        List<Integer> adjacentesList = jogoService.encontrarPecasAdjacentes(tabuleiro.getPecas());
        Assert.assertEquals("[6, 5]", adjacentesList.toString() );
    }

    @Test
    public void testEncontrarPecasAdjacentesPecaNula(){
        List<Integer> adjacentesList = jogoService.encontrarPecasAdjacentes(null);
        Assert.assertEquals(0, adjacentesList.size() );
    }

    @Test
    public void testEncontrarQuantidadePecasAdjacentesEstadoInicial(){
        List<Integer> adjacentesList = jogoService.encontrarPecasAdjacentes(tabuleiro.getPecas());
        Assert.assertEquals(2, adjacentesList.size() );
    }
}
