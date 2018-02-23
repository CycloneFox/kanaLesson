package client.logic;

import java.util.Collection;
import java.util.Date;

import client.presentation.common.Utils;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.datepicker.client.CalendarUtil;

public class AppData
{
  public static final String ALLOW_COOKIES = "allowCookies";
  public static final String KANA_SELECTION = "kanaSelection";
  public static final String SELECTED_PAGE = "selectedPage";

  private static AppData INSTANCE;

  private boolean allowCookies;

  private String selectedPage;

  private final EventBus eventBus;

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
    Date nextYear = new Date();
    CalendarUtil.addMonthsToDate(nextYear, 12);

    if(allowCookies)
    {
      Cookies.setCookie(ALLOW_COOKIES, Boolean.toString(true), nextYear);
      Cookies.setCookie(KANA_SELECTION, Utils.toString(kanaSelection), nextYear);
      Cookies.setCookie(SELECTED_PAGE, selectedPage, nextYear);
    }
    else if(isAllowCookiesSetAllowedInCookies())
    {
      Cookies.removeCookie(ALLOW_COOKIES);
      Cookies.removeCookie(KANA_SELECTION);
      Cookies.removeCookie(SELECTED_PAGE);
    }
  }

  private void loadAppData()
  {
    boolean isAllowCookies = isAllowCookiesSetAllowedInCookies();
    this.allowCookies = isAllowCookies;
    if(isAllowCookies)
    {
      this.kanaSelection = Utils.fromString(Cookies.getCookie(KANA_SELECTION));
      this.selectedPage = Cookies.getCookie(SELECTED_PAGE);
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

  public void setSelectedPage(String selectedPage)
  {
    this.selectedPage = selectedPage;
    saveAppData();
  }

  public String getSelectedPage()
  {
    return selectedPage;
  }
}
