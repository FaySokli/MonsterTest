package com.sg.testing.dao.implementations;

import com.sg.testing.model.Monster;
import com.sg.testing.model.MonsterType;
import static com.sg.testing.model.MonsterType.VAMPIRE;
import java.io.FileWriter;
import java.io.IOException;
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
        String testFile = "testDao.txt";
        // Use the FileWriter to quickly blank the file
        FileWriter fileWriter = new FileWriter(testFile);
        testDao = new AGoodMonsterDao(testFile);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAAddMonster() {
        AGoodMonsterDao testDao=new AGoodMonsterDao();
        //Arrange
        Monster M=new Monster("Dracula",MonsterType.VAMPIRE,9864,"Bloody Maries");
        //Act
        Monster retrieved=testDao.addMonster(0001, M);
        //Assert
        assertEquals(M.getName(), retrieved.getName(),"Checking monster's name.");
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
        //Act
        testDao.addMonster(0001, M);
        Monster retrieved=testDao.getMonster(0001);
        //Assert
        assertEquals(M.getName(), retrieved.getName(),"Checking monster's name.");
    }
}
