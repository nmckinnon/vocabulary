package com.nmckinnon.vocabulary.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import org.springframework.util.StringUtils;

import com.nmckinnon.vocabulary.domain.Word;

/**
 * An XML parser for a dictionary of words in XML form.
 * 
 * @author neilmckinnon
 */
public class WordParser 
{

    public List<Word> parse(InputStream in) throws XMLStreamException, IOException
    {
        List<Word> words = null;
        
        XMLInputFactory factory = XMLInputFactory.newInstance();
        
        XMLEventReader eventReader = factory.createXMLEventReader(in);
        
        // TODO: stick in a Map; easy to get random and always same time
        words = new ArrayList<>();
        
        String currentElementName = null;
        Word word = null;
        
        while(eventReader.hasNext()) 
        {
            XMLEvent e = eventReader.nextEvent();
            //System.out.println("ID:"+e.hashCode()+"["+e+"]");
            
            
            switch(e.getEventType())
            {
                case XMLStreamConstants.START_ELEMENT: 
                {
                    String localName = e.asStartElement().getName().getLocalPart();
                    
                    localName = localName.trim();
                    
                    // System.out.println("localName is: "+localName);
                    
                    currentElementName = localName;
                    
                    if("word".equals(localName))
                    {
                        // create a new Word
                        word = new Word();
                        // System.out.println("WORDY is: "+word);
                    }

                    break;
                }
                case XMLStreamConstants.CHARACTERS:
                {
                    String text = e.asCharacters().asCharacters().toString();
                    
                    text = text.trim();
                    
                    if(null != text && !StringUtils.isEmpty(text))
                    {
                        //System.out.println("currentElementName: "+currentElementName);
                        //System.out.println("text: "+text);
                        
                        if("name".equals(currentElementName))
                        {
                            word.setName(text);
                            // System.out.println("WORD: "+word);
                        }
                        else if("meaning".equals(currentElementName))
                        {
                            word.setMeaning(text);
                        }
                        else if("example".equals(currentElementName))
                        {
                            word.setExample(text);
                        }
                        else if("etymology".equals(currentElementName))
                        {
                            // word.setName("some name");
                            word.setEtymology(text);
                        }      
                        else if("pronunciation".equals(currentElementName))
                        {
                            // word.setName(e);
                            word.setPronunciation(text);
                        }
                    }
                         
                    
                    // System.out.println("e.asCharacters().getData() CHARS is: "+e.asCharacters().getData());
                    
                    /*int start = xmlr.getTextStart(); 
                    int length = xmlr.getTextLength(); 
                    System.out.print(new String(xmlr.getTextCharacters(), 
                                                start, 
                                                length)); */
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: 
                {
                    if("word".equals(e.asEndElement().getName().getLocalPart()))
                    {
                        // create a new Word
                        words.add(word);
                    }
                    break;
                }
                default: 
                {
                    break;
                }
            }
        }// end while
        
        return words;
    }
    
    
    public List<Word> parse(File file) throws XMLStreamException, IOException
    {
        List<Word> words = null;
        
        XMLInputFactory factory = XMLInputFactory.newInstance();
        
        XMLEventReader eventReader = factory.createXMLEventReader(new FileInputStream(file));
        
        // TODO: stick in a Map; easy to get random and always same time
        words = new ArrayList<>();
        
        String currentElementName = null;
        Word word = null;
        
        while(eventReader.hasNext()) 
        {
            XMLEvent e = eventReader.nextEvent();
            //System.out.println("ID:"+e.hashCode()+"["+e+"]");
            
            
            switch(e.getEventType())
            {
                case XMLStreamConstants.START_ELEMENT: 
                {
                    String localName = e.asStartElement().getName().getLocalPart();
                    
                    localName = localName.trim();
                    
                    // System.out.println("localName is: "+localName);
                    
                    currentElementName = localName;
                    
                    if("word".equals(localName))
                    {
                        // create a new Word
                        word = new Word();
                        // System.out.println("WORDY is: "+word);
                    }

                    break;
                }
                case XMLStreamConstants.CHARACTERS:
                {
                    String text = e.asCharacters().asCharacters().toString();
                    
                    text = text.trim();
                    
                    if(null != text && !StringUtils.isEmpty(text))
                    {
                        //System.out.println("currentElementName: "+currentElementName);
                        //System.out.println("text: "+text);
                        
                        if("name".equals(currentElementName))
                        {
                            word.setName(text);
                            // System.out.println("WORD: "+word);
                        }
                        else if("meaning".equals(currentElementName))
                        {
                            word.setMeaning(text);
                        }
                        else if("example".equals(currentElementName))
                        {
                            word.setExample(text);
                        }
                        else if("etymology".equals(currentElementName))
                        {
                            // word.setName("some name");
                            word.setEtymology(text);
                        }      
                        else if("pronunciation".equals(currentElementName))
                        {
                            // word.setName(e);
                            word.setPronunciation(text);
                        }
                    }
                         
                    
                    // System.out.println("e.asCharacters().getData() CHARS is: "+e.asCharacters().getData());
                    
                    /*int start = xmlr.getTextStart(); 
                    int length = xmlr.getTextLength(); 
                    System.out.print(new String(xmlr.getTextCharacters(), 
                                                start, 
                                                length)); */
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: 
                {
                    if("word".equals(e.asEndElement().getName().getLocalPart()))
                    {
                        // create a new Word
                        words.add(word);
                    }
                    break;
                }
                default: 
                {
                    break;
                }
            }
        }// end while
        
        return words;
    }
}
