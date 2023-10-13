/**
 * Clase que representa un EmpleadoRecolección.
 * Extiende la clase Empleado.
 * 
 * @author Área de programación UQ - Diego Flores
 * @since 2023-10
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class EmpleadoRecoleccion extends Empleado {
    private final int numeroKilos;
    private final int valorKilo;

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

    public int getValorKilo() {
        return valorKilo;
    }

    /**
     * Calcula el salario total del empleado de recolección.
     * 
     * @return El salario total.
     */
    public int calcularSalario() {
        int salario = (valorKilo * numeroKilos);
        return salario;
    }

}
