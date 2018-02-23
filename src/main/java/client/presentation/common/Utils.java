package client.presentation.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import client.logic.Kana;

public class Utils
{

  public static final String SEPARATOR = ", ";
  public static final String START = "[";
  public static final String END = "]";

  public static String toString(Collection<Kana> collection)
  {
    StringBuilder sb = new StringBuilder();

    sb.append(START);
    if(collection != null)
    {
      ArrayList<Kana> ordered = new ArrayList<Kana>(collection);
      for(Kana kana : ordered)
      {
        if(kana != null)
        {
          sb.append(kana.getKey());
          if(ordered.indexOf(kana) < ordered.size() -1)
          {
            sb.append(SEPARATOR);
          }
        }
      }
    }
    sb.append(END);

    return sb.toString();
  }

  public static Collection<Kana> fromString(String from)
  {
    if(from == null || from.isEmpty() || !START.equals(from.substring(0, 1)) || !END.equals(from.substring(from.length() -1, from.length())))
    {
      return Collections.emptyList();
    }

    String listContent = from.substring(1, from.length() - 1);

    Collection<Kana> kanas = new ArrayList<Kana>();

    for(String key : listContent.split(SEPARATOR))
    {
      Kana kana = Kana.getKanaByKey(key);
      if(kana != null)
      {
        kanas.add(kana);
      }
    }
    return kanas;
  }
}
