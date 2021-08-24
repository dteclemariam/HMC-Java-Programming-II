import java.util.HashMap;

public class Abbreviations {
    private HashMap<String, String> dictionary = new HashMap<>();

    public Abbreviations(){}

    public void addAbbreviation(String abbreviation, String explanation){
        abbreviation = sanitizedString(abbreviation);

        if (hasAbbreviation(abbreviation)){
            System.out.println("Abbreviation is already in the dictionary!");
            return;
        }

        explanation = sanitizedString(explanation);
        dictionary.put(abbreviation, explanation);

    }

    public String sanitizedString(String string){
        string.trim();
        string.toLowerCase();

        return string;
    }

    public boolean hasAbbreviation(String abbreviation){
        return dictionary.containsKey(abbreviation);
    }

    public String findExplanationFor(String abbreviation){
        return dictionary.get(abbreviation);
    }

}
