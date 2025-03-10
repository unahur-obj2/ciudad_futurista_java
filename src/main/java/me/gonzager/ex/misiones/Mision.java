package me.gonzager.ex.misiones;

import me.gonzager.ex.drones.Dron;

public abstract class Mision {
    public abstract Integer eficienciaOperativa();

    public abstract Boolean estaEnMisionAvanzada(Dron dron);

}
