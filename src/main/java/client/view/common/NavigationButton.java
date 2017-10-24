package client.view.common;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.HTML;

public class NavigationButton
  extends HTML
{
  public NavigationButton(SafeHtml safeHtml, final Command command)
  {
    setStyleName("simpleCheckBox"); // todo own style...

    setHTML(safeHtml);

    addClickHandler(new ClickHandler()
    {
      @Override
      public void onClick(ClickEvent event)
      {
        command.execute();
      }
    });
  }
}
