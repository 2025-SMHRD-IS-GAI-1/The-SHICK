package fluttingMasterPlace;

import java.util.ArrayList;

public class PlaceVO {
	private		String			placeName;
	private		String			placeNum;
	private		String			scripts;
	private		ArrayList<String[][]>	selector;
	
	public String getPlaceName() {		return placeName;	}
	public void setPlaceName(String placeName) {		this.placeName = placeName;	}
	public String getPlaceNum() {		return placeNum;	}
	public void setPlaceNum(String placeNum) {		this.placeNum = placeNum;	}
	public String getScripts() {		return scripts;	}
	public void setScripts(String scripts) {		this.scripts = scripts;	}
	public void setSelector(ArrayList<String[][]> selector) {		this.selector = selector;	}
	public String getScript(String sel) {		return this.scripts;	}
	public ArrayList<String[][]> getSelector() {		return selector;	}
	 
}
