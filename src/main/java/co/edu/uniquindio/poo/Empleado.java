package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;


public abstract class Empleado {
    private String nombre;
    private String cargo;

    public Empleado(String texto, String cargo) {
        ASSERTION.assertion(texto != null, "El texto es requerido");
        ASSERTION.assertion(cargo != null, "El cargo es requerido");
        this.nombre = texto;
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String texto) {
        this.nombre = texto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public abstract int calcularSalario();

}