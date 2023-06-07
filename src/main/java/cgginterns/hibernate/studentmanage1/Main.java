package cgginterns.hibernate.studentmanage1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		DAO d = new DAO();
		Scanner sc = new Scanner(System.in);

		StudentSS s1 = new StudentSS();
		while (true) {
			System.out.println("Press 1 to add student");
			System.out.println("Press 2 to update student");
			System.out.println("Press 3 to delete student");
			System.out.println("Press 4 to display all students");
			System.out.println("Press 5 to exit");

			System.out.println("enter your choice");
			int ch = sc.nextInt();

			if (ch == 1) {
				// add
				System.out.println("Enter name: ");
				String name = sc.next();
				System.out.println("Enter city: ");
				String city = sc.next();
				System.out.println("Enter phone: ");
				int ph = sc.nextInt();

				s1.setStudentName(name);
				s1.setStudentCity(city);
				s1.setStudentPhone(ph);

				DAO.saveStudent(s1);
			} else if (ch == 2) {
				// update
				System.out.println("Enter 1 to update name, 2 to update city, 3 to update phone");
				int update = sc.nextInt();
				System.out.println("Enter student's id to update");
				int i= sc.nextInt();
				switch (update) {
				case 1: {
					System.out.println("Enter student's new name: ");
					String name = sc.next();


					DAO.updateStudentName(name,i);
					break;
				}
				case 2: {
					System.out.println("Enter student's new city: ");
					String city = sc.next();


					DAO.updateStudentCity(city,i);
					break;
				}
				case 3: {
					System.out.println("Enter student's new phone: ");
					int ph = sc.nextInt();

					DAO.updateStudentPhone(ph,i);
					break;
				}

				}
			} else if (ch == 3) {
				// delete
				System.out.println("Enter student id to delete: ");
				int s = sc.nextInt();

				DAO.deleteStudent(s);
				
			} else if (ch == 4) {

				DAO.getAllStudents();

			}
			else {
				System.out.println("Thank you for using the app");
				System.out.println("----------------See you again--------------");
				break;
			}
		}
		
		

	}

}
