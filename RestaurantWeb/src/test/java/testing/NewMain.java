/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testing;

import DAO.*;
import java.util.*;
import model.*;

public class NewMain {

    public static void main(String[] args) {

        RestaurantDAO dao = new RestaurantDAO();
        List<Product> ls = dao.getAllProduct();
        System.out.println(ls);
    }

    static String autoIncreaseID(List<category> ls) {
        String id = "C";
        int noId = 1;

        for (int i = 0; i < ls.size(); i++) {
            String[] str = ls.get(i).getCategoryID().split("C");
            for (int j = 1; j < str.length; j++) {
                int no = Integer.parseInt(str[j]);
                while (noId <= no) {
                    noId++;
                }
            }
        }
        return id + noId;
    }
}
