import java.util.*;

class Materia {
    String nombre;
    String codigo;
    int creditos;
    List<String> horariosDisponibles; 

    public Materia(String nombre, String codigo, int creditos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.horariosDisponibles = new ArrayList<>();
    }

    public void agregarHorario(String horario) {
        horariosDisponibles.add(horario);
    }

    public void mostrarHorariosDisponibles() {
        System.out.println("Horarios disponibles para " + nombre + " (" + codigo + "):");
        if (horariosDisponibles.isEmpty()) {
            System.out.println("No hay horarios disponibles.");
        }
        for (String horario : horariosDisponibles) {
            System.out.println("- " + horario);
        }
    }
}

class Estudiante {
    String nombre;
    String id;
    Map<Materia, String> materiasInscritas; 

    public Estudiante(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.materiasInscritas = new HashMap<>();
    }

  
    public void inscribirMateria(Materia materia, String horario) throws Exception {
        if (materiasInscritas.containsKey(materia)) {
            throw new Exception("Ya estás inscrito en la materia " + materia.nombre + " en otro horario.");
        }

        if (!materia.horariosDisponibles.contains(horario)) {
            throw new Exception("El horario " + horario + " no está disponible para " + materia.nombre);
        }

        materiasInscritas.put(materia, horario);
        System.out.println("Materia " + materia.nombre + " inscrita en el horario " + horario);
    }

    public void mostrarHorarioCompleto() {
        System.out.println("Horario completo de " + nombre + " (ID: " + id + "):");
        if (materiasInscritas.isEmpty()) {
            System.out.println("No tiene materias inscritas.");
        }
        for (Map.Entry<Materia, String> entry : materiasInscritas.entrySet()) {
            System.out.println(entry.getKey().nombre + " (" + entry.getKey().codigo + ") - " + entry.getValue());
        }
    }
}

class GestionHorarios {
    List<Materia> materiasRegistradas; 
    List<Estudiante> estudiantesRegistrados; 

    public GestionHorarios() {
        this.materiasRegistradas = new ArrayList<>();
        this.estudiantesRegistrados = new ArrayList<>();
    }

    public void registrarMateria(Materia materia) {
        materiasRegistradas.add(materia);
        System.out.println("Materia " + materia.nombre + " registrada con éxito.");
    }

    public void registrarEstudiante(Estudiante estudiante) {
        estudiantesRegistrados.add(estudiante);
        System.out.println("Estudiante " + estudiante.nombre + " registrado con éxito.");
    }

    public void inscribirEstudianteEnMateria(Estudiante estudiante, Materia materia, String horario) {
        try {
            estudiante.inscribirMateria(materia, horario);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void mostrarEstudiantesYHorarios() {
        for (Estudiante estudiante : estudiantesRegistrados) {
            estudiante.mostrarHorarioCompleto();
        }
    }

    public Materia buscarMateriaPorNombre(String nombreMateria) {
        for (Materia materia : materiasRegistradas) {
            if (materia.nombre.equalsIgnoreCase(nombreMateria)) {
                return materia;
            }
        }
        return null;
    }
}

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionHorarios gestionHorarios = new GestionHorarios();
        
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n==== Menu ====");
            System.out.println("1. Registrar Materia");
            System.out.println("2. Registrar Estudiante");
            System.out.println("3. Inscribir Estudiante en Materia");
            System.out.println("4. Mostrar Estudiantes y sus Horarios");
            System.out.println("5. Mostrar Materias Registradas");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    // Registrar Materia
                    System.out.print("Ingrese el nombre de la materia: ");
                    String nombreMateria = scanner.nextLine();
                    System.out.print("Ingrese el código de la materia: ");
                    String codigoMateria = scanner.nextLine();
                    System.out.print("Ingrese los créditos de la materia: ");
                    int creditosMateria = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    Materia materia = new Materia(nombreMateria, codigoMateria, creditosMateria);
                    boolean agregandoHorarios = true;
                    while (agregandoHorarios) {
                        System.out.print("Ingrese un horario disponible para la materia (o 'fin' para terminar): ");
                        String horario = scanner.nextLine();
                        if (horario.equalsIgnoreCase("fin")) {
                            agregandoHorarios = false;
                        } else {
                            materia.agregarHorario(horario);
                        }
                    }
                    gestionHorarios.registrarMateria(materia);
                    break;
                
                case 2:
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombreEstudiante = scanner.nextLine();
                    System.out.print("Ingrese el ID del estudiante: ");
                    String idEstudiante = scanner.nextLine();
                    Estudiante estudiante = new Estudiante(nombreEstudiante, idEstudiante);
                    gestionHorarios.registrarEstudiante(estudiante);
                    break;

                case 3:
                    System.out.print("Ingrese el ID del estudiante: ");
                    String idEstudianteInscripcion = scanner.nextLine();
                    Estudiante est = null;
                    for (Estudiante e : gestionHorarios.estudiantesRegistrados) {
                        if (e.id.equals(idEstudianteInscripcion)) {
                            est = e;
                            break;
                        }
                    }
                    if (est != null) {
                        System.out.print("Ingrese el nombre de la materia a inscribir: ");
                        String materiaInscripcion = scanner.nextLine();
                        Materia materiaInscribir = gestionHorarios.buscarMateriaPorNombre(materiaInscripcion);
                        
                        if (materiaInscribir != null) {
                            materiaInscribir.mostrarHorariosDisponibles();
                            System.out.print("Ingrese el horario que desea para la materia: ");
                            String horarioInscripcion = scanner.nextLine();
                            gestionHorarios.inscribirEstudianteEnMateria(est, materiaInscribir, horarioInscripcion);
                        } else {
                            System.out.println("Materia no encontrada.");
                        }
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;

                case 4:
                    gestionHorarios.mostrarEstudiantesYHorarios();
                    break;

                case 5:
                    System.out.println("Materias Registradas:");
                    for (Materia m : gestionHorarios.materiasRegistradas) {
                        System.out.println(m.nombre + " (" + m.codigo + ")");
                    }
                    break;

                case 6:
                    continuar = false;
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}

