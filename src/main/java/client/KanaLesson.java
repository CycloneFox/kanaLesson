package client;

import client.logic.Kana;
import client.presentation.KanaSelection.KanaSelectionGrid;
import client.presentation.exercise.ExerciseArea;
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
    ExerciseArea exerciseArea = new ExerciseArea(Kana.ALL_KANA);
    KanaSelectionGrid kanaSelectionGrid = new KanaSelectionGrid();
    verticalPanel.add(exerciseArea);
    verticalPanel.add(kanaSelectionGrid);

    RootPanel.get().add(verticalPanel);
  }
}
