import java.util.*;

public class Student_Management_System {
	/**
	 * The main method that store all pieces of information about each student in the system. And also store
	 * the number of students in the system and the number of students that were deleted. 
	 * 
	 * informations:-
	 * - first name of the student.
	 * - last name of the student.
	 * - full name of the student.
	 * - id of the student.
	 * - city that students live in.
	 * - phone number of the student.
	 * - email address of the student.
	 * - age of the student.
	 * - GPA of the student.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);

		int sizeOfDatabase = 10000000;
		int studentsInDatabase = 0;
		int studentsDeleted = 0;

		String [] firstName = new String[sizeOfDatabase];
		String [] lastName = new String[sizeOfDatabase];
		String [] fullName = new String[sizeOfDatabase];
		int [] id = new int[sizeOfDatabase];
		String [] city = new String[sizeOfDatabase];
		String [] mobileNumber = new String[sizeOfDatabase];
		String [] email = new String[sizeOfDatabase];
		int [] age = new int[sizeOfDatabase];
		double [] gpa = new double[sizeOfDatabase];
		boolean [] gpaNormlize = new boolean[sizeOfDatabase];

		System.out.print("--- Welcome to the student program ---");
		System.out.println();
		toolsBox(firstName, lastName, fullName, id, city, mobileNumber, email, age, gpa, gpaNormlize, studentsDeleted, studentsInDatabase, sizeOfDatabase, console);
		
	}


	/**
	 * This is the toolsBox method. it works as the menu of the actions that can user do it in the system.
	 * 
	 * Actions:
	 * - register students in the system.
	 * - inquiry about a student.
	 * - delete a student from the system.
	 * - display all registered students in the system.
	 * - display statistics.
	 * - update the GPA of a student.
	 * - half-load.
	 * - normalize.
	 * 
	 * 
	 * @param firstName
	 * @param lastName
	 * @param fullName
	 * @param id
	 * @param city
	 * @param mobileNumber
	 * @param email
	 * @param age
	 * @param gpa
	 * @param gpaNormlize
	 * @param studentsDeleted
	 * @param studentsInDatabase
	 * @param sizeOfDatabase
	 * @param console
	 */
	public static void toolsBox (String [] firstName, String [] lastName, String [] fullName, int [] id, String [] city, String [] mobileNumber
		, String [] email, int [] age, double [] gpa, boolean [] gpaNormlize, int studentsDeleted, int studentsInDatabase, int sizeOfDatabase, Scanner console) {

		System.out.println();

		System.out.println("a) Register students in the system.");
		System.out.println("b) Inquiry about a student.");
		System.out.println("c) Delete a student from the system.");
		System.out.println("d) Display all registered students in the system.");
		System.out.println("e) Display statistics.");
		System.out.println("f) Update the GPA of a student.");
		System.out.println("g) Half-load.");
		System.out.println("h) Normalize.");

		System.out.println();

		System.out.println("** Enter Exit to exit the program **");
		System.out.print("Enter what do you want to do :- ");
		String ch = console.next();

		if (ch.equalsIgnoreCase("a") || ch.equals("1")) {
			System.out.println("----------------------------------------");
			System.out.println();
			studentsInDatabase += add(firstName, lastName, fullName, id, city, mobileNumber, email, age, gpa, studentsDeleted, studentsInDatabase, sizeOfDatabase, console);
			System.out.println();
			System.out.println("----------------------------------------");
			toolsBox(firstName, lastName, fullName, id, city, mobileNumber, email, age, gpa, gpaNormlize, studentsDeleted, studentsInDatabase, sizeOfDatabase, console);
		} else if (ch.equalsIgnoreCase("b") || ch.equals("2")) {
			System.out.println("----------------------------------------");
			System.out.println();
			search(fullName, id, city, mobileNumber, email, age, gpa, studentsDeleted, studentsInDatabase, console);
			System.out.println();
			System.out.println("----------------------------------------");
			toolsBox(firstName, lastName, fullName, id, city, mobileNumber, email, age, gpa, gpaNormlize, studentsDeleted, studentsInDatabase, sizeOfDatabase, console);
		} else if (ch.equalsIgnoreCase("c") || ch.equals("3")) {
			System.out.println("----------------------------------------");
			System.out.println();
			studentsDeleted += delete(firstName, lastName, fullName, id, city, mobileNumber, email, age, gpa, gpaNormlize, studentsDeleted, studentsInDatabase, sizeOfDatabase, console);
			System.out.println();
			System.out.println("----------------------------------------");
			toolsBox(firstName, lastName, fullName, id, city, mobileNumber, email, age, gpa, gpaNormlize, studentsDeleted, studentsInDatabase, sizeOfDatabase, console);
		} else if (ch.equalsIgnoreCase("d") || ch.equals("4")) {
			System.out.println("----------------------------------------");
			System.out.println();
			sortAndPrint(firstName, lastName, fullName, id, city, mobileNumber, email, age, gpa, gpaNormlize, studentsDeleted, studentsInDatabase);
			System.out.println();
			System.out.println("----------------------------------------");
			toolsBox(firstName, lastName, fullName, id, city, mobileNumber, email, age, gpa, gpaNormlize, studentsDeleted, studentsInDatabase, sizeOfDatabase, console);
		} else if (ch.equalsIgnoreCase("e") || ch.equals("5")) {
			System.out.println("----------------------------------------");
			System.out.println();
			statistics(firstName, lastName, fullName, id, city, mobileNumber, email, age, gpa, gpaNormlize, studentsDeleted, studentsInDatabase);
			System.out.println();
			System.out.println("----------------------------------------");
			toolsBox(firstName, lastName, fullName, id, city, mobileNumber, email, age, gpa, gpaNormlize, studentsDeleted, studentsInDatabase, sizeOfDatabase, console);
		} else if (ch.equalsIgnoreCase("f") || ch.equals("6")) {
			System.out.println("----------------------------------------");
			System.out.println();
			upDateGPA(gpa, gpaNormlize, id, studentsDeleted, studentsInDatabase, console);
			System.out.println();
			System.out.println("----------------------------------------");
			toolsBox(firstName, lastName, fullName, id, city, mobileNumber, email, age, gpa, gpaNormlize, studentsDeleted, studentsInDatabase, sizeOfDatabase, console);
		} else if (ch.equalsIgnoreCase("g") || ch.equals("7")) {
			System.out.println("----------------------------------------");
			System.out.println();
			halfLoad(gpa, studentsDeleted, studentsInDatabase);
			System.out.println();
			System.out.println("----------------------------------------");
			toolsBox(firstName, lastName, fullName, id, city, mobileNumber, email, age, gpa, gpaNormlize, studentsDeleted, studentsInDatabase, sizeOfDatabase, console);
		} else if (ch.equalsIgnoreCase("h") || ch.equals("8")) {
			System.out.println("----------------------------------------");
			System.out.println();
			normalize(gpa , gpaNormlize, studentsDeleted, studentsInDatabase);
			System.out.println();
			System.out.println("----------------------------------------");
			toolsBox(firstName, lastName, fullName, id, city, mobileNumber, email, age, gpa, gpaNormlize, studentsDeleted, studentsInDatabase, sizeOfDatabase, console);
		} else if (ch.equalsIgnoreCase("Exit")) {
			System.out.println();
			System.out.print("----------------Finish-----------------");
			System.out.println();
		} else {
			System.out.println();
			System.out.println("*** Please choose tool from the tools ***");
			toolsBox(firstName, lastName, fullName, id, city, mobileNumber, email, age, gpa, gpaNormlize, studentsDeleted, studentsInDatabase, sizeOfDatabase, console);
		}
	}


