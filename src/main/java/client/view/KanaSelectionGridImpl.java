package client.view;

import java.util.HashMap;
import java.util.Map;

import client.presentation.exercise.KanaSelectionGrid;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class KanaSelectionGridImpl
  implements KanaSelectionGrid.View
{
  private final FlexTable grid;
  private final Map<String, SimpleCheckbox> checkBoxLookup;
  private KanaSelectionGrid.SelectionHandler selectionHandler;

  public KanaSelectionGridImpl()
  {
    this.grid = new FlexTable();
    grid.setStyleName("kanaSelectionGrid");
    this.checkBoxLookup = new HashMap<String, SimpleCheckbox>();
  }

  @Override
  public Widget asWidget()
  {
    return grid;
  }

  @Override
  public void clear()
  {
    grid.clear();
  }

  @Override
  public void addCheckbox(int row, int column, final String key, String label)
  {
    SimpleCheckbox checkBox = new SimpleCheckbox(label);
    checkBox.addValueChangeHandler(new ValueChangeHandler<Boolean>()
    {
      public void onValueChange(ValueChangeEvent<Boolean> event)
      {
        if(selectionHandler != null)
        {
          selectionHandler.onSelect(key, event.getValue());
        }
      }
    });
    checkBoxLookup.put(key, checkBox);
    grid.setWidget(row, column, checkBox);
  }

  @Override
  public void setSelectionHandler(KanaSelectionGrid.SelectionHandler selectionHandler)
  {
    this.selectionHandler = selectionHandler;
  }

  @Override
  public void setCheckBoxes(Map<String, Boolean> checkBoxValues)
  {
    for(String key : checkBoxValues.keySet())
    {
      checkBoxLookup.get(key).setValue(checkBoxValues.get(key) != null && checkBoxValues.get(key), true);
    }
  }
}
