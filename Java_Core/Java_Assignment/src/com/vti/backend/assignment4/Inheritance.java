package com.vti.backend.assignment4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.inheritance.Book;
import com.vti.entity.inheritance.Document;
import com.vti.entity.inheritance.HighSchoolStudent;
import com.vti.entity.inheritance.Magazine;
import com.vti.entity.inheritance.Newspaper;
import com.vti.entity.inheritance.StaffManagement;

public class Inheritance {
	List<Document> documents = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public Inheritance() {
		documents.add(new Book(113, "Vidoo", 10328, "Norry Rappa", 5271));
		documents.add(new Book(436, "Flipbug", 2365, "Greg Lawrinson", 6581));
		documents.add(new Book(341, "Eayo", 97598, "Corbet Pottie", 3451));
		documents.add(new Magazine(2435, "InnoZ", 5591, 2223, 11));
		documents.add(new Magazine(6742, "Digitube", 5481, 5678, 10));
		documents.add(new Magazine(9341, "Kamba", 1452, 5621, 4));
		documents.add(new Newspaper(12351, "Voonix", 4985, 15));
		documents.add(new Newspaper(23356, "Tagcat", 3832, 22));
		documents.add(new Newspaper(67823, "Digitube", 6334, 6));
		documents.add(new Newspaper(86357, "Quire", 5621, 17));
	}

	public void Question1() {
		System.out.println("-------Question 1-------");
		System.out.println("Create 3 classes in com.vti.entity.inheritance");
	}

	public void Question2() {
		StaffManagement sm = new StaffManagement();

		boolean isCorrect = true;
		while (isCorrect) {
			System.out.println("-------Question 2-------");
			System.out.println("Please select one of the following functions:");
			System.out.println("(1) Add a new Staff Account");
			System.out.println("(2) Search for information of a staff");
			System.out.println("(3) Show information of all staffs");
			System.out.println("(4) Delete a staff");
			System.out.println("(5) Quit");
			boolean shn = sc.hasNextInt();
			String selectInput = sc.nextLine();
			if (shn && Integer.parseInt(selectInput) > 0 && Integer.parseInt(selectInput) <= 5) {
				switch (Integer.parseInt(selectInput)) {
				case 1:
					sm.addStaff();
					break;
				case 2:
					sm.searchStaff();
					break;
				case 3:
					sm.getAllStaff();
					break;
				case 4:
					sm.deleteStaff();
					break;
				default:
					System.out.println("See you again!");
					isCorrect = false;
				}

			} else {
				System.out.println("Please try again!");
			}
		}
	}

	public void Question3() {
		System.out.println("-------Question 3-------");
		HighSchoolStudent hsstudent = new HighSchoolStudent("Hoàng Nam", 1, "Chuyên Văn", "Đại học Công Nghệ");
		System.out.println(hsstudent.toString());
	}

	public void addDocument() {
		boolean isCorrect = true;
		while (isCorrect) {
			System.out.println("Please select the type of the document you want to add:");
			System.out.println("(1) Book");
			System.out.println("(2) Magazine");
			System.out.println("(3) Newspaper");
			boolean shn = sc.hasNextInt();
			String typeInput = sc.nextLine();
			if (shn && Integer.parseInt(typeInput) > 0 && Integer.parseInt(typeInput) < 4) {
				if (Integer.parseInt(typeInput) == 1) {
					System.out.println("Please enter the ID:");
					int IdInput = sc.nextInt();
					sc.nextLine();
					System.out.println("Please enter the  Publisher:");
					String publisherInput = sc.nextLine();
					System.out.println("Please enter the name of the author:");
					String authorInput = sc.nextLine();
					System.out.println("Please enter the number of copies:");
					int numberOfCopyInput = sc.nextInt();
					System.out.println("Please enter the number of pages:");
					int numberOfPageInput = sc.nextInt();
					Book book = new Book(IdInput, publisherInput, numberOfCopyInput, authorInput, numberOfPageInput);
					documents.add(book);
					System.out.println("Created successfully!");
					System.out.println(book.toString());
					isCorrect = false;
					sc.nextLine();
				} else if (Integer.parseInt(typeInput) == 2) {
					System.out.println("Please enter the ID:");
					int IdInput = sc.nextInt();
					sc.nextLine();
					System.out.println("Please enter the Publisher:");
					String publisherInput = sc.nextLine();
					System.out.println("Please enter the number of copies:");
					int numberOfCopyInput = sc.nextInt();
					System.out.println("Please enter the published ID:");
					int publishedIdInput = sc.nextInt();
					System.out.println("Please enter the published month:");
					int publishedMonthInput = sc.nextInt();
					Magazine magazine = new Magazine(IdInput, publisherInput, numberOfCopyInput, publishedIdInput,
							publishedMonthInput);
					documents.add(magazine);
					System.out.println("Created successfully!");
					System.out.println(magazine.toString());
					isCorrect = false;
					sc.nextLine();
				} else {
					System.out.println("Please enter the ID:");
					int IdInput = sc.nextInt();
					sc.nextLine();
					System.out.println("Please enter the Publisher:");
					String publisherInput = sc.nextLine();
					System.out.println("Please enter the number of copies:");
					int numberOfCopyInput = sc.nextInt();
					System.out.println("Please enter the published date:");
					int publishedDateInput = sc.nextInt();
					Newspaper newspaper = new Newspaper(IdInput, publisherInput, numberOfCopyInput, publishedDateInput);
					documents.add(newspaper);
					System.out.println("Created successfully!");
					System.out.println(newspaper.toString());
					isCorrect = false;
					sc.nextLine();
				}
			} else {
				System.out.println("Please try again!");
			}
		}
	}

