package client.view;

import client.presentation.layout.MainPage;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MainPageViewImpl
  implements MainPage.View
{
  private VerticalPanel mainArea;

  private final Panel headerArea;
  private final Panel naviArea;
  private final Panel contentArea;
  private final Panel footerArea;

  public MainPageViewImpl()
  {
    mainArea = new VerticalPanel();
    mainArea.addStyleName("mainArea");

    headerArea = new VerticalPanel();
    headerArea.addStyleName("headerArea");
    headerArea.addStyleName("hasPadding");
    naviArea = new VerticalPanel();
    naviArea.addStyleName("naviArea");
    naviArea.addStyleName("hasBorder");
    contentArea = new VerticalPanel();
    contentArea.addStyleName("contentArea");
    contentArea.addStyleName("hasPadding");
    contentArea.addStyleName("hasBorder");
    footerArea = new VerticalPanel();
    footerArea.addStyleName("footerArea");
    footerArea.addStyleName("hasBorder");
    footerArea.addStyleName("hasPadding");

    mainArea.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);

    mainArea.add(headerArea);
    mainArea.setCellHeight(headerArea, "50px");
    mainArea.add(naviArea);
    mainArea.setCellHeight(naviArea, "50px");
    mainArea.add(contentArea);
    mainArea.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
    mainArea.add(footerArea);
  }

  @Override
  public void mobileLayout()
  {
    mainArea.addStyleName("mobile");
    headerArea.addStyleName("mobile");
  }

  @Override
  public void desktopLayout()
  {
    mainArea.removeStyleName("mobile");
    headerArea.removeStyleName("mobile");
  }

  @Override
  public void setHeader(Widget widget)
  {
    headerArea.clear();
    headerArea.add(widget);
  }

  @Override
  public void setNavigation(Widget widget)
  {
    naviArea.clear();
    naviArea.add(widget);
  }

  @Override
  public void setFooter(Widget widget)
  {
    footerArea.clear();
    footerArea.add(widget);
  }

  @Override
  public void setHeight(int height)
  {
    mainArea.setHeight(height + "px");
  }

  @Override
  public void setContent(Widget widget)
  {
    contentArea.clear();
    contentArea.add(widget);
  }

  @Override
  public Widget asWidget()
  {
    return mainArea.asWidget();
  }
}
