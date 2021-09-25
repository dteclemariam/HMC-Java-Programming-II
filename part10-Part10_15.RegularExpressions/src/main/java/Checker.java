

public class Checker {

    public Checker(){
    }

    public boolean isDayOfWeek(String string){
        //Returns true if the string is one of the alternatives
        String dayChecker = "(mon|tue|wed|thu|fri|sat|sun)";
        return string.matches(dayChecker);
    }

    public boolean allVowels(String string){
        //Returns true if the string has only characters that are represented in the bracket 0 to n times
        String vowelChecker = "[aeiou]*";
        return string.matches(vowelChecker);
    }

    public boolean timeOfDay(String string){
        //The acceptable values are between 00:00:00 and 23:59:59.
        String timeChecker = "([0-1][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
        return string.matches(timeChecker);
    }

}
