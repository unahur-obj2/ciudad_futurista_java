package me.gonzager.ex.misiones;

import me.gonzager.ex.drones.Dron;

public class MisionExploracion extends Mision {

    @Override
    public Integer eficienciaOperativa() {
        return 0;
    }

    public Boolean estaEnMisionAvanzada(Dron dron) {
        return dron.eficienciaOperativa() % 2 == 0;
    }
}
