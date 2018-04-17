package by.htp.pageobject.steps.util;

import java.util.List;

public final class PrintListToConsole {

	private PrintListToConsole() {

	}

	public static <T> void printList(List<T> list) {
		for (T item : list) {
			System.out.println(item);
		}
	}

}
