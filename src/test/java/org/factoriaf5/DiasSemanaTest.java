package org.factoriaf5;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DiasSemanaTest {

    private DiasSemana diasSemana;

    @Before
    public void setUp() {
        diasSemana = new DiasSemana();
        diasSemana.crearListaDias();
    }

    @Test
    public void testCrearListaDias() {
        diasSemana.crearListaDias();
        List<String> dias = diasSemana.obtenerDias();
        assertEquals("La lista debe contener 7 días.", 7, dias.size());
        assertEquals("El primer día debe ser Lunes.", "Lunes", dias.get(0));
        assertEquals("El último día debe ser Domingo.", "Domingo", dias.get(6));
    }

    @Test
    public void testObtenerDias() {
        List<String> dias = diasSemana.obtenerDias();
        assertEquals("La lista debe contener 7 días.", 7, dias.size());
        assertTrue("La lista debe contener Lunes.", dias.contains("Lunes"));
        assertTrue("La lista debe contener Domingo.", dias.contains("Domingo"));
    }

    @Test
    public void testObtenerLargo() {
        assertEquals("La longitud de la lista debe ser 7.", 7, diasSemana.obtenerLargo());
    }

    @Test
    public void testEliminarDia() {
        assertTrue("Debe eliminar Lunes de la lista.", diasSemana.eliminarDia("Lunes"));
        assertFalse("Lunes no debe estar en la lista.", diasSemana.obtenerDias().contains("Lunes"));
        assertEquals("La lista debe tener 6 días después de la eliminación.", 6, diasSemana.obtenerLargo());
    }

    @Test
    public void testObtenerDia() {
        assertEquals("El día en la posición 0 debe ser Lunes.", "Lunes", diasSemana.obtenerDia(0));
        assertNull("Debe devolver null para un índice fuera de rango.", diasSemana.obtenerDia(10));
    }

    @Test
    public void testExisteDia() {
        assertTrue("Martes debe existir en la lista.", diasSemana.existeDia("Martes"));
        assertFalse("Funday no debe existir en la lista.", diasSemana.existeDia("Funday"));
    }

    @Test
    public void testOrdenarDias() {
        diasSemana.ordenarDias();
        List<String> dias = diasSemana.obtenerDias();
        assertEquals("El primer día debe ser Domingo después de ordenar.", "Domingo", dias.get(0));
        assertEquals("El último día debe ser Viernes después de ordenar.", "Viernes", dias.get(6));
    }

    @Test
    public void testVaciarLista() {
        diasSemana.vaciarLista();
        assertEquals("La lista debe estar vacía después de llamar a vaciarLista.", 0, diasSemana.obtenerLargo());
        assertTrue("La lista debe estar vacía.", diasSemana.obtenerDias().isEmpty());
    }
}
