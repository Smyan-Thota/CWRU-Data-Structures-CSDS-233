package HW2;

import java.util.*;
public class CustomSQueue {
  //creating two stacks 
  Stack<Integer> a = new Stack<Integer>();
  Stack<Integer> b = new Stack<Integer>();
  //creating the constructor for the input stack
  public CustomSQueue(Stack<Integer> ainput) {
    a = ainput;
  }
  //add method to add integers to the queue
  public void add(int input) {
    while(a.isEmpty()==false) {
      b.push(a.pop());
    }
    a.push(input);
    while(b.isEmpty()==false) {
      a.push(b.pop());
    }
  }
  //poll method that removes integers from queue
  public int poll() {
    if(a.isEmpty()==true)
    { System.out.println("Queue empty");
    return -1;
    }
    int i = a.peek();
    a.pop();
    return i;
  }
  //helper method to print the contents of the queue
  public void printer() {
    if(a.isEmpty())
    {System.out.println("empty");
      return;
    }
    int i = a.peek();
    a.pop();
    printer();
    System.out.print(i + " ");
    a.push(i);
  }
  //main method to run the methods and test the working
  public static void main(String[] args) {
    //creating a stack to test
    Stack<Integer> test = new Stack<Integer>();
    test.push(1);
    test.push(2);
    test.push(3);
    test.push(4);
    //creating a custom queue using the stack
    CustomSQueue d = new CustomSQueue(test);
    //testing the poll function by removing every element in the stack
    System.out.println(d.poll());
    System.out.println(d.poll());
    System.out.println(d.poll());
    System.out.println(d.poll());
    //checks to see if the poll function removes any elements in an empty queue
    d.poll();
    //checks to see if the printer prints any elements in an empty queue
    d.printer();
    //testing the add method
    d.add(5);
    d.add(6);
    d.add(7);
    //printing out the contents of the queue to see if the print function works
    d.printer();
    System.out.println(" ");
    //testing poll on recently added integers
    System.out.println("poll output : "+ d.poll());
    //printing out the final resulting queue
    d.printer();
    
    
  }
}
