package com.javarush.task.task33.task3309;

import org.w3c.dom.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

/*
Комментарий внутри xml

--add-modules java.xml.bind

*/
public class Solution {

    public static void main(String[] args) throws JAXBException, ParserConfigurationException, TransformerException {
        System.out.println(toXmlWithComment(new First(), "second", "it's a comment"));
    }

    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, ParserConfigurationException, TransformerException {
        StringWriter stringWriterResult = new StringWriter();

        StringWriter checkWriter = new StringWriter();

        Document document = getDocument();

        JAXBContext context = JAXBContext.newInstance(obj.getClass());

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(obj, document);
        marshaller.marshal(obj, checkWriter);

        replaceCDATAElements(document, document);

        insertComments(tagName, comment, document);

        transformXML(stringWriterResult, document);

        return stringWriterResult.toString();
    }

    private static Document getDocument() throws ParserConfigurationException {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    }

    public static void replaceCDATAElements(Node node, Document document) {
        NodeList nodeList = node.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);

            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                replaceCDATAElements(currentNode, document);
            }

            if (currentNode.getNodeType() == Node.TEXT_NODE) {
                if (currentNode.getTextContent().contains("\"")
                    || currentNode.getTextContent().contains("<")
                    || currentNode.getTextContent().contains(">")
                    || currentNode.getTextContent().contains("&")
                    || currentNode.getTextContent().contains("'")) {

                    String text = node.getTextContent();

                    CDATASection cdataSection = document.createCDATASection(text);

                    currentNode.getParentNode().replaceChild(cdataSection, currentNode);
                }
            }
        }
    }

    private static void insertComments(String tagName, String comment, Document document) {
        NodeList listOfTags = document.getElementsByTagName(tagName);

        for (int i = 0; i < listOfTags.getLength(); i++) {
            if (listOfTags.item(i).getNodeType() != Node.CDATA_SECTION_NODE) {
                Comment newComment = document.createComment(comment);

                listOfTags.item(i).getParentNode().insertBefore(newComment, listOfTags.item(i));
            }
        }
    }

    private static void transformXML(StringWriter stringWriterResult, Document document) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        DOMSource domSource = new DOMSource(document);

        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "no");

        StreamResult streamResult = new StreamResult(stringWriterResult);
        transformer.transform(domSource, streamResult);
    }
}
