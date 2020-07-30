package com.example.connectedcities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CityReader {
    //This class reads the cities from the city.txt file and store the cities in the map in (key,value) format.
        private Map<String, LinkedHashSet<String>> map = new HashMap();
        // this method will return the map containing  city(as key) and its connected cities( as value ).
        public Map<String, LinkedHashSet<String>> getCities() {
            Scanner sc;
            {
                try {
                    //this block will read the data from the city.txt file line by line

                    sc = new Scanner(new File("src/main/resources/city.txt"));
                    while (sc.hasNextLine()) {
                        String val = sc.nextLine();
                        String[] city = val.split(", ");
                        //here the addEgdge() will store the cities in the map in key value format
                        //where key is a name of a city and its value is a list of cities connected directly to that city
                        addEdge(city[0], city[1]);
                        addEdge(city[1],city[0]);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            return map;
        }
        // this addEdge method will compute and then store the city in the map based on that
        public void addEdge(String node1, String node2)
        {
            LinkedHashSet<String> adjacent = map.computeIfAbsent(node1, k -> new LinkedHashSet<>());
            adjacent.add(node2);
        }

}