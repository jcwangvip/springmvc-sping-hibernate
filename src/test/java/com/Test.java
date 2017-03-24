package com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Test {

	public static void main(String[] args) {

		Map map = new HashMap();
		
		Set set = new HashSet();
		
		 Random r = new Random();
         for(int i=1;i<100;i++){
        	 int rand = r.nextInt(1000); 
        	 map.put(rand, rand);
        	 set.add(rand);
        	 //System.out.print(rand+",");
         }
//         System.out.println(map);
//         System.out.println(set);
         
         
         Iterator iterator = set.iterator();
         for(int i=1 ;i<set.size();i++){
        	 if(iterator.hasNext()){
            	 System.out.println(iterator.next());
             }
         }
         
        
	}

}
