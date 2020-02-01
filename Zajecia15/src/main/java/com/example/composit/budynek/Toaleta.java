package com.example.composit.budynek;

import org.jetbrains.annotations.NotNull;

public class Toaleta implements Pomieszczenie {
    private Double dlugosc;
    private Double szerokosc;

    public Toaleta(@NotNull Double dlugosc, @NotNull Double szerokosc) {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
    }

    @Override
    public @NotNull String getName() {
        return "Toaleta";
    }

    @Override
    public @NotNull Double powierzchnia() {
        return dlugosc * szerokosc;
    }
}
