package model;

/*import java.io.Serializable;



//import jakarta.xml.bind.annotation.XmlRootElement;


import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlAccessType;



@jakarta.xml.bind.annotation.XmlRootElement(name = "stb")
@jakarta.xml.bind.annotation.XmlAccessorType(XmlAccessType.NONE)

public class stb implements Serializable {
	private static final long serialVersionUID = 1L;
	@XmlAnyAttribute
	private Integer id;
	@XmlAnyElement
	private String title;
	@XmlAnyElement
	private String published;
	
	public stb(Integer id, String title, String published) {
		super();
		this.id = id;
		this.title = title;
		this.published = published;
	}
	public stb() {
		
	}
	@Override
	public String toString() {
		return ("STB (" + id.toString() + ") du " + published + "\n" + title + "\n");
		
	}
}*/

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@XmlRootElement(name = "stb")
@Document(collection = "stb")
public class STB {

    @Id
    private String id;

    @Indexed(unique = true)
    @Field(value = "titre")
    private String titre;

    @Field(value = "description")
    private String description;

    @Field(value = "date_validation")
    private Date date_validation;

    @Field(value = "nom_entite_client")
    private String nom_entite_client;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date_validation;
    }

    public void setDate(Date date) {
        this.date_validation = date;
    }
    
    public String getNomEntite() {
        return nom_entite_client;
    }

    public void setNomEntite(String nomEntite) {
        this.nom_entite_client = nomEntite;
    }

    @Override
    public String toString() {
        return "id: " + this.id + ", titre: " + titre + ", description: " + this.description + ", date_validation: " + this.date_validation
        		+ ", nom_entite_client: " + this.nom_entite_client;
    }
}
