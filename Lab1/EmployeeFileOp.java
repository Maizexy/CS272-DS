//cs272
//Yuxi Wang

import java.io.*;

public class EmployeeFileOp {
	private static String[][] Information = new String[302][6];
	
	//read method
	public static void read(String fileName) { 
		try {
			
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            
            int n = 0;
            while(line != null) {
            	//replace the ',' which for split
            	line = line.replace(", " , "~~");
            	line = line.replace("," , "%%");
            	line = line.replace("~~" , ", ");
            	//split
            	String[] temp = line.split("%%");
            	//get the information
            	if(n < 301) {
            	    Information[n][0] = temp[0]; //name
            	    Information[n][1] = temp[1]; //number
            	    Information[n][2] = temp[2]; //state
            	    Information[n][3] = temp[3]; //zip
            	    Information[n][4] = temp[5]; //age
            	    Information[n][5] = temp[6]; //sex
            	}	
            	n++;
            	line = bufferedReader.readLine();
            }//end while
            bufferedReader.close(); 
            System.out.println("Successfully read the file");
            
        }catch(FileNotFoundException ex) {
            System.out.println("Unable to open file"); 
            
        }catch(IOException ex) {
            System.out.println("Error reading file"); 
        }//end try	
	}//end read
	
	//write method
	public static void write(String fileName){
		try {
			//create new file
			File file = new File(fileName);
			
			FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			//write the header
			bufferedWriter.write("Employee Name,Employee Number,State,Zip,Age,Sex"+"\n");
			//get young employee
			int age = 0; 
			for(int i = 0; i < Information.length; i++) {
				try {
				     age = Integer.parseInt(Information[i][4].trim());
				}catch(NumberFormatException e){
					 age = 31;
				}catch(NullPointerException e) {
					 age = 31;
				}
				if(age <= 30) {
					bufferedWriter.write(Information[i][0]+","+Information[i][1]+","+Information[i][2]+","
					    +Information[i][3]+","+Information[i][4]+","+Information[i][5]+"\n");
				}//end if
			}//end for
			
			bufferedWriter.close();
			fileWriter.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}//end try
		
		System.out.println("Finish writing");
		
		
		
	}//end write
	
	public static void main (String[]args) {
		
		read("core_dataset.csv");
		write("young_employee.csv");
	}//end main
		
}//end class
