package client.logic;

import java.util.Collection;

import client.presentation.common.Utils;
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
  private Collection<Kana> kanaSelection;

  public AppData()
  {
    this.eventBus = new SimpleEventBus();
    loadAppData();
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

  private boolean isAllowCookiesSetAllowedInCookies()
  {
    String allowCookies = Cookies.getCookie(ALLOW_COOKIES);
    return Boolean.TRUE.toString().equals(allowCookies);
  }

  private void saveAppData()
  {
    if(allowCookies)
    {
      Cookies.setCookie(ALLOW_COOKIES, Boolean.toString(true));
      Cookies.setCookie(KANA_SELECTION, Utils.toString(kanaSelection));
    }
    else if(isAllowCookiesSetAllowedInCookies())
    {
      Cookies.removeCookie(ALLOW_COOKIES);
    }
  }

  private void loadAppData()
  {
    boolean isAllowCookies = isAllowCookiesSetAllowedInCookies();
    this.allowCookies = isAllowCookies;
    if(isAllowCookies)
    {
      this.kanaSelection = Utils.fromString(Cookies.getCookie(KANA_SELECTION));
    }
  }

  public boolean isAllowCookies()
  {
    return allowCookies;
  }

  public Collection<Kana> getKanaSelection()
  {
    return kanaSelection;
  }

  public void setAllowCookies(boolean allowCookies)
  {
    this.allowCookies = allowCookies;
    saveAppData();
  }

  public void setKanaSelection(Collection<Kana> kanaSelection)
  {
    this.kanaSelection = kanaSelection;
    saveAppData();
  }
}
