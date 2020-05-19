package com.sg.testing.dao.implementations;

import com.sg.testing.model.Monster;
import com.sg.testing.model.MonsterType;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author froo
 */
public class MonsterDaoTest {
    AGoodMonsterDao testDao=new AGoodMonsterDao();
    public MonsterDaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws IOException {
        AGoodMonsterDao testDao=new AGoodMonsterDao();
        String testFile = "testDao.txt";
        // Use the FileWriter to quickly blank the file
        FileWriter fileWriter = new FileWriter(testFile);
        testDao = new AGoodMonsterDao(testFile);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddMonster() {
        AGoodMonsterDao testDao=new AGoodMonsterDao();
        //Arrange
        Monster M=new Monster("Dracula",MonsterType.VAMPIRE,9864,"Bloody Maries");
        //Act
        Monster retrieved=new Monster();
        testDao.addMonster(0001, M);
        retrieved=testDao.getMonster(0001);
        //Assert
        assertEquals(M.getName(),retrieved.getName(),"Checking monster's name.");
    }
    @Test
    public void testGetMonster() {
        AGoodMonsterDao testDao=new AGoodMonsterDao();
        //Arrange
        Monster M=new Monster("Dracula",MonsterType.VAMPIRE,9864,"Bloody Maries");
        //Act
        testDao.addMonster(0001, M);
        Monster retrieved=testDao.getMonster(0001);
        //Assert
        assertEquals(M.getName(), retrieved.getName(),"Checking monster's name.");
    }
    @Test
    public void testGetAllMonsters() {
        AGoodMonsterDao testDao=new AGoodMonsterDao();
        //Arrange
        Monster M=new Monster("Dracula",MonsterType.VAMPIRE,9864,"Bloody Maries");
        Monster Mo=new Monster("Peter Stubbe",MonsterType.WEREWOLF,328,"Antelopes");
        //Act
        testDao.addMonster(0001, M);
        testDao.addMonster(0002, Mo);
        List<Monster> retrieved=testDao.getAllMonsters();
        //Assert
        assertEquals(M.getName(), retrieved.get(0).getName(),"Checking Dracula's name.");
        assertEquals(Mo.getName(), retrieved.get(1).getName(),"Checking Peter's name.");
    }
    @Test
    public void testUpdateMonster() {
        AGoodMonsterDao testDao=new AGoodMonsterDao();
        //Arrange
        Monster M=new Monster("Dracula",MonsterType.VAMPIRE,9864,"Bloody Maries");
        Monster Mo=new Monster("Peter Stubbe",MonsterType.WEREWOLF,328,"Antelopes");
        //Act
        testDao.addMonster(0001, M);
        testDao.updateMonster(0001, Mo);
        Monster retrieved=testDao.getMonster(0001);
        //Assert
        assertEquals(Mo.getName(), retrieved.getName(),"Checking monster's name.");
    }
    @Test
    public void testRemoveMonster() {
        AGoodMonsterDao testDao=new AGoodMonsterDao();
        //Arrange
        Monster M=new Monster("Dracula",MonsterType.VAMPIRE,9864,"Bloody Maries");
        Monster Mo=new Monster("Peter Stubbe",MonsterType.WEREWOLF,328,"Antelopes");
        //Act
        testDao.addMonster(0001, M);
        testDao.addMonster(0002, Mo);
        testDao.removeMonster(0001);
        List<Monster> retrieved=testDao.getAllMonsters();
        //Assert
        assertEquals(Mo.getName(), retrieved.get(0).getName(),"Checking Dracula's name.");
        
    }
}
