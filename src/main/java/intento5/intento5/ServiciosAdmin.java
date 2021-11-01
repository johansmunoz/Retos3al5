
package intento5.intento5;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosAdmin {
    
    @Autowired
    private RepositorioAdmin metodosCrud;
    
    public List<Admin>getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Admin> getAdmin(int IdAdmin){
        return metodosCrud.getAdmin(IdAdmin);
    }
    
        public Admin save(Admin admin) {
        if (admin.getIdAdmin() == null) {
            return metodosCrud.save(admin);
        } else {
            Optional<Admin> e = metodosCrud.getAdmin(admin.getIdAdmin());
            if (e.isEmpty()) {
                return metodosCrud.save(admin);
            } else {
                return admin;
            }
        }
    }

    public Admin update(Admin admin) {
        if (admin.getIdAdmin() != null) {
            Optional<Admin> e = metodosCrud.getAdmin(admin.getIdAdmin());
            if (!e.isEmpty()) {
                if (admin.getCorreo() != null) {
                    e.get().setCorreo(admin.getCorreo());
                }
                if (admin.getNombre() != null) {
                    e.get().setNombre(admin.getNombre());
                }
                
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return admin;
            }
        }else{
            return admin;
        }
    }
        public boolean deleteAdmin(int IdAdmin) {
        Boolean aBoolean = getAdmin(IdAdmin).map(admin -> {
            metodosCrud.delete(admin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}

