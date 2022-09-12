import java.util.Scanner;

class Comp248secU{ // This is a class where all the methods will be created and utilized by the driver.
	
	// The following are members, attributes and variables. 
	private static int classSize,Idx,counter = 0;
	private static String semesterYear;
	private static String lectureRoom;
	private static String instructorFname;
	private static String instructorLname;
	private String[] studFname, studLname;
	private int[] studID;
	private double[] assgt1, assgt2, assgt3, assgt4, labs, midTerm, finalExam;
	
	
	// The following is a default constructor that initialize the data members of the class to some default values choses by the user.
	public Comp248secU(String fname, String lname, String room, String semYr, int size) {
		instructorFname = fname; 
		instructorLname = lname;
		lectureRoom = room;
		semesterYear = semYr;
		
		if(size<0) { // This is to ensure that the user inputs a valid integer, if not, the following message will be displayed.
			System.out.println("Error : Your input/entry for 'MaxClassSize' is NOT a valid integer. Kindly retry again!");
			System.exit(0); // This will end the program since a wrong type of input is given by the user.
		}
		classSize = size;
		
		// the following initializes all the data arrays size to the input "size" chosen by the user.
		this.studFname = new String[classSize];
		this.studLname = new String[classSize];
		this.studID = new int[classSize];
		this.assgt1 = new double[classSize];
		this.assgt2 = new double[classSize];
		this.assgt3 = new double[classSize];
		this.assgt4 = new double[classSize];
		this.labs = new double[classSize];
		this.midTerm = new double[classSize];
		this.finalExam = new double[classSize];
		
	}
	public void addStudent(String fname, String lname, int studID, int arrIdx) {
		if(counter<classSize) { // this is to ensure that the number of students does not exceed the class size.
		studFname[arrIdx] = fname; // setting the first element of 'stufFname' array to the parameter 'fname'.
		studLname[arrIdx] = lname; // setting the first element of 'stuflname' array to the parameter 'lname'.
		this.studID[arrIdx] = studID; // setting the first element of 'studID' array to the parameter 'studID'.
		this.assgt1[arrIdx] = 0.0;  // The following is to initialize all the attributes of a student to 0 until they get updated.
		this.assgt2[arrIdx] = 0.0;
		this.assgt3[arrIdx] = 0.0;
		this.assgt4[arrIdx] = 0.0;
		this.labs[arrIdx] = 0.0;
		this.midTerm[arrIdx] = 0.0;
		this.finalExam[arrIdx] = 0.0;
		System.out.println("Student with ID: " + studID + " added successfully.");
	    counter++; // increment the counter variable every time a new student gets added to the class.
		}
		else { // if the class is full and no other student can be added, the following message will be displayed.
			System.out.println("Student with ID: " + studID + " CANNOT be added. Class is already full.");
		}
	}
	public int getStudentIdx(int studID) {
		for(int idx = 0; idx < this.studID.length; idx++ ) {
            if(this.studID[idx] == studID) return idx; // This compares the parameter 'studID' to every element in the studID array, if a match is found it will return the index of this element which is the position of the student. 
        }
        System.out.println("Student with ID: " + studID + " does NOT exist");
        return -1; // If no match was found, the message above will be displayed as well as returning -1 as a value to show that there is no student with that studID.
    }
	
