<h1 align="center">JTuples</h1>

  A Simple Tuple and Named Tuple Library for Java.                                                                                         

## How To Use

To create a basic Tuple you can do the following.
```java
Tuple myTuple = new Tuple("String 1", 123, 99.9f);
```
You can put any amount of any type of value into the constructor, when printed it looks like this.
```java
System.out.println(myTuple);

OUTPUT: ("String 1", 123, 99.9)
```

To create a Named Tuple you first need to create a template which can be done by the following.
```java
NamedTupleTemplate color = new NamedTuple.with("color", "r", "g", "b");
```
You can put any amount of string keys into the constructor (the first argument being the name rather then a key).
Then use the template to create your named tuples like. (Will throw a exception if number of values does not match number of keys from template.
```java
NamedTuple myNamedTuple = new NamedTuple(color, 0, 0, 0);
NamedTuple myNamedTuple1 = new NamedTuple(color, 255, 255, 255);

System.out.println(myNamedTuple);
System.out.println(myNamedTuple1);
```
when printed it looks like this.
```
color(r=0, g=0, b=0)
color(r=255, g=255, b=255)
```

More Information Coming Soon.

## Minimum Java Version

* Java 8
