package Prometheus.Characters;

import Prometheus.Items.*;
import Prometheus.Systems.Dice;
import Prometheus.Systems.GameLogic;

import java.sql.SQLOutput;
import java.util.*;

import static Prometheus.Systems.GameLogic.printSeparator;

public class Player extends Character{

    //params
    private String characterClass;
    private int maxHP;
    private int saveFort;
    private int saveRef;
    private int saveWill;
    private int[] statModifiers = new int[6];
    private Inventory backpack;


    //G&S
    public String getCharacterClass() {
        return characterClass;
    }
    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int getMaxHP() {
        return maxHP;
    }
    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getSaveFort() {
        return saveFort;
    }
    public void setSaveFort(int saveFort) {
        this.saveFort = saveFort;
    }

    public int getSaveRef() {
        return saveRef;
    }
    public void setSaveRef(int saveRef) {
        this.saveRef = saveRef;
    }

    public int getSaveWill() {
        return saveWill;
    }
    public void setSaveWill(int saveWill) {
        this.saveWill = saveWill;
    }

    public int[] getStatModifiers() {
        return statModifiers;
    }
    //set stat Modifiers
    public void setStatModifiers(int[] stats){
        int count = 0;
        for(int n : stats){
            statModifiers[count]= GameLogic.roundDown(n)-5;
            count++;
        }
    }

    public Inventory getBackpack() {
        return backpack;
    }
    public void setBackpack(Inventory backpack) {
        this.backpack = backpack;
    }

    //constructor
    public Player(String name, String ancestry, int age, int[] stats) {
        super(name, ancestry, age, stats);
    }


    //print player sheet
    public void printCharacterSheet(Equipment playerEquipment){
        printSeparator(35);
        printSeparator(30);
        System.out.printf("%-12s %s\n","Name: ", getName());
        System.out.printf("%-12s %s\n","Ancestry: ", getAncestry());
        System.out.printf("%-12s %s\n","Age: ", getAge());
        System.out.printf("%-12s %s\n","Class: ", getCharacterClass());
        System.out.printf("%-12s %s\n","HP: ", getMaxHP());
        System.out.printf("%-12s %s\n","AC: ", 10 + getStatModifiers()[1] + playerEquipment.getAcBonus());
        printSeparator(40);
        System.out.println("|Saves|..|Value|");
        System.out.printf("%-12s %-6s\n", "Fortitude: ", getSaveFort());
        System.out.printf("%-12s %-6s\n", "Reflex: ", getSaveRef());
        System.out.printf("%-12s %-6s\n", "Will: ", getSaveWill());
        printSeparator(40);
        System.out.println("|Stat Name|...|Rank|...|Modifier|");
        printSeparator(40);
        System.out.println("Strength:      " + getStats()[0] + "       [" + getStatModifiers()[0] + "]");
        System.out.println("Dexterity:     " + getStats()[1] + "       [" + getStatModifiers()[1] + "]");
        System.out.println("Constitution:  " + getStats()[2] + "       [" + getStatModifiers()[2] + "]");
        System.out.println("Intelligence:  " + getStats()[3] + "       [" + getStatModifiers()[3] + "]");
        System.out.println("Wisdom:        " + getStats()[4] + "       [" + getStatModifiers()[4] + "]");
        System.out.println("Charisma:      " + getStats()[5] + "       [" + getStatModifiers()[5] + "]");
    }



