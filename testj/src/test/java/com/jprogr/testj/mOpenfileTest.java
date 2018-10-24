/**
 * 
 */
package com.jprogr.testj;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

/**
 * @author IsmagilovI
 *
 */
public class mOpenfileTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	//public final void test() {
	//	fail("Not yet implemented");

	//Тест на создание строки	
	public void simpleTestMakeList() {
		
		//assertEquals(3,1+2);
		
		mOpenfile mOpf = new mOpenfile(); 

		
		List<String> mList = mOpf.mScan("src\\test\\resources\\test.txt").stream() 	
				.filter(s -> s.length() >= 2)
				.collect(Collectors.toList());
		
		String listToString = mList.toString();
		  
		Assert.assertTrue(listToString.contains("[Тест, Тест, Тест, Тест, Тест, пап, пап, пап, Пап, мом, мом]"));   // passes
	}
	
	
	
	
	@Test
	//Тест на сравнение результатов в Map
	 public void simpleTestMap() {		
			
			mOpenfile mOpf = new mOpenfile(); 
			
			List<String> mList = mOpf.mScan("src\\test\\resources\\test.txt").stream() 	
					.filter(s -> s.length() >= 2)
					.collect(Collectors.toList());
			
			Map<String, Long> mcollect = mList.stream() 
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

			Map<String, Long> result = new LinkedHashMap<>(); 
			mcollect.entrySet().stream()
					.sorted(Map.Entry.<String, Long>comparingByValue().reversed())
					.forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
			
			Map <String, Long> comMap = new HashMap<String, Long>();
			
			long a=5,b=3,c=2,d=1;
			
			comMap.put("Тест", a);
			comMap.put("пап", b);
			comMap.put("мом", c);
			comMap.put("Пап", d);
		        
			Assert.assertEquals(result,comMap);
			 
	 }
}
