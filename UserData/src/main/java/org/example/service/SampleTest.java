package org.example.service;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Stream;

public class SampleTest {
  public static void main(String args[]) {
//        List<Integer> list = new ArrayList<>();
//        list.add(120);
//        list.add(102);
//        list.add(301);
//        list.add(64);
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(30);
//        list1.add(40);
//        list.addAll(list1);
      //       list.clear();
//        if (list.contains(1))
//        {
//            System.out.println("List  contains 1");
//        }
//        else {
//            System.out.println("List not contains 1");
//        }

//        Comparator<Integer> comparator=new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2<o1 ? 1:-1;
//            }
//        };
//        Collections.sort(list);
//        Collections.reverse(list);


//        for (Integer value:list
//             ) {
//            System.out.println(value);
//        }
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()) {
//            Object element = iterator.next();
//        System.out.println(element);
//
//        }
//      List<Person> people = new ArrayList<>();
//      people.add(new Person("Raj", 25));
//      people.add(new Person("Ram", 20));
//      people.add(new Person("Ravi", 30));
//
//      Collections.sort(people);
//
//      for (Person person : people) {
//          System.out.println(person.getName() + " " + person.getAge());
//      }
//
//  }
//}
//
//class Person implements Comparable<Person> {
//    private String name;
//    private int age;
//
//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    @Override
//    public int compareTo(Person other) {
//        return this.age - other.age;
//
      /*----------------------------------------------------------------------------------------*/
      /*tasks on stream and parllel stream */

    /*  List<Integer> list=new ArrayList<>();
      for(int index=0;index<=100000;index++) {
          list.add(index);
      }
      long startTime=System.currentTimeMillis();
      System.out.println(startTime);
      list.stream().forEach(item-> {
          int doubleValue = item * item;
      });
      long endTime=System.currentTimeMillis();
      System.out.println(endTime);
      System.out.println("Final Time = " + (endTime - startTime) );*/

      /*----------------------------------Parllel Streams------------------------------------------------------*/
   /*   List<Integer> list=new ArrayList<>();
      for(int index=0;index<=100000;index++) {
          list.add(index);
      }
      long startTime=System.currentTimeMillis();
      System.out.println(startTime);
      list.parallelStream().forEach(item-> {
          int doubleValue = item * item;
      });
      long endTime=System.currentTimeMillis();
      System.out.println(endTime);
      System.out.println("Final Time = " + (endTime - startTime) );*/

      /*-------------------------------------FIlter Streams----------------------------------------------------*/
     /* List<Integer> list=new ArrayList<>();
      for(int index=0;index<=100;index++) {
          list.add(index);
      }
      list.stream().filter(item->item%2==0).forEach(System.out::println);*
/*-------------------------------------Differnt Filter stream ---------------------------------------------*/
      /*List<String> list=new ArrayList<>();*/


      /*---------------------------------Streams using object-------------------------------------------------- */
/*      Stream<Integer> stream=list.stream();
      long startTime=System.currentTimeMillis();
      System.out.println(startTime);
      stream.forEach(even->{
      int doublevalue=even*even;
      });
      long endTime=System.currentTimeMillis();
      System.out.println(endTime);
      System.out.println("Final Time = " + (endTime - startTime) );
      */
      /*----------------------------Difference between Arraylist and Linkedlist(Speed of getting the data is slow in linked list) -------------------------------------*/
  /*    ArrayList<Integer> arrayList = new ArrayList<>();
      LinkedList<Integer> linkedList = new LinkedList<>();

      // Add elements to the ArrayList and LinkedList
      for (int i = 0; i < 100000; i++) {
          arrayList.add(i);
          linkedList.add(i);
      }

      // Access elements at a specific index
      long startTime = System.nanoTime();
      int value1 = arrayList.get(1);
      long endTime = System.nanoTime();
      long arrayListTime = endTime - startTime;

      startTime = System.nanoTime();
      int value2 = linkedList.get(1);
      endTime = System.nanoTime();
      long linkedListTime = endTime - startTime;

      System.out.println("ArrayList time: " + arrayListTime + " ns");
      System.out.println("LinkedList time: " + linkedListTime + " ns");*/

      /*----------------------------------Difference between Arraylist,LinkedList and Set------------------------------------*/
  /*  List<Integer> arrayList = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    List<Integer> linkedList = new LinkedList<>();

    for (int i = 0; i < 100000; i++) {
      arrayList.add(i);
      set.add(i);
      linkedList.add(i);
    }

    // Check for the presence of an element
    long startTime = System.nanoTime();
    boolean contains1 = arrayList.contains(88888);
    long endTime = System.nanoTime();
    long arrayListTime = endTime - startTime;

    startTime = System.nanoTime();
    boolean contains2 = set.contains(88888);
    endTime = System.nanoTime();
    long setTime = endTime - startTime;

    startTime = System.nanoTime();
    boolean contains3 = linkedList.contains(88888);
    endTime = System.nanoTime();
    long linkedTime = endTime - startTime;


    System.out.println("ArrayList time: " + arrayListTime + " nanoseconds");
    System.out.println("linkedlist time: " + linkedTime + " nanoseconds");
    System.out.println("Set time: " + setTime + " nanoseconds");*/

      /*--------------------------------Treeset--------------------------------------------------*/
    /*
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(10);
        hashSet.add(5);
        hashSet.add(20);
        hashSet.add(15);

        // Create a TreeSet and add the same elements
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(5);
        treeSet.add(20);
        treeSet.add(15);

        // Print the elements in each set
        System.out.println("HashSet: " + hashSet);
        System.out.println("TreeSet: " + treeSet);*/

      /*-----------------------Hashmap---------------------------------------------*/
       /* Map<Integer,String> map=new HashMap<>();
        map.put(1,"raju");
        map.put(2,"ram");
        map.put(3,"ramu");

        for(Map.Entry<Integer,String> value: map.entrySet()){
            System.out.println(value.getKey() + " -> " + value.getValue());
        }*/
//      map.forEach((key, value) -> System.out.println(key + " -> " + value));
     /* Map<Integer,Integer> map=new HashMap<>();
      map.put(1,1);
      map.put(2,2);
      map.put(3,3);
      map.forEach((key,value)-> System.out.println(key+"------"+value));
      }*/
      /*Map<Integer, Integer> map = new TreeMap<>();
      map.put(35, 1);
      map.put(45, 2);
      map.put(25, 3);
      map.forEach((key,value)-> System.out.println(key+"------"+value));*/
      /*List<Integer> list = new LinkedList<>();
      for(int index=0;index<=100;index++)
      {
          list.add(index);
      }
      long startTime=System.nanoTime();
      System.out.println(startTime);
      list.stream().filter((item)->item%2==0);
      long endTime=System.nanoTime();
      System.out.println(endTime);
      System.out.println(startTime-endTime);
      startTime=System.nanoTime();
      System.out.println(startTime);
      list.stream().filter((item)->item%2==0);
      endTime=System.nanoTime();
      System.out.println(endTime);
      System.out.println(startTime-endTime);*/

   /*   List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");

      strings.parallelStream()
              .map(String::toUpperCase)
              .forEach(System.out::println);*/
      List<String> strings = Arrays.asList("1.2", "2.5", "3.8", "4.1");

      strings.stream()
              .mapToDouble(Double::parseDouble)
              .forEach(System.out::println);

  }
}
