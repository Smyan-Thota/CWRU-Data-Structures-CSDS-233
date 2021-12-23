package HW2;
//class to reverse the linked list
public class SinglyLinkedList{
  //nested class that defines the nodes of a linked list
  public static class Node {

    Object data;//stores the data inside the nodes
    Node next;//stores the pointer to the next node
   
//constructor to define the node
   Node(Object d)
   {
    data = d;//stores the input as the data
    next = null;//points the next node to null
   }
  }
  
  
  //static variable that stores the head of the linked list
public static Node head;


  public void add(Object data) {
  if (head == null) {
   head = new Node(data);
  }
 
  Node temp = new Node(data);
  Node current = head;
 
  if (current != null) {
 
   while (current.next != null) {
    current = current.next;
   }
   current.next=temp;
  }

 }

  
//reverse method to output a reversed linked list
  public Node reverse(Node node)
  {
    
    //creates three nodes that store the node input, its previous and next element
   Node prev = null;
   Node current = node;
   Node next = null;
   
   //the loop keeps continuing until the pointer reaches the end of the list
   while (current != null) {
    
     next = current.next;
    current.next = prev;
    prev = current;
    current = next;
   }
   
   //returns the node that contains the reversed linked list
   node = prev;
   return node;
  }

  // printer method that prints the contents of the list
  void printList(Node node)
  {
   while (node != null) {
    System.out.print(node.data + " ");
    node = node.next;
   }
  }

  // tester main method
  public static void main(String[] args)
  {
   SinglyLinkedList list = new SinglyLinkedList();
   list.head = new Node(85);
   list.head.next = new Node(15);
   list.head.next.next = new Node(4);
   list.head.next.next.next = new Node(20);

   System.out.println("LL Before Reverse");
   list.printList(head);
   head = list.reverse(head);
   System.out.println("");
   System.out.println("LL After Reverse");
   list.printList(head);
  }
 }