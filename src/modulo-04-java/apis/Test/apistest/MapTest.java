package apistest;

import org.junit.*;
import java.util.*;

public class MapTest {

	@Test
	public void testGet() throws Exception{
		//Arrange
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Um");
		map.put(2, "teste");
		map.put(3, "do");
		map.put(4, "get");
		//Act
		//Assert
		String esperado = "get";
		Assert.assertEquals(esperado, map.get(4));
	}
	
	@Test
	public void testPut() throws Exception{
		//Arrange
		Map<Integer, String> map = new HashMap<>();
		//Act
		map.put(1, "Um");
		map.put(2, "teste");
		map.put(3, "do");
		map.put(4, "put");
		//Assert
		Map<Integer, String> esperado = new HashMap<>();
		esperado.put(1, "Um");
		esperado.put(2, "teste");
		esperado.put(3, "do");
		esperado.put(4, "put");
		Assert.assertEquals(esperado, map);
	}
	
	@Test
	public void testIsEmpty() throws Exception{
		//Arrange
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Um");
		map.put(2, "teste");
		map.put(3, "do");
		map.put(4, "isEmpty");
		//Act
		//Assert
		Assert.assertFalse(map.isEmpty());
	}
	
	@Test
	public void testPutAll() throws Exception{
		//Arrange
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Um");
		map.put(2, "teste");
		map.put(3, "do");
		map.put(4, "putAll");
		Map<Integer, String> map2 = new HashMap<>();
		//Act
		map2.putAll(map);
		//Assert
		Map<Integer, String> esperado = new HashMap<>();
		esperado.put(1, "Um");
		esperado.put(2, "teste");
		esperado.put(3, "do");
		esperado.put(4, "putAll");
		Assert.assertEquals(esperado, map2);
	}
	
	@Test
	public void testClear() throws Exception{
		//Arrange
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Um");
		map.put(2, "teste");
		map.put(3, "do");
		map.put(4, "clear");
		//Act
		map.clear();
		//Assert
		Assert.assertTrue(map.isEmpty());
	}
	
	@Test
	public void testSize() throws Exception{
		//Arrange
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Um");
		map.put(2, "teste");
		map.put(3, "do");
		map.put(4, "size");
		//Act
		//Assert
		int esperado = 4;
		Assert.assertEquals(esperado, map.size());
	}
	
	@Test
	public void testContainsKey() throws Exception{
		//Arrange
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Um");
		map.put(2, "teste");
		map.put(3, "do");
		map.put(4, "containsKey");
		//Act
		//Assert
		Assert.assertTrue(map.containsKey(4));
	}
	
	@Test
	public void testCotainsValue() throws Exception{
		//Arrange
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Um");
		map.put(2, "teste");
		map.put(3, "do");
		map.put(4, "containsValue");
		//Act
		//Assert
		Assert.assertTrue(map.containsValue("containsValue"));
	}
}
