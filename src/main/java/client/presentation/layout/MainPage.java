package client.presentation.layout;

import client.logic.AppData;
import client.presentation.common.Presenter;
import client.presentation.common.ResponsivePresenter;
import client.presentation.events.ChangeContentEvent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
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
  extends ResponsivePresenter<MainPage.View>
{
  public interface View
    extends ResponsivePresenter.View
  {
    void setHeader(Widget widget);

    void setNavigation(Widget widget);

    void setContent(Widget widget);

    void setFooter(Widget widget);

    void setHeight(int height);
  }

  private ResizeTimer resizeTimer;

  public MainPage()
  {
    super(GWT.<View>create(View.class));

    this.resizeTimer = new ResizeTimer();

    getEventBus().addHandler(ChangeContentEvent.TYPE, this::setContent);

    getView().setHeader(new HTML("Kana Lesson"));
    getView().setNavigation(new Navigation().asWidget());
    getView().setFooter(new HTML("<small>Created by CycloneFox</small>"));

  }

  private void setContent(Presenter content)
  {
    AppData.get().setSelectedPage(content.getClass().getSimpleName());
    getView().setContent(content.asWidget());
  }

  @Override
  protected void onResize(int width, int height)
  {
    super.onResize(width, height);

    resizeTimer.setHeight(height); //  constants
  }

  private class ResizeTimer
    extends Timer
  {
    private int height;

    @Override
    public void run()
    {
      getView().setHeight(height);
    }

    public void setHeight(int height)
    {
      this.height = height;
      resizeTimer.schedule(GWT.isProdMode() ? 10 : 100); //  constants
    }
  }
}
