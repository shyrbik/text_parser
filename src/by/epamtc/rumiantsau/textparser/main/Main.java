package by.epamtc.rumiantsau.textparser.main;
import by.epamtc.rumiantsau.textparser.service.OperationWithText;

public class Main {

    public static void main(String[] args) {
        OperationWithText operation = new OperationWithText();
        //сборка распаршенного текста
        operation.outPutAlltext();
        //Вывести все предложения заданного текста в порядке возрастания  количества слов в каждом из них.
        operation.printSentencesInIncreasingOrderOfWords();
        //В каждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения.
        operation.printSentencesWithSwapFirstLastWord();





    }
}
