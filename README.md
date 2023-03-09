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

Pour utiliser l'application, lancez le serveur local à partir de l'IDE et accédez à l'adresse `http://localhost:8080`.

## Dépendances

Le projet utilise les dépendances suivantes :

- Spring Boot Starter Data JPA pour la gestion des données
- Spring Boot Starter Web pour la création de l'application web
- Spring Boot DevTools pour faciliter le développement
- Microsoft SQL Server JDBC pour la connexion à la base de données
- Project Lombok pour faciliter l'écriture du code
- Spring Boot Starter Test pour les tests unitaires
- Apache POI pour la manipulation des fichiers Excel

## Méthodes

| Classe | Type | URL | Description |
| --- | --- | --- | --- |
| RessourceController | GET  | /api/v1/ressources/all | Récupère toutes les ressources |
| RessourceController | GET  | /api/v1/ressources/{id} | Récupère une ressource par son ID |
| RessourceController | POST | /api/v1/ressources/create | Enregistre une nouvelle ressource |
| RessourceController | POST | /api/v1/ressources/update/{id} | Met à jour une ressource existante |
| RessourceController | POST | /api/v1/ressources/delete/{id} | Supprime une ressource existante |
| RessourceController | POST | /api/v1/ressources/import-file | Importe une liste de ressources depuis un fichier Excel |
| CategorieController |	GET	 | /api/v1/categories/all | Récupère toutes les catégories |
| CategorieController | GET	 | /api/v1/categories/{id} | Récupère une catégorie par son ID |
| CategorieController	| POST | /api/v1/categories/create | Enregistre une nouvelle catégorie |

## Contributions

Les contributions sont les bienvenues ! N'hésitez pas à soumettre une pull request ou à ouvrir une issue sur Github.

## Auteurs

- DeaLeSa
