/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.service;

import java.util.ArrayList;
import java.util.List;
import sportstats.domain.League;
import sportstats.domain.Sport;
import sportstats.exceptions.SportstatsServiceException;

/**
 *
 * @author Niklas
 */
public class GetAllLeaguesBySportIdService extends BaseService<List<League>> {

    private int sportId;
    
    public GetAllLeaguesBySportIdService(int sportId){
        this.sportId = sportId;
    }
     
    @Override
    public List<League> execute(){
        
        if(!isValidSportId(sportId))
            throw new SportstatsServiceException("Invalid id");
  
        List<League> allLeagues = getBrokerFactory().getLeagueBroker().findAll();
        
        List<League> result = new ArrayList<>();
        
        for(int i = 0; i < allLeagues.size(); i++){
            
            if(allLeagues.get(i).getSportId() == sportId)
                result.add(allLeagues.get(i));
            
        }
         
        return result;
    }
    
    
    private boolean isValidSportId(int sportId){
        
        return sportId > 0;

    }

}
