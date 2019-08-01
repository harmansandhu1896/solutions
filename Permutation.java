import java.util.HashSet;
import java.util.Set;

public class Permutation {

    public static Set<String> genPerm(String word)
    {
        Set<String> permSet=null;
        Set<String> set = new HashSet<String>();
        if (word == "") { // to capture empty string
            return set;
        }

        Character a = word.charAt(0); // getting the characters

        if (word.length() > 1) //checking if the length of the word is greater than 1
        {

            word = word.substring(1); // getting the substring

            permSet = genPerm(word); //feeding back the word to genPrem

           for (String x : permSet) //getting values from permSet and adding the substrings
            {

                for (int i = 0; i <= x.length(); i++)
                {
                    set.add(x.substring(0, i) + a + x.substring(i)); // taking a character and joining the substrings back and forth of it.
                }

            }
        }
        else // in case the length of word is 1 or less
        {
         set.add(a+"");
        }
        return set;
    }
    public static void main(String as[]){

        Set<String> result=genPerm("abc");
        System.out.println("  "+result);

    }
}
