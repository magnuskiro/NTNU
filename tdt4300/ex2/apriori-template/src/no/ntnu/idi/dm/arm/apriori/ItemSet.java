package no.ntnu.idi.dm.arm.apriori;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ItemSet<V> implements Comparable<ItemSet<V>> {

	// we store the items here
	private SortedSet<V> items;

	// constructors
	public ItemSet() {
		items = new TreeSet<V>();
	}

	public ItemSet(Set<V> items) {
		this.items = new TreeSet<V>(items);
	}

	public ItemSet(V item) {
		this.items = new TreeSet<V>();
		this.items.add(item);
	}

	
	// access methods
	public Set<V> getItems() {
		return items;
	}

	public V first() {
		return items.first();
	}

	public V last() {
		return items.last();
	}

	public int size() {
		return items.size();
	}

	// add a new item to the set
	public boolean addItem(V v) {
		return items.add(v);
	}

	@Override
	public String toString() {
		return items.toString();
	}

	/**
	 * get the union of the current itemset and the given one
	 * 
	 * @param itemSet
	 * @return
	 */
	public ItemSet<V> union(ItemSet<V> itemSet) {
		Set<V> union = new LinkedHashSet<V>(getItems());
		union.addAll(itemSet.getItems());
		return new ItemSet<V>(union);
	}

	/**
	 * get the union of the current itemset and the given item
	 * 
	 * @param item
	 * @return
	 */
	public ItemSet<V> union(V item) {
		Set<V> union = new LinkedHashSet<V>(getItems());
		union.add(item);
		return new ItemSet<V>(union);
	}

	
	/**
	 * get the intersection of the current itemset and the given one
	 * 
	 * @param itemSet
	 * @return
	 */
	public ItemSet<V> intersection(ItemSet<V> itemSet) {
		Set<V> intersection = new HashSet<V>(getItems());
		intersection.retainAll(itemSet.getItems());
		return new ItemSet<V>(intersection);
	}

	/**
	 * returns all items in this set but not in the other (minusall)
	 */
	public ItemSet<V> difference(ItemSet<V> itemSet) {
		Set<V> difference = new HashSet<V>(getItems());
		difference.removeAll(itemSet.getItems());
		return new ItemSet<V>(difference);
	}

	/**
	 * returns all items in this set but not in the other (minusall)
	 */
	public ItemSet<V> difference(V item) {
		Set<V> difference = new HashSet<V>(getItems());
		difference.remove(item);
		return new ItemSet<V>(difference);
	}


	@Override
	public boolean equals(Object o) {
		return ((ItemSet<?>) o).items.equals(items);
	}

	@Override
	public int hashCode() {
		return items.hashCode();
	}

	/**
	 * returns how many consecutive items occurr in both set (starting from the
	 * first item) e.g. for the two sets <A,B,C> and <A,B,F> it will return 2.
	 * 
	 * @param other
	 * @return
	 */
	public int firstKItemsIdentical(ItemSet<V> other) {
		Iterator<V> iterator = items.iterator();
		Iterator<V> iterator2 = other.items.iterator();
		int counter = 0;
		while (iterator.hasNext() && iterator2.hasNext()) {
			V next = iterator.next();
			V next2 = iterator2.next();
			if (next.equals(next2)) {
				counter++;
			} else
				return counter;
		}

		return counter;
	}

	@Override
	public int compareTo(ItemSet<V> o) {
		return items.first().toString().compareTo(o.items.first().toString());
	}

}
