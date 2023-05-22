# PRACTICE 2 COMP


### Task text
---
Create the package named by.gsu.pms and define the class, describing a uniform material.

Class fields:
 - name, 
 - density.

Constructors:
 - default constructor;
 - general-purpose constructor.

Methods: 
 - getters/setters;
 - toString( ) – converting of an object to a string in the csv–format: each field, separated by the ";" symbol. 

Example: 
> steel;7850

Define in the same package the class, describing a subject consisting of a uniform material.

Class fields:
 - name, 
 - material,
 - volume.

Constructors: 
 - default constructor;
 - general-purpose constructor.

Methods: 
 - getters/setters;
 - getMass( ) – calculating the subject mass (= density * volume);
 - toString( ) – converting of an object to a string in the csv–format: each field and mass, separated by the ";" symbol. 

Example: 
> wire;steel;7850;0.03;235.5

Define the Runner class in the default package, where:
1. Create the object representing the steel wire having the volume 0.03 cubic me-ter.
2. Print the object content to the console, using toString( ) method.
3. Update the wire material on the copper (density = 8500) and print its mass.
4. Restore the wire material and print it.

---

### PROGRAM OUTPUT

>cube; steel;7850.0; 0.025; 196.25
>
>Subject mass: 212.5
>
>cube; steel;7850.0; 0.025; 196.25
