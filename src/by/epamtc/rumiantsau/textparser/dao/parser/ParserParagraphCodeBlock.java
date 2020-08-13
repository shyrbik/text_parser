package by.epamtc.rumiantsau.textparser.dao.parser;

import by.epamtc.rumiantsau.textparser.bean.CodeBlock;
import by.epamtc.rumiantsau.textparser.bean.Component;
import by.epamtc.rumiantsau.textparser.bean.Paragraph;
import by.epamtc.rumiantsau.textparser.bean.Text;
import by.epamtc.rumiantsau.textparser.dao.impl.Configuration;
import by.epamtc.rumiantsau.textparser.dao.impl.FileReader;

import java.util.LinkedList;
import java.util.List;


public final class ParserParagraphCodeBlock {

    private ParserParagraphCodeBlock() {
    }

    public static Text parseText(String text){
        List<Component> paragraphsAndCodeBlock = new LinkedList<>();
        //разбиваем текст на абзацы
        //String[] arrayOfParagraphs = text.split("\\n");
        String[] arrayOfParagraphs = text.split(Configuration.getInstance().getProperty(Configuration.regexParagraph));
        int bracketCount;
        for (int i = 0; i < arrayOfParagraphs.length; i++) {

            if(arrayOfParagraphs[i].contains("{")){
                //формируем блок кода
                //переменная для формирования кода блока
                StringBuffer codeBlock = new StringBuffer();
                bracketCount = 1;
                while(bracketCount > 0){
                    i++;
                    if(arrayOfParagraphs[i].contains("}")){
                        bracketCount--;
                    }
                    if(arrayOfParagraphs[i].contains("{")){
                        bracketCount++;
                    }
                    codeBlock.append(arrayOfParagraphs[i]);
                    codeBlock.append("\n");
                }
                CodeBlock newCodeBlock = new CodeBlock();
                newCodeBlock.setCodeBlock(codeBlock.toString());
               // CodeBlock newCodeBlock = new CodeBlock(codeBlock.toString());
                paragraphsAndCodeBlock.add(newCodeBlock);
            }

            else{

            paragraphsAndCodeBlock.add(ParserSentences.parseSentence(arrayOfParagraphs[i]));
            }

        }
        Text newText = new Text();
        newText.setParagraphsAndCodeBlock(paragraphsAndCodeBlock);

        return newText;
      //  return new Text().setParagraphsAndCodeBlock(paragraphsAndCodeBlock);

    }



}
