package no.ntnu.idi.dm.arm.apriori;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BruteForceApriori<V> extends BaseApriori<V> {

	public BruteForceApriori(List<ItemSet<V>> transactions, Double minimumSupport, Double minimumConfidence) {
		super(transactions, minimumSupport, minimumConfidence);
	}

	@Override
	public void apriori(Double minSupport) {

        List<ItemSet<V>> currentSets = getSingles(this.transactions);
        for (int i = 1; currentSets.size() > 0; i++) {
            List<ItemSet<V>> frequentSets = removeUnsupported(currentSets);
            frequentItemSets.put(i, frequentSets);


            System.out.println("Level " + i);
            System.out.println("\tGenerated " + currentSets.size()
                    + " candidates.");
            System.out.println("\t\t" + currentSets);
            System.out.println("\tKept " + frequentSets.size()
                    + " frequent itemsets");
            System.out.println("\t\t" + frequentSets);

            currentSets = combine(currentSets);
        }

	}

    // split all sets into singles.
    private List<ItemSet<V>> getSingles(List<ItemSet<V>> transactions) {
        Set<ItemSet<V>> singles = new HashSet<ItemSet<V>>();
        for (ItemSet<V> set : transactions) {
            for (V v : set.getItems()) {
                ItemSet<V> single = new ItemSet<V>(v);
                singles.add(single);
            }
        }
        return new LinkedList<ItemSet<V>>(singles);
    }

    // remove elements that is outside the supported limit.
    private List<ItemSet<V>> removeUnsupported(List<ItemSet<V>> sets) {
        List<ItemSet<V>> supportedSet = new LinkedList<ItemSet<V>>();
        for (ItemSet<V> set : sets) {
            // calculate the support value for the given set and compare it to the threshold.
            if (getAndCacheSupportForItemset(set) >= minimumSupport) {
                supportedSet.add(set);
            }
        }
        return supportedSet;
    }

    // combine the single sets to create useful combinations. The combinations are the used to create rules.
    private List<ItemSet<V>> combine(List<ItemSet<V>> minusKSet) {
        Set<ItemSet<V>> combinationSet = new HashSet<ItemSet<V>>();
        for (int i = 0; i < minusKSet.size(); i++) {
            ItemSet<V> setA = minusKSet.get(i);
            for (int j = 0; j < minusKSet.size(); j++) {
                ItemSet<V> setB = minusKSet.get(j);
                ItemSet<V> differenceSet = setB.difference(setA);

                for (V v : differenceSet.getItems()) {
                    ItemSet<V> combination = setA.union(v);
                    if (combination.size() > setA.size()) {
                        combinationSet.add(combination);
                    }
                }
            }
        }
        return new LinkedList<ItemSet<V>>(combinationSet);
    }

}
