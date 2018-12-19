package chapter9;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest{
	public static void main(String[] args) {
		SortedSet<Item> parts = new TreeSet<>();
		parts.add(new Item("Toaster", 1234));
		parts.add(new Item("widget", 4562));
		parts.add(new Item("Modem", 9921));
		parts.add(new Item("Toaster", 4567));
		System.out.println(parts);
		
		NavigableSet<Item> sortByDescription = new TreeSet<>(
				Comparator.comparing(Item::getDescription));
		sortByDescription.addAll(parts);
		System.out.println(sortByDescription);
	}
}

class Item implements Comparable<Item>{
	private String description;
	private int partNumber;
	
	public Item(String description, int partNumber) {
		this.description = description;
		this.partNumber = partNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(int partNumber) {
		this.partNumber = partNumber;
	}
	
	public String toString() {
		return "[description=" + description + ", partNumber=" + partNumber + " ]";
	}
	
public int compareTo(Item other) {
		int diff = Integer.compare(partNumber, other.partNumber);
		return diff != 0?diff:description.compareTo(other.description);
	}


}
