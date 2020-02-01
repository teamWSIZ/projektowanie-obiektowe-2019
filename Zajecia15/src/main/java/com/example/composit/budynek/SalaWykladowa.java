package com.example.composit.budynek;

import com.example.composit.wyposarzenie.Komputer;
import com.example.composit.wyposarzenie.Tablica;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SalaWykladowa extends Sala {
    Tablica tablica;

    ArrayList<Komputer> komputery;

    public SalaWykladowa(@NotNull Double dlugosc, @NotNull Double szerokosc, ArrayList<Komputer> komputery, Tablica tablica) {
        super(dlugosc, szerokosc);

        this.tablica = tablica;
        this.komputery = komputery;

        if(tablica==null||komputery==null)
            zakupWyposarzenie();
    }

    private void zakupWyposarzenie() {
        if (tablica == null) {
            tablica = new Tablica();
        }

        if (komputery == null) {
            komputery = new ArrayList<>();
        }
    }
}
