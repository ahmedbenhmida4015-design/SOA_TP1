package org.tp;

import junit.framework.TestCase;

public class AppTest extends TestCase {

    public void testValidDocument() {
        boolean result = App.run("src/main/resources/devplatform.xml", "src/main/resources/devplatform.xsd");
        assertTrue("Le document valide devrait retourner true", result);
    }

    public void testInvalidDocument() {
        boolean result = App.run("src/main/resources/invalid-devplatform.xml", "src/main/resources/devplatform.xsd");
        assertFalse("Le document invalide devrait retourner false", result);
    }
}