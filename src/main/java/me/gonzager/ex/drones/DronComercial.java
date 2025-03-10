package me.gonzager.ex.drones;

public class DronComercial extends Dron {

    public DronComercial(Integer autonomia, Integer procesamiento) {
        super(autonomia, procesamiento);
    }

    @Override
    public Integer eficienciaOperativa() {
        return super.eficienciaOperativa() + 15;
    }

    @Override
    public Boolean esDronAvanzado() {
        return false;
    }
}
