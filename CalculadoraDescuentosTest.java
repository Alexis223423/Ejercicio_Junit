package calculadoraDescuentos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class CalculadoraDescuentosTest {

    @Test
    public void testDescuentoElectronicaClienteNoVip() {
        List<Producto> productos = Arrays.asList(
            new Producto("electronica", 100.0, 3) // 10% descuento
        );
        double total = CalculadoraDescuentosUtils.calcularTotalConDescuento(productos, false);
        assertEquals(270.0, total); // 100 * 3 * 0.90
    }

    @Test
    public void testDescuentoRopaClienteVip() {
        List<Producto> productos = Arrays.asList(
            new Producto("ropa", 50.0, 3) // 15% + 5% = 20%
        );
        double total = CalculadoraDescuentosUtils.calcularTotalConDescuento(productos, true);
        assertEquals(120.0, total); // 50 * 3 * 0.80
    }
    
    @Test
    public void testLimiteDescuentoMaximo30() {
        List<Producto> productos = Arrays.asList(
            new Producto("electronica", 200.0, 6) // 20% + 5% = 25% (VIP)
        );
        double total = CalculadoraDescuentosUtils.calcularTotalConDescuento(productos, true);
        assertEquals(900.0, total); // 200 * 6 * 0.75
    }

    @Test
    public void testCategoriaInvalidaLanzaExcepcion() {
        List<Producto> productos = Arrays.asList(
            new Producto("juguetes", 30.0, 2)
        );
        assertThrows(IllegalArgumentException.class, () -> {
            CalculadoraDescuentosUtils.calcularTotalConDescuento(productos, false);
        });
    }

    @Test
    public void testDescuentoAlimentacionNoVip() {
        List<Producto> productos = Arrays.asList(
            new Producto("alimentacion", 10.0, 4) // 5% descuento
        );
        double total = CalculadoraDescuentosUtils.calcularTotalConDescuento(productos, false);
        assertEquals(38.0, total); // 10 * 4 * 0.95
    }


   
}