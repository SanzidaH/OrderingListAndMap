package com.kona.maven.ListMapSorting;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import junit.framework.TestCase;

public class HumanTest {

	private List<Human> unsortedList() {

		List<Human> humanList = new ArrayList<Human>();

		humanList.add(new Human("Sanzida", 22, 40000));
		humanList.add(new Human("Nusrat", 21, 40015));
		humanList.add(new Human("Sanjatul", 23, 40025));
		humanList.add(new Human("Rajashree", 20, 40020));

		return humanList;
	}

	private List<Human> ageSortedList() {

		List<Human> humanList = new ArrayList<Human>();

		humanList.add(new Human("Rajashree", 20, 40020));
		humanList.add(new Human("Nusrat", 21, 40015));
		humanList.add(new Human("Sanzida", 22, 40000));
		humanList.add(new Human("Sanjatul", 23, 40025));

		return humanList;

	}

	private List<Human> nameSortedList() {

		List<Human> humanList = new ArrayList<Human>();

		humanList.add(new Human("Nusrat", 21, 40015));
		humanList.add(new Human("Rajashree", 20, 40020));
		humanList.add(new Human("Sanjatul", 23, 40025));
		humanList.add(new Human("Sanzida", 22, 40000));

		return humanList;

	}

	private List<Human> salarySortedList() {

		List<Human> humanList = new ArrayList<Human>();

		humanList.add(new Human("Sanzida", 22, 40000));
		humanList.add(new Human("Nusrat", 21, 40015));
		humanList.add(new Human("Rajashree", 20, 40020));
		humanList.add(new Human("Sanjatul", 23, 40025));

		return humanList;

	}

	@Test
	public void testcompareToList() {

		List<Human> listToBeSorted = new ArrayList<Human>();
		listToBeSorted = unsortedList();
		Collections.sort(listToBeSorted);

		assertEquals(nameSortedList(), listToBeSorted);

	}

	@Test
	public void testsalarySortedList() {

		List<Human> listToBeSorted = new ArrayList<Human>();
		listToBeSorted = unsortedList();

		Collections.sort(listToBeSorted, new Comparator<Human>() {

			public int compare(Human o1, Human o2) {
				// TODO Auto-generated method stub
				return o1.getSalary() - o2.getSalary();
			}

		});

		assertEquals(salarySortedList(), listToBeSorted);

	}

	@Test
	public void testageSortedList() {

		List<Human> listToBeSorted = new ArrayList<Human>();
		listToBeSorted = unsortedList();

		Collections.sort(listToBeSorted, new Comparator<Human>() {

			public int compare(Human o1, Human o2) {
				// TODO Auto-generated method stub
				return o1.getAge() - o2.getAge();
			}

		});

		assertEquals(ageSortedList(), listToBeSorted);
	}

	// ________MAP_______

	private Map<Integer, Human> unsortedMap() {

		Map<Integer, Human> unsortMap = new HashMap<Integer, Human>();

		unsortMap.put(1, new Human("Sanzida", 22, 40000));
		unsortMap.put(4, new Human("Nusrat", 21, 40015));
		unsortMap.put(2, new Human("Sanjatul", 23, 40025));
		unsortMap.put(3, new Human("Rajashree", 20, 40020));

		return unsortMap;
	}

	private Map<Integer, Human> ageSortedMap() {

		Map<Integer, Human> agesortMap = new LinkedHashMap<Integer, Human>();

		agesortMap.put(3, new Human("Rajashree", 20, 40020));
		agesortMap.put(4, new Human("Nusrat", 21, 40015));
		agesortMap.put(1, new Human("Sanzida", 22, 40000));
		agesortMap.put(2, new Human("Sanjatul", 23, 40025));

		return agesortMap;
	}

	private Map<Integer, Human> salarySortedMap() {

		Map<Integer, Human> salarysortMap = new LinkedHashMap<Integer, Human>();

		salarysortMap.put(1, new Human("Sanzida", 22, 40000));
		salarysortMap.put(4, new Human("Nusrat", 21, 40015));
		salarysortMap.put(3, new Human("Rajashree", 20, 40020));
		salarysortMap.put(2, new Human("Sanjatul", 23, 40025));

		return salarysortMap;
	}

	private Map<Integer, Human> nameSortedMap() {

		Map<Integer, Human> namesortMap = new LinkedHashMap<Integer, Human>();

		namesortMap.put(4, new Human("Nusrat", 21, 40015));
		namesortMap.put(3, new Human("Rajashree", 20, 40020));
		namesortMap.put(2, new Human("Sanjatul", 23, 40025));
		namesortMap.put(1, new Human("Sanzida", 22, 40000));

		return namesortMap;
	}

	@Test
	public void testNameSortedMap() {

		Map<Integer, Human> mapToBeSorted = new HashMap<Integer, Human>();
		mapToBeSorted = unsortedMap();

		List<Map.Entry<Integer, Human>> list = new LinkedList<Map.Entry<Integer, Human>>(mapToBeSorted.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer, Human>>() {
			public int compare(Map.Entry<Integer, Human> o1, Map.Entry<Integer, Human> o2) {
				return (o1.getValue().getName()).compareTo(o2.getValue().getName());
			}
		});

		Map<Integer, Human> result = new LinkedHashMap<Integer, Human>();

		for (Map.Entry<Integer, Human> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}

		assertEquals(nameSortedMap(), result);

	}

	@Test
	public void testsalarySortedMap() {

		Map<Integer, Human> mapToBeSorted = new HashMap<Integer, Human>();
		mapToBeSorted = unsortedMap();

		List<Map.Entry<Integer, Human>> list = new LinkedList<Map.Entry<Integer, Human>>(mapToBeSorted.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer, Human>>() {
			public int compare(Map.Entry<Integer, Human> o1, Map.Entry<Integer, Human> o2) {
				return (o1.getValue().getSalary() - o2.getValue().getSalary());
			}
		});

		Map<Integer, Human> result = new LinkedHashMap<Integer, Human>();

		for (Map.Entry<Integer, Human> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}

		assertEquals(salarySortedMap(), result);

	}

	@Test
	public void testageSortedMap() {

		Map<Integer, Human> mapToBeSorted = new HashMap<Integer, Human>();
		mapToBeSorted = unsortedMap();

		List<Map.Entry<Integer, Human>> list = new LinkedList<Map.Entry<Integer, Human>>(mapToBeSorted.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer, Human>>() {
			public int compare(Map.Entry<Integer, Human> o1, Map.Entry<Integer, Human> o2) {
				return (o1.getValue().getAge() - o2.getValue().getAge());
			}
		});

		Map<Integer, Human> result = new LinkedHashMap<Integer, Human>();

		for (Map.Entry<Integer, Human> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}

		assertEquals(ageSortedMap(), result);
	}

}
