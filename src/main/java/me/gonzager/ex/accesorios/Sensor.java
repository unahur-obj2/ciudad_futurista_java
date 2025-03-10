package me.gonzager.ex.accesorios;

public class Sensor {
    private Integer capacidad;
    private Integer durabilidad;
    private Boolean mejorasTecnologicas;

    public Sensor(Integer capacidad, Integer durabilidad, Boolean mejorasTecnologicas) {
        this.capacidad = capacidad;
        this.durabilidad = durabilidad;
        this.mejorasTecnologicas = mejorasTecnologicas;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Integer getDurabilidad() {
        return durabilidad;
    }

    public Boolean getMejorasTecnologicas() {
        return mejorasTecnologicas;
    }

    public Integer efecienciaOperativa() {
        return !mejorasTecnologicas ? capacidad : 2 * capacidad;
    }

    public Boolean esDuradero() {
        return durabilidad > 2 * capacidad;
    }

}
