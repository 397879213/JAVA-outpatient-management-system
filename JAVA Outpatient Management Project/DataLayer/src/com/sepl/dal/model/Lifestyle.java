/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sepl.dal.model;

/**
 *
 * @author Vilcha
 */
public class Lifestyle {
    private Integer IDLifeStyle;
    private Boolean Vegetarian;
    private Boolean Smoker;
    private Integer AverageNoOfCigarettesPerDay;
    private Boolean AlcoholConsumer;
    private Integer AveragenoOfDrinksPerDay;
    private String UseStimulants;
    private Integer ConsumptionOfCoffeeTeaPerDay;
    private Integer ConsumptionOfSoftDrinksPerDay;
    private String HaveRegularMeals;
    private String EatHomeFoodOrOutsidePredominantly;

    public Lifestyle(Integer IDLifeStyle, Boolean Vegetarian, Boolean Smoker, Integer AverageNoOfCigarettesPerDay, Boolean AlcoholConsumer, Integer AveragenoOfDrinksPerDay, String UseStimulants, Integer ConsumptionOfCoffeeTeaPerDay, Integer ConsumptionOfSoftDrinksPerDay, String HaveRegularMeals, String EatHomeFoodOrOutsidePredominantly) {
        this.IDLifeStyle = IDLifeStyle;
        this.Vegetarian = Vegetarian;
        this.Smoker = Smoker;
        this.AverageNoOfCigarettesPerDay = AverageNoOfCigarettesPerDay;
        this.AlcoholConsumer = AlcoholConsumer;
        this.AveragenoOfDrinksPerDay = AveragenoOfDrinksPerDay;
        this.UseStimulants = UseStimulants;
        this.ConsumptionOfCoffeeTeaPerDay = ConsumptionOfCoffeeTeaPerDay;
        this.ConsumptionOfSoftDrinksPerDay = ConsumptionOfSoftDrinksPerDay;
        this.HaveRegularMeals = HaveRegularMeals;
        this.EatHomeFoodOrOutsidePredominantly = EatHomeFoodOrOutsidePredominantly;
    }

    public Integer getIDLifeStyle() {
        return IDLifeStyle;
    }

    public void setIDLifeStyle(Integer IDLifeStyle) {
        this.IDLifeStyle = IDLifeStyle;
    }

    public Boolean getVegetarian() {
        return Vegetarian;
    }

    public void setVegetarian(Boolean Vegetarian) {
        this.Vegetarian = Vegetarian;
    }

    public Boolean getSmoker() {
        return Smoker;
    }

    public void setSmoker(Boolean Smoker) {
        this.Smoker = Smoker;
    }

    public Integer getAverageNoOfCigarettesPerDay() {
        return AverageNoOfCigarettesPerDay;
    }

    public void setAverageNoOfCigarettesPerDay(Integer AverageNoOfCigarettesPerDay) {
        this.AverageNoOfCigarettesPerDay = AverageNoOfCigarettesPerDay;
    }

    public Boolean getAlcoholConsumer() {
        return AlcoholConsumer;
    }

    public void setAlcoholConsumer(Boolean AlcoholConsumer) {
        this.AlcoholConsumer = AlcoholConsumer;
    }

    public Integer getAveragenoOfDrinksPerDay() {
        return AveragenoOfDrinksPerDay;
    }

    public void setAveragenoOfDrinksPerDay(Integer AveragenoOfDrinksPerDay) {
        this.AveragenoOfDrinksPerDay = AveragenoOfDrinksPerDay;
    }

    public String getUseStimulants() {
        return UseStimulants;
    }

    public void setUseStimulants(String UseStimulants) {
        this.UseStimulants = UseStimulants;
    }

    public Integer getConsumptionOfCoffeeTeaPerDay() {
        return ConsumptionOfCoffeeTeaPerDay;
    }

    public void setConsumptionOfCoffeeTeaPerDay(Integer ConsumptionOfCoffeeTeaPerDay) {
        this.ConsumptionOfCoffeeTeaPerDay = ConsumptionOfCoffeeTeaPerDay;
    }

    public Integer getConsumptionOfSoftDrinksPerDay() {
        return ConsumptionOfSoftDrinksPerDay;
    }

    public void setConsumptionOfSoftDrinksPerDay(Integer ConsumptionOfSoftDrinksPerDay) {
        this.ConsumptionOfSoftDrinksPerDay = ConsumptionOfSoftDrinksPerDay;
    }

    public String getHaveRegularMeals() {
        return HaveRegularMeals;
    }

    public void setHaveRegularMeals(String HaveRegularMeals) {
        this.HaveRegularMeals = HaveRegularMeals;
    }

    public String getEatHomeFoodOrOutsidePredominantly() {
        return EatHomeFoodOrOutsidePredominantly;
    }

    public void setEatHomeFoodOrOutsidePredominantly(String EatHomeFoodOrOutsidePredominantly) {
        this.EatHomeFoodOrOutsidePredominantly = EatHomeFoodOrOutsidePredominantly;
    }

    @Override
    public String toString() {
        return "Lifestyle{" + "IDLifeStyle=" + IDLifeStyle + ", Vegetarian=" + Vegetarian + ", Smoker=" + Smoker + ", AverageNoOfCigarettesPerDay=" + AverageNoOfCigarettesPerDay + ", AlcoholConsumer=" + AlcoholConsumer + ", AveragenoOfDrinksPerDay=" + AveragenoOfDrinksPerDay + ", UseStimulants=" + UseStimulants + ", ConsumptionOfCoffeeTeaPerDay=" + ConsumptionOfCoffeeTeaPerDay + ", ConsumptionOfSoftDrinksPerDay=" + ConsumptionOfSoftDrinksPerDay + ", HaveRegularMeals=" + HaveRegularMeals + ", EatHomeFoodOrOutsidePredominantly=" + EatHomeFoodOrOutsidePredominantly + '}';
    }
    
    
}