	/**
	 * This is add method. the method asked the user to enter the number of students that the user wants to add to the system data and
	 * the method will check the validation of the numbers that the user entered by call (validationOfAnyIntNumber) and after that,
	 * the method will check if the size of the available storage of the system is greater than or equal to the number of students that
	 * the user wants to add to the system, then the method will start to add from where it ends and every time the user adds student
	 * information the counter will increase 1 at the end the method will return the counter and save it in studentsInDatabase varaible
	 * in the main method (studentsInDatabase++).
	 * 
	 * 
	 * 
	 * @param firstName
	 * @param lastName
	 * @param fullName
	 * @param id
	 * @param city
	 * @param mobileNumber
	 * @param email
	 * @param age
	 * @param gpa
	 * @param studentsDeleted
	 * @param studentsInDatabase
	 * @param sizeOfDatabase
	 * @param console
	 * @return one to the number of students in the system.
	 */
	public static int add (String [] firstName, String [] lastName, String [] fullName, int [] id, String [] city, String [] mobileNumber
		, String [] email, int [] age, double [] gpa, int studentsDeleted, int studentsInDatabase, int sizeOfDatabase, Scanner console) {

		/* In this part, the method asked the user to enter the number of students that the user wants to add to the system data and
		 * the program will check the validation of the numbers that the user entered by call (validationOfAnyIntNumber) and after that,
		 * the program will start to add students from where it ended. */

		System.out.print("Enter the number of the Student that you want to add in the database :- ");
		int addedToDatabase = validationOfAnyIntNumber(console);
		addedToDatabase += (studentsInDatabase - studentsDeleted); 

		/*
		 * In this part, the program will check if the size of the available storage of the system is greater than or equal
		 * to the number of students that the user wants to add to the system. 
		 */

		while (!(sizeOfDatabase >= addedToDatabase)) {
			int avalableSize = sizeOfDatabase - (studentsInDatabase - studentsDeleted);
			System.out.println("Sorry the size of the database is less than the number of students that you want to added !");
	 		System.out.print("Enter number between 0 and " + avalableSize + " :- ");
			addedToDatabase = validationOfAnyIntNumber(console);
			addedToDatabase += (studentsInDatabase - studentsDeleted);
		}

		/*
		 * The program will start to add from where it ends and every time the user adds student information the counter will increase 1 at
		 * the end the function will return the counter and save it in studentsInDatabase varaible in the main method (studentsInDatabase++).
		 * */

		int counter = 0;
		for (int i = (studentsInDatabase - studentsDeleted); i < addedToDatabase ; i++) {
			counter++;
			System.out.println();
			System.out.println("Student no. "+ (i+1) +" : ");
			System.out.println();

			System.out.print("Enter the first name of the Student :- ");
			firstName[i] = validationOfTheName(console);
			System.out.print("Enter the last name of the Student :- ");
			lastName[i] = validationOfTheName(console);

			fullName[i] = firstName[i] + " " + lastName[i];

			System.out.print("Enter the id of the Student :- ");
			id[i] = validationOfTheId(id, studentsInDatabase, studentsDeleted, console);

			System.out.print("Enter the city that the Student live in it :- ");
			city[i] = validationOfTheCity(console);

			System.out.print("Enter the mobile number of the Student :- ");
			mobileNumber[i] = validationOfMobileNumber(mobileNumber, studentsInDatabase, studentsDeleted, console);

			System.out.print("Enter the email address of the Student :- ");
			email[i] = validationOfTheEmail_1(email, studentsInDatabase, studentsDeleted, console);

			System.out.print("Enter the age of the Student :- ");
			age[i] = validationOfTheAge(console);

			System.out.print("Enter the GPA of the Student :- ");
			gpa[i] = validationOfGPA_1(console);

			System.out.println();
		}
		if (counter > 0) {
			System.out.println("Successfully registered.");
		} else {
			System.out.println("You dont add any student");
		}

		return counter;		
	}


