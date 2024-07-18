/*
package com.example.androidassignments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherForecast extends AppCompatActivity {

    public ProgressBar progressBar;
    public TextView min_temp, max_temp, val_temp;

    //public String min, max, value;
    public String iconName;

    public String imageURL = "http://openweathermap.org/img/w/" + iconName + ".png";
    //public Bitmap weather_image;
    public ImageView imageIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather_forecast);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        progressBar = findViewById(R.id.progress_bar);
        min_temp = findViewById(R.id.min_temp);
        max_temp = findViewById(R.id.max_temp);
        val_temp = findViewById(R.id.current_temp);
        progressBar.setVisibility(View.VISIBLE);
        imageIcon = findViewById(R.id.weather_icon);
    }



    public class ForecastQuery extends AsyncTask<String, Integer, String> {

        public String min, max, value;
        public Bitmap weather_image;
        @Override
        protected String doInBackground(String ...args) {
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q=ottawa,ca&APPID=79cecf493cb6e52d25bb7b7050ff723c&mode=xml&units=metric";
            try{

                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000 */
/* milliseconds *//*
);
                conn.setConnectTimeout(15000 */
/* milliseconds *//*
);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                // Starts the query.
                conn.connect();

                try{
                    XmlPullParser parser = Xml.newPullParser();
                    parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    parser.setInput(conn.getInputStream(), null);
                    parser.nextTag();
                    if("temperature".equals(parser.getName()))
                    {
                        value = parser.getAttributeValue(null, "value");
                        publishProgress(25);
                        min = parser.getAttributeValue(null, "min");
                        publishProgress(50);
                        max = parser.getAttributeValue(null, "max");
                        publishProgress(75);
                        Log.i("WeatherForecast", "Value = " + value);
                    }
                    if("weather".equals(parser.getName())){
                        iconName = parser.getAttributeValue(null, "icon");
                    }
                }
                catch (XmlPullParserException e){
                    throw new RuntimeException(e);
                }

                //return readFeed(parser);

                //return conn.getInputStream();
                String imageFile = iconName + ".png";


                if(fileExistance(imageFile)){
                    Log.i("WeatherForecast", "Image Found Locally");
                    FileInputStream fis = null;
                    try {
                        fis = openFileInput(imageFile);
                    }
                    catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    Bitmap bm = BitmapFactory.decodeStream(fis);
                    weather_image = bm;
                }
                else {
                    Log.i("WeatherForecast", "Image to be downloaded");
                    Bitmap image = HTTPUtils.getImage(imageURL);
                    FileOutputStream outputStream = openFileOutput(iconName + ".png", Context.MODE_PRIVATE);

                    image.compress(Bitmap.CompressFormat.PNG, 80, outputStream);
                    weather_image = image;
                    outputStream.flush();
                    outputStream.close();
                }
                publishProgress(100);
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }





            //publishProgress(100);

            //Log.i("WeatherForecast", "Looking for " + imageFile);
            return value;

        }
        public boolean fileExistance(String fname){
            File file = getBaseContext().getFileStreamPath(fname);
            return file.exists();   }

        public void onProgressUpdate(Integer ...value){
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgress(value[0]);
        }

        public void onPostExecute(){
            val_temp.setText(value);
            min_temp.setText(min);
            max_temp.setText(max);
            imageIcon.setImageBitmap(weather_image);
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
    public static class HTTPUtils{
        public static Bitmap getImage(String urlString) throws MalformedURLException {
            URL url = new URL(urlString);
            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    return BitmapFactory.decodeStream(connection.getInputStream());
                } else
                    return null;
            } catch (Exception e) {
                return null;
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }

        }

    }

}*/
/*


package com.example.androidassignments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.print.PrintHelper;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherForecast extends AppCompatActivity {

    public ProgressBar progressBar;
    public TextView min_temp, max_temp, val_temp;
    public ImageView imageIcon;
    public String iconName;
    public String imageURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather_forecast);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        progressBar = findViewById(R.id.progress_bar);
        min_temp = findViewById(R.id.min_temp);
        max_temp = findViewById(R.id.max_temp);
        val_temp = findViewById(R.id.current_temp);
        progressBar.setVisibility(View.VISIBLE);
        imageIcon = findViewById(R.id.weather_icon);

        new ForecastQuery().execute();
    }

    public class ForecastQuery extends AsyncTask<String, Integer, String> {

        public String min, max, value;
        public Bitmap weather_image;

        @Override
        protected String doInBackground(String... args) {
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q=ottawa,ca&APPID=79cecf493cb6e52d25bb7b7050ff723c&mode=xml&units=metric";
            try {
                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();

                try {
                    XmlPullParser parser = Xml.newPullParser();
                    parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    parser.setInput(conn.getInputStream(), null);
                    parser.nextTag();

                    while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {
                        if (parser.getEventType() == XmlPullParser.START_TAG) {
                            if ("temperature".equals(parser.getName())) {
                                value = parser.getAttributeValue(null, "value");
                                publishProgress(25);
                                min = parser.getAttributeValue(null, "min");
                                publishProgress(50);
                                max = parser.getAttributeValue(null, "max");
                                publishProgress(75);
                                Log.i("WeatherForecast", "Value = " + value);
                            } else if ("weather".equals(parser.getName())) {
                                iconName = parser.getAttributeValue(null, "icon");
                                String imageFile = iconName + ".png";
                                if(fileExistance(imageFile)){
                                    FileInputStream fis = null;
                                    try {
                                        fis = openFileInput(imageFile);
                                    } catch (FileNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                    Bitmap bm = BitmapFactory.decodeStream(fis);
                                    weather_image = bm;
                                } else {
                                    Log.i("WeatherForecast", "Image to be downloaded");
                                    imageURL = "https://openweathermap.org/img/wn/" + iconName + ".png";
                                    Bitmap image = HTTPUtils.getImage(imageURL);
                                    FileOutputStream outputStream = openFileOutput(iconName + ".png", Context.MODE_PRIVATE);
                                    image.compress(Bitmap.CompressFormat.PNG, 80, outputStream);
                                    weather_image = image;
                                    outputStream.flush();
                                    outputStream.close();
                                }
                                publishProgress(100);
                            }
                        }
                        parser.next();
                    }
                } catch (XmlPullParserException e) {
                    throw new RuntimeException(e);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return "";
        }

        public boolean fileExistance(String fname) {
            File file = getBaseContext().getFileStreamPath(fname);
            return file.exists();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            val_temp.setText("Current Temperature: " + value + "C");
            min_temp.setText("Min Temperature: " + min + "C");
            max_temp.setText("Max Temperature: " + max + "C");
            doPhotoPrint();
            Bitmap btmp = (Bitmap) ;
            imageIcon.setImageBitmap(weather_image);
            progressBar.setVisibility(View.INVISIBLE);
        }
        private void doPhotoPrint() {
            Log.i("WeatherForecast", "doPhotoPrint() called");
            PrintHelper photoPrinter = new PrintHelper(WeatherForecast.this);
            photoPrinter.setScaleMode(PrintHelper.SCALE_MODE_FIT);
            Bitmap bitmap = weather_image;
            photoPrinter.printBitmap("droids.jpg - test print", bitmap);
        }

    }

    public static class HTTPUtils {
        public static Bitmap getImage(String urlString) throws MalformedURLException {
            URL url = new URL(urlString);
            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    return BitmapFactory.decodeStream(connection.getInputStream());
                } else
                    return null;
            } catch (Exception e) {
                return null;
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        }
    }
}
*/

