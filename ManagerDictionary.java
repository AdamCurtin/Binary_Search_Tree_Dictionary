/*


Purpose: Implements a binary search tree data structure for employee lookup, insertion,
deletion, and traversal operations.
*/

package binarySearchTreeDictionary;

public class ManagerDictionary {
	private class Node {
		    private EmployeeObject employee;
		    private Node left;
		    private Node right;

		    // Constructor
		    public Node(EmployeeObject employee) {
		        this.employee = employee;
		        this.left = null;
		        this.right = null;
		    }

		    // Getters and Setters
		    public EmployeeObject getEmployee() {
		    	return employee;
		    } // end get employee

		    public Node getLeft() {
		    	return left;
		    } // end getLeft
		    
		    public Node getRight() {
		    	return right;
		    } // end getRight
		    
		    public void setEmployee(EmployeeObject employee) {
		    	this.employee = employee;
		    } // end set employee
		    
		    public void setLeft(Node left) {
		    	this.left = left;
		    } // end setLeft
		    
		    public void setRight(Node right) {
		    	this.right = right;
		    } // end setRight
		    
		    @Override
		    public String toString() {
		        return employee.toString();
		    }
		
	} // end node class

	// Begin Methods in Manager Class
	
	
	// Constructor to initialize the dictionary with an empty root node
	
	/* Insert(Employee employee method
	 * Delete(int empIDNumber) method
	 * search(int empIDNumber) method
	 * modify(int empIDNumber) method
	 * preOrder Traversal()
	 * inOrderTraversal()
	 * postOrderTraversal()
	 * User menu options
		
	
	*/
	
} // end ManagerDictionary Class
