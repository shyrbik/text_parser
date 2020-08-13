package by.epamtc.rumiantsau.textparser.bean;

import java.util.Objects;

public class Word implements Component{
    //слово или знак препинания
    private String wordOrPunct;


    public Word() {
    }

    public String getWordOrPunct() {
        return wordOrPunct;
    }

    public void setWordOrPunct(String wordOrPunct) {
        this.wordOrPunct = wordOrPunct;
    }

    @Override
    public String print() {
        return wordOrPunct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(wordOrPunct, word.wordOrPunct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordOrPunct);
    }

    @Override
    public String toString() {
        return wordOrPunct;
    }


}
