package org.tp;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.xpath.*;

public class XPathEvaluator {
    public static void evaluateQuery(String xmlPath, String expression) {
        try {
            Document doc = XMLParser.parse(xmlPath);
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();

            XPathExpression expr = xpath.compile(expression);
            NodeList results = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

            System.out.println("\n[XPath] Résultats pour : " + expression);
            for (int i = 0; i < results.getLength(); i++) {
                System.out.println("  - " + results.item(i).getNodeValue());
            }
        } catch (Exception e) {
            System.out.println("Erreur d'évaluation XPath : " + e.getMessage());
        }
    }
}