package ua.com.foxminded.nezlipand.anagrams;

public class PushedText {
	public String enteredText = new String();

	public PushedText(String enteredText) {
		super();
		this.enteredText = enteredText;
	}

	public String stringToWords(String text) {
		String[] arrWords = text.split(" ");
		return anagraWords(arrWords);
	}

	public String anagraWords(String[] arrWords) {
		String[] anagraArrWords = arrWords;
		StringBuilder finalAnagraArrWords = new StringBuilder();
		char[] arrLetters = new char[0];
		char letterCopy = ' ';
		int leftToRightIndex = 0;
		int rightToLeftIndex = 0;

		for (int i = 0; i < anagraArrWords.length; i++) {
			arrLetters = anagraArrWords[i].toCharArray();
			leftToRightIndex = 0;
			rightToLeftIndex = arrLetters.length - 1;
			
			for (int k = 0; k < arrLetters.length; k++) {
				if (leftToRightIndex == rightToLeftIndex) {
					break;
				}
				else if (leftToRightIndex >= arrLetters.length || rightToLeftIndex <= 0) {
					break;
				}
				if ((Character.isLetter(arrLetters[leftToRightIndex])) && (Character.isLetter(arrLetters[rightToLeftIndex]))) {
					letterCopy = arrLetters[leftToRightIndex];
					arrLetters[leftToRightIndex] = arrLetters[rightToLeftIndex];
					arrLetters[rightToLeftIndex] = letterCopy;
					
					leftToRightIndex++;
					rightToLeftIndex--;
				}
				else if (!(Character.isLetter(arrLetters[leftToRightIndex])) && !(Character.isLetter(arrLetters[rightToLeftIndex]))) {
					leftToRightIndex++;
					rightToLeftIndex--;
					continue;
				} else if (!(Character.isLetter(arrLetters[leftToRightIndex])) && Character.isLetter(arrLetters[rightToLeftIndex])) {
					leftToRightIndex++;
					continue;
				} else if (Character.isLetter(arrLetters[leftToRightIndex]) && !(Character.isLetter(arrLetters[rightToLeftIndex]))) {
					rightToLeftIndex--;
					continue;
				}
			}
			for(int k = 0; k < arrLetters.length; k++) {
				finalAnagraArrWords.append(arrLetters[k]);
			}
			finalAnagraArrWords.append(' ');
		}
		return finalAnagraArrWords.toString();
	}

	public String getEnteredText() {
		return enteredText;
	}

	public void setEnteredText(String enteredText) {
		this.enteredText = enteredText;
	}

	@Override
	public String toString() {
		return "PushedText [enteredText=" + enteredText + "]";
	}
}
