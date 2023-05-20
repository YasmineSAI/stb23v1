package ErrorHandler;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
public class ErrorXmlResponse {
    private String id;
    private String status;

    public ErrorXmlResponse() {
    }

    public ErrorXmlResponse(String id2, String status) {
        this.id = id2;
        this.status = status;
    }

    @XmlElement
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
