package com.example.composit.budynek;

import org.jetbrains.annotations.NotNull;

public class Szatnia implements Pomieszczenie{
    Double powierzchnia;

    public Szatnia(@NotNull Double powierzchnia){
        this.powierzchnia = powierzchnia;
    }

    @Override
    public @NotNull String getName() {
        return "Szatnia";
    }

    @Override
    public @NotNull Double powierzchnia() {
        return powierzchnia;
    }
}
