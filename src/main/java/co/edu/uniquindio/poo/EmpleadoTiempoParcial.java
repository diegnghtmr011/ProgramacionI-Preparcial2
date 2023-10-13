package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class EmpleadoTiempoParcial extends Empleado {
    private int numeroHoras;
    private int salarioHora;

    public EmpleadoTiempoParcial(String nombre, String cargo, int numeroHoras, int salarioHora) {
        super(nombre, cargo);
        ASSERTION.assertion(numeroHoras > 0, "El numero de horas es requerido");
        ASSERTION.assertion(salarioHora > 0, "El numero de horas es requerido");
        this.numeroHoras = numeroHoras;
        this.salarioHora = salarioHora;
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public int getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(int salarioHora) {
        this.salarioHora = salarioHora;
    }

    public int calcularSalario() {
        int salario = (salarioHora * numeroHoras);
        return salario;
    }

}
