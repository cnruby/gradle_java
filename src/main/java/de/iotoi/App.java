package de.iotoi;

import com.google.gson.Gson;

import java.util.Random;
import java.util.stream.LongStream;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        LongStream obj = new Random().longs(5,0,10);
        String json = new Gson().toJson(obj.toArray());

        System.out.println("json = " + json);
    }
}
