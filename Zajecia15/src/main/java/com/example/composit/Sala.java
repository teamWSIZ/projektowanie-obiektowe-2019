package com.example.composit;

import org.jetbrains.annotations.NotNull;

public class Sala implements Pomieszczenie {
    private Double dlugosc;
    private Double szerokosc;

    Sala(@NotNull Double dlugosc, @NotNull Double szerokosc) {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
    }

    @Override
    public @NotNull String getName() {
        return "Sala";
    }

    @Override
    public @NotNull Double powierzchnia() {
        return dlugosc * szerokosc;
    }
}
