package com.example.simplemyjdbc.service;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.example.simplemyjdbc.domian.Coal;


public class CoalManagerTest {
	
	private final static String NAME1 = "torf";
	private final static String TYPE1 = "kopalny";
	private final static int PERCENT1 = 60;
	private final static String NAME2 = "antracyt";
	private final static String TYPE2 = "pierwiastek";
	private final static int PERCENT2 = 100;
	
	CoalManager coalManager = new CoalManager();
	
	@Test
	public void checkConnection() {
		assertNotNull(coalManager.getConnection());
	}
	
	@Test
	public void checkAdding() {
		
		Coal coal = new Coal(NAME1, TYPE1, PERCENT1);
		
		coalManager.deleteEverything();
		assertEquals(1, coalManager.addCoal(coal));
		
		List<Coal> coalList = new ArrayList<>();
		coalList = coalManager.getAllCoal();
		
		Coal firstCoal = coalList.get(0);
		
		assertEquals(firstCoal.getName(), NAME1);
		assertEquals(firstCoal.getType(), TYPE1);
		assertEquals(firstCoal.getPercentOfCarbon(), PERCENT1);
	}
	
	@Test
	public void checkUpdating() {
		coalManager.deleteEverything();
		Coal coal = new Coal(NAME1, TYPE1, PERCENT1);
		assertEquals(1, coalManager.addCoal(coal));
		List<Coal> coals = coalManager.getAllCoal();
		Coal newCoal = coals.get(0);
		newCoal.setName(NAME2);
		assertEquals(1, coalManager.update(newCoal));
		coals = coalManager.getAllCoal();
		Coal coal2 = coals.get(0);
		assertEquals(NAME2, coal2.getName());
		assertEquals(TYPE1, coal2.getType());
		assertEquals(PERCENT1, coal2.getPercentOfCarbon());
	}
	
	
	@Test
	public void checkNameUpdating() {
		Coal coal = new Coal(NAME1, TYPE1, PERCENT1);
		
		coalManager.deleteEverything();
		assertEquals(1, coalManager.addCoal(coal));
		assertEquals(1, coalManager.updateName(NAME1, NAME2));
		
		List<Coal> coalList = new ArrayList<>();
		coalList = coalManager.getAllCoal();
		
		Coal firstCoal = coalList.get(0);
		
		assertEquals(firstCoal.getName(), NAME2);
		assertEquals(firstCoal.getType(), TYPE1);
		assertEquals(firstCoal.getPercentOfCarbon(), PERCENT1);
		
	}
	
	@Test
	public void checkTypeUpdating() {
		Coal coal = new Coal(NAME1, TYPE1, PERCENT1);
		
		coalManager.deleteEverything();
		assertEquals(1, coalManager.addCoal(coal));
		assertEquals(1, coalManager.updateType(NAME1, TYPE2));
		
		List<Coal> coalList = new ArrayList<>();
		coalList = coalManager.getAllCoal();
		
		Coal firstCoal = coalList.get(0);
		
		assertEquals(firstCoal.getName(), NAME1);
		assertEquals(firstCoal.getType(), TYPE2);
		assertEquals(firstCoal.getPercentOfCarbon(), PERCENT1);
		

	}
	
	@Test
	public void checkPercentUpdating() {
		Coal coal = new Coal(NAME1, TYPE1, PERCENT1);
		
		coalManager.deleteEverything();
		assertEquals(1, coalManager.addCoal(coal));
		assertEquals(1, coalManager.updatePercent(NAME1, PERCENT2));
		
		List<Coal> coalList = new ArrayList<>();
		coalList = coalManager.getAllCoal();
		
		Coal firstCoal = coalList.get(0);
		
		assertEquals(firstCoal.getName(), NAME1);
		assertEquals(firstCoal.getType(), TYPE1);
		assertEquals(firstCoal.getPercentOfCarbon(), PERCENT2);
	}

	@Test
	public void checkDeletionOfEverything() {
		coalManager.deleteEverything();
		List<Coal> coals = coalManager.getAllCoal();
		assertEquals(0, coals.size());
	}
	
	
	@Test
	public void checkDeletionByName() {
		Coal coal1 = new Coal(NAME1, TYPE1, PERCENT1);
		Coal coal2 = new Coal(NAME2, TYPE2, PERCENT2);
		coalManager.deleteEverything();
		assertEquals(1, coalManager.addCoal(coal1));
		assertEquals(1, coalManager.addCoal(coal2));
		coalManager.deleteByName(NAME1);
		List<Coal> withoutList = coalManager.getByName(NAME1);
		boolean check = false;
		for (Coal coal : withoutList) {
			if (coal.getName().equalsIgnoreCase(NAME1)) {
				check = true;
				break;
			}
		}
		assertFalse(check);
	}
	
	@Test
	public void chechGettingByName() {
		Coal coal1 = new Coal(NAME1, TYPE1, PERCENT1);
		Coal coal2 = new Coal(NAME2, TYPE2, PERCENT2);
		coalManager.deleteEverything();
		assertEquals(1, coalManager.addCoal(coal1));
		assertEquals(1, coalManager.addCoal(coal2));
		List<Coal> coals = coalManager.getByName(NAME1);
		Coal firstCoal = coals.get(0);
		
		assertEquals(firstCoal.getName(), NAME1);
		assertEquals(firstCoal.getType(), TYPE1);
		assertEquals(firstCoal.getPercentOfCarbon(), PERCENT1);
	}
}