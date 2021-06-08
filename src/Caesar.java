import java.lang.reflect.Array;
import java.util.ArrayList;

public class Caesar {
    private String masterKey = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890~`!@#$%^&*()_+-=';:,<.>/?|{[]} \n";
    private ArrayList<String> privateKey = null;
    private Integer keyRange = 4;

    // setingup key range

    public Caesar setKeyRange(Integer range) {
        this.keyRange = range;
        return this;
    }

    // settingup key and remove duplicated text
    public Caesar setKey(String key) {
        ArrayList<String> splitedKey = new ArrayList<>();
        for (String unfilteredKey: key.split("(?<=\\G.{" + this.keyRange + "})")) {
            if(splitedKey.indexOf(unfilteredKey) == -1) {
                splitedKey.add(unfilteredKey);
            }
        }
        this.privateKey = splitedKey;
        return  this;
    }

    // encrypt data with salt key
    public String encrypt(String toBeEncrypt) {
        String chipperKey = "";

        for (String text: toBeEncrypt.split("")) {
            chipperKey += this.privateKey.get(masterKey.indexOf(text));
        }

        return  chipperKey;
    }

    // decrypt text
    public String decrypt(String chipper) {
        String bufResult = "";
        for (String chip : chipper.split("(?<=\\G.{" + this.keyRange + "})")) {
            bufResult += this.masterKey.charAt(this.privateKey.indexOf(chip)); //this.masterKey[this.privateKey.indexOf(chip)];
        }
        return  bufResult;
    }
}
