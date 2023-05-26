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
	// Set Root node
	Node root;
	
	// Constructor for initial empty tree
	ManagerDictionary() {
		root = null;
	} 
	
	// currentNode represents the node being evaluated during the traversal process.
	public void addEmployee(EmployeeObject employee) {
		// if root is null, create new node and assign as root
		if (root == null) {
			root = new Node(employee);
			System.out.println("Employee added successfully!");
			return;
		} // end if root is null
		
		// if root is not null, initialize currentNode with the root
		Node currentNode = root;
		
		// 
		while (true) {
			// if ID of employee is less than current
			if (employee.getNumberID() < currentNode.getEmployee().getNumberID()) {
				if (currentNode.getLeft() == null) {
					currentNode.setLeft(new Node(employee));
					System.out.println("Employee added successfully!");
					return;
				} // end if left is null
				currentNode = currentNode.getLeft();

			} else if (employee.getNumberID() > currentNode.getEmployee().getNumberID()) {
				if (currentNode.getRight() == null) {
					currentNode.setRight(new Node(employee));
					System.out.println("Employee added successfully!");
					return;
				} // end if right is null
			
			currentNode = currentNode.getRight();
		} else {
			System.out.println("Employee with the same ID already exists.");
			return;
		}
		} // end while
	
	} // end addEmployee method
		
	// delete an employee node from tree
	
	
	
	 // Find the minimum node in a subtree
    private Node findMinimumNode(Node node) {
        Node current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }
	
	// search for employee 
	
	// modify an existing employee in the dictionary
	public void modifyEmployee(int NumberID, EmployeeObject newEmployee) {
		Node currentNode = root;
		
		
		while (currentNode != null) {
			if (NumberID < currentNode.getEmployee().getNumberID()) {
				currentNode = currentNode.getLeft();
			} else if (NumberID > currentNode.getEmployee().getNumberID()) {
				currentNode = currentNode.getRight();
			} else {
				// Employee with Specified ID found
				currentNode.setEmployee(newEmployee);
				System.out.println("Employee modified successfully!");
				return;
			} // end else
		} // end while current node isn't null
		// Employee with the specified ID not found
		System.out.println("Employee with specified ID not found");
	} // end modifyEmployee
	
	
	// Constructor to initialize the dictionary with an empty root node
	
	/* Insert(Employee employee method // Adam
	 * Delete(int empIDNumber) method // Meghan
	 * search(int empIDNumber) method // Meghan
	 * modify(int empIDNumber) method // Adam
	 * preOrderTraversal()
	 * while(current!= null)
	 * inOrderTraversal()
	 * postOrderTraversal()
	 * User menu options
		
	
	*/
	
} // end ManagerDictionary Class
