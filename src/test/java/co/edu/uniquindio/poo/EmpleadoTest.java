/**
 * Prueba de la clase Empleado y sus subclases para asegurar su correcto funcionamiento.
 * 
 * @author Área de programación UQ - Diego Flores
 * @since 2023-10
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class EmpleadoTest {
    private static final Logger LOG = Logger.getLogger(EmpleadoTest.class.getName());

    /**
     * Prueba el cálculo del salario para un empleado a tiempo parcial.
     */
    @Test
    public void calcularSalarioEmpleadoTiempoParcial() {
        LOG.info("Inicio de prueba calcularSalarioEmpleadoTiempoParcial...");

        // Se crea un empleado a tiempo parcial con 12 horas trabajadas y $2 por hora.
        Empleado e = new EmpleadoTiempoParcial("Josue", "Petuche", 12, 2);

        // El salario esperado es 24 (12 horas * $2 por hora).
        assertEquals(24, e.calcularSalario(), "El salario debe ser igual");

        // Se prueba la excepción para un número de horas negativo.
        assertThrows(Throwable.class, () -> new EmpleadoTiempoParcial("Josue", "Petuche", -12, 2));

        // Se prueba la excepción para un salario por hora negativo.
        assertThrows(Throwable.class, () -> new EmpleadoTiempoParcial("Josue", "Petuche", 12, -2));

        LOG.info("Fin de prueba calcularSalarioEmpleadoTiempoParcial...");
    }

    /**
     * Prueba el cálculo del salario para un empleado de recolección.
     */
    @Test
    public void calcularSalarioEmpleadoRecoleccion() {
        LOG.info("Inicio de prueba calcularSalarioEmpleadoRecoleccion...");

        // Se crea un empleado de recolección con 12 kilos recolectados y $200 por kilo.
        Empleado e = new EmpleadoRecoleccion("Josue", "PetuchePro", 12, 200);

        // Se crea un empleado de recolección con 12 kilos recolectados y $200 por kilo.
        assertEquals(2400, e.calcularSalario(), "El salario debe ser igual");

        // Se prueba la excepción para un número de kilos negativo.
        assertThrows(Throwable.class, () -> new EmpleadoRecoleccion("Josue", "PetuchePro", -12, 200));

        // Se prueba la excepción para un valor por kilo negativo.
        assertThrows(Throwable.class, () -> new EmpleadoRecoleccion("Josue", "PetuchePro", 12, -200));

        LOG.info("Fin de prueba calcularSalarioEmpleadoRecoleccion...");
    }

    /**
     * Prueba el cálculo del salario para un empleado a tiempo completo.
     */
    @Test
    public void calcularSalarioEmpleadoTiempoCompleto() {
        LOG.info("Inicio de prueba calcularSalarioEmpleadoRecoleccion...");

        // Se crea un empleado a tiempo completo con un salario de $1200.
        Empleado e = new EmpleadoTiempoCompleto("Josue", "PetuchePro", 1200);

        // El salario esperado es 1200.
        assertEquals(1200, e.calcularSalario(), "El salario debe ser igual");

        // Se prueba la excepción para un salario negativo.
        assertThrows(Throwable.class, () -> new EmpleadoTiempoCompleto("Josue", "PetuchePro", -1200));

        // Se prueba la excepción para un salario de cero.
        assertThrows(Throwable.class, () -> new EmpleadoTiempoCompleto("Josue", "PetuchePro", 0));

        LOG.info("Fin de prueba calcularSalarioEmpleadoRecoleccion...");
    }

}
