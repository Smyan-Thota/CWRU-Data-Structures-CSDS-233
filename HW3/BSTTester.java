import junit.framework.TestCase;

/** A JUnit test case class.
  * Every method starting with the word "test" will be called when running
  * the test with JUnit.
  */
public class BSTTester extends TestCase {

  public void test() {
    // Creating the object of BinarySearchTree class
        BinarySearchTree bst = new BinarySearchTree();
        // call the method insert
        bst.insert(15);
        bst.insert(10);
        bst.insert(20);
        bst.insert(8);
        bst.insert(12);    
        bst.insert(16);
        //testing sum
        assertEquals(bst.sum(bst.returnroot()),81);
        //testing kth smallest
        assertEquals((bst.kthSmallest(bst.returnroot(),2)).getData(),10);  
        //testing delete
        bst.delete(bst.returnroot(),16);
        
        //decrease in sum due to deletion of 16, hence the decrease by 16
        assertEquals(bst.sum(bst.returnroot()),65);
        
        // rest could not be tested since they were print statemets and the methods are of void type as specified by the assignment!
  }
  
}
