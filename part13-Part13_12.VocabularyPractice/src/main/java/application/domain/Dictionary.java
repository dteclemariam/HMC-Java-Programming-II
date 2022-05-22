package application.domain;

import java.util.*;

public class Dictionary {

    private List<String> words;
    private Map<String, String> translations;

    public Dictionary(){
        words = new ArrayList<>();
        translations = new HashMap<>();
        addTranslation("Test", "Test");
    }

    //Return translation of word
    public String getTranslation(String word){
        // Returns the value of the key or null if no value connected to key
        return this.translations.get(word);
    }

    public void addTranslation(String word, String translation){
        // If dictionary doesn't have the word, adds it to the words arrayList
        if (!translations.containsKey(word)){
            words.add(word);
        }

        // Adds the word and the translation to the hashMap, or if key exits replaces the value
        translations.put(word, translation);
    }

    public String getRandomWord(){
        Random random = new Random();
        // Returns a value from the ArrayList between the index 0 and the ArrayLists size
        return words.get(random.nextInt(this.words.size()));
    }
}
