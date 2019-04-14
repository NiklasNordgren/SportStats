/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain.broker;

import java.util.List;
import sportstats.domain.League;

/**
 *
 * @author Niklas
 */
public class LeagueBroker {
    
    public List<League> findAll(){
        return new League().getAll();
    }
    
    public League findById(int id){
        return new League().get(id);
    }
    
    public League create(){
        return new League();
    }
    
}