	/**
	 * In this method, The user will enter the number and this number will save in a string variable to check if the number that the user 
	 * entered contains any letter or symbols or not. if it contains, the flag will be false and the method will create a new string 
	 * variable called num2 and check again. If it does not contain any letter or symbols the flag will be true and the program will save
	 * num2 in string num3 and convert string num3 to integer data type called integer2 and return it.
	 * 
	 * @param console - object of class Scanner.
	 * @return integer - the number after check the validation.
	 */
	public static int validationOfAnyIntNumber(Scanner console) {
		String num = console.next();
		
		boolean flag = false;
		for (int i = 0; i < num.length() ; i++) {
			if (num.charAt(i) >= '0' && num.charAt(i) <= '9') {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}

		if (flag == true) {
			int integer = Integer.parseInt(num);
			return integer;
		}
		String num3 = null;
		while (flag == false) {
			System.out.print("**You entered Letters so please enter a number :- ");
			String num2 = console.next();

			for (int i = 0; i < num2.length() ; i++) {
				if (num2.charAt(i) >= '0' && num2.charAt(i) <= '9') {
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				num3 = num2;
			}
		}
		int integer2 = Integer.parseInt(num3);
		return integer2;
	}


	/**
	 * In this method, the user will enter the name and this name will save in a string variable to check if the name that the user entered 
	 * contain any numbers or symbols or not, if it contains the flag will be false and the method will create a new string variable called 
	 * name2 and the user will enter the name and check again. if it does not contain any number or symbols the flag will be true and the 
	 * program will save name2 in string name3 and return it.
	 * 
	 * @param console
	 * @return valid name 
	 */
	public static String validationOfTheName (Scanner console) {
		String name = console.next();

		boolean flag = false;
		for (int i = 0; i < name.length() ; i++) {
			if ((name.charAt(i) >= 'a' && name.charAt(i) <= 'z') || (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z')) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		if (flag == true) {
			return name;
		}
		
		
		String name3 = null;
		while (flag == false) {
			System.out.print("**Please enter the name again :- ");
			String name2 = console.next();

			for (int i = 0; i < name2.length() ; i++) {
				if ((name2.charAt(i) >= 'a' && name2.charAt(i) <= 'z') || (name2.charAt(i) >= 'A' && name2.charAt(i) <= 'Z')) {
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				name3 = name2;
			}
		}
		return name3;
	}


	/**
	 * In this method, the user will enter the id of the student and the program will check if it is valid or not by calling 
	 * (validationOfAnyIntNumber) after that the method will check if the id is taken or not, if it is taken the method will 
	 * prompt the user to enter another id and check the validation of the new id that the user entered. if it is valid the 
	 * program will check if it has been taken or not and so on .
	 * 
	 * @param databaseOfId
	 * @param studentsInDatabase
	 * @param studentsDeleted
	 * @param console
	 * @return the valid id.
	 */
	public static int validationOfTheId (int [] databaseOfId, int studentsInDatabase, int studentsDeleted, Scanner console) {
		int id = validationOfAnyIntNumber(console);

		for (int k = 0; k < (studentsInDatabase - studentsDeleted) ; k++) {
			for (int j = 0; j < (studentsInDatabase - studentsDeleted) ; j++) {
				while (id == databaseOfId[j]) {
					System.out.print("**This ID is allready founeded in the system so please enter another ID :- ");
					id = validationOfAnyIntNumber(console);
				}
			}
		}
		return id;
	}


	/**
	 * In this method, the user will enter the name of the city that the student lives in it and this city name will save in a string 
	 * variable to check, If the name that the user entered contains any numbers or symbols or not, If it contains the flag variable 
	 * will be false and the method will create a new string variable called city2 and the user will enter the name of the city and 
	 * check again. if it does not contain any number or any symbols the flag will be true and the method will save city2 in string city3
	 * and return it.
	 * 
	 * @param console
	 * @return the valid name of the city.
	 */
	public static String validationOfTheCity (Scanner console) {
		String city = console.next();

		boolean flag = false;
		for (int j = 0; j < city.length() ; j++) {
			if ((city.charAt(j) >= 'A' && city.charAt(j) <= 'Z') ||(city.charAt(j) >= 'a' && city.charAt(j) <= 'z')) {
				flag = true;
			} else {
				flag = false;
				break;
			}		
		}	
		if (flag == true) {
			return city;
		}

		String city3 = null;
		while (flag == false) {
			System.out.print("**Please enter the city again :- ");
			String city2 = console.next();

			for (int j = 0; j < city2.length() ; j++) {
				if ((city2.charAt(j) >= 'A' && city2.charAt(j) <= 'Z') ||(city2.charAt(j) >= 'a' && city2.charAt(j) <= 'z')) {
					flag = true;
				} else {
					flag = false;
					break;
				}		
			}
			if (flag == true) {
				city3 = city2;
			}	
		}
		return city3;
	}


	/**
	 * In this method, the user will enter a mobile number of the student and the method will check the validation of this number by calling
	 * (validationOfDigits method) after that the program will check if the mobile number that the user entered is taken or not if taken the
	 * method will prompt the user to enter another number and check its validation and so on.
	 * 
	 * @param databaseOfMobileNumbers
	 * @param studentsInDatabase
	 * @param studentsDeleted
	 * @param console
	 * @return the valid phone number
	 */
	public static String validationOfMobileNumber (String [] databaseOfMobileNumbers,int studentsInDatabase ,int studentsDeleted , Scanner console) {
		String number = validationOfDigits(console);

		for (int j = 0; j < (studentsInDatabase - studentsDeleted) ; j++) {
			for (int i = 0; i < (studentsInDatabase - studentsDeleted) ; i++) {
				while (number.equals(databaseOfMobileNumbers[i])) {
					System.out.print("**This mobile number is allready founded in the system so please enter another number :- ");
					number = validationOfDigits(console);
				}	
			}
		}
		return number;
	}


	/**
	 * This method check the validation of The Egyptian mobile numbers. 
	 * The Egyptian mobile number must start with 010, 011, 012, or 015 and the number of digits must be 11 digits so the program will check
	 * the number of the digits in the number and the first three digits (if it 010, 011, 012, 015 or not) and last 8 digits (if this 
	 * contain any letter or symbols or not) so if it contains letters or the number of digits less than or more than 11 digits or not start
	 * with 010, 011, 012, 015 the program will create a new String variable and prompt the user to enter the mobile number again and check 
	 * again and so on.
	 * 
	 * @param console
	 * @return moblie number as string.
	 */
	public static String validationOfDigits (Scanner console) {
		String number = console.next();
		
		// count the number of digits
		int digitsOfTheFirstCheck = 0;
		for (int i = 0; i < number.length(); i++) {
			digitsOfTheFirstCheck++;
		}

		boolean flag = false;
		if (((digitsOfTheFirstCheck == 11) && (number.charAt(0) == '0') && (number.charAt(1) == '1') && 
			(number.charAt(2) == '0' || number.charAt(2) == '1' || number.charAt(2) == '2' || number.charAt(2) == '5') && 
			(number.charAt(3) >= '0' && number.charAt(3) <= '9') && (number.charAt(4) >= '0' && number.charAt(4) <= '9') && 
			(number.charAt(5) >= '0' && number.charAt(5) <= '9') && (number.charAt(6) >= '0' && number.charAt(6) <= '9') && 
			(number.charAt(7) >= '0' && number.charAt(7) <= '9') && (number.charAt(8) >= '0' && number.charAt(8) <= '9') && 
			(number.charAt(9) >= '0' && number.charAt(9) <= '9') && (number.charAt(10) >= '0' && number.charAt(10) <= '9'))) {
			
			flag = true;
		}

		while (flag == false) {
			System.out.print("**You entered wrong mobile number so please enter the mobile again :- ");
			number = console.next();

			// count the number of digits
			int digitsOfTheSecondCheck = 0;
			for (int i = 0; i < number.length() ; i++) {
				digitsOfTheSecondCheck++;
			}

			if (((digitsOfTheSecondCheck == 11) && (number.charAt(0) == '0') && (number.charAt(1) == '1') && 
			(number.charAt(2) == '0' || number.charAt(2) == '1' || number.charAt(2) == '2' || number.charAt(2) == '5') && 
			(number.charAt(3) >= '0' && number.charAt(3) <= '9') && (number.charAt(4) >= '0' && number.charAt(4) <= '9') && 
			(number.charAt(5) >= '0' && number.charAt(5) <= '9') && (number.charAt(6) >= '0' && number.charAt(6) <= '9') && 
			(number.charAt(7) >= '0' && number.charAt(7) <= '9') && (number.charAt(8) >= '0' && number.charAt(8) <= '9') && 
			(number.charAt(9) >= '0' && number.charAt(9) <= '9') && (number.charAt(10) >= '0' && number.charAt(10) <= '9'))) {
			
			flag = true;
			break;
			}	
		}
		return number;
	}


	/**
	 * In this method, the user will enter the email address of the student and the method will check the validation of this email 
	 * address by calling (validationOfTheEmail_2) after that the method will check if the email that the user entered is taken or 
	 * not. if it has taken the method will prompt the user to enter another email and check its validation and so on.
	 * 
	 * @param databaseOfEmails
	 * @param studentsInDatabase
	 * @param studentsDeleted
	 * @param console
	 * @return the email address of the student to the system.
	 */
	public static String validationOfTheEmail_1 (String [] databaseOfEmails, int studentsInDatabase, int studentsDeleted, Scanner console) {
		String email = validationOfTheEmail_2(console);

		for (int i = 0; i < (studentsInDatabase - studentsDeleted) ; i++) {
			for (int j = 0; j < (studentsInDatabase - studentsDeleted); j++) { 
				while (email.equals(databaseOfEmails[j])) {
					System.out.print("**This Email is allready founded in the database so please enter the email again :- ");
					email = validationOfTheEmail_2(console);
				}
			}
		}
		return email;
	}


	/**
	 * In this method, the method will check if the email address is valid or not, if not valid the method will prompt the user to enter the
	 * email again and save this new email in a new string variable and check the validation, and so on.
	 * 
	 * @param console
	 * @return The valid syntax of email like (test@domain.com).
	 */
	public static String validationOfTheEmail_2 (Scanner console) {
		String email = console.next();
		int indexOfAt = 0, indexOfDot = 0;

        // to count  index of @ and index of dot (.)
		for (int i = 0; i < email.length() ; i++) {  
			if (email.charAt(i) == '@') {
				indexOfAt = i;
			}
			if (email.charAt(i) == '.') {
				indexOfDot = i;
			}
		}

		boolean flag = false;
		if (indexOfAt != 0 && indexOfDot != 0 && indexOfAt+1 < indexOfDot && indexOfAt != email.length()-1 && indexOfDot != email.length()-1) {
			flag = true;
			return email;
		}


		String email3 = null;
		while (flag == false) {
			System.out.print("**Please Enter The Email Again :- ");
			String email2 = console.next();
			int indexOfAt2 = 0, indexOfDot2 = 0;

			// to count the index of the (@) and the index of the (.) for the new email that the user entered
			for (int i = 0; i < email2.length() ; i++) {  
				if (email2.charAt(i) == '@') {
					indexOfAt2 = i;
				}
				if (email2.charAt(i) == '.') {
					indexOfDot2 = i;
				}
			}

			if (indexOfAt2 != 0 && indexOfDot2 != 0 && indexOfAt2+1 < indexOfDot2 && indexOfAt2 != email2.length()-1 && indexOfDot2 != email2.length()-1) {
				flag = true;
				email3 = email2;
				break;
			}
		}
		return email3;
	}


	/**
	 * In this method, the user will enter the age of the student and the method will check the validation of the numbers of the age by 
	 * calling (validationOfAnyIntNumber method) and after that, the program will check if the number is between 16 and 28 or not, If 
	 * not the method will prompt the user to enter the age again.
	 * 
	 * @param console
	 * @return the valid age to the system.
	 */
	public static int validationOfTheAge (Scanner console) {
		int age = validationOfAnyIntNumber(console);
		
		boolean flag = false;
		if (age >= 16 && age <= 28) {
			flag = true;
			return age;
		}

		int age3 = 0;
		while (flag == false) {
			System.out.print("**Please enter the correct age :- ");
			int age2 = validationOfAnyIntNumber(console);

			if (age2 >= 16 && age2 <= 28) {
				flag = true;
				age3 = age2;
				break;
			}
		}
		return age3;
	}


	/**
	 * In this method the user will enter the GPA of the student and the method will check the validation of the numbers on the GPA by 
	 * calling (validationOfGPA_2) and after that, the method will check if the number between 0.0 and 4.0 or not, if not the method will 
	 * prompt the user to enter the GPA again and check the validation and check the GPA validation again.
	 * 
	 * @param console
	 * @return the valid GPA to the system.
	 */
	public static double validationOfGPA_1 (Scanner console) {
		
		double gpa = validationOfGPA_2(console);

		boolean flag = false;
		if (gpa >= 0.0 && gpa <= 4.0) {
			flag = true;
			return gpa;
		}


		double gpa3 = 0.0;
		while (flag == false) {
			System.out.print("**Please enter GPA again between 0.0 and 4.0 :-");
			double gpa2 = validationOfGPA_2(console);

			if (gpa2 >= 0.0 && gpa2 <= 4.0) {
				flag = true;
				gpa3 = gpa2;
			}
		}
		return gpa3;
	}


	/**
	 * In this method, the user will enter the number and the method will check if the number is float or not. if it is not a float number 
	 * the method will prompt the user to enter the float number.
	 * 
	 * @param console - object of class Scanner.
	 * @return float number.
	 */
	public static double validationOfGPA_2 (Scanner console) {
		/*in this function the user will enter number and the function will check if the number contain any letter or symbols
		if it contain the function will prompt the user to enter double number and save it in string variable and check again
		and so on...*/
		String gpa = console.next();

		boolean flag = false;
		for (int i = 0; i < gpa.length() ; i++) {
			if ((gpa.charAt(i) >= '0' && gpa.charAt(i) <= '9') || (gpa.charAt(i) == '.')) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		if (flag == true) {
			double gpaDouble = Double.parseDouble(gpa);
			return gpaDouble;
		}


		double gpaDouble3 = 0.0;
		while (flag == false) {
			System.out.print("**You entered Letters so please enter double number :- ");
			String gpa2 = console.next();

			for (int i = 0; i < gpa2.length() ; i++) {
				if ((gpa2.charAt(i) >= '0' && gpa2.charAt(i) <= '9') || (gpa2.charAt(i) == '.')) {
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				double gpaDouble2 = Double.parseDouble(gpa2);
				gpaDouble3 = gpaDouble2;
				break;
			}
		}
		return gpaDouble3;
	} 


	/**
	 * In this method, the method will sort the students in the system by the ID of each students by using Bubble sort algorithm.
	 * only if the number of students in the database is more than one.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param fullName
	 * @param id
	 * @param city
	 * @param mobileNumber
	 * @param email
	 * @param age
	 * @param gpa
	 * @param gpaNormlize
	 * @param studentsDeleted
	 * @param studentsInDatabase
	 */
	public static void sortAndPrint (String [] firstName, String [] lastName, String [] fullName, int [] id, String [] city, String [] mobileNumber
		, String [] email, int [] age, double [] gpa, boolean [] gpaNormlize, int studentsDeleted, int studentsInDatabase) {

		if ((studentsInDatabase -  studentsDeleted) > 1) {
			for (int i = 0; i < (studentsInDatabase - studentsDeleted); i++) {
				for (int j = 0; j < (studentsInDatabase - studentsDeleted - 1); j++) {
					if (id[j] > id[j+1]) {

						String tempFirstName = firstName[j];
						firstName[j] = firstName[j+1];
						firstName[j+1] = tempFirstName;

						String tempLastName = lastName[j];
						lastName[j] = lastName[j+1];
						lastName[j+1] = tempLastName;

						String tempFullName = fullName[j];
						fullName[j] = fullName[j+1];
						fullName[j+1] = tempFullName;

						int tempId = id[j];
						id[j] = id[j+1];
						id[j+1] = tempId;

						String tempCity = city[j];
						city[j] = city[j+1];
						city[j+1] = tempCity;

						String tempMobileNumber = mobileNumber[j];
						mobileNumber[j] = mobileNumber[j+1];
						mobileNumber[j+1] = tempMobileNumber;

						String tempEmail = email[j];
						email[j] = email[j+1];
						email[j+1] = tempEmail;

						int tempAge = age[j];
						age[j] = age[j+1];
						age[j+1] = tempAge;

						double tempGPA = gpa[j];
						gpa[j] = gpa[j+1];
						gpa[j+1] = tempGPA;

						boolean tempNormalize = gpaNormlize[j];
						gpaNormlize[j] = gpaNormlize[j+1];
						gpaNormlize[j+1] = tempNormalize;
					}
				}
			}
			// after sorting the function will call another function called print to print all the students in the system.
			print(fullName, id, city, mobileNumber, email, age, gpa, studentsDeleted, studentsInDatabase);
		} else if ((studentsInDatabase - studentsDeleted) >= 1) {
			print(fullName, id, city, mobileNumber, email, age, gpa, studentsDeleted, studentsInDatabase);
		} else {
			System.out.println("No student has been recorded in the database.");
		}
	}


	/**
	 * This method print the students data.
	 * 
	 * @param fullName
	 * @param id
	 * @param city
	 * @param mobileNumber
	 * @param email
	 * @param age
	 * @param gpa
	 * @param studentsDeleted
	 * @param studentsInDatabase
	 */
	public static void print ( String [] fullName, int [] id, String [] city, String [] mobileNumber, 
		String [] email, int [] age, double [] gpa, int studentsDeleted, int studentsInDatabase) {
	 	for (int i = 0; i < (studentsInDatabase - studentsDeleted); i++) {
	 		System.out.println("Name :- "+ fullName[i] +"   ID :- "+ id[i] +"   City :- "+ city[i] +"   Mobile :- "+ mobileNumber[i] +"   Email :- "+ email[i] +"   Age :- "+ age[i] +"   GPA :- "+ gpa[i]);
	 	}
	}


	/**
	 * In this method, the user can add 0.2 to all GPAs less than 2.0.
	 * 
	 * @param gpa
	 * @param studentsDeleted
	 * @param studentsInDatabase
	 */
	public static void halfLoad (double [] gpa, int studentsDeleted, int studentsInDatabase ) {
		if ((studentsInDatabase - studentsDeleted) >= 1) {
			for (int i = 0; i < (studentsInDatabase - studentsDeleted); i++) {
				if (gpa[i] < 2.0) {
					gpa[i] += 0.2;
				}
			}
			System.out.println("Successfully half-Loaded.");
		} else {
			System.out.println("No student has been recorded in the database.");
		}
	}


	/**
	 * This method calculates the average GPAs of the students in the system then adds 5% of it to all of the students.
	 * 
	 * Note: The maximum GPA is 4.0 
	 * 
	 * @param gpa
	 * @param gpaNormlize
	 * @param studentsDeleted
	 * @param studentsInDatabase
	 */
	public static void normalize (double [] gpa, boolean [] gpaNormlize, int studentsDeleted, int studentsInDatabase) {
		if ((studentsInDatabase - studentsDeleted) >= 1) {
			double sum = 0;
			for (int i = 0; i < (studentsInDatabase - studentsDeleted) ; i++) {
				sum += gpa[i];
			}
			double average = sum/ (studentsInDatabase - studentsDeleted);
			double fivePerceint = (average * 5)/100; // calc. 5% of average

			for (int i = 0; i < (studentsInDatabase - studentsDeleted); i++) {
				double test = gpa[i] + fivePerceint;
				if (gpaNormlize[i] == false && test < 4.0) {
					gpa[i] = test;
					gpaNormlize[i] = true;
				} else if (gpaNormlize[i] == false && test > 4.0){
					// calc. the percentage allowed for the student and added it to the gpa of the student
					double perceint = test - 4.0;
					gpa[i] = test - perceint;
					gpaNormlize[i] = true;
				} else if (gpa[i] == 4.0) {
					gpa[i] += 0.0;
				}
			}
			System.out.println("Successfully Normalize");
		} else {
			System.out.println("No student has been recorded in the database.");
		}
	}


	/**
	 * In this method, the user will be prompted to enter an id of the student to search in the system for this student. the id is entered 
	 * as a string to check if it is valid or not, and if it is valid the id will convert to an integer number and save to int variable 
	 * called (idInteger) and search in the system about this id if it found the method will print all information about the student. if 
	 * not found the method will print "the id is not founded in the system".
	 * 
	 * @param fullName
	 * @param id
	 * @param city
	 * @param mobileNumber
	 * @param email
	 * @param age
	 * @param gpa
	 * @param studentsDeleted
	 * @param studentsInDatabase
	 * @param console
	 */
	public static void search (String [] fullName, int [] id, String [] city, String [] mobileNumber, 
		String [] email, int [] age, double [] gpa, int studentsDeleted, int studentsInDatabase, Scanner console) {
		
		if ((studentsInDatabase - studentsDeleted) >= 1) {
			System.out.print("Please Enter the ID that you want to search on it :- ");
	 		int search = validationOfAnyIntNumber(console);
	 		
	 		boolean flag = false; 

			for (int i = 0; i < (studentsInDatabase - studentsDeleted); i++) {
				if (search == id[i]) {
					System.out.println();
					System.out.println("Name of the Student is " + fullName[i]);
					System.out.println("ID of the Student is " + id[i]);
					System.out.println("City that the Student live in it is " + city[i]);
					System.out.println("Mobile Number of the Student is " + mobileNumber[i]);
					System.out.println("Email of the Student is " + email[i]);
					System.out.println("Age of the Student is " + age[i]);
					System.out.println("GPA of the Student is " + gpa[i]);
					flag = true;

					System.out.println();
					break;
				}
			}

			if (flag == false) {
				System.out.println("The ID Not Found in system.");
			}
		} else {
			System.out.println("No student has been recorded in the database.");
		}
	} 	


	/**
	 * This method update the GPA of student.
	 * 
	 * @param gpa
	 * @param gpaNormlize
	 * @param id
	 * @param studentsDeleted
	 * @param studentsInDatabase
	 * @param console
	 */
	public static void upDateGPA (double [] gpa, boolean [] gpaNormlize, int [] id, int studentsDeleted, int studentsInDatabase, Scanner console) {
		if ((studentsInDatabase - studentsDeleted) >= 1) {
			System.out.print("Please enter the ID of student that you want to update it :- ");
			int search = validationOfAnyIntNumber(console);

			boolean flag = false;
	 		for (int i = 0; i < (studentsInDatabase - studentsDeleted); i++) {
	 			if (search == id[i]) {
	 				System.out.print("Please enter the new GPA that you want to update it to this student :- ");
	 				gpa[i] = validationOfGPA_1(console); 
	 				gpaNormlize[i] = false;
	 				flag = true;
	 				break;
	 			}
	 		}
	 		if (flag == true) {
	 			System.out.println("Successfully updated.");
	 		}
	 		if (flag == false) {
	 			System.out.println("The ID Not Found in system.");
	 		}
		} else {
			System.out.println("No student has been recorded in the system.");
		}
	}


	/**
	 * Delete Student from the system.
	 * 
	 * @param firstName
	 * @param lastName
	 * @param fullName
	 * @param id
	 * @param city
	 * @param mobileNumber
	 * @param email
	 * @param age
	 * @param gpa
	 * @param gpaNormlize
	 * @param studentsDeleted
	 * @param studentsInDatabase
	 * @param sizeOfDatabase
	 * @param console
	 * @return one to the number studentsDeleted (studnetsDeleted++).
	 */
	public static int delete (String [] firstName, String [] lastName, String [] fullName, int [] id, String [] city, String [] mobileNumber
		, String [] email, int [] age, double [] gpa, boolean [] gpaNormlize, int studentsDeleted, int studentsInDatabase, int sizeOfDatabase, Scanner console) {

		if ((studentsInDatabase - studentsDeleted) >= 1) {
			System.out.print("Enter the ID of the student that you want to delete it :- ");
			int idOfStudent = validationOfAnyIntNumber(console);
			int indexOfId = -1;
			boolean flag = false;


	 		for (int i = 0; i < (studentsInDatabase - studentsDeleted); i++) {
	 			if (idOfStudent == id[i]) {
	 				indexOfId = i;
	 				flag = true;
	 				break;
	 			}
	 		}
	 		if (flag == true) {
	 			int counter = 1;
				for (int i = indexOfId; i < (studentsInDatabase -1); i++) {
					firstName[i] = firstName[i+1];
					lastName[i] = lastName[i+1];
					fullName[i] = fullName[i+1];
					id[i] = id[i+1];
					city[i] = city[i+1];
					mobileNumber[i] = mobileNumber[i+1];
					email[i] = email[i+1];
					age[i] = age[i+1];
					gpa[i] = gpa[i+1];
					gpaNormlize[i] = gpaNormlize[i+1];
				}
				System.out.println("Successfully deleted.");
				return counter;
 			} 
 			if (flag == false) {
 				System.out.println("The ID Not Found in system.");
 				return 0;
 			}
		} else {
			System.out.println("No student has been recorded in the system.");
		}
		return 0;
	}


	/**
	 * This method print statistics (average, highest GPA in the system, information about that have the highest GPA in the system and lowest one).
	 * 
	 * @param firstName
	 * @param lastName
	 * @param fullName
	 * @param id
	 * @param city
	 * @param mobileNumber
	 * @param email
	 * @param age
	 * @param gpa
	 * @param gpaNormlize
	 * @param studentsDeleted
	 * @param studentsInDatabase
	 */
	public static void statistics ( String [] firstName, String [] lastName, String [] fullName, int [] id, String [] city, String [] mobileNumber, String [] email, int [] age
		, double [] gpa, boolean [] gpaNormlize, int studentsDeleted, int studentsInDatabase) {

		if ((studentsInDatabase - studentsDeleted) >= 5) {
			for (int i = 0; i < (studentsInDatabase - studentsDeleted); i++) {
				for (int j = 0; j < (studentsInDatabase - studentsDeleted - 1); j++) {
					if (gpa[j] < gpa[j+1]) {

						String tempFirstName = firstName[j];
						firstName[j] = firstName[j+1];
						firstName[j+1] = tempFirstName;

						String tempLastName = lastName[j];
						lastName[j] = lastName[j+1];
						lastName[j+1] = tempLastName;

						String tempFullName = fullName[j];
						fullName[j] = fullName[j+1];
						fullName[j+1] = tempFullName;

						int tempId = id[j];
						id[j] = id[j+1];
						id[j+1] = tempId;

						String tempCity = city[j];
						city[j] = city[j+1];
						city[j+1] = tempCity;

						String tempMobileNumber = mobileNumber[j];
						mobileNumber[j] = mobileNumber[j+1];
						mobileNumber[j+1] = tempMobileNumber;

						String tempEmail = email[j];
						email[j] = email[j+1];
						email[j+1] = tempEmail;

						int tempAge = age[j];
						age[j] = age[j+1];
						age[j+1] = tempAge;

						double tempGPA = gpa[j];
						gpa[j] = gpa[j+1];
						gpa[j+1] = tempGPA;

						boolean tempNormalize = gpaNormlize[j];
						gpaNormlize[j] = gpaNormlize[j+1];
						gpaNormlize[j+1] = tempNormalize;
					}
				}
			}
			double sum = 0;
			for (int i = 0; i < (studentsInDatabase - studentsDeleted) ; i++) {
				sum += gpa[i];
			}
			double average = sum / (studentsInDatabase - studentsDeleted);
			for (int i = 0; i < 5 ; i++) {
				System.out.println("The " + (i+1) + "st place is " + fullName[i] + " and his/her ID is " + id[i] + " and his/her GPA is " + gpa[i]);
			}
			System.out.println("The max grade equal " + gpa[0]);
			System.out.println("The min grade equal " + gpa[studentsInDatabase - studentsDeleted - 1]);
			System.out.println("The average equal " + average);
		} else if ((studentsInDatabase - studentsDeleted) < 5 && (studentsInDatabase - studentsDeleted) >= 1) {
			System.out.println("The program can not do statistics because number of students less than 5 in the system.");
		} else if ((studentsInDatabase - studentsDeleted) == 0) {
			System.out.println("No student has been recorded in the system.");
		}
	}
}
