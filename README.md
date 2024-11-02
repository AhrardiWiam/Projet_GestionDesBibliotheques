# BookSmart : Un système de gestion de bibliothèque intelligent

Ce projet met en œuvre BookSmart, une application web conçue pour gérer efficacement une bibliotheques avec ses fonctionnalités fluides de gestion des collections de livres . Développé avec Spring Boot et Thymeleaf, il permet aux utilisateurs d'ajouter, de modifier, de supprimer et de consulter des informations détaillées sur les livres, y compris les informations sur leurs auteurs.


## Fonctionnalités principales

* *Ajouter des livres :* Créer de nouvelles entrées de livres, en spécifiant le titre, le genre, la date de publication ,la couverture du livre et les auteurs associés.
* *Modifier des livres :* Modifier les informations existantes sur les livres, y compris le titre, le genre, la date de publication ,la couverture et les associations d'auteurs.
* *Supprimer des livres :* Supprimer les livres de la bibliothèque.
* *Afficher les détails des livres :* Accéder à des informations détaillées sur un livre spécifique, y compris son genre, sa date de publication et une liste de ses auteurs avec leurs biographies.
* *Rechercher des livres :* Rechercher des livres par titre à l'aide d'une simple barre de recherche.
* *Gérer les auteurs :* Ajouter de nouveaux auteurs avec leurs biographies, les associer à des livres et gérer les associations d'auteurs.
* *Interface conviviale :* Offre une interface intuitive construite avec Thymeleaf pour une facilité d'utilisation et un attrait visuel.
* *Intégration de la base de données :* Utilise Spring Data JPA pour une interaction transparente avec une base de données MySQL afin de stocker et de gérer les données sur les livres et les auteurs.


## Prise en main

1. *Cloner le référentiel :* git clone [URL du référentiel]
2. *Naviguer vers le répertoire du projet :* cd BookSmart
3. *Configurer la base de données MySQL :*
   - Créer une nouvelle base de données nommée "monprojet".
   - Configurer le fichier application.properties avec vos identifiants de base de données MySQL.
4. *Construire l'application :*
   - Exécuter ./mvnw clean install pour construire le projet et générer le fichier JAR.
5. *Exécuter l'application :*
   - Exécuter ./mvnw spring-boot:run pour démarrer l'application.
6. *Accéder à l'application :*
   - Ouvrir votre navigateur et naviguer vers http://localhost:8080.


## Technologies utilisés

 * *Front-end : HTML, CSS, Thymeleaf, bootstrap ,JavaScript*
 *  *Back-end : Spring-Boot MVC*
 *  *Base de Données : MySql*


## Structure du projet

Le projet est structuré comme suit :

![image](https://github.com/user-attachments/assets/cba09305-e82a-4edf-a9a4-1e5fd1b2908f)

![image](https://github.com/user-attachments/assets/50d9a9f3-2253-4d1a-8e44-302b64a2abce)


- *src/main/java:* Contient le code source Java de l'application.
  - *com.example.monprojet.entities:* Contient les classes d'entité pour les données des livres et des auteurs.
 
    ![image](https://github.com/user-attachments/assets/462d045e-1a9b-4d36-b016-7e6cbd830a55)

  - *com.example.monprojet.controllers:* Contient les classes de contrôleur gérant les requêtes et réponses web.
  - *com.example.monprojet.repositories:* Contient les classes de référentiel pour l'interaction avec la base de données.
  - *com.example.monprojet.services:* Contient les classes de service pour la logique métier et la manipulation des données.
- *src/main/resources:* Contient les fichiers de configuration et les ressources statiques.
  - *application.properties:* Fichier de configuration pour l'application, y compris les paramètres de la base de données.
  - *templates:* Contient les modèles HTML pour les pages web de l'application.
  - *static:* Contient les fichiers CSS et JavaScript pour le style et l'interactivité.

## Améliorations futures
* *Mettre en œuvre une interface aux administrateur qui gerent les bibliotheques et une interface user pour les abonnés d'une bibliotheque. 
* *Mettre en œuvre l'authentification des utilisateurs :* Ajouter des fonctionnalités de connexion et d'inscription des utilisateurs pour un accès sécurisé au système de gestion de bibliothèque.
* *Ajouter d'autres critères de recherche :* Permettre aux utilisateurs de rechercher des livres par genre, auteur ou date de publication.
* *Mettre en œuvre un système de prêt :* Ajouter des fonctionnalités pour suivre les prêts de livres et les notifications de retard.
* *Améliorer l'expérience utilisateur :* Ajouter des fonctionnalités comme le tri, la pagination et le filtrage pour améliorer la navigation et la convivialité.


## Démonstration :


 * *Ajout d'un livre et l'affichage à l'aide de la page de détails:*

https://github.com/user-attachments/assets/dd0301af-32cf-4a9c-b92c-973755b75890


* *Le controle d'erreur (Ajout d'un livre invalide) :*


https://github.com/user-attachments/assets/238a93d5-696e-4787-8d1a-3e30bbd250eb


* *Modifier , supprimer et chercher un livre :*
 

https://github.com/user-attachments/assets/90b0cc98-86af-4d80-a238-80bcd51cf2ff


