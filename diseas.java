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
class diseas {
    int disid;
    String disname;
    public diseas(int disid,String disname){
        this.disid=disid;
        this.disname=disname;
    }
    public int getdisid(){
        return disid;
    }
   public String getdisname(){
       return disname;
   }
}
