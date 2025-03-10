package me.gonzager.ex.drones;

import me.gonzager.ex.misiones.Mision;

public abstract class Dron {
    private Integer autonomia;
    private Integer procesamiento;
    private Mision mision;

    public Dron(Integer autonomia, Integer procesamiento) {
        this.autonomia = autonomia;
        this.procesamiento = procesamiento;
    }

    public Integer getAutonomia() {
        return autonomia;
    }

    public Integer getProcesamiento() {
        return procesamiento;
    }

    public Mision getMision() {
        return mision;
    }

    public void setMision(Mision mision) {
        this.mision = mision;
    }

    public void disminuirAutonomia(Integer cantidad) {
        autonomia = Integer.max(0, autonomia - cantidad);
    }

    public Integer eficienciaOperativa() {
        return autonomia * 10 + mision.eficienciaOperativa();
    }

    public Boolean esAvanzado() {
        return this.esDronAvanzado() || this.estaEnMisionAvanzada();
    }

    public abstract Boolean esDronAvanzado();

    public Boolean estaEnMisionAvanzada() {
        return mision.estaEnMisionAvanzada(this);
    }

}
