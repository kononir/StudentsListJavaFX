/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysearchjavafx;

import java.util.Optional;

/**
 *
 * @author vlad
 */
public class DeletingController {
    final private Optional<String> answerOptional;
    
    public DeletingController(Optional<String> answerOptional){
        this.answerOptional = answerOptional;
    }
}
