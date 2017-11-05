Digicar
===========

Spring MVC + Hibernate + Maven

Technologies
===========
* MVC 3.x.x
* JDK 1.8
* WAMP Server for mySQL IHM
* Or MySQL 

To set BD locally
===========
Use the `hibnatedb` file in `sql` directory

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
mvn clean install -Dmaven.test.skip=true
```

or

In your preferred IDE such as SpringSource Tool Suite (STS) or IntelliJ IDEA:

Import digicar as a Maven Project
Drag-n-drop the project onto the glassfich 5.0.
Access the deployed web application at [http://localhost:8080/digicar/](http://localhost:8080/digicar/)
