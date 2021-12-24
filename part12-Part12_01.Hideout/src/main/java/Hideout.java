public class Hideout <T> {
    private T hiddenObject;

    public Hideout() {
    }

    public void putIntoHideout(T objectToHide) {
            this.hiddenObject = objectToHide;
    }

    public T takeFromHideout() {
        T reply = this.hiddenObject;
        this.hiddenObject = null;
        return reply;
    }

    public boolean isInHideout() {
        return hiddenObject != null;
    }
}
