/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sportstats.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import sportstats.domain.Season;
import sportstats.domain.broker.BrokerFactory;
import sportstats.exceptions.SportstatsServiceException;

/**
 *
 * @author Niklas
 */
public class AddSeasonByLeagueIdServiceTest extends BaseServiceTest {
    
    public AddSeasonByLeagueIdServiceTest() {
        
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
    
    @Test
    public void testStartYearShouldNotBeNegative(){
    
        try{
            new AddSeasonByLeagueIdService(1, -2018, 2019);
            fail("Should throw exception");
        }catch(SportstatsServiceException e){
            
        }
        
    }
    
    @Test
    public void testEndYearShouldNotBeNegative(){
    
        try{
            new AddSeasonByLeagueIdService(1, 2018, -2019);
            fail("Should throw exception");
        }catch(SportstatsServiceException e){
            
        }
        
    }
    
    @Test
    public void testExecute() {
        
        BrokerFactory brokerFactory = getMockedBrokerFactoryWithSetup();
        
        AddSeasonByLeagueIdService instance = new AddSeasonByLeagueIdService(10, 2020, 2021);
        instance.init(brokerFactory);
    
        Season expResult = brokerFactory.getSeasonBroker().create();
        Season result = instance.execute();
      
        assertEquals(expResult.getId(), result.getId());
        
    }
   
    @Override
    protected BrokerFactory getMockedBrokerFactoryWithSetup(){
        
        BrokerFactory brokerFactory = getMockedBrokerFactory();
        
        //För att inte spara något till databasen
        Season season = mock(Season.class);
  
        when(brokerFactory.getSeasonBroker().create()).thenReturn(season);
        
        return brokerFactory;
        
    }
    
}
