
package intento5.intento5;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jo-ha
 */
@Service
public class ServiciosCabin {
    
    @Autowired
    private RepositorioCabin metodosCrud;
    
    public List<Cabin> getAll(){
        return metodosCrud.getAll();
    }
    public Optional<Cabin> getCabin(int idCabin){
        return metodosCrud.getCabin(idCabin);
    }
    public Cabin save(Cabin cabin){
        if(cabin.getId()==null){
            return metodosCrud.save(cabin);
        }
        else{
            Optional<Cabin> evt=metodosCrud.getCabin(cabin.getId());
            if(evt.isEmpty()){
                return metodosCrud.save(cabin);   
            }
            else{
                return cabin;
            }            
        }
        
    }
public Cabin update(Cabin cabin){
        if(cabin.getId()!=null){
            Optional<Cabin> e=metodosCrud.getCabin(cabin.getId());
            if(!e.isEmpty()){
                if(cabin.getName()!=null){
                    e.get().setName(cabin.getName());
                }
                if(cabin.getBrand()!=null){
                    e.get().setBrand(cabin.getBrand());
                }
                if(cabin.getRooms()!=null){
                    e.get().setRooms(cabin.getRooms());
                }
                if(cabin.getDescription()!=null){
                    e.get().setDescription(cabin.getDescription());
                }
                if(cabin.getCategory()!=null){
                    e.get().setCategory(cabin.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return cabin;
            }
        }else{
            return cabin;
        }
    }


    public boolean deleteCabin(int id) {
        Boolean aBoolean = getCabin(id).map(cabin -> {
            metodosCrud.delete(cabin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
