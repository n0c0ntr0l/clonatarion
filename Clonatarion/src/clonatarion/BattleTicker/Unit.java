/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clonatarion.BattleTicker;

/**
 *
 * @author Jason
 */
public class Unit implements Comparable<Unit>, Cloneable{
    protected String uName;
    protected RoutesEnum uRoute;
    protected UnitTypeEnum uType;
    protected UnitClassEnum uClass;
    protected int uRange, uHealth, uArmour, uHDamage, uADamage, uValue, uInit;
    protected UnitClassEnum t1 = null;
    protected UnitClassEnum t2 = null;
    protected UnitClassEnum t3 = null;
    protected boolean stealth = false;
    public int amount, tHealth, tArmour, tHDamage, tADamage;
    
    
    public Unit(String name, String route, String unitType, String unitClass, int uRange,
            int uHealth, int uArmour, int uHDamage, int uADamage, int value,
            String t1String, String t2String, String t3String, boolean stealth, int amount){
        this.uName = name;
        this.uRoute = getRouteFromString(route);
        this.uType = getTypeFromString(unitType);
        this.uClass = getClassFromString(unitClass);
        this.uRange = uRange;
        this.uHealth = uHealth;
        this.uArmour = uArmour;
        this.uHDamage = uHDamage;
        this.uADamage = uADamage;
        this.t1 = getClassFromString(t1String);
        this.t2 = getClassFromString(t2String);
        this.t3 = getClassFromString(t3String);
        this.stealth = stealth;
        this.uValue = value;
        this.amount = amount;
        this.calculateTotalArmour();
        this.calculateTotalArmourDamage();
        this.calculateTotalHealth();
        this.calculateTotalHealthDamage();
    }
    
    private UnitClassEnum getClassFromString(String unitClass){
        UnitClassEnum cEnum = null;
        switch (unitClass){
            default:
                break;
            case "LET" :
                cEnum = UnitClassEnum.LET;
                break;
            case "INN" :
                cEnum = UnitClassEnum.INN;
                break;
            case "NLT" :
                cEnum = UnitClassEnum.NLT;
                break;
            case "NLD" :
                cEnum = UnitClassEnum.NLD;
                break;
        }
        return cEnum;
        
    }
    
    private UnitTypeEnum getTypeFromString(String type){
        UnitTypeEnum typeEnum = null;
        
        switch(type){
            default: 
                return null;
                
            case "Kills" :
                    typeEnum = UnitTypeEnum.KILL;
                    break;
            case  "Distracts" :
                typeEnum = UnitTypeEnum.DISTRACT;
                break;
            case "Disables" :
                typeEnum = UnitTypeEnum.DISABLE;
                break;
            case "Stuns" :
                typeEnum = UnitTypeEnum.STUN;
                break;
            case "Converts" :
                typeEnum = UnitTypeEnum.CONVERT;
                break;
            case "Gardens" :
                typeEnum =  UnitTypeEnum.GARDEN;
                break;
            case "Harvests" :
                typeEnum = UnitTypeEnum.HARVEST;
                break;
            case "Bribes" :
                typeEnum = UnitTypeEnum.BRIBE;
                break;
            case "Steals Land":
                typeEnum = UnitTypeEnum.STEALLAND;
                break;
            case "Steals Seeds" :
                typeEnum = UnitTypeEnum.STEALSEEDS;
                break;
            case "Steals Plants" :
                typeEnum = UnitTypeEnum.STEALPLANTS;
                break;
            case "Destroys Funds" :
                typeEnum = UnitTypeEnum.DESTROYFUNDS;
                break;
            case "Captures Flag" :
                typeEnum = UnitTypeEnum.FLAG;
                break;
                
        }
        return typeEnum;
    }
  
    private RoutesEnum getRouteFromString(String route){
        RoutesEnum eRoute = null;
        switch (route){
            default:
                break;
            case "Protestor" :
                eRoute = RoutesEnum.PROTESTOR;
                break;
            case "Alliance" :
                eRoute = RoutesEnum.ALLIANCE;
                break;
            case "Robotics" :
                eRoute = RoutesEnum.ROBOTICS;
                break;
            case "MILITARY" :
                eRoute = RoutesEnum.MILITARY;
                break;
            case "Thug" :
                eRoute = RoutesEnum.THUG;
                break;
            case "Generic" :
                eRoute = RoutesEnum.GENERIC;
                break;
            case "Special Operations" :
                eRoute = RoutesEnum.SPECOPS;
                break;            
        }        
        return eRoute;
    }
    
    private void calculateTotalHealth(){
        this.tHealth = this.uHealth * this.amount;
    }
    
    private void calculateTotalArmour(){
        this.tArmour = this.uArmour * this.amount;
    }
    
    private void calculateTotalArmourDamage(){
        this.tADamage = this.uADamage * this.amount;
    }
    
    public void calculateTotalHealthDamage(){
        this.tHDamage = this.uHDamage * this.amount;
    }
    

    @Override
    public int compareTo(Unit t) {
        if(t.uInit > this.uInit){
            return 1;
        }
        else if(t.uInit < this.uInit){
            return -1;
        }
        return 0;
    }
    
    
}
