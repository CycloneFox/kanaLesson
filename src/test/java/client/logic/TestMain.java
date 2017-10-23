package client.logic;

public class TestMain
{
  public static void main(String[] args)
  {
    System.out.println(Translator.translateFromTo("Nyan, nyan, nyan, nyan, nihao, nyan! ", Writing.ROMAJI, Writing.HIRAGANA, true));
  }
}
