package org.tp;

public class Main {
    private static final String xmlPath = "src/main/resources/devplatform.xml";
    private static final String xsdPath = "src/main/resources/devplatform.xsd";
    public static void main(String[] args){
        App.run(xmlPath,xsdPath);
    }
}
