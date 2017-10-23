package client.presentation.events;

import java.util.Collection;

import client.logic.Kana;
import com.google.gwt.event.shared.EventHandler;
import com.google.web.bindery.event.shared.Event;

public class KanaSelectionEvent
  extends Event<KanaSelectionEvent.Handler>
{
  public static final KanaSelectionEventType TYPE = new KanaSelectionEventType();
  private final Collection<Kana> selectedKanas;

  public KanaSelectionEvent(Collection<Kana> selectedKanas)
  {
    this.selectedKanas = selectedKanas;
  }

  @Override
  public Type getAssociatedType()
  {
    return TYPE;
  }

  @Override
  protected void dispatch(Handler handler)
  {
    handler.onSelectionEvent(selectedKanas);
  }

  public static class KanaSelectionEventType
    extends Event.Type<KanaSelectionEvent.Handler>
  {
  }

  public interface Handler
    extends EventHandler
  {
    void onSelectionEvent(Collection<Kana> selectedKana);
  }
}
