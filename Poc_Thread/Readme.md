TRABAJO: AHORCADO
TEMA: Thread and Runnable
ALUMNA: Felice, Karina

Diferencia entre thread y runnable

	Hay dos formas de hacer una tarea correr concurrentemente con otra: crear una nueva clase como subclase de la clase Thread o 
declarar una clase e implementar la interfaz Runnable.
Uso de Subclase
 	Cuando se crea una subclase de Thread, la subclase debería definir su propio método run() para sobre-escribir el método run() 
de la  clase Thread. La tarea concurrente es desarrollada en este método run().

Ejecución del método run()
	Una instancia de la subclase es creada con new, luego llamamos al método start() de la thread para hacer que la máquina virtual 
Java ejecute el método run(). Ojo para iniciar la concurrencia invocamos a start(), así invocamos a run() en forma indirecta. Si invocamos 
a run() directamente, se comportará como el llamado a cualquier método llamado dentro de un mismo hilo (sin crear uno independiente).

Implementación de la Interfaz Runnable
	La interfaz Runnable requiere que sólo un método sea implementado, el método run(). Primero creamos una instancia de esta clase 
con new, luego creamos una instancia de Thread con otra sentencia new y usamos el objeto recién creado en el constructor. Finalmente, 
llamamos el método start() de la instancia de Thread para iniciar la tarea definida en el método run().

RunnableThread.java
	Una instancia de una clase que defina el método run() - ya sea como subclase de Thread o implementando la interfaz Runnable - debe ser
 pasada como argumento en la creación de una instancia de Thread. Cuando el método start() de esta instancia es llamado, Java run  time 
sabe qué método run() ejecutar.



CICLO DE VIDA DE UN HILO

Un hilo tiene un ciclo de vida que va desde su creación hsta su terminación. Durante su ciclo de vida cada uno de los hilos o tareas de una 
aplicación puede estar en diferentes estados, algunos de los cuales se indican a continuación:

• Nacido: Cuando se acaba de crear un hilo, se dice que está nacido, y continúa en ese estado hasta que se invoca el método start() del hilo. 
La siguiente sentencia crea un nuevo thread pero no lo arranca, por lo tanto deja el thread en el estado de nacido.

       Thread miHilo = new MiClaseThread();

Cuando un thread está en este estado, es sólo un objeto Thread vacío o nulo. No se han asignado recursos del sistema todavía para el thread. 
Así, cuando un thread está en este estado, lo único que se puede hacer es arrancarlo con start().

• Listo: Cuando se invoca el método start() del hilo, se dice que está en estado listo. El método se arranca con la siguiente instrucción, 
para el caso del hilo jugador:

       jugador.start();

• Ejecutable: cuando el método start() se ejecuta, crea los recursos del sistema necesarios para ejecutar el thread,programa el thread para 
ejecutarse, y llama al método run() del thread que se ejecuta en forma secuencial. En este punto el thread está en el estado ejecutable. 
Se denomina así puesto que todavía no ha empezado a ejecutarse.

• En ejecución: Un hilo en estado de listo de la más alta prioridad, pasa al estado de ejecución, cuando se le asignan los recursos de un 
procesador, o sea cuando inicia su ejecución. Aquí el thread está en ejecución.Cada hilo tiene su prioridad, hilos con alta prioridad se 
ejecutan preferencialmente sobre los hilos de baja prioridad. En el ejercicio del ahorcado no tenian asignado una priotidad y es por ello
que se ejecuta el primero que llega

• No ejecutable :Un hilo continúa la ejecución de su método run(), hasta que pasa al estado de no ejecutable originado cuando ocurre alguno 
de los siguientes cuatro eventos:

Se invoca a su método sleep().
Se invoca a su su método suspend().
El thread utiliza su método wait() para esperar una condición variable. (Como se desarrollo en el ahorcado)
El thread está bloqueado durante una solicitud de entrada/salida.


• Muerto: Un hilo pasa al estado de muerto cuando se termina su método run(), o cuando se ha invocado su método stop(). En algún momento 
el sistema dispondrá entonces del hilo muerto. Un hilo puede morir de dos formas:

Muerte natural: se produce cuando su método run() sale normalmente. Por ejemplo, cuando ya no hay mas letras para adivinar entonces hay 
un hilo ganador o cuando se le terminaron las vidas y eso significa que perdio.

Por muerte provocada: en cualquier momento llamando a su método stop().
El método stop() lanza un objeto ThreadDeath hacia al hilo a eliminar. El thread moririá cuando reciba realmente la excepción ThreadDeath.

El método stop() provoca una terminación súbita del método run() del hilo. Si el método run() estuviera realizando cálculos sensibles, 
stop() podría dejar el programa en un estado inconsistente. Normalmente, no se debería llamar al método stop() pero si se debería proporcionar 
una terminación educada como la selección de una bandera que indique que el método run() debería salir. El método stop() se encuentra 
depreciado en la version JDK1.2.1.

