package client.logic;

import java.util.Arrays;
import java.util.Collection;

public class Translator
{
  public static Collection<String> DOUBLE_CONSONANTS = Arrays.asList("bb", "dd", "ff", "gg", "kk", "ll", "mm", "nn", "pp", "rr", "ss", "tt");

  /**
   * This method translates a given string from a given writing to a given writing. Characters, which cannot be translated will be skipped.
   *
   * @param value       the string to be translated
   * @param fromWriting the writing to translate from
   * @param toWriting   the writing to translate to
   *
   * @return the translated string
   */
  public static String translateFromTo(String value, Writing fromWriting, Writing toWriting, boolean takeOverNonTranslatables)
  {
    // this is where the translation will be collected
    StringBuilder translationBuilder = new StringBuilder();

    // iterate the translation value
    for(int i = 0; i < value.length(); /*incrementation will be determined after finding the kana*/)
    {
      // try to find a kana of the from-writing at the current index
      Kana currentKana = getKanaAtIndex(value, i, fromWriting);

      if(currentKana == null)
      {
        // append it to the translated string if required
        if(takeOverNonTranslatables)
        {
          translationBuilder.append(value.charAt(i));
        }
        // skip character
        ++i;
      }
      else
      {
        // we found the kana, we can translate:
        String translated = currentKana.get(toWriting);
        translationBuilder.append(translated);

        // increment index by length of found kana
        i += currentKana.get(fromWriting).length();
      }
    }

    return translationBuilder.toString();
  }

  /**
   * Gets the kana in of the given writing at the given index of the given string value.
   *
   * @param value   the value containing a kana
   * @param index   the index of the kana
   * @param writing the writing of the kana
   *
   * @return the found kana at the given index of the given value. Null, if there is no kana at the specified index of the given writing.
   */
  public static Kana getKanaAtIndex(String value, int index, Writing writing)
  {
    if(value == null || index >= value.length())
    {
      return null;
    }

    for(int kanaLength = 3; kanaLength > 0; --kanaLength)
    {
      if(value.length() > index + kanaLength - 1) // up to X character kanas
      {
        String potentialKana = value.substring(index, index + kanaLength);

        Kana kanaInWriting = getMatch(potentialKana, writing);
        if(kanaInWriting != null)
        {
          return kanaInWriting;
        }
      }
    }

    return null;
  }

  private static Kana getMatch(String potentialKana, Writing writing)
  {
    if(potentialKana == null)
    {
      return null;
    }

    // check for small tsu or double consonants other than 'n'
    if(potentialKana.length() == 2)
    {
      if(isSmallTsu(potentialKana, writing))
      {
        return Kana.SMALL_TSU;
      }
    }

    for(String kanaInWriting : Kana.getAllOf(writing))
    {
      if(kanaInWriting.toLowerCase().equals(potentialKana.toLowerCase()))
      {
        return Kana.getKanaBy(kanaInWriting, writing);
      }
    }
    return null;
  }

  private static boolean isSmallTsu(String potentialKana, Writing writing)
  {
    return potentialKana != null
           && (Writing.ROMAJI.equals(writing) && DOUBLE_CONSONANTS.contains(potentialKana.toLowerCase())
               || Writing.HIRAGANA.equals(writing) && Kana.SMALL_TSU.getHiragana().toLowerCase().equals(potentialKana.substring(0, 1).toLowerCase())
               || Writing.HIRAGANA.equals(writing) && Kana.SMALL_TSU.getKatakana().toLowerCase().equals(potentialKana.substring(0, 1).toLowerCase()));
  }
}
