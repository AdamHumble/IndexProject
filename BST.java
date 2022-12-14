/*
import any necessary classes
*/
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
* <H1>Binary Search Tree</H1>
*  
* The Binary Search Tree (BST) is a data structure in which the left subtree only 
* contains nodes with keys lesser than it's parent, and the right subtree only
* contains nodes with keys greater than it's parent. 
*
* INPUT: Data to be added to each node of the tree
* PROCESSING: adding and removing nodes from a tree
* OUTPUT: Binary search tree data structure
*
* @author  Adam Humble
* @version 1.8  
* 
* This is today's date
* @since   2022-11-23 
*/
public class BST<T extends Comparable<T>> {

  private Node<T> root;
  private int size = 0;
  //public BST<T> lineNumbers;
  
  public void add(T data) {
    root = add(data, root);
  }

  /** 
  Method name: add()
  This method will add data and nodes to the BST

  Pseudocode:
  1. If tree is empty (no root), create a node holding key t as root, done.
  2. Set CurrNode = RootNode.
  3. If t == CurrNode.key, done.
  4. If t < CurrNode.key
      If CurrNode.left == NULL, create a node holding t as left child of CurrNode, done.
      Else set CurrNode = CurrNode.left, go back to 3.
  5. Else
      If CurrNode.right == NULL, create a node holding t as left child of CurrNode, done.
      Else set CurrNode = CurrNode.right, go back to 3.

  @param  data  A generic representing the data in the node being added
  @param  node  A node representing the position in the tree

  @return node representing the position in the tree
  */
  private Node<T> add(T data, Node<T> node) {
    if(node != null) {
      if(data == null) {
        node.right = add(data, node.right);
      }
      else {
        if(node.getData() == null) {
          node = new Node<T>(data);
          node.right = add(null, node.right);
        }
        if(data.compareTo(node.data) < 0) {
          node.left = add(data, node.left);
        }
        if(data.compareTo(node.data) > 0) {
          node.right = add(data, node.right);
        }
      }
    }
    else {
      node = new Node<T>(data);
      size++;
    }
    return node;
  }
  
  /** 
  Method name: addAll()
  This method will add the tree data to a collection

  @param  c  A generic representing the data being added to the collection

  */
  public void addAll(Collection<? extends T> c) {
    for(T data : c) {
      add(data);
    }
  }

  /** 
  Method name: remove()
  This method will remove data from the tree containing the specified key

  @param  data  A generic representing the data being removed

  @return null the data has been removed and will make the node null
  */
  public T remove(T data) {
    boolean b = false;
    if(contains(data)) {
      b = true;
    }
    root = remove(root, data);
    if(b) {
      return data;
    }
    return null;
  }

  /** 
  Method name: remove()
  This method will remove a node and its data from the tree

  @param  data  A generic representing the data in the node being removed
  @param  here  A node representing the position in the tree

  @return here representing the position in the tree
  */
  private Node<T> remove(Node<T> here, T data) {
    if (here != null) {
      if(data == null) {
        here.right = remove(here.right, data);
        if(here.getData() == null) {
          here = removeNode(here);
        }
      }
      else {
        if (data.compareTo(here.getData()) < 0) {
          here.left = remove(here.left, data);
        }
        else if (data.compareTo(here.getData()) > 0) {
          here.right = remove(here.right, data);
        }
        else {
          here = removeNode(here);
        }
      }
    }
    return here;
  }

  /** 
  Method name: removeNode()
  This method will remove a node from the tree

  @param  here  A node representing the position in the tree

  @return here representing the position in the tree
  */
  private Node<T> removeNode(Node<T> here) {
    if (here.left == null)
      here = here.right;
    else if (here.right == null)
      here = here.left;
    else {
      Node<T> big = here.left;
      Node<T> last = null;
      while (big.right != null) {
        last = big;
        big = big.right;
      }
      here.data = big.data;
      if (last == null) {
        here.left = big.left;
      }
      else {
        last.right = big.left;
      }
    }
    return here;
  }

