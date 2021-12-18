package com.vti.entity.inheritance;

import java.util.Scanner;

public class StaffManagement {
	
	public void addStaff() {
		System.out.println("Select the Staff you want to add.");
		System.out.println("(1) Engineer");
		System.out.println("(2) Employee");
		System.out.println("(3) Worker");
		
		Scanner scanner = new Scanner(System.in);
		boolean isCorrect1 = true;
		while(isCorrect1) {
			String s = scanner.nextLine();
			switch(s) {
				case "1":
					System.out.println("Please enter the engineer's full name:");
					String fullNameInput1 = scanner.nextLine();
					System.out.println("Please enter the engineer's gender(MALE, FEMALE):");
					String genderInput1 = scanner.nextLine();
					System.out.println("Please enter the engineer's address:");
					String addressInput1 = scanner.nextLine();
					System.out.println("Please enter the engineer's speciality:");
					String specialityInput1 = scanner.nextLine();
					System.out.println("Please enter the engineer's age:");
					boolean isCorrect2 = true;
					while(isCorrect2) {
						// tien hanh vong while buoc nguoi dung nhap dung input tuoi
						boolean shn = scanner.hasNextInt();
						String ageInput1 = scanner.nextLine();
						if(shn) {
							if(Integer.parseInt(ageInput1) > 0) {
								Engineer engineer = new Engineer(fullNameInput1, Integer.parseInt(ageInput1), null, addressInput1, specialityInput1);
								
								if(genderInput1.equals("MALE")) {
									engineer.setGender(Gender.MALE);
								} else if (genderInput1.equals("FEMALE")) {
									engineer.setGender(Gender.FEMALE);
								} else {
									engineer.setGender(Gender.UNKNOWN);
								}
								System.out.println("Engineer's account has been created successfully: ");
								System.out.println(engineer.toString());
								isCorrect2 = false;
							} else {
								System.out.println("Please try again!");
							}
						} else {
							System.out.println("Please try again!");
						}
					}
					isCorrect1 = false;
					break;
				case "2":
					System.out.println("Please enter the employee's full name:");
					String fullNameInput2 = scanner.nextLine();
					System.out.println("Please enter the employee's gender(MALE, FEMALE):");
					String genderInput2 = scanner.nextLine();
					System.out.println("Please enter the employee's address:");
					String addressInput2 = scanner.nextLine();
					System.out.println("Please enter the employee's job:");
					String jobInput = scanner.nextLine();
					System.out.println("Please enter the employee's age:");
					boolean isCorrect3 = true;
					while(isCorrect3) {
						// tien hanh vong while buoc nguoi dung nhap dung input tuoi
						boolean shn = scanner.hasNextInt();
						String ageInput2 = scanner.nextLine();
						if(shn) {
							if(Integer.parseInt(ageInput2) > 0) {
								Employee employee = new Employee(fullNameInput2, Integer.parseInt(ageInput2), null, addressInput2, jobInput);
								
								if(genderInput2.equals("MALE")) {
									employee.setGender(Gender.MALE);
								} else if (genderInput2.equals("FEMALE")) {
									employee.setGender(Gender.FEMALE);
								} else {
									employee.setGender(Gender.UNKNOWN);
								}
								System.out.println("Employee's account has been created successfully: ");
								System.out.println(employee.toString());
								isCorrect3 = false;
							} else {
								System.out.println("Please try again!");
							}
						} else {
							System.out.println("Please try again!");
						}
					}
					isCorrect1 = false;
					break;
				case "3":
					System.out.println("Please enter the worker's full name:");
					String fullNameInput3 = scanner.nextLine();
					System.out.println("Please enter the worker's gender(MALE, FEMALE):");
					String genderInput3 = scanner.nextLine();
					System.out.println("Please enter the worker's address:");
					String addressInput3 = scanner.nextLine();
	
					System.out.println("Please enter the worker's age:");
					boolean isCorrect4 = true;
					while(isCorrect4) {
						// tien hanh vong while buoc nguoi dung nhap dung input tuoi
						boolean shn1 = scanner.hasNextInt();
						String ageInput3 = scanner.nextLine();
						if(shn1) {
							if(Integer.parseInt(ageInput3) > 0) {			
								System.out.println("Please enter the worker's level(1 - 10):");
								boolean isCorrect5 = true;
								while(isCorrect5) {
									// tien hanh vong while buoc nguoi dung nhap dung input level
									boolean shn2 = scanner.hasNextInt();
									String levelInput = scanner.nextLine();
									if(shn2) {
										if(Integer.parseInt(levelInput) > 0 && Integer.parseInt(levelInput) < 11) {
											Worker worker = new Worker(fullNameInput3, Integer.parseInt(ageInput3), null, addressInput3, Integer.parseInt(levelInput));
											
											if(genderInput3.equals("MALE")) {
												worker.setGender(Gender.MALE);
											} else if (genderInput3.equals("FEMALE")) {
												worker.setGender(Gender.FEMALE);
											} else {
												worker.setGender(Gender.UNKNOWN);
											}
											System.out.println("Worker's account has been created successfully: ");
											System.out.println(worker.toString());
											isCorrect4 = false;
											isCorrect5 = false;
										} else {
											System.out.println("Please try again!");
										}
									} else {
										System.out.println("Please try again!");
									}
								}
							} else {
								System.out.println("Please try again!");
							}
						} else {
							System.out.println("Please try again!");
						}
					}
					isCorrect1 = false;
					break;
				default:
					System.out.println("Please try again!");
			}
		}

	}

