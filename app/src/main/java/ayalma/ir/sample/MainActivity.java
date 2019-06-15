package ayalma.ir.sample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.appcompat.widget.Toolbar;

import ayalma.ir.expandablerecyclerview.ExpandableRecyclerView;


public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final ExpandableRecyclerView recyclerView = (ExpandableRecyclerView) findViewById(R.id.recyclerView);
        assert recyclerView != null;
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        final ExpandableTestAdapter testAdapter = new ExpandableTestAdapter();
        recyclerView.setAdapter(testAdapter);
    }

}
