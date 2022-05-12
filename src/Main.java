import java.util.*;

public class Main {

  public static String[] wordsCounter(String input) {

    final int boundarySize = 3;
    int count, mostFrequent;
    String[] result = new String[boundarySize];

    List<String> words = new ArrayList<>(Arrays.asList(input
                                          .toLowerCase()
                                          .replaceAll("[!\"#$%&()*+,-./:;<=>?@[\\\\]^_`{|}~]", "")
                                          .split(" ")));

    HashSet<String> wordsSet = new HashSet<>(words);

    if(wordsSet.size() < boundarySize)  {
      return result;
    }

    for(int k = 0; k < boundarySize; k++) {
      mostFrequent = 0;
      for (int i = 0; i < words.size(); i++) {
        count = 0;
        for (int j = i + 1; j < words.size(); j++) {
          if (words.get(i).equals(words.get(j))) {
            count++;
          }
        }
        if(mostFrequent < count)  {
          result[k] = words.get(i);
          mostFrequent = count;
        }
      }
      for(int i = words.size() - 1; i >= 0; i--) {
        if(words.get(i).equals(result[k]))  {
          words.remove(i);
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {

    String[] test;

    System.out.println(MonoSubstitutionCipher.encrypt("abcdefghijk", 2));

    System.out.println(MonoSubstitutionCipher.decrypt("dhaeibfjcgk", 2));

    test = wordsCounter("Lorem ipsum dolor sit amet consectetur adipiscing elit varius consequat, habitasse tempus" +
        " dis arcu nibh dapibus phasellus aliquet nec, vel quis fringilla nulla leo senectus finibus dignissim." +
        " Commodo fringilla dapibus nec efficitur pulvinar tortor ex dui, phasellus fermentum primis convallis" +
        " dolor euismod placerat penatibus, est ipsum senectus cras hendrerit potenti viverra. Id lacus sociosqu natoque" +
        " fermentum eget ut ridiculus efficitur vulputate enim litora, massa per metus blandit" +
        " pretium mi porttitor in nam cursus. Netus arcu pretium bibendum inceptos lectus posuere per porttitor" +
        " eu egestas, sagittis curae taciti hendrerit consectetur amet commodo elit. Aliquam etiam commodo magna" +
        " mus finibus interdum rhoncus velit, accumsan potenti taciti molestie integer nullam. Penatibus ultricies" +
        " lectus sociosqu eget ad et sagittis, vitae nibh felis dictumst sodales purus, quam torquent etiam senectus" +
        " justo lobortis.");
    for (String s: test) {
      System.out.println(s);
    }
  }
}
