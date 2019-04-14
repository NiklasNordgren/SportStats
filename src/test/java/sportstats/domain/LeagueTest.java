/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import sportstats.storage.LeagueDao;

/**
 *
 * @author Niklas
 */
public class LeagueTest {
    
    private final League instance;
    private final LeagueDao leagueDaoMock;
    
    public LeagueTest() {
        leagueDaoMock = mock(LeagueDao.class);
        instance = new League(leagueDaoMock);
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
     * Test of get method, of class Season.
     */
    @Test
    public void testGet() {
        
        League expResult = new League();
        
        when(leagueDaoMock.get(5)).thenReturn(expResult);
        League result = instance.get(5);
        
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of getAll method, of class Season.
     */
    @Test
    public void testGetAll() {
        
        List<League> expResult  = new ArrayList<>();
        
        when(leagueDaoMock.getAll()).thenReturn(expResult);
        List<League> result = instance.getAll();
        
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of save method, of class Season.
     */
    @Test
    public void testSave() {
        
        instance.save();
        
        verify(leagueDaoMock, times(1)).save(instance);
        
    }
    
    /**
     * Test of update method, of class Season.
     */
    @Test
    public void testUpdate() {
        
        instance.update();
        
        verify(leagueDaoMock, times(1)).update(instance);
        
    }
    
    /**
     * Test of update method, of class Season.
     */
    @Test
    public void testDelete() {
        
        instance.delete();
        
        verify(leagueDaoMock, times(1)).delete(instance);
        
    }
    
    /**
     * Test of getNumberOfColumns method, of class Season.
     */
    @Test
    public void testGetNumberOfColumns() {
        
        when(leagueDaoMock.getNumberOfColumns()).thenReturn(5);
        
        int expResult = leagueDaoMock.getNumberOfColumns();
        
        int result = instance.getNumberOfColumns();
        
        assertEquals(expResult, result);
  
    }
    
    /**
     * Test of getColumnNames method, of class Season.
     */
    @Test
    public void testGetColumnNames() {
        
        when(leagueDaoMock.getColumnNames()).thenReturn(new String[]{"id", "league_name", "sport_id"});
        
        String[] expResult = leagueDaoMock.getColumnNames();
        
        String[] result = instance.getColumnNames();
        
        assertEquals(expResult, result);
  
    }

    /**
     * Test of getId and setId methods, of class League.
     */
    @Test
    public void testGetAndSetLeagueId() {

        instance.setId(9);
        
        int expResult = 9;
        int result = instance.getId();
        
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getLeagueName and setLeagueName methods, of class League.
     */
    @Test
    public void testGetAndSetLeagueName() {
  
        instance.setLeagueName("testName");
        
        String expResult = "testName";
        String result = instance.getLeagueName();
        
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getSportId and setSportId methods, of class League.
     */
    @Test
    public void testGetAndSetSportId() {
  
        instance.setSportId(77);
        
        int expResult = 77;
        int result = instance.getSportId();
        
        assertEquals(expResult, result);
        
    }

}
