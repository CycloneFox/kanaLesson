/*
 * Copyright (c) 2017 conLeos GmbH. All Rights reserved.
 * <p/>
 * This software is the confidential intellectual property of conLeos GmbH; it is copyrighted and licensed.
 */
package client.presentation.events;

import client.logic.Kana;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.web.bindery.event.shared.Event;

public class KanaSelectionEvent
  extends Event.Type<KanaSelectionEvent.Handler>
{
  private static final GwtEvent.Type<Handler> TYPE = new GwtEvent.Type<Handler>();

  public static GwtEvent.Type<Handler> type()
  {
    return TYPE;
  }

  public interface Handler
    extends EventHandler
  {
    void onSelectionEvent(Kana[] selectedKana);
  }
}
