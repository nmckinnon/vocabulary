package com.nmckinnon.vocabulary.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import static org.junit.Assert.assertEquals;

import com.nmckinnon.vocabulary.domain.Word;

/**
 * Tests the {@code WordParser} class.
 * 
 * @author neilmckinnon
 */
public class WordParserTest 
{
    private WordParser mWordParser;
    private File mFile;

    @Before
    public void before() throws IOException
    {
        mWordParser = new WordParser();
        
        mFile = new ClassPathResource("static/short-dictionary.xml").getFile();
    }
    
    @Test
    public void testParse() throws XMLStreamException, IOException
    {
        List<Word> words = mWordParser.parse(mFile);
        assertEquals(6, words.size());
    }
}
