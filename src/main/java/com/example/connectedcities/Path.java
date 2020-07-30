package com.example.connectedcities;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Path {
    //this class contains the method to recursively find the path between tw cities.
    CityReader cityReader = new CityReader();
    //here we store the map return by getCities() method of CityReader class in a new map;
    private Map<String, LinkedHashSet<String>> map = cityReader.getCities();
    //this static map will contains city(as key) and all the cities(as value) connected directly or indirectly to that city.
    private static Map<String, LinkedHashSet<String>> cities = new HashMap<>();
    private static String  START;
    private static String  END;
    //here we store the origin and destination city into two variables START and END
    Path(String origin,String destination)
    {
        START = origin;
        END = destination;
    }
    /*this method will take a city as a agrument and
    return the list of its adjacent cities
    (cities which are directly connected to this city)*/
    public LinkedHashSet<String> adjacentCities(String last)
    {
        LinkedHashSet<String> adjacent = map.get(last);
        if (adjacent == null)
        {
            return new LinkedHashSet<>();
        }
        return adjacent;
    }

    //this linkedHashSet will conatins the Set of the cities traversed or visited while finding the path.
    LinkedHashSet<String> visited = new LinkedHashSet<>();

    //this method takes the origin city as input and then insert into the map currentCity(as key) and
    // list of all the cities connected to it either directly or indirectly as its value
     private void findPath(Path path,String currentCity) {
         //this method call itself recursively to implement the BFS algorithm to find the path recursively
        LinkedHashSet<String> nodes = path.adjacentCities(currentCity);
        LinkedHashSet<String> city = cities.computeIfAbsent(START, k -> new LinkedHashSet<>());
        city.add(currentCity);
        for (String node : nodes) {
            if (visited.contains(node))
                continue;
            visited.add(node);
            findPath(path, node);
        }
    }
    //this getPath method with the help of the find path method will check
    // if there exist a path between the two cities and return "yes" or "no" based on that.
    public String getPath(String origin, String destination)
    {
        Path path = new Path(origin,destination);
        findPath(path,START);
        if(cities.get(origin).contains(destination)) return "yes";
        return "no";
    }


}
