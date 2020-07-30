package com.example.connectedcities;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class ConnectedCities {
    @GetMapping("/connected")
    @ResponseBody
    public String connectedCities(@RequestParam String origin, @RequestParam String destination) {
        /*this method takes two arugments orgin and destination from the url
        and pass them to getPath method of path to class
        which will return "yes" if the cities are connected else return "no".*/
            Path path= new Path(origin,destination);
            return path.getPath(origin,destination);
      }

}

