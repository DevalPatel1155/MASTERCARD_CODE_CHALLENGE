package com.example.connectedcities;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Path {
    CityReader cityReader = new CityReader();
    private Map<String, LinkedHashSet<String>> map = cityReader.getCities();
    private static Map<String, LinkedHashSet<String>> cities = new HashMap<>();
    private static String  START;
    private static String  END;
    Path(String origin,String destination)
    {
        START = origin;
        END = destination;
    }

    public LinkedHashSet<String> adjacentCities(String last)
    {
        LinkedHashSet<String> adjacent = map.get(last);
        if (adjacent == null)
        {
            return new LinkedHashSet<>();
        }
        return adjacent;
    }

    LinkedHashSet<String> visited = new LinkedHashSet<>();


    private void findPath(Path path,String currentCity) {
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

    public String getPath(String origin, String destination)
    {
        Path path = new Path(origin,destination);
        findPath(path,START);
        if(cities.get(origin).contains(destination)) return "yes";
        return "no";
    }


}
