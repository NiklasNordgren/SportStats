/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sportstats.service;

import java.util.List;
import sportstats.domain.League;
import sportstats.domain.Sport;
import sportstats.exceptions.SportstatsServiceException;

/**
 *
 * @author Niklas
 */
public class AddLeagueBySportIdService extends BaseService<League> {
    
    private final int id;
    private String leagueName;
    
    public AddLeagueBySportIdService(String leagueName, int id){

        if(!isValidLeagueName(leagueName))
            throw new SportstatsServiceException("Invalid leaguename");
    
        this.leagueName = leagueName;
        this.id = id;  
        
    }
    
    @Override
    public League execute(){
        
        if(!isValidSportId())
            throw new SportstatsServiceException("Invalid id");
        
        League league = getBrokerFactory().getLeagueBroker().create();
        league.setLeagueName(leagueName);
        league.setSportId(id);
        league.save();
        
        return league;
        
    }
    
    private boolean isValidSportId(){
        
        if(id < 0)
            return false;
    
        List<Sport> sports = getBrokerFactory().getSportBroker().findAll();
        
        for(int i = 0; i < sports.size(); i++)
            if(sports.get(i).getId().equals(Integer.toString(id)))
                return false;
        
        return true;
        
    }
    
    private boolean isValidLeagueName(String leagueName){
        
        return leagueName != null && !(leagueName.isEmpty());
        
    }
    
}
