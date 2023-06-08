package fr.epita.services;

import fr.epita.datamodel.Passenger;
import fr.epita.enumerations.PassengerClassEnum;
import fr.epita.enumerations.SexEnum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PassengerCSVDAO {

    public List<Passenger> readAll() {
        File file = new File("data.csv");
        List<Passenger> res = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            scanner.nextLine();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                try {
                    String[] split = line.split(";");
                    String name = split[0].trim();
                    String pClass = split[1].trim().toLowerCase();
                    Double age = Double.parseDouble(split[2].trim());
                    String sex = split[3].trim().toLowerCase();
                    Boolean survived = "1".equals(split[4].trim());
                    Passenger passenger = new Passenger(name, pClass, age, sex, survived);
                    res.add(passenger);
                }catch (Exception e){
                    System.out.println("error parsing line: " + line);
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        // sort passengers by passenger class
        if(!res.isEmpty()) {
            res.sort(new Comparator<Passenger>() {
                @Override
                public int compare(Passenger o1, Passenger o2) {
                    return o1.getPassengerClass().compareTo(o2.getPassengerClass());
                }
            });
        }

        return res;
    }



}
