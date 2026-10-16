# Proyecto 1 – Sistema de Examen por Consola (POO con Java)

Programación Orientada a Objetos con Java – Universidad Central de Chile

Docente: Mg. Gonzalo Honores

**Integrantes:** David Fuentes, Vicente Millaqueo

## Descripción

Programa por consola que administra un examen tipo cuestionario con tres tipos de preguntas
(verdadero/falso, selección múltiple y respuesta corta), cada una con su peso, y entrega el
resultado en porcentaje. Incluye manejo de excepciones y un registro de puntajes en archivo.


## Clases

-Pregunta (Clase abstracta): Contiene los atributos protegidos peso y texto, los métodos de acceso (getPeso, setPeso, getText) y declara el método abstracto buscar().   
-TFpregunta: Extiende de Pregunta para manejar preguntas de verdadero o falso, validando entradas T o F.   
-Resp_Cortas_Pregunta: Extiende de Pregunta para gestionar respuestas cortas, comparando la entrada del usuario mediante equalsIgnoreCase.   
-Selec_Mul_Pregunta: Extiende de Pregunta para preguntas de selección múltiple, mostrando las alternativas indexadas por letras (a, b, c, etc.).   
-Exam: Administra una colección de preguntas mediante un arreglo de tamaño fijo (10 elementos), permitiendo agregarlas y calcular la calificación porcentual ponderada.   
-ExamDemo: Clase principal encargada de instanciar el examen con las preguntas de prueba y ejecutar la evaluación. 
