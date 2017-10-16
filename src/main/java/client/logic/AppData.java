package client.logic;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;

public class AppData
{
  private static AppData INSTANCE;

  private final EventBus eventBus;

  public AppData()
  {
    this.eventBus = new SimpleEventBus();
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
}
