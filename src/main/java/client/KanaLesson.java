package client;

import client.logic.Kana;
import client.presentation.exercise.ExerciseArea;
import client.presentation.settings.SettingsArea;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class KanaLesson
  implements EntryPoint
{
  public void onModuleLoad()
  {
    // todo responsive layout?
    VerticalPanel verticalPanel = new VerticalPanel();
    verticalPanel.setWidth("100%");
    ExerciseArea exerciseArea = new ExerciseArea(Kana.ALL_KANA);
    verticalPanel.add(new SettingsArea());
    verticalPanel.add(exerciseArea);

    RootPanel.get().add(verticalPanel);

//    RootPanel.get().add(new MainPage().asWidget());
  }
}
