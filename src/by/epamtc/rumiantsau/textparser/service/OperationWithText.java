package by.epamtc.rumiantsau.textparser.service;

import by.epamtc.rumiantsau.textparser.bean.*;
import by.epamtc.rumiantsau.textparser.dao.impl.FileReader;
import by.epamtc.rumiantsau.textparser.dao.parser.ParserParagraphCodeBlock;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class OperationWithText {
   private String text = new FileReader().readText();
   private Text textAfterParsing = ParserParagraphCodeBlock.parseText(text);
   private List<Component> paragraphsAndCodeBlock = textAfterParsing.getParagraphsAndCodeBlock();
   private List<Sentence> listSentences = new LinkedList<>();
   private Paragraph parag;

    public OperationWithText() {
    }

    public void outPutAlltext(){
        System.out.println(textAfterParsing.print());
    }

    public void printSentencesInIncreasingOrderOfWords (){
        //  Вывести все предложения заданного текста в порядке возрастания  количества слов в каждом из них.
        //размеры всех предложений будут хранится тут
        Set<Integer> setOfSizeSentences = new TreeSet<>();
        //выбираем только абзацы без блоков кода, формируес единый список предложений
        for (Component component : paragraphsAndCodeBlock) {
            //выбираем все абзацы
            if(!component.getClass().equals(CodeBlock.class)){
                parag = (Paragraph) component;
                //формируем список из предложений и массив из их длинны
                for (Sentence sentence : parag.getListOfSentences()) {
                    if (sentence.getListOfWords().size()>1) {
                        listSentences.add(sentence);
                        setOfSizeSentences.add(sentence.getListOfWords().size());
                    }
                }

            }
        }

        for (Integer size : setOfSizeSentences) {
            for (Sentence sentence : listSentences) {
                if(sentence.getListOfWords().size() == size){
                    System.out.println(sentence.print());
                }
            }

        }
    }

    public void printSentencesWithSwapFirstLastWord(){
        //В каждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения.
        List<Sentence> listStringSwapFirstLastWord = new LinkedList<>();
        Word swapStringLast;
        Word swapStringFirst;

        for (Component component : paragraphsAndCodeBlock) {
            //выбираем все абзацы
            if(!component.getClass().equals(CodeBlock.class)){
                parag = (Paragraph) component;
                //формируем список из предложений и массив из их длинны
                for (Sentence sentence : parag.getListOfSentences()) {

                    if (sentence.getListOfWords().size()>1) {
                        //сохраняем последнее слово предложения
                        swapStringLast = sentence.getListOfWords().get((sentence.getListOfWords().size()-2));
                        swapStringFirst = sentence.getListOfWords().get(0);
                        sentence.getListOfWords().set(sentence.getListOfWords().size()-2, swapStringFirst);
                        sentence.getListOfWords().set(0, swapStringLast);
                        listSentences.add(sentence);
                    }
                }

            }
        }
        for (Sentence sentence : listSentences) {
            System.out.println(sentence);
        }

    }





}
