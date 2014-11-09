package com.shamiq.microbitwager;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class ListViewWithListActivityFixed extends ListActivity {

    public class codeLeanChapter {
        String chapterName;
        String chapterDescription;
    }

    CodeLearnAdapter chapterListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_with_list_activity_fixed);


        chapterListAdapter = new CodeLearnAdapter();

        setListAdapter(chapterListAdapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        codeLeanChapter chapter = chapterListAdapter.getCodeLearnChapter(position);

        Toast.makeText(ListViewWithListActivityFixed.this, chapter.chapterName,Toast.LENGTH_LONG).show();
    }
    public class CodeLearnAdapter extends BaseAdapter {

        List<codeLeanChapter> codeLeanChapterList = getDataForListView();
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return codeLeanChapterList.size();
        }

        @Override
        public codeLeanChapter getItem(int arg0) {
            // TODO Auto-generated method stub
            return codeLeanChapterList.get(arg0);
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {

            if(arg1==null)
            {
                LayoutInflater inflater = (LayoutInflater) ListViewWithListActivityFixed.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                arg1 = inflater.inflate(R.layout.listitem, arg2,false);
            }

            TextView chapterName = (TextView)arg1.findViewById(R.id.textView1);
            TextView chapterDesc = (TextView)arg1.findViewById(R.id.textView2);

            codeLeanChapter chapter = codeLeanChapterList.get(arg0);

            chapterName.setText(chapter.chapterName);
            chapterDesc.setText(chapter.chapterDescription);

            return arg1;
        }

        public codeLeanChapter getCodeLearnChapter(int position)
        {
            return codeLeanChapterList.get(position);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    public List<codeLeanChapter> getDataForListView()
    {
        List<codeLeanChapter> codeLeanChaptersList = new ArrayList<codeLeanChapter>();

        for(int i=0;i<3;i++)
        {
            String[] names = {"John", "Jen", "Joe"};
            String[] values = {"5 BTC", "8 BTC", "9 BTC"};
            codeLeanChapter chapter = new codeLeanChapter();
            chapter.chapterName = names[i];
            chapter.chapterDescription = values[i];
            codeLeanChaptersList.add(chapter);
        }

        return codeLeanChaptersList;

    }
}