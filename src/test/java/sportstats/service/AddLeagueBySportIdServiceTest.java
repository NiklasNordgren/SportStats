/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.service;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import sportstats.domain.League;
import sportstats.domain.Sport;
import sportstats.domain.broker.BrokerFactory;
import sportstats.exceptions.SportstatsServiceException;

/**
 *
 * @author Niklas
 */
public class AddLeagueBySportIdServiceTest extends BaseServiceTest {

    public AddLeagueBySportIdServiceTest() {

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
            new AddLeagueBySportIdService(null, 1);
            fail("Should throw exception");
        }catch(SportstatsServiceException e){
            
        }
          
    }
    
    @Test
    public void testNameShouldNotBeEmpty(){
        
        try{
            new AddLeagueBySportIdService("", 1);
            fail("Should throw exception");
        }catch(SportstatsServiceException e){
            
        }
          
    }

    @Test
    public void testExecute(){
        
        BrokerFactory brokerFactory = getMockedBrokerFactoryWithSetup();
        
        AddLeagueBySportIdService instance = new AddLeagueBySportIdService("testName", 1);
        instance.init(brokerFactory);

        League expResult = brokerFactory.getLeagueBroker().create();
        League result = instance.execute();
  
        assertEquals(expResult.getLeagueName(), result.getLeagueName());
        assertEquals(expResult.getId(), result.getId());
        
    }

    @Override
    protected BrokerFactory getMockedBrokerFactoryWithSetup(){
        
        BrokerFactory brokerFactory = getMockedBrokerFactory();
        
        when(brokerFactory.getSportBroker().findAll()).thenReturn(new ArrayList<Sport>());

        //För att inte spara något till databasen
        League league = mock(League.class);
       
        when(brokerFactory.getLeagueBroker().create()).thenReturn(league);

        return brokerFactory;
        
    }
    
}
