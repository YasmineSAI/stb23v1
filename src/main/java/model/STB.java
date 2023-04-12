package model;

import java.io.Serializable;



//import jakarta.xml.bind.annotation.XmlRootElement;


import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlAccessType;



@jakarta.xml.bind.annotation.XmlRootElement(name = "stb")
@jakarta.xml.bind.annotation.XmlAccessorType(XmlAccessType.NONE)

public class STB implements Serializable {
	private static final long serialVersionUID = 1L;
	@XmlAnyAttribute
	private Integer id;
	@XmlAnyElement
	private String title;
	@XmlAnyElement
	private String published;
	
	public STB(Integer id, String title, String published) {
		super();
		this.id = id;
		this.title = title;
		this.published = published;
	}
	public STB() {
		
	}
	@Override
	public String toString() {
		return ("STB (" + id.toString() + ") du " + published + "\n" + title + "\n");
		
	}
}
