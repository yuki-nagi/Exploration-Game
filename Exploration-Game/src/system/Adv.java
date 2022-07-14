package system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import map.FirstRoom;
import sercher.Sercher;

class Adv {
	//コマンド入力を備えたADVシーンのループと、
	//ゲームのコマンドに関するメソッドを持つクラス。
	Sercher sercher;
	FirstRoom firstRoom;
	
	public Adv() {
		Sercher s1 = new Sercher();
		this.sercher = s1;
		FirstRoom fr = new FirstRoom();
		this.firstRoom = fr;
	}
	
	int adv() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean running = true;

		while(running) {
			//それぞれ、ゲームオーバーとエンディングのフラグが立っていればGS値をmainloopへ返してシーンを遷移させる記述。
			if(this.firstRoom.getBook().isLoopBreak()==true) {
				running = false;
				int GS = 3;
				return GS;
			}
			else if(this.firstRoom.getWindow().isLoopBreak() == true) {
				running = false;
				int GS = 2;
				return GS;
			}
			else if(this.firstRoom.getDoor().isLoopBreak() == true){
				running = false;
				int GS = 2;
				return GS;
			}
			
			System.out.println("");
			System.out.println("--------------------");
			System.out.print("何をしようか？ >> ");
			
			//GameObjectの子クラス特有のフラグを、別のクラスでも立てる為の記述。
			//良い方法が見つかったら改善したい点。
			if(this.firstRoom.getBook().isKnowSacrifice()) {
				this.firstRoom.getBookStand().setKnowSacrifice(true);
			}
			
			if(this.firstRoom.getBookStand().isHasRat()) {
				this.firstRoom.getBook().setHasRat(true);
			}
			
			if(this.firstRoom.getBook().isBreaked() == true) {
				this.firstRoom.getWindow().setDevil(true);
			}

			if(this.firstRoom.getDiary().isBreaked()){
				this.firstRoom.getDoor().setBreaked(true);
			}
			
			//コマンドの入力と、その文字列がメソッドの中にあるものと一致していれば実行
			try {
				String command = br.readLine();
				command(command);
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		//ここの返し値はreturn値が必要だったから書いただけ。
		//正常に動作していればたどり着かないはず。
		int GS =1; 
		System.out.println("異常な動作によりループを抜けました。デバッグの必要があります。");
		return GS;
	}
	
	void help() {
		System.out.println("コマンド一覧");
		System.out.println("");
		System.out.println("look + \"対象\"  ……対象をちゃんとよく見ます。本の場合は読みます。");
		System.out.println("                   対象を指定しない場合、部屋を見回します。");
		System.out.println("");
		System.out.println("mebosi + \"対象\" ……対象に対して脱出にかかわるヒントがないか探ります。" );
		System.out.println("");
		System.out.println("break + \"対象\" ……対象が壊せるものなら壊します。");
		if(this.firstRoom.getDiary().isBreaked() == true){
			System.out.println("");
			System.out.println("open Door ……手にした鍵で、部屋のドアを開けます。");
		}
		if(this.firstRoom.getBook().isKnowRitual() == true) {
			System.out.println("");
			System.out.println("ritual ……悪魔召喚の儀式を行います。自分以外の生き物がいればそれを生贄に捧げます。");
			System.out.println("           生贄なしでの儀式では探索者の無事は保証できません。");
		}
		System.out.println("");
		System.out.println("help ……現在使えるコマンド一覧を表示します。");
		System.out.println("          新たにコマンドが使えるようになった場合、helpに追加されます。");
	}

	void command(String command) {
		if(command.equals("help")) {
			help();
		}

		else if(command.equals("open Door")){
			if(this.firstRoom.getDiary().isBreaked()){
				System.out.println("鍵を差し回すとカチャリと音がして錠が外れた。");
				this.firstRoom.getDoor().setLoopBreak(true);
			}
		}
		
		else if(command.equals("ritual")) {
			if(this.firstRoom.getWindow().isDevil()) {
				System.out.println("悪魔召喚は成功したのだろうか？ 窓の外に気配を感じる。");
			}
			else if(this.firstRoom.getBook().isKnowRitual()){
				if(this.firstRoom.getBookStand().isHasRat()) {
					System.out.println("悪魔を呼び出す儀式を始めた。");
					System.out.println("捕まえていたネズミが一際甲高く鳴いた次の瞬間、動かなくなった。");
					System.out.println("……悪魔召喚は成功したのだろうか？ 窓の外に気配を感じる。");
					this.firstRoom.getWindow().setDevil(true);
				}
				if(this.firstRoom.getBookStand().isHasRat() == false) {
					System.out.println("素晴らしい悪魔の呼び声が聞こえた。");
					System.out.println("「ご苦労。その魂、その檻から救済してやろう」");
					System.out.println("歓喜に包まれながら、探索者の魂は一瞬で悪魔に食われた。");
					this.firstRoom.getBook().setLoopBreak(true);
				}
				
			}
		}
		
		else if(command.equals("look Rat")) {
			if(this.firstRoom.getWindow().isDevil()) {
				System.out.println("あのネズミは袋の中で息絶えている");
			}
			else if(this.firstRoom.getBookStand().isHasRat()) {
				System.out.println("生け捕りにしたネズミだ。");
				System.out.println("袋に詰めてポケットに入れているが、暴れている");
			}
		}
		
		else if(command.equals("look")) {
			this.sercher.look(firstRoom);
		}
		
		
		else if(command.equals("look Book")) {
			this.sercher.look(firstRoom.getBook());
		}
		else if(command.equals("break Book")) {
			this.sercher.Break(firstRoom.getBook());
		}
		else if(command.equals("mebosi Book")) {
			this.sercher.mebosi(firstRoom.getBook());			
		}
		
		else if(command.equals("look BookStand")) {
			this.sercher.look(firstRoom.getBookStand());
		}
		else if(command.equals("break BookStand")) {
			this.sercher.Break(firstRoom.getBookStand());
		}
		else if(command.equals("mebosi BookStand")) {
			this.sercher.mebosi(firstRoom.getBookStand());			
		}
		
		else if(command.equals("look Door")) {
			this.sercher.look(firstRoom.getDoor());
		}
		else if(command.equals("break Door")) {
			this.sercher.Break(firstRoom.getDoor());
		}
		else if(command.equals("mebosi Door")) {
			this.sercher.mebosi(firstRoom.getDoor());			
		}
		
		else if(command.equals("look Memo")) {
			this.sercher.look(firstRoom.getMemo());
		}
		else if(command.equals("break Memo")) {
			this.sercher.Break(firstRoom.getMemo());
		}
		else if(command.equals("mebosi Memo")) {
			this.sercher.mebosi(firstRoom.getMemo());			
		}
		
		
		else if(command.equals("look Window")) {
			this.sercher.look(firstRoom.getWindow());
		}
		else if(command.equals("break Window")) {
			this.sercher.Break(firstRoom.getWindow());
		}
		else if(command.equals("mebosi Window")) {
			this.sercher.mebosi(firstRoom.getWindow());			
		}

		else if(command.equals("look Painting")) {
			this.sercher.look(firstRoom.getPainting());
		}
		else if(command.equals("break Painting")) {
			this.sercher.Break(firstRoom.getPainting());
		}
		else if(command.equals("mebosi Painting")) {
			this.sercher.mebosi(firstRoom.getPainting());			
		}

		else if(command.equals("look Desk")) {
			this.sercher.look(firstRoom.getDesk());
		}
		else if(command.equals("break Desk")) {
			this.sercher.Break(firstRoom.getDesk());
		}
		else if(command.equals("mebosi Desk")) {
			this.sercher.mebosi(firstRoom.getDesk());			
		}

		else if(command.equals("look Diary")) {
			this.sercher.look(firstRoom.getDiary());
		}
		else if(command.equals("break Diary")) {
			this.sercher.Break(firstRoom.getDiary());
		}
		else if(command.equals("mebosi Diary")) {
			this.sercher.mebosi(firstRoom.getDiary());			
		}
		
		
		
		
	}

}
