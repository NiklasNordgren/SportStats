/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.service;

import sportstats.db.DbConnectionSingleton;
import sportstats.domain.broker.BrokerFactory;

/**
 *
 * @author Niklas
 * @param <T>
 */
public class ServiceRunner<T> {
    
    private final SportStatsService<T> service;
    
    public ServiceRunner(SportStatsService service){
        this.service = service;
    }
    
    public T execute(){
        
        DbConnectionSingleton dbConn = DbConnectionSingleton.getInstance();
        service.init(new BrokerFactory());
        T result = null;
        
        try{
            dbConn.open();
            result = service.execute();
        }catch(Exception e){
            throw e;
        }finally{
            dbConn.close();
        }

        return result;   
        
    }
    
}
