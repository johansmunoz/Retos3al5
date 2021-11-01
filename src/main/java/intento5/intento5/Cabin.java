//paquete al que pertenecce
package intento5.intento5;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "cabin") //crea una tabla ne neustra base de datos. En este caso la tabla llamada cabin
/**
 * Clase encargada de contener todos los atributos del objeto
 * Tambien contendra las distinas relaciones entre las tablas correspondientes
 * Y los getter y setter
 */
public class Cabin implements Serializable{
    /**
     * El id y el generated permiten definir la llave principal y que se autogenere
     * automaticamente a medida que se ingresan nuevos datos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //Atributo unico
    private String name; //Atributo nombre
    private String brand; // Atributo marca
    private Integer rooms; // Atributo habitaciones
    private String description; //Atributo descripcion
    
    /**
     * Dependencias encargadas de crear las relaciones entre las diferentes tablas
     */
    @ManyToOne
    @JoinColumn(name ="idCategory")
    @JsonIgnoreProperties("cabins")
    private Category category; //Atributo que relaciona con que tabla se esta relacionando Cabin
    /**
     * Dependencias encargadas de crear las relaciones entre las diferentes tablas
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cabin")
    @JsonIgnoreProperties({"cabin","client"})//client
    private List<Message> messages;//Atributo que relaciona con que tabla se esta relacionando Cabin
    /**
     * Dependencias encargadas de crear las relaciones entre las diferentes tablas
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cabin")
    @JsonIgnoreProperties({"cabins","client"})
    private List<Reservation> reservations;//Atributo que relaciona con que tabla se esta relacionando Cabin
    
    /**
     * Funcion que permite acceder a las reservaciones
     * @return 
     */
    public List<Reservation> getReservations() {
        return reservations;
    }
    
    /**
     * Permite asignar valores al atributo reservation
     * @param  
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
    /**
     * Funcion que permite acceder a los mensajes
     * @return 
     */
    public List<Message> getMessages() {
        return messages;
    }
    /**
     * Permite asignar valores al atributo reservation
     * @param  
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    
    /**
     * Funcion que permite acceder a los id
     * @return 
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Permite asignar valores al atributo id
     * @param  
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Funcion que permite acceder a las marcas
     * @return 
     */
    public String getBrand() {
        return brand;
    }

        /**
     * Permite asignar valores al atributo brand
     * @param  
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Funcion que permite acceder a las habitaciones
     * @return 
     */
    public Integer getRooms() {
        return rooms;
    }
    
        /**
     * Permite asignar valores al atributo rooms
     * @param  
     */
    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }
    
    /**
     * Funcion que permite acceder a las Categorias
     * @return 
     */
    public Category getCategory() {
        return category;
    }
    
        /**
     * Permite asignar valores al atributo category
     * @param  
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * Funcion que permite acceder a los nombres
     * @return 
     */
    public String getName() {
        return name;
    }
    
        /**
     * Permite asignar valores al atributo name
     * @param  
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Funcion que permite acceder a las descripciones
     * @return 
     */
    public String getDescription() {
        return description;
    }
    
        /**
     * Permite asignar valores al atributo description
     * @param  
     */
    public void setDescription(String description) {
        this.description = description;
    }


    
    
}
