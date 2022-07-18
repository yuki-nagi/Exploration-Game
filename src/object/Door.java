package object;

public class Door extends GameObject {
	// breaked フラグを、Diaryの鍵ゲットフラグ（代わりのbreakedフラグ）に対応して、Adv経由でsetします。

	public void mebosiEvent() {
		if(this.isBreaked() == false){
			System.out.println("錠と取っ手がついた木製のドアだ。道具もなしに壊すのは難しそうだ。");
		}
		else if(this.isBreaked() == true){
			System.out.println("錠と取っ手のついた木製のドアだ。");
			System.out.println("今なら鍵で開けるだろう。");
		}
	}
	
	public void lookEvent() {
		System.out.println("錠と取っ手がついた木製のドアだ。");
		if(this.isBreaked() == false){
			System.out.println("この錠は鍵があれば開きそうだが……。それにしても、内側に錠が必要な構造というのも不思議なものだ。");
		}
		else if(this.isBreaked() == true){
			System.out.println("この鍵でドアは開けられるだろう。それにしても、内側に錠が必要な構造というのも不思議なものだ。");
		}
	}

	public void breakEvent() {
		if(this.isBreaked() == false){
			System.out.println("殴ろうとも体当たりしてもびくともしない。");
			System.out.println("見た目以上に頑丈な扉だ。");
		}
		else if(this.isBreaked() == true){
			System.out.println("鍵は手に入った。壊さずとも、もう開けることが出来るだろう。");
		}
	}

}
