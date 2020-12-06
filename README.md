# PPCLS
## Projet Android I5
- Cahier Jean-Baptiste
- Caro Bastien

### Introduction
Ce projet a pour objectif la création d'une application sous android de pierre feuille ciseaux revisité.
Il a été réalisé sous android en JAVA.


### Authentification & Stockage de données
  L'authentification de notre projet a été réalisé via [Firebase](https://firebase.google.com/) une plateforme de google proposant
  des services tels que la gestion de BDD en NoSQL ou encore de l'authentification. L'implementation de Firebase est relativement simple 
  à effectuer car de nombreux tutoriels existent sur Internet et la documentation meme de Firebase est assez bien réalisé.

### Le Jeu 

Le jeu se présente sous la forme d'un papier feuille ciseaux revisité en "tour par tour".
Avant de pouvoir accéder au jeu il faut pouvoir s'authentifier via le bouton Sign in  ou se créé un compte via le bouton register
Ces deux Activité vont récuperer l'ensemble des infos entrer par l'utilisateur pour soit verifier son existence dans la liste des user existant  soit crée une entrée dans la BDD et crée un utilisateur  pouvant accéder au jeu.

Une fois identifié l'utilisateur a alors le choix d'aller voir le tableau des scores ou de jouer en choissisant également le niveau de difficulté de l'IA
Pour l'interface graphique du jeu en lui meme nous avons Fait au plus simple avec une liste de coup disposer sur le bas de l'écran,  un tableau des scores  et une zone d'action ou le joueur et l'ordinateur devront confronté leurs choix 


### choix des coups
Afin de rendre notre code évolutif nous avons décidé de crée une classe Coup qui sera hérité par tous les coup que nous avons créée ainsi si le jeu doit etre modifié nous aurons juste a crée le nouveau coup et les méthodes de base serait déja disponible. Aussi chaque coup dispose d'une liste de faiblesse, de cette maniere si le coup jouer par l'adversaire est compris dans cette liste le coup est directement battu.

### déroulement d'une partie  & fonctionnement de l'IA 

Apres avoir choisi la difficulté de l'IA est lancer la partie  le jeu commence. le joueur a donc le choix entre pierre, feuille, ciseaux, lézard et spock
le joueur entre son choix en selectionnant l'élément souhaiter et  le valide via un bouton.
A partir de la et en fonction de la difficulté de l'IA 

l'IA fonctionne avec une probabilités pour chaque coup de tomber qui est de base a 0,2. De cette manière si on augmente la difficulté la probabilités de tomber sur un coup qui vaincra le joueur augmente et de la meme maniere si on choisis une difficulté basse  on diminuera la probabilité de tomber sur un coup qui vaincra l'adversaire  en divisant le coefficient difficulté choisi par 10 


Tu peux écrire vite fais l’ia dans le readme, je vais pas avoir le temps
Il faut juste dire que c’est chaque coup a une proba de 0,2 et que si la difficulté est supérieure a deux on multiplie plie la proba par un coeff de la difficulté et sinon on divise la proba par un coeff de la difficulté divisée par 10

