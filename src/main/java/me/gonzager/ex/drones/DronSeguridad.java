package me.gonzager.ex.drones;

public class DronSeguridad extends Dron {

    public DronSeguridad(Integer autonomia, Integer procesamiento) {
        super(autonomia, procesamiento);
    }

    public Boolean esDronAvanzado() {
        return this.getProcesamiento() > 50;
    }
}
