# Tareas
## Implementación de Clases Principales

- [X] **Clase PCB** (Process Control Block)
  - [ ] Guardar estados del proceso: nuevo, preparado, ejecución, en espera, finalizado
  - [ ] Contador del programa (ubicación en memoria)
  - [ ] Registros AC, AX, BX, CX, DX, .....
  - [ ] Información de la pila (tamaño de 5, manejo de desbordamiento)
  - [ ] Información contable:
    - [ ] CPU en ejecución
    - [ ] Tiempo de inicio
    - [ ] Tiempo empleado
  - [ ] Información de E/S (lista de archivos abiertos)
  - [ ] Enlace al siguiente PCB
  - [ ] Dirección de inicio (Base)
  - [ ] Tamaño del proceso (Alcance)
  - [ ] Prioridad

- [X] **Clase Process**
  - [ ] Manejar los estados del proceso
  - [ ] Asignar memoria a los procesos

- [X] **Clase Memory**
  - [ ] Definir secciones para los procesos a ejecutar y sus PCB
  - [ ] Manejo de memoria para almacenar los valores de cada PCB
  - [ ] Configuración de tamaño de memoria (por defecto 256 KB)
  - [ ] Implementar memoria virtual (por defecto 64 KB)

- [X] **Clase CPU**
  - [ ] Simular un CPU con capacidad para ejecutar 5 tareas
  - [ ] Registro IR para visualizar la instrucción en ejecución

- [ ] **Clase AsmLoader**
  - [ ] Cargar programas .asm desde disco
  - [ ] Validar sintaxis de los archivos .asm
  - [ ] Cargar múltiples archivos simultáneamente
  - [ ] Gestionar la asignación de programas en memoria

- [X] **Clase Instruction**
  - [ ] Definir instrucciones para ejecución de procesos
  - [ ] Gestionar pesos de las instrucciones

- [ ] **Clase Dispatcher**
- [x] **Clase ASMFilter**
- [x] **Clase Expression**
- [x] **Clase Kernel**

## Planificador de Trabajos

- [ ] Implementar manejo de enlaces entre los PCBs
- [ ] Correcto manejo de la memoria para almacenar los PCBs y procesos
- [ ] Implementar algoritmo de planificación **FCFS** (First Come, First Served)
- [ ] Manejar espera de procesos cuando no hay espacio en memoria principal
- [ ] Gestionar **cambios de contexto** entre procesos
- [ ] Implementar un **despachador** para manejar la asignación de procesos a los núcleos
- [ ] Controlar el tiempo de ejecución por cada núcleo en intervalos de 1 segundo (botón "Siguiente")
- [ ] Implementar ejecución automática de procesos

## Unidades de Almacenamiento

- [ ] **Unidad de Almacenamiento Principal**
  - [ ] Configurable con un valor por defecto de 512 KB
  - [ ] Manejo de memoria virtual (64 KB por defecto)

- [ ] **Unidad de Almacenamiento Secundaria**
  - [ ] Simular almacenamiento en disco para programas
  - [ ] Configuración a través de archivos (texto, JSON, XML, etc.)

- [ ] **Gestión de Archivos**
  - [ ] Implementar índice de archivos:
    - [ ] Almacenar nombre de archivo
    - [ ] Dirección de almacenamiento
    - [ ] Ubicar el índice en los primeros registros de la unidad de almacenamiento
  - [ ] Manejar lectura y escritura de índices

## Dispositivos Simulados

- [ ] Implementar pantalla para imprimir mensajes (código ensamblador)
- [ ] Implementar teclado para entrada de valores (interrupciones de E/S)

## Configuración y Manejo de Memoria

- [ ] Permitir configuración de tamaños de memoria principal y secundaria a través de archivos de configuración
- [ ] Validar y cargar configuraciones al iniciar el sistema
- [ ] Manejar errores de desbordamiento en la pila y memoria
- [ ] Implementar protección y seguridad en el manejo de procesos

## Interrupciones y Llamadas al Sistema

- [ ] Implementar manejo de **interrupciones de E/S**
- [ ] Implementar **llamadas al sistema** para manejar operaciones de procesos

## Visualización de Información

- [ ] Visualizar el **BCP actual** en ejecución
- [ ] Visualizar dónde y cómo se almacenan los BCPs en memoria principal
- [ ] Mostrar el **tiempo de ejecución** de cada proceso
- [ ] Visualizar los valores de los registros: **IR**, **AC**, **PC**
- [ ] Visualizar la **lista de trabajos** y su estado, actualizada en tiempo real durante la ejecución

## Estadísticas Finales

- [ ] Al finalizar la ejecución, mostrar estadísticas de cada proceso:
  - [ ] Nombre del proceso
  - [ ] Hora:minuto de inicio
  - [ ] Hora:minuto de finalización
  - [ ] Duración en segundos

## Menú de Configuración

- [ ] Incluir un menú o medio de configuración que permita:
  - [ ] Ajustar el tamaño de la memoria principal
  - [ ] Ajustar el tamaño de la memoria virtual
  - [ ] Elegir el tipo de archivo para la configuración (texto, JSON, XML)

# Consideraciones

- El sistema debe gestionar de manera eficiente la memoria principal y virtual.
- Se debe implementar una correcta validación de los archivos `.asm` cargados, con mensajes claros en caso de errores.
- El **algoritmo FCFS** será utilizado para la planificación y ejecución de procesos.
- El sistema debe garantizar la seguridad y protección de los procesos en ejecución, con manejo adecuado de errores y desbordamientos.

## Flujo del Programa
