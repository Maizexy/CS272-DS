/* Name: Yuxi Wang
 * Class: CS272
 * Due: 09132019 */

public class EmployeeSet {
	
	// instance variables
	final int INITIAL_CAPACITY = 10;
	private int empNum;
	private Employee[] empData;
	
	// no-argument constructor
	/* @postcondition
	*  This bag is empty and has an initial capacity of 10.
	*  @exception OutOfMemoryError */
	public EmployeeSet() {
		empNum = 0;
		empData = new Employee[INITIAL_CAPACITY];
	}// end constructor
	
	// accessor
	public Employee[] getEmpData () {
		return empData;
	} // end accessor
	
	// mutator
	public void setCapacity ( int n ) {
		Employee[] tempArray = new Employee[n];
		for(int i = 0; i < this.capacity(); i++) {
			tempArray[i] = empData[i];
		}// end for
		empData = new Employee[n];
		for(int k = 0; k < this.capacity(); k++) {
			empData[k] = tempArray[k];
		}// end for
	} // end mutator
	
	// copy constructor
	/* @precondition
	*  The object should NOT be null and should be an instance of EmployeeSet. */
	public EmployeeSet(Object obj) {
		EmployeeSet e = (EmployeeSet) obj;
		Employee[] temp = e.getEmpData();
		empNum = e.size();
		empData = new Employee[e.capacity()];
		for(int i = 0; i < e.capacity(); i++) {
			empData[i] = temp[i];
		}// end for
	}// end constructor
	
	// size method
	/* @Postcondition 
	 * The return value is the actual number of elements in this collection. */
	public int size() {
		return empNum;
	}// end method
	
	// capacity method
	/* @Postcondition 
	 * The return value is the capacity of this collection instance. */
	public int capacity() {
		return empData.length;
	}// end method
	
	/* @functionality
	 * adds one given Employee object to the first available space of the employee
	   array in this EmployeeSet instance. 
	 * @precondition
	 * The employee object should NOT be null. */
	public void add(Employee a) {
		for(int i = 0; i < this.capacity(); i++) {
			if(empData[i] == null) {
				empData[i] = a;
				empNum++; // when a object is added into employee set, empNum +1
				break;
			}else if(empData[this.capacity()-1] != null) { 
				// the space is not sufficient, double the space
				int newCapacity = this.capacity() *2;
				this.ensureCapacity(newCapacity);
			}// end if
		}// end for
	}// end method
	
	/* @functionality
	 * check whether this collection contains the input parameter. 
	 * @Postcondition 
	 * The return value is true if this collection contains an employee object. */
	public boolean contains(Employee a) {
		boolean exist = false;
		if(a == null) 
			return false;
		for(int i = 0; i < this.size(); i++) {
			if(a.getNumber() == empData[i].getNumber()){
				exist = true;
				break;
			}// end if
		}// end for
	    if(exist) {
			return true;
		}else {
			return false;
		}// end if
	}// end method
	
	/* @functionality
	 * remove from the collection the employee with the given employee number eno. 
	 * @Postcondition 
	 * If this collection contains one employee object a1 whose employee number equals to eno, then
       remove a1 from this collection and return true; otherwise, do nothing and return false. */
	public boolean remove(int eno) {
		if(eno == 0)
			return false;
		int Index;
		for(Index = 0; Index < this.capacity() && empData[Index].getNumber() != eno; Index++);
		if( Index == this.capacity() ) { 
			return false; // if no one's number is eno, do not make any change.
		}else { // the allEmp[Index]'s number is eno.
			for(int i = Index; i < empNum-1; i++) {
				empData[i] = empData[i+1];
			}// end for
			empData[ empNum-1 ] = null;
			empNum--; // when a object is removed form employee set, empNum -1.
			return true; // remove successfully, return true.
		}// end if
	}// end method
	
	/* @functionality
	 * guarantees the capacity of the collection. 
	 * @precondition
	 * the input parameter minimumCapacity should be positive. */
	private void ensureCapacity (int minimumCapacity) {
		if(this.capacity() < minimumCapacity){
			this.setCapacity(minimumCapacity);
		}else{
			System.out.println("The capacity is >= " + minimumCapacity );
		}// end if
	}// end method
	
