package jsontest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * json - служит для передачи объектов
 */
public class JSONtest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        User user1 = new User();
        user1.setName("Saif Ali Khan");
        user1.setEmal("saif@mail.in");

        User user2 = new User();
        user1.setName("Karina Kapoor");
        user2.setEmal("karina@mail.in");

        User users[] = new User[2];
        users[0] = user1;
        users[1] = user2;

        String json = null;

        // пример для одного объекта    
        try {
            // упаковывание
            json = new ObjectMapper().writeValueAsString(user1);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(JSONtest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("json = " + json);
        System.out.println("************-----");
        // распаковка
        User arrived = null;

        try {
            arrived = new ObjectMapper().readValue(json, User.class);
        } catch (IOException ex) {
            Logger.getLogger(JSONtest.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (arrived != null) {
            System.out.println("User from json: " + arrived);
            System.out.println("//-------****------");
        }
        // пример для массива объектов
        try {
            // упаковывание
            json = new ObjectMapper().writeValueAsString(users);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(JSONtest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("json = " + json);
        System.out.println("-----array of users received!!!!!!");
        // распаковка
        User[] arriveds = null;
        try {
            arriveds = new ObjectMapper().readValue(json, User[].class);
        } catch (IOException ex) {
            Logger.getLogger(JSONtest.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (arriveds != null) {
            for (User u : users) {
                System.out.println("User from json: " + u);
            }
            System.out.println("-----the array list is viewed!!!!!!");
        }
        // пример для двумерного массива чисел
        int[][] a = {{1, 2}, {7, 9}, {5, 6}};

        try {
            // упаковывание
            json = new ObjectMapper().writeValueAsString(a);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(JSONtest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("json = " + json);
        System.out.println("-----array of users received!!!!!!");
        // распаковка
        int[][] b = null;
        try {
            b = new ObjectMapper().readValue(json, int[][].class);
        } catch (IOException ex) {
            Logger.getLogger(JSONtest.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (b != null) {
            for (int i = 0; i < b.length; i++) {
                for (int j = 0; j < b[i].length; j++) {
                    System.out.println("a[" + i + "][" + j + "] = " + a[i][j]);
                }               
            } 
            System.out.println("Hurray!!! Two-dimensional array received!!!!");
        }
    }
}
