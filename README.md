# PRACTICE_2_INH TASK 1

### Text task

---

Create the package named by.gsu.pms for the superclass and subclasses.

Define the superclass, describing the commodity purchase.

Superclass fields:
 - commodity name,
 - price in belarusian rubles, 
 - number of purchased units.

Constructors: 
 - default constructor,
 - general-purpose constructor.

Methods: 
 - getters/setters;
 - getCost( ) – calculating the purchase cost;
 - toString( ) – converting of an object to a string in the following format: each field and the purchase cost, separated by the ";" symbol);
 - equals( ) – comparing of purchases (equal if name and price are the same). 

Define the first subclass for the purchase with a price discount and override necessary methods. 

Define the second subclass for the purchase with a discount to be presented if the number of purchased units is greater than the given subclass constant. A discount rate is given by the percent from the purchase cost. Override necessary methods.

File src\in.txt consists of 6 lines with correct data. Every line contains needed data separated by spaces for 1 object of the superclass or the first subclass or the second one. Every line begins with some identifier of the purchase class, then other data follow. 

The line example for the superclass object: 

```
GENERAL_PURCHASE   Milk   2500    3
```

Define the Runner class in the default package, where:
1. Create an array for 6 objects.
2. Input data from the given file into array.
3. Print the array content to the console (one element per line).
4. Print the maximum cost purchase.
5. Determine whether all purchases are equal.
Realize subtasks 2–5 by the single cycle.

---

#### INPUT FILE

```
GENERAL_PURCHASE Milk 2500 3
DISCOUNT_PURCHASE Bread 1500 5 200
QUANTITY_DISCOUNT_PURCHASE Apple 1000 10 10
GENERAL_PURCHASE Eggs 2000 4
QUANTITY_DISCOUNT_PURCHASE Cheese 3000 20 5.825
DISCOUNT_PURCHASE Juice 5000 2 1000
```

#### OUTPUT

```
Milk;2500.0;3;7500.0
Bread;1500.0;5;6500.0
Apple;1000.0;10;10000.0
Eggs;2000.0;4;8000.0
Cheese;3000.0;20;56505.0
Juice;5000.0;2;8000.0
Maximum cost purchase:
Cheese;3000.0;20;56505.0
Are all purchases equal? false
```
