package be.lmagnette;

import java.util.Arrays;

sealed interface CardClassification permits Suit, Tarot {}
enum Suit implements CardClassification { CLUBS, DIAMONDS, HEARTS, SPADES }
final class Tarot implements CardClassification {}
public class PatterMatchingSwitchEnumMain {

    public static void main(String[] args) {

        System.out.println("---- PatterMatchingSwitchEnum START ----");

        testforHearts(Suit.HEARTS);
        testforHearts(Suit.CLUBS);

        var cardList = Arrays.asList(Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES, new Tarot());
        cardList.forEach(PatterMatchingSwitchEnumMain::exhaustiveSwitchWithoutEnumSupport);
        cardList.forEach(PatterMatchingSwitchEnumMain::exhaustiveSwitchWithBetterEnumSupport);

        System.out.println("---- PatterMatchingSwitchEnum STOP ----");


    }


    //before Java 21
    static void testforHearts(Suit s) {
        switch (s) {
            case HEARTS -> System.out.println("It's a heart!");
            default -> System.out.println("Some other suit");
        }
    }

    static void exhaustiveSwitchWithoutEnumSupport(CardClassification c) {
        switch (c) {
            case Suit s when s == Suit.CLUBS -> {
                System.out.println("It's clubs");
            }
            case Suit s when s == Suit.DIAMONDS -> {
                System.out.println("It's diamonds");
            }
            case Suit s when s == Suit.HEARTS -> {
                System.out.println("It's hearts");
            }
            case Suit s -> {
                System.out.println("It's spades");
            }
            case Tarot t -> {
                System.out.println("It's a tarot");
            }
        }
    }

    static void exhaustiveSwitchWithBetterEnumSupport(CardClassification c) {
        switch (c) {
            case Suit.CLUBS -> {
                System.out.println("It's clubs");
            }
            case Suit.DIAMONDS -> {
                System.out.println("It's diamonds");
            }
            case Suit.HEARTS -> {
                System.out.println("It's hearts");
            }
            case Suit.SPADES -> {
                System.out.println("It's spades");
            }
            case Tarot t -> {
                System.out.println("It's a tarot");
            }
        }
    }
}
