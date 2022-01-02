package com.vti.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.abstraction.News;

public class MyNews {
	Scanner scanner = new Scanner(System.in);
	List<News> newsLists = new ArrayList<>();

	public MyNews() {
		newsLists.add(new News(null, null, null, null));
		newsLists.add(new News(null, null, null, null));
		newsLists.add(new News(null, null, null, null));
		newsLists.add(new News(null, null, null, null));
	}

	public void insertNews() {
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

	public void viewListNews() {
		System.out.println("Here is all the news:");
		for (News n : newsLists) {
			n.display();
			System.out.println("");
		}
	}
}
