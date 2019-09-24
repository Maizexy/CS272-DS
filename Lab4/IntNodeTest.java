/* @author: Yuxi Wang
 * Course: CS272
 * Due: 09232019 */
public class IntNodeTest {
	public static void main (String[] args) {
		IntNode n1 = new IntNode();
		// set
		n1.setData(10);
		
		// add a node after the last node, and test get method
		n1.addNodeAfterThis(20);
		n1.getLink().addNodeAfterThis(30);
		
		// toString
		System.out.print("Linked list starting with n1: ");
		n1.toString();
		
		// add a node after the fist node
		n1.addNodeAfterThis(15);
		System.out.print("Add node (data 15) after the first node: ");
		n1.toString();

		// length
		System.out.println( "The length of the list starting with n1 is " + IntNode.listLength(n1) );

		// remove the node after the fist node
		n1.removeNodeAfterThis();
		System.out.print("After removed the second node: ");
		n1.toString();
		
		// search whether the list contains data 30.
		if(IntNode.search(n1, 30)) {
			System.out.println("The list contains data 30.");
		}else {
			System.out.println("The list does not contain data 30.");
		}// end if
		
		// remove the last node
		n1.getLink().removeNodeAfterThis();
		System.out.print("After removed the last node: ");
		n1.toString();
		
		// search whether the list contains data 30.
		if(IntNode.search(n1, 30)) {
			System.out.println("The list contains data 30.");
		}else {
			System.out.println("The list does not contain data 30.");
		}// end if	
		
	}// end main
}// end class
