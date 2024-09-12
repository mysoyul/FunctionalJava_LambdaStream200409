package lambdasinaction._02stream.basic2;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class PuttingIntoPractice{
    public static void main(String ...args){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
        List<Transaction> txList2011 = transactions
                .stream() //Stream<Transaction>
                .filter(tx -> tx.getYear() == 2011)
                //.sorted(comparingInt(Transaction::getValue)) //ascending
                .sorted(comparingInt(Transaction::getValue).reversed()) //descending
                .toList();
        System.out.println("txList2011 = " + txList2011);

        // Query 2: What are all the unique cities where the traders work?
        List<String> cityList = transactions.stream() //Stream<Transaction>
                .map(tx -> tx.getTrader().getCity()) //Stream<String>
                .distinct()
                .toList();
        System.out.println("cityList = " + cityList);

        // Query 3: Find all traders from Cambridge and sort them by name.



        // Query 4: Return a string of all traders names sorted alphabetically.



        // Query 5: Are there any trader based in Milan?




        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.




        // Query 7: What's the highest value in all the transactions?



    }
}