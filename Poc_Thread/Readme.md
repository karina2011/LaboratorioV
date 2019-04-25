TRABAJO: AHORCADO
TEMA: Thread and Runnable
ALUMNA: Felice, Karina

Diferencia entre thread y runnable

	Hay dos formas de hacer una tarea correr concurrentemente con otra: crear una nueva clase como subclase de la clase Thread o 
declarar una clase e implementar la interfaz Runnable.
Uso de Subclase
 	Cuando se crea una subclase de Thread, la subclase deber�a definir su propio m�todo run() para sobre-escribir el m�todo run() 
de la  clase Thread. La tarea concurrente es desarrollada en este m�todo run().

Ejecuci�n del m�todo run()
	Una instancia de la subclase es creada con new, luego llamamos al m�todo start() de la thread para hacer que la m�quina virtual 
Java ejecute el m�todo run(). Ojo para iniciar la concurrencia invocamos a start(), as� invocamos a run() en forma indirecta. Si invocamos 
a run() directamente, se comportar� como el llamado a cualquier m�todo llamado dentro de un mismo hilo (sin crear uno independiente).

Implementaci�n de la Interfaz Runnable
	La interfaz Runnable requiere que s�lo un m�todo sea implementado, el m�todo run(). Primero creamos una instancia de esta clase 
con new, luego creamos una instancia de Thread con otra sentencia new y usamos el objeto reci�n creado en el constructor. Finalmente, 
llamamos el m�todo start() de la instancia de Thread para iniciar la tarea definida en el m�todo run().

RunnableThread.java
	Una instancia de una clase que defina el m�todo run() - ya sea como subclase de Thread o implementando la interfaz Runnable - debe ser
 pasada como argumento en la creaci�n de una instancia de Thread. Cuando el m�todo start() de esta instancia es llamado, Java run  time 
sabe qu� m�todo run() ejecutar.



CICLO DE VIDA DE UN HILO

Un hilo tiene un ciclo de vida que va desde su creaci�n hsta su terminaci�n. Durante su ciclo de vida cada uno de los hilos o tareas de una 
aplicaci�n puede estar en diferentes estados, algunos de los cuales se indican a continuaci�n:

� Nacido: Cuando se acaba de crear un hilo, se dice que est� nacido, y contin�a en ese estado hasta que se invoca el m�todo start() del hilo. 
La siguiente sentencia crea un nuevo thread pero no lo arranca, por lo tanto deja el thread en el estado de nacido.

       Thread miHilo = new MiClaseThread();

Cuando un thread est� en este estado, es s�lo un objeto Thread vac�o o nulo. No se han asignado recursos del sistema todav�a para el thread. 
As�, cuando un thread est� en este estado, lo �nico que se puede hacer es arrancarlo con start().

� Listo: Cuando se invoca el m�todo start() del hilo, se dice que est� en estado listo. El m�todo se arranca con la siguiente instrucci�n, 
para el caso del hilo jugador:

       jugador.start();

� Ejecutable: cuando el m�todo start() se ejecuta, crea los recursos del sistema necesarios para ejecutar el thread,programa el thread para 
ejecutarse, y llama al m�todo run() del thread que se ejecuta en forma secuencial. En este punto el thread est� en el estado ejecutable. 
Se denomina as� puesto que todav�a no ha empezado a ejecutarse.

� En ejecuci�n: Un hilo en estado de listo de la m�s alta prioridad, pasa al estado de ejecuci�n, cuando se le asignan los recursos de un 
procesador, o sea cuando inicia su ejecuci�n. Aqu� el thread est� en ejecuci�n.Cada hilo tiene su prioridad, hilos con alta prioridad se 
ejecutan preferencialmente sobre los hilos de baja prioridad. En el ejercicio del ahorcado no tenian asignado una priotidad y es por ello
que se ejecuta el primero que llega

� No ejecutable :Un hilo contin�a la ejecuci�n de su m�todo run(), hasta que pasa al estado de no ejecutable originado cuando ocurre alguno 
de los siguientes cuatro eventos:

Se invoca a su m�todo sleep().
Se invoca a su su m�todo suspend().
El thread utiliza su m�todo wait() para esperar una condici�n variable. (Como se desarrollo en el ahorcado)
El thread est� bloqueado durante una solicitud de entrada/salida.


� Muerto: Un hilo pasa al estado de muerto cuando se termina su m�todo run(), o cuando se ha invocado su m�todo stop(). En alg�n momento 
el sistema dispondr� entonces del hilo muerto. Un hilo puede morir de dos formas:

Muerte natural: se produce cuando su m�todo run() sale normalmente. Por ejemplo, cuando ya no hay mas letras para adivinar entonces hay 
un hilo ganador o cuando se le terminaron las vidas y eso significa que perdio.

Por muerte provocada: en cualquier momento llamando a su m�todo stop().
El m�todo stop() lanza un objeto ThreadDeath hacia al hilo a eliminar. El thread moriri� cuando reciba realmente la excepci�n ThreadDeath.

El m�todo stop() provoca una terminaci�n s�bita del m�todo run() del hilo. Si el m�todo run() estuviera realizando c�lculos sensibles, 
stop() podr�a dejar el programa en un estado inconsistente. Normalmente, no se deber�a llamar al m�todo stop() pero si se deber�a proporcionar 
una terminaci�n educada como la selecci�n de una bandera que indique que el m�todo run() deber�a salir. El m�todo stop() se encuentra 
depreciado en la version JDK1.2.1.