	public void searchStaff() {
		Staff[] staff = new Staff[9];
		staff[1] = new Engineer("Lyda Fearby", 30, Gender.MALE, "54950 Springview Drive", "Programing");
		staff[2] = new Engineer("Phillie Malcolm", 26, Gender.FEMALE, "67 Porter Point", "Web Designing");
		staff[3] = new Engineer("Marwin Abrahamsohn", 22, Gender.MALE, "74928 Lien Parkway", "IT");
		
		staff[4] = new Employee("Ginni Pamphilon", 26, Gender.FEMALE, "76674 Ilene Place", "Editor");
		staff[5] = new Employee("Ivan Kenion", 40, Gender.MALE, "0432 Fisk Parkway", "Assistant Manager");
		staff[6] = new Employee("Phelia Dearnaly", 33, Gender.FEMALE, "43 Dayton Center", "Sales Representative");
		
		staff[7] = new Worker("Vin Collett", 18, Gender.UNKNOWN, "69 Sundown Center", 1);
		staff[8] = new Worker("Rayna Ottley", 20, Gender.MALE, "411 Longview Avenue", 3);
		staff[9] = new Worker("Barret Walne", 29, Gender.FEMALE, "5 Starling Trail", 6);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the staff's full name:");
		String fullNameInput = scanner.nextLine();
		for (Staff s : staff) {
			if(s.getFullName().equals(fullNameInput)) {
				System.out.println("The information of the staff you just entered is:");
				System.out.println(s.toString());
			}
		}
		
	}

	public void getAllStaff() {
		Staff[] staff = new Staff[9];
		staff[1] = new Engineer("Lyda Fearby", 30, Gender.MALE, "54950 Springview Drive", "Programing");
		staff[2] = new Engineer("Phillie Malcolm", 26, Gender.FEMALE, "67 Porter Point", "Web Designing");
		staff[3] = new Engineer("Marwin Abrahamsohn", 22, Gender.MALE, "74928 Lien Parkway", "IT");
		
		staff[4] = new Employee("Ginni Pamphilon", 26, Gender.FEMALE, "76674 Ilene Place", "Editor");
		staff[5] = new Employee("Ivan Kenion", 40, Gender.MALE, "0432 Fisk Parkway", "Assistant Manager");
		staff[6] = new Employee("Phelia Dearnaly", 33, Gender.FEMALE, "43 Dayton Center", "Sales Representative");
		
		staff[7] = new Worker("Vin Collett", 18, Gender.UNKNOWN, "69 Sundown Center", 1);
		staff[8] = new Worker("Rayna Ottley", 20, Gender.MALE, "411 Longview Avenue", 3);
		staff[9] = new Worker("Barret Walne", 29, Gender.FEMALE, "5 Starling Trail", 6);
		
		System.out.println("Information of all staffs:");
		for (Staff staff2 : staff) {
			System.out.println("\n" + staff2.toString());
		}
	}

	public void deleteStaff() {
		Staff[] staff = new Staff[9];
		staff[1] = new Engineer("Lyda Fearby", 30, Gender.MALE, "54950 Springview Drive", "Programing");
		staff[2] = new Engineer("Phillie Malcolm", 26, Gender.FEMALE, "67 Porter Point", "Web Designing");
		staff[3] = new Engineer("Marwin Abrahamsohn", 22, Gender.MALE, "74928 Lien Parkway", "IT");
		
		staff[4] = new Employee("Ginni Pamphilon", 26, Gender.FEMALE, "76674 Ilene Place", "Editor");
		staff[5] = new Employee("Ivan Kenion", 40, Gender.MALE, "0432 Fisk Parkway", "Assistant Manager");
		staff[6] = new Employee("Phelia Dearnaly", 33, Gender.FEMALE, "43 Dayton Center", "Sales Representative");
		
		staff[7] = new Worker("Vin Collett", 18, Gender.UNKNOWN, "69 Sundown Center", 1);
		staff[8] = new Worker("Rayna Ottley", 20, Gender.MALE, "411 Longview Avenue", 3);
		staff[9] = new Worker("Barret Walne", 29, Gender.FEMALE, "5 Starling Trail", 6);
		
		System.out.println("Select the staff you want to delete:\n");
		for (Staff staff2 : staff) {
			System.out.println(staff2.getFullName());
		}
		Scanner scanner = new Scanner(System.in);
		String fullNameInput = scanner.nextLine();
		for (Staff s : staff) {
			if(s.getFullName().equals(fullNameInput)) {
				s = null;
			}
		}
	}
}

















