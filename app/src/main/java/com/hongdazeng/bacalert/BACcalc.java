package com.hongdazeng.bacalert;

import java.text.DecimalFormat;
/**
 * Created by Xu Han on 2/20/2016.
 *
 */
public class BACcalc {
    private double weight;
    private double ounce;
    private double gender;
    //double drinkPeriod;
    public BACcalc(){
        weight = 150;
        gender = 0.73;
        ounce = 0;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public double getWeight(){
        return weight;
    }
    public void addDrinks(){
        ounce += 0.6;
    }
    //public void setDrinkPeriod(double drinkPeriod){
        //this.drinkPeriod = drinkPeriod;
    //}
    public void changeGender(){
        if(gender == 0.73){
            gender = 0.66;
        }
        else{
            gender = 0.73;
        }
    }
    public double getBAC(){
        double BAC = (ounce * 5.14)/(weight * gender) - 0.15 * 0.25; //0.25 = 15 minutes drink period
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
