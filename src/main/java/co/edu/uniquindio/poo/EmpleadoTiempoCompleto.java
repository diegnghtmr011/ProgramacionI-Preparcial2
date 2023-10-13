package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class EmpleadoTiempoCompleto extends Empleado {
    private int salario;

    public EmpleadoTiempoCompleto(String nombre, String cargo, int salario) {
        super(nombre, cargo);
        ASSERTION.assertion(salario > 0, "El salario es requerido");
        this.salario = salario;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int calcularSalario() {
        return salario;
    }

}