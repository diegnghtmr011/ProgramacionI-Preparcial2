/**
 * Clase que representa un EmpleadoTiempoCompleto.
 * Extiende la clase Empleado.
 * 
 * @author Área de programación UQ - Diego Flores
 * @since 2023-10
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class EmpleadoTiempoCompleto extends Empleado {
    private final int salario;

    public EmpleadoTiempoCompleto(String nombre, String cargo, int salario) {
        super(nombre, cargo);
        ASSERTION.assertion(salario > 0, "El salario es requerido");
        this.salario = salario;
    }

    public int getSalario() {
        return salario;
    }

    /**
     * Calcula el salario total del empleado a tiempo completo.
     * 
     * @return El salario total.
     */
    public int calcularSalario() {
        return salario;
    }

}
