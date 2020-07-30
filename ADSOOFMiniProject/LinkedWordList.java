class LinkedWordList {
	private LinkedWordEntry wordAtHash = null;
	
	public LinkedWordEntry getWordAtHash() {
		return wordAtHash;
	}
	
	public void addToHash(LinkedWordEntry wordToAdd) {
		if(wordAtHash == null)
			wordAtHash = wordToAdd;
		else {
			LinkedWordEntry currentWordAtHash = wordAtHash;
			wordAtHash = wordToAdd;
			wordAtHash.setNextWord(currentWordAtHash);
		}
	}
	
	public int countInList(LinkedWordEntry wordToCount) {
		int count = 0;
		LinkedWordEntry currentEntryInChain = wordAtHash;

		while(currentEntryInChain != null) {
			if(currentEntryInChain.getWord().equals(wordToCount.getWord()))
				count++;
			currentEntryInChain = currentEntryInChain.getNextWord();
		}

		return count;
	}
	
	public void removeFirstOcc(LinkedWordEntry wordToRemove) {
		if(wordAtHash == null) return;

		if(wordAtHash.getWord().equals(wordToRemove.getWord())) {
			wordAtHash = wordAtHash.getNextWord();
			return;
		}

		LinkedWordEntry currentEntryInChain = wordAtHash;
		while(currentEntryInChain != null) {
			if(currentEntryInChain.getWord().equals(wordToRemove.getWord())) {
				currentEntryInChain.setNextWord(currentEntryInChain.getNextWord());
				return;
			}
			currentEntryInChain = currentEntryInChain.getNextWord();
		}
	}

	public void printWord() {
		if(wordAtHash == null) return;
		LinkedWordEntry temp = wordAtHash;
		System.out.println(temp.getWord());
		while(temp.getNextWord() != null) {
			System.out.println(temp.getNextWord().getWord());
			temp = temp.getNextWord();
		}
	}
}