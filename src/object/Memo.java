package object;

public class Memo
  extends GameObject {
  public void mebosiEvent() {
    if (!isBreaked()) {
      System.out.println("スケジュール帳を破ったのだろうか、ずいぶんと切れ方の荒っぽいメモだ。");
    }
    else if (isBreaked()) {
      System.out.println("ぐちゃぐちゃに丸めたメモだ。");
    } 
  }
  public void lookEvent() {
    if (!isBreaked()) {
      System.out.println("「私に選ばれた優秀な探索者へ。」");
      System.out.println("「唯一の扉から出たいなら、2つの魔法で人になった彼女の正体を知ることだ。」");
      System.out.println("「それが出来ないなら、窓から出るしかない。君が翼を持つのなら、だが。」");
      setLookChecked(true);
    }
    else if (isBreaked()) {
      System.out.println("メモが丸められている。");
      if (isLookChecked()) {
        System.out.println("たしか「扉から出たいなら、2つの魔法で人になった彼女の正体を知ることだ」と書いてあったな。");
        System.out.println("「窓から外に」は流石に煽り文だと思うが……。扉を開くことが難しければ、そちらも考えないといけないだろう。");
      } 
    } 
  }
  public void breakEvent() {
     if (!isBreaked()) {
       System.out.println("メモを握りつぶした。");
       setBreaked(true);
    }
     else if (isBreaked()) {
       if (isLookChecked()) {
         System.out.println("ここから出る方法を考えながら、丸まったメモを握った。");
      }
       else if (!isLookChecked()) {
         System.out.println("イライラを鎮める為に、丸まったメモを再度握った。");
      } 
    } 
  }
}
