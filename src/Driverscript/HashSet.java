//package Driverscript;
//
//import java.util.*;
//import java.util.Set;
//
//public class HashSet {
//
//	public static void main(String[] args) {
//		HashSet<String> set=new HashSet<String>();  
//        set.add("1");  
//        set.add("2");  
//        set.add("3");  
//        set.add("4");  
//        System.out.println("An initial list of elements: "+set);  
//        //Removing specific element from HashSet  
//        set.remove("Ravi");  
//        System.out.println("After invoking remove(object) method: "+set);  
//        HashSet<String> set1=new HashSet<String>();  
//        set1.add("5");  
//        set1.add("1");  
//        set.addAll(set1);  
//        System.out.println("Updated List: "+set);  
//        //Removing all the new elements from HashSet  
//        set.removeAll(set1);  
//        System.out.println("After invoking removeAll() method: "+set);  
//        //Removing elements on the basis of specified condition  
//        set.removeIf(str->str.contains("2"));    
//        System.out.println("After invoking removeIf() method: "+set);  
//        //Removing all the elements available in the set  
//        set.clear();  
//        System.out.println("After invoking clear() method: "+set);  
//
//	}
//
//}
