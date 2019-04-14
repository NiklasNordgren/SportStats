/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain.broker;

import java.util.List;
import sportstats.domain.Sport;

/**
 *
 * @author Niklas
 */
public class SportBroker {
    
    public List<Sport> findAll(){
        return Sport.findAll();
    }
    
    public Sport findById(int id){
        return Sport.findById(id);
    }
    
    public Sport create(){
        return new Sport();
    }
     
}
