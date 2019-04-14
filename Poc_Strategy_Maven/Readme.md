TRABAJO PRACTICO: NUMERO 1

TEMA: TORNEO DE 

ALUMNA:FELICE, 


¿QUE ES MAVEN?

  Maven es una de las herramientas más útiles a la hora de utilizar librerías de terceros. Maven se utiliza en la gestión y construcción de 
software. Posee la capacidad de realizar ciertas tareas claramente definidas, como la compilación del código y su empaquetado. Es decir, 
hace posible la creación de software con dependencias incluidas dentro de la estructura del JAR. Es necesario definir todas las 
dependencias del proyecto (librerías externas utilizadas) en un fichero propio de todo proyecto Maven, el POM (Project Object Model). 
Sin embargo, la característica más importante de Maven es su capacidad de trabajar en red. Cuando definimos las dependencias de Maven, 
este sistema se encargará de ubicar las librerías que deseamos utilizar en Maven Central, el cual es un repositorio que contiene cientos 
de librerías constantemente actualizadas por sus creadores. Maven permite incluso buscar versiones más recientes o más antiguas de un 
código dado y agregarlas a nuestro proyecto. Todo se hará de forma automática sin que el usuario tenga que hacer nada más que definir 
las dependencias.


¿POM QUE SIGNIFICA Y PARA QUE NOS SIRVE?

  POM(Project Object Model) es un archivo en formato XML que contiene todo lo necesario para que a la hora de generar el fichero 
ejecutable de nuestra aplicación este contenga todo lo que necesita para su ejecución en su interior. Contiene las clases propias 
de la librería pero ademas incluye toda la información necesaria para su correcta gestión (grupo, versión, dependencias etc).
  En otras palabras es un archivo xml llamado pom.xml y ubicado en la raiz de un proyecto (o un módulo) que declara datos sobre el mismo, dependencias
y plugins a utilizar durante el ciclo de vida de la administración del proyecto. 


DIFERENCIAS ENTRE ARCHETYPE Y ARTIFACT

ARCHETYPE:
  Archetype es un conjunto de herramientas para la creación de plantillas del proyecto Maven. Un arquetipo se define como un patrón o 
modelo original a partir del cual se hacen todas las demás cosas del mismo tipo . El nombre se ajusta a medida que intentamos 
proporcionar un sistema que proporcione un medio consistente para generar proyectos de Maven. Archetype ayudará a los autores a crear 
plantillas de proyectos de Maven para los usuarios, y proporciona a los usuarios los medios para generar versiones parametrizadas de 
esas plantillas de proyectos.
  El uso de arquetipos proporciona una excelente manera de habilitar a los desarrolladores de manera rápida y consistente con las 
mejores prácticas empleadas por su proyecto u organización.
ARTIFACT:
  Para programar de una forma correcta por lo menos deberíamos construir código que sea reutilizable . Normalmente la reutilización 
esta fuertemente ligada con la modularidad. Es decir a bloques de código más pequeños mayor es la posibilidad de reutilización.
  Un Maven Artifact no es ni más ni menos que un bloque de código reutilizable. 
  
  Maven utilza el término artifact para denominar a la unidad mínima que maneja en su repositorio. Puede ser por ejemplo un jar, un ear, 
un zip, etc. Cuando Maven compila y empaqueta código, produce también artifacts que instala en el repositorio. Los artifacts están 
agrupados bajo el id de grupo (groupId) y tienen un id propio (artifactId), una versión, un clasificador y una extensión. Para 
administrar los artefactos en el repositrio Maven los acompaña con un respectivo pom.xml conteniendo los datos anteriores, mientras que
archetypes (arquetipos) son las plantillas que contienen la descripción y administración de un proyecto que debe tener una estructura 
determinada e incluye los pom.xml necesarios. 
  Existe un plugin en Maven que permite generar la estructura y configuración inicial de un proyecto a partir 
de una plantilla. Estas plantillas son llamadas archetypes (arquetipos) y el plugin que permite la generación a partir de los 
arquitipos se llama también archetype.
  En terminos simples el artefacto (artefact) es la salida de la construcción. Es lo que crea la construcción. En pocas palabras, si 
