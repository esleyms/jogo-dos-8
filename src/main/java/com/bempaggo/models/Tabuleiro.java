package com.bempaggo.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@Setter
@ToString
public class Tabuleiro {
    private Peca[][] pecas;
    private int indiceLinhaEspacoVazio;
    private int indiceColunaEspacoVazio;

    @Override
    public String toString() {
        String estadoAtual = "";
        for (int i = 0; i < 3; i++) {
            String linha = "";
            for (int j = 0; j < 3; j++) {
                if(pecas[i][j] != null){
                    linha += " "+pecas[i][j].getNumeroPeca();
                }else{
                    linha += " *";
                }
            }
            estadoAtual += "\n"+linha;
        }

        return estadoAtual;
    }
}
