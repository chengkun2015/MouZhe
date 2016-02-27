package com.example.volleyimageloaderdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.Volley;

/**
 * 
 * @author lanx
 *
 */
public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
	}
	
	public void displayImg(View view){
		ImageView imageView = (ImageView)this.findViewById(R.id.image_view);
		RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext()); 
		
		ImageLoader imageLoader = new ImageLoader(mQueue, new BitmapCache());

		ImageListener listener = ImageLoader.getImageListener(imageView,R.drawable.default_image, R.drawable.default_image);
		imageLoader.get("http://img.my.csdn.net/uploads/201404/13/1397393290_5765.jpeg", listener);
	}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
