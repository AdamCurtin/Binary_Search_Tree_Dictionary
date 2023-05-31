/*
Programmers: Adam Curtin & Meghan Flaherty
CS 145 Java
Purpose: Implements a binary search tree data structure for employee lookup, insertion,
deletion, and traversal operations.
*/

package adamMeghanBinarySearchTree; 

import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;

public class ACMFManagerDictionary extends ACMFMainDictionary {
    
    private class Node {
        private ACMFEmployeeObject employee;
        private Node left;
        private Node right;

        // Constructor
        public Node(ACMFEmployeeObject employee) {
            this.employee = employee;
            this.left = null;
            this.right = null;
        }

        // Getters and Setters
        public ACMFEmployeeObject getEmployee() {
            return employee;
        } 

        public Node getLeft() {
            return left;
        } 
        
        public Node getRight() {
            return right;
        } 
        
        public void setEmployee(ACMFEmployeeObject employee) {
            this.employee = employee;
        } 
        
        public void setLeft(Node left) {
            this.left = left;
        } 
        
        public void setRight(Node right) {
            this.right = right;
        } 
        
        @Override
        public String toString() {
            return employee.toString();
        }
    } // end node class

        // Set Root node
        Node root;

        // Constructor for initial empty tree
        ACMFManagerDictionary() {
        root = null;
        } 

    // Menu to handle user input
    public void menu() {
  
    Scanner scanner = new Scanner(System.in);
    
        System.out.println("----- Employee Dictionary Menu -----");
        System.out.println("1. Add Employee");
        System.out.println("2. Delete Employee");
        System.out.println("3. View Employees");
        System.out.println("4. Modify Employee");
        System.out.println("5. Find Employee");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
         
        String menuChoice = scanner.nextLine();
         
            switch (menuChoice) {
                 case "1":
                     runAddEmployee();
                     break;
                 case "2":
                     runDeleteEmployee();
                     break;
                 case "3":
                     viewEmployees();
                     break;
                 case "4":
                     runModifyEmployee();
                     break;
                 case "5":
                     runFindEmployee();
                 case "6":
                     System.exit(0);
                     break;
                 default:
                     System.out.println("Invalid choice! Please enter a valid option.");
                     break;
            } // end switch menu choice
            System.out.println();
            scanner.close();	 
        } // end menu

    // method to handle the add employee menu option
    public void runAddEmployee() {
        ACMFEmployeeObject newEmployee = gatherEmployeeInfo();
        if (newEmployee != null) {
            addEmployee(newEmployee);
        } else { 
            System.out.println("Invalid employee information entered.");	
        } 
    } // end runAddEmployee

    // Method to handle the "Delete Employee" menu option
    public void runDeleteEmployee() {
        Scanner scanner = new Scanner(System.in);
    
        // get user ID
        System.out.print("Enter the Employee ID to delete: ");
        int deleteID = Integer.parseInt(scanner.nextLine());
    
        // delete the employee with the specified ID
        deleteEmployee(deleteID);
        scanner.close();
    } // end runDeleteEmployee

    // Method to handle the "Find Employee" menu option
    public void runFindEmployee() {
        Scanner input = new Scanner(System.in);

        // create int for finding correct node with corresponding ID number
        System.out.print("Enter the ID number for the employee you wish to find: ");
        int findID = Integer.parseInt(input.nextLine());

        findEmployee(findID);
    } // end runFindEmployee

    // Method to handle the "Modify Employee" menu option
    public void runModifyEmployee() {
        Scanner scanner = new Scanner(System.in);
    
        // enter ID to modify
        System.out.print("Enter the Employee ID to modify: ");
        int modifyID = Integer.parseInt(scanner.nextLine());
    
        // get info for the new modified employee
        ACMFEmployeeObject modifiedEmployee = gatherEmployeeInfo();
    
        // modify the employee
        modifyEmployee(modifyID, modifiedEmployee);
        scanner.close();
    } // end runModifyEmployee

    // currentNode represents the node being evaluated during the traversal process.
    public void addEmployee(ACMFEmployeeObject employee) {
        // if root is null, create new node and assign as root
        if (root == null) {
            root = new Node(employee);
            System.out.println();
            System.out.println("Employee added successfully!");
            System.out.println();
            menu();
            return;
        } // end if root is null
    
        // if root is not null, initialize currentNode with the root
        Node currentNode = root;
     
        while (true) {
            // if ID of employee is less than current
            if (employee.getNumberID() < currentNode.getEmployee().getNumberID()) {
                if (currentNode.getLeft() == null) {
                    // Add the employee as left child of current node
                    currentNode.setLeft(new Node(employee));
                    System.out.println();
                    System.out.println("Employee added successfully!");
                    System.out.println();
                    menu();
                    return;
                } // end if left is null
                currentNode = currentNode.getLeft(); 
            } 
            else if (employee.getNumberID() > currentNode.getEmployee().getNumberID()) {
                if (currentNode.getRight() == null) {
                    // Add employee as right child of current node
                    currentNode.setRight(new Node(employee));
                    System.out.println();
                    System.out.println("Employee added successfully!");
                    System.out.println();
                    menu();
                    return;
             } // end if right is null
        
            currentNode = currentNode.getRight();
        } else {
            // Employee ID already exists
            System.out.println();
            System.out.println("Employee with the same ID already exists.");
            System.out.println();
            menu();
            return;
        }
     } // end while
    } // end addEmployee method
    
