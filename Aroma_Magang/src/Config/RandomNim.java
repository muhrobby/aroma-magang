/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import java.util.Random;

/**
 *
 * @author muhrobby
 */
public class RandomNim {
    
    public static String random(){
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        
        sb.append("25");
        
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(9));
        }
        return sb.toString();
    }
    
}
