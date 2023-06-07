package KE5;

import java.util.*;

public class FilterTest {
    public static void main(String[] args) {
        ArrayList<Person> source = new ArrayList<Person>();
        source.add(new Person("Joe", 77.0));
        source.add(new Person("Bob", 90.2));
        source.add(new Person("Jenny", 44.2));
        source.add(new Person("Anna", 51.9));
        source.add(new Person("Peter", 84.3));
        source.add(new Person("George", 69.7));
        
        Filter<Person> personFilter = new Filter<Person>(source);
        List<Person> shortNameList = personFilter.filter(
            p -> p.getName().length() < 5
        );
        for (Person person : shortNameList) {
            System.out.println(person.getName());
        }
        
        ArrayList<String> source2 = new ArrayList<String>();
        source2.add("Otto");
        source2.add("test");
        source2.add("Lagerregal");
        source2.add("Teeet");
        
        Filter<String> palindromeFilter = new Filter<String>(source2);
        /*FilterPredicate<String> isPalindrome = new FilterPredicate<String>() {
            @Override
            public boolean isMatching(String candidate) {
                StringBuilder sb = new StringBuilder(candidate);
                String reverse = sb.reverse().toString();
                return candidate.equalsIgnoreCase(reverse);
            }
        };*/
        List<String> resultPalindrome = palindromeFilter.filter(
                s -> new StringBuilder(s).reverse().toString().equalsIgnoreCase(s)
        );
        for (String palindrome : resultPalindrome) {
            System.out.println(palindrome);
        }
        
        /*ArrayList<String> source = new ArrayList<String>();
        source.add("Otto");
        source.add("test");
        source.add("Lagerregal");
        source.add("Teeet");
        
        Filter<String> palindromeFilter = new Filter<String>(source);
        FilterPredicate<String> isPalindrome = new FilterPredicate<String>() {
            @Override
            public boolean isMatching(String candidate) {
                StringBuilder sb = new StringBuilder(candidate);
                String reverse = sb.reverse().toString();
                return candidate.equalsIgnoreCase(reverse);
            }
        };
        List<String> resultPalindrome = palindromeFilter.filter(isPalindrome);
        for (String palindrome : resultPalindrome) {
            System.out.println(palindrome);
        }
        ArrayList<Person> source2 = new ArrayList<Person>();
        source2.add(new Person("Joe", 77.0));
        source2.add(new Person("Bob", 90.2));
        source2.add(new Person("Jenny", 44.2));
        source2.add(new Person("Anna", 51.9));
        source2.add(new Person("Peter", 84.3));
        Filter<Person> personFilter = new Filter<Person>(source2);
        FilterPredicate<Person> hasShortName = new FilterPredicate<Person>()    {
            @Override
            public boolean isMatching(Person candidate) {
                return candidate.getName().length() < 5;
            }
        };
        List<Person> resultShortName = personFilter.filter(hasShortName);
        for (Person person : resultShortName) {
            System.out.println(person.getName());
        }
        FilterPredicate<Person> hasFeatherweight = new FilterPredicate<Person>() {
            @Override
            public boolean isMatching(Person candidate) {
                return candidate.getWeight() <= 60;
            }
        };
        List<Person> resultFeatherweight = personFilter.filter(hasFeatherweight);
        for (Person person : resultFeatherweight) {
            System.out.println(person.getName() +", Gewicht: " + person.getWeight());
        }*/
    }
}

interface FilterPredicate <T>   {
    boolean isMatching(T candidate);
}




class Filter<T>    {
    private List<T> sourceList;
    
    Filter(List<T> sourceList)  {
        this.sourceList = sourceList;
    }
    
    List<T> filter (FilterPredicate <T> filterPredicate)    {
        ArrayList<T> resultList = new ArrayList<T>();
        for (T elem : sourceList)   {
            if (filterPredicate.isMatching(elem))   {
                resultList.add(elem);
            }
        }
        return resultList;
    }
}

interface Weighable{
    double getWeight();
}

class Person implements Weighable, WakeUpServiceClient {
    protected String name;
    protected double weight;
    
    public Person(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
    
    String getName() {
        return name;
    }
    
    @Override
    public double getWeight() {
        return weight;
    }
    
    @Override
    public void wakeUp(int hour) {
        System.out.println("Person " + this.name + " needs to wake up, it is " + hour + ".");
    }
    
}


