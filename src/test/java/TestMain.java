/*
 * Copyright (c) 2017 conLeos GmbH. All Rights reserved.
 * <p/>
 * This software is the confidential intellectual property of conLeos GmbH; it is copyrighted and licensed.
 */
package client.logic;

public class TestMain
{
  public static void main(String[] args)
  {
    System.out.println(Translator.translateFromTo("Nyan, nyan, nyan, nyan, nihao, nyan! ", Writing.ROMAJI, Writing.HIRAGANA, true));
  }
}
