package client.presentation.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import client.logic.Kana;
import client.presentation.common.Presenter;
import client.presentation.events.KanaSelectionEvent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Logical presentation of an are, which shows random kanas and a text-field for users to input their guesses, which romaji the current kana stands for.
 */
public class ExerciseArea extends Presenter<ExerciseArea.View>
{
  /**
   * the remaining kana to be solved during this exercise
   */
  private final List<Kana> remainingKana;

  /**
   * currently shown kana
   */
  private Kana currentKana;

  /**
   * all kanas this excercising area alternates between
   */
  private Kana[] kanas;

  public interface View extends IsWidget
  {
    void showKana(String kana);

    void setGuessAction(Command guessAction);

    String getGuess();

    void clearGuess();

    void focus();
  }

  public ExerciseArea(Kana... kanas)
  {
    super(GWT.<View>create(View.class));
    this.kanas = kanas;
    this.remainingKana = new ArrayList<Kana>();

    getView().setGuessAction(new Command()
    {
      public void execute()
      {
        takeGuess();
      }
    });

    getEventBus().addHandler(KanaSelectionEvent.TYPE, new KanaSelectionEvent.Handler()
    {
      public void onSelectionEvent(Kana[] selectedKana)
      {
        setKanas(selectedKana);
        remainingKana.clear();
        nextExercise();
      }
    });
  }

  private void takeGuess()
  {
    if (currentKana == null)
    {
      return;
    }

    String guess = getView().getGuess();
    if(guess == null)
    {
      return;
    }

    if(guess.toLowerCase().trim().equals(currentKana.getRomaji()))
    {
      getView().clearGuess();
      remainingKana.remove(currentKana);
      nextExercise();
    }
  }

  @Override
  protected void onShow()
  {
    super.onShow();

    nextExercise();

    getView().focus();
  }

  public void nextExercise()
  {
    if(remainingKana.isEmpty())
    {
      remainingKana.addAll(Arrays.asList(kanas));
    }

    int randomKanaIndex = (int) (Math.random() * remainingKana.size());

    currentKana = remainingKana.get(randomKanaIndex);

    getView().showKana(currentKana.getHiragana());
  }

  public void setKanas(Kana[] kanas)
  {
    this.kanas = kanas;
  }
}