	/* @functionality
	 * add one employee object to EmployeeSet instance such that the objects
       in the employee array are in ascending order of employee nos. 
	 * @precondition
	 * The employee object should NOT be null. 
	 * The objects in the empData array should be already in ascending order of employee nos. */
	public void addOrdered(Employee a) {
		for(int i = 0; i < this.capacity(); i++) {
			if(empData[this.capacity()-1] != null) {
				// the space is not sufficient, double the space
				int newCapacity = this.capacity() *2;
				this.ensureCapacity(newCapacity);
			}else {
				if( empData[i].getNumber() > a.getNumber() ) {
					for(int m = this.capacity()-1; m > i; m--) {
						// make each element (which has a bigger employee no) index +1
						empData[m] = empData[m-1];
					}// end for
					empData[i] = a;
					empNum++;
					break;
				}// end if
			}// end if
		}// end for
	}// end method
	
	
		

	// main method
	public static void main(String[] args) {
		
		// create 12 employees
		Employee e1 = new Employee("A", 1, 23, "NM", 88001, null );
		Employee e2 = new Employee("B", 2, 20, "NY", 12201, null);
		Employee e3 = new Employee("C", 3, 22, "CA", 90001, null);
		Employee e4 = new Employee("D", 4, 19, "LA", 70112, null);
		Employee e5 = new Employee("E", 5, 23, "AZ", 85001, null);
		Employee e6 = new Employee("F", 6, 27, "AK", 99701, null);
		Employee e7 = new Employee("G", 7, 32, "AK", 99701, null);
		Employee e8 = new Employee("H", 8, 25, "AK", 99701, null);
		Employee e9 = new Employee("I", 9, 24, "AK", 99701, null);
		Employee e10 = new Employee("J", 10, 30, "AK", 99701, null);
		Employee e11 = new Employee("K", 11, 36, "AK", 99701, null);
		Employee e12 = new Employee("L", 12, 22, "AK", 99701, null);
		
		// create a employee set set1
		EmployeeSet set1 = new EmployeeSet();
		
		// test add method, add those employees info into set1
		set1.add(e1);
		set1.add(e2);
		set1.add(e3);
		set1.add(e4);
		set1.add(e5);
		set1.add(e6);
		
		// test the capacity method
		System.out.println("The capacity of set1 is " + set1.capacity());
		
		// test the size method
		System.out.println("There are " + set1.size() + " employee in set1.");
		
		// test getEmpData method
		Employee[] show = set1.getEmpData();
		System.out.print("They are: ");
		for(int i = 0; i < set1.size(); i++) {
			System.out.print( show[i].getName() + " " );
		}// end for
		System.out.println();
		
		// test the remove method, remove employee No.3
		set1.remove(3);
		
		// print
		System.out.println();
		System.out.println("After I removed employee No.3, there are " + set1.empNum + " employee in set1.");
		show = set1.getEmpData();
		System.out.print("They are: ");
		for(int i = 0; i < set1.size(); i++) {
			System.out.print( show[i].getName() + " " );
		}// end for
		System.out.println();
		
		// test contains method and print
			if(set1.contains(e3) == false)
				System.out.println( "e3 is not in set1" );
			System.out.println();
		
		// test ensureCapacity method, add the rest of the employees into set1
		set1.add(e7);
		set1.add(e8);
		set1.add(e9);
		set1.add(e10);
		set1.add(e11);
		set1.add(e12);
		
		// print
		System.out.println("When I add the rest of the employees,"
				+ "there are " + set1.empNum + " employee in set1.");
		System.out.println("And the capacity of set1 is " + set1.capacity() + " now.");
		show = set1.getEmpData();
		System.out.print("They are: ");
		for(int i = 0; i < set1.size(); i++) {
			System.out.print( show[i].getName() + " " );
		}// end for
		System.out.println();
		System.out.println();
		
		// test addOrdered method, add the employee No.3 back 
		set1.addOrdered(e3);
		
		// print
		show = set1.getEmpData();
		System.out.print("After adding e3 in order, there are " + set1.size() +" employees: ");
		for(int i = 0; i < set1.size(); i++) {
			System.out.print( show[i].getName() + " " );
		}// end for
		
		// test contains method and print
		System.out.println();
		if(set1.contains(e3))
			System.out.println( "We have e3 in set1" );
		System.out.println();
		
		// print
		System.out.println("Now we have tested all the methods. Thank you for grading this program!");
	
	}// end main

}// end class
