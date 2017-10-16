package client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kana
{
  public static Kana A = new Kana("あ", "a");
  public static Kana I = new Kana("い", "i");
  public static Kana U = new Kana("う", "u");
  public static Kana E = new Kana("え", "e");
  public static Kana O = new Kana("お", "o");

  public static Kana KA = new Kana("か", "ka");
  public static Kana KI = new Kana("き", "ki");
  public static Kana KU = new Kana("く", "ku");
  public static Kana KE = new Kana("け", "ke");
  public static Kana KO = new Kana("こ", "ko");

  public static Kana SA = new Kana("さ", "sa");
  public static Kana SHI = new Kana("し", "shi");
  public static Kana SU = new Kana("す", "su");
  public static Kana SE = new Kana("せ", "se");
  public static Kana SO = new Kana("そ", "so");

  public static Kana TA = new Kana("た", "ta");
  public static Kana CHI = new Kana("ち", "chi");
  public static Kana TSU = new Kana("つ", "tsu");
  public static Kana TE = new Kana("て", "te");
  public static Kana TO = new Kana("と", "to");

  public static Kana NA = new Kana("な", "na");
  public static Kana NI = new Kana("に", "ni");
  public static Kana NU = new Kana("ぬ", "nu");
  public static Kana NE = new Kana("ね", "ne");
  public static Kana NO = new Kana("の", "no");

  public static Kana HA = new Kana("は", "ha");
  public static Kana HI = new Kana("ひ", "hi");
  public static Kana FU = new Kana("ふ", "fu");
  public static Kana HE = new Kana("へ", "he");
  public static Kana HO = new Kana("ほ", "ho");

  public static Kana MA = new Kana("ま", "ma");
  public static Kana MI = new Kana("み", "mi");
  public static Kana MU = new Kana("む", "mu");
  public static Kana ME = new Kana("め", "me");
  public static Kana MO = new Kana("も", "mo");

  public static Kana YA = new Kana("や", "ya");
  public static Kana YU = new Kana("ゆ", "yu");
  public static Kana YO = new Kana("よ", "yo");

  public static Kana RA = new Kana("ら", "ra");
  public static Kana RI = new Kana("り", "ri");
  public static Kana RU = new Kana("る", "ru");
  public static Kana RE = new Kana("れ", "re");
  public static Kana RO = new Kana("ろ", "ro");

  public static Kana WA = new Kana("わ", "wa");
  public static Kana WO = new Kana("を", "wo");

  public static Kana N = new Kana("ん", "n");

  public static Kana[] A_ROW = new Kana[]{A, I, U, E, O};
  public static Kana[] KA_ROW = new Kana[]{KA, KI, KU, KE, KO};
  public static Kana[] SA_ROW = new Kana[]{SA, SHI, SU, KE, KO};
  public static Kana[] TA_ROW = new Kana[]{TA, CHI, TSU, TE, TO};
  public static Kana[] NA_ROW = new Kana[]{NA, NI, NU, NE, NO};
  public static Kana[] HA_ROW = new Kana[]{HA, HI, FU, HE, HO};
  public static Kana[] MA_ROW = new Kana[]{MA, MI, MU, ME, MO};
  public static Kana[] YA_ROW = new Kana[]{YA, YU, YO};
  public static Kana[] RA_ROW = new Kana[]{RA, RI, RU, RE, RO};
  public static Kana[] WA_ROW = new Kana[]{WA, WO};
  public static Kana[] N_ROW = new Kana[]{N};

  public static Kana[] ALL_HIRAGANA = combine(
      A_ROW, KA_ROW, SA_ROW, TA_ROW, NA_ROW, HA_ROW, MA_ROW, YA_ROW, RA_ROW, WA_ROW, N_ROW);

  private static Kana[] combine(Kana[]... kanaRows)
  {
    List<Kana> combination = new ArrayList<Kana>();
    for(Kana[] kanaRow : kanaRows)
    {
      combination.addAll(Arrays.asList(kanaRow));
    }
    return combination.toArray(new Kana[combination.size()]);
  }

  private final String kana;
  private final String romaji;

  private Kana(String kana, String romaji)
  {
    this.kana = kana;
    this.romaji = romaji;
  }

  public String getKana()
  {
    return kana;
  }

  public String getRomaji()
  {
    return romaji;
  }
}
