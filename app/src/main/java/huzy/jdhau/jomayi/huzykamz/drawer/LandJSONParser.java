package huzy.jdhau.jomayi.huzykamz.drawer;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class LandJSONParser {
	
	public static List<ModelClass> parseFeed(String content) {
	
		try {
			JSONArray ar = new JSONArray(content);
			List<ModelClass> modelClassList = new ArrayList<>();
			
			for (int i = 0; i < ar.length(); i++) {
				
				JSONObject obj = ar.getJSONObject(i);
				ModelClass modelClass = new ModelClass();
				
				modelClass.setArea(obj.getString("Area"));
				modelClass.setDistrict(obj.getString("District"));
				modelClass.setProperty(obj.getString("PropertyType"));
				modelClass.setPhoto(obj.getString("photo"));
				modelClass.setPrice(obj.getString("Price"));
				modelClass.setBuyno(obj.getString("BuyNo"));
				modelClass.setInformation(obj.getString("Information"));
				modelClass.setAcres(obj.getString("LandSize"));

				
				modelClassList.add(modelClass);
			}
			
			return modelClassList;
		} catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