� Bloqueado: un hilo se encuentra en el estado bloqueado cuando el hilo realiza una solicitud de entrada/salida. Cuando termina la 
entrada/salida que estaba esperando, un hilo bloqueado queda en el estado listo.


EXPLIQUE LOS METODOS [START,SLEEP,  JOIN, YIELD]

Start(): Como hab�amos mencionado antes, para poner en marcha este nuevo Thread se debe llamar al m�todo start(), que se encarga de 
llamar a run(). Es importante no confundir el m�todo start() con el m�todo run(). El m�todo run() contiene el c�digo a ser ejecutado 
�asincr�nicamente� en otro thread, mientras que el m�todo start() es el que crea al Thread y en alg�n punto hace que ese Thread 
ejecute lo que esta en run().Este m�todo devuelve el control inmediatamente. Pero si mezclamos todo y ejecutamos directamente el 
run(), el c�digo se ejecutara en el Thread actual.

El m�todo start() devuelve el control inmediatamente� mientras tanto, el nuevo Thread inicia su recorrido por el m�todo run(). �Hasta 
cuando? Hasta que termina ese m�todo, cuando sale, termina el Thread.


Sleep(): El m�todo sleep() simplemente le dice al Thread que duerma durante los milisegundos espec�ficos. Se deber�a utilizar sleep() 
cuando se pretenda retrasar la ejecuci�n del Thread, sleep() no consume recursos del sistema mientras el Thread duerme. De  esta forma 
otros Threads seguir funcionando.

       jugador.sleep(1000) //Duerme al hilo jugador 1 seg


Join(): Si un Thread necesita esperar a que otro termine (por ejemplo el Thread padre espera a que termine el hijo) puede usar el 
m�todo join().

A continuaci�n se presenta un ejemplo m�s complejo: una reuni�n de alumnos. El siguiente ejemplo usa Threads para activar simult�neamente 
tres objetos de la misma clase, que comparten los recursos del procesador pele�ndose para escribir a la pantalla.

public static void main(String args[]) throws InterruptedException{

       Thread juan = new Thread (new Alumno(�Juan�));
       Thread luis = new Thread (new Alumno(�Luis�));
       Thread nora = new Thread (new Alumno(�Nora�));
      
       juan.start();
       juan.join();

       pepe.start();
       pepe.join();

       jorge.start();
       jorge.join();
}
El metodo join() que llamamos al final hace que el programa principal espere hasta que este Thread este �muerto�(finalize su ejecucion). Este 
m�todo puede disparar la excepci�n InterruptedException, por lo que lo hemos tenido en cuenta en el encabezamiento del m�todo.

En nuestro ejemplo, simplemente a cada instancia de Alumno(�) que creamos la hemos ligado a un Thread y puesto a andar. Corren todas en paralelo 
hasta que mueren de muerte natural, y tambi�n el programa principal termina.

A continuaci�n se muestra la clase Alumno:

class Alumno implements Runnable{

String mensaje;

public Alumno(String nombre){

      mensaje = �Hola, soy � + nombre + � y este es mi mensaje numero: �;

}

public void run(){

      for (int i=1; i<6;i++){
              String msj = mensaje + i;
              System.out.println(msj);
      }

}

La salida ser� m�s o menos as�:

Hola, soy Juan y este es mi mensaje numero 1
Hola, soy Juan y este es mi mensaje numero 2
Hola, soy Juan y este es mi mensaje numero 3
Hola, soy Juan y este es mi mensaje numero 4
Hola, soy Juan y este es mi mensaje numero 5
����.etc.


Yield(): El m�todo yield() tiene la funci�n de hacer que un hilo que se est� ejecutando de regreso pase al estado en �listo para ejecutar� para 
permitir que otros hilos de la misma prioridad puedan ejecutarse. Sin embargo, el funcionamiento de este m�todo (al igual que de los hilos en 
general) no est� garantizado, puede que despu�s de que se establezca un hilo por medio del m�todo yield() a su estado �listo para ejecutar�, 
�ste vuelva a ser elegido para ejecutarse. El m�todo yield() nunca causar� que un hilo pase a estado de espera/bloqueado/dormido, simplemente 
pasa de ejecut�ndose(running) a  �listo para ejecutar�.
A continuaci�n tomando el ejemplo anterior solo haremos una modificaci�n en el m�todo run, vemos como se implementa dicho metodo:

public void run(){
       for (int i=1; i<6; i++){
                       String msj = mensaje + i;
                       System.out.println(msj);
                       Thread.yield();
       }
}

En este ejemplo la salida ser� m�s o menos as�:

Hola, soy Juan y este es mi mensaje 1
Hola, soy Luis y este es mi mensaje 1
Hola, soy Nora y este es mi mensaje 1

Hola, soy Juan y este es mi mensaje 2
Hola, soy Luis y este es mi mensaje 2
Hola, soy Nora y este es mi mensaje 2

Hola, soy Juan y este es mi mensaje 3
Hola, soy Luis y este es mi mensaje 3
����etc.


