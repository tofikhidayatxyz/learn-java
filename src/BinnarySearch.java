import models.Word;

import java.util.ArrayList;

public class BinnarySearch {
    public ArrayList<Word> words = new ArrayList<>();

    public void addSeed(Word word) {
        this.words.add(word);
    }

    public Word searchFromEnglish(Integer first, Integer last, String key) {

        if(last >= first) {
            Integer mid =  first + (last - first)/2;

            if(this.words.get(mid).english.equalsIgnoreCase(key)) {
                return this.words.get(mid);
            }

            if(this.words.get(mid).english.length() > key.length()) {
                return searchFromEnglish(first, mid - 1, key);
            } else {
                return searchFromEnglish(mid+1, last, key);
            }
        }

        return null;
    }

    public Word searchFromIndonesia(Integer first, Integer last, String key) {

        if(last >= first) {
            Integer mid =  first + (last - first)/2;

            if(this.words.get(mid).indonesia.equalsIgnoreCase(key)) {
                return this.words.get(mid);
            }

            if(this.words.get(mid).indonesia.length() > key.length()) {
                return searchFromEnglish(first, mid - 1, key);
            } else {
                return searchFromEnglish(mid+1, last, key);
            }
        }

        return null;
    }
}