• Bloqueado: un hilo se encuentra en el estado bloqueado cuando el hilo realiza una solicitud de entrada/salida. Cuando termina la 
entrada/salida que estaba esperando, un hilo bloqueado queda en el estado listo.


EXPLIQUE LOS METODOS [START,SLEEP,  JOIN, YIELD]

Start(): Como habíamos mencionado antes, para poner en marcha este nuevo Thread se debe llamar al método start(), que se encarga de 
llamar a run(). Es importante no confundir el método start() con el método run(). El método run() contiene el código a ser ejecutado 
“asincrónicamente” en otro thread, mientras que el método start() es el que crea al Thread y en algún punto hace que ese Thread 
ejecute lo que esta en run().Este método devuelve el control inmediatamente. Pero si mezclamos todo y ejecutamos directamente el 
run(), el código se ejecutara en el Thread actual.

El método start() devuelve el control inmediatamente… mientras tanto, el nuevo Thread inicia su recorrido por el método run(). ¿Hasta 
cuando? Hasta que termina ese método, cuando sale, termina el Thread.


Sleep(): El método sleep() simplemente le dice al Thread que duerma durante los milisegundos específicos. Se debería utilizar sleep() 
cuando se pretenda retrasar la ejecución del Thread, sleep() no consume recursos del sistema mientras el Thread duerme. De  esta forma 
otros Threads seguir funcionando.

       jugador.sleep(1000) //Duerme al hilo jugador 1 seg


Join(): Si un Thread necesita esperar a que otro termine (por ejemplo el Thread padre espera a que termine el hijo) puede usar el 
método join().

A continuación se presenta un ejemplo más complejo: una reunión de alumnos. El siguiente ejemplo usa Threads para activar simultáneamente 
tres objetos de la misma clase, que comparten los recursos del procesador peleándose para escribir a la pantalla.

public static void main(String args[]) throws InterruptedException{

       Thread juan = new Thread (new Alumno(“Juan”));
       Thread luis = new Thread (new Alumno(“Luis”));
       Thread nora = new Thread (new Alumno(“Nora”));
      
       juan.start();
       juan.join();

       pepe.start();
       pepe.join();

       jorge.start();
       jorge.join();
}
El metodo join() que llamamos al final hace que el programa principal espere hasta que este Thread este “muerto”(finalize su ejecucion). Este 
método puede disparar la excepción InterruptedException, por lo que lo hemos tenido en cuenta en el encabezamiento del método.

En nuestro ejemplo, simplemente a cada instancia de Alumno(…) que creamos la hemos ligado a un Thread y puesto a andar. Corren todas en paralelo 
hasta que mueren de muerte natural, y también el programa principal termina.

A continuación se muestra la clase Alumno:

class Alumno implements Runnable{

String mensaje;

public Alumno(String nombre){

      mensaje = “Hola, soy “ + nombre + “ y este es mi mensaje numero: “;

}

public void run(){

      for (int i=1; i<6;i++){
              String msj = mensaje + i;
              System.out.println(msj);
      }

}

La salida será más o menos así:

Hola, soy Juan y este es mi mensaje numero 1
Hola, soy Juan y este es mi mensaje numero 2
Hola, soy Juan y este es mi mensaje numero 3
Hola, soy Juan y este es mi mensaje numero 4
Hola, soy Juan y este es mi mensaje numero 5
………….etc.


Yield(): El método yield() tiene la función de hacer que un hilo que se está ejecutando de regreso pase al estado en “listo para ejecutar” para 
permitir que otros hilos de la misma prioridad puedan ejecutarse. Sin embargo, el funcionamiento de este método (al igual que de los hilos en 
general) no está garantizado, puede que después de que se establezca un hilo por medio del método yield() a su estado “listo para ejecutar”, 
éste vuelva a ser elegido para ejecutarse. El método yield() nunca causará que un hilo pase a estado de espera/bloqueado/dormido, simplemente 
pasa de ejecutándose(running) a  “listo para ejecutar”.
A continuación tomando el ejemplo anterior solo haremos una modificación en el método run, vemos como se implementa dicho metodo:

public void run(){
       for (int i=1; i<6; i++){
                       String msj = mensaje + i;
                       System.out.println(msj);
                       Thread.yield();
       }
}

En este ejemplo la salida será más o menos así:

Hola, soy Juan y este es mi mensaje 1
Hola, soy Luis y este es mi mensaje 1
Hola, soy Nora y este es mi mensaje 1

Hola, soy Juan y este es mi mensaje 2
Hola, soy Luis y este es mi mensaje 2
Hola, soy Nora y este es mi mensaje 2

Hola, soy Juan y este es mi mensaje 3
Hola, soy Luis y este es mi mensaje 3
…………etc.


