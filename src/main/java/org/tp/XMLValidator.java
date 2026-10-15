package org.tp;

import java.io.IOException;
import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class XMLValidator {

    public static boolean validate(String xmlPath,String xsdPath){
        try{
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new DOMSource(XMLParser.parse(xmlPath)));
            return true;
        }catch(IOException e){
            System.out.println("errur de document" + e.getMessage());
            return false;
        }catch (SAXException e){
            System.out.println("erreur de validation " + e.getMessage());
            return false;
        }
        catch(Exception e){
            System.out.println("erreur inconnue");
            return false;
        }
    }
}
