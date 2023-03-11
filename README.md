# ResDev

ResDev est un projet visant à faciliter le partage de ressources liées au développement web.

## Prérequis

* Java 17
* Spring Boot 3.0.4
* Maven 3.6.3 ou version ultérieure
* Base de données SQL Server 2019

## Installation

Pour installer le projet, clonez le repository. Il est également nécessaire de créer un fichier `database.properties` à la racine du projet avec les informations de connexion à la base de données. Voir la rubrique "Base de données" pour plus d'informations.

## Base de données

Le projet nécessite la création d'un fichier `database.properties` à la racine du projet avec les informations de connexion à la base de données.

Voici le contenu du fichier `database.properties` :

```
spring.datasource.url=jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;databaseName=nom_de_votre_base_de_données
spring.datasource.username=votre_identifiant
spring.datasource.password=votre_mot_de_passe
```

## Utilisation

Afin d'utiliser l'application, il vous faut lancer le serveur local depuis votre IDE, puis vous rendre à l'adresse suivante : `http://localhost:8080`.

## Visualisation et test des API REST

Pour visualiser et tester les endepoints, vous pouvez accéder à l'interface graphique Swagger UI via l'URL suivante : `http://localhost:8080/swagger-ui/index.html`.

## Dépendances

Le projet utilise les dépendances suivantes :

- Spring Boot Starter Data JPA pour la gestion des données
- Spring Boot Starter Web pour la création de l'application web
- Spring Boot DevTools pour faciliter le développement
- Microsoft SQL Server JDBC pour la connexion à la base de données
- Project Lombok pour faciliter l'écriture du code
- Spring Boot Starter Test pour les tests unitaires
- Apache POI pour la manipulation des fichiers Excel
- Springdoc-OpenAPI pour générer une spécification OpenAPI de l'API RESTful de l'application

## Contributions

Les contributions sont les bienvenues ! N'hésitez pas à soumettre une pull request ou à ouvrir une issue sur Github.

## Auteurs

- DeaLeSa
