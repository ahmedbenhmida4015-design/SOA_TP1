package org.tp;

public class App 
{
    public static boolean run( String xmlPath,String xsdPath )
    {
        System.out.println("=== 1. Validation XML/XSD ===");
        boolean isValid = XMLValidator.validate(xmlPath,xsdPath);
        if (isValid){
            System.out.println("le document est validée\n\n");
        }
        else{
            System.out.println("document n'est pas validée");
            return false;
        }
        System.out.println("=== 2. interrogation du XML avec XPath");

        System.out.println("Recherche des titres de toutes les tâches ayant une priorité 'Haute'");
        XPathEvaluator.evaluateQuery(xmlPath, "//Tache[@priorite='Haute']/Titre/text()");

        System.out.println("Extraction des noms des projets développés en TypeScript");
        XPathEvaluator.evaluateQuery(xmlPath, "//Projet[@lang='TypeScript']/Nom/text()");

        System.out.println("Liste des tâches qui sont actuellement 'En_Cours'");
        XPathEvaluator.evaluateQuery(xmlPath, "//Tache[Etat='En_Cours']/Titre/text()");
        return true;
    }
}
