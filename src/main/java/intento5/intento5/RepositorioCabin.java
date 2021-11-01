
package intento5.intento5;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jo-ha
 */
@Repository
public class RepositorioCabin {
    @Autowired
   private InterfaceCabin crud;
   
   public List<Cabin>getAll(){
       return (List<Cabin>) crud.findAll();
       
   }
   
   public Optional<Cabin>getCabin(int id){
           return crud.findById(id);
                   }
   public Cabin save(Cabin cabin){
       return crud.save(cabin);
   }
   public void delete(Cabin cabin){
       crud.delete(cabin);
   }
}
