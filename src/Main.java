public class Main {
    public static void main(String[] args) {
        Caesar crypt = new Caesar();


        crypt.setKeyRange(7)
                .setKey("f230ZLwyVQHkGpmxR0ayt9Q9lTXGYg+9ntRBUQJJC/0Qhc6dGitxKr+jJPkKDxEoD68cXlKlkJhu5R/Nrw1vUwEcnFydLkrdxy7l5BprcKMQKwz2ERDhhil3O1f3S3qvKJ7+58I7Mw67QXr7Q25qDZy56PbbDoPXJQOCeoSWDPIy5H5W7WFg9YNU7JxVwM05OhSU0fokDLmju9qLKh9CXEly83tMV0uFv5dvgK7DXeUYCLT5MZlXcak7cltmF6cPUQ5k4Bry0oSsB+nSZlY4m3wvAv2k2IeM6Y1ByiRO9e+yE2pXlDQK6wT/6dZBU0tO10lU/l8sq/fWtclJj3VnSmHnZ224BtpZPfZCoXdC+cj1OxhS/M/9XLQYNASxMdo710r+pIVLL/4oe50w6guve4nCQ/hBONUgEeVMCXYwWc7dZrPIN2DqMLFAjK9nudKLPYoWe2Tx6+BeqbeOuu6fhL5MXLKDN3dzaWqLrTUmk6naTJbPEeBSRlBnU2udsgrMrBAPQ7Tp6HWoZH8ZXtIeqr2TAby8W2/IlGh7c+IQWq6B/2aVXnuVNYL6IU/Hwp5a8Z2HYRo37XLKKm/8UuWINgIURwbNANFsA4JFnfYlNuTKWMvEKGP9YzFV5jKTisWcgp8+g/WF8quj51iglyutUotQAZdesuwmS1Ncuy22GDr6hGPhtbHDtmguBCevMWOh5mQZGdIXcu3Zkj5Gh3S4Ig");


        String plainText = "Hello World";
        String encryptedText = crypt.encrypt(plainText);
        String decryptedtext = crypt.decrypt(encryptedText);

        System.out.println("Text awal : " + plainText);
        System.out.println("Encrypted text : " + encryptedText);
        System.out.println("Decrypted text : " + decryptedtext);
    }
}
