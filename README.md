# Le Jeu Du Pendu

### 1. Objectif du programme

Ce programme Java, implémente le jeu classique du Pendu où l'utilisateur doit deviner un mot secret en proposant des lettres une par une, avec un maximum de 10 erreurs autorisées.

### 2. Fonctionnalités

- Sélection aléatoire d'un mot parmi une liste prédéfinie
- Gestion des erreurs (maximum 10 tentatives incorrectes)
- Affichage en temps réel
    * Mot partiellement découvert (avec tirets)
    * Lettres incorrectes déjà proposées
    * Compteurs d'erreurs

- Validation des saisies
    * Vérification des lettres uniques
    * Conversion automatique en minuscules
    * Détection des lettres déjà proposées


### 3. Structure du code

- Variables principales

    * ```words[]``` : Liste des mots disponibles
    * ```secretWord``` : Mot à deviner (choisi aléatoirement)
    * ```foundLetters``` : Tableau des lettres correctes découvertes
    * ```incorrectLetters``` : Tableau des lettres incorrectes proposées
    * ```errors``` : Compteur d'erreurs (0 a 10)

- Logique du jeu

    * Initialisation : choix aléatoire du mot et préparation des tableaux
    * Boucle principale : répète le jeu jusqu'à victoire ou défaite
    * Saisie utilisateur : lecture et validation de la lettre proposée
    * Vérification : comparaison avec le mot secret
    * Mise à jour : affichage et gestion de l'état du jeu


### 4. Exécution

```bash

javac Hangman.java

java Hangman
```