/*
maddy
package com.example.androidassignments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.xmlpull.v1.XmlPullParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class WeatherForecast extends AppCompatActivity {
    private ImageView imageViewCurrentWeather;
    private TextView textViewCurrentTemperature;
    private TextView textViewMinTemperature;
    private TextView textViewMaxTemperature;
    private ProgressBar horizontalProgressBar;
    private List<String> cityList;
    private TextView cityName;
    private static final String weatherTAG = "WeatherForecast Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather_forecast);
        */
/*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
         *//*

        horizontalProgressBar = findViewById(R.id.progress_bar);
        horizontalProgressBar.setVisibility(View.VISIBLE);
        imageViewCurrentWeather = findViewById(R.id.weather_icon);
        textViewCurrentTemperature = findViewById(R.id.current_temp);
        textViewMinTemperature = findViewById(R.id.min_temp);
        textViewMaxTemperature = findViewById(R.id.max_temp);
        //cityName = findViewById(R.id.cityName);
        //get_a_city();
    }

    */
/*public void get_a_city() {
        cityList = Arrays.asList(getResources().getStringArray(R.array. cities));
        final Spinner citySpinner = findViewById(R.id.citySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this, R.array.cities, android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(adapter);
        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView <?> adapterView, View view, int i, long l) {
                new ForecastQuery(cityList.get(i)).execute();
                cityName.setText(cityList.get(i) + " Weather");
            }
            @Override
            public void onNothingSelected(AdapterView <?> adapterView) {

            }
        });
    }*//*

    private class ForecastQuery extends AsyncTask<String,Integer, String> {
        private String minTemperature;
        private String maxTemperature;
        private String currentTemperature;
        private Bitmap currentWeather;
        protected String city = "Ottawa";

        */
