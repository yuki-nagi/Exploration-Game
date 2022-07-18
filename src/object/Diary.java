package object;
import java.util.Scanner;

public class Diary extends GameObject {
	//鍵の入手フラグに breaked フラグを使用しています。←Advクラスで使用。

	Scanner sc = new Scanner(System.in);

	@Override
	public void mebosiEvent() {
		if(this.isBreaked() == false) {
			System.out.println("この部屋に似合わず、非常に豪華な日記帳だ。");
			System.out.println("表紙には「Caesar」と書かれている。シーザー……日記の持ち主の名前だろうか？");
		}
		else if(this.isBreaked() == true){
			System.out.println("中が空っぽになった、分厚い日記の形をした箱だ。");
			System.out.println("開けた時には気づかなかったが、箱の底に何か文字が書かれている気がする。");
		}
		this.setMebosiChecked(true);
		
	}

	@Override
	public void breakEvent() {
		if(this.isBreaked() == false){
			System.out.println("破こうと持ち上げてみたが、表紙だけがパタンと捲れて本のページが捲れない。箱のようになっている。");
			System.out.println("揺らすと中でカシャカシャと金属音がする。");
		}
		else if(this.isBreaked() == true){
			System.out.println("もう箱の中は空っぽだ。壊す意味もない。");
		}
	}

	@Override
	public void lookEvent() {
		if(this.isBreaked() == false){
			System.out.println("よく見ると日記に見せかけた箱のようだ。表紙……いや蓋と呼ぶべきだろうか？――を捲ると、5文字分のアルファベットのダイヤル鍵が出現した。");
			System.out.println("心当たりは何かあるだろうか。5文字のアルファベット……。試してみるか。");
			String keyword = sc.next(); 
			if(keyword.length() < 5){
				System.out.println("いや、この文字数だと少し短いな。");
				System.out.println("「5文字のアルファベット」を探そう。");
			}
			else if(keyword.length() > 5){
				System.out.println("駄目だ、これは文字数が多すぎる");
				System.out.println("「5文字のアルファベット」を探そう。");
			}
			else if(keyword.length() == 5){
				if(keyword.equalsIgnoreCase("anjel")){
				System.out.println("カチッと音がして、錠が開いた。");
				System.out.println("箱の中から鍵が出てきた。");
				System.out.println("これでドア(Door)を開けば(open)ここから出られるだろう。");
				this.setBreaked(true);
				}
				else{
					System.out.println("……どうやら違ったようだ。");
					System.out.println("「5文字のアルファベット」……そのままの形で見つかるとは思えないか。");
				}
			}
		}
		if(this.isBreaked() == true){
			System.out.println("箱の底には「彼女の真名に辿り着いた賢者へ、扉の先で待つ」と書かれている。");
		}
		this.setLookChecked(true);
	}
}
