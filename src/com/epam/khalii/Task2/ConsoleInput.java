package com.epam.khalii.Task2;

import java.util.*;

/**
 * Created by Anhelina_Khalii on 16.04.2015.
 */
public class ConsoleInput {

 // 1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

 public static void printShorter(ArrayList<Integer> args) {
  int size = Integer.toString(Integer.MAX_VALUE).length(), el=Integer.MAX_VALUE;
  for (int iterator : args) {
   int itsize = Integer.toString(iterator).length();
   String siterator = Integer.toString(iterator);
   if (itsize < size) {
    size = itsize;
    el = iterator;
   }
  }
  System.out.println("Minimal length: "+size+" character in "+el+" element");
 }

 public static void printLonger(ArrayList<Integer> args){
  int size = Integer.toString(Integer.MIN_VALUE).length(), el=Integer.MIN_VALUE;
  for (int iterator : args) {
   int itsize = Integer.toString(iterator).length();
   String siterator = Integer.toString(iterator);
   if (itsize > size) {
    size = itsize;
    el = iterator;
   }
  }
  System.out.println("Maximal length: "+size+" character in "+el+" element");
 }

 //2. Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины.
 public static void sortDescAsc(ArrayList<Integer> args){
  ArrayList<String> result = new ArrayList<String>();
  for(int iterator:args){
   result.add(Integer.toString(iterator));
  }
  Collections.sort(result);
  System.out.print("Desc: ");
  for (String st: result){
   System.out.print(st + " ");
  }
  System.out.println();
 }

 public static void sortAsc(ArrayList<Integer> args){
  ArrayList<String> result = new ArrayList<String>();
  for(int iterator:args){
   result.add(Integer.toString(iterator));
  }
  Collections.sort(result);
  Collections.reverse(result);
  System.out.print("Asc: ");
  for (String st: result){
   System.out.print(st+" ");
  }
 }

 // 3. Вывести на консоль те числа, длина которых меньше (больше) средней, а также длину.
 public static void lessLength(ArrayList<Integer> args){
  ArrayList<String> result = new ArrayList<String>();
  for(int iterator:args){
   result.add(Integer.toString(iterator));
  }


 }


 public static void printMatrix(int size){
  //8. Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз.
  for(int i=0;i<size;i++) {
   for(int j=0;j<size;i++) {
    System.out.print(i+j+1);
   }
   System.out.println();
  }
 }

 public static void entryPoint(){
  System.out.println("Please, tap some number of integers in row. ");
  Scanner sc = new Scanner(System.in);
  try {
   if (sc.hasNext()) {
    String[] nums = sc.nextLine().split("\\s+");
    ArrayList<Integer> argum = new ArrayList<Integer>();
    for(int i=0;i<nums.length;i++) {
     argum.add(Integer.parseInt(nums[i]));
    }


    printMatrix(nums.length);
  }
 } catch (NumberFormatException ex) {
   System.out.println("You tap wrong arguments!");
   return;
  }
 }
}

/**
 * Ввести n чисел с консоли.
 1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
 2. Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины.
 3. Вывести на консоль те числа, длина которых меньше (больше) средней, а также длину.
 4. Найти число, в котором число различных цифр минимально. Если таких чисел несколько,
 найти первое из них.
 5. Найти количество чисел, содержащих только четные цифры, а среди них количество чисел
 с равным числом четных и нечетных цифр.
 6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел
 несколько, найти первое из них.
 7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти
 первое из них.

 */