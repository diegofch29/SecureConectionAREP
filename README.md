# SecureConectionAREP

## Prerequisitos

Para usar la aplicación necesitara lo siguiente:

*maven
*jdk 8

## Descargando y ejecutando
### Descarga
Para descargar la aplicación solo tiene que usar la siguiente linea.

```
git clone https://github.com/diegofch29/SecureConectionAREP
```
### Utilizado la aplicación
  Para usar la aplicación debe seguir los siguientes pasos
  * Compilar el codigo debe estar ubicado en la carpeta "SecureConectionAREP" y el siguiente comando.
  ```
  mvn clean package
  ```
  * Para ejecutar el codigo utilice la siguiente linea, puede cambiar los numero como desee siempre y cuando los numeros esten separados por espacios.
  ```
  java -cp target/classes:target/dependency/* edu.escuelaing.arep.secureconection.Conection
  ```
  * La aplicion corre en el localhost/login en el puerto 5000 o en el puerto configurado en el ambiente.
## Como funciona
  Utilizado el framework spark web se implemento el protocolo https, al momento de hacer el login la contraseña es encriptada con SHA-256 y se compara
  con el hash que se encuentra guardado, de esta manera nos evitamos guardar contraseñas en texto  plano y agregamos seguridad a la aplicacion.
  
## Video AWS
[Video demostracion Funcionamiento en AWS](https://youtu.be/rfGOkmwGg9I)

## Construido con

* [Java](https://www.java.com/es/) - Lenguaje de programación
* [Maven](https://maven.apache.org/) - Manejo de dependencias
* [Git](https://git-scm.com/) - Control de versiones

# Autor

* **Diego Fernando Chinchilla Bautista** - *Deviation* - [Diegofch29](https://github.com/diegofch29)

## Licencia

Este proyecto está licenciado bajo la licencia del GNU - Vea el [LICENSE.txt](LICENSE.txt) para más detalles
