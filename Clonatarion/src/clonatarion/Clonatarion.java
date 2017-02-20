/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clonatarion;

import clonatarion.BattleTicker.Unit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jason
 */
public class Clonatarion {

    DatabaseHelper dbHelper = new DatabaseHelper();
    HashMap<String,Unit> dictionaryOfUnits = new HashMap();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public void moveUnits(){
        try {
            String getAllMovingUnitsStatement = "SELECT * FROM movingunitsdetailed;";
            ResultSet rs = dbHelper.getMovingUnitsTable(getAllMovingUnitsStatement);
            HashMap<String,MovingUnits> mapOfMovingUnits = new HashMap<String,MovingUnits>();
            List<MovingUnits> listOfMovingUnits = new ArrayList();
            
            while(rs.next()){
                int senderID = rs.getInt("playerid");
                String unitName = rs.getString("unit");
                int amount = rs.getInt("amount");
                int destinationid = rs.getInt("destinationid");
                int eta = rs.getInt("eta");
                int totalEta = rs.getInt("totaleta");
                int attdef = rs.getInt("attdef");
                boolean attacking = false;
                if(attdef == 1){
                    attacking = true;
                }
                String mapKey = String.valueOf(senderID) + String.valueOf(destinationid);
                if(mapOfMovingUnits.containsKey(mapKey)){
                    mapOfMovingUnits.get(mapKey).addUnits(unitName, amount);
                } else {
                    MovingUnits mu = new MovingUnits(dictionaryOfUnits,
                            new Integer(senderID), destinationid, eta, attacking, totalEta
                    );
                    mu.addUnits(unitName, amount);
                    mapOfMovingUnits.put(mapKey, mu);
                    listOfMovingUnits.add(mu);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Clonatarion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void getAllBattles(List<MovingUnits> listOfMovingUnits){
        Map<String,List<MovingUnits>> mapOfBattlesToOccur = new HashMap();
        
        
        //first of all we get all the battles that are to be occuring
        for(MovingUnits mu : listOfMovingUnits){
            if(mu.isAtWar()){
                if(mapOfBattlesToOccur.containsKey(String.valueOf(mu.destinationID))){
                    mapOfBattlesToOccur.get(String.valueOf(mu.destinationID)).add(mu);
                } else {
                    List<MovingUnits> newList = new ArrayList<MovingUnits>();
                    newList.add(mu);
                    mapOfBattlesToOccur.put(String.valueOf(mu.destinationID),newList);
                }
            }
            
        //now we get the number of units home at the defending id
        for(String id : mapOfBattlesToOccur.keySet()){
            String queryToGetResultSetForUnitsHome = "SELECT * FROM playerunits WHERE playerid='" + id + "'";
            MovingUnits homeUnits = new MovingUnits(dictionaryOfUnits, new Integer(id),Integer.parseInt(id),-1,false,-1);
            ResultSet rs = this.dbHelper.sendquery(queryToGetResultSetForUnitsHome);
                try {
                    while(rs.next()){
                        String
                    }   } catch (SQLException ex) {
                    Logger.getLogger(Clonatarion.class.getName()).log(Level.SEVERE, null, ex);
                }
        }    
            
        //then we send all fighting units to battleticker
        }
        
        
        
    }
    

    
    
    
}
