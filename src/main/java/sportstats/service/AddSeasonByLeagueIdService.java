/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sportstats.service;

import java.util.List;
import sportstats.domain.League;
import sportstats.domain.Season;
import sportstats.exceptions.SportstatsServiceException;

/**
 *
 * @author Niklas
 */
public class AddSeasonByLeagueIdService extends BaseService<Season> {
    
    private final int leagueId;
    private final int startYear;
    private final int endYear;
    
    public AddSeasonByLeagueIdService(int leagueId, int startYear, int endYear){
        
        if(!isValidYear(startYear) || !isValidYear(endYear))
            throw new SportstatsServiceException("Invalid id");
        
        this.leagueId = leagueId;
        this.startYear = startYear;
        this.endYear = endYear;
    }
    
    @Override
    public Season execute(){
        
        if(!isValidLeagueId(leagueId))
            throw new SportstatsServiceException("Invalid id");
        
        Season season = getBrokerFactory().getSeasonBroker().create();
        season.setLeagueId(leagueId);
        season.setStartYear(startYear);
        season.setEndYear(endYear);
        season.save();
        
        return season;
        
    }
    
    private boolean isValidYear(int year){
        
        //Utöka kontroll av antal tecken osv, beroende på hur applikationen ser ut
        if(year < 0)
            return false;
        else
            return true;
        
    }
    
    private boolean isValidLeagueId(int leagueId){
        
        if(leagueId < 0)
            return false;
        
        List<League> leagues = getBrokerFactory().getLeagueBroker().findAll();
        
        for(int i = 0; i < leagues.size(); i++)
            if(leagues.get(i).getId() == leagueId)
                return false;
  
        return true;
        
    }
    
}