    //initialize inventory
    public Inventory setupInventory(){
        Set<Integer> availableSlots = Inventory.setPackSize(10);
        Map<Integer, Item> inventory = new LinkedHashMap<>();
        Inventory backpack = new Inventory(inventory, availableSlots);
        setBackpack(backpack);
        return backpack;
    }



//---class setup methods
    //cleric
    public void setCleric(int[] stats){
        setMaxHP(getStatModifiers()[2]+ 8 + Dice.d8(1));
        setSaveFort(getStatModifiers()[2]+2);
        setSaveRef(getStatModifiers()[1]);
        setSaveWill(getStatModifiers()[4]+2);
        Armor chainShirt = new Armor("Chain Shirt", 1, 4, "Light Armor");
        Inventory.addItem(chainShirt, backpack.getAvailableSlots(), backpack.getInventory());
        Equipment.equipItem("Body", chainShirt);
        Armor woodenShield = new Armor("Wooden Shield",1,1,"Light Shield");
        Inventory.addItem(woodenShield, backpack.getAvailableSlots(), backpack.getInventory());
        Equipment.equipItem("Shield", woodenShield);
        Weapon flangedMace = new Weapon("Flanged Mace", 1 ,6, 1, "1-handed Blunt");
        Inventory.addItem(flangedMace, backpack.getAvailableSlots(), backpack.getInventory() );
        KeyItems holySymbol = new KeyItems("Holy Symbol", 1);
        Inventory.addItem(holySymbol, backpack.getAvailableSlots(), backpack.getInventory());

    }
    //fighter
    public void setFighter(int[] stats){
        setMaxHP(getStatModifiers()[2]+ 10 + Dice.d10(1));
        setSaveFort(getStatModifiers()[2]+2);
        setSaveRef(getStatModifiers()[1]);
        setSaveWill(getStatModifiers()[4]);
//        inventory.add("Longsword");
        Weapon longsword = new Weapon("Longsword", 1, 6, 1, "1-handed Blade");
        Inventory.addItem(longsword, backpack.getAvailableSlots(),backpack.getInventory());
//        inventory.add("Steel Shield");
        Armor steelShield = new Armor("Steel Shield", 1,2,"Heavy Shield");
        Inventory.addItem(steelShield, backpack.getAvailableSlots(), backpack.getInventory());
        Equipment.equipItem("Shield", steelShield);
//        inventory.add("Scale Mail");
        Armor scaleMail = new Armor("Scale Mail", 1,4,"Medium Armor");
        Inventory.addItem(scaleMail, backpack.getAvailableSlots(),backpack.getInventory());
        Equipment.equipItem("Body", scaleMail);

    }
    //rogue
    public void setRogue(int[] stats){
        setMaxHP(getStatModifiers()[2]+ 6 + Dice.d6(1));
        setSaveFort(getStatModifiers()[2]);
        setSaveRef(getStatModifiers()[1]+2);
        setSaveWill(getStatModifiers()[4]);
//        inventory.add("Dagger");
        Weapon dagger = new Weapon("Dagger", 2,4,1,"Agile");
        Inventory.addItem(dagger, backpack.getAvailableSlots(), backpack.getInventory());
//        inventory.add("Leather Armor");
        Armor leatherArmor = new Armor("Leather Armor", 1, 2, "Light Armor");
        Inventory.addItem(leatherArmor, backpack.getAvailableSlots(),backpack.getInventory());
        Equipment.equipItem("Body", leatherArmor);
//        inventory.add("Thieves Tools");
        KeyItems thievesTools = new KeyItems("Thieves Tools", 1);
        Inventory.addItem(thievesTools, backpack.getAvailableSlots(),backpack.getInventory());
    }
    //wizard
    public void setWizard(int[] stats){
        setMaxHP(getStatModifiers()[2]+ 4 + Dice.d4(1));
        setSaveFort(getStatModifiers()[2]);
        setSaveRef(getStatModifiers()[1]);
        setSaveWill(getStatModifiers()[4]+2);
//        inventory.add("Staff");
        Weapon woodenStaff = new Weapon("Wooden Staff", 1,6,1,"Staff");
        Inventory.addItem(woodenStaff, backpack.getAvailableSlots(),backpack.getInventory());
//        inventory.add("Spellbook");
        KeyItems spellbook = new KeyItems("Spellbook", 1);
        Inventory.addItem(spellbook, backpack.getAvailableSlots(),backpack.getInventory());
//        inventory.add("Pointed Hat");
        Armor pointedHat = new Armor("Pointed Hat",1,0,"Cloth");
        Inventory.addItem(pointedHat, backpack.getAvailableSlots(),backpack.getInventory());
        Equipment.equipItem("Head", pointedHat);
//        inventory.add("Robes");
        Armor wizardRobes = new Armor("Wizard Robe",1,0,"Cloth");
        Inventory.addItem(wizardRobes, backpack.getAvailableSlots(),backpack.getInventory());
        Equipment.equipItem("Body", wizardRobes);
    }


}
