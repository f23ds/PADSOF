# Uso Demostrador:

- **Se ejecuta la clase `Demostrador.java` que actúa como `main` para comprobar diversas funcionalidades de la aplicación.**
- **Existe un desarrollo guiado de pruebas que se vuelcan en un fichero de datos `demostrador.txt`. En él se puede seguir la ejecución de diversas acciones en la aplicación.**
- **Sin embargo, para un correcto entendimiento del desarrollo, es recomendable ojear el código de `Demostrador.java` para resolver posibles dudas con respecto a las pruebas.**

#Diagrama de clases:
- **Los getters, los setters y los constructores no se especifican en el diagrama**
- **Ademas, las funciones encargadas de añadir objetos a colecciones, como puede ser addClientes, etc tampoco se especifican en el diagrama de clases**

#Sistema:

- **Implementamos el getInstance sin argumentos para que cree el sistema completamente vacio**
- **Los atributos Horario y Gestor se settean en el constructor privado a unos valores que estan arraigados al programa. El resto de colecciones se inicializan.**
- **Hemos requerido una funcion privada copiarSistema que nos ayuda al implementar la funcion cargarDatos. Esta funcion por lo tanto no se prueba de manera separada en los tests, se hace implicitamente en cargarDatos**
- **Tambien hemos implementado una funcion setInstancenull que no tiene otro uso mas que el de ayudarnos en los tests para que antes de cada test se inicialice la instancia del sistema.**

#Directorio tmp:

- **Este directorio se mantiene únicamente para la generación de tickets**
