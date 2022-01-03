package com.vti.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.backend.utils.ScannerUtils;
import com.vti.entity.abstraction.News;

public class MyNews {
	Scanner scanner = new Scanner(System.in);
	List<News> newsLists = new ArrayList<>();

	public MyNews() {
		newsLists.add(new News("No way home", "2021/4/14", "Tom Holland", "Marvel", 3, 4, 5));
		newsLists.add(new News("Avengers", "2021/4/15", "Tony Stark", "Marvel", 1, 4, 2));
		newsLists.add(new News("The Winter Soldier", "2021/4/16", "Steve Roger", "Marvel", 1, 5, 4));
		newsLists.add(new News("In the multiverse of madness", "2021/4/17", "Doctor Strange", "Marvel", 2, 3, 1));
	}

	private void insertNews() {
		System.out.println("Please enter the title of the news:");
		String titleInput = scanner.nextLine();
		System.out.println("Please enter the published date of the news:");
		String publishDateInput = scanner.nextLine();
		System.out.println("Please enter the author of the news:");
		String authorInput = scanner.nextLine();
		System.out.println("Please enter the content of the news:");
		String contentInput = scanner.nextLine();

		insert(titleInput, publishDateInput, authorInput, contentInput);

	}

	private void insert(String title, String publishDate, String author, String content) {
		News new1 = new News(title, publishDate, author, content);
		System.out.println("News created successfully:");
		new1.display();
	}

	private void viewNewsList() {
		System.out.println("Here is all the news:");
		for (News n : newsLists) {
			System.out.println(n.getTitle());
		}
	}
	
	private void getAverageRates() {
		System.out.println("Please enter the ID of the news you want to get average rates:");
		int id = ScannerUtils.inputID("ID must be an integer and greater than 0");
		for (News n : newsLists) {
			if(n.getId() == id) {
				n.display();
			}
		}
	}

	public void Question1() {
		System.out.println("-------Question 1-------");
		while(true) {
			System.out.println("Please choose the function you want use:");
			System.out.println("(1) Insert a news");
			System.out.println("(2) View news list");
			System.out.println("(3) Get average rates");
			System.out.println("(4) Exit");
			int choice = ScannerUtils.inputInt("Please try again!", 0, 5);
			switch (choice) {
			case 1:
				insertNews();
				break;
			case 2:
				viewNewsList();
				break;
			case 3:
				getAverageRates();
				break;
			default:
				return;
			}
		}
	}
}
