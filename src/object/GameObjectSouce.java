package object;

public abstract class GameObjectSouce {
	boolean checked = false;
	
	public void mebosiEvent() {
		//本来abstractにしたいが、探索者クラスで使うのに定義の必要があった為仕方なく定義。
		//mebosiEventは必ずオーバーライドすること。
		System.out.println("異常な操作です。GameObject型を継承した場合、mebosiEventは必ずオーバーライドしてください");
	}
	
	public void breakEvent() {
		//本来abstractにしたいが、探索者クラスで使うのに定義の必要があった為仕方なく定義。
		//breakiEventは必ずオーバーライドすること。
		System.out.println("異常な操作です。GameObject型を継承した場合、breakEventは必ずオーバーライドしてください");
	}
	
	public void lookEvent() {
		//本来abstractにしたいが、探索者クラスで使うのに定義の必要があった為仕方なく定義。
		//lookiEventは必ずオーバーライドすること。
		System.out.println("異常な操作です。GameObject型を継承した場合、lookEventは必ずオーバーライドしてください");
		
	}
	
}
