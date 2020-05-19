package com.sg.testing.dao.implementations;

import com.sg.testing.dao.implementations.buggy.BadMonsterDaoA;
import com.sg.testing.dao.implementations.buggy.BadMonsterDaoB;
import com.sg.testing.dao.implementations.buggy.BadMonsterDaoC;
import com.sg.testing.dao.implementations.buggy.BadMonsterDaoD;
import com.sg.testing.dao.implementations.buggy.BadMonsterDaoE;
import com.sg.testing.dao.implementations.buggy.BadMonsterDaoF;
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
    //AGoodMonsterDao testDao=new AGoodMonsterDao();
    BadMonsterDaoF testDao=new BadMonsterDaoF();
    
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
        //AGoodMonsterDao testDao=new AGoodMonsterDao();
        BadMonsterDaoF testDao=new BadMonsterDaoF();
        String testFile = "testDao.txt";
        // Use the FileWriter to quickly blank the file
        FileWriter fileWriter = new FileWriter(testFile);
        //testDao = new AGoodMonsterDao(testFile);
        testDao = new BadMonsterDaoF(testFile);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddMonster() {
        //AGoodMonsterDao testDao=new AGoodMonsterDao();
        BadMonsterDaoF testDao=new BadMonsterDaoF();
        //Arrange
        Monster M=new Monster("Dracula",MonsterType.VAMPIRE,9864,"Bloody Maries");
        //Act
        Monster retrieved=new Monster();
        testDao.addMonster(0001, M);
        retrieved=testDao.getMonster(0001);
        //Monster retrieved=testDao.addMonster(0001, M);
        //Assert
        assertEquals(M.getName(),
                retrieved.getName(),
                "Checking monster's name.");
    }
    @Test
    public void testGetMonster() {
        //AGoodMonsterDao testDao=new AGoodMonsterDao();
        BadMonsterDaoF testDao=new BadMonsterDaoF();
        
        //Arrange
        Monster M=new Monster("Dracula",MonsterType.VAMPIRE,9864,"Bloody Maries");
        //Act
        Monster retrieved=new Monster();
        testDao.addMonster(0001, M);
        retrieved=testDao.getMonster(0001);
        //Assert
        assertEquals(M.getName(), 
                retrieved.getName(),
                "Checking monster's name.");
    }
    @Test
    public void testGetAllMonsters() {
        //AGoodMonsterDao testDao=new AGoodMonsterDao();
        BadMonsterDaoF testDao=new BadMonsterDaoF();
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
        //AGoodMonsterDao testDao=new AGoodMonsterDao();
        BadMonsterDaoF testDao=new BadMonsterDaoF();
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
        //AGoodMonsterDao testDao=new AGoodMonsterDao();
        BadMonsterDaoF testDao=new BadMonsterDaoF();
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
    @Test
    public void testBadA() {
        BadMonsterDaoA testDao=new BadMonsterDaoA();
        //Arrange
        Monster M=new Monster("Dracula",MonsterType.VAMPIRE,9864,"Bloody Maries");
        Monster Mo=new Monster("Peter Stubbe",MonsterType.WEREWOLF,328,"Antelopes");
        //Act
        testDao.addMonster(0001, M);
        testDao.addMonster(0002, Mo);
        List<Monster> retrieved=testDao.getAllMonsters();
        //Assert
        assertEquals(2, retrieved.size(),"GetAll has a problem returning.");
    }
    @Test
    public void testBadB() {
        BadMonsterDaoB testDao=new BadMonsterDaoB();
        //Arrange
        Monster M=new Monster("Dracula",MonsterType.VAMPIRE,9864,"Bloody Maries");
        Monster Mo=new Monster("Peter Stubbe",MonsterType.WEREWOLF,328,"Antelopes");
        //Act
        testDao.addMonster(0001, M);
        testDao.addMonster(0002, Mo);
        testDao.removeMonster(0001);
        List<Monster> retrieved=testDao.getAllMonsters();
        //Assert
        assertEquals(1, retrieved.size(),"It's not removing.");
    }
    @Test
    public void testBadC() {
        BadMonsterDaoC testDao=new BadMonsterDaoC();
        //Arrange
        Monster M=new Monster("Dracula",MonsterType.VAMPIRE,9864,"Bloody Maries");
        Monster Mo=new Monster("Peter Stubbe",MonsterType.WEREWOLF,328,"Antelopes");
        //Act
        testDao.addMonster(0001, M);
        testDao.addMonster(0002, Mo);
        testDao.removeMonster(0001);
        List<Monster> retrieved=testDao.getAllMonsters();
        //Assert
        assertEquals(1, retrieved.size(),"It's coming back empty, wrong type.");
    }
    @Test
    public void testBadD() {
        BadMonsterDaoD testDao=new BadMonsterDaoD();
        //Arrange
        Monster M=new Monster("Dracula",MonsterType.VAMPIRE,9864,"Bloody Maries");
        Monster Mo=new Monster("Peter Stubbe",MonsterType.WEREWOLF,328,"Antelopes");
        //Act
        testDao.addMonster(0001, M);
        testDao.addMonster(0002, Mo);
        testDao.removeMonster(0001);
        List<Monster> retrieved=testDao.getAllMonsters();
        //Assert
        assertEquals(1, retrieved.size(),"Passes all tests.");
    }
    @Test
    public void testBadE() {
        BadMonsterDaoE testDao=new BadMonsterDaoE();
        //Arrange
        Monster M=new Monster("Dracula",MonsterType.VAMPIRE,9864,"Bloody Maries");
        Monster Mo=new Monster("Peter Stubbe",MonsterType.WEREWOLF,328,"Antelopes");
        //Act
        testDao.addMonster(0001, M);
        testDao.addMonster(0002, Mo);
        testDao.updateMonster(0003, M);
        //Assert
        assertEquals(testDao.getMonster(0002), testDao.getMonster(0002),
                "It should fail this test because 0003 does not exist and"
                        + "each time it gets an object removes it.");
    }
    @Test
    public void testBadF() {
        BadMonsterDaoF testDao=new BadMonsterDaoF();
        //Arrange
        Monster M=new Monster("Dracula",MonsterType.VAMPIRE,9864,"Bloody Maries");
        Monster Mo=new Monster("Peter Stubbe",MonsterType.WEREWOLF,328,"Antelopes");
        //Act
        testDao.addMonster(0001, M);
        testDao.addMonster(0002, Mo);
        Monster retrieved=testDao.getMonster(0002);
        //Assert
        assertEquals(Mo.getName(), retrieved.getName(),"Passes all tests.");
    }
}
