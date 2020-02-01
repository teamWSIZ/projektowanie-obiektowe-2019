package com.example.composit.budynek;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Pietro implements Pomieszczenie {
    ArrayList<Pomieszczenie> pomieszczenia = new ArrayList<>();

    @Override
    public @NotNull String getName() {
        return "Piętro";
    }

    @Override
    public @NotNull Double powierzchnia() {
        Double powierzchnia = 0.0;

        for (Pomieszczenie pomieszczenie : pomieszczenia)
            powierzchnia += pomieszczenie.powierzchnia();

        return powierzchnia;
    }

    public void dodajPomieszczenie(Pomieszczenie pomieszczenie) {
        pomieszczenia.add(pomieszczenie);
    }
}
