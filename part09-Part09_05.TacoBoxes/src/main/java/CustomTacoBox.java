public class CustomTacoBox implements TacoBox{

    private int tacosRemaining;

    public CustomTacoBox(int numbOfTacos){
        this.tacosRemaining = numbOfTacos;
    }

    @Override
    public int tacosRemaining() {
        return tacosRemaining;
    }

    @Override
    public void eat() {
        if (tacosRemaining > 0){ tacosRemaining--; }
    }
}
