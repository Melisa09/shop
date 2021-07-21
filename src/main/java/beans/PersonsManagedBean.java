
package beans;


import entity.Persons;
import facade.PersonsFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;


@Named(value = "personsManagedBean")
@SessionScoped
public class PersonsManagedBean implements Serializable {

   private Integer personID;
   private String username;
   private String password;
   private String message = "";
   private List<Persons> _personsList;
   
   @Inject
   PersonsFacadeLocal personsFacadeLocal;
   
   @PostConstruct
   private void init(){
       _personsList = personsFacadeLocal.findAll();
   }
   
    public PersonsManagedBean() {
    }

    public Integer getPersonID() {
        return personID;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Persons> getPersonsList() {
        return _personsList;
    }

    public void setPersonsList(List<Persons> _personsList) {
        this._personsList = _personsList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    public String login(){
        Persons person = personsFacadeLocal.findByUsername(username);
        if (person.getUsername() != null && person.getPassword() != null) {
            if (username.equals(person.getUsername()) && password.equals(person.getPassword())) {
          return "admin";
        }else
            {
            message = "Pogrešna kombinacija korisničkog imena :  " +username+" i lozinke : " + password;
            return "login";
            }     
        }
       return null;
    }
    
    public String register(){ 
    Persons persons= new Persons(personID, username, password);
    personsFacadeLocal.create(persons);
    init();
    return "login";
}

}