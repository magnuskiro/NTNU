package no.ntnu.idi.dm.arm.apriori;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FkMinus1FKMinus1<V> extends BaseApriori<V> {

	public FkMinus1FKMinus1(List<ItemSet<V>> transactions, Double minimumSupport, Double minimumConfidence) {
		super(transactions, minimumSupport, minimumConfidence);
	}

	@Override
	public List<ItemSet<V>> aprioriGen(List<ItemSet<V>> frequentCandidatesKMinus1) {

        Collections.sort(frequentCandidatesKMinus1);
		int allGeneratedCandidatesCounter = 0;
		Set<ItemSet<V>> frequentCandidateSet = new HashSet<ItemSet<V>>();

        for (int i = 0; i < frequentCandidatesKMinus1.size(); i++) {
            ItemSet<V> setA = frequentCandidatesKMinus1.get(i);
            for (int j = 0; j < frequentCandidatesKMinus1.size(); j++) {
                ItemSet<V> setB = frequentCandidatesKMinus1.get(j);
                ItemSet<V> differenceSet = setB.difference(setA);

                for (V v : differenceSet.getItems()) {
                    ItemSet<V> combination = setA.union(v);
                    if (combination.size() != setA.size() + 1) {
                        continue;
                    }

                    frequentCandidateSet.add(combination);
                    getAndCacheSupportForItemset(combination);
                    allGeneratedCandidatesCounter++;
                }
            }
        }

		return new LinkedList<ItemSet<V>>(frequentCandidateSet);
	}

}
