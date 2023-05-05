package task2;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "src/task2/file.txt";
        List<User> users = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(" ");
                String name = columns[0];
                int age = Integer.parseInt(columns[1]);
                User user = new User(name, age);
                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("user.json"))) {
            bw.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}