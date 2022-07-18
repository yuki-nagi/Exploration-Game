package object;

public class BookStand extends GameObject {
	
	// 生贄に関して探索者が知っているかどうか(adv()によってsetされる)
	boolean knowSacrifice = false;
	
	// ネズミを捕まえたかどうか(advによってBookにsetされる。またAdvのcommandで直接使用される)
	boolean hasRat = false;
	
	public void mebosiEvent() {
		System.out.println("3段からなる小さな本棚だ。医学書の類が並んでいるように思える。");
		System.out.println("本棚の周辺でたまに何かが動く音がする気がする");
	}
	
	public void lookEvent() {
		System.out.println("3段からなる小さな本棚だ。");
		System.out.println("医学書の類が並んでいるが、その中に異質な本（Book）がある");
		this.setLookChecked(true);
	}
	
	public void breakEvent() {
		System.out.println("本棚を殴りつけた。");
		if(hasRat == false) {
		System.out.println("本棚の裏からびっくりしたネズミが一瞬出てきて、こっちもびっくりした。");
			if(isKnowSacrifice() == true) {
				System.out.println("もしかしたら生贄に使えるかもしれない。");
				System.out.println("ネズミを捕まえた。");
				hasRat =true;
			}
		}
		else if(hasRat == true) {
			System.out.println("もう本棚の裏のネズミはいない。殴りつけた拳が痛いだけだ。");
		}
	}
	

	
	public boolean isKnowSacrifice() {
		return this.knowSacrifice;
	}
	
	public void setKnowSacrifice(boolean knowSacrifice) {
		this.knowSacrifice = knowSacrifice;
	}
	
	public boolean isHasRat() {
		return this.hasRat;
	}
	
	public void setHasRat(boolean hasRat) {
		this.hasRat = hasRat;
	}

}
