public class CD implements Packable{
    String artist;
    String name;
    int published;

    public CD(String artist, String name, int published){
        this.artist = artist;
        this.name = name;
        this.published = published;
    }

    @Override
    public double weight() {
        return 0.1;
    }

    public String toString(){
        return artist + ": " + name + " (" + published + ")";
    }
}
