package com.example.connectedcities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CityReader {
        private Map<String, LinkedHashSet<String>> map = new HashMap();
        public Map<String, LinkedHashSet<String>> getCities() {
            Scanner sc;
            {
                try {
                    sc = new Scanner(new File("src/main/resources/city.txt"));
                    while (sc.hasNextLine()) {
                        String val = sc.nextLine();
                        String[] city = val.split(", ");
                        addEdge(city[0], city[1]);
                        addEdge(city[1],city[0]);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            return map;
        }
        public void addEdge(String node1, String node2)
        {
            LinkedHashSet<String> adjacent = map.computeIfAbsent(node1, k -> new LinkedHashSet<>());
            adjacent.add(node2);
        }

}