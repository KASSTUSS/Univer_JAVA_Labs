# PRACTICE_INH TASK 2

### Text task

Create the package named by.gsu.pms for the entities classes.
Define the class Commodity, describing the commodity.
Superclass fields:
 - commodity name,
 - price in belarusian rubles. 

Constructors: 
 - default constructor,
 - general-purpose constructor.

Methods: 
 - getters/setters;
 - toString( ) – converting of an object to a string in the csv–format: each field and the purchase cost, separated by the ";" symbol.

Define the superclass AbstaractPurchase, describing the commodity purchase and implementing interface Comparable<AbstaractPurchase>.

Superclass fields:
 - commodity,
 - number of purchased units.
 
Constructors: 
 - default constructor,
 - general-purpose constructor.

Methods: 
 - getters/setters;
 - getCost( ) – calculating the purchase cost;
 - toString( ) – converting of an object to a string in the csv–format: each field and the purchase cost, separated by the ";" symbol.
 - compareTo(AbstaractPurchase purchase) – comparing purchases by the cost decreasing. 

Define the first subclass for the purchase with a price discount and override necessary methods. 

Define the second subclass for the purchase with a percent discount and override necessary methods.

Define the third subclass for the purchase with an addition for transport expenses and override necessary methods.

Define the Runner class in the default package, where:
1. Create unique commodity for purchasing.
2. Create an array for 6 objects (2 – of every subclass).
3. Print the array content to the console (one element per line).
4. Sort an array on the cost decreasing by the method sort( ) of the class Arrays.
5. Print the array content to the console (one element per line).
6. Print purchase with minimum cost.
7. Perform an additional task.

---
  
#### OUTPUT
  
```
Array content before sorting:
Unique Commodity;100.0;2;160.0
Unique Commodity;100.0;3;255.0
Unique Commodity;100.0;5;450.0
Unique Commodity;100.0;4;368.0
Unique Commodity;100.0;6;650.0
Unique Commodity;100.0;7;760.0
Array content after sorting:
Unique Commodity;100.0;7;760.0
Unique Commodity;100.0;6;650.0
Unique Commodity;100.0;5;450.0
Unique Commodity;100.0;4;368.0
Unique Commodity;100.0;3;255.0
Unique Commodity;100.0;2;160.0
Purchase with minimum cost:
Unique Commodity;100.0;2;160.0
Performing additional task...
```
