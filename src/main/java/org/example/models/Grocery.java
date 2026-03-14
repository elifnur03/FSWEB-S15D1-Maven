package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("0 - Exit");
            System.out.println("1 - Add item(s)");
            System.out.println("2 - Remove item(s)");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter item(s) to add: ");
                String input = scanner.nextLine();
                addItems(input);
            } else if (choice == 2) {
                System.out.print("Enter item(s) to remove: ");
                String input = scanner.nextLine();
                removeItems(input);
            } else if (choice == 0) {
                System.out.println("Exiting...");
            }

            printSorted();
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmed = item.trim();
            if (!checkItemIsInList(trimmed)) {
                groceryList.add(trimmed);
                System.out.println(trimmed + " added.");
            } else {
                System.out.println(trimmed + " already in list.");
            }
        }
        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmed = item.trim();
            if (checkItemIsInList(trimmed)) {
                groceryList.remove(trimmed);
                System.out.println(trimmed + " removed.");
            } else {
                System.out.println(trimmed + " not found in list.");
            }
        }
        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Grocery List: " + groceryList);
    }
}