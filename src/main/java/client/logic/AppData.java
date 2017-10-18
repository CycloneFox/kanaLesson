package client.logic;

import java.util.Collection;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Cookies;

public class AppData
{
  public static final String ALLOW_COOKIES = "allowCookies";
  public static final String KANA_SELECTION = "kanaSelection";
  private static AppData INSTANCE;

  private final EventBus eventBus;
  private boolean allowCookies;
  private Collection<String> kanaSelection;

  public AppData()
  {
    this.eventBus = new SimpleEventBus();
    String allowCookies = Cookies.getCookie(ALLOW_COOKIES);
    boolean isAllowCookies = Boolean.TRUE.toString().equals(allowCookies);
    this.allowCookies = isAllowCookies;
    if(isAllowCookies)
    {
//      this.kanaSelection = Arrays.toString()Cookies.getCookie(KANA_SELECTION);
      // TODO get kana from cookies!
    }
  }

  public static AppData get()
  {
    if(INSTANCE == null)
    {
      INSTANCE = new AppData();
    }
    return INSTANCE;
  }

  public EventBus getEventBus()
  {
    return eventBus;
  }

  private void saveAppData()
  {
    if(allowCookies)
    {
      Cookies.setCookie(ALLOW_COOKIES, Boolean.toString(true));
      Cookies.setCookie(KANA_SELECTION, kanaSelection.toString());
    }
  }

  public boolean isAllowCookies()
  {
    return allowCookies;
  }

  public Collection<String> getKanaSelection()
  {
    return kanaSelection;
  }

  public void setAllowCookies(boolean allowCookies)
  {
    this.allowCookies = allowCookies;
    saveAppData();
  }

  public void setKanaSelection(Collection<String> kanaSelection)
  {
    this.kanaSelection = kanaSelection;
    saveAppData();
  }
}
