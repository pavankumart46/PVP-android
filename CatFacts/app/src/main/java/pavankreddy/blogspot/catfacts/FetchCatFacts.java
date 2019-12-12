package pavankreddy.blogspot.catfacts;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class FetchCatFacts extends AsyncTask<String,Void,String>
{

    private static final String link = "https://cat-fact.herokuapp.com/facts";
    private Context context;
    private TextView tv;

    public FetchCatFacts(Context context,TextView tv) {
        this.context = context;
        this.tv = tv;
    }

    @Override
    protected String doInBackground(String... strings)
    {
        try
        {
            URL url = new URL(link);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);

            String line;
            StringBuffer stringBuffer = new StringBuffer();

            while((line = br.readLine())!=null){
                stringBuffer.append(line);
            }

            return stringBuffer.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tv.setText(s);
    }
}
