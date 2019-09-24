
public class Employee {
	
	// instance variables
	private String name;
	private int no;
	private int age;
	private String state;
	private int zip;
	private int advisors[] = new int[3];
	
	// default constructor
	public Employee () {
		name = "";
		no = 0;
		age = 0;
		state = "";
		zip = 0;
		advisors = null;
	}// end constructor
	
	// another constructor
	public Employee ( String name, int no, int age, String state, int zip, int[] advisors ) {
		setName (name);
		setNumber (no);
		setAge (age);
		setState (state);
		setZip (zip);
		setAdvisors (advisors);
	}// end constructor
	
	// copy constructor
	public Employee (Employee employee) {
		if(employee.name != "") {
		    System.out.println("Copy constructor called"); 
            name = employee.name; 
            no = employee.no; 
            age = employee.age;
            state = employee.state;
            zip = employee.zip;
            for(int i = 0; i < employee.advisors.length; i++) {
            	if(employee.advisors[i] != 0) 
            	    advisors[i] = employee.advisors[i];
            }// end for
		}// employee should not be null
	}// end constructor
	
	// accessors
	public String getName () {
		return name;
	} // end accessor
	public int getNumber () {
		return no;
	} // end accessor
	public int getAge () {
		return age;
	} // end accessor
	public String getState () {
		return state;
	} // end accessor
	public int getZip () {
		return zip;
	} // end accessor
	public int[] getAdvisors () {
		return advisors;
	} // end accessor
	
	// mutators
	public void setName ( String na ) {
		if ( na != "" ) //must have employee's name
			name = na;
	} // end mutator
	public void setNumber ( int N ) {
		no = N;
	} // end mutator
	public void setAge ( int A ) {
		age = A;
	} // end mutator
	public void setState ( String S ) {
		state = S;
	} // end mutator
	public void setZip ( int Z ) {
		zip = Z;
	} // end mutator
	public void setAdvisors (int[] Ad) {
		advisors = Ad;
	} // end accessor
	
	// toString method
	public String toString () {
		System.out.print( "Name: " + name + ", Number: " + no + ", Age: " + age + ", State: " + state + ", Zip: "
				+ zip + ", Advisors: " );
		for(int i = 0; i < 3; i++) {
			if(advisors[i] != 0)
				System.out.print(advisors[i] + " ");
		}// end for
		System.out.println();
		return "";
	} // end toString method
	
	// equals method
	public boolean equals (Employee employee) {
		if(employee.name != "") {
			if(no == employee.no) {
				return true;
		    }else {
		    	return false;
		    }
		}else {
		    return false;
		}// employee should not be null
	}// end equals method
	
	// getAllAdvisors method
	public static int[] getAllAdvisors (Employee e1, Employee e2) {
		int[] allAdvisors = new int[6];
		int temp = e1.advisors.length;
		if(e1.name != "" && e2.name != "") {
			for(int i = 0; i < e1.advisors.length; i++) {
				if(e1.advisors[i] != 0) {
					allAdvisors[i] = e1.advisors[i];
				}// end if
			}// end for
			for(int j = 0; j < e2.advisors.length; j++) {
				if(e2.advisors[j] != e1.advisors[0] && e2.advisors[j] != e1.advisors[1]
						&& e2.advisors[j] != e1.advisors[2] && e2.advisors[j] != 0) {
					allAdvisors[temp] = e2.advisors[j];
				}// end if, get all the DISTINCT advisors
				temp++;
			}// end for
			return allAdvisors;
		}// end if, employee should not be null
		return null;
	}// end getAllAdvisors method
	
	
	
	
	// main
	public static void main (String[] args) {
		// create employee information
		int [] e1Advisors = {1, 2, 3};
		int [] e1AdvisorsChanged = {2, 3, 4};
		int [] e2Advisors = {3, 4, 5};
		int [] e3Advisors = {7, 8, 9};
		int [] e4Advisors = {5, 6};
		int [] e5Advisors = {6};
		int [] e6Advisors = {1, 2};
		Employee e1 = new Employee("Jeff", 0, 18, "NM", 88001, e1Advisors);
		Employee e2 = new Employee("James", 2, 20, "NY", 12201, e2Advisors);
		Employee e3 = new Employee("David", 3, 22, "CA", 90001, e3Advisors);
		Employee e4 = new Employee("Steven", 4, 19, "LA", 70112, e4Advisors);
		Employee e5 = new Employee("Kevin", 5, 23, "AZ", 85001, e5Advisors);
		Employee e6 = new Employee("Jason", 6, 25, "AK", 99701, e6Advisors);
		
		// Test toString by printing e1 and e2
		System.out.print(e1.toString());
		System.out.print(e2.toString());
		System.out.print(e3.toString());
		
		// Test mutators
		e1.setName("Tom");
		e1.setNumber(1);
		e1.setAge(26);
		e1.setState("FL");
		e1.setZip(32099);
		e1.setAdvisors(e1AdvisorsChanged);
		System.out.print(e1.toString());// Print e1
		
		// Test accessors
		System.out.println ( e1.getName() );
		System.out.println ( e1.getNumber() );
		System.out.println ( e1.getAge() );
		System.out.println ( e1.getState() );
		System.out.println ( e1.getZip() );
		int [] AD = new int [3];
		AD = e1.getAdvisors();
		for(int i = 0; i < 3; i++) {
			if( AD[i] != 0)
				System.out.print( AD[i] + " ");
		}// end for
		System.out.println();
		
		// Test the copy constructor
		Employee e7 = new Employee(e6);
		System.out.print(e7.toString());
		
		// Test the equals method
		if(e6.equals(e7)) {
			System.out.println ( "e6 is equal to e7" );
		}else {
			System.out.println ( "e6 is not equal to e7" );
		}// end if
		if(e4.equals(e5)) {
			System.out.println ( "e4 is equal to e5" );
		}else {
			System.out.println ( "e4 is not equal to e5" );
		}// end if
		
		// Test getAllAdvisors method
		int allAdvisors [] = new int [6];
		allAdvisors = getAllAdvisors(e3, e4);
		System.out.print ( "All the advisors from e3 and e4 are " );
		for(int l = 0; l < allAdvisors.length; l++) {
			if(allAdvisors[l] != 0)
			    System.out.print ( allAdvisors[l] + " " );
		}// end for
		System.out.println();
		
	}// end main
	
}// end class
