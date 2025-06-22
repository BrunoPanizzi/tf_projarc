package com.example.imposto.presentation.dtos.enums;

public enum State {
    RIO_GRANDE_DO_SUL("Rio Grande do Sul"),
    SAO_PAULO("Sao Paulo"),
    PERNAMBUCO("Pernambuco");

    private final String displayName;

    State(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
