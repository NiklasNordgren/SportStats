/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.service;

import sportstats.domain.Sport;
import sportstats.exceptions.SportstatsServiceException;

/**
 *
 * @author Niklas
 */
public class AddSportService extends BaseService<Sport> {

    private final String sportName;
    
    public AddSportService(String sportName){
        
        if(!isValidSportName(sportName))
            throw new SportstatsServiceException("Invalid sportname");
        
        this.sportName = sportName;
    }
    
    @Override
    public Sport execute(){

        Sport sport = getBrokerFactory().getSportBroker().create();
        sport.setSportName(sportName);
        sport.save();
        
        return sport;
    }
    
    private boolean isValidSportName(String sportName){
        
        return sportName != null && !(sportName.isEmpty());
        
    }
   
}
