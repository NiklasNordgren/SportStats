/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import sportstats.domain.Season;
import sportstats.domain.broker.BrokerFactory;

/**
 *
 * @author Niklas
 */
public class GetAllSeasonsByLeagueIdServiceTest extends BaseServiceTest {

    public GetAllSeasonsByLeagueIdServiceTest() {
        
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
    public void testExecute() {
        
        BrokerFactory brokerFactory = getMockedBrokerFactoryWithSetup();
        
        GetAllSeasonsByLeagueIdService instance = new GetAllSeasonsByLeagueIdService(5);
        instance.init(brokerFactory);
        
        List<Season> result = instance.execute();
        List<Season> expResult = brokerFactory.getSeasonBroker().findAll();
        
        assertEquals(expResult, result);
        
    }

    @Override
    protected BrokerFactory getMockedBrokerFactoryWithSetup() {
        
        BrokerFactory brokerFactory = getMockedBrokerFactory();
       
        when(brokerFactory.getSeasonBroker().findAll()).thenReturn(new ArrayList<Season>());

        return brokerFactory;
        
    }
    
}
