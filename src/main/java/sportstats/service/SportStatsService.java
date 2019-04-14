/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.service;

import sportstats.domain.broker.BrokerFactory;

/**
 *
 * @author Niklas
 * @param <T>
 */
public interface SportStatsService<T> {
    
    void init(BrokerFactory brokerFactory);
    T execute();
           
}
