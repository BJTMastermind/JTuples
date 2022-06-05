<h1 align="center">JTuples</h1>

  A Simple Tuple and Named Tuple Library for Java.                                                                                         

## How To Use

To create a basic Tuple you can do the following.
```java
Tuple myTuple = new Tuple("String 1", 123, 99.9f);
```
You can put any amount of any type of value into the contrutor, when printed it looks like this.
```java
System.out.println(myTuple);

OUTPUT: ("String 1", 123, 99.9)
```

To create a Named Tuple you can do the following.
```java
NamedTuple myNamedTuple = new NamedTuple.with("color", "r", 255).end();
```
You can put any amount of any type of value into the with method (the first one taking a name also), they can also be chained infitly and end it with the end method.
```java
NamedTuple myNamedTuple = new NamedTuple.with("color", "r", 255).with("g", 255).with("b", 255).end();
```
when printed it looks like this.
```java
System.out.println(myNamedTuple);

OUTPUT: color(r=255, g=255, b=255)
```

More Information Coming Soon.

## Minimum Java Version

* Java 8
