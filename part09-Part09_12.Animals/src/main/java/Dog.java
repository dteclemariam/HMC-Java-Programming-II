public class Dog extends Animal implements NoiseCapable{

    public Dog(){
        super("Dog");
    }

    public Dog(String name) {
        super(name);
    }

    public void bark(){
        System.out.println(name + " barks");
    }

    @Override
    public void makeNoise() {
        bark();
    }
}
