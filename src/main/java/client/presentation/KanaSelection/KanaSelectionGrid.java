/*
 * Copyright (c) 2017 conLeos GmbH. All Rights reserved.
 * <p/>
 * This software is the confidential intellectual property of conLeos GmbH; it is copyrighted and licensed.
 */
package client.presentation.KanaSelection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import client.logic.AppData;
import client.logic.Kana;
import client.presentation.common.Presenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.IsWidget;

public class KanaSelectionGrid
  extends Presenter<KanaSelectionGrid.View>
{
  private static final Collection<String> DEFAULT_SELECTION = Kana.romajiOf(Kana.A_ROW);

  public interface View
    extends IsWidget
  {
    void clear();

    void addCheckbox(int row, int column, String key, String label);

    void setSelectionHandler(SelectionHandler selectionHandler);

    void setKanaSelection(Collection<String> selectedKanas);
  }

  public interface SelectionHandler
  {
    void onSelect(String key, boolean selected);
  }

  private final Set<String> kanaStore;

  public KanaSelectionGrid()
  {
    super(GWT.<View>create(View.class));

    this.kanaStore = new HashSet<String>();

    initializeView();

    Collection<String> selectedKanas = AppData.get().getKanaSelection();
    if(selectedKanas == null)
    {
      selectedKanas = DEFAULT_SELECTION;
    }
    setKanaSelection(selectedKanas, true);
  }

  private void setKanaSelection(Collection<String> selectedKanas, boolean updateView)
  {
    AppData.get().setKanaSelection(selectedKanas);
    kanaStore.clear();
    kanaStore.addAll(selectedKanas);
    if(updateView)
    {
      getView().setKanaSelection(selectedKanas);
    }
  }

  private void initializeView()
  {
    // clear possible previous content
    getView().clear();

    // add grid check boxes for all kans
    int row = 0;
    for(Kana[][] kanaGroup : Kana.ALL_KANA_IN_GROUPS)
    {
      for(Kana[] kanaRow : kanaGroup)
      {
        getView().addCheckbox(row + 1, 0, createRowKey(kanaRow), ":");
        int column = 0;
        for(Kana kana : kanaRow)
        {
          getView().addCheckbox(row + 1, column + 1, kana.getRomaji(), kana.getRomaji() + " " + kana.getHiragana());
          ++column;
        }
        ++row;
      }
    }

    // when clicking on a checkbox, select or deselect that
    getView().setSelectionHandler(new SelectionHandler()
    {
      @Override
      public void onSelect(String key, boolean selected)
      {
        if(selected)
        {
          kanaStore.add(key);
        }
        else
        {
          kanaStore.remove(key);
        }
        setKanaSelection(kanaStore, false);
      }
    });
  }



  private static String createRowKey(Kana[] kanaRow)
  {
    if(kanaRow == null || kanaRow.length == 0)
    {
      return "emptyRow";
    }
    StringBuilder sb = new StringBuilder();
    for(Kana kana : kanaRow)
    {
      sb.append(kana.getRomaji());
    }
    sb.append("Row");
    return sb.toString();
  }
}
