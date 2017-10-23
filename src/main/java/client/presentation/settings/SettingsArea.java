package client.presentation.settings;

import java.util.Collections;
import java.util.List;

import client.logic.AppData;
import client.presentation.common.LOG;
import client.presentation.common.Presenter;
import com.google.gwt.core.client.GWT;

public class SettingsArea
  extends Presenter<SettingsArea.View>
{
  public static final String ALLOW_COOKIES = "allowCookies";

  public interface View
    extends Presenter.View
  {
    void showBooleanOptions(List<String> keys);

    void setOptionChangeHandler(OptionChangeCommand<Boolean> optionChangeCommand);

    void setOption(String key, boolean value);
  }

  public SettingsArea()
  {
    super(GWT.<View>create(View.class));

    getView().showBooleanOptions(Collections.singletonList(ALLOW_COOKIES)); // todo more options to come?
    getView().setOptionChangeHandler(new OptionChangeCommand<Boolean>()
    {
      @Override
      public void onChange(String key, Boolean value)
      {
        if(key == null)
        {
          AppData.get().setAllowCookies(true);
          return;
        }

        if(ALLOW_COOKIES.equals(key))
        {
          AppData.get().setAllowCookies(value);
        }
        else
        {
          LOG.warn(getClass(), "The setting '" + key + "' is not implemented, yet.");
        }
      }
    });
    if(AppData.get().isAllowCookies())
    {
      getView().setOption(ALLOW_COOKIES, true);
    }
  }
}
