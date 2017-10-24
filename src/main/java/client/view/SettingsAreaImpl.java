package client.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import client.presentation.settings.OptionChangeCommand;
import client.presentation.settings.SettingsArea;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;

public class SettingsAreaImpl
  implements SettingsArea.View
{
  private final HorizontalPanel panel;
  private final Map<String, CheckBox> checkBoxLookup;

  private OptionChangeCommand<Boolean> optionChangeCommand;

  public SettingsAreaImpl()
  {
    this.panel = new HorizontalPanel();
    this.checkBoxLookup = new HashMap<String, CheckBox>();
  }

  @Override
  public void showBooleanOptions(List<String> keys)
  {
    panel.clear();
    for(final String key : keys)
    {
      CheckBox checkBox = new CheckBox(key.toUpperCase());
      checkBoxLookup.put(key, checkBox);
      checkBox.addValueChangeHandler(new ValueChangeHandler<Boolean>()
      {
        @Override
        public void onValueChange(ValueChangeEvent<Boolean> event)
        {
          if(optionChangeCommand != null)
          {
            optionChangeCommand.onChange(key, event.getValue());
          }
        }
      });
      panel.add(checkBox);
    }
  }

  @Override
  public void setOptionChangeHandler(OptionChangeCommand<Boolean> optionChangeCommand)
  {
    this.optionChangeCommand = optionChangeCommand;
  }

  @Override
  public void setOption(String key, boolean value)
  {
    CheckBox checkBox = checkBoxLookup.get(key);
    if(checkBox != null)
    {
      checkBox.setValue(value);
    }
  }

  @Override
  public Widget asWidget()
  {
    return panel;
  }
}
