/*
 * 
 * 
 * Test Project Junior Programmer.
 * 
 * 
 *  
 */

package com.jprogr.testj;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.util.function.Function;

public class App {

	public static void main(String[] args) throws IOException {

		mOpenfile mOpf = new mOpenfile(); // Открытие текстового вайла, возврт строки текста из файла. src\test\resources\test.txt

		//List<String> mList = mOpf.mScan("C:\\2.txt").stream() // Создаем поток из перечня слов и фильтруем его по количеству символов
		//List<String> mList = mOpf.mScan("src\\test\\resources\\test.txt").stream() 	
	    List<String> mList = mOpf.mScan("").stream() 
				
				.filter(s -> s.length() >= 2)
				.collect(Collectors.toList());
		

		Map<String, Long> mcollect = mList.stream() // Получаем Map группируем и считаем
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Map<String, Long> result = new LinkedHashMap<>(); // Сортируем полученный Map
		mcollect.entrySet().stream()
				.sorted(Map.Entry.<String, Long>comparingByValue().reversed())
				.forEachOrdered(x -> result.put(x.getKey(), x.getValue()));

		System.out.println("Слово = количество вхождений");

		result.entrySet().forEach(System.out::println);
		
		
	}

}
