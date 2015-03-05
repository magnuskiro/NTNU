package no.ntnu.idi.dm.arm.apriori;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FKMinus1F1Apriori<V> extends BaseApriori<V> {

	public FKMinus1F1Apriori(List<ItemSet<V>> transactions, Double minimumSupport, Double minimumConfidence) {
		super(transactions, minimumSupport, minimumConfidence);
	}

	@Override
	public List<ItemSet<V>> aprioriGen(
			List<ItemSet<V>> frequentCandidatesKMinus1) {
		Collections.sort(frequentCandidatesKMinus1);
		int allGeneratedCandidatesCounter = 0;
		Set<ItemSet<V>> frequentCandidateSet = new HashSet<ItemSet<V>>();

        // for all frequent candidates
		for (ItemSet<V> frequentCandidate : frequentCandidatesKMinus1) {
            // for all the frequent sets.
            for (ItemSet<V> frequentSet : frequent1Itemsets) {
                // if the two sets doesn't overlap at al
                if (frequentCandidate.intersection(frequentSet).size() == 0) {
                    // get all the elements of the two sets.
                    ItemSet<V> combination = frequentCandidate.union(frequentSet);
                    // add the new set to the current candidate set.
                    frequentCandidateSet.add(combination);
                    // calculate the support value for the new set.
                    getAndCacheSupportForItemset(combination);
                    // count the number of generated candidates.
                    allGeneratedCandidatesCounter++;
                }
            }
        }

		return new LinkedList<ItemSet<V>>(frequentCandidateSet);
	}
}
