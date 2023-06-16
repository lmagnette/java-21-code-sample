package be.lmagnette;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;
import java.util.SequencedSet;
import java.util.TreeSet;

public class SequencedMain {


    public static void main(String[] args) {

        System.out.println("---- Sequenced START ----");
        sequencedList();
        sequencedSet();
        System.out.println("---- Sequenced STOP ----");
    }


    private static void sequencedSet(){
        TreeSet<String> treeSet = new TreeSet<>();

        System.out.println("treeSet is a " + (treeSet instanceof SequencedCollection ? "SequencedCollection" : "Set"));
        System.out.println("hashSet is a " + (treeSet instanceof SequencedSet ? "SequencedSet" : "Set"));


        for (int i = 0; i < 10; i++) {
            var value = Math.random();
            treeSet.add(String.valueOf(value));
        }



        //print the first element of the set
        System.out.println("---- First element ----");
        System.out.println("using TreeSet first:"+treeSet.first());
        //Java 21
        System.out.println("using sequence getFirst:"+treeSet.getFirst());

        //print the last element of the set
        System.out.println("---- Last element ----");
        System.out.println("using TreeSet last"+treeSet.last());
        //Java 21
        System.out.println("using sequence getLast:"+treeSet.getLast());



    }
    private static void sequencedList() {
        List<String> list = new ArrayList<>();

        System.out.println("usualList is a " + (list instanceof SequencedCollection ? "SequencedCollection" : "List"));

        // generate random value string
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(Math.random()));
        }

        System.out.println("---- First element ----");
        //print the first element of the list
        System.out.println("using list get by index:"+list.get(0));
        //Java 21
        System.out.println("using sequence getFirst"+list.getFirst());

        System.out.println("---- Last element ----");
        //print the last element of the list
        System.out.println("using list get by index:"+list.get(list.size() - 1));
        //Java 21
        System.out.println("using sequence getLast:"+list.getLast());
    }
}
