public class List <Type>{
    private Type [] values;
    private int firstFreeIndex;

    public List (){
        //Creates new Array of object Type, f.eks List<String> creates an Array of type String with the size of 10
        this.values = (Type []) new Object [10];
        this.firstFreeIndex = 0;
    }

    public void add(Type value){
        //If the index of the next free spot in the Array is the same as size, grow is called
        if (this.firstFreeIndex == this.values.length) grow();

        this.values[this.firstFreeIndex] = value;
    }

    //Creates a new Array the size of values x 1,5, adds the not empty values of values to the new Array,
    // and points the values to the new Array
    private void grow(){
        Type [] newArray = (Type []) new Object[this.values.length + (this.values.length) / 2];
        for (int i = 0; i < this.firstFreeIndex; i++) {
            newArray[i] = this.values[i];
        }
    }

    private boolean contains(Type value){
        return indexOfValue(value) >=0;
    }

    private int indexOfValue(Type value){
        for (int i = 0; i < this.firstFreeIndex; i++) {
            if (this.values[i].equals(value)) return i;
        }
        return -1;
    }

    public Type value(int index){
        //Throws the exception ArrayOutOfBounds if the index used for search is lower than 0,
        //or bigger than firstFreeIndex
        if (index < 0 || index > this.firstFreeIndex){
            throw new ArrayIndexOutOfBoundsException("Index " + index + " outside of [0, " + this.firstFreeIndex + "]");
        }
        return this.values[index];
    }

    public void remove(Type value){
        int index = indexOfValue(value);
        if (index < 0) return;
        moveToTheLeft(index);

    }

    private void moveToTheLeft(int index){
        //moves all the object in the Array until first free index to the left, starting with the object after the
        //object that is to be removed
        for (int i = index; i < this.firstFreeIndex; i++) {
            values[i] = values[i + 1];
        }
        this.firstFreeIndex--;
    }

    public int size(){
        return this.firstFreeIndex;
    }
}
