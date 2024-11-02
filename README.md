## BookSmart : Un système de gestion de bibliothèque intelligent

Ce projet met en œuvre BookSmart, une application web conçue pour gérer efficacement une collection de livres. Développé avec Spring Boot et Thymeleaf, il permet aux utilisateurs d'ajouter, de modifier, de supprimer et de consulter des informations détaillées sur les livres, y compris les informations sur leurs auteurs.

### Fonctionnalités principales

* *Ajouter des livres :* Créer de nouvelles entrées de livres, en spécifiant le titre, le genre, la date de publication et les auteurs associés.
* *Modifier des livres :* Modifier les informations existantes sur les livres, y compris le titre, le genre, la date de publication et les associations d'auteurs.
* *Supprimer des livres :* Supprimer les livres du catalogue de la bibliothèque.
* *Afficher les détails des livres :* Accéder à des informations détaillées sur un livre spécifique, y compris son genre, sa date de publication et une liste de ses auteurs avec leurs biographies.
* *Rechercher des livres :* Rechercher des livres par titre à l'aide d'une simple barre de recherche.
* *Gérer les auteurs :* Ajouter de nouveaux auteurs avec leurs biographies, les associer à des livres et gérer les associations d'auteurs.
* *Interface conviviale :* Offre une interface intuitive construite avec Thymeleaf pour une facilité d'utilisation et un attrait visuel.
* *Intégration de la base de données :* Utilise Spring Data JPA pour une interaction transparente avec une base de données MySQL afin de stocker et de gérer les données sur les livres et les auteurs.

### Prise en main

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

### Structure du projet

Le projet est structuré comme suit :

- *src/main/java:* Contient le code source Java de l'application.
  - *com.example.monprojet.entities:* Contient les classes d'entité pour les données des livres et des auteurs.
  - *com.example.monprojet.controllers:* Contient les classes de contrôleur gérant les requêtes et réponses web.
  - *com.example.monprojet.repositories:* Contient les classes de référentiel pour l'interaction avec la base de données.
  - *com.example.monprojet.services:* Contient les classes de service pour la logique métier et la manipulation des données.
- *src/main/resources:* Contient les fichiers de configuration et les ressources statiques.
  - *application.properties:* Fichier de configuration pour l'application, y compris les paramètres de la base de données.
  - *templates:* Contient les modèles HTML pour les pages web de l'application.
  - *static:* Contient les fichiers CSS et JavaScript pour le style et l'interactivité.

### Améliorations futures

* *Mettre en œuvre l'authentification des utilisateurs :* Ajouter des fonctionnalités de connexion et d'inscription des utilisateurs pour un accès sécurisé au système de gestion de bibliothèque.
* *Ajouter d'autres critères de recherche :* Permettre aux utilisateurs de rechercher des livres par genre, auteur ou date de publication.
* *Mettre en œuvre un système de prêt :* Ajouter des fonctionnalités pour suivre les prêts de livres et les notifications de retard.
* *Intégrer avec des API externes :* Récupérer des informations sur les livres à partir d'API externes comme Google Books ou Open Library pour élargir le catalogue.
* *Améliorer l'expérience utilisateur :* Ajouter des fonctionnalités comme le tri, la pagination et le filtrage pour améliorer la navigation et la convivialité.
