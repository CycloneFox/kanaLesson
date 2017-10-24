package client.presentation.common;

import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.Window;

/**
 * Presenters, which derive from this class will automatically call a mobile- or a desktop-layout method in their views depending on viewport size.
 *
 * @param <V> a view containing layout methods for both a mobile and a desktop layout
 */
public abstract class ResponsivePresenter<V extends ResponsivePresenter.View>
  extends Presenter<V>
{
  public interface View
    extends Presenter.View
  {
    void mobileLayout();

    void desktopLayout();
  }

  private Boolean mobile;

  public ResponsivePresenter(V view)
  {
    super(view);
    this.mobile = null;

    getView().asWidget().addAttachHandler(new AttachEvent.Handler()
    {
      @Override
      public void onAttachOrDetach(AttachEvent event)
      {
        onResize(Window.getClientWidth(), Window.getClientHeight());
      }
    });
    Window.addResizeHandler(new ResizeHandler()
    {
      @Override
      public void onResize(ResizeEvent event)
      {
        ResponsivePresenter.this.onResize(event.getWidth(), event.getHeight());
      }
    });
  }

  /**
   * Is called on every (!) resize event or attach of the whole application. So this method must always be extremely light-weighted.
   *
   * @param width  the window width
   * @param height the window height
   */
  protected void onResize(int width, int height)
  {
    // only call layout method when passing over a very specific border (800px)
    if(width < 800)
    {
      if(mobile == null || !mobile)
      {
        getView().mobileLayout();
        mobile = true;
      }
    }
    else if(mobile == null || mobile)
    {
      getView().desktopLayout();
      mobile = false;
    }
  }
}
