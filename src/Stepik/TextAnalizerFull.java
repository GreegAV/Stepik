package Stepik;

public class TextAnalizerFull {
    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        Label currentLabel = Label.OK;
        for (TextAnalyzer analyzer : analyzers) {
            currentLabel = analyzer.processText(text);
            if ( !currentLabel.equals(Label.OK) ) {
                break;
            }
        }
        return currentLabel;
    }

    public abstract class KeywordAnalyzer implements TextAnalyzer {
        protected abstract Label getLabel();

        protected abstract String[] getKeywords();

        @Override
        public Label processText(String text) {
            for (String keyword : getKeywords()) {
                if ( text.toLowerCase().contains(keyword.toLowerCase()) ) return getLabel();
            }
            return Label.OK;
        }
    }

    public class SpamAnalyzer extends KeywordAnalyzer {
        private String[] keywords;

        public SpamAnalyzer(String[] keywords) {
            this.keywords = keywords;
        }

        @Override
        protected Label getLabel() {
            return Label.SPAM;
        }

        @Override
        protected String[] getKeywords() {
            return keywords;
        }
    }

    public class NegativeTextAnalyzer extends KeywordAnalyzer {

        @Override
        protected Label getLabel() {
            return Label.NEGATIVE_TEXT;
        }

        @Override
        protected String[] getKeywords() {
            return new String[]{":(", "=(", ":|"};
        }

    }

    public interface TextAnalyzer {
        Label processText(String text);
    }

    public enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }

    public class TooLongTextAnalyzer implements TextAnalyzer {

        private int maxLength;

        public TooLongTextAnalyzer(int maxLength) {
            this.maxLength = maxLength;
        }

        @Override
        public Label processText(String text) {
            return text.length() > maxLength ? Label.TOO_LONG : Label.OK;
        }
    }

}