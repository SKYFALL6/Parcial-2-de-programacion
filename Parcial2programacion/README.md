Cómo Utilizar el Sistema
Registro de Materia: Ingresa el nombre, código y créditos de la materia. Luego, agrega los horarios disponibles.

Registro de Estudiante: Ingresa el nombre y ID del estudiante.

Inscripción en Materia: Seleccione el ID del estudiante, luego elige la materia y el horario en que desea inscribirse.

Mostrar Horarios: Visualiza el horario completo de todos los estudiantes inscritos.

Mostrar Materias: Lista todas las materias registradas en el sistema.

Espero que esta documentación te sea útil y te ayude a entender mejor el funcionamiento del sistema.

INTRODUCCION
Este sistema de gestión de horarios permite a los estudiantes de nuestra universidad seleccionar sus horarios de clases de manera eficiente. A continuación, se describen las funcionalidades del sistema, los componentes principales y cómo utilizarlo. Esta documentación ha sido realizada con un enfoque claro y sencillo, ideal para estudiantes de secundaria.

Las Clases Principales

Clase Materia
La clase Materia representa las asignaturas que los estudiantes pueden inscribir. Cada materia tiene un nombre, un código, una cantidad de créditos y una lista de horarios disponibles.

Sus atributos
nombre: Nombre de la materia.
codigo: Código identificativo de la materia.
creditos: Créditos que vale la materia.
horariosDisponibles: Lista de horarios disponibles para la materia.

Los metodos:
agregarHorario(String horario): Agrega un horario a la lista de horarios disponibles.
mostrarHorariosDisponibles(): Muestra los horarios disponibles.

Clase Estudiante
La clase Estudiante representa a los estudiantes inscritos en la universidad. Cada estudiante tiene un nombre, un ID y una lista de materias inscritas con sus respectivos horarios.

Sus atributos:
nombre: Nombre del estudiante.
id: ID del estudiante.
materiasInscritas: Mapa de materias inscritas con sus horarios.

Sus metodos:
inscribirMateria(Materia materia, String horario): Inscribe una materia con un horario específico.
mostrarHorarioCompleto(): Muestra el horario completo del estudiante.

Clase GestionHorarios
La clase GestionHorarios gestiona el registro de materias y estudiantes, así como la inscripción de materias.

Sus atributos:
materiasRegistradas: Lista de materias registradas.
estudiantesRegistrados: Lista de estudiantes registrados.

Los metodos:
registrarMateria(Materia materia): Registra una nueva materia.
registrarEstudiante(Estudiante estudiante): Registra un nuevo estudiante.
inscribirEstudianteEnMateria(Estudiante estudiante, Materia materia, String horario): Inscribe a un estudiante en una materia con un horario específico.
mostrarEstudiantesYHorarios(): Muestra los horarios completos de todos los estudiantes.
buscarMateriaPorNombre(String nombreMateria): Busca una materia por su nombre.

Clase main
La clase main contiene el menú para procesar las operaciones del sistema nos permite registrar materias y estudiantes, inscribir estudiantes en materias, y mostrar los horarios registrados.