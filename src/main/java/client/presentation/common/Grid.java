/*
 * Copyright (c) 2017 conLeos GmbH. All Rights reserved.
 * <p/>
 * This software is the confidential intellectual property of conLeos GmbH; it is copyrighted and licensed.
 */
package client.presentation.common;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.view.client.ProvidesKey;

public class Grid
  extends CellTable<Row>
{
  private static ProvidesKey<Row> keyProvider = new ProvidesKey<Row>()
  {
    @Override
    public Object getKey(Row item)
    {
      return item.getKey();
    }
  };

  public Grid()
  {
    super(15, keyProvider);
  }
}
