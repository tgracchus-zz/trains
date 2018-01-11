package com.trains;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please, introduce your graph in one line and hit enter");
        Scanner in = new Scanner(System.in);
        List<String> results = Trains.newDefaultTrains().run(in.nextLine());
        results.forEach(System.out::println);
    }


}