	public void removeDocument() {
		System.out.println("Select the id of the document you want to delete");
		for (Document d : documents) {
			System.out.println(d.getId());
		}
		boolean isCorrect = true;
		while (isCorrect) {
			boolean shn = sc.hasNextInt();
			String id = sc.nextLine();
			if (shn) {
				Document selected = null;
				for (Document d : documents) {
					if (d.getId() == Integer.parseInt(id)) {
						selected = d;
					}
				}
				documents.remove(selected);
				System.out.println("Document deleted!");
				for (Document d : documents) {
					System.out.println(d.toString() + "\n");
				}
			} else {
				System.out.println("Please try again!");
			}
		}
	}

	public void showAllDocument() {
		System.out.println("Here are all the documents:");
		for (Document d : documents) {
			System.out.println(d.toString() + "\n");
		}
	}

	public void searchDocumentByType() {
		System.out.println("Enter the type of document you want to find (Book, Magazine, Newspaper): ");
		boolean isCorrect = true;
		while (isCorrect) {
			String typeInput = sc.nextLine();
			switch (typeInput) {
			case "Book":
				for (Document d : documents) {
					if (d instanceof Book) {
						System.out.println(d.toString() + "\n");
					}
				}
				isCorrect = false;
				break;
			case "Magazine":
				for (Document d : documents) {
					if (d instanceof Magazine) {
						System.out.println(d.toString() + "\n");
					}
				}
				isCorrect = false;
				break;
			case "Newspaper":
				for (Document d : documents) {
					if (d instanceof Newspaper) {
						System.out.println(d.toString() + "\n");
					}
				}
				isCorrect = false;
				break;
			default:
				System.out.println("Please try again!");
			}
		}
	}

	public void Question4() {
		boolean isCorrect = true;
		while (isCorrect) {
			System.out.println("Please select the function you want to use");
			System.out.println("(1) Add a document");
			System.out.println("(2) Remove a document");
			System.out.println("(3) Show all the documents");
			System.out.println("(4) Search documents by type");
			System.out.println("(5) Quit!");
			boolean shn = sc.hasNextInt();
			String s = sc.nextLine();
			if (shn && Integer.parseInt(s) > 0 && Integer.parseInt(s) < 6) {
				switch (s) {
				case "1":
					addDocument();
					break;
				case "2":
					removeDocument();
					break;
				case "3":
					showAllDocument();
					break;
				case "4":
					searchDocumentByType();
					break;
				default:
					System.out.println("See you again!");
					isCorrect = false;
				}
			} else {
				System.out.println("Please try again!");
			}
		}
	}

	public void Question5() {
		Scanner scanner = new Scanner(System.in);
		boolean isCorrect = true;
		int age = 0;

		while (isCorrect) {
			System.out.print("Nhap vao tuoi: ");
			try {
				age = scanner.nextInt();
				if (age > 0) {
					System.out.println("Tuoi la: " + age);
					isCorrect = false;
				} else {
					System.err.println("Tuoi phai lon hon 0");
				}

			} catch (InputMismatchException e) {
				System.err.println("Error!");
			} finally {
				scanner.nextLine();
			}

		}
		scanner.close();
	}
}
