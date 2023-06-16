package be.lmagnette;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

public class PatternMatchingSwitchMain {

    public static void main(String[] args) {
        System.out.println("---- PatternMatchingSwitch START ----");
        var printable = Arrays.asList(42,42L,42.0,"Hello");

        printable.stream().map(PatternMatchingSwitchMain::formatBeforeJava16).forEach(System.out::println);
        printable.stream().map(PatternMatchingSwitchMain::formatBeforeJava21).forEach(System.out::println);
        printable.stream().map(PatternMatchingSwitchMain::formatterPatternSwitch).forEach(System.out::println);


        var fooBarCases = Arrays.asList(null,"Foo","Bar");
        fooBarCases.forEach(PatternMatchingSwitchMain::testFooBarOld);
        fooBarCases.forEach(PatternMatchingSwitchMain::testFooBarNew);


        var stringCases = Arrays.asList(null,"Y","n","yes","No","Foo");
        stringCases.forEach(PatternMatchingSwitchMain::testStringOld);
        stringCases.forEach(PatternMatchingSwitchMain::testStringNew);
        stringCases.forEach(PatternMatchingSwitchMain::testStringEnhanced);




        System.out.println("---- PatternMatchingSwitch STOP ----");
    }

    static String formatBeforeJava16(Object o) {
        String formatted = "";
        //format all the values
        if (o instanceof Integer) {
            int i = (Integer) o;
            formatted = String.format("int %d", i);
        } else if (o instanceof Long) {
            long l = (Long) o;
            formatted = String.format("long %d", l);
        } else if (o instanceof Double) {
            double d = (Double) o;
            formatted = String.format("double %f", d);
        } else if (o instanceof String) {
            String s = (String) o;
            formatted = String.format("String %s", s);
        }
        return formatted;
    }

    static String formatBeforeJava21(Object obj) {
        String formatted = "unknown";
        if (obj instanceof Integer i) {
            formatted = String.format("int %d", i);
        } else if (obj instanceof Long l) {
            formatted = String.format("long %d", l);
        } else if (obj instanceof Double d) {
            formatted = String.format("double %f", d);
        } else if (obj instanceof String s) {
            formatted = String.format("String %s", s);
        }
        return formatted;
    }

    static String formatterPatternSwitch(Object obj) {
        return switch (obj) {
            case Integer i -> String.format("int %d", i);
            case Long l -> String.format("long %d", l);
            case Double d -> String.format("double %f", d);
            case String s -> String.format("String %s", s);
            default -> obj.toString();
        };
    }

    static void testFooBarOld(String s) {
        if (s == null) {
            System.out.println("Oops!");
            return;
        }
        switch (s) {
            case "Foo", "Bar" -> System.out.println("Great");
            default -> System.out.println("Ok");
        }
    }

    static void testFooBarNew(String s) {
        switch (s) {
            case null -> System.out.println("Oops!");
            case "Foo", "Bar" -> System.out.println("Great");
            default -> System.out.println("Ok");
        }
    }


    static void testStringOld(String response) {
        switch (response) {
            case null -> {
            }
            case String s -> {
                if (s.equalsIgnoreCase("YES"))
                    System.out.println("You got it");
                else if (s.equalsIgnoreCase("NO"))
                    System.out.println("Shame");
                else
                    System.out.println("Sorry?");
            }
        }
    }

    static void testStringNew(String response) {
        switch (response) {
            case null -> {
            }
            case String s when s.equalsIgnoreCase("YES") -> {
                System.out.println("You got it");
            }
            case String s when s.equalsIgnoreCase("NO") -> {
                System.out.println("Shame");
            }
            case String s -> {
                System.out.println("Sorry?");
            }
        }
    }
    static void testStringEnhanced(String response) {
        switch (response) {
            case null -> { }
            case "y", "Y" -> {
                System.out.println("You got it");
            }
            case "n", "N" -> {
                System.out.println("Shame");
            }
            case String s
                    when s.equalsIgnoreCase("YES") -> {
                System.out.println("You got it");
            }
            case String s
                    when s.equalsIgnoreCase("NO") -> {
                System.out.println("Shame");
            }
            case String s -> {
                System.out.println("Sorry?");
            }
        }
    }


}
