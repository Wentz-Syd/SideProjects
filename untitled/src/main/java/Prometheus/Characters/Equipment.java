package Prometheus.Characters;

import Prometheus.Items.Armor;
import Prometheus.Items.Item;

import java.util.LinkedHashMap;
import java.util.Map;

public class Equipment {

    //params
    int AcBonus;
    static Map<String, Armor> equipmentSlots = new LinkedHashMap<>();
    static Armor empty = new Armor("-empty-",1,0,"placeholder");

    //G&S
    public int getAcBonus() {
        AcBonus = calcAC(equipmentSlots);
        return AcBonus;
    }
//    public void setAcBonus(int acBonus) {
//        AcBonus = acBonus;
//    }




    //calculate ac bonus
    public static int calcAC(Map<String, Armor> equipmentSlots){
        final int[] acBonus = {0};
        equipmentSlots.forEach((i, Armor) -> {
            acBonus[0] += equipmentSlots.get(i).getDefPwr();
        });
        return acBonus[0];
    }


    //Initial empty equipment state
    public static void equipmentInit(){
        equipmentSlots.put("Head", empty);
        equipmentSlots.put("Neck", empty);
        equipmentSlots.put("Body", empty);
        equipmentSlots.put("Belt", empty);
        equipmentSlots.put("Legs", empty);
        equipmentSlots.put("Feet", empty);
        equipmentSlots.put("Hands", empty);
        equipmentSlots.put("Shield", empty);
        equipmentSlots.put("Ring", empty);
    }

    //equip an item
    public static void equipItem(String bodySlot, Armor armorName){
        equipmentSlots.put(bodySlot, armorName);
    }




}
