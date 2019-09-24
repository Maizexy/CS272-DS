/* @author: Yuxi Wang
 * Course: CS272
 * Due: 09232019 */

public class IntNode {
	
	// instance variables
	int data;
	IntNode link;
	
	// no-argument constructor
	public IntNode() {
		data = 0;
		link = null;
	}// end constructor
	
	// another constructor
	public IntNode(int _data, IntNode _node) {
		data = _data;
		link = _node;
	}// end constructor
	
	// get method
	public int getData() {
		return data;
	}// end method
	public IntNode getLink() {
		return link;
	}// end method
	
	// set method
	public void setData( int n ) {
		this.data = n;
	}// end method
	public void setLink( IntNode l ) {
		this.link = l;
	}// end method
	
	// toString method
	public String toString() {
		for(IntNode tempNode = this; tempNode != null; tempNode = tempNode.getLink()) {
			if(tempNode.getLink() != null) {
				System.out.print(tempNode.data + " -> ");
			}else {
				System.out.print(tempNode.data + "\n");
			}// end for
		}// end for
		return "";
	}// end method
	
	// add method, to add a node after the current node.
	public void addNodeAfterThis(int newdata) {
		IntNode newNode = new IntNode();
		newNode.setData(newdata);
		if(this.getLink() != null) {
			newNode.setLink(this.getLink());
			this.setLink(newNode);
		}else {
			this.setLink(newNode);
		}// end if
	}// end method
	
	// remove method, to remove the node after the current node.
	public void removeNodeAfterThis() {
		if(this.getLink() != null) {
			if(this.getLink().getLink() != null) {
				IntNode tempNode = this.getLink().getLink();
				this.setLink(tempNode);
			}else {
				this.setLink(null);
			}// end if
		}else {
			System.out.println("There is no Node after this.");
		}// end if
	}// end method
	
	// listLength method, to get the number of nodes in the list starting from a given node head.
	/* @Postcondition 
	 * The return value is the number of nodes in this list. */
	public static int listLength(IntNode head) {
		int n = 0;
		for(IntNode tempNode = head; tempNode != null; tempNode = tempNode.getLink()) {
			n++;
		}// end for
		return n;
	}// end method
	
	// search method, to search whether a linked list starting with head contains a given value data.
	/* @precondition
	*  Head is not null. 
	*  @Postcondition
	*  The return value is true if the list contains the given value data*/
	public static boolean search(IntNode head, int data) {
		boolean exist = false;
		for(IntNode tempNode = head; tempNode != null; tempNode = tempNode.link) {
			if(tempNode.data == data) {
				exist = true;
				break;
			}// end if
		}// end for
		return exist;
	}// end method

}// end class
