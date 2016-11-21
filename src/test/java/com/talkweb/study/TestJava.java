package com.talkweb.study;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface Square {
    double perimeter(double a, double b, double c, double d);

    default double area(double a, double h) {
        return a * h;
    }
}

interface Converter<F, T> {
    T convert(F from);
}

interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}

class Rectangle implements Square {
    @Override
    public double perimeter(double a, double b, double c, double d) {
        return a + b + c + d;
    }
}

public class TestJava {

    public static void main(String[] args) {

        Square square = new Rectangle();
        System.out.println(square.area(5, 10));

        Something something = new Something();
        Converter<String, String> converter = something::startsWith;
        String converted = converter.convert("JAVA SCRIPTS");
        System.out.println(converted);    //

        Runnable runnable = () -> System.out.println("Hello world");
        runnable.run();

        PersonFactory personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");

        Converter<Integer, String> stringConverter = (from) -> {
            int a = 111;
            return from + " Fxxk" + a;
        };

        Predicate<String> predicate = s -> s.length() > 2;
        System.out.println(predicate.test("aaaa"));
        System.out.println(predicate.test("cc"));

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();


        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        System.out.println(backToString.apply("11111"));

        Supplier<Person> personSupplier = Person::new;
        personSupplier.get();

        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getFirstName());
        greeter.accept(new Person("Luke", "Skywalker"));


        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        stringCollection.stream().sorted().filter(s -> s.startsWith("a")).forEach(System.out::print);
        System.out.println();
        stringCollection.stream().map(String::toUpperCase).sorted((a, b) -> b.compareTo(a)).forEach(System.out::print);
        System.out.println();

//        int max = 1000000;
//        List<String> values = new ArrayList<>(max);
//        for (int i = 0; i < max; i++) {
//            UUID uuid = UUID.randomUUID();
//            values.add(uuid.toString());
//        }
//
//        long t0 = System.nanoTime();
//        long count = values.stream().sorted().count();
//        System.out.println(count);
//        long t1 = System.nanoTime();
//        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
//        System.out.println(String.format("sequential sort took: %d ms", millis));
//
//
//        long t2 = System.nanoTime();
//        count = values.parallelStream().sorted().count();
//        System.out.println(count);
//        long t3 = System.nanoTime();
//        millis = TimeUnit.NANOSECONDS.toMillis(t3 - t2);
//        System.out.println(String.format("parallel sort took: %d ms", millis));


        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }

        map.forEach((id, val) -> System.out.println(val));
        map.computeIfPresent(3, (key, val) -> "key " + key + " old value " + val + " change to new value");
        System.out.println(map.get(3));

        map.computeIfAbsent(11, (key) -> "im the new value of key " + key);
        System.out.println(map.get(11));

        System.out.println(map.getOrDefault(12, "key 12 not exist!"));


        map.remove(9);
        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9));            // val9
        map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9));            // val9

        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};

        Arrays.sort(players, (s1, s2) -> s1.compareTo(s2));
        Arrays.asList(players).forEach(System.out::println);

        Arrays.asList(players).stream().sorted().forEach(System.out::println);


        List<Person> javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
                add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
                add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
                add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
                add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
                add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
                add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
                add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
                add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
                add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
            }
        };

        List<Person> phpProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
                add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
                add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
                add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
                add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
                add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
                add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
                add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
                add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
                add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
            }
        };


        javaProgrammers.forEach(p -> System.out.printf("%s %s;", p.getFirstName(), p.getLastName()));
        System.out.println();
        phpProgrammers.forEach(p -> System.out.printf("%s %s;", p.getFirstName(), p.getLastName()));

        Consumer<Person> giveRaise = e -> e.setSalary(e.getSalary() / 100 * 5 + e.getSalary());
        javaProgrammers.forEach(giveRaise);
        phpProgrammers.forEach(giveRaise);

        phpProgrammers.stream().filter(p -> (p.getSalary() > 1400)).forEach(p -> System.out.printf("%s %s;", p.getFirstName(), p.getLastName()));
        System.out.println();

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        DoubleSummaryStatistics stats = numbers
                .stream()
                .mapToDouble(x -> x * x)
                .summaryStatistics();

        System.out.println("List中最大的数字 : " + stats.getMax());
        System.out.println("List中最小的数字 : " + stats.getMin());
        System.out.println("所有数字的总和   : " + stats.getSum());
        System.out.println("所有数字的平均值 : " + stats.getAverage());

    }
}

class Something {
    public String startsWith(String str) {
        return str.substring(0, 1);
    }
}

class Person {
    private String firstName, lastName, job, gender;
    private int salary, age;

    Person() {
    }

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, String job,
                  String gender, int age, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.job = job;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

