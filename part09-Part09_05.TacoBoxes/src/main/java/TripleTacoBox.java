public class TripleTacoBox implements TacoBox {
    private int tacosRemaining;

    public TripleTacoBox(){
        this.tacosRemaining = 3;
    }

    @Override
    public int tacosRemaining() {
        return tacosRemaining;
    }

    @Override
    public void eat() {
        if (tacosRemaining > 0){
            tacosRemaining--;
        }
    }
}
