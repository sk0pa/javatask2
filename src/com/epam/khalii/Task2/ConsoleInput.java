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
  int size = 0, el=0;
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

 private static void insertSortDesc(String[] array){
  for(int i=1; i<array.length;i++) {
   String cur = array[i];
   int j;
   for(j=i-1;j>=0&&array[j].length()>cur.length();j--)
    array[j+1]=array[j];
   array[j+1]=cur;
  }
 }

 private static void insertSortAsc(String[] array){
  for(int i=1; i<array.length;i++) {
   String cur = array[i];
   int j;
   for(j=i-1;j>=0&&array[j].length()<cur.length();j--)
    array[j+1]=array[j];
   array[j+1]=cur;
  }
 }

 public static void printArray(String[] array){
  for(int i=0;i<array.length;i++)
   System.out.print(array[i]+" ");
  System.out.println();
 }

 public static void sortDesc(ArrayList<Integer> args){
  String[] array = new String[args.size()];
  for(int iterator=0; iterator<args.size();iterator++) {
   array[iterator] = (Integer.toString(args.get(iterator)));
  }
  insertSortDesc(array);
  System.out.println("Array sort by count of numbers(desc): ");
  printArray(array);
 }

 public static void sortAsc(ArrayList<Integer> args){
  String[] array = new String[args.size()];
  for(int iterator=0; iterator<args.size();iterator++) {
   array[iterator] = (Integer.toString(args.get(iterator)));
  }
  insertSortAsc(array);
  System.out.println("Array sort by count of numbers(asc): ");
  printArray(array);
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
  System.out.println("Average is: " + average);
  System.out.print("Element with lower then average size: ");
  for(int i=0;i<result.size();i++){
    if(result.get(i).length()<average){
     System.out.print("element "+result.get(i)+" length "+result.get(i).length()+", ");
    }
  }
  System.out.println();
 }

 public static void muchLength(ArrayList<Integer> args){
  ArrayList<String> result = new ArrayList<String>();
  int average=0;
  for(int iterator:args){
   result.add(Integer.toString(iterator));
   average+=Integer.toString(iterator).length();
  }
  average/=result.size();
  System.out.println("Average is: " + average);
  System.out.print("Element with lower then average size: ");
  for(int i=0;i<result.size();i++){
   if(result.get(i).length()>average){
    System.out.print("element "+result.get(i)+" length "+result.get(i).length()+", ");
   }
  }
  System.out.println();
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

 private static int uniqueNum(String st){
  int[] nums = new int[10]; // counter 0 1 2 3 4 5 6 7 8 9
  int count=0;
  for(int i = 0; i<st.length();i++) {
   nums[Character.getNumericValue(st.charAt(i))]++;
  }
  for(int i = 0; i<10;i++) {
   if(nums[i]==1) count++;
  }
  return count;
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
   if(uniqueNum(st)<min){
    min=uniqueNum(st);
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
  System.out.println("Numbers with equal number of even and odd digits:");
  for(String st: result){
   if(isEvenOdd(st)){
    System.out.print(st+" ");
    count++;
   }
  }
  System.out.println("\nCount of even numbers with equal number of even and odd digits is "+count);
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
   if (iterator>9)
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
   if(Integer.toString(iterator).length()<11&&Integer.toString(iterator).length()>1){
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
   for(int j=0;j<size;j++) {
    System.out.print(i*size+j+1+" ");
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

