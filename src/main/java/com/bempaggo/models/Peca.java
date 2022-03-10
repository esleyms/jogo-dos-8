package com.bempaggo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor @ToString
public class Peca {
    private int numeroPeca;
    private boolean isAdjacente;
}