  /** 
  Method name: contains()
  This method will return the contents of a specific root key

  @param  data  A generic representing the data in the node

  @return false if the tree is empty
  @return find(data, root) to return the contents of the tree root
  */
  public boolean contains(T data) {
    if (root == null) {
      return false;
    }
    else {
      return find(data, root);
    }
  }
  /** 
  Method name: find()
  This method will work through the BST searching for a specified key

  Pseudocode:
  1. If tree is empty (no root), return FALSE.
  2. Set CurrNode = RootNode.
  3. If t == CurrNode.key, return TRUE.
  4. If t < CurrNode.key
      If CurrNode.left == NULL, return FALSE.
      Else set CurrNode = CurrNode.left, go back to 3.
  5. Else
      If CurrNode.right == NULL, return FALSE.
      Else set CurrNode = CurrNode.right, go back to 3.

  @param  data  A generic representing the data in the node being added
  @param  node  A node representing the position in the tree

  @return boolean will return true if key is found, otherwise false
  */
  public boolean find(T data, Node<T> node) {
    if (data != null) {
      if (data.compareTo(node.getData()) == 0) {
        return true;
      }
      else {
        if (data.compareTo(node.getData()) < 0) {
          if(node.left == null) {
            return false;
          }
          else {
            return find(data, node.left);
          }
        }
        else if(data.compareTo(node.getData()) > 0) {
          if(node.right == null) {
            return false;
          }
          else {
            return find(data, node.right);
          }
        }
      }
    }
    else {
      Node<T> max = root;
      while(max != null) {
        if(max.getData() == null) {
          return true;
        }
        max = max.right;
      }
    }
    return false;
  }

  /*
  Method name: preOrder()
  This method is a constructor for the preOrder method

  @return list the data from each node of the tree
  */
  public List<T> preOrder() {
    List<T> list = new ArrayList<T>();
    preOrder(root, list);
    return list;
  }

  /*
  Method name: preOrder()
  This method will traverse the tree starting at the root, to the left
  subtree then to the right subtree

  @param node a generic object for the nodes of the tree
  @param list a generic object for the data within the nodes of the tree
  */
  public void preOrder(Node<T> node, List<T> list) {
    if (node != null) {
      list.add(node.getData());
      preOrder(node.left, list);
      preOrder(node.right, list);
    }
  }

  /*
  Method name: inOrder()
  This method is a constructor for the inOrder method

  @return list the data from each node of the tree
  */
  public List<T> inOrder() {
    List<T> list = new ArrayList<T>();
    inOrder(root, list);
    return list;
  }

  /*
  Method name: inOrder()
  This method will traverse the tree starting at the left subtree to the
  root, then to the right subtree

  @param node a generic object for the nodes of the tree
  @param list a generic object for the data within the nodes of the tree
  */
  public void inOrder(Node<T> node, List<T> list) {
    if(node != null) {
      inOrder(node.left, list);
      list.add(node.getData());
      System.out.printf("%-15s \n", node.data); //print each node as a list
      inOrder(node.right, list);
    }
  }

  /*
  Method name: postOrder()
  This method is a constructor for the postOrder method

  @return list the data from each node of the tree
  */
  public List<T> postOrder() {
    List<T> list = new ArrayList<T>();
    postOrder(root, list);
    return list;
  }

  /*
  Method name: postOrder()
  This method will traverse the tree starting at the left subtree to the
  right subtree, then to the root

  @param node a generic object for the nodes of the tree
  @param list a generic object for the data within the nodes of the tree
  */
  public void postOrder(Node<T> node, List<T> list) {
    if(node != null) {
      postOrder(node.left, list);
      postOrder(node.right, list);
      list.add(node.getData());
    }
  }

  /*
  Method name: isEmpty()
  This method will check to see if the BST is empty

  @return root if the BST is empty or not
  */
  public boolean isEmpty() {
    return root == null;
  }

  /*
  Method name: clear()
  This method is used to make the root null, to clear a tree
  */
  public void clear() {
    root = null;
  }

  /**
  * <H1>Node Class</H1>
  *  
  * The Node Class defines constructors so that they can be applied in the BST class
  *
  * INPUT: Provides a set of constructors for BST class, therefore no input
  * PROCESSING: Uses constructors to help the BST class define the nodes
  * OUTPUT: There is no output
  *
  */
  public static class Node<A extends Comparable<A>> {
    private A data;
    private Node<A> left, right;

    /*
    Method name: Node()
    This method use the setData method to describe data on a node

    @param data a generic which will specify data for a node
    */
    public Node(A data) {
      setData(data);
    }

    /*
    Method name: getData()
    This method is a constructor to see if data is on a node

    @return data an object that will return data if found
    */
    public A getData() {
      return data;
    }

    /*
    Method name: setData()
    This method define the data to be used

    @param data a generic which will specify data for a node
    */
    public void setData(A data) {
      this.data = data;
    }

    /*
    Method name: getLeft()
    This method will look for the left node

    @return left returns the left node
    */
    public Node<A> getLeft() {
      return left;
    }

    /*
    Method name: setLeft()
    This method will make a particular node the left node

    @param left a node to be made the left
    */
    public void setLeft(Node<A> left) {
      this.left = left;
    }
    
    /*
    Method name: getRight()
    This method will look for the right node

    @return right returns the right node
    */
    public Node<A> getRight() {
      return right;
    }

    /*
    Method name: setRight()
    This method will make a particular node the right node

    @param right a node to be made the right
    */
    public void setRight(Node<A> right) {
      this.right = right;
    }
  }
}