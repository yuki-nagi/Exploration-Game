package map;

import object.Book;
import object.BookStand;
import object.Door;
import object.Memo;
import object.Window;
import object.Painting;
import object.Desk;
import object.Diary;

public class FirstRoom {
	//GameObjectの子クラスのインスタンスをフィールドに持つ。
	//（部屋に置いてあるオブジェクト、というイメージで製作したため）
	//このクラスとsercher（探索者）がAdvに呼び出されて、ゲームになるイメージ。
	
	private Window Window;
	private BookStand BookStand;
	private Memo Memo;
	private Door Door;
	private Book Book;
	private Painting Painting;
	private Desk Desk;
	private Diary Diary;
	
	public FirstRoom() {
		Window window = new Window();
		this.setWindow(window);
		
		BookStand bookStand = new BookStand();
		this.setBookStand(bookStand);
		
		Memo memo = new Memo();
		this.setMemo(memo);
		
		Door door = new Door();
		this.setDoor(door);
		
		Book book = new Book();
		this.setBook(book);

		Painting painting = new Painting();
		this.setPainting(painting);

		Desk desk = new Desk();
		this.setDesk(desk);

		Diary diary = new Diary();
		this.setDiary(diary);
	}

	public Window getWindow() {
		return this.Window;
	}

	public void setWindow(Window window) {
		this.Window = window;
	}
	
	public BookStand getBookStand() {
		return this.BookStand;
	}
	public void setBookStand(BookStand bookStand) {
		this.BookStand = bookStand;
	}
	
	public Memo getMemo() {
		return this.Memo;
	}
	
	public void setMemo(Memo memo) {
		this.Memo = memo;
	}
	
	public Door getDoor() {
		return this.Door;
	}
	
	public void setDoor(Door door) {
		this.Door = door;
	}
	
	public Book getBook() {
		return this.Book;
	}
	
	public void setBook(Book book) {
		this.Book = book;
	}

	public Painting getPainting(){
		return this.Painting;
	}

	public void setPainting(Painting painting){
		this.Painting = painting;
	}
	
	public Desk getDesk(){
		return this.Desk;
	}

	public void setDesk(Desk desk){
		this.Desk = desk;
	}

	public Diary getDiary(){
		return this.Diary;
	}

	public void setDiary(Diary diary){
		this.Diary = diary;
	}

	public void lookEvent() {
		System.out.println("部屋を見渡した。");
		System.out.println("絵画（Painting）がある。");
		if(this.Window.isBreaked() == false) {
			System.out.println("窓（Window）がある。");
		}
		else if(this.Window.isBreaked() == true) {
			System.out.println("割れた窓(Window)がある。");
		}
		System.out.println("扉(Door)がある。");
		System.out.println("机(Desk)がある。");
		if(this.Desk.isLookChecked()||this.Desk.isMebosiChecked()||this.Diary.isLookChecked()||this.Diary.isMebosiChecked()){
			System.out.println("机の上に日記帳(Diary)がある。");
		}
		System.out.println("本棚(BookStand)がある。");
		if(this.Memo.isBreaked() == true) {
			System.out.println("本棚の上に、丸まったメモ(Memo)がある");
		}
		else if(this.Memo.isBreaked() == false) {
			System.out.println("本棚の上に メモ(Memo)がある。");
		}
		if(this.Book.isLookChecked() == true) {
			System.out.println("本棚の上に「悪魔召喚の禁呪」と題された本(Book)がある");
		}
		else if(this.BookStand.isLookChecked() == true) {
			System.out.println("本棚には異質な本(Book)がある。");
		}
		else {}
		
	}
}
