package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "Ismail";
        } else if(query.contains("plus")) {//"what is
            String s = query;
            String[] array = s.split(" ");
            int summe = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i].matches(".*\\d.*")){
                    int temp = Integer.parseInt(array[i]);
                    summe += temp;
                }
            }
            return String.valueOf(summe);
        }
        else if (query.contains("largest")){
            ArrayList<Integer> list = new ArrayList<>();
            String s = query.substring(query.indexOf(":"));
            String[] array = s.split(",");
            for (int i = 0; i < array.length; i++) {
                if (array[i].matches(".*\\d.*")){
                    list.add(Integer.parseInt(array[i]));
                }
            }
            Optional<Integer> l = list.stream().max(Integer::compareTo);
            if (l.isPresent()){
                return String.valueOf(l.get());
            }
        }
        return "";
    }
}
