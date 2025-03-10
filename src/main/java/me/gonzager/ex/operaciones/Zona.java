package me.gonzager.ex.operaciones;

public class Zona {
    private Integer tamanio;
    private Integer cantidadOperacionesRecibidas = 0;

    public Zona(Integer tamanio) {
        this.tamanio = tamanio;
    }

    public Integer getTamanio() {
        return tamanio;
    }

    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }

    public Integer getCantidadOperacionesRecibidas() {
        return cantidadOperacionesRecibidas;
    }

    public void aumentarOperacionesRecibidas(Integer cantidadOperacionesRecibidas) {
        this.cantidadOperacionesRecibidas += cantidadOperacionesRecibidas;
    }

}
