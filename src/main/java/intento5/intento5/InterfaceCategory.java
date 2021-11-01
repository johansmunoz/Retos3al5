
package intento5.intento5;

import org.springframework.data.repository.CrudRepository;

public interface InterfaceCategory extends CrudRepository<Category, Integer> {//se dejo tipo de llave como string verificar si es integer
    
}