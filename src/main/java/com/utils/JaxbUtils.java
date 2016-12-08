package com.utils;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class JaxbUtils {

    public static String objectToXml(Object object, Class className) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(className);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        final StringWriter stringWriter = new StringWriter();
        jaxbMarshaller.marshal(object, stringWriter);
        return stringWriter.toString();
    }

    public static Object xmlToObject(String xml, Class className) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(className);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return unmarshaller.unmarshal(new StringReader(xml));
    }
}
