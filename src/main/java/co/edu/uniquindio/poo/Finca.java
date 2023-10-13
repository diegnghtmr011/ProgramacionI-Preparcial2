package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;

public class Finca {
    private String nombre;
    private Collection<Empleado> empleados;

    public Finca(String nombre) {
        ASSERTION.assertion(nombre != null, "El nombre es requerido");
        this.empleados = new LinkedList<>();
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Collection<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Collection<EmpleadoTiempoParcial> listarEmpleadosTiempoParcial() {
        Predicate<Empleado> condicion = empleado -> empleado instanceof EmpleadoTiempoParcial;
        return empleados.stream()
                .filter(condicion)
                .map(empleado -> (EmpleadoTiempoParcial) empleado)
                .sorted((e1, e2) -> Integer.compare(e2.calcularSalario(), e1.calcularSalario()))
                .toList();
    }

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

    public void adicionarEmpleado(Empleado empleado) {
        validarEmpleadoExiste(empleado);
        empleados.add(empleado);
    }

    private void validarEmpleadoExiste(Empleado empleado) {
        boolean existeEmpleado = buscarEmpleado(empleado).isPresent();
        ASSERTION.assertion(!existeEmpleado, "El empleado ya esta registrado");
    }

    private Optional<Empleado> buscarEmpleado(Empleado empleado) {
        Predicate<Empleado> condicion = e -> e.getNombre().equals(empleado.getNombre());
        return empleados.stream().filter(condicion).findAny();
    }

    public Collection<EmpleadoRecoleccion> listarEmpleadosRecoleccion(int numeroKilos) {
        Predicate<EmpleadoRecoleccion> condicion = empleado -> empleado.getNumeroKilos() > numeroKilos;
        return empleados.stream().filter(empleado -> empleado instanceof EmpleadoRecoleccion)
                .map(empleado -> (EmpleadoRecoleccion) empleado).filter(condicion).sorted(Comparator
                        .comparing(EmpleadoRecoleccion::getNumeroKilos).reversed())
                .toList();
        // el .reversed() solo está para acordarme que existe XD
    }

    public Collection<Empleado> listarEmpleadosSalarioMayorPromedio() {
        Predicate<Empleado> condicion = empleado -> empleado.calcularSalario() > calcularSalarioPromedio();
        return empleados.stream().filter(condicion).sorted(Comparator.comparing(Empleado::getNombre)).toList();
    }

    private double calcularSalarioPromedio() {
        return empleados.stream().mapToInt(Empleado::calcularSalario).summaryStatistics().getAverage();
    }

}
