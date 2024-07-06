package e1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HotelTest {
    private static Hotel hotel;
    @BeforeAll
    static void setUp() {
        // Crear un hotel
        hotel = new Hotel("UDC-Hills");

        // Añadir habitaciones al hotel
        hotel.AddHabitacion("Supervisor1");
        hotel.AddHabitacion("Supervisor2");
        hotel.AddHabitacion("Supervisor3");
    }

    @Test
    void testReserva() {
        setUp();

        // Reservar una habitación
        hotel.ReservarHabitacion("Cliente1", 1);
        assertEquals("Habitacion No. 2 Habitacion No. 3 ", hotel.getHabitacionesDisponibles());

        // Intentar reservar una habitación ya ocupada
        hotel.ReservarHabitacion("Cliente2", 1);
        assertEquals("Cliente1", hotel.getHuesped(1));

        // Terminar una reserva
        hotel.ReservarHabitacion("Cliente4", 1);
        hotel.TerminarReserva(1);
        assertEquals("Habitacion No. 1 Habitacion No. 2 Habitacion No. 3 ", hotel.getHabitacionesDisponibles());

    }
    @Test
    void testLimpieza() {
        setUp();

        // Limpiar una habitación
        hotel.LimpiarHabitacion("Limpiador1", 2);
        assertEquals("Habitacion No. 2 ", hotel.getHabitacionesPendientesAprovacion());

        // Intentar limpiar una habitación ya ocupada
        hotel.ReservarHabitacion("Cliente1", 1);
        hotel.LimpiarHabitacion("Limpiador2", 1);
        assertEquals("Habitacion No. 2 ", hotel.getHabitacionesPendientesAprovacion());

    }

    @Test
    void testAprobacion() {
        setUp();
        hotel.LimpiarHabitacion("Limpiador1", 1);
        hotel.LimpiarHabitacion("Limpiador2", 2);

        // Aprobar la limpieza
        hotel.AprobarLimpieza(true, 1, "Supervisor1");
        assertEquals("Habitacion No. 2 ", hotel.getHabitacionesPendientesAprovacion());

        // Intentar aprobar limpieza de una habitación ya aprobada
        hotel.AprobarLimpieza(true, 3, "Supervisor1");
        assertEquals("Habitacion No. 2 ", hotel.getHabitacionesPendientesAprovacion());

        // No aporbar una limpieza de una habitación
        hotel.AprobarLimpieza(false, 2, "Supervisor3");
        assertEquals("Habitacion No. 2 ", hotel.getHabitacionesPendienteLimpieza());
        assertEquals("", hotel.getHabitacionesPendientesAprovacion());

        // Intentar aprobar limpieza de una habitación sin limpiar
        hotel.LimpiarHabitacion("Limpiador1",2);
        hotel.ReservarHabitacion("Huesped 1", 1);
        hotel.LiberarHabitacion(1);
        hotel.AprobarLimpieza(true, 1, "Supervisor2");
        assertEquals("Habitacion No. 2 ", hotel.getHabitacionesPendientesAprovacion());
        assertEquals("Habitacion No. 1 ", hotel.getHabitacionesPendienteLimpieza());

        // Revocar la aprobacion de una habitacion
        hotel.AprobarLimpieza(true, 2, "Supervisor1");
        assertEquals("", hotel.getHabitacionesPendientesAprovacion());
        hotel.LimpiarHabitacion("Limpiador3", 2);
        assertEquals("Habitacion No. 2 ", hotel.getHabitacionesPendientesAprovacion());
    }
    @Test
    void testShowInfo(){
        setUp();
        hotel.showInfo();
        hotel.ReservarHabitacion("Cliente1", 2);
        hotel.LimpiarHabitacion("Limpiador1", 1);
        hotel.ReservarHabitacion("Cliente2", 3);
        hotel.showInfo();
        hotel.LiberarHabitacion(3);
        hotel.TerminarReserva(2);
        hotel.AprobarLimpieza(false, 1, "Supervisor1");
        hotel.showInfo();
    }
}