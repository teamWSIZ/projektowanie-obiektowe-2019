package com.example.composit.budynek;

import org.jetbrains.annotations.NotNull;

public class Kuchnia implements Pomieszczenie {
    private Double dlugosc;
    private Double szerokosc;

    public Kuchnia(@NotNull Double dlugosc, @NotNull Double szerokosc) {
        this.dlugosc = dlugosc;
        this.szerokosc = szerokosc;
    }

    @Override
    @NotNull
    public String getName() {
        return "Kuchnia";
    }

    @Override
    @NotNull
    public Double powierzchnia() {
        return dlugosc * szerokosc;
    }
}
