/*
 * Copyright (c) 2017 conLeos GmbH. All Rights reserved.
 * <p/>
 * This software is the confidential intellectual property of conLeos GmbH; it is copyrighted and licensed.
 */
package client.presentation.events;

import client.logic.Kana;
import com.google.gwt.event.shared.EventHandler;
import com.google.web.bindery.event.shared.Event;

public class KanaSelectionEvent
  extends Event<KanaSelectionEvent.Handler>
{
  public static final KanaSelectionEventType TYPE = new KanaSelectionEventType();
  private final Kana[] selectedKanas;

  public KanaSelectionEvent(Kana[] selectedKanas)
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
    void onSelectionEvent(Kana[] selectedKana);
  }
}
