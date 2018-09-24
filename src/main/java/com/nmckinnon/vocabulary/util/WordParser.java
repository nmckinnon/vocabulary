package com.nmckinnon.vocabulary.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import org.springframework.core.io.ClassPathResource;

import com.nmckinnon.vocabulary.domain.Word;

/**
 * An XML parser for a dictionary of words in XML form.
 * 
 * @author neilmckinnon
 */
public class WordParser 
{

    public void parse(File file) throws XMLStreamException, IOException
    {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        
        XMLEventReader eventReader = factory.createXMLEventReader(new ClassPathResource("static/dictionary.xml").getInputStream());
        
        // TODO: stick in a Map; easy to get random and always same time
        List<Word> words = new ArrayList<>();
        
        while(eventReader.hasNext()) 
        {
            XMLEvent e = eventReader.nextEvent();
            System.out.println("ID:"+e.hashCode()+"["+e+"]");
            
            Word word = null;
            
            switch(e.getEventType())
            {
                case XMLStreamConstants.START_ELEMENT: {
                    if("word".equals(e.asStartElement().getName().getLocalPart()))
                    {
                        System.out.println("We got a word ....");
                        // create a new Word
                        word = new Word();
                    }
                    else if("name".equals(e.asStartElement().getName().getLocalPart()))
                    {
                        // word.setName(e);
                    }
                    break;
                }
                case XMLStreamConstants.CHARACTERS: 
                    System.out.println("e.asCharacters().asCharacters(): "+e.asCharacters().asCharacters());
                    
                    System.out.println("e.asCharacters().getData() CHARS is: "+e.asCharacters().getData());
                    
                    /*int start = xmlr.getTextStart(); 
                    int length = xmlr.getTextLength(); 
                    System.out.print(new String(xmlr.getTextCharacters(), 
                                                start, 
                                                length)); */
                    break; 
                case XMLStreamConstants.CDATA: 
                    System.out.println("<![CDATA[");
                    System.out.println("e.asCharacters().getData() is: "+e.asCharacters().getData());
                    
                    /*start = e.getTextStart(); 
                    length = xmlr.getTextLength(); 
                    System.out.print(new String(xmlr.getTextCharacters(), 
                                                start, 
                                                length)); 
                    System.out.print("]]>"); */
                    break; 
                case XMLStreamConstants.END_ELEMENT: {
                    if("word".equals(e.asEndElement().getName().getLocalPart()))
                    {
                        System.out.println("We got a word ....");
                        // create a new Word
                        words.add(word);
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }
    
    /*private static void printUsage() {
        System.out.println("usage: java examples.event.Parse <xmlfile>");
    }

    public static void main(String[] args) throws Exception {
        try {
            filename = args[0];
        } catch (ArrayIndexOutOfBoundsException aioobe){
            printUsage();
            System.exit(0);
        }

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader r =
                factory.createXMLEventReader(new FileReader(filename));
        while(r.hasNext()) 
        {
            XMLEvent e = r.nextEvent();
            System.out.println("ID:"+e.hashCode()+"["+e+"]");
        }
    }*/
}
