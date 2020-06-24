package org.hobgoblin.acessos;


import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Acesso {
	private String pusherAppId;
    private String pusherKey;
    private String pusherSecret;

    public Acesso() {
        this.parser();
    }
    public void parser() {

    	InputStream stream = getClass().getResourceAsStream("/acessos.xml");
    	
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        try {
            db = dbf.newDocumentBuilder();
            Document d = db.parse(stream);
            d.getDocumentElement().normalize();

            NodeList nList = d.getElementsByTagName("pusher");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    this.setPusherAppId(eElement.getElementsByTagName("appId").item(0).getTextContent());
                    this.setPusherKey(eElement.getElementsByTagName("key").item(0).getTextContent());
                    this.setPusherSecret(eElement.getElementsByTagName("secret").item(0).getTextContent());

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getPusherAppId() {
        return pusherAppId;
    }

    public void setPusherAppId(String pusherAppId) {
        this.pusherAppId = pusherAppId;
    }

    public String getPusherKey() {
        return pusherKey;
    }

    public void setPusherKey(String pusherKey) {
        this.pusherKey = pusherKey;
    }

    public String getPusherSecret() {
        return pusherSecret;
    }

    public void setPusherSecret(String pusherSecret) {
        this.pusherSecret = pusherSecret;
    }
}
