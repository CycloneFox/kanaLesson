package client.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class Kana
{
  public static final String DOUBLE_LETTER = "doubleKonsonant";

  // vocals

  public static final Kana A = new Kana("A", "a", "あ", "ア");
  public static final Kana I = new Kana("I", "i", "い", "イ");
  public static final Kana U = new Kana("U", "u", "う", "ウ");
  public static final Kana E = new Kana("E", "e", "え", "エ");
  public static final Kana O = new Kana("O", "o", "お", "オ");

  // standard syllables

  public static final Kana KA = new Kana("KA", "ka", "か", "カ");
  public static final Kana KI = new Kana("KI", "ki", "き", "キ");
  public static final Kana KU = new Kana("KU", "ku", "く", "ク");
  public static final Kana KE = new Kana("KE", "ke", "け", "ケ");
  public static final Kana KO = new Kana("KO", "ko", "こ", "コ");

  public static final Kana SA = new Kana("SA", "sa", "さ", "サ");
  public static final Kana SHI = new Kana("SHI", "shi", "し", "シ");
  public static final Kana SU = new Kana("SU", "su", "す", "ス");
  public static final Kana SE = new Kana("SE", "se", "せ", "セ");
  public static final Kana SO = new Kana("SO", "so", "そ", "ソ");

  public static Kana TA = new Kana("TA", "ta", "た", "タ");
  public static Kana CHI = new Kana("CHI", "chi", "ち", "チ");
  public static Kana TSU = new Kana("TSU", "tsu", "つ", "ツ");
  public static Kana TE = new Kana("TE", "te", "て", "テ");
  public static Kana TO = new Kana("TO", "to", "と", "ト");

  public static Kana NA = new Kana("NA", "na", "な", "ナ");
  public static Kana NI = new Kana("NI", "ni", "に", "ニ");
  public static Kana NU = new Kana("NU", "nu", "ぬ", "ヌ");
  public static Kana NE = new Kana("NE", "ne", "ね", "ネ");
  public static Kana NO = new Kana("NO", "no", "の", "ノ");

  public static Kana HA = new Kana("HA", "ha", "は", "ハ");
  public static Kana HI = new Kana("HI", "hi", "ひ", "ヒ");
  public static Kana FU = new Kana("FU", "fu", "ふ", "フ");
  public static Kana HE = new Kana("HE", "he", "へ", "ヘ");
  public static Kana HO = new Kana("HO", "ho", "ほ", "ホ");

  public static Kana MA = new Kana("MA", "ma", "ま", "マ");
  public static Kana MI = new Kana("MI", "mi", "み", "ミ");
  public static Kana MU = new Kana("MU", "mu", "む", "ム");
  public static Kana ME = new Kana("ME", "me", "め", "メ");
  public static Kana MO = new Kana("MO", "mo", "も", "モ");

  public static Kana YA = new Kana("YA", "ya", "や", "ヤ");
  public static Kana YU = new Kana("YU", "yu", "ゆ", "ユ");
  public static Kana YO = new Kana("YO", "yo", "よ", "ヨ");

  public static Kana RA = new Kana("RA", "ra", "ら", "ラ");
  public static Kana RI = new Kana("RI", "ri", "り", "リ");
  public static Kana RU = new Kana("RU", "ru", "る", "ル");
  public static Kana RE = new Kana("RE", "re", "れ", "レ");
  public static Kana RO = new Kana("RO", "ro", "ろ", "ロ");

  public static Kana WA = new Kana("WA", "wa", "わ", "ワ");
  public static Kana WO = new Kana("WO", "wo", "を", "ヲ");

  // extra

  public static Kana N = new Kana("N", "n", "ん", "ン");

  // dakuten and handakuten

  public static Kana GA = new Kana("GA", "ga", "が", "ガ");
  public static Kana GI = new Kana("GI", "gi", "ぎ", "ギ");
  public static Kana GU = new Kana("GU", "gu", "ぐ", "グ");
  public static Kana GE = new Kana("GE", "ge", "げ", "ゲ");
  public static Kana GO = new Kana("GO", "go", "ご", "ゴ");

  public static Kana ZA = new Kana("ZA", "za", "ざ", "ザ");
  public static Kana Z_JI = new Kana("Z_JI", "ji", "じ", "ジ");
  public static Kana ZU = new Kana("ZU", "zu", "ず", "ズ");
  public static Kana ZE = new Kana("ZE", "ze", "ぜ", "ゼ");
  public static Kana ZO = new Kana("ZO", "zo", "ぞ", "ゾ");

  public static Kana DA = new Kana("DA", "da", "だ", "ダ");
  public static Kana D_JI = new Kana("D_JI", "ji", "ぢ", "ヂ");
  public static Kana D_ZU = new Kana("D_ZU", "zu", "づ", "ヅ");
  public static Kana DE = new Kana("DE", "de", "で", "デ");
  public static Kana DO = new Kana("DO", "do", "ど", "ド");

  public static Kana BA = new Kana("BA", "ba", "ば", "バ");
  public static Kana BI = new Kana("BI", "bi", "び", "ビ");
  public static Kana BU = new Kana("BU", "bu", "ぶ", "ブ");
  public static Kana BE = new Kana("BE", "be", "べ", "ベ");
  public static Kana BO = new Kana("BO", "bo", "ぼ", "ボ");

  public static Kana PA = new Kana("PA", "pa", "ぱ", "パ");
  public static Kana PI = new Kana("PI", "pi", "ぴ", "ピ");
  public static Kana PU = new Kana("PU", "pu", "ぷ", "プ");
  public static Kana PE = new Kana("PE", "pe", "ぺ", "ペ");
  public static Kana PO = new Kana("PO", "po", "ぽ", "ポ");

  // i-combos

  public static Kana KYA = new Kana("KYA", "kya", "きゃ", "キャ");
  public static Kana KYU = new Kana("KYU", "kyu", "きゅ", "キュ");
  public static Kana KYO = new Kana("KYO", "kyo", "きょ", "キョ");

  public static Kana NYA = new Kana("NYA", "nya", "にゃ", "ニャ");
  public static Kana NYU = new Kana("NYU", "nyu", "にゅ", "ニュ");
  public static Kana NYO = new Kana("NYO", "nyo", "にょ", "ニョ");

  public static Kana HYA = new Kana("HYA", "hya", "ひゃ", "ヒャ");
  public static Kana HYU = new Kana("HYU", "hyu", "ひゅ", "ヒュ");
  public static Kana HYO = new Kana("HYO", "hyo", "ひょ", "ヒョ");

  public static Kana MYA = new Kana("MYA", "mya", "みゃ", "ミャ");
  public static Kana MYU = new Kana("MYU", "myu", "みゅ", "ミュ");
  public static Kana MYO = new Kana("MYO", "myo", "みょ", "ミョ");

  public static Kana RYA = new Kana("RYA", "rya", "りゃ", "リャ");
  public static Kana RYU = new Kana("RYU", "ryu", "りゅ", "リュ");
  public static Kana RYO = new Kana("RYO", "ryo", "りょ", "リョ");

  public static Kana GYA = new Kana("GYA", "gya", "ぎゃ", "ギャ");
  public static Kana GYU = new Kana("GYU", "gyu", "ぎゅ", "ギュ");
  public static Kana GYO = new Kana("GYO", "gyo", "ぎょ", "ギョ");

  public static Kana BYA = new Kana("BYA", "bya", "びゃ", "ビャ");
  public static Kana BYU = new Kana("BYU", "byu", "びゅ", "ビュ");
  public static Kana BYO = new Kana("BYO", "byo", "びょ", "ビョ");

  public static Kana PYA = new Kana("PYA", "pya", "ぴゃ", "ピャ");
  public static Kana PYU = new Kana("PYU", "pyu", "ぴゅ", "ピュ");
  public static Kana PYO = new Kana("PYO", "pyo", "ぴょ", "ピョ");

  // sh/ch/j-combos

  public static Kana SHA = new Kana("SHA", "sha", "しゃ", "シャ");
  public static Kana SHU = new Kana("SHU", "shu", "しゅ", "シュ");
  public static Kana SHO = new Kana("SHO", "sho", "しょ", "ショ");

  public static Kana CHA = new Kana("CHA", "cha", "ちゃ", "チャ");
  public static Kana CHU = new Kana("CHU", "chu", "ちゅ", "チュ");
  public static Kana CHO = new Kana("CHO", "cho", "ちょ", "チョ");

  public static Kana SH_JA = new Kana("SH_JA", "ja", "じゃ", "ジャ");
  public static Kana SH_JU = new Kana("SH_JU", "ju", "じゅ", "ジュ");
  public static Kana SH_JO = new Kana("SH_JO", "jo", "じょ", "ジョ");

  public static Kana CH_JA = new Kana("CH_JA", "ja", "ぢゃ", "ヂャ");
  public static Kana CH_JU = new Kana("CH_JU", "ju", "ぢゅ", "ヂュ");
  public static Kana CH_JO = new Kana("CH_JO", "jo", "ぢょ", "ヂョ");

  // small tsu or in romaji double consonant for faster pronunciation of following syllable

  public static final Kana SMALL_TSU = new Kana("SMALL_TSU", DOUBLE_LETTER, "っ", "ッ");

  public static Kana[] A_ROW = new Kana[]{A, I, U, E, O};
  public static Kana[] KA_ROW = new Kana[]{KA, KI, KU, KE, KO};
  public static Kana[] SA_ROW = new Kana[]{SA, SHI, SU, SE, SO};
  public static Kana[] TA_ROW = new Kana[]{TA, CHI, TSU, TE, TO};
  public static Kana[] NA_ROW = new Kana[]{NA, NI, NU, NE, NO};
  public static Kana[] HA_ROW = new Kana[]{HA, HI, FU, HE, HO};
  public static Kana[] MA_ROW = new Kana[]{MA, MI, MU, ME, MO};
  public static Kana[] YA_ROW = new Kana[]{YA, YU, YO};
  public static Kana[] RA_ROW = new Kana[]{RA, RI, RU, RE, RO};
  public static Kana[] WA_ROW = new Kana[]{WA, WO};

  public static Kana[] N_ROW = new Kana[]{N};

  public static Kana[] STANDARD_KANA = combine(A_ROW, KA_ROW, SA_ROW, TA_ROW, NA_ROW, HA_ROW, MA_ROW, YA_ROW, RA_ROW, WA_ROW, N_ROW);

  public static Kana[] GA_ROW = new Kana[]{GA, GI, GU, GE, GO};
  public static Kana[] ZA_ROW = new Kana[]{ZA, Z_JI, ZU, ZE, ZO};
  public static Kana[] DA_ROW = new Kana[]{DA, D_JI, D_ZU, DE, DO};
  public static Kana[] BA_ROW = new Kana[]{BA, BI, BU, BE, BO};
  public static Kana[] PA_ROW = new Kana[]{PA, PI, PU, PE, PO};

  public static Kana[] DAKUTEN_KANA = combine(GA_ROW, ZA_ROW, DA_ROW, BA_ROW, PA_ROW);

  public static Kana[] KYA_ROW = new Kana[]{KYA, KYU, KYO};
  public static Kana[] NYA_ROW = new Kana[]{NYA, NYU, NYO};
  public static Kana[] HYA_ROW = new Kana[]{HYA, HYU, HYO};
  public static Kana[] MYA_ROW = new Kana[]{MYA, MYU, MYO};
  public static Kana[] RYA_ROW = new Kana[]{RYA, RYU, RYO};
  public static Kana[] GYA_ROW = new Kana[]{GYA, GYU, GYO};
  public static Kana[] BYA_ROW = new Kana[]{BYA, BYU, BYO};
  public static Kana[] PYA_ROW = new Kana[]{PYA, PYU, PYO};

  public static Kana[] IYA_KANA = combine(KYA_ROW, NYA_ROW, HYA_ROW, MYA_ROW, RYA_ROW, GYA_ROW, BYA_ROW, PYA_ROW);

  public static Kana[] SHA_ROW = new Kana[]{SHA, SHU, SHO};
  public static Kana[] CHA_ROW = new Kana[]{CHA, CHU, CHO};
  public static Kana[] SH_JA_ROW = new Kana[]{SH_JA, SH_JU, SH_JO};
  public static Kana[] CH_JA_ROW = new Kana[]{CH_JA, CH_JU, CH_JO};

  public static Kana[] SHCHJ_KANA = combine(SHA_ROW, CHA_ROW, SH_JA_ROW, CH_JA_ROW);

  public static Kana[] ALL_KANA = combine(STANDARD_KANA, DAKUTEN_KANA, IYA_KANA, SHCHJ_KANA);

  public static Kana[][][] ALL_KANA_IN_GROUPS = new Kana[][][]{
    {A_ROW, KA_ROW, SA_ROW, TA_ROW, NA_ROW, HA_ROW, MA_ROW, YA_ROW, RA_ROW, WA_ROW, N_ROW},
    {GA_ROW, ZA_ROW, DA_ROW, BA_ROW, PA_ROW},
    {KYA_ROW, NYA_ROW, HYA_ROW, MYA_ROW, RYA_ROW, GYA_ROW, BYA_ROW, PYA_ROW},
    {SHA_ROW, CHA_ROW, SH_JA_ROW, CH_JA_ROW}
  };

  private static Kana[] combine(Kana[]... kanaRows)
  {
    List<Kana> combination = new ArrayList<Kana>();
    for(Kana[] kanaRow : kanaRows)
    {
      combination.addAll(Arrays.asList(kanaRow));
    }
    return combination.toArray(new Kana[combination.size()]);
  }

  private final String key;
  private final String romaji;
  private final String hiragana;
  private final String katakana;

  private Kana(String key, String romaji, String hiragana, String katakana)
  {
    this.key = key;
    this.romaji = romaji;
    this.hiragana = hiragana;
    this.katakana = katakana;
  }

  public String getRomaji()
  {
    return romaji;
  }

  public String getHiragana()
  {
    return hiragana;
  }

  public String getKatakana()
  {
    return katakana;
  }

  public String get(Writing writing)
  {
    if(writing == null)
    {
      return null;
    }
    switch(writing)
    {
      case ROMAJI:
        return getRomaji();
      case HIRAGANA:
        return getHiragana();
      case KATAKANA:
        return getKatakana();
      default:
        return null;
    }
  }

  public static Kana getKanaBy(String value, Writing writing)
  {
    if(value == null)
    {
      return null;
    }
    for(Kana kana : ALL_KANA)
    {
      if(kana.get(writing).trim().toLowerCase().equals(value.trim().toLowerCase()))
      {
        return kana;
      }
    }
    return null;
  }

  public static Kana getKanaByKey(String selectedKey)
  {
    if(selectedKey == null)
    {
      return null;
    }
    for(Kana kana : ALL_KANA)
    {
      if(kana.getKey().equals(selectedKey))
      {
        return kana;
      }
    }
    return null;
  }

  public static Collection<String> getAllOf(Writing writing)
  {
    Collection<String> writings = new ArrayList<String>();
    for(Kana kana : ALL_KANA)
    {
      writings.add(kana.get(writing));
    }
    return writings;
  }

  public String getKey()
  {
    return key;
  }

  @Override
  public String toString()
  {
    return romaji + "(" + hiragana + "/" + katakana + ")";
  }

  public static Collection<String> romajiOf(Kana... kanas)
  {
    Collection<String> romajis = new ArrayList<String>();
    for(Kana kana : kanas)
    {
      romajis.add(kana.getRomaji());
    }
    return romajis;
  }
}
