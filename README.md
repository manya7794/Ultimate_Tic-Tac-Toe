# Ultimate Tic-Tac-Toe

## Utilisation

Jeu à lancer dans le terminal en éxécutant le script Powershell nommé *Script_Morpion.ps1* présent dans le dossier __Ultimate Tic-Tac-Toe__.
Une fois en jeu, choisissez le mode de jeu auquel vous voulez jouer __1 joueur__ ou __2 joueurs__.

## Règles du jeu

Les règles du jeu sont les suivantes :

* Le premier joueur choisit la zone de jeu dans laquelle il souhaite jouer
* Il choisit ensuite la case dans laquelle il souhaite jouer
* Une fois que le premier joueur a joué son tour, la main passe au second joueur qui doit jouer dans la zone correspondant à la case jouée par le joueur précédant
* Le jeu se déroule ainsi jusqu'à ce qu'un des joueurs ait complété une ligne, une colonne ou une diagonales avec les zones de jeu
* Une zone de jeu est considérée comme validée quand une ligne, une colonne ou une diagonale de cette zone est complète 
* Si l'un des joueurs remplit une case renvoyant vers une zone déjà remplie ou complète, le joueur qui doit jouer le prochain tour a le droit de choisir sa zone de jeu

## Algorithmes utilisés

Les algorithmes utilisés pour ce jeu sont les algorithmes Minimax et l'élagage alpha-bêta.
