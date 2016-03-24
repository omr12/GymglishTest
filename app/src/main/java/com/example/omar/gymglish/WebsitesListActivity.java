package com.example.omar.gymglish;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Omar on 24/03/2016.
 */
public class WebsitesListActivity extends Activity {

    private ListView websitesList;
    private ArrayAdapter websitesArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites_list);

        websitesList = (ListView) findViewById(R.id.listView);
        websitesArrayAdapter = ArrayAdapter.createFromResource(this, R.array.websites, android.R.layout.simple_list_item_1);
        websitesList.setAdapter(websitesArrayAdapter);
        websitesList.setOnItemClickListener(new WebsiteItemClickListener());
    }

    private class WebsiteItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String url = ((TextView) view).getText().toString();
            Intent intent = new Intent(WebsitesListActivity.this, WebsiteDisplayActivity.class);
            intent.putExtra(WebsiteDisplayActivity.EXTRA_URL, url);
            startActivity(intent);
        }
    } // WebsiteItemClickListener
}
