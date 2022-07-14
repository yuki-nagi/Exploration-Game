package object;

import java.util.Scanner;

public class Book extends GameObject {
	private boolean knowSacrifice = false;
	private boolean knowRitual = false;
	private boolean hasRat = false;
	
	//このクラスの breaked はWindowクラスの devil のフラグになっている
	//（作成当時この本を壊す予定がなかった為、breakedフラグを代わりに使用している。
	//なので、更新でbreaked を本来の用途で使用する場合は別の方法でフラグを繋げること。。
	

	@Override
	public void mebosiEvent() {
		System.out.println("何かの革で装丁された物々しさを感じる本だ。");
		
	}

	@Override
	public void breakEvent() {
		System.out.println("破くのは難しそうだ。");
	}

	@Override
	public void lookEvent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("「悪魔召喚の禁呪」というタイトルの本のようだ……。");
		setLookChecked(true);
		if(this.isBreaked() == true) {
			System.out.println("もう禍々しい力はこの本から感じられなくなっている。");
		}
		else if(this.isBreaked() == false) {
			System.out.println("");
			System.out.println("中身を読みますか？");
			System.out.println("1: はい 2: いいえ");
			int choice1 = sc.nextInt();
			if(choice1 == 1) {
				System.out.println("「悪魔召喚の禁呪」を読み進めた");
				System.out.println("何か「魂を持つ生き物」さえ生贄に捧げれば呼び出せるらしい。");
				if(this.knowSacrifice == false) {
					System.out.println("☆--「生贄」の知識を得ました--☆");
					setKnowSacrifice(true);
				}
				System.out.println("");
				System.out.println("続きを読みますか？");
				System.out.println("1: はい 2: いいえ");
				int choice2 = sc.nextInt();
				if(choice2 == 1) {
					System.out.println("「悪魔召喚の禁呪」を読み進めた");
					System.out.println("悪魔がいれば願いが叶えられることが書かれている。");
					System.out.println("続きを、続き、を読まなければ――");
					System.out.println("");
					System.out.println("1:続きを読む 2:本を閉じる");
					int choice3 = sc.nextInt();
					if(choice3 == 1) {
						System.out.println("「悪魔召喚の禁呪」をさらに読み進めた。");
						System.out.println("生き物を準備して儀式(retual)をすれば呼び出せそうだ。");
						if(this.knowRitual == false) {
							System.out.println("☆--悪魔召喚の方法を修得した--☆");
							setKnowRitual(true);
						}
						System.out.println("");
						System.out.println("ハハハ、続きを……。ツヅキを、ヨマなキャ……");
						System.out.println("1.続きを読む 2:本を閉じる");
						int choice4 = sc.nextInt();
						if(choice4 == 1) {
							System.out.println("「悪魔召喚の禁呪」を最後まで読んだ。");
							System.out.println("悪魔の魅力に捕らわれた探索者は、その場で悪魔を呼び出す儀式を始めた。");
							if(hasRat == true) {
								System.out.println("捕まえていたネズミが一際甲高く鳴いた次の瞬間、動かなくなった。");
								System.out.println("……窓の外に気配を感じる。");
								setBreaked(true);
							}
							if(hasRat == false) {
								System.out.println("素晴らしい悪魔の呼び声が聞こえた。");
								System.out.println("「ご苦労。その魂、その檻から救済してやろう」");
								System.out.println("歓喜に包まれながら、探索者の魂は一瞬で悪魔に食われた。");
								this.setLoopBreak(true);
							}
						}
					}
				}
			}
		}
		
	}
	
	public boolean isKnowSacrifice() {
		return this.knowSacrifice;
	}
	
	public void setKnowSacrifice(boolean knowSacrifice) {
		this.knowSacrifice = knowSacrifice;
	}
	
	public boolean isKnowRitual() {
		return knowRitual;
	}
	
	public void setKnowRitual(boolean knowRitual) {
		this.knowRitual = knowRitual;
	}
	
	public boolean isHasRat() {
		return this.hasRat;
	}
	
	public void setHasRat(boolean hasRat) {
		this.hasRat = hasRat;
	}

}
