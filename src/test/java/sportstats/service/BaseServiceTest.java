/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import sportstats.domain.broker.BrokerFactory;
import sportstats.domain.broker.LeaderboardBroker;
import sportstats.domain.broker.LeagueBroker;
import sportstats.domain.broker.SeasonBroker;
import sportstats.domain.broker.SportBroker;

/**
 *
 * @author Niklas
 */
public abstract class BaseServiceTest {
    
    protected abstract BrokerFactory getMockedBrokerFactoryWithSetup();
    
    protected BrokerFactory getMockedBrokerFactory(){
        
        SportBroker sportBroker = mock(SportBroker.class);
        LeagueBroker leagueBroker = mock(LeagueBroker.class);
        SeasonBroker seasonBroker = mock(SeasonBroker.class);
        LeaderboardBroker leaderboardBroker = mock(LeaderboardBroker.class);
        
        BrokerFactory brokerFactory = mock(BrokerFactory.class);
        
        when(brokerFactory.getSportBroker()).thenReturn(sportBroker);
        when(brokerFactory.getLeagueBroker()).thenReturn(leagueBroker);
        when(brokerFactory.getSeasonBroker()).thenReturn(seasonBroker);
        when(brokerFactory.getLeaderboardBroker()).thenReturn(leaderboardBroker);
        
        return brokerFactory;
    }

}
