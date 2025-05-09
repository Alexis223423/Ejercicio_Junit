# 1 - Introducción

En este documento se van a detallar los pasos para llevar a cabo las pruebas con **Junit** sobre las clases del proyecto Java para confirmar que funcionan de manera correcta.

# 2 - Implementación de JUnit

La ruta para implementar la libreria es la siguiente, tal y como se muestra en la imagen:

>Java Build Path > Libraries > Add Library > JUnit

![Implementación Junit al proyecto](/fotos/1%20-%20Implementar%20Junit%20al%20proyecto.png)

Una vez que se ha creado el archivo java para hacer los test, la ruta para hacer la cobertura de código es la siguiente:

>Coverage As > JUnit Test

![Comprobar cobertura del proyecto](/fotos/2%20-%20Comprobar%20cobertura%20del%20proyecto%20con%20Junit.png)

Se hace una comprobación previa sin ningun test con cobertura 0%.

![Cobertura inicial](/fotos/3%20-%20Cobertura%20al%20inicio%20de%20los%20test.png)

# 3 - Implementación de los test

## 3.1 - Test 1

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

El primer test de cobertura del código abarca un 74,1%.

![Cobertura 1º test](/fotos/4%20-%20Cobertura%20con%20primer%20test.png)

## 3.2 - Test 2

**Nombre:** testDescuentoRopaClienteVip

**Objetivo:** Comprueba eñ descuento combinado para ropa (15% por cantidad + 5% por ser VIP), sumando un 20% de descuento.

~~~
public void testDescuentoRopaClienteVip() {
        List<Producto> productos = Arrays.asList(
            new Producto("ropa", 50.0, 3) // 15% + 5% = 20%
        );
        double total = CalculadoraDescuentosUtils.calcularTotalConDescuento(productos, true);
        assertEquals(120.0, total); // 50 * 3 * 0.80
    }
~~~

El segundo test de cobertura del código abarca un 83,5%.

![Cobertura 1º test](/fotos/5%20-%20Cobertura%20con%20segundo%20test.png)