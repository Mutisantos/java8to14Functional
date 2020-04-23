package com.muti.learning.Java14Funcional.functionalInterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class OptionalsPOC {


   
   public static final Consumer<String> formattedPrint = x -> System.out.print(x+"::Numero de Caracteres:"+x.length()+"--------------");
   
   public static void main(final String[] args) {

      final String names[] = { "Ali", null, "Xi", null };
      List<Optional<String>> nameStream = new ArrayList<>();
      
      for (String name : names) {
         nameStream.add(mvpOptionalName(name));
      }
      
      for (Optional<String> optional : nameStream) {
         String uppercase = null;
         uppercase = optional.orElse("\nEsto es Nulo!").toUpperCase();
         System.out.println(uppercase);
         optional.ifPresent(formattedPrint);
      }
   }
   
   public static Optional<String> mvpOptionalName(final String name) {
      return Optional.ofNullable(name);
   }
   
   

}
