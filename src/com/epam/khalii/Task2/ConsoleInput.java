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
 public static void sortDesc(ArrayList<Integer> args){
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
  int average=0;
  for(int iterator:args){
   result.add(Integer.toString(iterator));
   average+=Integer.toString(iterator).length();
  }
  average/=result.size();
  System.out.print("Element with lower then average size: ");
  for(int i=0;i<result.size();i++){
    if(result.get(i).length()<average){
     System.out.print("element "+result.get(i)+" length "+result.get(i).length()+", ");
    }
  }
 }

 public static void muchLength(ArrayList<Integer> args){
  ArrayList<String> result = new ArrayList<String>();
  int average=0;
  for(int iterator:args){
   result.add(Integer.toString(iterator));
   average+=Integer.toString(iterator).length();
  }
  average/=result.size();
  System.out.print("Element with lower then average size: ");
  for(int i=0;i<result.size();i++){
   if(result.get(i).length()>average){
    System.out.print("element "+result.get(i)+" length "+result.get(i).length()+", ");
   }
  }
 }


 //4. Найти число, в котором число различных цифр минимально. Если таких чисел несколько,
 //найти первое из них.
 private static boolean isUnique(String st){
  for(int i = 0; i<st.length();i++) {
   for (int j = i+1;j<st.length();j++){
    if (st.charAt(i)==st.charAt(j))
     return false;
   }
  }
  return true;
 }

 public static void minDifDigit(ArrayList<Integer> args){
  ArrayList<String> result = new ArrayList<String>();
  String winner="";
  for(int iterator:args){
   if(Integer.toString(iterator).length()<11){
   result.add(Integer.toString(iterator));
   }
  }
  int min = 11;
  for(String st: result){
   if(isUnique(st)&&st.length()<min){
    min=st.length();
    winner=st;
   }
  }
  System.out.println("Number with minimal count of unique digit is "+winner);
 }

 //5. Найти количество четных чисел, а среди них количество чисел
 //с равным числом четных и нечетных цифр.

 private static boolean isEvenOdd(String st){
  int even=0, odd=0;
  for(int i=0;i<st.length();i++){
   if(Character.getNumericValue(st.charAt(i))%2==0)
    even++;
   else odd++;
  }
  if(even==odd)
   return true;
  else
   return false;
 }

 public static void evenEvenOdd(ArrayList<Integer> args){
  ArrayList<String> result = new ArrayList<String>();
  for(int iterator:args){
   if(iterator%2==0){
    result.add(Integer.toString(iterator));
   }
  }
  int count=0;
  for(String st: result){
   if(isEvenOdd(st)){
    count++;
   }
  }
  System.out.println("Count of even numbers with equal number of even and odd digits is "+count);
 }

 //6. Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел
 //несколько, найти первое из них.

 private static boolean isProgression(String st){
  for(int i = 0; i<st.length();i++) {
   for (int j = i+1;j<st.length();j++){
    if (Character.getNumericValue(st.charAt(i))>Character.getNumericValue(st.charAt(j)))
     return false;
   }
  }
  return true;
 }

 public static void arifmProgr(ArrayList<Integer> args){
  ArrayList<String> result = new ArrayList<String>();
  String winner="";
  for(int iterator:args){
    result.add(Integer.toString(iterator));
  }
  for(String st: result){
   if(isProgression(st)){
    winner = st;
    System.out.println("Number with digit in arithmetic progression "+winner);
    break;
   }
  }
 }

 //7. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти
 //первое из них.

 public static void difDigit(ArrayList<Integer> args){
  ArrayList<String> result = new ArrayList<String>();
  String winner="";
  for(int iterator:args){
   if(Integer.toString(iterator).length()<11){
    result.add(Integer.toString(iterator));
   }
  }
  for(String st: result)
   if (isUnique(st)) {
    winner = st;
    System.out.println("Number with unique digits is " + winner);
    break;
   }
 }

//8. Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз.
 public static void printMatrix(int size){

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

    printShorter(argum);
    printLonger(argum);
    sortDesc(argum);
    sortAsc(argum);
    lessLength(argum);
    muchLength(argum);
    minDifDigit(argum);
    evenEvenOdd(argum);
    arifmProgr(argum);
    difDigit(argum);
    printMatrix(nums.length);
  }
 } catch (NumberFormatException ex) {
   System.out.println("You tap wrong arguments!");
   return;
  }
 }
}

