package client.presentation.common;

import client.logic.AppData;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public abstract class Presenter<V extends IsWidget>
  implements IsWidget
{
  private final V view;
  private final EventBus eventBus;

  public Presenter(V view)
  {
    this.view = view;
    this.eventBus = AppData.get().getEventBus();

    getView().asWidget().addAttachHandler(new AttachEvent.Handler()
    {
      @Override
      public void onAttachOrDetach(AttachEvent event)
      {
        if (event.isAttached())
        {
          onShow();
        }
        else
        {
          onHide();
        }
      }
    });
  }

  protected void onHide()
  {

  }

  protected void onShow()
  {

  }

  public V getView()
  {
    return view;
  }

  public EventBus getEventBus()
  {
    return eventBus;
  }

  @Override
  public Widget asWidget()
  {
    return getView().asWidget();
  }
}
