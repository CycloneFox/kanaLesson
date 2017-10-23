/*
 * Copyright (c) 2017 conLeos GmbH. All Rights reserved.
 * <p/>
 * This software is the confidential intellectual property of conLeos GmbH; it is copyrighted and licensed.
 */
package client.view;

import client.presentation.layout.MainPage;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MainPageViewImpl
  implements MainPage.View
{
  private boolean mobile;

  private VerticalPanel panel;

  private Widget header;
  private Widget navigation;
  private Widget content;
  private Widget footer;

  public MainPageViewImpl()
  {
    panel = new VerticalPanel();
    HTML testHeader = new HTML();
    testHeader.getElement().setAttribute("background-color", "red");
    HTML testNavi = new HTML();
    testNavi.getElement().setAttribute("background-color", "green");
    HTML testContent = new HTML();
    testContent.getElement().setAttribute("background-color", "blue");
    HTML testFooter = new HTML();
    testFooter.getElement().setAttribute("background-color", "yellow");
    panel.add(testHeader);
    panel.add(testNavi);
    panel.add(testContent);
    panel.add(testFooter);
    desktopLayout();
  }

  @Override
  public void mobileLayout()
  {
    mobile = true;
    layout();
  }

  @Override
  public void desktopLayout()
  {
    mobile = false;
    layout();
  }

  private void layout()
  {

  }

  // static?
  @Override
  public void setHeader(Widget widget)
  {
    header = widget;
  }

  // static?
  @Override
  public void setNavigation(Widget widget)
  {
    navigation = widget;
  }

  // static?
  @Override
  public void setFooter(Widget widget)
  {
    footer = widget;
  }

  // not static?
  @Override
  public void setContent(Widget widget)
  {
    content = widget;
  }

  @Override
  public void setWidth(int width)
  {
    panel.setWidth(width + "px");
  }

  @Override
  public Widget asWidget()
  {
    return panel.asWidget();
  }
}
