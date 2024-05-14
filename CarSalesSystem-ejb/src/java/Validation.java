/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author wongtiksoon
 */
public class Validation {
    
    public boolean checkPassword(String pass){
        if (pass.length() < 8 ){
            return false;
        }
        return true;
    }
    
      public boolean checkContact(String pass){
        if (pass.length() < 8 ){
            return false;
        }
        return true;
    }
}
