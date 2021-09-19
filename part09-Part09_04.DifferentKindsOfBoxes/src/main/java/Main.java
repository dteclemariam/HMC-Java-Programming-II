

public class Main {

    public static void main(String[] args) {
        // You can test your program here

        Box boxWithMaxWeight = new BoxWithMaxWeight(5);
        boxWithMaxWeight.add(new Item("a", 1));
        boxWithMaxWeight.add(new Item("b", 2));
        boxWithMaxWeight.add(new Item("c", 2));
        boxWithMaxWeight.add(new Item("d", 1));
        System.out.println(boxWithMaxWeight.isInBox(new Item("c")));
        System.out.println(boxWithMaxWeight.isInBox(new Item("d")));

        OneItemBox oneItemBox = new OneItemBox();
        oneItemBox.add(new Item("Saludo", 5));
        oneItemBox.add(new Item("Pirkka", 5));

        System.out.println(oneItemBox.isInBox(new Item("Saludo")));
        System.out.println(oneItemBox.isInBox(new Item("Pirkka")));

        MisplacingBox misplacingBox = new MisplacingBox();
        misplacingBox.add(new Item("Saludo", 5));
        misplacingBox.add(new Item("Pirkka", 5));

        System.out.println(misplacingBox.isInBox(new Item("Saludo")));
        System.out.println(misplacingBox.isInBox(new Item("Pirkka")));
    }
}
