package questions;

/*
Carer cup Persons A and B uses an encryption based system for their conversation.
        Each conversation message is encoded from the source and decoded in
        the destination using a shared private positive number key known to each other.
        The algorithm is illustrated with an example.
        Input Format with explanation:

        Operation (1 for Encoding and 2 for Decoding)
        Input message
        Input private key
        Example:

        input 1 Message: Open Key: 123

        Output: Oppeeen

        Input: 2 Oppeeen 123

        Output: Open
 */
public class CarerCup {


    public static void main(String[] args) {
        int operation = 1;
        String message = "abcdefgh";
        String key = "33333333333";
        String encrypted = encrypt(message, key);


        String messageD = "aaabbbcccdddeeefffggghhh";
        String decrypted = decrypt(messageD, key);

        System.out.println(encrypted + " equals " + messageD + " is " + encrypted.equals(messageD));
        System.out.println(decrypted + " equals " + message + " is " + decrypted.equals(message));
    }

    private static String decrypt(String message, String key) {

        if (key == null || key.isEmpty() || key.isBlank()) {
            return message;
        }


        if (message == null || message.isEmpty() || message.isBlank()) {
            return null;
        }

        int length = message.length();
        int keyLength = key.length();

        int j = 0;
        int i = 0;

        StringBuilder sb = new StringBuilder();

        while (i < length) {
            sb.append(message.charAt(i));
            if (j < keyLength) {
                int count = Integer.parseInt(String.valueOf(key.charAt(j)));
                i += count;
                j++;
            } else {
                i++;
                break;
            }

        }

        while (i < length) {
            sb.append(message.charAt(i));
            i++;
        }

        return sb.toString();
    }

    private static String encrypt(String message, String key) {

        if (key == null || key.isEmpty() || key.isBlank()) {
            return message;
        }


        if (message == null || message.isEmpty() || message.isBlank()) {
            return null;
        }

        int length = message.length();
        int keyLength = key.length();

        int j = 0;
        int i = 0;


        StringBuilder sb = new StringBuilder();

        for (; i < length; i++) {

            if (j < keyLength) {
                int count = Integer.parseInt(String.valueOf(key.charAt(j)));
                while (count > 0) {
                    sb.append(message.charAt(i));
                    count--;
                }
                j++;
            } else
                break;
        }

        while (i < length) {
            sb.append(message.charAt(i));
            i++;
        }


        return sb.toString();
    }
}
