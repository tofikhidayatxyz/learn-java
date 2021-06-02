import models.Word;


public class Main {


    static void printWord(Word word, String keyWord) {
        System.out.println("Kata '" + keyWord + "' Di temukan");
        System.out.println("English : " + word.english);
        System.out.println("Indonesia : " + word.indonesia);
    }

    public static void main(String[] args) {

        BinnarySearch search = new BinnarySearch();

        search.addSeed(new Word("makan", "eat"));
        search.addSeed(new Word("minum", "drink"));
        search.addSeed(new Word("jalan", "walk"));
        search.addSeed(new Word("loncat", "jump"));
        search.addSeed(new Word("lari", "run"));
        search.addSeed(new Word("bangun", "wakeup"));


        /**
         * Search from english to indonesia
         */

        System.out.println("\n====== Cari berdasarkan kata inggris ======");

        String keyWord1 = "wakeup";
        Word customSearch1 = search.searchFromEnglish(0, search.words.size(), keyWord1);

        if(customSearch1 != null) {
            printWord(customSearch1, keyWord1);
        } else {
            System.out.println("Kata '"+ keyWord1 +"' Tidak Di temukan");
        }

        /**
         * Search from indonesia to english
         */

        System.out.println("\n====== Cari berdasarkan kata indonesia ======");

        String keyWord2 = "bangun";
        Word customSearch2 = search.searchFromIndonesia(0, search.words.size(), keyWord2);

        if(customSearch2 != null) {
            printWord(customSearch2, keyWord2);
        } else {
            System.out.println("Kata '"+ keyWord2 +"' Tidak Di temukan");
        }


        /**
         * Search from indonesia to english when notfound
         */

        System.out.println("\n====== Cari berdasarkan kata indonesia [not found] ======");

        String keyWord3 = "bangun_rumah";
        Word customSearch3 = search.searchFromIndonesia(0, search.words.size(), keyWord3);

        if(customSearch3 != null) {
            printWord(customSearch3, keyWord3);
        } else {
            System.out.println("Kata '"+ keyWord3 +"' Tidak Di temukan");
        }

    }
}
