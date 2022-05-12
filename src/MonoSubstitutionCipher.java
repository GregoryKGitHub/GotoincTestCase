public class MonoSubstitutionCipher {

  public static String encrypt(String input, int n) {

    if(input.equals("") || n <= 0)  {
      return input;
    }

    String result = "", tempString = input.toLowerCase();

    for(int i = 0; i < n; i++)  {
      result = "";
      for(int j = 1; j < tempString.length(); j += 2)  {
        result += tempString.charAt(j);
      }
      for(int j = 0; j < tempString.length(); j += 2)  {
        result += tempString.charAt(j);
      }
      tempString = result;
    }

    return result;
  }

  public static String decrypt(String input, int n) {

    if(input.equals("") || n <= 0)  {
      return input;
    }

    String result = "", tempString = input.toLowerCase();

    for(int i = 0; i < n; i++)  {
      result = "";
      for(int j = tempString.length() / 2, k = 0; j < tempString.length(); j++, k++)  {
        result += tempString.charAt(j);
        if(tempString.length() / 2 != k)  {
          result += tempString.charAt(k);
        }
      }
      tempString = result;
    }

    return result;
  }
}
