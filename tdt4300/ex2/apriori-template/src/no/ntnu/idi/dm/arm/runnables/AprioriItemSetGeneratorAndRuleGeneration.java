package no.ntnu.idi.dm.arm.runnables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import no.ntnu.idi.dm.arm.apriori.AbstractApriori;
import no.ntnu.idi.dm.arm.apriori.BruteForceApriori;
import no.ntnu.idi.dm.arm.apriori.FKMinus1F1Apriori;
import no.ntnu.idi.dm.arm.apriori.FkMinus1FKMinus1;
import no.ntnu.idi.dm.arm.apriori.ItemSet;

public class AprioriItemSetGeneratorAndRuleGeneration {


	public static ArrayList<ItemSet<String>> readFile(String filename) throws IOException
	{
		BufferedReader reader=new BufferedReader(new FileReader(new File(filename)));
		ArrayList<String> attributeNames=new ArrayList<String>();
		ArrayList<ItemSet<String>> itemSets=new ArrayList<ItemSet<String>>();
		String line=reader.readLine();
		 line=reader.readLine();
		 
		while(line!=null)
		{
			if (line.contains("#") || line.length()<2)
			{
				line=reader.readLine();
				continue;
			}
			if(line.contains("attribute"))
			{
				int startIndex=line.indexOf("'");
				if(startIndex>0)
				{
					int endIndex=line.indexOf("'", startIndex+1);
					attributeNames.add(line.substring(startIndex+1,endIndex ));
				}
				
			}
			else
			{
				ItemSet<String> is=new ItemSet<String>();				
				StringTokenizer tokenizer=new StringTokenizer(line,",");
				int attributeCounter=0;
				String itemSet="";
				while(tokenizer.hasMoreTokens())
				{
					String token=tokenizer.nextToken().trim();
					if(token.equalsIgnoreCase("t"))
					{
						String attribute=attributeNames.get(attributeCounter);
						
						itemSet+=attribute+",";
						is.addItem(attribute);
					}
					attributeCounter++;
				}
				itemSets.add(is);
			}
			line=reader.readLine();
		}
		reader.close();
		return itemSets;
		
	}

	public static void main(String[] args) {

		// get the data set
		List<ItemSet<String>> transactions=null;
		boolean useSmallDataset=false; //use small or large dataset
		try {
			if(useSmallDataset)
				transactions=readFile("smallDataset.txt");
			else
			transactions = readFile("supermarket.arff");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// print transactions ... just in case
		System.out.println(transactions);

		// threshold
        Double minConfidence = .8;
		Double minSupport = .4d;
		System.out.println("We set the relative minsup to " + minSupport);

		AbstractApriori<String> apriori;

        apriori = new BruteForceApriori<String>(transactions, minSupport, minConfidence);
		//apriori = new FKMinus1F1Apriori<String>(transactions, minSupport, minConfidence);
		//apriori = new FkMinus1FKMinus1<String>(transactions, minSupport, minConfidence);

		apriori.apriori(minSupport);

		apriori.generateAllRules();
		
		System.out.println("Generated " + apriori.getRules().size() + " rules.");

	}

}

//public static List<ItemSet<String>> createDataSet() {
//	ItemSet<String> t1 = new ItemSet<String>();
//	t1.addItem("bread");
//	t1.addItem("milk");
//
//	ItemSet<String> t2 = new ItemSet<String>();
//	t2.addItem("bread");
//	t2.addItem("diapers");
//	t2.addItem("beer");
//	t2.addItem("eggs");
//
//	ItemSet<String> t3 = new ItemSet<String>();
//	t3.addItem("milk");
//	t3.addItem("diapers");
//	t3.addItem("beer");
//	t3.addItem("cola");
//
//	ItemSet<String> t4 = new ItemSet<String>();
//	t4.addItem("bread");
//	t4.addItem("milk");
//	t4.addItem("diapers");
//	t4.addItem("beer");
//
//	ItemSet<String> t5 = new ItemSet<String>();
//	t5.addItem("bread");
//	t5.addItem("milk");
//	t5.addItem("diapers");
//	t5.addItem("cola");
//
//	ItemSet<String> t6 = new ItemSet<String>();
//	t6.addItem("bread");
//	t6.addItem("diapers");
//	t6.addItem("milk");
//
//	List<ItemSet<String>> transactions = new LinkedList<ItemSet<String>>();
//	transactions.add(t1);
//	transactions.add(t2);
//	transactions.add(t3);
//	transactions.add(t4);
//	transactions.add(t5);
//	 transactions.add(t6);
//	return transactions;
//}
//
//
