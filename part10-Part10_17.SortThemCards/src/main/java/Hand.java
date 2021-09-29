import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Hand implements Comparable<Hand>{
    private List<Card> cards;

    public Hand(){
        cards = new ArrayList<>();
    }

    public void add(Card card){
        cards.add(card);
    }

    public void print(){
        cards.stream()
                .forEach(card -> System.out.println(card));
    }

    public void sort(){
        Collections.sort(cards);
    }

    public int getSumOfHand(){
        int sum = 0;
        Iterator<Card> iterator = cards.iterator();
        while (iterator.hasNext()){
            sum += iterator.next().getValue();
        }
        return sum;

        //Using stream
//        int sumOfHand = cards.stream()
//                .map(card -> card.getValue())
//                .reduce(0,(valueOne, valueTwo) -> valueOne + valueTwo);
//
//        return sumOfHand;
    }

    public void sortBySuit(){
        Collections.sort(cards, new BySuitInValueOrder());
    }

    @Override
    public int compareTo(Hand otherHand) {
        return this.getSumOfHand() - otherHand.getSumOfHand();
    }
}
