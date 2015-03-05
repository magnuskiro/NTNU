package no.ntnu.idi.dm.arm.apriori;


/**
 * Represents an association rule: itemsetA => itemsetB
 * 
 */
public class AssociationRule<V> implements Comparable<AssociationRule<V>> {

	private ItemSet<V> itemSetA;

	private ItemSet<V> itemSetB;

	private double support, confidence;

	public AssociationRule(ItemSet<V> itemSetA, ItemSet<V> itemSetB) {
		this.itemSetA = itemSetA;
		this.itemSetB = itemSetB;
	}

	public void setItemSetA(ItemSet<V> itemSetA) {
		this.itemSetA = itemSetA;
	}

	public void setItemSetB(ItemSet<V> itemSetB) {
		this.itemSetB = itemSetB;
	}

	public ItemSet<V> getItemSetA() {
		return itemSetA;
	}

	public ItemSet<V> getItemSetB() {
		return itemSetB;
	}

	public ItemSet<V> getAllItems() {
		return itemSetA.union(itemSetB);
	}

	public String getRuleBodyAsString() {
		return "{" + itemSetA + "} => {" + itemSetB + "}";
	}

	public String getRuleBodyAsStringPlain() {
		return (itemSetA.toString() + " " + itemSetB.toString()).replaceAll(
				"\\[|\\]|,", "");
	}

	public String getRuleAntecendentAsStringPlain() {
		return (itemSetA.toString()).replaceAll("\\[|\\]|,", "");
	}

	@Override
	public String toString() {
		return getRuleBodyAsString() + " confidence = " + confidence
				+ ", support = " + support;
	}

	public int numItems() {
		return itemSetA.size() + itemSetB.size();
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public boolean equals(Object o) {
		return toString().equals(((AssociationRule<?>) o).toString());
	}

	/**
	 * we sort acording to the number of items in the rule, the number of items
	 * in the left part of the rule, and in alphabetical order
	 */
	@Override
	public int compareTo(AssociationRule<V> o) {
		// if length is the same
		int ruleLength = numItems() - o.numItems();
		int aLength = itemSetA.size() - o.getItemSetA().size();
		if (ruleLength != 0) {
			return ruleLength;
		} else {
			if (aLength != 0) {
				return aLength;
			}
		}
		return toString().compareTo(o.toString());
	}

	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}

	public double getConfidence() {
		return confidence;
	}

	public void setSupport(double support) {
		this.support = support;
	}

	public double getSupport() {
		return support;
	}

}