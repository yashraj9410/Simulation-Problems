package solidPrinciples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.*;

// microsoft HR round

public class EmailValidator {

    public static boolean checkDomain(String domain) {
        if(domain.indexOf('.') == -1) return false;
        String[] domainParts = domain.split("\\.");
        for(String part : domainParts) {
            if(part.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkUserName(String userName) {
        Set<Character> set = new HashSet<>(Arrays.asList('.','+','#'));
        for(int i = 0; i < userName.length(); i++){
            if(i == 0 || i == userName.length() - 1){
                if(set.contains(userName.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidEmail(String email) {
        if (email == null || email.length() == 0) {
            return false;
        }
        int atIndex = email.indexOf('@');
        if(atIndex ==  -1 || atIndex != email.lastIndexOf('@')) {
            return false;
        }
        return checkDomain(email.substring(atIndex + 1)) && checkUserName(email.substring(0,atIndex));

    }

    public static void main(String[] args) {
     String[] testEmails = {
    "john.doe@example.com", //valid
                    "yash@xyz.com", //valid
                    "yash@xyz.tr.com", //valid
                    "yash@.com",  // invalid
                    "yash@yash",  // invalid
                    "xyz.com",
                    "yash@xyz..com",
                    ".@a.com",
                    "yash.raj+@gm.com",
                    "yash.raj+raju@gmail.com",
                    null
            };

            for (String email : testEmails) {
                System.out.println(email + " => " + isValidEmail(email));
            }
        }
    }
