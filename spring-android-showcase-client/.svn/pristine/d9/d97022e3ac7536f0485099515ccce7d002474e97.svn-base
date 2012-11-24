/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.android.showcase.rest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.android.showcase.AbstractAsyncActivity;
import org.springframework.android.showcase.R;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * @author Roy Clarkson
 */
public class VaultPostFormDataActivity extends AbstractAsyncActivity {
	
	protected static final String TAG = VaultPostFormDataActivity.class.getSimpleName();
	private static final int CAMERA_REQUEST = 1888;
	private ImageView imageView;
	private ProgressDialog dialog;
	private Bitmap photo;
	private EditText editDesc;
	private EditText editName;
	private DatePicker datePicker;
	//***************************************
    // Activity methods
    //***************************************
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.vault_post_form_data_layout);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); 
		this.imageView = (ImageView) this.findViewById(R.id.imageView1);
		EditText editDesc =(EditText) this.findViewById(R.id.descInput);
		EditText editName = (EditText)this.findViewById(R.id.nameInput);
		DatePicker datePicker =(DatePicker)this.findViewById(R.id.datePicker1);
		// Initiate the POST request when the button is selected
		final Button button = (Button) findViewById(R.id.uploadButton);
		button.setOnClickListener(new View.OnClickListener() { 
			public void onClick(View v) {
				new PostReceiptDetails().execute();
			}
		});
	}
		
	
	//***************************************
    // Private methods
    //***************************************	
	private void showResult(String result) {
		if (result != null) {
			// display a notification to the user with the response information
			Toast.makeText(this, result, Toast.LENGTH_LONG).show();
		} else {
			Toast.makeText(this, "I got null, something happened!", Toast.LENGTH_LONG).show();
		}
	}
	
	
	public void attachImage(View view) {
		Intent cameraIntent = new Intent(
				android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(cameraIntent, CAMERA_REQUEST);
	}

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
        if (requestCode == CAMERA_REQUEST) {  
            photo = (Bitmap) data.getExtras().get("data"); 
            imageView.setImageBitmap(photo);
        }  
    }
    protected File createTemporaryFile(String part, String ext) throws Exception
    {
        File tempDir= Environment.getExternalStorageDirectory();
        tempDir=new File(tempDir.getAbsolutePath());
        if(!tempDir.exists())
        {
            tempDir.mkdir();
        }
        return File.createTempFile(part, ext, tempDir);
    }

	//***************************************
    // Private classes
    //***************************************
	private class PostReceiptDetails extends AsyncTask<Void, Void, String> {
		
		private MultiValueMap<String, Object> formData;
		
		@Override
		protected void onPreExecute() {
			// before the network request begins, show a progress indicator
			showLoadingProgressDialog();
			
			Resource resource = new ClassPathResource("res/drawable/spring09_logo.png");
		
			// populate the data to post
			formData = new LinkedMultiValueMap<String, Object>();
			formData.add("description", "Spring logo");
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			photo.compress(CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
			byte[] bitmapdata = bos.toByteArray();
			resource = new ByteArrayResource(bitmapdata);
			formData.add("file", resource);
		}
		
		@Override
		protected String doInBackground(Void... params) {
			try {				
				// The URL for making the POST request
				final String url = getString(R.string.base_uri) + "/postformdata";
				
				HttpHeaders requestHeaders = new HttpHeaders();
				
				// Sendin	g multipart/form-data
				requestHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
				ByteArrayHttpMessageConverter converter = new ByteArrayHttpMessageConverter();
				List<MediaType> mediaTypes = new ArrayList<MediaType>();
				mediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
				converter.setSupportedMediaTypes(mediaTypes);
				
				// Populate the MultiValueMap being serialized and headers in an HttpEntity object to use for the request
				HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(formData, requestHeaders);

				// Create a new RestTemplate instance
				RestTemplate restTemplate = new RestTemplate();
				List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
				messageConverters.add(converter);
				restTemplate.setMessageConverters(messageConverters);
				// Make the network request, posting the message, expecting a String in response from the server
				ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
								
				// Return the response body to display to the user
				return response.getBody();
			} catch(Exception e) {
				Log.e(TAG, e.getMessage(), e);
			}
			
			return null;
		}
		
		@Override
		protected void onPostExecute(String result) {
			// after the network request completes, hide the progress indicator
			dismissProgressDialog();
			
			// return the response body to the calling class
			showResult(result);
		}
	}
}
