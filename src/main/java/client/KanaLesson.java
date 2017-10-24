package client;

import client.presentation.layout.MainPage;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class KanaLesson
  implements EntryPoint
{
  public void onModuleLoad()
  {
//    VerticalPanel verticalPanel = new VerticalPanel();
//    verticalPanel.setWidth("100%");
//    ExerciseArea exerciseArea = new ExerciseArea(Kana.ALL_KANA);
//    verticalPanel.add(new SettingsArea());
//    verticalPanel.add(exerciseArea);
//
//    RootPanel.get().add(verticalPanel);

    RootPanel.get().add(new MainPage());
  }
}
