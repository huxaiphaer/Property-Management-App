package huzy.jdhau.jomayi.huzykamz.drawer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class LandAdapter extends ArrayAdapter<ModelClass> {

	private Context context;
	private List<ModelClass> modelClassList =null;
    private ArrayList<ModelClass> arraylist;

	public LandAdapter(Context context, int resource, List<ModelClass> objects) {
		super(context, resource, objects);
		this.context = context;
		this.modelClassList = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = 
				(LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.item_flower, parent, false);

		//Display modelClass name in the TextView widget
		ModelClass modelClass = modelClassList.get(position);
		TextView district = (TextView) view.findViewById(R.id.district);
		TextView area = (TextView) view.findViewById(R.id.area);
		TextView property = (TextView) view.findViewById(R.id.property);
		TextView price = (TextView) view.findViewById(R.id.price);
		TextView acres = (TextView) view.findViewById(R.id.acres);


		district.setText(modelClass.getDistrict());
		area.setText(modelClass.getArea());
		property.setText(modelClass.getProperty());
		price.setText(modelClass.getPrice());
		acres.setText(modelClass.getAcres());
		
		//Display modelClass photo in ImageView widget
		ImageView image = (ImageView) view.findViewById(R.id.flag);
		image.setImageBitmap(modelClass.getBitmap());
		
		return view;
	}


	//filter class
	public void filter(String charText)
	{

		charText = charText.toLowerCase(Locale.getDefault());
		modelClassList.clear();
		if (charText.length() ==0){

			modelClassList.addAll(arraylist);
		}
else {
			for(ModelClass fp : arraylist){
				if(fp.getDistrict().toLowerCase(Locale.getDefault()).contains(charText) ||
						fp.getArea().toLowerCase(Locale.getDefault()).contains(charText)||
						fp.getPrice().toLowerCase(Locale.getDefault()).contains(charText)||
						fp.getProperty().toLowerCase(Locale.getDefault()).contains(charText)

						){
					modelClassList.add(fp);

				}

			}
		}
         notifyDataSetChanged();
	}
}
