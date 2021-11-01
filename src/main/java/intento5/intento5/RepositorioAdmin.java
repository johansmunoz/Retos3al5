
package intento5.intento5;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioAdmin {
    @Autowired
    private InterfaceAdmin crud6;
    
    public List<Admin>getAll(){
        return (List<Admin>) crud6.findAll();
    }
    
    public Optional<Admin>getAdmin(int id){
        return crud6.findById(id);
    }
    public Admin save(Admin admin){
        return crud6.save(admin);
    }
    public void delete(Admin admin) {
        crud6.delete(admin);
        
    }
}
