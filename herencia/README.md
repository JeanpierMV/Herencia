# Proyecto de Herencia - Cuentas Bancarias

![alt text](image.png)

## Diagrama de Clases

```mermaid
classDiagram
    class Cuenta {
        #saldo: float
        #numeroConsignaciones: int
        #numeroRetiros: int
        #tasaAnual: float
        #comisionMensual: float
        +Cuenta(saldo: float, tasaAnual: float)
        +consignar(cantidad: float)
        +retirar(cantidad: float)
        +calcularInteres()
        +extractoMensual()
        +imprimir()
    }
    
    class CuentaAhorros {
        -activa: boolean
        +CuentaAhorros(saldo: float, tasaAnual: float)
        +consignar(cantidad: float)
        +retirar(cantidad: float)
        +extractoMensual()
        +imprimir()
    }
    
    class CuentaCorriente {
        -sobregiro: float
        +CuentaCorriente(saldo: float, tasaAnual: float)
        +consignar(cantidad: float)
        +retirar(cantidad: float)
        +extractoMensual()
        +imprimir()
    }
    
    Cuenta <|-- CuentaAhorros : hereda
    Cuenta <|-- CuentaCorriente : hereda
    
    note for CuentaAhorros "Cuenta activa si saldo >= 10000\nComisión $1000 por cada retiro adicional > 4\nNo permite transacciones si inactiva"
    note for CuentaCorriente "Permite sobregiro ilimitado\nConsignaciones cubren sobregiro antes de aumentar saldo"
    note for Cuenta "Clase base con lógica común\nCalcula interés mensual y maneja extractos"
```

## Descripción

Este proyecto implementa un sistema de cuentas bancarias utilizando herencia en Java. La clase base `Cuenta` proporciona la funcionalidad común, mientras que `CuentaAhorros` y `CuentaCorriente` extienden esta clase con comportamientos específicos.

### Características Principales

- **Cuenta de Ahorros**: Se activa con saldo mínimo de $10,000. Cobra comisión por retiros adicionales.
- **Cuenta Corriente**: Permite sobregiro y maneja consignaciones para cubrirlo primero.

## Cómo Ejecutar

1. Asegúrate de tener Maven instalado.
2. Navega al directorio del proyecto.
3. Ejecuta `mvn compile` para compilar.
4. Ejecuta `mvn exec:java` para correr el programa.