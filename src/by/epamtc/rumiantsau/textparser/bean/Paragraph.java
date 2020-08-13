package by.epamtc.rumiantsau.textparser.bean;

import java.util.List;
import java.util.Objects;

public class Paragraph implements Component {
    private List<Sentence> listOfSentences;


    public Paragraph(List<Sentence> listOfSentences) {
        this.listOfSentences = listOfSentences;
    }

    public void setListOfSentences(List<Sentence> listOfSentences) {
        this.listOfSentences = listOfSentences;
    }
    public List<Sentence> getListOfSentences() {
        return listOfSentences;
    }

    @Override
    public String print() {
        StringBuffer paragraph = new StringBuffer();

        for (Sentence sentence : listOfSentences) {
            paragraph.append(sentence).append(" ");
        }

        return paragraph.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paragraph paragraph = (Paragraph) o;
        return listOfSentences.equals(paragraph.listOfSentences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listOfSentences);
    }

    @Override
    public String toString() {
        StringBuffer paragraph = new StringBuffer();

        for (Sentence sentence : listOfSentences) {
            paragraph.append(sentence.print()).append(" ");
        }

        return paragraph.toString();
    }


}
