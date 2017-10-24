/*
 * Copyright (c) 2017 conLeos GmbH. All Rights reserved.
 * <p/>
 * This software is the confidential intellectual property of conLeos GmbH; it is copyrighted and licensed.
 */
package client.presentation.events;

import client.presentation.common.Presenter;
import com.google.gwt.event.shared.EventHandler;
import com.google.web.bindery.event.shared.Event;

public class ChangeContentEvent
  extends Event<ChangeContentEvent.Handler>
{
  public static final ChangeContentEventType TYPE = new ChangeContentEventType();

  private final Presenter content;

  public ChangeContentEvent(Presenter content)
  {
    this.content = content;
  }

  @Override
  public Type<ChangeContentEvent.Handler> getAssociatedType()
  {
    return TYPE;
  }

  @Override
  protected void dispatch(Handler handler)
  {
    handler.onContentChange(content);
  }

  public static class ChangeContentEventType
    extends Event.Type<ChangeContentEvent.Handler>
  {
  }

  public interface Handler
    extends EventHandler
  {
    void onContentChange(Presenter content);
  }
}
