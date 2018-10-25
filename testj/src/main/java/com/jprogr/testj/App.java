/*
 * 
 * 
 * Test Project Junior Programmer.
 * 
 * 
 *  
 */

package com.jprogr.testj;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.io.IOException;
import java.util.function.Function;

public class App {

	public static void main(String[] args) throws IOException {

		mOpenfile mOpf = new mOpenfile(); // Открытие текстового вайла, возврт строки текста из файла.
											// src\test\resources\test.txt

		// List<String> mList = mOpf.mScan("C:\\2.txt").stream() // Создаем поток из
		// перечня слов и фильтруем его по количеству символов
		List<String> mList = mOpf.mScan("src\\test\\resources\\test.txt").stream()
				// List<String> mList = mOpf.mScan("").stream()

				.filter(s -> s.length() >= 2).collect(Collectors.toList());

		Map<String, Long> nmresult = new LinkedHashMap<>();

		long k = 0;
		int x1 = 0;

		//Заполняем map
		for (int i = 0; i < mList.size(); i++) {
			for (int ii = 0; ii < mList.size(); ii++) {

				if (mList.get(i).equals(mList.get(ii))) {
					k++;
				}

			}
			nmresult.put(mList.get(i), k);
			k = 0;
		}

		//Создаем массив по длинне map
		long[] mlng = new long[(nmresult.size())];

		
		//Заполняем массив ключами
		int k1 = 0;
		for (String key : nmresult.keySet()) {

			mlng[k1] = nmresult.get(key);
			k1++;
		}

		//Сортируем
		Arrays.sort(mlng);

		k1 = mlng.length; //Длинна массива

		
		//Сортируем 
		for (int i = 0; i < k1; i++) { //Перебираем все элементы массива

			for (Map.Entry<String, Long> entry : nmresult.entrySet()) { //Перебор Map

				if (mlng[i] == entry.getValue()) { //если элемент массива равент Value выводи его.

					System.out.println(entry.getKey() + "=" + entry.getValue());
				}
				

			}

		}

		/*
		 * for (Long key : nmresult.values()) {
		 * 
		 * 
		 * 
		 * if (k1==key) { System.out.println(key); }
		 * 
		 * System.out.println(nmresult.keySet());
		 * 
		 * System.out.println(key); k1--; }
		 */

		/*
		 * nmresult.entrySet().forEach(System.out::println);
		 * 
		 * 
		 * Map<String, Long> mcollect = mList.stream() // Получаем Map группируем и
		 * считаем .collect(Collectors.groupingBy(Function.identity(),
		 * Collectors.counting()));
		 * 
		 * Map<String, Long> result = new LinkedHashMap<>(); // Сортируем полученный Map
		 * mcollect.entrySet().stream() .sorted(Map.Entry.<String,
		 * Long>comparingByValue().reversed()) .forEachOrdered(x ->
		 * result.put(x.getKey(), x.getValue()));
		 * 
		 * System.out.println("Слово = количество вхождений");
		 * 
		 * result.entrySet().forEach(System.out::println);
		 */

	}

}
