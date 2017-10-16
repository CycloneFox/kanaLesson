package client;

import client.logic.Kana;
import client.presentation.ExerciseArea;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class KanaLesson
  implements EntryPoint
{
  public void onModuleLoad()
  {
    RootPanel.get().add(new ExerciseArea(Kana.ALL_KANA));
  }
}
