package com.bempaggo;

import com.bempaggo.models.Tabuleiro;
import com.bempaggo.service.impl.JogoService;



import java.util.List;
import java.util.Scanner;

/**
 * Processo Seletivo da BemPaggo
 *
 * O Jogo dos Oito é um jogo de tabuleiro.
 * O jogo é estruturado em um tabuleiro 3×3 com 8 peças (cada peça tem um número de 1 a 8) e um espaço vazio.
 * O objetivo é colocar os números nas peças para combinar com a configuração final usando o espaço vazio.
 * Podemos deslizar quatro peças adjacentes (esquerda, direita, acima e abaixo) no espaço vazio.
 */



public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Processo Seletivo da BemPaggo" );

        JogoService jogoService = new JogoService();
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro = jogoService.gerarEstadoInicial();
        boolean continuarJogo = true;
        Scanner scanner;
        int opcao;

        do {
            List<Integer> pecasAdjacentes = jogoService.encontrarPecasAdjacentes(tabuleiro.getPecas());
            System.out.println( tabuleiro.toString() );
            System.out.println( "Qual peca gostaria de mover?" );
            System.out.println( pecasAdjacentes.toString() );
            scanner = new Scanner(System.in);
            opcao = scanner.nextInt();
            if(pecasAdjacentes.contains(opcao)){
                tabuleiro = jogoService.moverPecaNoTabuleiro(tabuleiro, opcao);
                // verificar se tabuleiro encontra-se no estado final e setar continuarJogo = false
            }else{
                System.out.println( "Movimento invalido!" );
            }

        }while (continuarJogo);
    }
}
