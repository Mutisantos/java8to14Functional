package com.muti.learning.Java14Funcional.functionalInterfaces;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.Random;

public class FunctionCompositionPOC {

   final static Function<Integer, Integer> multiply2 = x -> x * 2;
   final static Function<Integer, Integer> power2 = x -> x * x;
   final static Consumer<String> printConsumer = x -> System.out.println(x);
   final static Supplier<Integer> intRandomGenerator = () -> {
      Random rand = new Random();
      return rand.nextInt(9);
   };

   public static void main(final String[] args) {
      // With compose, it will do first the function within (power2) and the result will be used for the first function
      // (multiply2) => (4*4)*2 => 32
      printConsumer.accept("Using compose:" + multiply2.compose(power2).apply(intRandomGenerator.get()));

      // With compose, it will use the first function (multiply2) and then it will do the function within (power2) =>
      // (4*2)(4*2) => 64
      printConsumer.accept("Using andThen:" + multiply2.andThen(power2).apply(intRandomGenerator.get()));

   }

}
