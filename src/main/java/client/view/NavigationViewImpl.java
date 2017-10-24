package client.view;

import java.util.ArrayList;
import java.util.List;

import client.presentation.layout.Navigation;
import client.view.common.NavigationButton;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import org.jadice.web.gwt.fontawesome.client.FontAwesome;

public class NavigationViewImpl
  implements Navigation.View
{
  private Panel panel; // wrapper for both layouts
  private Panel verticalNavigation; // for mobile layout
  private Panel horizontalNavigation; // for desktop layout

  private List<NavigationButton> buttons;
  private final HTML menuButton;
  private boolean mobileMenuShown;

  public NavigationViewImpl()
  {
    panel = new VerticalPanel();
    verticalNavigation = new VerticalPanel();
    horizontalNavigation = new HorizontalPanel();
    buttons = new ArrayList<NavigationButton>();
    menuButton = initMobileMenuButton();
  }

  private HTML initMobileMenuButton()
  {
    HTML html = new HTML(FontAwesome.BARS.toSafeHtml());
    html.setStyleName("bigButton");
    mobileMenuShown = false;
    html.addClickHandler(new ClickHandler()
    {
      @Override
      public void onClick(ClickEvent event)
      {
        setShowMobileMenu(!mobileMenuShown);
      }
    });
    return html;
  }

  @Override
  public void setShowMobileMenu(boolean show)
  {
    if(show)
    {
      panel.add(verticalNavigation);
    }
    else
    {
      verticalNavigation.removeFromParent();
    }
    mobileMenuShown = show;
  }

  private void cleanup()
  {
    panel.clear();
    mobileMenuShown = false;
    for(NavigationButton button : buttons)
    {
      button.removeFromParent();
    }
  }

  private void layoutButtons(Panel navBar)
  {
    for(NavigationButton button : buttons)
    {
      navBar.add(button);
    }
  }

  @Override
  public void mobileLayout()
  {
    cleanup();
    panel.add(menuButton);
    layoutButtons(verticalNavigation);
  }

  @Override
  public void desktopLayout()
  {
    cleanup();
    panel.add(horizontalNavigation);
    layoutButtons(horizontalNavigation);
  }

  @Override
  public Widget asWidget()
  {
    return panel;
  }

  @Override
  public void addNavigation(String label, Command command)
  {
    buttons.add(new NavigationButton(SafeHtmlUtils.fromString(label), command));
  }
}