estás construyendo un tarro, es el tarro. Si es una guerra, es la guerra mientras que arquetipo es un modelo a seguir que genera un 
proyecto basado en una plantilla. Está creado para facilitar las construcciones. Por ejemplo, la mayoría de los proyectos Java 
simples tienen en común: src,main,java,test,resources,pom.xml

  EXPLIQUE LOS SIGUIENTES GOALS DE MAVEN: [CLEAN, PACKAGE, INSTALL, COMPILE]
  
  Si pensamos en un ejemplo practico. Suponiendo que queremos hace una calculadora entonces generamos el codigo para ello. 
  Ya tenemos nuestra super calculadora , sin embargo esto no es funcional ya que tendremos que 
compilarlo para poder ejecutarlo.  Es aquí donde el concepto de Maven Artifact es capaz de abstraer de una forma correcta y a 
detalle lo que implica compilar un bloque de código. En principio un desarrollador piensa que compilar el código es simplemente 
pulsar al botón de compilar y se genera un compilado en nuestro caso un jar o algo similar.
  La realidad es que esto no es  tan directo el proceso de compilación y generación de un jar se puede dividir en bastantes fases
  
  VALIDATE -> COMPILE -> TEST -> PACKAGE -> INSTALL -> DEPLOY
  
  VALIDATE : Simplemente comprueba que el proyecto tiene la estructura correcta y los ficheros están donde tienen que estar . Ok a 
nivel práctico hace poca cosa.
  COMPILE : Nos compila el código, este es fácil de entender , eso si nosotros compilamos el código primero pasará la por la fase de 
validate.
  TEST: Se encarga de pasar las pruebas unitarias , algo que siempre debiéramos tener por lo tanto es otra fase importante y que 
Maven de  alguna forma refuerza.
  PACKEGE: Recordemos que una cosa es compilar nuestro código y generar los ficheros .class y otra cosa muy diferente es generar 
un empaquetado que se pueda “reutilizar” . Recordemos el concepto de código reutilizable

  CODIGO------compilacion------->COMPILADO(CLASESS)-----packege------->PACKEGE 
  
  Compilar no es lo mismo que empaquetar . Aunque a veces las herramientas lo simplifican tanto que lo parece.
  install: La realidad es que la gente nos va a solicitar el empaquetado y el código fuente . El código fuente es necesario nos le 
van a solicitar siempre. Así que de alguna forma necesitamos instalar nuestro artefacto de maven en un repositorio de Maven. Eso es 
lo que se hace en la fase de install.
  A partir de este momento tenemos instalado nuestro Maven artifact en un repositorio para su posterior utilización este repositorio 
se encuentra en la famosa carpeta .m2. Si queremos que nuestro artefacto pueda ser utilizado por otros developers necesitaremos 
realizar maven deploy esto nos lo instalará en un repositorio Maven remoto al que otros usuarios podrán acceder (Nexus o Artifactory).
  Clean: se usa cuando desea eliminar los archivos generados en el momento de la compilación en el directorio de un proyecto.


EXPLIQUE LOS SIGUENTES SCOPES [COMPILE, PROVIDE,RUNTIME,TEST, SYSTEM]

Compile: Este es el alcance predeterminado, usado si no se especifica ninguno. Las dependencias de compilación están disponibles en 
todos los classpaths de un proyecto. Además, esas dependencias se propagan a proyectos dependientes.

Provided: Esto es muy parecido a compilar, pero indica que espera que el JDK o un contenedor proporcione la dependencia en tiempo de 
ejecución. Por ejemplo, al crear una aplicación web para Java Enterprise Edition, establecería la dependencia de la API de Servlet 
y las API de Java EE relacionadas en el alcance proporcionado porque el contenedor web proporciona esas clases. Este alcance solo 
está disponible en la compilación y prueba classpath, y no es transitivo.

Runtime: Este alcance indica que la dependencia no es necesaria para la compilación, pero es para la ejecución. Se 
encuentra en el entorno de ejecución y en la prueba de las rutas de clase, pero no en la compilación de la ruta de clases.

Test: Este alcance indica que la dependencia no es necesaria para el uso normal de la aplicación, y solo está disponible para las 
fases de compilación y ejecución de la prueba. Este alcance no es transitivo.

System  Este ámbito es similar al proporcionado, excepto que debe proporcionar el JAR que lo contiene explícitamente. El artefacto 
siempre está disponible y no se busca en un repositorio.
