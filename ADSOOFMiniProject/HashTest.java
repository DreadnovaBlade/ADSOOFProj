import java.util.*;
class HashTest {
	public static void main(String[] args) {
        String a = WordGen.make();
        int hashKeyValue = 0;
        for (int i = 0; i < a.length(); i++) {
            // 'a' has the character code of 97 so subtract
            // to make our letters start at 1
            int charCode = a.charAt(i) - 96;
            int hKVTemp = hashKeyValue;
            // Calculate the hash key using the 26 letters plus blank
            hashKeyValue = (hashKeyValue * 2  + charCode);
            System.out.println("Hash Key Value " + hKVTemp + " * 27 + Character Code " + charCode + "hashkey" + hashKeyValue);
        }
        System.out.println(a + " : " + hashKeyValue);
	}
}

class LinkedHashEntry {

      private int key;

      private int value;

      private LinkedHashEntry next;

 

      LinkedHashEntry(int key, int value) {

            this.key = key;

            this.value = value;

            this.next = null;

      }

 

      public int getValue() {

            return value;

      }

 

      public void setValue(int value) {

            this.value = value;

      }

 

      public int getKey() {

            return key;

      }

 

      public LinkedHashEntry getNext() {

            return next;

      }

 

      public void setNext(LinkedHashEntry next) {

            this.next = next;

      }

}

 

class HashMap {

 

      LinkedHashEntry[] table;

 

      HashMap(int n) {

            table = new LinkedHashEntry[n];

            for (int i = 0; i < n; i++)

                  table[i] = null;

      }

 

      public int get(int key) {

            int hash = (key % table.length);

            if (table[hash] == null)

                  return -1;

            else {

                  LinkedHashEntry entry = table[hash];

                  while (entry != null && entry.getKey() != key)

                        entry = entry.getNext();

                  if (entry == null)

                        return -1;

                  else

                        return entry.getValue();

            }

      }

 	public int getT() { return table.length; }

      public void put(int key, int value) {

            int hash = (key % table.length);

            if (table[hash] == null) {

                  table[hash] = new LinkedHashEntry(key, value);

            } else {

                  LinkedHashEntry entry = table[hash];

                  while (entry.getNext() != null && entry.getKey() != key)

                        entry = entry.getNext();

                  if (entry.getKey() == key)

                        entry.setValue(value);

                  else

                        entry.setNext(new LinkedHashEntry(key, value));

            }

      }

 

      public void remove(int key) {

            int hash = (key % table.length);

            if (table[hash] != null) {

                  LinkedHashEntry prevEntry = null;

                  LinkedHashEntry entry = table[hash];

                  while (entry.getNext() != null && entry.getKey() != key) {

                        prevEntry = entry;

                        entry = entry.getNext();

                  }

                  if (entry.getKey() == key) {

                        if (prevEntry == null)

                             table[hash] = entry.getNext();

                        else

                             prevEntry.setNext(entry.getNext());

                  }

            }

      }

//public void add(String word) {
//		if(pointer < words.length) {
//			words[pointer] = word;
//			pointer++;
//			return;
//		}
//		double d = Math.round(words.length*1.29226);
//		int yeet = (int)d;
//		System.out.println(yeet);
//		String[] temp = new String[yeet];
//		for(int i = 0; i < words.length; i++)
//			temp[i] = words[i];
//		words = temp;
//		words[pointer] = word;
//		pointer++;
//	}
//
//	public int count(String word) { 
//		int count = 0;
//		for(int i = 0; i < words.length; i++) {
//			if(word.equals(words[i]))
//				count++;
//		}
//		return count;
//	}


}
