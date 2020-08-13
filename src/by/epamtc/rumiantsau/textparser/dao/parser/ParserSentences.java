package by.epamtc.rumiantsau.textparser.dao.parser;

import by.epamtc.rumiantsau.textparser.bean.Paragraph;
import by.epamtc.rumiantsau.textparser.bean.Sentence;
import by.epamtc.rumiantsau.textparser.bean.Word;
import by.epamtc.rumiantsau.textparser.dao.impl.Configuration;
import java.util.LinkedList;
import java.util.List;

public final class ParserSentences {
    //public static String regexSentence = "(?<=[.!?:])\\s";
    //public static String regexWord = "\\b";
    public static String regexSentence = Configuration.getInstance().getProperty(Configuration.regexSentence);
    public static String regexWord = Configuration.getInstance().getProperty(Configuration.regexWord);

    public static Paragraph parseSentence(String paragraph){
        List<Sentence> listOfSentences = new LinkedList<>();
        //String лист из предложений
        String[] arrayOfLines = paragraph.split(regexSentence);
        for (String arrayOfLine : arrayOfLines) {

            List<Word> listOfWord = new LinkedList<>();
            String[] arrayOfWords = arrayOfLine.split(regexWord);

            for (String arrayOfWord : arrayOfWords) {

                if(!arrayOfWord.equals(" ")){
                Word newWord = new Word();
                newWord.setWordOrPunct(arrayOfWord);
                listOfWord.add(newWord);
                }

            }
            Sentence newSentence = new Sentence();
            newSentence.setListOfWords(listOfWord);
            //Sentence newSentence = new Sentence(listOfWord);
            listOfSentences.add(newSentence);

        }

        return new Paragraph(listOfSentences);
    }


}
