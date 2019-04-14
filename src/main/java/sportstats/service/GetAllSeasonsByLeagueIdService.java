/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.service;

import java.util.ArrayList;
import java.util.List;
import sportstats.domain.League;
import sportstats.domain.Season;
import sportstats.exceptions.SportstatsServiceException;

/**
 *
 * @author Niklas
 */
public class GetAllSeasonsByLeagueIdService extends BaseService<List<Season>> {

    private int leagueId;
    
    public GetAllSeasonsByLeagueIdService(int leagueId){
        this.leagueId = leagueId;
    }

    @Override
    public List<Season> execute(){
        
        if(!isValidLeagueId())
            throw new SportstatsServiceException("invalid id");

        List<Season> allSeasons = getBrokerFactory().getSeasonBroker().findAll();
        
        List<Season> result = new ArrayList<>();
        
        for(int i = 0; i < allSeasons.size(); i++){
            
            if(allSeasons.get(i).getLeagueId() == leagueId)
                result.add(allSeasons.get(i));
            
        }
         
        return result;
    }
    
    private boolean isValidLeagueId(){
     
        return leagueId > 0;
    }
    
}
