package com.challenge.odonto_prev.enums;

public enum Procedure {
    FILLING("Restauração"),
    ROOT_CANAL("Tratamento de Canal"),
    TOOTH_EXTRACTION("Extração Dental"),
    TEETH_WHITENING("Clareamento Dental"),
    BRACES_REMOVAL("Remoção de Aparelho Ortodôntico"),
    METAL_BRACES_INSTALLATION("Colocação de Aparelho Metálico"),
    DENTAL_PROSTHETICS("Prótese Dentária");

    private String description;

    Procedure(String description) {
        this.description = description;
    }
}

