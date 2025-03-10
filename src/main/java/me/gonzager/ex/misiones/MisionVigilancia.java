package me.gonzager.ex.misiones;

import java.util.ArrayList;
import java.util.List;

import me.gonzager.ex.accesorios.Sensor;
import me.gonzager.ex.drones.Dron;

public class MisionVigilancia extends Mision {
    private List<Sensor> sensores = new ArrayList<>();

    public MisionVigilancia() {
    };

    public MisionVigilancia(List<Sensor> sensores) {
        this.sensores = sensores;
    }

    public void addSensor(Sensor unSensor) {
        sensores.add(unSensor);
    }

    public Boolean tieneSensorConMejorasTecnologicas() {
        return this.sensores.stream().anyMatch(sensor -> sensor.getMejorasTecnologicas());
    }

    @Override
    public Integer eficienciaOperativa() {
        return sensores.stream().map(s -> s.efecienciaOperativa()).reduce(0, Integer::sum);
    }

    @Override
    public Boolean estaEnMisionAvanzada(Dron dron) {
        return this.sensores.stream().allMatch(s -> s.esDuradero());
    }
}
