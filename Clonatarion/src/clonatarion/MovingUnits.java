/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clonatarion;

import clonatarion.BattleTicker.Unit;
import static clonatarion.MovingUnits.MovementStage.*;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jason
 */
public class MovingUnits {
          
        public Integer senderID;
        public int destinationID;
        public TreeMap<Unit,Integer> movingUnits;
        public int numberOfMovingUnitsTotal;
        public boolean attacking;
        public boolean goingHome = false;
        public boolean isHome = false;
        private MovementStage eta;
        private MovementStage journeyEta;
        private HashMap<String,Unit> unitDictionary;
        
        
        public MovingUnits(HashMap<String,Unit> unitDictionary, Integer senderID, int destinationID, int eta, boolean attacking, int totalETA){
            try {
                this.unitDictionary = unitDictionary;
                this.senderID = senderID;
                this.destinationID = destinationID;
                switch(eta){
                    default : throw new Exception();
                    case 10 : this.eta = ETA10;
                        break;
                    case 7 : this.eta = ETA7;
                        break;   
                    case 9 : this.eta = ETA9;
                        break;
                    case 8 : this.eta = ETA8;
                        break;
                    case 6 : this.eta = ETA6;
                        break;
                    case 5 : this.eta = ETA5;
                        break;
                    case 4 : this.eta = ETA4;
                        break;   
                    case 3 : this.eta = ETA3;
                        break;
                    case 2 : this.eta = ETA2;
                        break;
                    case 1 : this.eta = ETA1;
                        break;  
                    case -1 :
                        if(attacking){
                            this.eta = ATT3;
                        } else {
                            this.eta = DEF3;
                        }
                    break;
                    case -2 : if (attacking){
                        this.eta = ATT2;
                    } else {
                        this.eta = DEF2;
                    }
                    break;
                    case -3 : if(attacking){
                        this.eta = ATT1;
                    } else {
                        this.eta = DEF1;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(MovingUnits.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public void addUnits(String unitName, int amount){            
            movingUnits.put(unitDictionary.get(unitName), amount);
        }
        
        public void incrementMovingStage(){
           if(eta.equals(ETA10)){
               eta = ETA9;
           }
           if(eta.equals(ETA9)){
               eta = ETA8;
           }
           if(eta.equals(ETA8)){
               eta = ETA7;
           }
           if(eta.equals(ETA7)){
               eta = ETA6;
           }
           if(eta.equals(ETA6)){
               eta = ETA5;
           }
           if(eta.equals(ETA5)){
               eta = ETA4;
           }
           if(eta.equals(ETA4)){
               eta = ETA3;
           }
           if(eta.equals(ETA3)){
               eta = ETA2;
           }
           if(eta.equals(ETA2)){
               eta = ETA1;
           }
           if(eta.equals(ETA1) && attacking)
               eta = ATT3;
           if(eta.equals(ATT3))
               eta = ATT2;
           if(eta.equals(ATT2))
               eta = ATT1;
           if(eta.equals(ATT1)){
               eta = journeyEta;
               attacking = false;
               goingHome = true;
               destinationID = this.senderID;
           }
           if(eta.equals(ETA1) && !attacking && !goingHome){
               eta = DEF3;
           }
           if(eta.equals(DEF3))
               eta = DEF2;
           if(eta == DEF2)
               eta = DEF1;
           if(eta == DEF1){
               eta = journeyEta;
               goingHome = true;
               destinationID = this.senderID;
           }
           if(eta.equals(ETA1) && !attacking && goingHome){
               isHome = true;
           }
        }
        
        public boolean isAtWar(){
            if(this.eta.equals(ATT1)||this.eta.equals(ATT2)||this.eta.equals(ATT3)||
                    this.eta.equals(DEF1)||this.eta.equals(DEF2)||this.eta.equals(DEF3))
                return true;
            return false;
        }
        
        public enum MovementStage{
        ETA10, ETA9, ETA8, ETA7, ETA6, ETA5, ETA4, ETA3, ETA2, ETA1,
        ATT3, ATT2, ATT1, DEF3, DEF2, DEF1;
        }
    

}
