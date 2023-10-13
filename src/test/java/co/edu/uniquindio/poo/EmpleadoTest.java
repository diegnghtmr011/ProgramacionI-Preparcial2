package co.edu.uniquindio.poo;

import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class EmpleadoTest {
    private static final Logger LOG = Logger.getLogger(EmpleadoTest.class.getName());

    @Test
    public void calcularSalarioEmpleadoTiempoParcial() {
        LOG.info("Inicio de prueba calcularSalarioEmpleadoTiempoParcial...");

        Empleado e = new EmpleadoTiempoParcial("Josue", "Petuche", 12, 2);

        assertEquals(24, e.calcularSalario(), "El salario debe ser igual");

        assertThrows(Throwable.class, () -> new EmpleadoTiempoParcial("Josue", "Petuche", -12, 2));

        assertThrows(Throwable.class, () -> new EmpleadoTiempoParcial("Josue", "Petuche", 12, -2));

        LOG.info("Fin de prueba calcularSalarioEmpleadoTiempoParcial...");
    }

    @Test
    public void calcularSalarioEmpleadoRecoleccion() {
        LOG.info("Inicio de prueba calcularSalarioEmpleadoRecoleccion...");

        Empleado e = new EmpleadoRecoleccion("Josue", "PetuchePro", 12, 200);

        assertEquals(2400, e.calcularSalario(), "El salario debe ser igual");

        assertThrows(Throwable.class, () -> new EmpleadoRecoleccion("Josue", "PetuchePro", -12, 200));

        assertThrows(Throwable.class, () -> new EmpleadoRecoleccion("Josue", "PetuchePro", 12, -200));

        LOG.info("Fin de prueba calcularSalarioEmpleadoRecoleccion...");
    }

    @Test
    public void calcularSalarioEmpleadoTiempoCompleto() {
        LOG.info("Inicio de prueba calcularSalarioEmpleadoRecoleccion...");

        Empleado e = new EmpleadoTiempoCompleto("Josue", "PetuchePro", 1200);

        assertEquals(1200, e.calcularSalario(), "El salario debe ser igual");

        assertThrows(Throwable.class, () -> new EmpleadoTiempoCompleto("Josue", "PetuchePro", -1200));

        assertThrows(Throwable.class, () -> new EmpleadoTiempoCompleto("Josue", "PetuchePro", 0));

        LOG.info("Fin de prueba calcularSalarioEmpleadoRecoleccion...");
    }

}
