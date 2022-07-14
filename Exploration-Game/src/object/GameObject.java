package object;

public abstract class GameObject extends GameObjectSouce{
	// mebosiChecked は mebosi コマンドをGameObjectに使用済みかどうかをチェックする為のフラグ。
	// lookChecked も同様。
	// 二回目に調べた時に記述を短くしたい、（初発見時は細かく記述したい）場合などに使用出来る。
	
	// breaked は BreakコマンドによってGameObjectが壊されているかどうかをチェックする為のフラグ。
	// 基本的には本来の用途で使うべきだが、壊せないものに関しては別の用途のフラグとして使用して可（コメントは残すこと）
	
	// loopBreak は mainloop でGSを変える（エンディングorゲームオーバー）に繋げる場面でのみ使用。例外は認めない。
	// loopBreak を受け取ったmainloop側でGSの切り替え処理を記述する必要あり。
	
	private boolean mebosiChecked = false;
	private boolean lookChecked = false;
	private boolean breaked = false;
	private boolean loopBreak = false;
	
	
	//それぞれ、sercherクラスの mebosi break look メソッドによって参照される。(厳密にはこの継承元のGameObjectSouce型を指定)
	
	public abstract void mebosiEvent();
	
	public abstract void breakEvent();
	
	public abstract void lookEvent();
	
	
	
	// 以下、フィールドの値に関するsetterとgetter
	
	
	public boolean isMebosiChecked() {
		return mebosiChecked;
	}
	
	public void setMebosiChecked(boolean mebosiChecked) {
		this.mebosiChecked = mebosiChecked;
	}

	public boolean isLookChecked() {
		return lookChecked;
	}

	public void setLookChecked(boolean lookChecked) {
		this.lookChecked = lookChecked;
	}
	
	public boolean isBreaked() {
		return this.breaked;
	}
	
	public void setBreaked(boolean breaked) {
		this.breaked = breaked;
	}
	
	public boolean isLoopBreak() {
		return this.loopBreak;
	}
	
	public void setLoopBreak(boolean loopBreak) {
		this.loopBreak = loopBreak;
	}
	
}
