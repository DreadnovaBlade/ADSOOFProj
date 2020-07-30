class LinkedWordEntry {
	//private int index;
	private String word;
	private LinkedWordEntry nextWord;

	public LinkedWordEntry(String word) {
		//this.index = index;
		this.word = word;
		this.nextWord = null;
	}

	//public int getIndex() {
	//	return index;
	//}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public LinkedWordEntry getNextWord() {
		return nextWord;
	}

	public void setNextWord(LinkedWordEntry next) {
		this.nextWord = next;
	}
}