// This could be encapsulated in the Manager Class 

/*


Purpose: Represents a node in the binary search tree, containing Employee object
and references to its left and right child nodes.
*/

package binarySearchTreeDictionary;

public class NodeContainingEmployee {

	private EmployeeObject employee;
	private NodeContainingEmployee left;
	private NodeContainingEmployee right;
	
	// Constructor
	public NodeContainingEmployee(EmployeeObject emplooyee) {
		this.employee = employee;
		this.left = null;
		this.right = null;
	}
	// Getters and Setters
    public EmployeeObject getEmployee() {
    	return employee;
    } // end get employee

    public NodeContainingEmployee getLeft() {
    	return left;
    } // end getLeft
    
    public NodeContainingEmployee getRight() {
    	return right;
    } // end getRight
    
    public void setEmployee(EmployeeObject employee) {
    	this.employee = employee;
    } // end set employee
    
    public void setLeft(NodeContainingEmployee left) {
    	this.left = left;
    } // end setLeft
    
    public void setRight(NodeContainingEmployee right) {
    	this.right = right;
    } // end setRight
    
    @Override
    public String toString() {
        return employee.toString();
    }
}
