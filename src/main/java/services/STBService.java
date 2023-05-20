package services;
import repositories.stbRepository;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;
import model.STB;

@Service
public class STBService {

    private final stbRepository stbRepository;

    @Autowired
    public STBService(stbRepository stbRepository) {
        this.stbRepository = stbRepository;
    }

    public STB save(STB stb) {
        return stbRepository.save(stb);
    }

    public boolean convertSTBToXMLAndValidate(STB stb, String xmlFilePath, String xsdFilePath) {
        // Convertir STB en XML
  
        convertSTBToXML(stb, xmlFilePath);

        // Valider le fichier XML généré par rapport au schéma XSD
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File xsdFile = new File(xsdFilePath);
            Schema schema = schemaFactory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            Source xmlSource = new StreamSource(new File(xmlFilePath));
            validator.validate(xmlSource);
            return true;
        } catch (Exception e) {
            System.err.println("Le fichier XML n'est pas valide selon le schéma XSD : " + e.getMessage());
            return false;
        }
    }
    public void convertSTBToXML(STB stb, String xmlFilePath) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(STB.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File xmlFile = new File(xmlFilePath);
            marshaller.marshal(stb, xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public boolean existsById(String id) {
        return stbRepository.existsById(id);
    }

    public void deleteSTB(String id) {
    	stbRepository.deleteById(id);
    }


	

}

