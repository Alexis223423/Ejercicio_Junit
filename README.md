# Ejercicio_Junit

En este documento se van a detallar los pasos para llevar a cabo las pruebas con Junit sobre las clases del proyecto Java para confirmar que funcionan de manera correcta.

## **Test 1**

**Nombre:** testDescuentoElectronicaClienteNoVip

**Objetivo:** Verifica la aplicación del 10% de descuento a productos de electrónica cuando se compran menos de 5 unidades y el cliente no es VIP.

~~~
public void testDescuentoElectronicaClienteNoVip() {
        List<Producto> productos = Arrays.asList(
            new Producto("electronica", 100.0, 3) // 10% descuento
        );
        double total = CalculadoraDescuentosUtils.calcularTotalConDescuento(productos, false);
        assertEquals(270.0, total); // 100 * 3 * 0.90
    }
~~~


