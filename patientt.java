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
class patientt {
    int apid;
    String pname,psurname,day;
    String time;
    public patientt(int apid,String pname,String psurname,String day,String time){
        this.apid=apid;
        this.pname=pname;
        this.psurname=psurname;
        this.time=time;
        this.day=day;
    }
    public int getapid(){
        return apid;
    }
    public String getpname(){
        return pname;
    }
    public String getpsurname(){
        return psurname;
    }
    public String getday(){
        return day;
    }
    public String gettime(){
        return time;
    }
}
