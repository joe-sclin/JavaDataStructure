# Demonstration of implementing Java Data Structures 

* Data structure and OOP are foundation of programming, implementing data structure from scratch (not from java.util) is a good practice of basic skills
* Class BasicNode is abstract class for data structures
  * 3 attributes: content, predecessor and successor
  * 3 abstract functions to get each attributes
* Class SimpleNode extended BasicNode and implemented abstract functions
* Class LinearContainer contains inner class SequentialNode to implement abstract class BasicNode
* Each data structure inherited BasicNode / SimpleNode for its own implementation by overriding

##  Four essential components for Object oriented programming (OOP) in Java
* Encapsulation shown in class BasicNode
  * All three attributes are set protected --> can only access and modify via public functions
* Polymorphism shown in class SimpleNode
  * Constructors were implemented with or without input for different purposes
* Inheritance shown in class for each data structure
  * Example: DoublyLinkedList extends SimpleNode and SimpleNode extends BasicNode
* Abstraction
  * BasicNode is an abstract class only containing attributes and functions without implementation

## Additional demonstration: Recursive function in Data Structure Tree
* Function RemoveNode and printTree were recursive to traverse nodes and their child nodes 

## Data structures
- [X] Linked list
- [X] Stack
- [X] Queue
- [X] Graph (Directed and Undirected graph)
- [X] Tree