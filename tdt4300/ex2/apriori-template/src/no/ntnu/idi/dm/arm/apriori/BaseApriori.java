package no.ntnu.idi.dm.arm.apriori;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class BaseApriori<V> extends AbstractApriori<V> {

	// we store the frequent 1-itemsets
	protected List<ItemSet<V>> frequent1Itemsets;

	public BaseApriori(List<ItemSet<V>> transactions, Double minimumSupport, Double minimumConfidence) {
		super(transactions, minimumSupport, minimumConfidence);
	}

	@Override
	public List<ItemSet<V>> aprioriGen(	List<ItemSet<V>> frequentCandidatesKMinus1) {
		
		Collections.sort(frequentCandidatesKMinus1);
		int allGeneratedCandidatesCounter = 0;
		Set<ItemSet<V>> frequentCandidateSet = new HashSet<ItemSet<V>>();
		// we iterate both itemsets and generate new candidates base on their
		// combinations
		for (int i = 0; i < frequentCandidatesKMinus1.size(); i++) { // make all n*(n-1)/2 combinations
			ItemSet<V> itemSet1 = frequentCandidatesKMinus1.get(i);
			for (int j = i + 1; j < frequentCandidatesKMinus1.size(); j++) {
				ItemSet<V> itemSet2 = frequentCandidatesKMinus1.get(j);

				ItemSet<V> difference = itemSet2.difference(itemSet1);
				Iterator<V> iterator = difference.getItems().iterator();
				while (iterator.hasNext()) {
					V next = iterator.next();
					ItemSet<V> possibleExtensionItemSet = new ItemSet<V>();
					possibleExtensionItemSet.addItem(next);
					ItemSet<V> union = itemSet1.union(possibleExtensionItemSet);

					// we only keep candidates of size k (which is k - 1 + 1)
					if (union.size() != itemSet1.size() + 1) {
						continue;
					}
					allGeneratedCandidatesCounter++;
					getAndCacheSupportForItemset(union);
					frequentCandidateSet.add(union);
				}
			}
		}
		System.out.println(allGeneratedCandidatesCounter
				+ " total, unique itemsets: " + frequentCandidateSet.size());
		return new LinkedList<ItemSet<V>>(frequentCandidateSet);
	}

	/**
	 * the main apriori algorithm, to be overriden in subclasses
	 * 
	 * @param minSupport
	 */
	public void apriori(Double minSupport) {
		// get frequent 1-itemsets
		List<ItemSet<V>> candidatesLevel1 = getAllItemsetsOfSizeOne();
		System.out.println("Level 1:");
		System.out.println("\tGenerated " + candidatesLevel1.size()
				+ " candidates.");
		System.out.println("\t\t" + candidatesLevel1);

		// prune 1-itemsets
		List<ItemSet<V>> frequentCandidatesLevel = pruneInfrequentCandidates(
				minSupport, candidatesLevel1);
		System.out.println("\tKept " + frequentCandidatesLevel.size()
				+ " frequent itemsets");
		System.out.println("\t\t" + frequentCandidatesLevel);
		// storing frequent 1-itemsets for a later time
		frequent1Itemsets = frequentCandidatesLevel;

		// store in our list of frequent itemsets
		frequentItemSets.put(1, frequentCandidatesLevel);

		// create the higher levels as long as we still produce frequent
		// itemsets
		for (int i = 2;; i++) {
			// generate candidates for level i
			System.out.println("Level " + i);

			// generate candidates
			List<ItemSet<V>> generateCandidateSizeK = aprioriGen(frequentCandidatesLevel);
			System.out.println("\tGenerated " + generateCandidateSizeK.size()
					+ " candidates.");
			System.out.println("\t\t" + generateCandidateSizeK);

			// prune
			frequentCandidatesLevel = pruneInfrequentCandidates(minSupport,
					generateCandidateSizeK);

			System.out.println("\tKept " + frequentCandidatesLevel.size()
					+ " frequent itemsets");
			if (frequentCandidatesLevel.size() == 0) {
				System.out
						.println("We're done here, there's no more frequent itemsets");
				break;
			}
			// store in our list of frequent itemsets
			frequentItemSets.put(i, frequentCandidatesLevel);
			System.out.println("\t\t" + frequentCandidatesLevel);
		}

	}

}
