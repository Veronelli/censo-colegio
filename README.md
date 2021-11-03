### Intalar dependencias
`mvn install`

### Compilar
`mvn compile`

### Ejecutar Maven project
Sin argumentos
`mvn exec:java -Dexec.mainClass=ar.com.censo.main.Main`

Con argumentos
`-Dexec.args="arg1"`

#### Explicacion del comando:
`mvn`: indica el programa de ejecución. Luego en el `Dexec.mainClass=` se declara la ubicacion de el objeto de arranque

En con cualquier problema se debe buscar el archivo `.replit` el cual contiene la configuracion del arranque.