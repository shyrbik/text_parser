package by.epamtc.rumiantsau.textparser.bean;

import java.util.Objects;

public class CodeBlock implements Component {
    private String codeBlock;


    public CodeBlock() {
    }

    @Override
    public String print() {
        return codeBlock;
    }

    public String getCodeBlock() {
        return codeBlock;
    }

    public void setCodeBlock(String codeBlock) {
        this.codeBlock = codeBlock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeBlock codeBlock1 = (CodeBlock) o;
        return Objects.equals(codeBlock, codeBlock1.codeBlock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeBlock);
    }

    @Override
    public String toString() {
        return "CodeBlock{" +
                "codeBlock='" + codeBlock + '\'' +
                '}';
    }


}
