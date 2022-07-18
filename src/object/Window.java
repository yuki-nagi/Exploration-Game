package object;

import java.util.Scanner;

public class Window extends GameObject {
  Scanner sc = new Scanner(System.in);

  // 悪魔が召喚されているかどうかの特別フィールド
  boolean devil = false;

  
  public void mebosiEvent() {
    if (!isBreaked()) {
      System.out.println("大きな窓だ。少し汚れている。壊すこと自体は容易だろう。");
      if (isDevil()) {
        System.out.println("……窓の外に気配を感じる。");
      }
    }
    else if (isBreaked()) {
      System.out.println("大きな窓だが割れている。風が入ってきている。");
      if (isDevil()) {
        System.out.println("……窓の外に黒い翼を持った存在がいる。");
        System.out.println("悪魔は願いを叶える存在だ。目を見てちゃんと願えば、ここから出してもらえるだろう。");
      } 
    } 
  }
  
  public void lookEvent() {
    if (!isBreaked()) {
      if (!isLookChecked()) {
        System.out.println("大きな窓だ。少し汚れている。外を見ると5階以上の高さはあるだろうか。");
        System.out.println("下のほうは森になっているが、この高さではここから落ちても助からないだろう。");
        if (isDevil()) {
          System.out.println("窓の外に黒い何かがいるのが分かる。");
        }
        setLookChecked(true);
      }
      else if (isLookChecked()) {
        System.out.println("大きな窓だ。5階以上のこの高さではここから脱出するのは難しそうだ。");
        if (isDevil()) {
          System.out.println("窓の外に黒い何かがいる。");
        }
      }
    
    } else if (isBreaked()) {
      if (isDevil()) {
        System.out.println("窓の外の悪魔が手を差し伸べる");
        System.out.println("「あんな小さい魂で我をこき使うとはな。……まあ良い、外に出すだけならやってやろう」");
        System.out.println("悪魔の笑みに企みを感じた探索者は、契約を注意深く確認してから悪魔の契約に同意した。");
        System.out.println("「落として殺すな？ ……ちぃ、小賢しいやつだ。」");
        System.out.println("悪魔の手を取り、探索者は窓から外へ出た。");
        setLoopBreak(true);
      }
      else if (!isLookChecked()) {
        System.out.println("大きな窓だが割れている。風が入ってきている。");
        System.out.println("身を乗り出すことは出来るが、5階以上の高さのあるこの位置から飛び降りても助からないだろう。");
        setLookChecked(true);
      }
      else if (isLookChecked()) {
        System.out.println("割れた窓から風が入ってきている。5階以上のこの高さではここから飛び降りても助からないだろう。");
      } 
    } 
  }

  
  public void breakEvent() {
    if (!isBreaked()) {
      
      System.out.println("大きな窓だが、壊すこと自体は容易だろう。");
      System.out.println("壊しますか？");
      System.out.println("1:はい 2:いいえ");
      String breakChoice = this.sc.next();
      if (breakChoice.equals("1")) {
        System.out.println("大きな窓を殴り壊した。");
        setBreaked(true);
        setLookChecked(false);
      }
    
    }
    else if (isBreaked()) {
      System.out.println("もう割ってしまった。");
    } 
  }
  
  public boolean isDevil() {
    return this.devil;
  }
  
  public void setDevil(boolean devil) {
    this.devil = devil;
  }
}