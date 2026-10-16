# Proyecto 1 – Sistema de Examen por Consola (POO con Java)

Programación Orientada a Objetos con Java – Universidad Central de Chile, sede Coquimbo
Docente: Mg. Gonzalo Honores

**Integrantes:** David Fuentes, Vicente Millaqueo

## Descripción

Programa por consola que administra un examen tipo cuestionario con tres tipos de preguntas
(verdadero/falso, selección múltiple y respuesta corta), cada una con su peso, y entrega el
resultado en porcentaje. Incluye manejo de excepciones y un registro de puntajes en archivo.

## Cómo ejecutarlo

```
javac -encoding UTF-8 *.java
java ExamDemo
```

Para salir del examen en cualquier momento, escribir `STOP`.

## Clases

- `Pregunta`: clase abstracta con el texto, el peso y el método `buscar()`.
- `TFpregunta`, `Selec_Mul_Pregunta`, `Resp_Cortas_Pregunta`: los tres tipos de pregunta.
- `Exam`: colección de preguntas (máximo 10) que administra el examen.
- `ExamenInterrumpidoException`: excepción propia para cuando el usuario escribe STOP.
- `RegistroPuntajes`: guarda y muestra el historial de puntajes (extra).
- `ExamDemo`: clase principal de prueba.