/*ForecastQuery(String city) {
            this.city = city;
        }*//*

        @Override
        protected String doInBackground(String... params){
            try {
                URL url = new URL("https://api.openweathermap.org/" + "data/2.5/weather?q=" + this.city + "," + "ca&APPID=79cecf493cb6e52d25bb7b7050ff723c&" + "mode=xml&units=metric");
                HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();
                InputStream in = conn.getInputStream();
                try {
                    XmlPullParser parser = Xml.newPullParser();
                    parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    parser.setInput(in, null);
                    int type;
                    while ((type = parser.getEventType()) != XmlPullParser.END_DOCUMENT) {
                        if (parser.getEventType() == XmlPullParser.START_TAG) {
                            if (parser.getName().equals("temperature")) {
                                currentTemperature = parser.getAttributeValue(null, "value");
                                publishProgress(25);
                                minTemperature = parser.getAttributeValue(null, "min");
                                publishProgress(50);
                                maxTemperature = parser.getAttributs
                                s
                                s
                                s
                                s
                                s
                                s
                                s
                                s
                                ss
                                s
                                s
                                s
                                eValue(null, "max");
                                publishProgress(75);
                            }
                            else if (parser.getName().equals("weather")) {
                                String iconName = parser.getAttributeValue(null, "icon");
                                String fileName = iconName + ".png";
                                Log.i(weatherTAG, "Looking for file: " + fileName);
                                if (fileExistance(fileName)) {
                                    FileInputStream fis = openFileInput(fileName);
                                    Log.i(weatherTAG, "Found the file locally");
                                    currentWeather = BitmapFactory.decodeStream(fis);
                                } else {
                                    String iconUrl = "https://openweathermap.org/img/wn/" + fileName;
                                    currentWeather = getImage(new URL(iconUrl));
                                    FileOutputStream outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                                    currentWeather.compress(Bitmap.CompressFormat.PNG, 80, outputStream);
                                    Log.i(weatherTAG, "Downloaded the file from the Internet");
                                    outputStream.flush();
                                    outputStream.close();
                                }
                                publishProgress(100);
                            }
                        }
                        parser.next();
                    }
                } finally {
                    in.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return "";
        }
        public boolean fileExistance(String fname) {
            File file = getBaseContext().getFileStreamPath(fname);
            return file.exists();
        }
        public Bitmap getImage(URL url) {
            HttpsURLConnection connection = null;
            try {
                connection = (HttpsURLConnection) url.openConnection();
                connection.connect();
                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    return BitmapFactory.decodeStream(connection.getInputStream());
                } else
                    return null;
            }
            catch (Exception e) {sdfsdf
            s
            s
            s
            s
            s
            s
            s
            s
                return null;
            }
            finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            horizontalProgressBar.setProgress(values[0]);
        }
        @Override
        protected void onPostExecute(String a){
            horizontalProgressBar.setVisibility(View.INVISIBLE);
            imageViewCurrentWeather.setImageBitmap(currentWeather);
            textViewCurrentTemperature.setText("Current Temperature: " + currentTemperature + "°C");
            textViewMinTemperature.setText("Min Temperature: "+minTemperature+"°C");
            textViewMaxTemperature.setText("Max Temperature: "+maxTemperature+"°C");
        }
    }

}
*/
package com.example.androidassignments;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class WeatherForecast extends AppCompatActivity {

    public ProgressBar progressBar;
    public TextView min_temp, max_temp, val_temp;
    public ImageView imageIcon;
    public String iconName;
    public String imageURL;
    public List<String> city_list;
    String tag = "WeatherForecast";

    public Spinner citySelector;
    public String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather_forecast);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        progressBar = findViewById(R.id.progress_bar);
        min_temp = findViewById(R.id.min_temp);
        max_temp = findViewById(R.id.max_temp);
        val_temp = findViewById(R.id.current_temp);
        progressBar.setVisibility(View.VISIBLE);
        imageIcon = findViewById(R.id.weather_icon);
        citySelector = findViewById(R.id.city_select);
        CitySelector();


    }
    public void CitySelector() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.cities_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySelector.setAdapter(adapter);
        citySelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView <?> parent, View view, int position, long id) {
                city = parent.getItemAtPosition(position).toString().toLowerCase();
                new ForecastQuery(city).execute();
                Log.i(tag,city);

            }

            @Override
            public void onNothingSelected(AdapterView <?> parent) {

            }
        });

    }

    public class ForecastQuery extends AsyncTask<String, Integer, String> {

        public String min, max, value;
        public Bitmap weather_image;
        public String city_selected;

        ForecastQuery(String city)
        {
            this.city_selected = city;
        }

        @Override
        protected String doInBackground(String... args) {
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + city_selected + ",ca&APPID=79cecf493cb6e52d25bb7b7050ff723c&mode=xml&units=metric";
            Log.i(tag, urlString);
            try {
                URL url = new URL(urlString);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();

                try {
                    XmlPullParser parser = Xml.newPullParser();
                    parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    parser.setInput(conn.getInputStream(), null);
                    parser.nextTag();

                    while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {
                        if (parser.getEventType() == XmlPullParser.START_TAG) {
                            if ("temperature".equals(parser.getName())) {
                                value = parser.getAttributeValue(null, "value");
                                publishProgress(25);
                                min = parser.getAttributeValue(null, "min");
                                publishProgress(50);
                                max = parser.getAttributeValue(null, "max");
                                publishProgress(75);
                                Log.i(tag, "Value = " + value);
                            }
                            if ("weather".equals(parser.getName())) {
                                iconName = parser.getAttributeValue(null, "icon");
                                Log.i(tag, "Icon Name = " + iconName);
                            }
                        }
                        parser.next();
                    }
                } catch (XmlPullParserException e) {
                    throw new RuntimeException(e);
                }


                imageURL = "https://openweathermap.org/img/wn/" + iconName + ".png";
                Log.i("WeatherForecast", "Image URL = " + imageURL);
                String imageFile = iconName + ".png";

                if (fileExistance(imageFile)) {
                    Log.i("WeatherForecast", "Image Found Locally");
                    FileInputStream fis = openFileInput(imageFile);
                    Bitmap bm = BitmapFactory.decodeStream(fis);
                    weather_image = bm;
                } else {
                    Log.i("WeatherForecast", "Image to be downloaded");
                    Bitmap image = HTTPUtils.getImage(imageURL);
                    if (image != null) {
                        FileOutputStream outputStream = openFileOutput(iconName + ".png", Context.MODE_PRIVATE);
                        image.compress(Bitmap.CompressFormat.PNG, 80, outputStream);
                        weather_image = image;
                        outputStream.flush();
                        outputStream.close();
                    } else {
                        Log.e("WeatherForecast", "Failed to download image");
                    }
                }
                Thread.sleep(2000);
                publishProgress(100);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return value;
        }

        public boolean fileExistance(String fname) {
            File file = getBaseContext().getFileStreamPath(fname);
            return file.exists();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            val_temp.setText("Current Temperature: " + value + "C");
            min_temp.setText("Min Temperature: " + min + "C");
            max_temp.setText("Max Temperature: " + max + "C");
            if (weather_image != null) {
                imageIcon.setImageBitmap(weather_image);
            } else {
                Log.e("WeatherForecast", "Weather image is null");
            }
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
    public static class HTTPUtils {
        public static Bitmap getImage(String urlString) throws MalformedURLException {
            URL url = new URL(urlString);
            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                int responseCode = connection.getResponseCode();
                if (responseCode == 200) {
                    return BitmapFactory.decodeStream(connection.getInputStream());
                } else
                    return null;
            } catch (Exception e) {
                return null;
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        }
    }
}






