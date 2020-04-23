package com.muti.learning.Java14Funcional.functionalInterfaces;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsPOC {


   public static void main(final String[] args) {

      final List<Worker> workers = workerBuilder(5);
      // FlatMap can take every list with the objects of an stream and make all of those elements into a single list
      final Optional<String> allSkills = workers.stream().flatMap(worker -> worker.getSkills().stream())
            .reduce((x, y) -> x + "," + y);
      allSkills.ifPresent(System.out::println);
   }

   public static List<Worker> workerBuilder(final int amount) {
      return Stream.iterate(0, x -> x + 1).limit(amount)
            .map(x -> Worker.builder().Id(x + "").skills(addElements(x)).build()).collect(Collectors.toList());
   }

   public static List<String> addElements(final int amount) {
      final Function<Integer, String> intToAscii = x -> (char) x.intValue() + "-skill";
      return Stream.iterate(100, x -> x + 1).limit(amount).map(intToAscii::apply)
            .collect(Collectors.toList());
   }

}
