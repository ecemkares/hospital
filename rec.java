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
class rec {
    int idapp;
    String dname,dsurname,dsname,recno;
    public rec(int idapp,String dname,String dsurname,String dsname,String recno){
        this.idapp=idapp;
        this.dname=dname;
        this.dsurname=dsurname;
        this.dsname=dsname;
        this.recno=recno;
    }
    public int getidapp(){
        return idapp;
    }
    public String getdname(){
        return dname;
    }
    public String getdsurname(){
        return dsurname;
    }
    public String getdsname(){
        return dsname;
    }
    public String getrecno(){
        return recno;
    }
}