	public String[] getStudentInfo(int studID) {
		if(getStudentIdx(studID) == -1) { // If no student was found with the 'studID' input the following message will be displayed.
        	System.out.println("Unable to retrieve information for Student with ID: " + studID);
        	String[] studInfo = new String[10]; // Creation an array of size 10 to display students info.
            return studInfo; // If there is no student nothing will be displayed.
		}
		else {
			String[] studInfo = new String[10];  // Creation an array of size 10 to display students info.
			studInfo[0] = this.studFname[getStudentIdx(studID)] + ""; // storing each student's  first name as the first element of student info.  
			studInfo[1] = this.studLname[getStudentIdx(studID)] + ""; // storing each student's last name as the second element of student info.  
			studInfo[2] = this.studID[getStudentIdx(studID)] + ""; // storing each student's student ID as the third element of student info.  
			studInfo[3] = this.assgt1[getStudentIdx(studID)] + ""; // storing each student's assignment 1 grade as the fourth element of student info.  
			studInfo[4] = this.assgt2[getStudentIdx(studID)] + ""; // storing each student's assignment 2 grade as the fifth element of student info.  
			studInfo[5] = this.assgt3[getStudentIdx(studID) ]+ ""; // storing each student's assignment 3 grade as the sixth element of student info.  
			studInfo[6] = this.assgt4[getStudentIdx(studID)] + ""; // storing each student's assignment 4 grade as the seventh element of student info.  
			studInfo[7] = this.labs[getStudentIdx(studID)] + ""; // storing each student's labs grade as the first eighth of student info.  
			studInfo[8] = this.midTerm[getStudentIdx(studID)] + ""; // storing each student's mid term grade as the ninth element of student info.  
			studInfo[9] = this.finalExam[getStudentIdx(studID)] + "";  // storing each student's final exam as the tenth element of student info.  
			return studInfo; // this is to return the info when the method is called.
        }
		
	}
	// The following is  method to delete a student from the class.
	public int delStudent(int studID) {
		int studIdx = getStudentIdx(studID);
		if(studIdx == -1) {// If no student was found with the 'studID' input the following message will be displayed.
			System.out.println("Unable to retrieve information for Student with ID: " + studID);
		}
		// If a student is found, we then transform all of his attributes to nulls and 0s. That way the student will no longer exists.
		else {
        			this.studFname[studIdx] = null;
        			this.studLname[studIdx] = null;
        			this.studID[studIdx] = 0;
        			this.assgt1[studIdx] = 0.0;
        			this.assgt2[studIdx] = 0.0;
        			this.assgt3[studIdx] = 0.0;
        			this.assgt4[studIdx] = 0.0;
        			this.labs[studIdx] = 0.0;
        			this.midTerm[studIdx] = 0.0;
        			this.finalExam[studIdx] = 0.0;	
        			counter--; // We decrement the counter whenever a student is deleted to keep track of the number of the students in the class.
            }
            
		return 0;
	}
	// The following method is to update the students first name and last name.
	public int updateStudPart (String fname, String lname, int studID) {
		boolean test = false;
        for (int element : this.studID) {  // Using a for-each loop to traverse across the student ID array and to check if the studID input by the user corresponds to any of its elements.
            if (element == studID) {
                test = true;
		this.studFname[getStudentIdx(studID)] = fname; // updating the name of a student with the new input of the user.
		this.studLname[getStudentIdx(studID)] = lname; // updating the name of a student with the new input of the user.
		this.studID[getStudentIdx(studID)] = studID;
		System.out.println("Successfuly updated identification particulars for student with ID :" + studID);
		break;
            }
        }
            if(test == false) { // If no student was found the following message will be displayed.
            	System.out.println("Student with ID: " + studID + " does NOT exist");
            	System.out.println("Unable to retrieve information for Student with ID: " + studID);
            }
        
		return 1;
	}
	// The following message is to update the assignments scores of a student with the corresponding studID.
	public int updateAssgtScore(double a1, double a2, double a3, double a4, int studID) {
		boolean test = false;
        for (int element : this.studID) { // Using a for-each loop to traverse across the student ID array and to check if the studID input by the user corresponds to any of its elements.
            if (element == studID) {
                test = true;
                // The following is to update every assignment score by the input of the user for the corresponding student ID.
		this.assgt1[getStudentIdx(studID)] = a1;
		this.assgt2[getStudentIdx(studID)] = a2;
		this.assgt3[getStudentIdx(studID)] = a3;
		this.assgt4[getStudentIdx(studID)] = a4;
		System.out.println("Succesfully updated Assigments' scores for Student with ID:" + studID); // Displaying a message that confirms that the scores have been updated.
		break;
            }
        }
        if(test == false) { // If no student was found the following message will be displayed.
        	System.out.println("Student with ID: " + studID + " does NOT exist");
        	System.out.println("Unable to retrieve information for Student with ID: " + studID);
        }
		return 1;
		
		
	}
	// The following method is to update the lab, tests, and exams scores of a student with the corresponding student ID.
	public int updateOtherScore(double lab, double test, double exam, int studID) {
		boolean Test = false;
        for (int element : this.studID) { // Using a for-each loop to traverse across the student ID array and to check if the studID input by the user corresponds to any of its elements.
            if (element == studID) {
                Test = true;
             // The following is to update every score by the input of the user for the corresponding student ID.
		this.labs[getStudentIdx(studID)] = lab;
		this.midTerm[getStudentIdx(studID)] = test;
		this.finalExam[getStudentIdx(studID)] = exam;
		System.out.println("Succesfully updated Cummulative Labs, Mid-Term test, and Final Examination scores for Student with ID:" + studID); // Displaying a message that confirms that the scores have been updated.
		break;
            }
        }
        if(Test == false) { // If no student was found the following message will be displayed.
        	System.out.println("Student with ID: " + studID + " does NOT exist");
        	System.out.println("Unable to retrieve information for Student with ID: " + studID);
        }
		return 1;
		
	}
	// The following method calculates every students total score.
	public double computeWeightScore(int studID) {
		// This takes every single score of the corresponding student and sums them all up after dividing them by their weight.
		 double score =  ((this.assgt1[getStudentIdx(studID)]/20)*0.02 + (this.assgt2[getStudentIdx(studID)]/20)*0.03 + 
				(this.assgt3[getStudentIdx(studID)]/20)*0.05 + (this.assgt4[getStudentIdx(studID)]/20)*0.08 +
				(this.labs[getStudentIdx(studID)]/12)*0.12 + (this.midTerm[getStudentIdx(studID)]/30)*0.30 +
				(this.finalExam[getStudentIdx(studID)]/40)*0.40)*100;
		return score; // this will return the total of the student in percentage.
	}
	 // The following method is to associate the corresponding letter to the total of a student.
	public static char computeGrade(double wgtScore) {
		char grade;
		if(wgtScore >= 88) { // If the score is higher than 88, the letter A will be displayed.
			grade = 'A';
		}
		else if(wgtScore <88 && wgtScore >=80) { // If the score is higher or equal than 80 and lower than 88, the letter B will be displayed.
			grade = 'B';
		}
		else if(wgtScore <80 && wgtScore >=67) { // If the score is higher or equal than 67 and lower than 80, the letter C will be displayed.
			grade = 'C';
		}
		else if(wgtScore <67 && wgtScore >=60) { // If the score is higher or equal than 60 and lower than 67, the letter D will be displayed.
			grade = 'D';
		}
		else { // else the letter F will be displayed.
			grade = 'F';
		}
		return grade; // this is to return the grade when the method is called
	
	}
	// The following method is to find the lower grade of all the students.
	public static double findMin(double[] dataArr) {
		double grade = dataArr[0]; // allocating to the variable grade the first element of the array that has been passed.
		for (int i=0;i<counter; i++) { // traversing through the array.
			if(dataArr[i]<dataArr[0]) { 
				grade = dataArr[i]; // if element i is smaller than the element that has bee allocated to grade, we overwrite grade until it is the smaller of all.
			}
			
		}
		return grade; // this is to return the smallest grade when the method is called
	}
	// The following method is to find the higher grade of all the students
	public static double findMax(double[] dataArr) {
		double grade = dataArr[0];// allocating to the variable grade the first element of the array that has been passed.
		for (int i=0;i<counter; i++) { // traversing through the array.
			if(dataArr[i]>dataArr[0]) {
				grade = dataArr[i]; // if element 'i' is bigger than the element that has bee allocated to grade, we overwrite grade until it is the greater of all.
			}
			
		}
		return grade; // this is to return the highest when the method is called
	}
	// The following method is to find the grade grade of all the students
	public static double findAvg(double[] dataArr) {
		double ave = 0;
		double sum = 0;
		for (int i=0;i<counter;i++) { // traversing through the array that has been passed.
			sum = sum + dataArr[i]; // adding up all the elements of the array.( here we are technically adding up all the grades together and storing it in the sum variable).
		}
		ave = sum/(double)counter; // here we are calculating the average which is dividing the sum of the grades by the number of elements.
		return ave; // this is to return the average when the method is called
	}
	// The following message is to obtain the minimum grade of the different types of tests.
	public double[] getClassMin() {
		
		double[] classMinarr = new double[7]; // Creating an array of size 7 to display the corresponding info.
		// Calling the findMin method throughout each type of test to get the minimum grade of the class.
		classMinarr[0] = Comp248secU.findMin(assgt1);
		classMinarr[1] = Comp248secU.findMin(assgt2);
		classMinarr[2] = Comp248secU.findMin(assgt3);
		classMinarr[3] = Comp248secU.findMin(assgt4);
		classMinarr[4] = Comp248secU.findMin(labs);
		classMinarr[5] = Comp248secU.findMin(midTerm);
		classMinarr[6] = Comp248secU.findMin(finalExam);
		
		return classMinarr; // this is to return the min grades when the method is called
	}
	// The following message is to obtain the maximum grade of the different types of tests.
	public double[] getClassMax() {
		
		double[] classMaxarr = new double[7]; // Creating an array of size 7 to display the corresponding info.
		// Calling the findMax method throughout each type of test to get the maximum grade of the class.
		classMaxarr[0] = Comp248secU.findMax(assgt1); 
		classMaxarr[1] = Comp248secU.findMax(assgt2);
		classMaxarr[2] = Comp248secU.findMax(assgt3);
		classMaxarr[3] = Comp248secU.findMax(assgt4);
		classMaxarr[4] = Comp248secU.findMax(labs);
		classMaxarr[5] = Comp248secU.findMax(midTerm);
		classMaxarr[6] = Comp248secU.findMax(finalExam);
		
		return classMaxarr; // this is to return the max grades when the method is called
	}
	// The following message is to obtain the average of the different types of tests.
	public double[] getClassAvg() {
		
		double[] classAvg = new double[7]; // Creating an array of size 7 to display the corresponding info.
		// Calling the findAvg method throughout each type of test to get the average grade of the class.
		classAvg[0] = Comp248secU.findAvg(assgt1);
		classAvg[1] = Comp248secU.findAvg(assgt2);
		classAvg[2] = Comp248secU.findAvg(assgt3);
		classAvg[3] = Comp248secU.findAvg(assgt4);
		classAvg[4] = Comp248secU.findAvg(labs);
		classAvg[5] = Comp248secU.findAvg(midTerm);
		classAvg[6] = Comp248secU.findAvg(finalExam);
		
		return classAvg; // this is to return the average grades  when the method is called
	}
	// The following is to display all the attributes of every student such as his name, ID, grades etc.
	public void classReportCard() {
		double[] min = getClassMin(); // Creating an array that calls the getClassMin to get the minimum grade for every type of test.
        double[] max = getClassMax(); // Creating an array that calls the getClassMax to get the maximum grade for every type of test.
        double[] avg = getClassAvg(); // Creating an array that calls the getClassAvg to get the average grade for every type of test.
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		System.out.println("First Name	Last Name	Stud.ID		 A1      A2      A3      A4    Labs    Test    Exam    Wgt.    *");
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		for (int i=0; i<counter;i++) { // The following code will be executed for every student in the class.
			// Displaying every element of every type of array to present the student information. 
			System.out.println(this.studFname[i] +"\t\t"+ this.studLname[i] +"\t\t"+ this.studID[i] +
					"\t"+ this.assgt1[i] +"\t"+ this.assgt2[i] +"\t"+ this.assgt3[i] +"\t"+ this.assgt4[i] +
					"\t"+ this.labs[i] +"\t"+ this.midTerm[i] +"\t"+ this.finalExam[i] +"\t"+ computeWeightScore(studID[i])+ "\t" + computeGrade(computeWeightScore(studID[i])));
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
		System.out.print("		Minimum Score in Class:		" ); 
		for(int i = 0; i<7; i++) {
            System.out.print(min[i] + "\t"); // Displaying the elements of the array min created above. This will display the minimum grade for every test.
        }
		System.out.println();
		System.out.print("		Average Score in Class:		");
        for(int i = 0; i<7; i++) {
            System.out.print(avg[i] + "\t"); // Displaying the elements of the array avg created above. This will display the average grade for every test.
        }
        System.out.println();
        System.out.print("		Maximum Score in Class:		");
        for(int i = 0; i<7; i++) {
            System.out.print(max[i] + "\t"); // Displaying the elements of the array max created above. This will display the maximum grade for every test.
        }
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
	}
	
}
public class ClassroomManagment {
	public static void main(String[] args) {
		System.out.println("Welcome to the Simple Classroom Managment System: "); // Welcome message. 
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Enter instructor's particulars (FirstName, LastName, LectureRoom, Semester, MaxClassSize) as a single line entry: "); // Asking the user to input some info.
		Scanner scanner = new Scanner(System.in); 
		String frist = scanner.next(); // Allocating the first input to the variable first.
		String last = scanner.next(); // Allocating the second input to the variable last.
		String room = scanner.next(); // Allocating the third input to the variable room.
		String year = scanner.next(); // Allocating the fourth input to the variable year.
		if(!scanner.hasNextInt()) { // if the input for the class size is not an integer the following message will be displayed.
			
			System.out.println("Error: Your input/entry for 'MaxClassSize' is NOT a valid integer. Kindly retry again!");
		}
		else { // if the input for the class size is a valid integer the following code will be displayed.
			int size = scanner.nextInt();
		Comp248secU ClassA = new Comp248secU(frist,last, room, year,size); // Creating a object of the class Comp248secU.
		// The following is the options that the user can choose from when using this program.
		System.out.println();
		System.out.println("Code => Description");
		System.out.println("-------------------");
		System.out.println("103 => Enrol New Student");
		System.out.println("106 => Find Student Position in class List");
		System.out.println("109 => Retrieve Student's Information");
		System.out.println("112 => Unenrol Student");
		System.out.println("115 => Update Student's Particulars");
		System.out.println("118 => Update Assignement Scores");
		System.out.println("121 => Update Other Scores");
		System.out.println("124 => Display Student's Report Card");
		System.out.println("127 => Display Class Report Card");
		System.out.println("0 ===> Exit");
		System.out.println();
		System.out.println("Please enter a code, from the aftermentioned, that corresponds to your task: "); // Asking the user to choose an option.
		boolean bool = true;
		int index=0;
		while (bool == true) {
			if(!scanner.hasNextByte()) { // If the users input is not a valid byte, the following message will be displayed.
			System.out.println("Error: Your input/entry is not a valid integer between -128 to 127. Kindly retry again!");
			bool = false; // changing the 'bool' variable to false to end the while loop.
			}
			else  { // If the input is indeed a byte, the following code will be executed.
		int code = scanner.nextByte();
		switch (code) { // using switch to represent every option by a case.
		case 103: // this case is to add a new student.
			System.out.println();
			System.out.println();
			System.out.println("Enrolling new student...");
			System.out.println("-------------------------");
			System.out.println("Enter student's particulars (FirstName, LastName, StudentID) as a single-line entry:"); // Asking the user to enter the student particulars.
			String fname = scanner.next(); // storing the first input to the variable fname.
			String lname = scanner.next(); // storing the second input to the variable lname.
			if(scanner.hasNextInt()) { // if the user enter a valid integer for the student ID, the following code will be executed. This is to ensure that the user inputs a valid information.
			int ID = scanner.nextInt();
			ClassA.addStudent(fname, lname, ID, index); // calling a method from the Comp248secU class to add a student. When calling this method, the code inside of it will be executed.
			index++;
			System.out.println("Kindly continue by entering a Code, from the menu above, that corresponds to your task:"); // Asking the user to choose another option from the menu above.
			break; 
			}
			else if(scanner.hasNextInt() == false) { // if the user does enter a valid integer for the student ID, the following message will be displayed.
				System.out.println("Error: Your input/entry for Student ID is NOT a valid integer. Kindly retry again!");
				System.out.println("Kindly continue by entering a Code, from the menu above, that corresponds to your task:"); // Asking the user to choose another option from the menu above.
				scanner.next();
				continue;
			}
			break; // adding a break to ensure that the following cases do not get executed. this will return to the beginning of the while loop.
		case 106: // this case is to find the student's position in class
			System.out.println("Finding Student's Position in Class List...");
			System.out.println("--------------------------------------------");
			System.out.println("Enter StudentID: "); // asking the user to input a student ID.
			if(scanner.hasNextInt()) { // if the next input is a valid integer the following code will be executed.
			int w = scanner.nextInt(); // storing the input inside the variable w to use it after when calling a method.
			int studidx = ClassA.getStudentIdx(w); // calling the getStudentIdx to get the position of the student inside the class and storing the value inside the studidx variable.
			System.out.println("The position of student with ID: " + w + " , in the class list, is: " + studidx); // displaying the position of the student in the class.
			System.out.println("Kindly continue by entering a Code, from the menu above, that corresponds to your task:"); // Asking the user to choose another option from the menu above.
			break; // adding a break to ensure that the following cases do not get executed. this will return to the beginning of the while loop.
			}
			else if(scanner.hasNextInt() == false) { // else, if the input is not an integer the messages will be displayed.
				System.out.println("Error: Your input/entry for Student ID is NOT a valid integer. Kindly retry again!");
				System.out.println("Kindly continue by entering a Code, from the menu above, that corresponds to your task:"); // Asking the user to choose another option from the menu above.
				scanner.next();
				continue;
			}
		case 109: // this case is to retrieve the student's info.
			System.out.println("Retrieving Student's information...");
			System.out.println("------------------------------------");
			System.out.println("Enter StudentID: "); // asking the user to input a student ID.
			int w1 = scanner.nextInt(); // storing the input inside the variable w1 to use it after when calling a method.
			String [] info = ClassA.getStudentInfo(w1); // calling the getStudentInfo method. The code inside the method will be executed to give us the info we need.
			if(info[0] == null) { // if there is no student with the inputed student ID, the program would simply ask to choose from another option.
				System.out.println("Kindly continue by entering a Code, from the menu above, that corresponds to your task:"); // Asking the user to choose another option from the menu above.
				continue;
			}
			else { // if a student is found, the program would display the info as following:
			System.out.println("Student's First Name = " + info[0]);
			System.out.println("Student's Last Name = " + info[1]);
			System.out.println("Student's ID = " + info[2]);
			System.out.println("Score in Assigment 1 = " + info[3]);
			System.out.println("Score in Assigment 2 = " + info[4]);
			System.out.println("Score in Assigment 3 = " + info[5]);
			System.out.println("Score in Assigment 4 = " + info[6]);
			System.out.println("Commulative Scores in Labs = " + info[7]);
			System.out.println("Mid-Term Test Score = " + info[8]);
			System.out.println("Final Examination Score = " + info[9]);
			// we know that in our method we have created an array of size 10, and we allocated the attributes of a student to each element. We are simply calling each element to be displayed. For example, we know that element 0 of the array would display the student's first name.
			System.out.println("Kindly continue by entering a Code, from the menu above, that corresponds to your task:"); // Asking the user to choose another option from the menu above.
			break;
			}
		case 112: // this case is to delete a student.
			System.out.println();
			System.out.println();
			System.out.println("Unenrolling new student...");
			System.out.println("-------------------------");
			System.out.println("Enter StudentID: "); // asking the user to input a student ID.
			if (scanner.hasNextInt()) { // if the next input is a valid integer the following code will be executed. 
			int w2 = scanner.nextInt(); // storing the input inside the variable w2 to use it after when calling a method.
			ClassA.delStudent(w2); // calling the method from the Comp248secU class that deletes a student.
			System.out.println("Successfully removed Student with ID: " + w2); // displaying a message that the student has been indeed deleted.
			System.out.println("Kindly continue by entering a Code, from the menu above, that corresponds to your task:"); // Asking the user to choose another option from the menu above.
			break; // adding a break to ensure that the following cases do not get executed. this will return to the beginning of the while loop.
			}
			else if(scanner.hasNextInt() == false) { // else, if the input is not an integer the messages will be displayed.
				System.out.println("Error: Your input/entry for Student ID is NOT a valid integer. Kindly retry again!");
				System.out.println("Kindly continue by entering a Code, from the menu above, that corresponds to your task:"); // Asking the user to choose another option from the menu above.
				scanner.next();
				continue;
			}
		case 115: // this case is to update the student's particulars.
			System.out.println("Updating Student's Particulars...");
			System.out.println("---------------------------------");
			System.out.println("Enter update to student's particulars (FirstName, LastName, StudentID) as a single-line entry: ");
			String newFname = scanner.next(); // storing the new first name of the student to the variable newFname.
			String newLname = scanner.next(); // storing the new last name of the student to the variable newLname.
			if(scanner.hasNextInt()) { // if the next input is a valid integer the following code will be executed.
			int newID = scanner.nextInt();	
			ClassA.updateStudPart(newFname, newLname, newID); // calling the updateStudPart from the Comp248secU class method that allows us to update the students particulars.
			System.out.println("Kindly continue by entering a Code, from the menu above, that corresponds to your task:"); // Asking the user to choose another option from the menu above.
			break; // adding a break to ensure that the following cases do not get executed. this will return to the beginning of the while loop.
			}
			else if(scanner.hasNextInt() == false) { // else, if the input is not an integer the messages will be displayed.
				System.out.println("Error: Your input/entry for Student ID is NOT a valid integer. Kindly retry again!");
				System.out.println("Kindly continue by entering a Code, from the menu above, that corresponds to your task:"); // Asking the user to choose another option from the menu above.
				scanner.next();
				continue;
			}
		case 118: // this case is to update the grades of the assignments.
			System.out.println("Updating Assigment Scores...");
			System.out.println("----------------------------");
			System.out.println("Enter update to student's Assigment scores (Assigment1, Assigment2, Assigment3, Assigment4, StudentID) as a single-line entry: "); // asking the user to input some info.
			int a1 = scanner.nextInt(); // storing the next inputs to some variables.
			int a2 = scanner.nextInt();
			int a3 = scanner.nextInt();
			int a4 = scanner.nextInt();
			if(scanner.hasNextInt()) { // if the next input is an integer the following code will be executed.
			int ID1 = scanner.nextInt();
			ClassA.updateAssgtScore(a1, a2, a3, a4, ID1); // calling the updateAssgtScore while passing through it the different variables that the user has chosen to overwrite the current grades of the student.
			System.out.println("Kindly continue by entering a Code, from the menu above, that corresponds to your task:"); // Asking the user to choose another option from the menu above.
			break; // adding a break to ensure that the following cases do not get executed. this will return to the beginning of the while loop.
			}
			else if(scanner.hasNextInt() == false) { // else, if the input is not an integer the messages will be displayed.
				System.out.println("Error: Your input/entry for Student ID is NOT a valid integer. Kindly retry again!");
				System.out.println("Kindly continue by entering a Code, from the menu above, that corresponds to your task:"); // Asking the user to choose another option from the menu above.
				scanner.next();
				continue;
			}
			// this case is to update some other grades of the students.
		case 121:
			System.out.println("Updating Other Scores...");
			System.out.println("----------------------------");
			System.out.println("Enter update to student's Other scores (CummulativeLabs, MidTerm, FinalExam, StudentID) as a single-line entry: ");
			int lab = scanner.nextInt(); // storing the new grades chosen by the user to different variables corresponding to each test.
			int midterm = scanner.nextInt();
			int finalexam = scanner.nextInt();
			if(scanner.hasNextInt()) { // if the next input is an integer the following code will be executed.
			int ID2 = scanner.nextInt();
			ClassA.updateOtherScore(lab, midterm, finalexam, ID2); // calling the updateOtherScore while passing through it the different variables that the user has chosen to overwrite the current grades of the student.
			System.out.println("Kindly continue by entering a Code, from the menu above, that corresponds to your task:"); // Asking the user to choose another option from the menu above.
			break; // adding a break to ensure that the following cases do not get executed. this will return to the beginning of the while loop.
			}
			else if(scanner.hasNextInt() == false) { // else, if the input is not an integer the messages will be displayed.
				System.out.println("Error: Your input/entry for Student ID is NOT a valid integer. Kindly retry again!");
				System.out.println("Kindly continue by entering a Code, from the menu above, that corresponds to your task:"); // Asking the user to choose another option from the menu above.
				scanner.next();
				continue;
			}
			// this case is to display the student's report card.
		case 124:
			System.out.println("Displaying Student's Report Card...");
			System.out.println("-----------------------------------");
			System.out.println("Enter StudentID:");
			if(scanner.hasNextInt()) { // if the next input is an integer the following code will be executed.
			int w3 = scanner.nextInt();
			String [] info1 = ClassA.getStudentInfo(w3); // calling the getStudentInfo method. The code inside the method will be executed to give us the info we need.
			if(info1[0] == null) { // If no student was found, the following message will be displayed.
				System.out.println("Kindly continue by entering a Code, from the menu above, that corresponds to your task:"); // Asking the user to choose another option from the menu above.
				break;
			}
			else {
			System.out.println("Student's First Name = " + info1[0]);
			System.out.println("Student's Last Name = " + info1[1]);
			System.out.println("Student's ID = " + info1[2]);
			System.out.println("Score in Assigment 1 = " + info1[3]);
			System.out.println("Score in Assigment 2 = " + info1[4]);
			System.out.println("Score in Assigment 3 = " + info1[5]);
			System.out.println("Score in Assigment 4 = " + info1[6]);
			System.out.println("Commulative Scores in Labs = " + info1[7]);
			System.out.println("Mid-Term Test Score = " + info1[8]);
			System.out.println("Final Examination Score = " + info1[9]);
			System.out.println("--------------------------------");
			System.out.println("Student's Cummulative Weighted Score = " + ClassA.computeWeightScore(w3)); // this calls the computeWeightScore method that takes the student's grade and returns his total grade.
			System.out.println("Student's Final Letter Grade = " + Comp248secU.computeGrade(ClassA.computeWeightScore(w3))); // this calls the computeGrade method that calls the computeWeightScore method internally. It will will return the letter corresponding the the student's final grade.
			System.out.println("Kindly continue by entering a Code, from the menu above, that corresponds to your task:"); // Asking the user to choose another option from the menu above.
			// we know that in our method we have created an array of size 10, and we allocated the attributes of a student to each element. We are simply calling each element to be displayed. For example, we know that element 0 of the array would display the student's first name.
			break;
			}
			}
			else if(scanner.hasNextInt() == false) { // else, if the input is not an integer the messages will be displayed.
				System.out.println("Error: Your input/entry for Student ID is NOT a valid integer. Kindly retry again!");
				System.out.println("Kindly continue by entering a Code, from the menu above, that corresponds to your task:"); // Asking the user to choose another option from the menu above.
				scanner.next();
				continue;
			}
			// this case is to display the class report card.
		case 127:
			System.out.println("Displaying Class Report Card...");
			System.out.println("-------------------------------");
			ClassA.classReportCard(); // this calls the classReportCard method. the code inside the method will be executed to display the report card of the entire class.
			System.out.println("Kindly continue by entering a Code, from the menu above, that corresponds to your task:"); // Asking the user to choose another option from the menu above.
			break; // adding a break to ensure that the following cases do not get executed. this will return to the beginning of the while loop.
		// if the user decides to exit the program, the code inside the following case will be executed.
		case 0:
			System.out.println("Thank you for patronizing our Simple Classroom Managment System.");
			bool = false; // changing the variable bool to false so that the condition of the while loop return false and will end the loop.
			break; // adding a break to ensure that the following cases do not get executed. this will return to the beginning of the while loop.
		// this case is for a valid byte input, but a an invalid menu code input.
		default:
			System.out.println("Thank you for patronizing our Simple Classroom Managment System.");
			bool = false; // changing the variable bool to false so that the condition of the while loop return false and will end the loop.
		}
		}
		}	
	}
	}

}
