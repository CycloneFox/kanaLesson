package client.presentation.layout;

import client.presentation.common.Presenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;

/**
 * This class will be the main layout consisting of a header, a main navigation, a content area and a footer. <br>
 * When shown on a device wider than 600 px:
 * <pre>
 *   ┌───────────────────────────────────────┐
 *   │         ┌─────────────────┐        │
 *   │         │ Logo          │        │
 *   │         └─────────────────┘        │
 *   │         │1│2│3│4        │        │
 *   │         ┌─────────────────┐        │
 *   │         │ 1             │        │
 *   │         │ Content       │        │
 *
 *                  (...)
 *
 *   │         └─────────────────┘        │
 *   │         ┌────────┬────────┐        │
 *   │         │    Footer     │        │
 *   │         └────────┴────────┘        │
 *   └───────────────────────────────────────┘
 * </pre>
 * When shown on a device more narrow than 600px:
 * <pre>
 *   ┌───────────────────┐
 *   │┌─────────────────┐│
 *   ││ Logo          ││
 *   │└─────────────────┘│
 *   ││    Menubutton ││ <- shows/hides menu
 *   │┌─────────────────┐│
 *   ││ (Menu)        ││
 *   ││ 1             ││
 *   ││ 2             ││
 *   ││ 3             ││
 *   ││ 4             ││
 *   │└─────────────────┘│
 *   │┌─────────────────┐│
 *   ││ 1             ││
 *   ││ Content       ││
 *
 *         (...)
 *
 *   │└─────────────────┘│
 *   │┌────────┬────────┐│
 *   ││    Footer     ││
 *   │└────────┴────────┘│
 *   └───────────────────────────────────────┘
 * </pre>
 */
public class MainPage
  extends Presenter<MainPage.View>
{
  public interface View
    extends Presenter.View
  {
    void mobileLayout();

    void desktopLayout();

    void setHeader(Widget widget);

    void setNavigation(Widget widget);

    void setContent(Widget widget);

    void setFooter(Widget widget);
  }

  public MainPage()
  {
    super(GWT.<View>create(View.class));

    Window.addResizeHandler(new ResizeHandler()
    {
      @Override
      public void onResize(ResizeEvent event)
      {
        if(event.getWidth() < 600)
        {
          getView().mobileLayout();
        }
        else
        {
          getView().desktopLayout();
        }
      }
    });

    getView().setHeader(new HTML("Logo here"));
    getView().setNavigation(new HTML("Navigation here"));
    getView().setContent(new HTML("Content here"));
    getView().setFooter(new HTML("Footer here"));
  }
}
