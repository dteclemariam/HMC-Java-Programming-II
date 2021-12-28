import java.util.ArrayList;
import java.util.List;

public class HashMap <K, V>{

    private List<Pair<K, V>> [] values;
    private int numberOfPairs;

    public HashMap(){
        this.values = new List[32];
        this.numberOfPairs = 0;
    }

    public V get(K key){
        int hashValue = getKeyHashValue(key);
        //returns null if there are no Pairs in the Array with the index of the calculated hashCode of the key
        if(this.values[hashValue] == null) return null;

        List<Pair<K, V>> valuesAtIndex = values[hashValue];

        //Runs through the List returned based on the hashCode of the key, goes to the keys of the Pairs
        //returns the value of the key/value pair if the key in the pair matches the key from the parameter
        for (int i = 0; i < valuesAtIndex.size(); i++) {
            if (valuesAtIndex.get(i).getKey().equals(key)){
                return valuesAtIndex.get(i).getValue();
            }
        }
        return null ;
    }

    private int getKeyHashValue(K key){
        //The hash value is calculated with the hashCode method that each object has.
        // Then modulo (remainder of division operation) is used for ensuring that the index stays within the
        // size boundaries of the internal array.
        return Math.abs(key.hashCode() % values.length);
    }

    public void add (K key, V value){
        //Gets the list from the Array based on the provided key
        List<Pair<K, V>> valuesAtIndex = getListBasedOnKey(key);
        //gets the index of the corresponding key in the List, or -1 one if not found
        int index = getIndexOfKey(valuesAtIndex, key);

        //if key not found add the pair to List in the array with the index calculated from the hashValue of the key
        //and increments firstFreeIndex.
        //If the corresponding key is found changes the value of that specific key
        if (index < 0){
            valuesAtIndex.add(new Pair<>(key, value));
            this.numberOfPairs++;
        }else{
            valuesAtIndex.get(index).setValue(value);
        }

        if (1.0 * this.numberOfPairs / this.values.length > 0.75) grow();
    }

    private int getIndexOfKey(List<Pair<K, V>> myList, K key){
        //Gets the List from the index of the array where the key would be
        //returns the index of the pair with the matching key or -1 if not found
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getKey().equals(key)){
                return i;
            }
        }
        return -1;
    }

    //Returns a List of the Pairs with the corresponding index from the array with the parameter keys hasValue.
    //Or creates a new Array list at the index of the array if its null
    private List<Pair<K, V>> getListBasedOnKey(K key){
        int keyHashValue = getKeyHashValue(key);
        if (values[keyHashValue] == null){
            values[keyHashValue] = new ArrayList<>();
        }

        return values[keyHashValue];
    }

    private void grow(){
        //Create a new array with double size of the current
        List<Pair<K, V>> [] newList = new List[this.values.length * 2];
        //for each value in the values array, run copy() and copies the values from values, to newList.
        for (int i = 0; i < this.values.length; i++) {
            copy(newList, i);
        }

        //Replaces old array with new.
        this.values = newList;
    }

    //Copies the values of the old array in to the new array.
    private void copy(List<Pair<K, V>> [] newList, int fromIndex){
        //runs through Pairs in the List from the Array with the fromIndex


        for (int i = 0; i < this.values[fromIndex].size() ; i++) {
            //Takes the Pair from the List
            Pair<K, V> value = this.values[fromIndex].get(i);
            //calculates a new hashValue as the size of the new Array is double the old
            int hashValue = getKeyHashValue(value.getKey());
            //If the the index of the hashvalue in the Array is null, creates a new ArrayList there
            if (newList[hashValue] == null){
                newList[hashValue] = new ArrayList<>();
            }
            //Add Pair to the List in the index of the array with the same value has newly calculated hashValue
            newList[hashValue].add(value);
        }
    }

    public V remove(K key){
        //Gets the list of the pair(s) in the index,
        //if empty a new Arraylist is created at the index and an arraylist with 0 objects is returned
        List<Pair<K, V>> values = getListBasedOnKey(key);
        if (values.size() == 0) return null;

        //Gets index of key, if not found returns -1
        int indexOfKey = getIndexOfKey(values, key);

        //The returned value is -1 and means the key vas not found
        if (indexOfKey < 0){
            return null;
        }

        //Returns the value of the key
        return values.get(indexOfKey).getValue();
    }



}