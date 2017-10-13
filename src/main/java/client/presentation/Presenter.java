package client.presentation;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.IsWidget;

public abstract class Presenter<V extends IsWidget>
{
  private final V view;
  private final EventBus eventBus;

  public Presenter(V view)
  {
    this.view = view;
    this.eventBus = AppData.get().getEventBus();
  }

  protected IsWidget getView()
  {
    return view;
  }
}
