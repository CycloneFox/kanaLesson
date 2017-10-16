/*
 * Copyright (c) 2017 conLeos GmbH. All Rights reserved.
 * <p/>
 * This software is the confidential intellectual property of conLeos GmbH; it is copyrighted and licensed.
 */
package client.presentation.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.safehtml.shared.SafeHtml;

/**
 * A row for a grid
 */
public class Row
{
  private List<String> keys;
  private Map<String, SafeHtml> htmlMap;
  private Object key;

  public Row()
  {
    this.key = UUID.getUUID("Row");
    this.keys = new ArrayList<>();
    this.htmlMap = new HashMap<>();
  }

  public List<String> getKeys()
  {
    return new ArrayList<>(keys);
  }

  public SafeHtml getHtml(String key)
  {
    return htmlMap.get(key);
  }

  public void add(String key, SafeHtml html)
  {
    add(-1, key, html);
  }

  public void add(int index, String key, SafeHtml html)
  {
    if(index < 0)
    {
      index = keys.size();
    }
    keys.add(index, key);
    htmlMap.put(key, html);
  }

  public void remove(String key)
  {
    keys.remove(key);
    htmlMap.remove(key);
  }

  public Object getKey()
  {
    return key;
  }

  public void setKey(Object key)
  {
    this.key = key;
  }
}
