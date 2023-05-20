package dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.STB;

@XmlRootElement(name = "stb")
public class STBXmlResponse {
    private STB stb;

    public STBXmlResponse() {
    }

    public STBXmlResponse(STB stb) {
        this.stb = stb;
    }
    
    @XmlElement(name = "specification")
    public STB getStb() {
        return stb;
    }

    public void setStb(STB stb) {
        this.stb = stb;
    }
  
}

