package dictionary;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class SaveableDictionary {
    private Map<String, String> dictionary;
    private String file;

    public SaveableDictionary() {
        dictionary = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this();
        this.file = file;

    }

    public void add(String word, String translation) {
        dictionary.putIfAbsent(word, translation);
    }

    public String translate(String word) {
        //simple search for value with key
        if (dictionary.containsKey(word)) return dictionary.get(word);

        //Go through the keys, and se if the get current key returns a value that is equal to the word.
        for (String key : dictionary.keySet()) {
            if (dictionary.get(key).equals(word)) return key;
        }

        return null;
    }

    public void delete(String word) {
        //Answer from SO for handling ConcurrentModificationException that I encountered
//        for (Iterator<Map.Entry<String, String>> it = dictionary.entrySet().iterator(); it.hasNext(); ) {
//            Map.Entry<String, String> entry = it.next();
//            if (entry.getKey().equals(word) || entry.getValue().equals(word)) {
//                it.remove();
//            }

        //My own solution, Iterate through the HashMap and remove set
        Iterator<Map.Entry<String, String>> iterator = dictionary.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entrySet = iterator.next();
            if (entrySet.getKey().equals(word) || entrySet.getValue().equals(word)) {
                iterator.remove();
            }
        }
    }

    public boolean load() {
        //The try-with-resources approach below is useful for handling resources,
        // because the program closes the used resources automatically.
        try (Scanner fileReader = new Scanner(new File(file))) {
            while (fileReader.hasNext()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");
                this.add(parts[0], parts[1]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public boolean save() {
        try {
            PrintWriter writer = new PrintWriter(file);
            String formatedText = "";

            //Example using for-loop
//            String key = "";
//            for (String currentKey: dictionary.keySet()) {
//                key = currentKey;
//                writer.println(currentKey + ":" + dictionary.get(key));
//            }

            //Using Iterator and the key-value set in the map
            Iterator<Map.Entry<String, String>> entryIterator = dictionary.entrySet().iterator();
            while (entryIterator.hasNext()) {
                formatedText = formatEntrySetForWriter(entryIterator.next());
                writer.println(formatedText);
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private String formatEntrySetForWriter(Map.Entry<String, String> entrySet) {
        return entrySet.getKey() + ":" + entrySet.getValue();
    }
}
