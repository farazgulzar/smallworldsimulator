package com.smallworld.simulator.util;

public class InvertPhraseUtil {
	private String specialCharacters = "!#$%&'()*+,./:;<=>?@[]^_`{|}~";

	// InvertStr will be a static implementation for the highlighted problem
	public String invertStr(String inputPhrase) {
		String invertedPhrase = null;

		try {
			String[] wordsArray = inputPhrase.trim().split(" ");

			String temp = "";

			for (int i = wordsArray.length - 1; i >= 0; i--) {

				if (wordsArray[i].lastIndexOf("?") != -1) {
					temp += "?" + wordsArray[i].split("\\?")[0] + " ";

				} else if (i > 0 && wordsArray[i - 1].lastIndexOf(",") != -1) {
					temp += wordsArray[i] + ", ";

				} else {
					temp += wordsArray[i].contains(",") ? wordsArray[i].split("\\,")[0] : wordsArray[i] + " ";
				}
			}

			invertedPhrase = temp;
			this.printInvertedStr(inputPhrase, invertedPhrase);
		} catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
			arrayIndexOutOfBoundsException.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			return invertedPhrase = "";
		}
		
		return invertedPhrase.trim();
	}

	// invertStr2 will be dynamically look into specialCharacters defined in global
	// variable
	public String invertStr2(String inputPhrase) {
		String invertedPhrase = null;
		try {
			String[] wordsArray = inputPhrase.trim().split(" ");
			invertedPhrase = traverseEachWordElement(wordsArray);
			this.printInvertedStr(inputPhrase, invertedPhrase);

		} catch (Exception e) {
			e.printStackTrace();
			return invertedPhrase = "";
		}
		return invertedPhrase.trim();
	}

	public String traverseEachWordElement(String[] wordsArray) {
		String temp = "";
		for (int i = wordsArray.length - 1; i >= 0; i--) {

			String specialCharacter = "";
			boolean isInNextElement = false;
			boolean isInCurrentElement = false;

			specialCharacter = findSpecialCharacterInWord(wordsArray[i]);
			if (specialCharacter.isEmpty()) {
				specialCharacter = findSpecialCharacterInWord(i == 0 ? wordsArray[i] : wordsArray[i - 1]);
				if (specialCharacter.isEmpty()) {
					isInNextElement = true;
				}
			} else {
				isInCurrentElement = true;
			}

			if (i != 0 && !specialCharacter.isEmpty() && wordsArray[i].lastIndexOf(specialCharacter) != -1) {

				if (isInNextElement && i == wordsArray.length - 1) {
					temp += specialCharacter + wordsArray[i].split("\\" + specialCharacter)[0] + " ";
				} else if (isInCurrentElement) {
					temp += i == wordsArray.length - 1
							? specialCharacter + (wordsArray[i].split("\\" + specialCharacter).length > 0
									? wordsArray[i].split("\\" + specialCharacter)[0] : "") + " "
							: wordsArray[i].split("\\" + specialCharacter)[0] + " ";

					specialCharacter = findSpecialCharacterInWord(i == 0 ? wordsArray[i] : wordsArray[i - 1]);
					if (specialCharacter.isEmpty()) {
						temp = temp.trim();
						temp += specialCharacter + " ";
					}
				} else {
					temp += wordsArray[i].split("\\" + specialCharacter)[0] + " ";
				}

			} else if (i > 0 && !specialCharacter.isEmpty() && wordsArray[i - 1].lastIndexOf(specialCharacter) != -1) {
				temp += wordsArray[i] + specialCharacter + " ";
			} else {

				temp += wordsArray[i].indexOf(specialCharacter) != 0 ? wordsArray[i].split("\\" + specialCharacter)[0]
						: wordsArray[i] + " ";
			}
		}

		return temp.trim();
	}

	// Is to be used in dynamic implementation
	public String findSpecialCharacterInWord(String word) {
		char[] specialCharArr = specialCharacters.toCharArray();
		for (int index = 0; index < specialCharArr.length; index++) {
			if (word.contains(String.valueOf(specialCharArr[index]))) {
				return String.valueOf(specialCharArr[index]);
			}
		}

		return "";
	}

	// For printing the provided input and inverted output
	public void printInvertedStr(String inputPhrase, String invertedPhrase ) {
		System.out.println("Input phrase :: " + inputPhrase);
		System.out.println("Inverted Phrase :: " + invertedPhrase);
	}

}
