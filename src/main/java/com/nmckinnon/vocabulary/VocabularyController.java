
package com.nmckinnon.vocabulary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VocabularyController
{

    @PostMapping(path = "/vocabulary/v1", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> create(@RequestHeader HttpHeaders aHeaders)
    {
        ResponseEntity<Object> lResponse = null;
        
       
        
        return lResponse;
    }// end create
	
    @GetMapping(value = "/vocabulary/v1/random", produces = "application/json")
    public ResponseEntity<Object> get(@RequestHeader HttpHeaders aHeaders)
    {
        ResponseEntity<Object> lResponse = null;
        
        List<String> randomWords = new ArrayList<>();
        randomWords.add("Spectre");
        randomWords.add("Altruism");
        randomWords.add("Veracity");
        randomWords.add("Trick");
        randomWords.add("Gravitas");
        
        Collections.shuffle(randomWords);
        
        String randomWord = randomWords.iterator().next();
        
        Word word = new Word();
        word.word = randomWord;
        word.meaning = "made it up";
        
        lResponse = new ResponseEntity<Object>(word, HttpStatus.OK);
        
        return lResponse;
    }// end get

    class Word 
    {
        private String word;
        public String getWord() {
            return word;
        }
        public void setWord(String word) {
            this.word = word;
        }
        public String getMeaning() {
            return meaning;
        }
        public void setMeaning(String meaning) {
            this.meaning = meaning;
        }
        private String meaning;
    }
}
