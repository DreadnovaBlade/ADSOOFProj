import java.util.*;

class WordStoreImp implements WordStore {
	private LinkedWordList[] words;
	private HashFunction hashfunc;

	public WordStoreImp(int n) {
		if(n == 0) 
			words = new LinkedWordList[1];
		else
			words = new LinkedWordList[n];
		for(int i = 0; i < words.length; i++)
			words[i] = new LinkedWordList();
		hashfunc = new HashFunction();
	}

	public void add(String word) {
		int hash = hashfunc.createHashKey(word, words.length);
		LinkedWordEntry wordToAdd = new LinkedWordEntry(word);
		words[hash].addToHash(wordToAdd);
	}

	public int count(String word) { 
		int hash = hashfunc.createHashKey(word, words.length);
		LinkedWordEntry wordToCount = new LinkedWordEntry(word);
		return words[hash].countInList(wordToCount);
	}

	public void remove(String word) {
		int hash = hashfunc.createHashKey(word, words.length);
		LinkedWordEntry wordToRemove = new LinkedWordEntry(word);
		words[hash].removeFirstOcc(wordToRemove);
	}

	public void printWord() {
		for(int i = 0; i < words.length; i++)
			words[i].printWord();
	}
}
