package com.nmckinnon.vocabulary.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the {@code Word} class.
 * 
 * @author neilmckinnon
 */
public class WordTest 
{
    private static final String NAME = "somename";
    private static final String MEANING = "somemeaning";
    private static final String ETYMOLOGY = "someetymology";
    private static final String PRONUNCIATION = "somepronunciation";
    private static final String EXAMPLE = "someexample";
    
    private Word mWord;
    
    @Before
    public void before()
    {
        mWord = new Word();
        
        mWord.setName(NAME);
        mWord.setMeaning(MEANING);
        mWord.setEtymology(ETYMOLOGY);
        mWord.setPronunciation(PRONUNCIATION);
        mWord.setExample(EXAMPLE);
    }
    
    @Test
    public void testAccessors()
    {
        assertEquals(NAME, mWord.getName());
        assertEquals(MEANING, mWord.getMeaning());
        assertEquals(ETYMOLOGY, mWord.getEtymology());
        assertEquals(PRONUNCIATION, mWord.getPronunciation());
        assertEquals(EXAMPLE, mWord.getExample());
    }
}
