/*
 * Copyright (c) 2017 conLeos GmbH. All Rights reserved.
 * <p/>
 * This software is the confidential intellectual property of conLeos GmbH; it is copyrighted and licensed.
 */
package client.presentation.KanaSelection;

import client.logic.Kana;
import client.presentation.common.Presenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.IsWidget;

public class KanaSelectionGrid
  extends Presenter<KanaSelectionGrid.View>
{
  public interface View
    extends IsWidget
  {
    void clear();

    void addCheckbox(int row, int column, String key, String label);

    void setRowAndColumnCount(int rows, int columns);
  }

  public KanaSelectionGrid()
  {
    super(GWT.<View>create(View.class));

    initialize();
  }

  private void initialize()
  {
    getView().clear();
    getView().setRowAndColumnCount(getRowCount(), getColumnCount());
    int row = 0;
    for(Kana[][] kanaGroup : Kana.ALL_KANA_IN_GROUPS)
    {
      for(Kana[] kanaRow : kanaGroup)
      {
        int column = 0;
        for(Kana kana : kanaRow)
        {
          getView().addCheckbox(row, column, kana.getRomaji(), kana.getRomaji() + " " + kana.getHiragana()); // todo katakana? other grid?
          ++column;
        }
        ++row;
      }
    }
  }

  private static int getRowCount()
  {
    int count = 0;
    for(Kana[][] kanaGroup : Kana.ALL_KANA_IN_GROUPS)
    {
      count += kanaGroup.length;
    }
    return count;
  }

  private static  int getColumnCount()
  {
    int biggestRow = 0;
    for(Kana[][] kanaGroup : Kana.ALL_KANA_IN_GROUPS)
    {
      for(Kana[] kanaRow : kanaGroup)
      {
        if(kanaRow.length > biggestRow)
        {
          biggestRow = kanaRow.length;
        }
      }
    }
    return biggestRow;
  }
}
