package matrix.hillchiper;

import java.util.ArrayList;

public class Encrypt {
    final String privateKey = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890 \n\t";
    final String zeroKeyCode = "F";
    final String randomKey[] = {"A", "B", "C", "D", "E"};
    final Integer encryptKeyPair[][] = {
            {2,3},
            {1,2}
    };

    public String getKeyPairIndex(String keyText) {
        String splitedKey[] = this.privateKey.split("");
        for (int i = 0; i < splitedKey.length; i++) {
            if(((String) splitedKey[i]).equals(keyText)) {
                return "" + (i + 1);
            }
        }
        return keyText;
    }

    public String generateRandomKey(Integer length) {
        String keyResult = "";
        for(int i = 1; i <=  length; i++) {
            keyResult += this.randomKey[(int) (Math.floor(Math.random() * (this.randomKey.length - 1)) + 1)];
        }
        return  keyResult;
    }

    public String generateSignatureKey(String keyText) {
        String resultText = keyText.replaceAll("0", this.zeroKeyCode);
        if(resultText.length() < 4) {
            return "" + generateRandomKey(4 - keyText.length()) + resultText;
        }
        return resultText;
    }


    public String encrypt(String source) {

        String fileToArray[] = source.split("");
        ArrayList<ArrayList<Integer>> mapedMatrix = new ArrayList<>();
        mapedMatrix.add(new ArrayList<>());
        mapedMatrix.add(new ArrayList<>());

        ArrayList<Integer> fileToNum = new ArrayList<>();

        for(String ar : fileToArray) {
            fileToNum.add(Integer.parseInt(getKeyPairIndex(ar)));
        }

        if(fileToNum.size() % 2 == 1) {
            fileToNum.add(privateKey.length() - 1);
        }


        for(int key = 0; key < fileToNum.size(); key++) {
            if(key < fileToNum.size() / 2)/**/ {
                mapedMatrix.get(0).add(fileToNum.get(key));
            } else {
                mapedMatrix.get(1).add(fileToNum.get(key));
            }
        }

        ArrayList<ArrayList<Integer>> mapedParsedMatrix = new ArrayList<>();
        mapedParsedMatrix.add(new ArrayList<>());
        mapedParsedMatrix.add(new ArrayList<>());



        for(Integer value : mapedMatrix.get(0)) {
            mapedParsedMatrix.get(0).add(value * encryptKeyPair[0][0]);
            mapedParsedMatrix.get(1).add(value * encryptKeyPair[1][0]);
        }




        for(int key = 0; key < mapedMatrix.get(1).size(); key++) {
            Integer value = mapedMatrix.get(1).get(key);
            mapedParsedMatrix.get(0).set(key, mapedParsedMatrix.get(0).get(key) + (value * encryptKeyPair[0][1]));
            mapedParsedMatrix.get(1).set(key, mapedParsedMatrix.get(1).get(key) + (value * encryptKeyPair[1][1]));
        }


        ArrayList<Integer> listingMatrix = new ArrayList<>();
        listingMatrix.addAll(mapedParsedMatrix.get(0));
        listingMatrix.addAll(mapedParsedMatrix.get(1));

        ArrayList<String> fileToKeyMap = new ArrayList<>();

        for(Integer x : listingMatrix) {
            fileToKeyMap.add(generateSignatureKey("" + x));
        }


        return String.join("", fileToKeyMap);
    }
}
