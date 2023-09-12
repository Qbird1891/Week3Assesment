package controller;

import java.util.Scanner;

import model.Cars;

/**
 * @author Itsal - Quinn Birdsley CIS175 - Fall 2023 Sep 11, 2023
 */
public class PersistantDriver {
	CarsHelper helper = new CarsHelper();

	public static void main(String[] args) {
		PersistantDriver run = new PersistantDriver();
		run.go();

	}

	private void go() {
		int userIn = 0;
		Scanner in = new Scanner(System.in);

		while (userIn != 5) {
			printMenu();
			userIn = in.nextInt();
			if (userIn == 1) {
				Cars c = new Cars();
				System.out.println("enter make of car: ");
				c.setMake(in.next());
				System.out.println("enter model of car: ");
				c.setModel(in.next());
				System.out.println("enter year of car: ");
				c.setYear(in.nextInt());
				helper.persist(c);
			} else if (userIn == 4) {
				showAll();
			} else if (userIn == 2) {
				Cars c = new Cars();
				System.out.println("enter id to delete");
				c.setRowId(in.nextInt());
				helper.delete(c);
			} else if (userIn == 3) {
				Cars c = new Cars();
				showAll();
				System.out.println("Enter rowId to update:");
				c.setRowId(in.nextInt());
				System.out.println("Enter make of car:");
				c.setMake(in.next());
				System.out.println("enter model of car:");
				c.setModel(in.next());
				System.out.println("Set year of car");
				c.setYear(in.nextInt());
			}
		}
		System.out.println("Quitting Program");

	}

	private void showAll() {
		for (Cars c : helper.showAllCars()) {
			System.out.println(c.toString());
		}
	}

	// this prints the query to the console for user input
	private void printMenu() {
		System.out.println("---1.) create car");
		System.out.println("--2.) Delete car");
		System.out.println("--3.) edit car");
		System.out.println("--4.) show all cars");
		System.out.println("--5.) Quit");
	}

}
