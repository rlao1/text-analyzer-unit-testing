import java.util.*;
import java.io.*;

public class TextAnalyzer {
	
	File file = new File("file");
	List<String> list = new ArrayList<String>();
	List<Word> wordList = new ArrayList<Word>();
	List<String> resultList = new ArrayList<String>();
	Boolean duplicate = false;
	
	public static void main(String[] args) throws IOException 
	{
		
	}
	
	public List<String> getList() throws IOException 
	{
		Scanner scan = new Scanner(file); 
		scan.useDelimiter("[^A-Za-z]+");
		while(scan.hasNextLine()) 
		{ 
			try 
			{ 
				list.add(scan.next().toUpperCase()); 
			} catch(NoSuchElementException e) {} 
		} 

		for(String w : list) 
		{
			duplicate = false;
			
			for(Word wo : wordList) 
			{
				if(w.equals(wo.getWord()))
				{
					wo.incrementCount();
					duplicate = true;
					break;
				}
			}
			
			if(!duplicate) wordList.add(new Word(w));
		}
		
		Collections.sort(wordList, Word.descendingCount);
		String result;
		int i = 1;
		for(Word wo : wordList) 
		{
			String tempString = wo.getWord().toString();
			String tempInt = String.valueOf(wo.getCount());
			result = String.valueOf(i) + "\t" + tempString + ", " + tempInt;
			resultList.add(result);
			i++;
		}
		
		return resultList;
	}
}

class Word {
	private String word;
	private int count;
	
	public static Comparator<Word> descendingCount = new Comparator<Word>() {
		public int compare(Word a, Word b) 
		{
			int aCount = a.getCount();
			int bCount = b.getCount();
			return bCount - aCount;
		}
	};
	
	public Word(String w) 
	{
		word = w;
		count = 1;
	}
	
	// For JUnit Testing purposes
	public Word(String w, int c) 
	{
		word = w;
		count = c;
	}
	
	public void incrementCount() 
	{
		count++;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public String getWord()
	{
		return word;
	}
	
	public void printStat() 
	{
		System.out.printf("%s, %d\n", word, count);
	}
	
}
