package client.presentation.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import client.logic.AppData;
import client.logic.Kana;
import client.logic.Writing;
import client.presentation.common.Presenter;
import client.presentation.events.KanaSelectionEvent;
import com.google.gwt.core.client.GWT;

public class KanaSelectionGrid
  extends Presenter<KanaSelectionGrid.View>
{
  public static final Collection<Kana> DEFAULT_SELECTION = Arrays.asList(Kana.A_ROW);

  public interface View
    extends Presenter.View
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

  private final Set<Kana> kanaStore;

  public KanaSelectionGrid()
  {
    super(GWT.<View>create(View.class));

    this.kanaStore = new HashSet<Kana>();

    initializeView();

    Collection<Kana> selectedKanas = AppData.get().getKanaSelection();
    if(selectedKanas == null)
    {
      selectedKanas = DEFAULT_SELECTION;
    }
    setKanaSelection(selectedKanas);
  }

  private void setKanaSelection(Collection<Kana> selectedKanas)
  {
    AppData.get().setKanaSelection(selectedKanas);
    kanaStore.clear();
    kanaStore.addAll(selectedKanas);

    // update view
    Collection<String> keys = new ArrayList<String>();
    for(Kana selectedKana : selectedKanas)
    {
      if(selectedKana != null)
      {
        keys.add(selectedKana.getRomaji());
      }
    }
    updateCheckboxes(keys);

    getEventBus().fireEvent(new KanaSelectionEvent(selectedKanas));
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
        getView().addCheckbox(row + 1, 0, createRowKey(kanaRow), "->");
        int column = 0;
        for(Kana kana : kanaRow)
        {
          getView().addCheckbox(row + 1, column + 1, kana.getRomaji(), kana.getRomaji());
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
        Set<Kana> newKanaSelection = new HashSet<Kana>(kanaStore);
        for(String selectedKey : selection)
        {
          Kana kana = Kana.getKanaBy(selectedKey, Writing.ROMAJI);
          if(selected)
          {
            newKanaSelection.add(kana);
          }
          else
          {
            newKanaSelection.remove(kana);
          }
        }
        setKanaSelection(newKanaSelection);
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
