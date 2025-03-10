package me.gonzager.ex.operaciones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import me.gonzager.ex.drones.Dron;
import me.gonzager.ex.drones.DronComercial;
import me.gonzager.ex.drones.DronSeguridad;

import me.gonzager.ex.misiones.MisionTransporte;
import me.gonzager.ex.misiones.MisionVigilancia;

public class EscuadronTest {
    Escuadron escuadron = new Escuadron();
    private Dron dronSeguridad = new DronSeguridad(8, 52);
    private Dron dronComercial = new DronComercial(1, 10);

    private MisionVigilancia misionVigilancia = new MisionVigilancia();
    private MisionTransporte misionTransporte = new MisionTransporte();;

    @BeforeEach
    private void init() {
        dronComercial.setMision(misionTransporte);
        dronSeguridad.setMision(misionVigilancia);
        escuadron.agregarDron(dronComercial);
        escuadron.agregarDron(dronSeguridad);

    }

    @Test()
    void testNoSePuedeAgregarDronAlEscuadron() {
        Escuadron.setCantidadMaximaDrones(0);
        assertThrows(IllegalArgumentException.class, () -> {
            escuadron.agregarDron(new DronComercial(0, 0));
        });
    }

    @Test()
    void noPuedeOperarZona() {
        var zona = new Zona(100);
        assertFalse(escuadron.puedeOperar(zona));
    }

    @Test()
    void puedeOperarZona() {
        var zona = new Zona(5);
        assertTrue(escuadron.puedeOperar(zona));
    }

    @Test()
    void operarZona() {
        var zona = new Zona(5);
        escuadron.operarZona(zona);
        assertEquals(1, zona.getCantidadOperacionesRecibidas());
        assertEquals(6, dronSeguridad.getAutonomia());
        assertEquals(0, dronComercial.getAutonomia());
    }

}
