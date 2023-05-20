package model;

public class STBSummary {
    private String id;
    private String titre;
    private String description;
    private String Date;
    private String nom_entite;
    
    public STBSummary(String id, String titre, String description, String Date, String nom_entite) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.Date = Date;
        this.nom_entite = nom_entite;
    }
    
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
    
    public String getDate() {
        return Date;
    }
    
    public void setDate(String date) {
        this.Date = date;
    }
    
    public String getNomEntite() {
        return nom_entite;
    }
    
    public void setNomEntite(String nomEntite) {
        this.nom_entite = nomEntite;
    }
}
