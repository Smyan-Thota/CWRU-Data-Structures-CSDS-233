package HW2;


import java.util.LinkedList;
import java.util.Queue;
public class CustomQStack {
  
  Queue<Integer> Q = new LinkedList<Integer>();
  
  public CustomQStack(Queue<Integer> Qinput) {
    Q=Qinput;
  }
  //
  public boolean empty() {
    return Q.isEmpty();
  }
  
//method to reverse queue
  private void reverser()
  {
    // base case
    if (Q.isEmpty()==true) {
      return;
    }
    
    Integer head = Q.peek();
    Q.poll();
    reverser();
    Q.add(head);
  }
  //removing the last element of the stack
  public int pop() {
    if(Q.isEmpty()==true) {
      System.out.println("Empty");
      return -1;
    }
    reverser();
    int output = Q.peek();
    Q.poll();
    reverser();
    return output;
  }
  //push method to inesrt the variables from the top of the stack
  public void push(int input) {
    Q.add(input);
  }
  //helper method to print the contents of the stack
  public void printer() {
    if(Q.isEmpty())
      System.out.println("Empty");
    
    for(int i : Q) {
      System.out.print(i+" ");
    }
    System.out.println(" ");
  }
  //main method to test the working of the code
  public static void main (String[] args) {
    
    //creating a queue with elements
    Queue<Integer> Q = new LinkedList<Integer>();
    Q.add(1);
    Q.add(2);
    Q.add(3);
    Q.add(4);
    
    //creating a custom stack
    CustomQStack S = new CustomQStack(Q);
    
    //checking the pop command
    System.out.println(S.pop());
    System.out.println(S.pop());
    System.out.println(S.pop());
    System.out.println(S.pop());
    //checking to see if the printer recognises that the stack is empty
    System.out.println(S.empty());
    S.printer();
    //checking the push command
    S.push(9);
    S.push(8);
    S.push(7);
    //printing out the contenst after the push command
    S.printer();
    //checking if the pop command works on recently pushed integers
    System.out.println(S.pop());
    //checking to see if the variable has been removed
    S.printer();
    //checking to see if the stack is empty
    System.out.println(S.empty());
    
  }
}
