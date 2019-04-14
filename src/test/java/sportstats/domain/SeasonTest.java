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
import sportstats.storage.SeasonDao;

/**
 *
 * @author Niklas
 */
public class SeasonTest {
    
    private final Season instance;
    private final SeasonDao seasonDaoMock;
    
    public SeasonTest() {
        seasonDaoMock = mock(SeasonDao.class);
        instance = new Season(seasonDaoMock);
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
        
        Season expResult  = new Season();
        
        when(seasonDaoMock.get(5)).thenReturn(expResult);
        Season result = instance.get(5);
        
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of getAll method, of class Season.
     */
    @Test
    public void testGetAll() {
        
        List<Season> expResult  = new ArrayList<>();
        
        when(seasonDaoMock.getAll()).thenReturn(expResult);
        List<Season> result = instance.getAll();
        
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of save method, of class Season.
     */
    @Test
    public void testSave() {
        
        instance.save();
        
        verify(seasonDaoMock, times(1)).save(instance);
        
    }
    
    /**
     * Test of update method, of class Season.
     */
    @Test
    public void testUpdate() {
        
        instance.update();
        
        verify(seasonDaoMock, times(1)).update(instance);
        
    }
    
    /**
     * Test of update method, of class Season.
     */
    @Test
    public void testDelete() {
        
        instance.delete();
        
        verify(seasonDaoMock, times(1)).delete(instance);
        
    }
    
    /**
     * Test of getNumberOfColumns method, of class Season.
     */
    @Test
    public void testGetNumberOfColumns() {
        
        when(seasonDaoMock.getNumberOfColumns()).thenReturn(5);
        
        int expResult = seasonDaoMock.getNumberOfColumns();
        
        int result = instance.getNumberOfColumns();
        
        assertEquals(expResult, result);
  
    }
    
    /**
     * Test of getColumnNames method, of class Season.
     */
    @Test
    public void testGetColumnNames() {
        
        when(seasonDaoMock.getColumnNames()).thenReturn(new String[]{"id", "start_year", "end_year", "league_id", "season_team_list_id"});
        
        String[] expResult = seasonDaoMock.getColumnNames();
        
        String[] result = instance.getColumnNames();
        
        assertEquals(expResult, result);
  
    }
    
    /**
     * Test of getId and setId methods, of class Season.
     */
    @Test
    public void testGetAndSetSeasonId() {
        
        instance.setId(55);
        
        int expResult = 55;
        int result = instance.getId();
        
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of getStartYear method, of class Season.
     */
    @Test
    public void testGetAndSetStartYear() {
        
        instance.setStartYear(2000);
        
        int expResult = 2000;
        int result = instance.getStartYear();
        
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of getEndYear method, of class Season.
     */
    @Test
    public void testGetAndSetEndYear() {
        
        instance.setEndYear(2015);
        
        int expResult = 2015;
        int result = instance.getEndYear();
        
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of getLeagueId method, of class Season.
     */
    @Test
    public void testGetAndSetLeagueId() {
        
        instance.setLeagueId(56);
        
        int expResult = 56;
        int result = instance.getLeagueId();
        
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of getSeasonTeamMapId method, of class Season.
     */
    @Test
    public void testGetAndSetSeasonTeamMapId() {
        
        instance.setSeasonTeamMapId(99);
        
        int expResult = 99;
        int result = instance.getSeasonTeamMapId();
        
        assertEquals(expResult, result);
        
    }
    
}