    // Delete an employee from the dictionary
    public void deleteEmployee(int numberID) {
        Scanner in = new Scanner(System.in);
        Node currentNode = root;
        Node parentNode = null;
        boolean isLeftChild = false;

        // find the node to be deleted
        while (currentNode != null) {
            if (numberID < currentNode.getEmployee().getNumberID()) {
                parentNode = currentNode;
                currentNode = currentNode.getLeft();
                isLeftChild = true;
            } else if (numberID > currentNode.getEmployee().getNumberID()) {
                parentNode = currentNode;
                currentNode = currentNode.getRight();
                isLeftChild = false;
         } else {

            System.out.println("This is the contact to be deleted: ");
            System.out.println();
            System.out.println(currentNode.getEmployee().toString());
            System.out.println();
            System.out.println("Are you sure you want to delete this employee contact?");
            System.out.println("y/n");

           
            String delete = in.nextLine();
                
            if (delete.toLowerCase().equals("n")) {
                    menu();
                }
                break;
            }
        }

        // check if the node was found
        if (currentNode == null) {
            System.out.println("Employee with the specified ID not found");
            System.out.println();
            return;
        }

        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            // Case 1: Node to be deleted is a leaf node
            if (currentNode == root) {
                root = null;
                } else if (isLeftChild) {
                parentNode.setLeft(null);
                    } else {
                    parentNode.setRight(null);
            }
        }  
        else if (currentNode.getLeft() == null) {
            // Case 2: Node to be deleted has only a right child
            if (currentNode == root) {
                root = currentNode.getRight();
                } else if (isLeftChild) {
                parentNode.setLeft(currentNode.getRight());
                    } else {
                    parentNode.setRight(currentNode.getRight());
            }
        } 
        else if (currentNode.getRight() == null) {
            // Case 3: Node to be deleted has only a left child
            if (currentNode == root) {
                root = currentNode.getLeft();
                } else if (isLeftChild) {
                parentNode.setLeft(currentNode.getLeft());
                    } else {
                    parentNode.setRight(currentNode.getLeft());
            }
        } else {
        // Case 4: Node to be deleted has both left and right children
        Node successor = findMinimumNode(currentNode.getRight());
        currentNode.setEmployee(successor.getEmployee());
        deleteEmployee(successor.getEmployee().getNumberID());
        }

