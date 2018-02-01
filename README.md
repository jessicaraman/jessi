Digicar
===========

Spring MVC + Hibernate + Maven

Dependencies
===========

## Java
* Spring MVC 3.2.2
* Hibernate 4.2.0

## Front end
* MDBootstrap 4.4.4
* Font Awesome 4.7.0 

To set BD locally
===========
Use the `hibnatedb.sql` file in the `common/src/main/java/fr/digicar/sql` directory

To get the code
===========
Clone the repository:

```
git clone http://fw-i2-digicar:8086/alpha.barry/digicar.git
```

To run the application locally
===========

From the command line with Maven:

```
cd digicar
mvn clean install
```

Artifacts to deploy: 
* `backoffice.war`
* `webportal.war` 

Access the deployed web application at [http://localhost:8080/digicar/](http://localhost:8080/digicar/)
