class HashFunction {
	public int createHashKey(String wordToHash, int arraySize) {
		int hashKey = 0;
		for(int i = 0; i < wordToHash.length(); i++) {
			int alphabetCode = wordToHash.charAt(i) - 96;
			hashKey = (hashKey * 27 + alphabetCode) % arraySize;
		}
		return hashKey;
	}
}