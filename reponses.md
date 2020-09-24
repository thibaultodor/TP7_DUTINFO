 ##  Partie 2
 #### Exercice 2
 ##### Question 2
 
Lorsque l'on utilise une Arraylist on remarque que le temps pour ajouter un élément est de plus en plus long plus la taille de la liste est longue.

La où lorsque l'on utilise une LinkedList le temps d'ajout est beaucoup plus court.

Dans notre cas c'est une solution beaucoup plus approprié car l'on souhaite ajouter des éléments à notre liste.

Par contre il faut faire attention à une chose avec les LinkedList, le temps d'accés à un élément qui lui par contre peut augmenter grandement selon la taille de la liste car on est obligé de la parcourir en totalité.

Ce probleme n'est pas présent avec l'Arraylist.

En gros : 

 ##### Question 3
 
 Comme nous venons de le voir pour le cas de la variable `dejasVus` à qui on lui ajoute souvent des données il serait plus approprié d'utiliser une LinkedList car elle permet des temps d'ajout beaucoup plus rapide contrairement à l'ArrayList.
 
 Mais vus que l'on doit aussi accéder aux donnés il faut trouver autre chose.
 
 La solution : le **hashSet()** qui permet un temps d'accés et d'ajout beaucoup plus rapide et aussi qui permet naturellement d'éviter les doublons. Parfait pour `dejasVus`.
 
  ##### Question 4
  
  En utilisant le hashSet on peut résoudre en moins de 10 secondes un taquin qui de base prenait plusieurs minutes à être résolu.
  
1 4 5<br/>
0 2 3<br/>
6 8 7
  
  Ce taquin ci dessus mettait plusieurs minutes sans hashset et mais maintenant **9 secondes** à être résolu.