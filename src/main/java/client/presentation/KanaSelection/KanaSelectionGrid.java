/*
 * Copyright (c) 2017 conLeos GmbH. All Rights reserved.
 * <p/>
 * This software is the confidential intellectual property of conLeos GmbH; it is copyrighted and licensed.
 */
package client.presentation.KanaSelection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import client.logic.AppData;
import client.logic.Kana;
import client.logic.Writing;
import client.presentation.common.Presenter;
import client.presentation.events.KanaSelectionEvent;
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

    void setCheckBoxes(Map<String, Boolean> checkboxValues);
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
      updateCheckboxes(selectedKanas);
    }

    List<String> kanaKeys = new ArrayList<String>(selectedKanas);
    Kana[] kanas = new Kana[selectedKanas.size()];
    for(int i = 0; i < selectedKanas.size(); i++)
    {
      kanas[i] = Kana.getKanaBy(kanaKeys.get(i), Writing.ROMAJI);
    }
    getEventBus().fireEvent(new KanaSelectionEvent(kanas));
  }

  private void updateCheckboxes(Collection<String> selectedKanas)
  {
    Map<String, Boolean> checkboxValues = new HashMap<String, Boolean>();
    for(Kana[][] kanaGroup : Kana.ALL_KANA_IN_GROUPS)
    {
      for(Kana[] kanaRow : kanaGroup)
      {
        boolean allKanaInGroupContained = true;
        for(Kana kana : kanaRow)
        {
          String key = kana.getRomaji();
          boolean currentKanaContained = selectedKanas.contains(key);
          allKanaInGroupContained &= currentKanaContained;
          checkboxValues.put(key, currentKanaContained);
        }
        checkboxValues.put(createRowKey(kanaRow), allKanaInGroupContained); // turns row check bx on and off
      }
    }
    getView().setCheckBoxes(checkboxValues);
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
        Collection<String> selection = new ArrayList<String>();
        // check for multi selection key
        for(Kana[][] kanaGroup : Kana.ALL_KANA_IN_GROUPS)
        {
          for(Kana[] kanaRow : kanaGroup)
          {
            if(createRowKey(kanaRow).equals(key))
            {
              for(Kana kana : kanaRow)
              {
                selection.add(kana.getRomaji());
              }
            }
          }
        }
        // no multi-selection means single selection
        if(selection.isEmpty())
        {
          selection.add(key);
        }
        Set<String> newKanaSelection = new HashSet<String>(kanaStore);
        for(String selectedKey : selection)
        {
          if(selected)
          {
            newKanaSelection.add(selectedKey);
          }
          else
          {
            newKanaSelection.remove(selectedKey);
          }
        }
        setKanaSelection(newKanaSelection, true);
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
