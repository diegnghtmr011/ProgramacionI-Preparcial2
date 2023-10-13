/**
 * Clase que representa una Finca y gestiona la colección de empleados.
 * 
 * @author Área de programación UQ - Diego Flores
 * @since 2023-10
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Finca {
    private final String nombre;
    private final Collection<Empleado> empleados;

    public Finca(String nombre) {
        ASSERTION.assertion(nombre != null, "El nombre es requerido");
        this.empleados = new LinkedList<>();
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Collection<Empleado> getEmpleados() {
        return Collections.unmodifiableCollection(empleados);
    }

    /**
     * Lista todos los empleados a tiempo parcial, ordenados por salario de mayor a
     * menor.
     * 
     * @return Colección de empleados a tiempo parcial.
     */
    public Collection<EmpleadoTiempoParcial> listarEmpleadosTiempoParcial() {
        Predicate<Empleado> condicion = empleado -> empleado instanceof EmpleadoTiempoParcial;
        return empleados.stream()
                .filter(condicion)
                .map(empleado -> (EmpleadoTiempoParcial) empleado)
                .sorted((e1, e2) -> Integer.compare(e2.calcularSalario(), e1.calcularSalario()))
                .toList();
    }

    /**
     * Lista los empleados con menor rendimiento en base al promedio de horas (para
     * empleados a tiempo parcial)
     * y al promedio de kilos recolectados (para empleados de recolección).
     * 
     * @return Colección de empleados con menor rendimiento.
     */
    public Collection<Empleado> listarEmpleadosMenorRendimiento() {
        double promedioHoras = promedioEmpleadosTiempoParcial();
        double promedioKilos = promedioEmpleadosRecoleccion();
        Predicate<Empleado> condicionEmpleadoTiempoParcial = empleado -> empleado instanceof EmpleadoTiempoParcial
                && ((EmpleadoTiempoParcial) empleado).getNumeroHoras() < promedioHoras;
        Predicate<Empleado> condicionEmpleadoRecoleccion = empleado -> empleado instanceof EmpleadoRecoleccion
                && ((EmpleadoRecoleccion) empleado).getNumeroKilos() < promedioKilos;
        return empleados.stream()
                .filter(condicionEmpleadoTiempoParcial.or(condicionEmpleadoRecoleccion)).toList();
    }

    /**
     * Calcula el promedio de horas trabajadas por empleados a tiempo parcial.
     * 
     * @return Promedio de horas trabajadas.
     */
    private double promedioEmpleadosTiempoParcial() {
        double totalHoras = 0;
        double contador = 0;

        for (Empleado empleado : empleados) {
            if (empleado instanceof EmpleadoTiempoParcial) {
                totalHoras += ((EmpleadoTiempoParcial) empleado).getNumeroHoras();
                contador++;
            }
        }
        return (totalHoras / contador);
    }

    /**
     * Calcula el promedio de kilos recolectados por empleados de recolección.
     * 
     * @return Promedio de kilos recolectados.
     */
    private double promedioEmpleadosRecoleccion() {
        double totalKilos = 0;
        double contador = 0;

        for (Empleado empleado : empleados) {
            if (empleado instanceof EmpleadoRecoleccion) {
                totalKilos += ((EmpleadoRecoleccion) empleado).getNumeroKilos();
                contador++;
            }
        }
        return (totalKilos / contador);
    }

    /**
     * Añade un empleado a la colección de empleados de la finca.
     * 
     * @param empleado El empleado a añadir.
     */
    public void adicionarEmpleado(Empleado empleado) {
        validarEmpleadoExiste(empleado);
        empleados.add(empleado);
    }

    /**
     * Valida si un empleado ya está registrado en la finca.
     * 
     * @param empleado El empleado a validar.
     */
    private void validarEmpleadoExiste(Empleado empleado) {
        boolean existeEmpleado = buscarEmpleado(empleado).isPresent();
        ASSERTION.assertion(!existeEmpleado, "El empleado ya esta registrado");
    }

    /**
     * Busca un empleado en la colección de empleados.
     * 
     * @param empleado El empleado a buscar.
     * @return Una instancia Optional que contiene al empleado si se encuentra, o un
     *         Optional vacío si no.
     */
    private Optional<Empleado> buscarEmpleado(Empleado empleado) {
        Predicate<Empleado> condicion = e -> e.getNombre().equals(empleado.getNombre());
        return empleados.stream().filter(condicion).findAny();
    }

    /**
     * Lista los empleados de recolección que han recolectado más de cierta cantidad
     * de kilos.
     * 
     * @param numeroKilos La cantidad mínima de kilos recolectados.
     * @return Colección de empleados de recolección que cumplen con el criterio.
     */
    public Collection<EmpleadoRecoleccion> listarEmpleadosRecoleccion(int numeroKilos) {
        Predicate<EmpleadoRecoleccion> condicion = empleado -> empleado.getNumeroKilos() > numeroKilos;
        return empleados.stream().filter(empleado -> empleado instanceof EmpleadoRecoleccion)
                .map(empleado -> (EmpleadoRecoleccion) empleado).filter(condicion).sorted(Comparator
                        .comparing(EmpleadoRecoleccion::getNumeroKilos).reversed())
                .toList();
        // el .reversed() solo está para acordarme que existe XD
    }

    /**
     * Lista los empleados cuyo salario es mayor que el promedio de salarios de la
     * finca.
     * 
     * @return Colección de empleados con salario mayor que el promedio.
     */
    public Collection<Empleado> listarEmpleadosSalarioMayorPromedio() {
        Predicate<Empleado> condicion = empleado -> empleado.calcularSalario() > calcularSalarioPromedio();
        return empleados.stream().filter(condicion).sorted(Comparator.comparing(Empleado::getNombre)).toList();
    }

    /**
     * Calcula el salario promedio de todos los empleados de la finca.
     * 
     * @return El salario promedio.
     */
    private double calcularSalarioPromedio() {
        return empleados.stream().mapToInt(Empleado::calcularSalario).summaryStatistics().getAverage();
    }

}
