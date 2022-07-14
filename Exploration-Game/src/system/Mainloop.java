package system;

public class Mainloop {
	private int GS = 0;
	private boolean running = true;
	
	public  void game() {
		//ゲームシーンの管理。GS0 = タイトル、 GS1 = ADVパート、 GS2 = エンディング、 GS3 = ゲームオーバー。
		//Advクラスのadv()メソッドがゲームのメインとなるシーンで、またその戻り値でエンディングとゲームオーバーを切り替える。
		
		while(this.running) {
			if(this.GS == 0) {
				title();
			}
			else if(this.GS == 1) {
				Adv adv = new Adv();
				this.GS = adv.adv();
			}
			else if(this.GS ==2) {
				ending();
				this.running = false;
				break;
			}
			else if(this.GS == 3) {
				gameover();
				this.running = false;
				break;
			}
			
		}
	}
	
	public int getGS() {
		return this.GS;
	}
	
	public void setGS(int GS) {
		this.GS = GS;
	}
	
	public void title() {
		System.out.println("コマンド式 探索アドベンチャー");
		System.out.println("部屋に閉じ込められた探索者のあなた。");
		System.out.println("コマンドで部屋を探索して、部屋から脱出してください。");
		System.out.println("");
		System.out.println("コマンド一覧");
		System.out.println("");
		System.out.println("look + \"対象\"  ……対象をちゃんとよく見ます。本の場合は読みます。");
		System.out.println("                   対象を指定しない場合、部屋を見回します。");
		System.out.println("");
		System.out.println("mebosi + \"対象\" ……対象に対して脱出にかかわるヒントがないか探ります。" );
		System.out.println("");
		System.out.println("break + \"対象\" ……対象が壊せるものなら壊します。");
		System.out.println("");
		System.out.println("help ……現在使えるコマンド一覧を表示します。");
		System.out.println("          新たにコマンドが使えるようになった場合、helpに追加されます。");
		
		this.GS = 1;
	}
	
	public void ending() {
		System.out.println("こうして、探索者は部屋から出ることが出来た。");
		System.out.println("この先、彼はまだまだ困難に出会うことになるが、それはまた別のお話……");
		System.out.println("----- Thank you for playing!! -----");
		System.out.println("----- Game Clear! -----");
	}
	
	public void gameover() {
		System.out.println("探索者は部屋から出ること叶わず力尽きた。");
		System.out.println("-----GAME OVER-----");
		
	}
	

	
}
