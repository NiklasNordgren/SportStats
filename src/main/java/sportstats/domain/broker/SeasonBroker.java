/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain.broker;

import java.util.List;
import sportstats.domain.Season;
import sportstats.domain.Sport;

/**
 *
 * @author Niklas
 */
public class SeasonBroker {
    
    public List<Season> findAll(){
        return new Season().getAll();
    }
    
    public Season findById(int id){
        return new Season().get(id);
    }
    
    public Season create(){
        return new Season();
    }
    
}
