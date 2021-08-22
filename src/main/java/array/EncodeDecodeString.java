package array;

import lombok.extern.slf4j.Slf4j;

/**
 * https://leetcode.com/discuss/interview-question/334671/goldman-sacks-july-2019-hackerrank-2
 * Carer cup Persons A and B uses an encryption based system for their conversation.
 * Each conversation message is encoded from the source and decoded in
 * the destination using a shared private positive number key known to each other.
 * The algorithm is illustrated with an example.
 * Input Format with explanation:
 * <p>
 * Operation (1 for Encoding and 2 for Decoding)
 * Input message
 * Input private key
 * Example:
 * <p>
 * input 1 Message: Open Key: 123
 * <p>
 * Output: Oppeeen
 * <p>
 * Input: 2 Oppeeen 123
 * <p>
 * Output: Open
 */
@Slf4j
public class EncodeDecodeString {

    public String encode(String s, String key) {
        StringBuilder res = new StringBuilder();
        int read = 0;
        char[] chars = s.toCharArray();
        char[] freqs = key.toCharArray();
        for (read = 0; read < freqs.length; read++) {
            for (int j = 1; j <= freqs[read] - '0'; j++) {
                res.append(chars[read]);
            }
        }
        while (read < chars.length) {
            res.append(chars[read++]);
        }
        return res.toString();
    }

    public String decode(String s, String key) {
        //check edge cases
        if(s == null || s.isEmpty() || key == null || key.isEmpty()){
            return "";
        }

        // 2 pointer
        int sReader = 0, keyReader = 0;
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        while(sReader < s.length() && keyReader < key.length()){
            int count = key.charAt(keyReader) - '0';
            sb.append(s.charAt(pos));
            pos += count;
            keyReader++;
            sReader = pos;
        }
        while(sReader < s.length()){
            sb.append(s.charAt(sReader));
            sReader++;
        }
        return sb.toString();
    }

    //other's solution

    //2 pointers
    public String encrypt(String msg, String key) {
        if (msg == null || msg == " " || key == null || key == " ")
            System.out.println(msg);

        int msgLen = 0;
        int keyLen = 0;
        StringBuilder sb = new StringBuilder();
        while (keyLen != key.length() && msgLen != msg.length()) {
            int count = (key.charAt(keyLen) - '1') + 1;
            char ch = msg.charAt(msgLen);
            while (count != 0) {
                sb.append(ch);
                count--;
            }
            keyLen++;
            msgLen++;
        }
        while (msgLen != msg.length()) {
            sb.append(msg.charAt(msgLen));
            msgLen++;
        }

        return sb.toString();
    }
    //skip read, I just read the last
    public String decrypt(String msg, String key) {
        if (msg == null || msg == " " || key == null || key == " ")
            System.out.println(msg);
        int msgLen = 0;
        int keyLen = 0;
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        while (keyLen != key.length() && msgLen != msg.length()) {
            int count = (int) key.charAt(keyLen) - '1' + 1;
            counter = counter + count;
            char ch = msg.charAt(counter - 1);
            sb.append(ch);
            keyLen++;
            msgLen = counter;
        }
        while (msgLen != msg.length()) {
            sb.append(msg.charAt(msgLen));
            msgLen++;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        EncodeDecodeString obj = new EncodeDecodeString();
        log.info("encoded= " + obj.encode("keep", "123"));
        log.info("decoded= " + obj.decode("keeeeep", "123"));
        log.info("encoded= " + obj.encrypt("keep", "123"));
        log.info("decoded= " + obj.decrypt("keeeeep", "123"));
    }


}
