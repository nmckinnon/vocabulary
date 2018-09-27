package com.nmckinnon.vocabulary.domain;

/**
 * Domain object representing a word.
 *
 * @author nmckinnon
 */
public class Word 
{
	private String mName;
	private String mMeaning;
	private String mPronunciation;
	private String mEtymology;
	private String mExample;

	/**
	 * Creates a new instance of a {@code Word} object.
	 */
	public Word()
	{
	}
	
	/**
	 * Creates a new instance of a {@code Word} object.
	 *
	 * @param name
	 * @param meaning
	 * @param pronunciation
	 * @param etymology
	 */
	public Word(String name, String meaning, String pronunciation, String etymology)
	{
		this.setName(name);
		this.setMeaning(meaning);
		this.setPronunciation(pronunciation);
		this.setEtymology(etymology);
	}

	/**
	 * Returns the name for this word.
	 * 
	 * @return String The word name
	 */
	public String getName()
	{
		return this.mName;
	}

	/**
	 * Sets the name for this word.
	 * 
	 * @param name The word name
	 */
	public void setName(String name)
	{
		this.mName = name;
	}

	public String getMeaning()
	{
		return this.mMeaning;
	}

	public void setMeaning(String meaning)
	{
		this.mMeaning = meaning;
	}

	public String getPronunciation()
	{
		return this.mPronunciation;
	}

	public void setPronunciation(String pronunciation)
	{
		this.mPronunciation = pronunciation;
	}

	public String getExample()
	{
		return this.mExample;
	}

	public void setExample(String example)
	{
		this.mExample = example;
	}
	
	public String getEtymology() 
	{
		return this.mEtymology;
	}

	public void setEtymology(String etymology) 
	{
		this.mEtymology = etymology;
	}
	
	@Override
	public String toString()
	{
	    return "Word.Name: "+this.mName;
	}
	
}