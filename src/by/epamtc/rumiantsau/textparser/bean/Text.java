package by.epamtc.rumiantsau.textparser.bean;

import java.util.List;
import java.util.Objects;

public class Text implements Component{
    private List<Component> paragraphsAndCodeBlock;
    public Text() {
    }


  /*  public Text(List<Component> paragraphsAndCodeBlock) {
        this.paragraphsAndCodeBlock = paragraphsAndCodeBlock;
    }*/

    public List<Component> getParagraphsAndCodeBlock() {
        return paragraphsAndCodeBlock;
    }

    public void setParagraphsAndCodeBlock(List<Component> paragraphsAndCodeBlock) {
        this.paragraphsAndCodeBlock = paragraphsAndCodeBlock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return paragraphsAndCodeBlock.equals(text.paragraphsAndCodeBlock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paragraphsAndCodeBlock);
    }

    @Override
    public String print() {
        StringBuffer text = new StringBuffer();

        for (Component component : paragraphsAndCodeBlock) {

            text.append(component.print());

        }
        return text.toString();
    }
}
