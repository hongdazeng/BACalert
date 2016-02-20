package com.hongdazeng.bacalert;

import java.text.DecimalFormat;
/**
 * Created by Xu Han on 2/20/2016.
 *
 */
public class BACcalc {
    private double weight;
    private int numDrinks;
    private double gender;
    //double drinkPeriod;
    public BACcalc(){
        weight = (150/2.2406);
        gender = 0.58;
        numDrinks = 0;
    }
    public void setWeight(int weight){
        this.weight = (weight/2.2406);
    }
    public double getWeight(){
        return weight;
    }
    public void addDrinks(){
        numDrinks += 1;
    }
    //public void setDrinkPeriod(double drinkPeriod){
        //this.drinkPeriod = drinkPeriod;
    //}
    public void changeGender(){
        if(gender == 0.58){
            gender = 0.49;
        }
        else{
            gender = 0.58;
        }
    }
    public double getBAC(){
        double BAC = (0.806* numDrinks * 1.2)/(gender * weight) - (0.017 * 0.25) + 0.001; //0.25 = 15 minutes drink period
        DecimalFormat formatter = new DecimalFormat("#0.00");
        System.out.println(formatter.format(BAC));
        return BAC;
    }

    public static void main(String[] args) {
        BACcalc newCal = new BACcalc();
        newCal.getBAC();
        newCal.addDrinks();
        newCal.getBAC();
    }

}
