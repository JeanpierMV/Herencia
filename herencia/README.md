# Proyecto de Herencia - Cuentas Bancarias

Este proyecto demuestra el concepto de herencia en Java mediante la implementación de un sistema de cuentas bancarias.

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

- **Cuenta**: Clase base que maneja saldo, consignaciones, retiros, tasa anual y comisión mensual.
- **CuentaAhorros**: Hereda de Cuenta. Se activa con saldo >= 10000. Cobra comisión por retiros extras.
- **CuentaCorriente**: Hereda de Cuenta. Permite sobregiro y maneja consignaciones para cubrirlo.

## Cómo ejecutar

```bash
mvn compile
mvn exec:java
```

## Requisitos

- Java 17
- Maven