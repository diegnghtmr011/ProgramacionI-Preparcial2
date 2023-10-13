/**
 * Clase que representa un EmpleadoTiempoParcial.
 * Extiende la clase Empleado.
 * 
 * @author Área de programación UQ - Diego Flores
 * @since 2023-10
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class EmpleadoTiempoParcial extends Empleado {
    private final int numeroHoras;
    private final int salarioHora;

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

    public int getSalarioHora() {
        return salarioHora;
    }

    /**
     * Calcula el salario total del empleado a tiempo parcial.
     * 
     * @return El salario total.
     */
    public int calcularSalario() {
        int salario = (salarioHora * numeroHoras);
        return salario;
    }

}
