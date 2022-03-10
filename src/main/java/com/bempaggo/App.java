package com.bempaggo;

import com.bempaggo.models.Tabuleiro;
import com.bempaggo.service.impl.JogoService;

import java.util.List;
import java.util.Scanner;

/**
 * Processo Seletivo da BemPaggo
 *
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
/**
 * CRIAR A PLACA
 * INCLUIR 8 BLOCOS
 *
 * Estado inicial = [1, 2, 3, 4, 8, 6, 7, 5]
 * Estado final = [1, 2, 3, 4, 5, 6, 7, 8]
 */