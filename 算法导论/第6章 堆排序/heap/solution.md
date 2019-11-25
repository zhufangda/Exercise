<!--
 * @Author: ZHU Fangda
 * @Date: 2019-11-15 15:45:29
 * @LastEditTime: 2019-11-15 15:57:23
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit 
 * @FilePath: \heap\solution.md
 -->
# JAVA:

## Donne-nous les méthodes que tu connais de la classe Object.

toString, hashCode, euqals 

## A quoi sert la méthode finalize ? 

## Quel est le contrat entre hashcode et equals ?
       

Si A.equals(B), alors on a A.hashCode() == B.hashCode().
        En revanche, si A.hashCode() == B.hashCode(), A.equals(B) n'est pas toujours vrai. 

## Quelle note sur 10 te donnerais-tu pour ta maitrise du Java ?

7/10 

## Quels sont les types de collections que tu connais ? 
        List, Set, Queue, Map
## Donne-nous des exemples de Lists ? 
ArrayList, Vector, LinkedList 

## Quel est/sont la/les différence(s) entre une LinkedList et une ArrayList ?
      ArrayList est implémenté par un tableau. LinkedList est implémenté par double liste chainé.
      LinkedList a aussi implémenté l'interface Queue. 
## Laquelle est la plus gourmande en terme d'espace mémoire ? Pourquoi ? 

LinkedList. Car ArrayList ne contient que des valeurs. Mais pour chaque noeud de LinkedList, il non seulement enregistre la valeur, mais aussi le référence de prochaine noeud et la référence de dernier noeud.
 
## A quel moment préférer une ArrayList à une LinkedList ? 

Si l'opération d'accès par index est fréquent, je vais utiliser ArrayList. Si l'opération de  suppression ou addition des elements, je vais utiliser LinkedList.

## Dans quel cas la LinkedList est plus efficace en complexité que l’ArrayList ?
      Supprimer des éléments et ajouter des éléments.

## Donne-nous une implémentation d'un Set.

HashSet

## Comment fonctionne le HashSet ?

Quand on initialise une HashSet, une tableau va être créé. Chaque case de ce tableau peut être considé un seau, chaque seau contiens une liste chainée.Quand on ajoute un nouveau element A dans ce Set, il va tout d'abord trouver la seau correspondant par  la valeur A.hashCode, après il va vérifier si ce element a dejà existé dans ce seau en utilisant A.equals(). Si non, ce element va être ajouté au tête de ce liste chaîné. Si la taille de liste chainé est supérieur à 8, il va utiliser red-black tree au lieu de liste chainé.  

## Combien de buckets à l’initialisation d’une hashMap ?
16
 Je ne sais pas. Mais normalement, c'est 2^n

## J'ai 1 million d’élément. Je les place dans un Set et dans une List, laquelle de ces collections me donnera la meilleure performance pour la fonction contains ?

Liste

## Connais-tu des collections thread-safe ? HashTable ?

ConcurrenceMap, Vector, HashTable

## Connais-tu le multithreading ?

oui

## Comment s’utilise le mot-clé synchronize ?

1. ajouter synchronized dans le signature de méthode
2. Utiliser Sychronized block

## Connais-tu d'autres manière de gérer les accès concurrents ?

Semaphore

## Connais-tu les Lock / ReentrantLock ?

Non

## Implémente un Singleton thread-safe. Pourquoi déclarer l’instance « volatile » ?

 ```java
 class MyClass{
 
    private static volatile MyClass instance;
 
    public static MyClass getInstance(T t){
        if(instance ==null){  
            synchronized(this){
                if(instance==null){
                    instance = new MyClass();
                }
            }
        }
        return instance;
    }
 }
```

## Avec cette implémentation (double-check Locking Singleton), est-il possible de se retrouver avec deux instances différente de ce singleton ? 

Ma solution non. 

## Quels Executor Service connais-tu ? 

Ne souviens plus. 

## Un utilisateur de ton application se plaint  lorsqu'il fait une certaine manipulation l'application crash avec une erreur qui indique que la mémoire est saturée. On te demande de trouver la cause de ce problème. Que fais-tu ?

Je ne sais pas.

## Les différences entre Callable et Runnable ? la méthode call() d’un Callable peut lever une exception, laquelle ?

si on espère que le thread retourne un résultat, on utilise callable. Sinon, on utilise Runnable.  

# ALGO : 

## J’ai un tableau et un entier w inférieur à la taille du tableau. Je veux faire la moyenne des w premiers éléments du tableau puis du 2ème au w+1, ainsi de suite jusqu'aux derniers w éléments. Crée un algo pour faire cela. Quel est la complexité de l’algo ? Si la complexité de l’algo est O(nw) comment peux-tu l'optimiser pour voir une complexité linéaire O(n) ?

windows slide:
Voir Solution1.java  

```java
ublic class Solution1{


    public static void main(String[] args) {
            int[] input = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
            // Random random = new Random();
            // int w = 3;

            // for(int i=0;i<100;i++){
            //     input[i] = random.nextInt();
            // }
            int w = 3;
            double[] res = slideAverage(input, w);
            for(double ele: res){
                System.out.printf(" " + ele);
            }
    }

    public static double[] slideAverage(int[] input, int w){
        double[] output = new double[input.length - w+1];
        
        double sum = 0;
        for(int i=0;i<w;i++){
            sum += input[i];
        }
        
        output[0] = sum / w; 
        
        for(int i=1;i<input.length-w+1;i++){
            sum -= input[i-1];
            sum += input[w+i-1];
            output[i] = sum/w;
        }

        return output;
    }

}
```



## Crée un algo qui renvoi l'intersection de deux listes triés de taille n et m ? Quel est la complexité de l’algo ? peux-tu l'optimiser pour voir une complexité linéaire O(n + m) ?

Voir Solution2.java
```java

import java.io.*;
import java.util.*;
import java.util.Arrays;


public class Solution2 {
  public static void main(String[] args) {
    int[] a = {3, 6, 9, 10, 10, 17, 20};
    int[] b = {1, 9, 10, 11, 17, 20, 24, 24, 27};
    
    
    List<Integer> ans = intersection(a,b);
    System.out.println(ans);
    
    
  }
  
  /*
  input1: [3, 6, 9, 10, 10, 17, 20 .... ] 1 Tb
  input2: [1, 9, 10, 11, 17, 20, 24, 24, 27 ...] 2 Tb
  
  => output: 1 Tb
  */
  
  static public List<Integer> intersection(int[] a, int[] b){
      List<Integer> ans = new ArrayList<Integer>();

      int i=0; 
      int j=0;
      while(i<a.length && j<a.length){
        if(a[i]<b[j]){
            i++;
        }else if(a[i]>b[j]){
            j++;
        }else{
            ans.add(a[i]);
            i++;
            j++;
        }

      }


      return ans;
  }

    
}
```
  
** LOGIQUE: **

## On prend deux nombres premiers consécutifs. La moyenne de ces deux nombres peut-elle être un nombre premier ?

Je ne sais pas

## On a une bouteille de 1L. Je bois la moitié, tu bois la moitié de ce qu’il reste, puis je bois la moitié de ce qu’il reste, ainsi de suite jusqu’à finir la bouteille. Quelle quantité est-ce que j’aurai bu et quelle quantité est-ce que tu auras bu ?
   Je prend 2/3*a, tu prend 1/3*a

 ᐧ