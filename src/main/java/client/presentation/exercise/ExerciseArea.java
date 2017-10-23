package client.presentation.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import client.logic.Kana;
import client.logic.Writing;
import client.presentation.common.ButtonHandle;
import client.presentation.common.Presenter;
import client.presentation.events.KanaSelectionEvent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Widget;
import org.jadice.web.gwt.fontawesome.client.FontAwesome;

/**
 * Logical presentation of an are, which shows random kanas and a text-field for users to input their guesses, which romaji the current kana stands for.
 */
public class ExerciseArea extends Presenter<ExerciseArea.View>
{
  public static final SafeHtml HIRAGANA_BUTTON_LABEL = SafeHtmlUtils.fromTrustedString(Kana.HI.getHiragana());
  public static final SafeHtml KATAKANA_BUTTON_LABEL = SafeHtmlUtils.fromTrustedString(Kana.KA.getKatakana());
  public static final SafeHtml HIRAGANA_OR_KATAKANA_BUTTON_LABEL = SafeHtmlUtils.fromTrustedString("?");
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
  private Collection<Kana> kanas;
  private final ButtonHandle hiraKataToggle;
  private final KanaSelectionGrid kanaSelectionGrid;

  public interface View extends Presenter.View
  {
    void removeOverlay();

    void overlayArea(Widget widget);

    ButtonHandle addBigFontButton();

    void showKana(String kana);

    void setGuessAction(Command guessAction);

    String getGuess();

    void clearGuess();

    void focus();

    void setFeedBack(String feedback);
  }

  private boolean displaySelection;

  private Writing writing;

  public ExerciseArea(Kana... kanas)
  {
    super(GWT.<View>create(View.class));
    this.displaySelection = false;
    this.kanas = Arrays.asList(kanas);
    this.remainingKana = new ArrayList<Kana>();
    this.writing = Writing.HIRAGANA;

    getView().setGuessAction(new Command()
    {
      public void execute()
      {
        takeGuess();
      }
    });

    getEventBus().addHandler(KanaSelectionEvent.TYPE, new KanaSelectionEvent.Handler()
    {
      public void onSelectionEvent(Collection<Kana> selectedKana)
      {
        setKanas(selectedKana);
        remainingKana.clear();
        nextExercise();
      }
    });

    kanaSelectionGrid = new KanaSelectionGrid();
    ButtonHandle kanaSelection = getView().addBigFontButton();
    kanaSelection.setLabel(FontAwesome.BARS.toSafeHtml());
    kanaSelection.setAction(new Command()
    {
      @Override
      public void execute()
      {
        toggleKanaSelection();
      }
    });
    hiraKataToggle = getView().addBigFontButton();
    hiraKataToggle.setLabel(HIRAGANA_BUTTON_LABEL);
    hiraKataToggle.setAction(new Command()
    {
      @Override
      public void execute()
      {
        toggleKanaWriting();
      }
    });
  }

  private void toggleKanaSelection()
  {
    if(displaySelection)
    {
      getView().removeOverlay();
    }
    else
    {
      getView().overlayArea(kanaSelectionGrid.asWidget());
    }
    displaySelection = !displaySelection;
  }

  private void toggleKanaWriting()
  {
    if(Writing.HIRAGANA.equals(writing))
    {
      writing = Writing.KATAKANA;
      hiraKataToggle.setLabel(KATAKANA_BUTTON_LABEL);
    }
    else if(Writing.KATAKANA.equals(writing))
    {
      writing = null;
      hiraKataToggle.setLabel(HIRAGANA_OR_KATAKANA_BUTTON_LABEL);
    }
    else
    {
      writing = Writing.HIRAGANA;
      hiraKataToggle.setLabel(HIRAGANA_BUTTON_LABEL);
    }
    updateKanaView();
  }

  public void setWriting(Writing writing)
  {
    this.writing = writing;
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
      remainingKana.addAll(kanas);
    }

    int randomKanaIndex = (int) (Math.random() * remainingKana.size());

    currentKana = remainingKana.get(randomKanaIndex);

    getView().setFeedBack(kanas.size() - remainingKana.size() + 1 + "/" + kanas.size());
    updateKanaView();
  }

  private void updateKanaView()
  {
    Writing selected = writing != null ? writing :  Math.random() >= 0.5 ? Writing.HIRAGANA : Writing.KATAKANA;
    String kanaInWriting = Writing.HIRAGANA.equals(selected) ? currentKana.getHiragana() : currentKana.getKatakana();
    getView().showKana(kanaInWriting);
  }

  public void setKanas(Collection<Kana> kanas)
  {
    this.kanas = kanas.isEmpty() ? KanaSelectionGrid.DEFAULT_SELECTION :  kanas;
  }
}
