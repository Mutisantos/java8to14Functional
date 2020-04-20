package com.muti.learning.Java14Funcional.functionalInterfaces;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Worker {
   private List<String> skills;
   private String Id;
}