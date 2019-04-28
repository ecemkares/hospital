/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalsystem;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Operations {
    Connection con = null;
    Statement sts = null;
    PreparedStatement pata = null;
    public boolean Login(String id, String password){
        String sorgu = "select * from doctors where doc_id=? and doc_pass=?";
        try{
        pata = con.prepareStatement(sorgu);
        pata.setString(1, id);
        pata.setString(2, password);
        ResultSet rs = pata.executeQuery();
        return rs.next();
    }catch (SQLException ex){
        Logger.getLogger(Operations.class.getName()).log(Level.SEVERE,null,ex);
        return false;
    }}
    
    public void addrepice(int doc_id,int p_id,int t_pr,String rep){
        String sorgu="call insertrep(?,?,?,?)";
        try{
           pata=con.prepareStatement(sorgu);
           pata.setInt(1,doc_id);
           pata.setInt(2,p_id);
           pata.setInt(3,t_pr);
           pata.setString(4,rep);
           
           ResultSet rs=pata.executeQuery();
        
        }catch(SQLException ex){
           Logger.getLogger(Operations.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public void addpatient(int doc_id,String p_name,String p_surname,String tel_no,int age,String app_day,Time app_time){
        String sorgu="call insertappointment(?,?,?,?,?,?,?)";
        try{
           pata=con.prepareStatement(sorgu);
           pata.setInt(1,doc_id);
           pata.setString(2,p_name);
           pata.setString(3,p_surname);
           pata.setString(4,tel_no);
           pata.setInt(5,age);
           pata.setString(6,app_day);
           pata.setTime(7,app_time);
           ResultSet rs=pata.executeQuery();
        
        }catch(SQLException ex){
           Logger.getLogger(Operations.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public ArrayList<diseas> typedis(){
        String sorgu= "select * from disease ";
        ArrayList <diseas> diss = new ArrayList<diseas>();
        try{
        pata = con.prepareStatement(sorgu);
        
        
        ResultSet rs = pata.executeQuery();
        diseas ds;
        while(rs.next()){
            ds = new diseas(
                    rs.getInt("dis_id"),
                    rs.getString("dis_name")
                    
                    
            );
            diss.add(ds);
        }
    }catch (SQLException ex){
        Logger.getLogger(Operations.class.getName()).log(Level.SEVERE,null,ex);
    
    }
        return diss;
    }
    public ArrayList<rec> recipeshow(String id){
        String sorgu= "select recipe.app_id,doctors.doc_name,doctors.doc_surname,disease.dis_name,recipe.rec_no from recipe join doctors on recipe.doc_id=doctors.doc_id \n" +
         "join disease on disease.dis_id=recipe.dis_id where app_id=?   ";
        ArrayList <rec> reci = new ArrayList<rec>();
        try{
        pata = con.prepareStatement(sorgu);
        pata.setString(1, id);
        
        ResultSet rs = pata.executeQuery();
        rec rc;
        while(rs.next()){
            rc = new rec(
                    rs.getInt("app_id"),
                    rs.getString("doc_name"),
                    rs.getString("doc_surname"),
                    rs.getString("dis_name"),
                    rs.getString("rec_no")
                    
            );
            reci.add(rc);
        }
    }catch (SQLException ex){
        Logger.getLogger(Operations.class.getName()).log(Level.SEVERE,null,ex);
    
    }
        return reci;
    }
    public ArrayList<patientt> patient(String id){
        String sorgu= "select app_id,p_name,p_surname,app_day,app_time from appointment where doc_id=? ";
        ArrayList <patientt> pati = new ArrayList<patientt>();
        try{
        pata = con.prepareStatement(sorgu);
        pata.setString(1, id);
        
        ResultSet rs = pata.executeQuery();
        patientt pat;
        while(rs.next()){
            pat = new patientt(
                    rs.getInt("app_id"),
                    rs.getString("p_name"),
                    rs.getString("p_surname"),
                    rs.getString("app_day"),
                    rs.getString("app_time")
                    
            );
            pati.add(pat);
        }
    }catch (SQLException ex){
        Logger.getLogger(Operations.class.getName()).log(Level.SEVERE,null,ex);
    
    }
        return pati;
    }
    public ArrayList<Doctorr> user(String id){
        String sorgu= "select * from doctors where doc_id=? ";
        ArrayList <Doctorr> doc = new ArrayList<Doctorr>();
        try{
        pata = con.prepareStatement(sorgu);
        pata.setString(1, id);
        
        ResultSet rs = pata.executeQuery();
        Doctorr doct;
        while(rs.next()){
            doct = new Doctorr(
                    rs.getString("doc_id"),
                    rs.getString("doc_pass"),
                    rs.getString("doc_name"),
                    rs.getString("doc_surname")
                    
            );
            doc.add(doct);
        }
    }catch (SQLException ex){
        Logger.getLogger(Operations.class.getName()).log(Level.SEVERE,null,ex);
    
    }
        return doc;
    }
    String id ="ecem";
    String password = "32369001Ecem";
    String host ="localhost"; 
           
    String port= "3306";
    String db_name ="project";
    public Operations(){
        String url = "jdbc:mysql://"+host+":"+port+"/"+db_name+"?allowMultiQueries=true&useUnicode=true" +
    "&useJDBCCompliantTimezoneShift=true" +
    "&useLegacyDatetimeCode=false" +
    "&serverTimezone=UTC";
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url,id,password);
        System.out.println("Database Baglandi");
    } catch (ClassNotFoundException ex){
        Logger.getLogger(Operations.class.getName()).log(Level.SEVERE,null,ex);
        System.out.println("Driver calismadi");
        
    }catch (SQLException ex){
        Logger.getLogger(Operations.class.getName()).log(Level.SEVERE,null,ex);
    }
    
    
}
    public static void main(String[] args){
        Operations op = new Operations();
    }
}
