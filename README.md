Jakarta EE Rest Api example 
===============================
Tutorial: http://www.mastertheboss.com/javaee/jakarta-ee/getting-started-with-jakarta-ee

# Télécharger TomEE, Maven, OpenJDK

1. TomEE Plume ZIP (ex. version 8.0.8)
 https://tomee.apache.org/download.html

2. Maven Binary Zip (ex. version Apache Maven 3.8.4)
https://maven.apache.org/download.cgi

3. JDK 11 Binary Zip (archive Zip plutot que MSI installer)
https://www.azul.com/downloads/azure-only/?version=java-11-lts&os=windows&architecture=x86-64-bit&package=jdk

# Installation

1. Créer dossier C:\JAVA
2. Dézipper les 3 archives + renommer les dossiers:
- c:\JAVA\ jdk-11\  (sous-dossiers: bin\, ...)
- .......  maven\   (sous-dossiers: bin\, ...)
- .......  tomee\   (sous-dossiers: bin\, ...)
- .......  projets\ (dossier des projets à compiler)

3. Dans jdk-11\bin on doit trouver:
- javac.exe: compilateur
- java.exe: execute le programme
- jar.exe: archiver

4. Dans projets, dézipper le projet tomee-jakarta-hsqldb.zip
5. Dans le dossier tomee-jakarta-hsqldb\
- Dble-cliquer sur maven.bat
- dans la console, taper la commande: mvn -version
- le résultat doit afficher:
```
Apache Maven 3.8.4, Maven home: C:\JAVA\maven
Java version: 11.0.13, runtime: C:\JAVA\jdk-11
Default locale: fr_FR, platform encoding: Cp1252
OS name: "windows 10" ...
```

# Builder le projet
- Dans la console, taper: mvn clean package
- Si le build est SUCCESS, on obtient le fichier .war:
```
[INFO] Building war: C:\JAVA\projets\demo\target\demo-jakarta.war
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```
# Déployer l'application dans le serveur TomEE
- Dans la console, copier l'archive: copy target\demo-jakarta.war C:\JAVA\tomee\webapps\
- puis taper: cd C:\JAVA\tomee
- Démarrer le serveur TomEE: bin\startup.bat
- Si une fenetre Windows s'affiche, "cliquer sur Autoriser l'accès"

# Ouvrir l'application dans le navigateur (Chrome ou Edge)
- Taper l'adresse "localhost:8080/demo-jakarta"

![Alt text](jakarta.jpg?raw=true "Title")

