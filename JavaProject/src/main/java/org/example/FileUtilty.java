package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtilty {
    private static final String PATH_TO_FILE = "src/main/resources/fisier.txt";

    public static void WriteToFile(){
        File file = new File(PATH_TO_FILE);

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        Person person1 = new Person("Bill", 25, false, Arrays.asList(4, 5, 6));
        Person person2 = new Person("Anna", 23, false, Arrays.asList(2, 1, 3));

        List<Person> persons = new ArrayList<>();

        persons.add(person1);
        persons.add(person2);

        try {
            writer.writeValue(file, person1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromFile(){
        ObjectMapper mapper = new ObjectMapper();
        Path path = Paths.get(PATH_TO_FILE);
        byte[] bytes = new byte[0];

        try{
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String json = new String(bytes);

        try {
            List<Person> persons = mapper.readValue(json, new TypeReference<List<Person>>(){});
            System.out.println(persons.get(1).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}