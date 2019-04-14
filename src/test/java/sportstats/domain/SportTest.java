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
import sportstats.db.records.SportRecord;

/**
 *
 * @author Niklas
 */
public class SportTest {
    
    private final Sport instance;
    private final SportRecord sportRecordMock;
    
    public SportTest() {
        sportRecordMock = mock(SportRecord.class);
        instance = new Sport(sportRecordMock);
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
     * Test of getId method, of class Sport.
     */
    @Test
    public void testGetId() {
        
        when(sportRecordMock.getString("id")).thenReturn("6");
        
        String expResult = "6";
        String result = instance.getId();
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setId method, of class Sport.
     */
    
    
    @Test
    public void testSetId() {
        
        String expResult = "5";
        
        instance.setId(expResult);
        verify(sportRecordMock, times(1)).setString("id", expResult);
    }
    
    
    /**
     * Test of getSportName method, of class Sport.
     */
    
    @Test
    public void testGetSportName() {
        
        when(sportRecordMock.getString("sport_name")).thenReturn("Soccer");
        
        String expResult = "Soccer";
        String result = instance.getSportName();
        
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of setSportName method, of class Sport.
     */
    
    @Test
    public void testSetSportName() {
        
        String name = "testName";
        
        instance.setSportName(name);
        verify(sportRecordMock, times(1)).setString("sport_name", name);
    }
    
    
    /**
     * Test of getNumberOfColumns method, of class Sport.
     */
    @Test
    public void testGetNumberOfColumns() {
        
        int expResult = 2;
        int result = Sport.getNumberOfColumns();
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of getColumnNames method, of class Sport.
     */
    @Test
    public void testGetColumnNames() {
        
        String[] expResult = {"id", "sport_name"};
        String[] result = Sport.getColumnNames();
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of findAll method, of class Sport.
     */
    @Test
    public void testFindAll() {
        
        /*
            TODO: Fixa unit-test m.h.a PowerMockito eller dylikt
        */
         
    }
    
    
    /**
     * Test of findById method, of class Sport.
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
        
        verify(sportRecordMock, times(1)).save();
        
    }
    
    /**
     * Test of delete method, of class Sport.
     */
    @Test
    public void testDelete() {
        
        instance.delete();
        
        verify(sportRecordMock, times(1)).delete();
        
    }
  
}


