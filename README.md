# Greeks for Greeks - JAVA Backend Development Live - 15

This Repository Contains all assignments and notes for JDBL-15
Q1. You are given a Binary Tree where a node of the tree looks like this

class Node{
	Person person;
	Node left;
	Node right;
}

You have to implement a function where you are given the root node, you have to return a hashmap in which the key will be the person object and the value would be no of occurrences of that person in the entire tree
Note : Person 1 = Person 2 (only and only if all the attributes of a person p1 are equal to all the attributes of person p2)

Q2.You are given an array of Persons. You have to do the following operation until you are left with 1 element in the array. In the end, you have to return the minimum sum of all the operation values

The operation to do → Pick any two Person from the array, calculate the sum of their heights and then delete that person and add one person with the newly added height
The sum of two persons’ heights is the operation value