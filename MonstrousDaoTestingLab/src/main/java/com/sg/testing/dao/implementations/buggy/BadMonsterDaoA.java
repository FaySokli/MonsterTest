/*********************************
* The Software Guild
* Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
*********************************/
package com.sg.testing.dao.implementations.buggy;

import com.sg.testing.dao.MonsterDao;
import com.sg.testing.model.Monster;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BadMonsterDaoA implements MonsterDao {
    //Constructor
    private final String MONSTER_FILE;
    public BadMonsterDaoA(){
        MONSTER_FILE = "test.txt";
    }
    
    public BadMonsterDaoA(String testFile){
        MONSTER_FILE = testFile;
    }
    
    Map<Integer, Monster> monsters = new HashMap<>();
    int id;
    
    @Override
    public Monster addMonster(int i, Monster m) {
        return monsters.put(id, m);
    }

    @Override
    public Monster getMonster(int id) {
       Monster m = monsters.get(id);
       return m;
    }

    @Override
    public List<Monster> getAllMonsters() {
        List<Monster> monsterList = new ArrayList<>();
        monsterList.addAll(monsters.values());
        return monsterList;
    }

    @Override
    public void updateMonster(int id, Monster m) {
        monsters.replace(id, m);
    }

    @Override
    public Monster removeMonster(int id) {
        Monster m = monsters.remove(id);
        return m;
    }
    
}
