/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import sportstats.db.records.LeaderboardRecord;


/**
 *
 * @author Niklas
 */
public class LeaderboardTest {
    
    private Leaderboard instance;
    private LeaderboardRecord leaderboardRecordMock;
    
    public LeaderboardTest() {
        leaderboardRecordMock = mock(LeaderboardRecord.class);
        instance = new Leaderboard(leaderboardRecordMock);
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Leaderboard.
     */
    @Test
    public void testGetId() {

        when(leaderboardRecordMock.getString("id")).thenReturn("16");
   
        String expResult = "16";
        String result = instance.getId();
        
        assertEquals(expResult, result);  
    }

    /**
     * Test of setId method, of class Leaderboard.
     */
    
    @Test
    public void testSetId() {
        
        String expResult = "15";
      
        instance.setId(expResult);
        verify(leaderboardRecordMock, times(1)).setString("id", expResult);
    }
    

    /**
     * Test of getSeasonId method, of class Leaderboard.
     */
    @Test
    public void testGetSeasonId() {
        
        when(leaderboardRecordMock.getString("season_id")).thenReturn("26");
        
        String expResult = "26";
        String result = instance.getSeasonId();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setSeasonId method, of class Leaderboard.
     */
    @Test
    public void testSetSeasonId() {
        
        String expResult = "25";
      
        instance.setSeasonId(expResult);
        verify(leaderboardRecordMock, times(1)).setString("season_id", expResult);
        
    }
    
    /**
     * Test of getNumberOfColumns method, of class Leaderboard.
     */
    @Test
    public void testGetNumberOfColumns() {
       
        int expResult = 2;
        int result = Leaderboard.getNumberOfColumns();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getColumnNames method, of class Leaderboard.
     */
    @Test
    public void testGetColumnNames() {
   
        String[] expResult = {"id", "season_id"};
        String[] result = Leaderboard.getColumnNames();
        
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of findAll method, of class Leaderboard.
     */
    @Test
    public void testFindAll() {
        
        /*
            TODO: Fixa unit-test m.h.a PowerMockito eller dylikt
        */
        
    }
    

    /**
     * Test of findById method, of class Leaderboard.
     */
    @Test
    public void testFindById() {
        /*
            TODO: Fixa unit-test m.h.a PowerMockito eller dylikt
        */
    }

    /**
     * Test of save method, of class Sport.
     */
    @Test
    public void testSave() {
        
        instance.save();
        
        verify(leaderboardRecordMock, times(1)).save();
        
    }
    
    /**
     * Test of delete method, of class Sport.
     */
    @Test
    public void testDelete() {
        
        instance.delete();
        
        verify(leaderboardRecordMock, times(1)).delete();
        
    }

}
