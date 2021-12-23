public class BinarySearchTree {
  
  public class Node{
    
    private int data;
    private Node left;
    private Node right;
    
    public Node (int data) {
      this.setLeft(null);
      this.setRight(null);
      this.setData(data);
    }
    
    public int getData() {
      return data;
    }
    
    public void setData(int data) {
      this.data = data;
    }
    
    public Node getLeft() {
      return left;
    }
    
    public void setLeft(Node left) {
      this.left = left;
    }
    
    public Node getRight() {
      return right;
    }
    
    public void setRight(Node right) {
      this.right = right;
    }
    
  }//end of node
  
  public static Node root;
  int counter=0;
  
  public BinarySearchTree() {
    this.root = null;
  }
  
  // insert method to insert the new Date
    public void insert(int newData) {
        this.root = insert(root, newData);
    }

    public Node insert(Node root, int input) {
        // Base Case
        if (root == null) {
            root = new Node(input);
            return root;
        }
        else if (root.data >= input) {
            // if current root data is greater than the new data then now process the left sub-tree
            root.left = insert(root.left, input);
        } else {
            // if current root data is less than the new data then now process the right sub-tree
            root.right = insert(root.right, input);
        }
        return root;
    }
  
  
  public void inOrder() {
     inOrder(root);
     System.out.println();
    }  
   
   private void inOrder(Node node) {
     if (node == null) {
       return;
     }   
     inOrder(node.getLeft());
     System.out.printf("%s ", node.getData());
     inOrder(node.getRight());
   }  
  public Node kthSmallest(Node root, int k) {
    counter=0;
    Node helper = kthSmallestHelper(root,k);
    return helper;
  }
  
  public Node kthSmallestHelper(Node root, int k) {
    if(root==null)
      return null;
    
    Node left = kthSmallestHelper(root.getLeft(), k);
    
    if(left!=null)
      return left;
    counter++;
    if(counter==k)
      return root;
    
    return kthSmallestHelper(root.getRight(), k); 
  }
  
  
  public Node delete(Node root, int key) {
    
    //empty tree
    if(root == null)
      return root;
    //going down the tree
    if(key<root.getData())
      root.setLeft(delete(root.getLeft(), key));
    else if(key>root.getData())
      root.setRight(delete(root.getRight(), key));
    //key same as roots
    else {
      //only one child
      if(root.getLeft()==null)
        return root.getRight();
      else if(root.getRight()==null)
        return root.getLeft();
      
      //two children
      root.setData(min(root.getRight()));
      root.setRight(delete(root.getRight(), root.getData()));
    }
    return root;
  }
  
  public int min(Node root) {
    int min = root.getData();
    while(root.getLeft()!=null)
    {
      min = root.getLeft().getData();
      root=root.getLeft(); 
    }
    return min;
  }
  
  public int sum(Node root) {
    if(root == null)
      return 0;
    return (root.getData()+sum(root.getLeft())+sum(root.getRight()));
  }
  
  public Node search(Node root, int key) {
    
    if(root==null||root.getData()==key)
      return root;
    if(root.getData()<key)
      return search(root.getRight(),key);
    
    return search(root.getLeft(),key);
  }
  
  public Node returnroot(){
  return root;
  }
  
  public int printer(){
    return root.getData();
  }

    public static void main(String[] args) {
        // Creating the object of BinarySearchTree class
        BinarySearchTree bst = new BinarySearchTree();
        // call the method insert
        bst.insert(15);
        bst.insert(10);
        bst.insert(20);
        bst.insert(8);
        bst.insert(12);    
        bst.insert(16);
        bst.insert(25);
        System.out.println("inordered tree must return 8,10,12,15,16,20,25");
        System.out.println("output from inorder is : ");
        bst.inOrder();
  }
    }
