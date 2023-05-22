# PRACTICE 1


### Task text
---

Create the package named by.gsu.pms and define the class, describing business trip expenses of an employee.

Class fields:
 - daily allowance rate in belarusian rubles (the constant) (A),
 - employee account (B),
 - transportation expenses in belarusian rubles (C),
 - number of days (D).

Constructors: 
 - default constructor;
 - general-purpose constructor.

Methods: 
 - getters/setters;
 - getTotal( ) – calculating total business trip expenses (C + A * D);
 - show( ) – printing all fields to the console (each field and the total business trip expenses should be on the separate line in the following format: name=value);
   Example: 
> rate = 25000
> 
> account = Anton Slutsky
> 
> transport = 50000
> days = 5
> total = 175000

 - toString( ) – converting of an object to a string in the csv–format: each field and the total business trip expenses, separated by the ";" symbol.

Example: 

> 25000;Anton Slutsky;50000;5;175000

Define the Runner class in the default package, where:
1. Create an array of 7 objects (the element with index 2 should be empty, i.e. null; the last element of the array should be created by default constructor; other elements should be created by general-purpose constructor).
2. Print the array content to the console, using show( ) method.
3. Change the employee`s transportaion expenses (C) for the last object of the array.
4. Print the duration (D) of two initial business trips by the single operator.
Example: 
Duration = 9
5. Print the array content to the console (one element per line), using toString( ) method implicitly.
6. Find the sum of total expenses
7. Find and print account name employee’s with maximum total expenses

---

### PROGRAM OUTPUT

```
rate = 2,500000 
account = Nilolay Gerasenko 
transport = 25,000000 
days = 10 
total = 50,000000

rate = 2,500000 
account = Alexey Voevoda 
transport = 37,500000 
days = 14 
total = 72,500000

rate = 2,500000 
account = Bladislav Belous 
transport = 15,750000 
days = 7 
total = 33,250000

rate = 2,500000 
account = Ilya Anikeenko 
transport = 51,299999 
days = 5 
total = 63,799999

rate = 2,500000 
account = Kastus Chvalau 
transport = 10,100000 
days = 5 
total = 22,600000

rate = 2,500000 
account = Anton Slutsky 
transport = 5,000000 
days = 5 
total = 17,500000

Duration = 21

2.5;Nilolay Gerasenko;25.0;10;50.0
2.5;Alexey Voevoda;37.5;14;72.5
2.5;Bladislav Belous;15.75;7;33.25
2.5;Ilya Anikeenko;51.3;5;63.8
2.5;Kastus Chvalau;10.1;5;22.6
2.5;Anton Slutsky;53.3;5;65.8

Sum of total expenses: 307,95

Employee with maximum  total expenses: Alexey Voevoda
```
