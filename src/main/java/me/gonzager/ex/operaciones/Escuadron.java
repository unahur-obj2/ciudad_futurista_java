package me.gonzager.ex.operaciones;

import java.util.ArrayList;
import java.util.List;

import me.gonzager.ex.drones.Dron;

public class Escuadron {
    public static Integer cantidadMaximaDeDrones = 10;

    public List<Dron> drones = new ArrayList<Dron>();

    public static void setCantidadMaximaDrones(Integer cantidad) {
        Escuadron.cantidadMaximaDeDrones = cantidad;
    }

    public void agregarDron(Dron dron) {
        if (drones.size() >= Escuadron.cantidadMaximaDeDrones)
            throw new IllegalArgumentException("Supera la cantidad máxima de drones");
        drones.add(dron);
    }

    public Boolean puedeOperar(Zona zona) {
        return this.alMenosUnDronAvanazado() && this.capacidadOperativaEscuadron() > 2 * zona.getTamanio();
    }

    private Boolean alMenosUnDronAvanazado() {
        return drones.stream().anyMatch(dron -> dron.esAvanzado());
    }

    private Integer capacidadOperativaEscuadron() {
        return drones.stream().map(dron -> dron.eficienciaOperativa()).reduce(0, Integer::sum);
    }

    public void operarZona(Zona zona) {
        if (this.puedeOperar(zona)) {
            zona.aumentarOperacionesRecibidas(1);
            drones.stream().forEach(dron -> dron.disminuirAutonomia(2));
        }
    }

}
