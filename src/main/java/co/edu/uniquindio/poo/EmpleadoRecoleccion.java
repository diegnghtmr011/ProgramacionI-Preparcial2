package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class EmpleadoRecoleccion extends Empleado {
    private int numeroKilos;
    private int valorKilo;

    public EmpleadoRecoleccion(String nombre, String cargo, int numeroKilos, int valorKilo) {
        super(nombre, cargo);
        ASSERTION.assertion(numeroKilos > 0, "El numero de kilos es requerido");
        ASSERTION.assertion(valorKilo > 0, "El numero de horas es requerido");
        this.numeroKilos = numeroKilos;
        this.valorKilo = valorKilo;
    }

    public int getNumeroKilos() {
        return numeroKilos;
    }

    public void setNumeroKilos(int numeroKilos) {
        this.numeroKilos = numeroKilos;
    }

    public int getValorKilo() {
        return valorKilo;
    }

    public void setValorKilo(int valorKilo) {
        this.valorKilo = valorKilo;
    }

    public int calcularSalario() {
        int salario = (valorKilo * numeroKilos);
        return salario;
    }

}
