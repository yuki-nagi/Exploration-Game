package object;

public class Desk extends GameObject{

	@Override
	public void mebosiEvent() {
		System.out.println("引き出しのないシンプルな机だ。上に分厚い日記帳(Diary)のようなものがある");
		this.setMebosiChecked(true);
		
	}

	@Override
	public void breakEvent() {
		System.out.println("机を上から殴りつけたが、壊れる気配がない。頑丈な良い天板だ。");
		
	}

	@Override
	public void lookEvent() {
		System.out.println("引き出しのないシンプルな机だ。分厚い日記帳（Diary）の他に物は置いてない。");
		System.out.println("よく見ると天板の端に「32145」と書かれた付箋が貼られている。");
		System.out.println("何かのパスワード? それとも順序だろうか？");
		this.setLookChecked(true);
	}

}
