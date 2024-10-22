package Prometheus.Systems;

import Prometheus.Characters.Enemy;
import Prometheus.Combat.Attack;
import Prometheus.Combat.SpecialAttack;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Encounters {

    private Map<Integer, Enemy> enemyEncounters = new LinkedHashMap<>();

    public void setupEnemyEncounters(){
        List<Attack> skeletonAttacks = new ArrayList<>();
        skeletonAttacks.add(new Attack("Claw",Dice.d4(1)+1));
        enemyEncounters.put(1, new Enemy("Skeleton",Dice.d12(1),15,0,1,2, 1,skeletonAttacks));

        List<Attack> skeletonAttacksArmed = new ArrayList<>();
        skeletonAttacksArmed.add(new Attack("Claw",Dice.d4(1)+1));
        skeletonAttacksArmed.add(new Attack("Sword", Dice.d6(1)+1));
        enemyEncounters.put(2,new Enemy("Armed Skeleton", Dice.d12(1),15,0,1,2, 1, skeletonAttacksArmed));

        List<Attack> troglodyteAttacks = new ArrayList<>();
        troglodyteAttacks.add(new Attack("Club", Dice.d6(1)));
        troglodyteAttacks.add(new Attack("Claw", Dice.d4(1)));
        troglodyteAttacks.add(new SpecialAttack("Stench",0,false,false,true,Dice.d4(1)));
        enemyEncounters.put(3, new Enemy("Troglodyte",Dice.d8(2)+4,15,5,-1,0, 1,troglodyteAttacks));

        List<Attack> vargouilleAttacks = new ArrayList<>();
        vargouilleAttacks.add(new Attack("Bite", Dice.d4(1)));
        enemyEncounters.put(4, new Enemy("Vargouille", Dice.d8(1)+1,12,3,3,3,3,vargouilleAttacks));

        List<Attack> batSwarmAttacks = new ArrayList<>();
        batSwarmAttacks.add(new Attack("Swarm", Dice.d6(1)));
        enemyEncounters.put(5, new Enemy("Bat Swarm", Dice.d8(3),16,3,7,3,0, batSwarmAttacks));


    }

//    public Map<Integer, Enemy> chooseEnemyEncounters(){
//        int choice = Dice.d6(1);
////        Enemy encounter =
////        return encounter;
//    }



}
