/*
 * Test Project Junior Programmer.
 * 
 * 
 * Open the text file and return the string ArrayList
 * 
 * 
 */

package com.jprogr.testj;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class mOpenfile {

	String mPath = ""; // путь к файлу
	String mtxt = ""; // текст из файла

	// Считывает текст из указанного файла и возвращает ArrayLis

	public ArrayList<String> mScan(String path) {

		
		if (path.length()>2) {
				mPath = path; }		
		else {
		System.out.println("Укажите путь к файлу: ");

		// Получаем путь к файлу
		Scanner scn = new Scanner(System.in);
		mPath = scn.next();

		scn.close();
		}
		
		try {
			// Считываем слова из файла
			File file = new File(mPath);

			Scanner in = new Scanner(file, "Cp1251");

			while (in.hasNext())

				mtxt += in.nextLine() + "&";

			in.close();

			// String [] words = message.toLowerCase().replaceAll("[-.?!)(,:]",
			// "").split("\\.?,?:?\\s");

			// Разбиваем слова
			ArrayList<String> items = new ArrayList<String>(
					Arrays.asList(mtxt.replaceAll("[-—_.?!)(,:;&«»]", " ").split("\\.?,?\\s")));

			return items;

		} catch (Exception e) {
			System.out.println("Ошибка (" + e + ").");
			System.exit(1);
		}
		return null;
	}

}
