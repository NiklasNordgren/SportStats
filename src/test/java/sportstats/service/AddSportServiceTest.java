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
import sportstats.db.records.SportRecord;
import sportstats.domain.Sport;
import sportstats.domain.broker.BrokerFactory;
import sportstats.exceptions.SportstatsServiceException;

/**
 *
 * @author Niklas
 */
public class AddSportServiceTest extends BaseServiceTest {

    public AddSportServiceTest() {
 
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
    public void testNameShouldNotBeNull(){
        
        try{
            new AddSportService(null);
            fail("Should throw exception");
        }catch(SportstatsServiceException e){
            
        }
          
    }
    
    @Test
    public void testNameShouldNotBeEmpty(){
        
        try{
            new AddSportService("");
            fail("Should throw exception");
        }catch(SportstatsServiceException e){
            
        }
          
    }
     
    @Test
    public void testExecute() {
        
        BrokerFactory brokerFactory = getMockedBrokerFactoryWithSetup();
        
        AddSportService instance = new AddSportService("testSportName");
        instance.init(brokerFactory);
        
        Sport expResult = brokerFactory.getSportBroker().create();
        Sport result = instance.execute();
        
        assertEquals(expResult.getSportName(), result.getSportName());
 
    }

    @Override
    protected BrokerFactory getMockedBrokerFactoryWithSetup(){
        
        BrokerFactory brokerFactory = getMockedBrokerFactory();
        
        //För att inte spara något till databasen
        SportRecord sportRecordMock = mock(SportRecord.class);
        Sport sport = new Sport(sportRecordMock);
  
        when(brokerFactory.getSportBroker().create()).thenReturn(sport);
        
        return brokerFactory;
        
    }
   
}
