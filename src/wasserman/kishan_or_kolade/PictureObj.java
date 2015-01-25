package wasserman.kishan_or_kolade;

public class PictureObj{

private int id;
private boolean isKolade;

	public PictureObj(int a, boolean b){
			id=a;
			isKolade=b;
	}

	public boolean getIsKolade(){
		return isKolade;
	}
	public int getID(){
		return id;
	}
}