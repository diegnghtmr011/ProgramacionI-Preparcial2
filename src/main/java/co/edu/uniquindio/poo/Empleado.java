/**
 * Clase abstracta que representa un Empleado.
 * 
 * @author Área de programación UQ - Diego Flores
 * @since 2023-10
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public abstract class Empleado {
    private final String nombre;
    private final String cargo;

    public Empleado(String texto, String cargo) {
        ASSERTION.assertion(texto != null, "El texto es requerido");
        ASSERTION.assertion(cargo != null, "El cargo es requerido");
        this.nombre = texto;
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }

    /**
     * Calcula el salario del empleado. Este método debe ser implementado por las
     * clases que extiendan Empleado.
     * 
     * @return El salario del empleado.
     */
    public abstract int calcularSalario();

}
