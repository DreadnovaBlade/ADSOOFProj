class SaveMe {
	public static void main(String[] args) {
		WordStore words = new WordStoreImp(5);
		words.add("a");
		words.add("b");
		words.add("c");
		words.add("d");
		words.add("e");
		words.add("five");
		//for(int i = 0; i < 5; i++)
		//	((WordStoreImp)words).printWord(i);
	}
}