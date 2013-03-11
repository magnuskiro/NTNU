package no.ntnu.idi.dm.arm.apriori;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class AbstractApriori<V> {

	// we store the frequent itemsets in here (whatever's left after pruning)
	protected HashMap<Integer, List<ItemSet<V>>> frequentItemSets;

	// we cache the relative support count of itemsets
	private Map<ItemSet<V>, Double> supportCache = new HashMap<ItemSet<V>, Double>();

	// the transactions of the data set
	protected List<ItemSet<V>> transactions;

	// we keep the final rules that were generated
	private List<AssociationRule<V>> rules;

    // we store minimumSupport and minimumConfidence
    protected Double minimumSupport;
    protected Double minimumConfidence;

	/**
	 * initialise with a list of transactions
	 * 
	 * @param transactions
	 */
	public AbstractApriori(List<ItemSet<V>> transactions, Double minimumSupport, Double minimumConfidence) {
		this.transactions = transactions;
        this.minimumSupport = minimumSupport;
        this.minimumConfidence = minimumConfidence;
		frequentItemSets = new HashMap<Integer, List<ItemSet<V>>>();
		rules = new LinkedList<AssociationRule<V>>();
	}

	/**
	 * iterate over the transactions and return all 1-itemsets
	 * 
	 * @return
	 */
	public List<ItemSet<V>> getAllItemsetsOfSizeOne() {
		Set<ItemSet<V>> sizeOneItemSets = new HashSet<ItemSet<V>>();
		// iterate transactions
		for (ItemSet<V> nextItemSet : transactions) {
			// iterate items in each transaction
			for (V v : nextItemSet.getItems()) {
				// create a new ItemSet and add it to our set
				ItemSet<V> itemSet = new ItemSet<V>();
				itemSet.addItem(v);
				sizeOneItemSets.add(itemSet);
				// update support counts for these itemsets on the fly
				getAndCacheSupportForItemset(itemSet);
			}
		}
		// convert to list and return
		return new LinkedList<ItemSet<V>>(sizeOneItemSets);
	}

	/**
	 * get or calculate support for the given itemset it is either fetched from
	 * the cache or computed from the transaction set
	 * 
	 * @param itemset
	 * @return support count
	 */
	public double getAndCacheSupportForItemset(ItemSet<V> itemset) {
		// check cache first and return if it is found there
		Double double1 = supportCache.get(itemset);
		if (double1 != null) {
			return double1;
		}

		// else iterate the transactions and count support
		int occurrenceCount = 0;
		Iterator<ItemSet<V>> transactionIterator = transactions.iterator();

		while (transactionIterator.hasNext()) {
			ItemSet<V> transaction = transactionIterator.next();
			// System.out.println("comparing to: " + transaction);
			if (transaction.intersection(itemset).size() == itemset.size()) {
				// System.out.println("found in: " + transaction);
				occurrenceCount++;
			}
		}

		// store relative support
		double d = ((double) occurrenceCount) / transactions.size();
		supportCache.put(itemset, d);
		return d;
	}

	/**
	 * 
	 * 
	 * @param minSupport
	 * @param candidates
	 * @return
	 */
	protected List<ItemSet<V>> pruneInfrequentCandidates(Double minSupport,
			List<ItemSet<V>> candidates) {

		List<ItemSet<V>> frequentCandidates = new LinkedList<ItemSet<V>>();
		Iterator<ItemSet<V>> candidateIterator = candidates.iterator();
		while (candidateIterator.hasNext()) {
			ItemSet<V> next = candidateIterator.next();
			Double support = supportCache.get(next);
			if (support >= minSupport) {
				frequentCandidates.add(next);
			}
		}
		return frequentCandidates;
	}

	/**
	 * see apriori-gen method in literature, to be implemented by subclasses
	 * 
	 * @param frequentCandidatesKMinus1
	 * @return
	 */
	public abstract List<ItemSet<V>> aprioriGen(
			List<ItemSet<V>> frequentCandidatesKMinus1);

	/**
	 * 
	 * to be implemented in subclasses
	 * */
	abstract public void apriori(Double minSupport);

	// we deal with actual association rules from here on

	/**
	 * to be called recursive with an itemset and a consequent
	 * 
	 * @param frequentItemSet
	 * @param consequent
	 */
	public void generateRulesBase(ItemSet<V> frequentItemSet, ItemSet<V> consequent) {
        //private AssociationRule<V> createAssociationRule(ItemSet<V> antecedent,ItemSet<V> consequent) {

        // create rule
        AssociationRule<V> rule = new AssociationRule<V>(frequentItemSet.difference(consequent), consequent);

        // compute confidence and support
        Double support = supportCache.get(frequentItemSet.union(consequent));
        Double leftSupport = supportCache.get(frequentItemSet);
        if (support != null) {
            rule.setSupport(support);
            rule.setConfidence(support / leftSupport);
        }

        rules.add(rule);

		//AssociationRule rule=new AssociationRule(frequentItemSet,consequent);
	}

	/**
	 * start generating rules by iterating al frequent 2+ itemsets
	 */
	public void generateAllRules() {
		for (Entry<Integer, List<ItemSet<V>>> entry : frequentItemSets.entrySet()) {
			// we only do this for itemsets larger 1, it'd be kind of a boring
			// rule otherwise now, wouldn't it
			if (entry.getKey() > 1) {
				System.out.println("Generating rules for level: " + entry.getKey());

                // for each itemset this size
				for (ItemSet<V> itemSet : entry.getValue()) {
					System.out.println("handling itemset: " + itemSet);
					// for each of its items we generate a antecendent -> consequent combination
					for (V is : itemSet.getItems()) {
						ItemSet<V> leftHandSide = itemSet.difference(is);
						ItemSet<V> rightHandSide = new ItemSet<V>(is);

						// System.out.println("Starting recursion for: "
						// + leftHandSide + " and " + rightHandSide);

						// start recursion for this combination
						generateRulesBase(leftHandSide, rightHandSide);
					}
				}
			}
		}
	}

	public List<AssociationRule<V>> getRules() {
		return rules;
	}

}
