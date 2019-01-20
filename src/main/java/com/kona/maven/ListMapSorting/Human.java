package com.kona.maven.ListMapSorting;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Human implements Comparable<Human> {

	String name;
	int age;
	int salary;
	//LocalDate dathOfBirth;

	public Human(String name, int age, int salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		// this.dathOfBirth = dathOfBirth;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getSalary() {
		return salary;
	}

//	public LocalDate getDathOfBirth() {
//		return dathOfBirth;
//	}

	public int compareTo(Human o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj == null) {
			return false;
		}

		if (!Human.class.isAssignableFrom(obj.getClass())) {
			return false;
		}

		final Human other = (Human) obj;
		if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
			return false;
		}

		if (this.age != other.age) {
			return false;
		}

		if (this.salary != other.salary) {
			return false;
		}

		return true;

	}

	public static void main(String args[]) {

		System.out.println("Driver Class");

		Map<Integer, Human> unsortMap = new HashMap<Integer, Human>();

		unsortMap.put(1, new Human("Sanzida", 22, 40000));
		unsortMap.put(4, new Human("Nusrat", 21, 40015));
		unsortMap.put(2, new Human("Sanjatul", 23, 40025));
		unsortMap.put(3, new Human("Rajashree", 20, 40020));

		// Map<Integer, Human> mapToBeSorted = new HashMap<Integer, Human>();
		// mapToBeSorted = unsortedMap();

		Map<Integer, Human> agesortMap = new LinkedHashMap<Integer, Human>();

		agesortMap.put(3, new Human("Rajashree", 20, 40020));
		agesortMap.put(4, new Human("Nusrat", 21, 40015));
		agesortMap.put(1, new Human("Sanzida", 22, 40000));
		agesortMap.put(2, new Human("Sanjatul", 23, 40025));

		List<Map.Entry<Integer, Human>> list = new LinkedList<Map.Entry<Integer, Human>>(unsortMap.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer, Human>>() {
			public int compare(Map.Entry<Integer, Human> o1, Map.Entry<Integer, Human> o2) {
				return (o1.getValue().getAge() - o2.getValue().getAge());
			}
		});

		Map<Integer, Human> result = new LinkedHashMap<Integer, Human>();

		for (Map.Entry<Integer, Human> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}

		System.out.println("Map Unsorted  :" + unsortMap);
		System.out.println("Map manual sorted  :" + agesortMap);
		System.out.println("Map sort by comparator  :" + result);

	}

}
