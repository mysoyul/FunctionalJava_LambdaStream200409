package lambdasinaction;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class MapFlatMapTest {
    /*
        Stream 의 map() 과 flatMap의 차이점 이해
    */
    @Test
    public void transformUsingStream() {
        List<Customer> customers = List.of(
                new Customer(101, "john", "john@gmail.com", Arrays.asList("397937955", "21654725")),
                new Customer(102, "smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947")),
                new Customer(103, "peter", "peter@gmail.com", Arrays.asList("38946328654", "3286487236")),
                new Customer(104, "kely", "kely@gmail.com", Arrays.asList("389246829364", "948609467"))
        );
        //email 주소 목록 List<String>
        List<String> emailList = customers.stream()  //Stream<Customer>
                .map(Customer::getEmail) //Stream<String>
                .toList();//List<String>

        emailList.forEach(System.out::println);

        customers.stream()
                .map(Customer::getEmail)
                .toList()
                .forEach(System.out::println);

        //map() : <R> Stream<R> map(Function<? super T,? extends R> mapper)
        List<List<String>> phoneList = customers.stream() //Stream<Customer>
                .map(Customer::getPhoneNumbers) //Stream<List<String>>
                .toList(); //List<List<String>>
        System.out.println("map() phoneList = " + phoneList);

        //flatMap : <R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)
        List<String> phoneList2 = customers.stream() //Stream<Customer>
                .flatMap(customer -> customer.getPhoneNumbers().stream())   //Stream<String>>
                .toList();
        System.out.println("flatMap() phoneList = " + phoneList2);

    }

    static class Customer {
        private final int id;
        private final String name;
        private final String email;
        private final List<String> phoneNumbers;

        public Customer(int id, String name, String email, List<String> phoneNumbers) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.phoneNumbers = phoneNumbers;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public List<String> getPhoneNumbers() {
            return phoneNumbers;
        }
    }
}
