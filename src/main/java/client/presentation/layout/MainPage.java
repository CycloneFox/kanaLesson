package client.presentation.layout;

import client.presentation.common.Presenter;
import com.google.gwt.core.client.GWT;

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

  }

  public MainPage()
  {
    super(GWT.<View>create(View.class));
  }
}