        System.out.println();
        System.out.println("Employee deleted successfully!");
        System.out.println();
        menu();
    } // end deleteEmployee

    public void findEmployee(int findID) {
        Node currentNode = root;

        while (currentNode != null) {
            if (findID < currentNode.getEmployee().getNumberID()) {
                //Traverse to left child
                currentNode = currentNode.getLeft();
            } else if (findID > currentNode.getEmployee().getNumberID()) {
                // Traverse to right child
                currentNode = currentNode.getRight();
            } else {

                // employee found using ID
                System.out.println();
                System.out.println("Employee found!");
                System.out.println();
                System.out.println(currentNode.getEmployee().toString());
                System.out.println();

                menu();
                return;
            } // end else 
        }
        System.out.println();
        System.out.println("There is no employee matching the input ID number");
        System.out.println("Please try again using an ID number that is currently in use");
        System.out.println();
        menu();

    } // end findEmployee

    // modify an existing employee in the dictionary
    public void modifyEmployee(int NumberID, ACMFEmployeeObject newEmployee) {
        Node currentNode = root;
    
        while (currentNode != null) {
            if (NumberID < currentNode.getEmployee().getNumberID()) {
                //Traverse to left child
                currentNode = currentNode.getLeft();
            } else if (NumberID > currentNode.getEmployee().getNumberID()) {
                // Traverse to right child
                currentNode = currentNode.getRight();
            } else {
                // Employee with Specified ID found
                currentNode.setEmployee(newEmployee);
                System.out.println("Employee modified successfully!");
                System.out.println();
                menu();
                return;
            } // end else
        } // end while current node isn't null
    
        // Employee with the specified ID not found
        System.out.println("Employee with specified ID not found");
        System.out.println();
        menu();
    } // end modifyEmployee

    // deciding traversal order for employee lookup
    public void viewEmployees() {
        Scanner scanner = new Scanner(System.in);
    
        // Prompt user to select order type
        System.out.println();
        System.out.println("Select the order to lookup employees:");
        System.out.println("1. Pre-order");
        System.out.println("2. In-order");
        System.out.println("3. Post-order");
        System.out.print("Enter your choice: ");
        String lookupChoice = scanner.nextLine();
        System.out.println();
    
        // Perform lookup based on choice
        switch (lookupChoice) {
            case "1":
                preOrderTraversal(root);
                break;
            case "2":
                inOrderTraversal(root);
                break;
            case "3":
                postOrderTraversal(root);
                break;
            default:
                System.out.println("Invalid order specified");
                System.out.println();
                break;
        } // end switch lookUpChoice
    
        scanner.close();
    } // end LookUpEmployees

    // Pre-order traversal
    public void preOrderTraversal(Node root) {
        
        // if root is null, return
        if (root == null) {
            return;	
        }
        System.out.println();

        // push root node onto the stack
        Stack<Node> stack = new Stack<>();
        stack.push(root);
    
        // pop node from stack, print details and push right child onto stack, then left child
        // this ensures left child is processed before the right child
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.getEmployee());
            System.out.println();
           
             if (node.getRight() != null) {
                stack.push(node.getRight());
            } 
        
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
                System.out.println(node.getEmployee());
                System.out.println();
            } 
        }
        menu();
    } // end preOrderTraversal

    // In-order Traversal
    public void inOrderTraversal(Node root) {
        // if root is null, return
        if (root == null) {
            return;
        }

        System.out.println();
        // set initial reference point to root node
        Stack<Node> stack = new Stack<>();
        Node currentNode = root;
    
        // while stack isn't empty and current node isn't null
        while (!stack.isEmpty() || currentNode != null) {
            // if current node isn't null, there are nodes to process along the left subtree
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.getLeft();
            } 
                else {
                // once node is null, we are all the way left. Pop, print details, set current to right.
                Node node = stack.pop();
                System.out.println(node.getEmployee());
                System.out.println();
                currentNode = node.getRight();
                }
            }
            menu();
        } // end inOrderTraversal

    // post-order Traversal
    public void postOrderTraversal(Node root) {
        // if root is null, return
        if (root == null) {
            return;
        }
    
        System.out.println();

        // use two stacks. Push root node onto stack1 then in a loop pop node from stack1 and push onto stack2
        // push the left child onto stack1 first, then right child
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
    
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);
        
            if (node.getLeft() != null) {
                stack1.push(node.getLeft());
            }
        
            if (node.getRight() != null) {
                stack1.push(node.getRight());
            }
        }
    
        // After the loop, pop nodes from stack2 and print details
        while (!stack2.isEmpty()) {
            Node node = stack2.pop();
            System.out.println(node.getEmployee());
            System.out.println();
        }
        menu();
    } // end postOrderTraversal

    // Find the minimum node in a subtree
    public Node findMinimumNode(Node node) {
        Node current = node;
    
        // traverse to the leftmost node in the subtree
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        // return the minimum node
        return current;
    } // end findMinimumNode

    // Method to gather user input for employee info and Create Employee Object
    public ACMFEmployeeObject gatherEmployeeInfo() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter Employee ID: ");
            int numberID = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter Street Address: ");
            String streetAddress = scanner.nextLine();

            System.out.print("Enter City: ");
            String city = scanner.nextLine();

            System.out.print("Enter Zip Code: ");
            int zipCode = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            System.out.print("Enter Phone Number: ");
            String phoneNumber = scanner.nextLine();

            // Create and return the EmployeeObject
            return new ACMFEmployeeObject(numberID, firstName, lastName, streetAddress, city,
                                    zipCode, email, phoneNumber);
        } catch (NumberFormatException e) {
        System.out.println();
        System.out.println("Invalid input format for ID or Zip Code. Please enter numeric values.");
        System.out.println();
        menu();
        }
        return null;
    } // end gatherEmployeeInfo

    // method for art cover
    public void artThing() {

        System.out.println(" _____   __   ___ ___   __   ______   __  __");
        System.out.println("|  _  ) (  ) |   )  |  / _\\  |  _  \\ (  \\/  )");
        System.out.println("|  _ (  |  | |      | /    \\ |     /  )    /");
        System.out.println("|_____) (__) |__)___|/__/\\__\\|__\\__)  (___/");
        System.out.println();
        System.out.println(" _____  _____    __    ____   ____   _   _ ");
        System.out.println("/  ___) | ___)  /_ \\  |  _ \\ /  __) | |_| | ");
        System.out.println("\\___  \\ |  _)  /    \\ |    /(  (__  |  _  | ");
        System.out.println("(_____/ |____)/__/\\__\\|_\\__\\ \\____) |_| |_|");
        System.out.println();
        System.out.println("        _____   ____   _____   _____ ");
        System.out.println("       (_   _) |  _ \\ |  ___) |  ___) ");
        System.out.println("         ) (   |    / |   _)  |   _)   ");
        System.out.println("        (___)  |_\\__\\ |_____) |_____) ");
        System.out.println();
        menu();
    } // end artThing method
} // end ManagerDictionary Class