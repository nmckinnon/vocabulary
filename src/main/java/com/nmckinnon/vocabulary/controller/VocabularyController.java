
package com.nmckinnon.vocabulary.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.nmckinnon.vocabulary.domain.Word;
import com.nmckinnon.vocabulary.exception.WordLookupException;
import com.nmckinnon.vocabulary.util.WordParser;

/**
 * A REST controller for vocabulary actions.
 * 
 * @author neilmckinnon
 *
 */
@RestController
public class VocabularyController
{

    @PostMapping(path = "/vocabulary/v1", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> create(@RequestHeader HttpHeaders aHeaders)
    {
        ResponseEntity<Object> lResponse = null;
        
       
        
        return lResponse;
    }// end create
	
    /**
     * Return a random word from the available dictionary of words.
     * 
     * @return ResponseEntity<Object> The found random word
     */
    @GetMapping(value = "/vocabulary/v1/random", produces = "application/json")
    public ResponseEntity<Object> get() throws WordLookupException
    {
        ResponseEntity<Object> lResponse = null;

        try 
        {
            List<String> randomWords = new ArrayList<>();
            randomWords.add("Spectre");
            randomWords.add("Altruism");
            randomWords.add("Veracity");
            randomWords.add("Trick");
            randomWords.add("Gravitas");
            
            Collections.shuffle(randomWords);
            
            // grab the dictionary of words we'll use; opted not to use a DB here since I don't 
            // expect them to change that often
            File file = new ClassPathResource("static/dictionary.xml").getFile();
            
            // TODO: load at start
            List<Word> words = new WordParser().parse(file);
            
            
            Collections.shuffle(words);
            
            Word randomWord = words.iterator().next();
            
            //System.out.println("file exists is: "+file.exists());
            
            
            //String randomWord = randomWords.iterator().next();

            //Word word = new Word(randomWord, "meaning", "pronunciation", "etymology");
            
            lResponse = new ResponseEntity<Object>(randomWord, HttpStatus.OK);
        } 
        catch (IOException ioe) 
        {
            throw new WordLookupException();
        } 
        catch (XMLStreamException e) 
        {
            throw new WordLookupException();
        }
        
        return lResponse;
    }// end get
}
