/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalsystem;

/**
 *
 * @author asus
 */
class Doctorr {
    String id;
    String password;
    String name;
    String surname;
    
    
    public Doctorr(String id,String password,String name, String surname){
        this.id=id;
        this.password = password;
        this.name=name;
        this.surname=surname;
        
    }
    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
        
    }
    
    public String getId(){
        return id;
    }
    public String getPassword(){
        return password;
    }
}
