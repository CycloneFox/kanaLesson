/*
 * Copyright (c) 2017 conLeos GmbH. All Rights reserved.
 * <p/>
 * This software is the confidential intellectual property of conLeos GmbH; it is copyrighted and licensed.
 */
package client.view;

import client.presentation.KanaSelection.KanaSelectionGrid;
import client.presentation.common.Grid;
import client.presentation.common.Row;
import com.google.gwt.user.cellview.client.AbstractCellTable;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.CellPreviewEvent;

public class KanaSelectionGridImpl
  implements KanaSelectionGrid.View
{
  private final Grid grid;

  public KanaSelectionGridImpl()
  {
    this.grid = new Grid();
    grid.addCellPreviewHandler(new AbstractCellTable.CellTableKeyboardSelectionHandler<Row>(grid){
      @Override
      public void onCellPreview(CellPreviewEvent<Row> event)
      {
        // todo create click events for grid class
        boolean isClick = "click".equals(event.getNativeEvent().getType());
        super.onCellPreview(event);
      }
    });
  }

  @Override
  public Widget asWidget()
  {
    return grid;
  }

  @Override
  public void clear()
  {
//    grid.clear();
  }

  @Override
  public void addCheckbox(int row, int column, String key, String label)
  {
//    grid.setHTML(row, column, label); // todo map key, display checkbox etc..
  }

  @Override
  public void setRowAndColumnCount(int rows, int columns)
  {
//    grid.resize(rows, columns);
  }
}
