package by.epamtc.rumiantsau.textparser.bean;

import java.util.List;
import java.util.Objects;

public class Sentence implements Component {
    private List<Word> listOfWords;

    public Sentence() {
    }

    public List<Word> getListOfWords() {
        return listOfWords;
    }

    public void setListOfWords(List<Word> listOfWords) {
        this.listOfWords = listOfWords;
    }

    @Override
    public String print() {
        StringBuffer sentence = new StringBuffer();

        //добавить проверку на знак пунктуации и не добавлять пробел перед знаками пунктуации

        for (Word word : listOfWords) {
            sentence.append(word.print()).append(" ");

        }
        return sentence.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return listOfWords.equals(sentence.listOfWords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listOfWords);
    }

    @Override
    public String toString() {
        StringBuffer sentence = new StringBuffer();

        //добавить проверку на знак пунктуации и не добавлять пробел перед знаками пунктуации

        for (Word word : listOfWords) {
            sentence.append(word).append(" ");
        }
        return sentence.toString();
    }


}
