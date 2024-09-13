# Tareas
## Implementación de Clases Principales

- [x] **Clase PCB** (Process Control Block)
  - [x] Guardar estados del proceso: nuevo, preparado, ejecución, en espera, finalizado
  - [x] Contador del programa (ubicación en memoria)
  - [x] Registros AC, AX, BX, CX, DX, .....
  - [x] Asignar memoria a los procesos
  - [ ] Información de la pila (tamaño de 5, manejo de desbordamiento)
  - [ ] Información contable:
    - [ ] CPU en ejecución
    - [ ] Tiempo de inicio
    - [ ] Tiempo empleado
  - [ ] Información de E/S (lista de archivos abiertos)
  - [ ] Enlace al siguiente PCB
  - [x] Dirección de inicio (Base)
  - [ ] Tamaño del proceso (Alcance)
  - [x] Prioridad

- [x] **Clase Main Memory**
  - [ ] Definir secciones para los procesos a ejecutar y sus PCB
  - [ ] Manejo de memoria para almacenar los valores de cada PCB
  - [ ] Configuración de tamaño de memoria (por defecto 256 KB)
  - [ ] Implementar memoria virtual (por defecto 64 KB)

- [x] **Clase Secondary Memory**

- [x] **Clase CPU**
  - [ ] Simular un CPU con capacidad para ejecutar 5 tareas
  - [x] Registro IR para visualizar la instrucción en ejecución

- [ ] **Clase AsmLoader**
  - [ ] Cargar programas .asm desde disco
  - [x] Validar sintaxis de los archivos .asm
    - [x] LOAD
    - [x] STORE
    - [x] MOV
    - [x] SUB
    - [x] ADD
    - [x] INC
    - [x] DEC
    - [x] SWAP
    - [x] INT
    - [x] JMP
    - [x] CMP
    - [x] JE
    - [x] JNE
    - [x] PARAM
    - [x] PUSH
    - [x] POP
  - [ ] Cargar múltiples archivos simultáneamente
  - [ ] Gestionar la asignación de programas en memoria

- [x] **Clase Instruction**
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
- [x] **Cargar Programas en Memoria**
  - [x] Leer Archivos .asm: Leer uno o más archivos de programas en ensamblador (*.asm) desde el disco.
  - [ ] **Crear Bloque de Control de Proceso (PCB) para Cada Programa**
    - [ ] Asignar un Process ID (PID) único.
    - [ ] Establecer la dirección base y el límite del segmento de memoria donde se almacenarán las instrucciones del programa.
    - [ ] Inicializar el contador de programa (PC) con la dirección base del segmento de instrucciones del proceso.
    - [ ] Inicializar otros registros (AC, AX, BX, CX, DX) y la información del stack (tamaño del stack = 5).
    - [ ] Establecer la prioridad y otra información de contabilidad.
  - [ ] **Cargar las Instrucciones y Datos del Programa en el Segmento de Usuario**
    - [ ] Colocar las instrucciones en el segmento de código y los datos en el segmento de datos del proceso.
  - [ ] **Añadir el PCB a la Cola de Procesos:** Insertar el PCB del nuevo proceso en la cola de procesos (por ejemplo, cola de procesos listos).

- [ ] **Gestión de Procesos y Planificación (Scheduling)**
  - [ ] **Algoritmo de Planificación FCFS (First-Come, First-Served)**
    - [ ] Seleccionar el primer proceso de la cola de procesos listos para ser ejecutado.
    - [ ] El proceso seleccionado cambia a estado Running.
  - [ ] **Conmutación de Contexto (Context Switching)**
    - [ ] Guardar el estado del proceso actual en su PCB cuando se pausa o bloquea.
    - [ ] Cargar el estado del próximo proceso a ejecutar desde su PCB.

- [ ] **Ejecución del Ciclo Fetch-Decode-Execute**
  - [ ] **Modo de Ejecución Paso a Paso**
    - [ ] En el Modo Paso a Paso, ejecutar las instrucciones una por una. El usuario presiona un botón "Siguiente" para ejecutar cada instrucción.
    - [ ] Actualizar la interfaz gráfica (GUI) para mostrar el estado actual del PCB, los registros (IR, AC, PC), y la memoria.
  - [ ] **Modo de Ejecución Automático**
    - [ ] En el Modo Automático, ejecutar todas las instrucciones del proceso hasta que se complete o se bloquee por una interrupción o E/S.
    - [ ] La interfaz gráfica muestra en tiempo real el estado de la memoria, los registros, y el PCB.

- [ ] **Gestión de Interrupciones y E/S**
  - [ ] **Interrupciones**
    - [ ] Manejar diferentes tipos de interrupciones, como INT 10H para mostrar datos o INT 09H para entrada del teclado.
    - [ ] Actualizar el estado del proceso a Waiting si está esperando por una operación de E/S.
  - [ ] **Operaciones de E/S**
    - [ ] Agregar solicitudes de E/S pendientes a la lista de solicitudes del proceso en su PCB.
    - [ ] Después de completar la E/S, cambiar el estado del proceso de Waiting a Ready.

- [ ] **Conmutación de Contexto y Continuación de la Ejecución**
  - [ ] **Cuando se completa una operación de E/S o un proceso es bloqueado, se realiza una conmutación de contexto**
    - [ ] Guardar el estado del proceso actual (por ejemplo, el valor del contador de programa (PC), registros, etc.) en su PCB.
    - [ ] Seleccionar el siguiente proceso en la cola de Ready usando el algoritmo de planificación y cargar su estado desde su PCB.
  - [ ] Reanudar la ejecución del siguiente proceso.

- [ ] **Finalización del Proceso**
  - [ ] **Ejecutar Instrucción HALT**
    - [ ] Cuando un proceso ejecuta una instrucción HALT, cambia su estado a "Terminated".
    - [ ] Liberar los recursos del proceso, incluyendo la memoria y el PCB.

- [ ] **Visualización de Resultados y Estadísticas**
  - [ ] **Mostrar Estadísticas**
    - [ ] Mostrar estadísticas detalladas al finalizar, como el tiempo de inicio, tiempo de finalización, duración del proceso, tiempo de CPU utilizado, etc.
    - [ ] La interfaz gráfica (GUI) muestra los resultados finales, incluyendo el estado de todos los procesos, el contenido de la memoria, los registros del CPU, y las estadísticas de rendimiento.
