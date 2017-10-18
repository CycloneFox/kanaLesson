/*
 * Copyright (c) 2017 conLeos GmbH. All Rights reserved.
 * <p/>
 * This software is the confidential intellectual property of conLeos GmbH; it is copyrighted and licensed.
 */
package client.view;

import java.util.HashMap;
import java.util.Map;

import client.presentation.KanaSelection.KanaSelectionGrid;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class KanaSelectionGridImpl
  implements KanaSelectionGrid.View
{
  private final FlexTable grid;
  private final Map<String, CheckBox> checkBoxLookup;
  private KanaSelectionGrid.SelectionHandler selectionHandler;

  public KanaSelectionGridImpl()
  {
    this.grid = new FlexTable();
    this.checkBoxLookup = new HashMap<String, CheckBox>();
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
    CheckBox checkBox = new CheckBox(label == null ? SafeHtmlUtils.EMPTY_SAFE_HTML : SafeHtmlUtils.fromString(label));
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
      checkBoxLookup.get(key).setValue(checkBoxValues.get(key) != null && checkBoxValues.get(key));
    }
  }
}
