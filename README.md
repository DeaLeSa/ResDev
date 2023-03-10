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
Dans le fichier `application.properties`, modifiez `spring.jpa.hibernate.ddl-auto=create` en fonction de vos besoins :

:one: `spring.jpa.hibernate.ddl-auto=create`: cette option demande à Hibernate de créer la structure de votre base de données à chaque démarrage de l'application. Cela signifie que toutes les tables, colonnes et contraintes seront supprimées et recréées à chaque fois que l'application est redémarrée. Cette option est souvent utilisée pour les tests de développement ou pour les applications où la structure de la base de données est régulièrement modifiée.

:two: `spring.jpa.hibernate.ddl-auto=create-drop`: cette option demande à Hibernate de créer la structure de votre base de données à chaque démarrage de l'application, mais de la supprimer à la fin de l'exécution. Cela signifie que toutes les tables, colonnes et contraintes seront supprimées lorsque l'application est arrêtée, ce qui peut être utile pour les tests de développement.

:three: `spring.jpa.hibernate.ddl-auto=update`: cette option demande à Hibernate de mettre à jour la structure de votre base de données en fonction des modifications apportées à vos entités. Cela signifie que les nouvelles tables, colonnes et contraintes seront ajoutées à la base de données, tandis que les tables, colonnes et contraintes obsolètes seront supprimées. Cette option est souvent utilisée pour les environnements de production où la structure de la base de données est modifiée de manière régulière et contrôlée.

:four: `spring.jpa.hibernate.ddl-auto=validate`: cette option demande à Hibernate de valider la structure de votre base de données par rapport à vos entités, sans effectuer de modifications. Cela signifie qu'aucune modification ne sera apportée à la base de données, mais que Hibernate vérifiera que la structure de la base de données correspond à vos entités. Cette option est souvent utilisée pour les environnements de production où la structure de la base de données est figée.

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
| EtatController | GET	| /api/v1/etats/all | Récupère tous les états |
| EtatController | GET | /api/v1/etats/{id} | Récupère un état par son ID |
| EtatController | POST | /api/v1/etats/create | Enregistre un nouvel état |

## Contributions

Les contributions sont les bienvenues ! N'hésitez pas à soumettre une pull request ou à ouvrir une issue sur Github.

## Auteurs

- DeaLeSa
