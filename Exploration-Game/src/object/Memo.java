package object;

public class Memo extends GameObject{
	
	public void mebosiEvent() {
		if(isBreaked() == false) {
			System.out.println("スケジュール帳を破ったのだろうか、ずいぶんと切れ方の荒っぽいメモだ。");
		}
		else if(isBreaked() == true) {
			System.out.println("ぐちゃぐちゃに丸めたメモだ。");
		}
	}
	public void lookEvent() {
		if(isBreaked() == false) {
			System.out.println("「ここに呼ばれた不運な君へ」");
			System.out.println("「出口は2つある。私は扉の先で、彼女の名を知るお前を待つ。」");
			System.out.println("「そうでなければ窓から外のどこへでも行くといい。お前が翼を持つなら、の話だが。」");
			setLookChecked(true);
		}
		else if(isBreaked() == true) {
			System.out.println("メモが丸められている。");
			if(isLookChecked() == true) {
				System.out.println("たしか「出口は2つある」「扉の先で、彼女の名を知るお前を待つ」と書いてあったな。");
				System.out.println("「窓の外」は流石に煽り文だと思うが……。扉を開くことが難しければ、そちらも考えないといけないだろう。");
			}
		}
	}
	public void breakEvent() {
		if(isBreaked() == false) { 
			System.out.println("メモを握りつぶした");
			setBreaked(true);
		}
		else if(isBreaked() == true) {
			if(isLookChecked() == true) {
				System.out.println("ここから出る方法を考えながら、丸まったメモを握った");
			}
			else if(isLookChecked() == false) {
				System.out.println("イライラを鎮める為に、丸まったメモを再度握った");
			}
		}
	}
	

}
