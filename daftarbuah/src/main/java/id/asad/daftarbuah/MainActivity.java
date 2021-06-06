package id.asad.daftarbuah;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvBuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // atur recyclerview
        rvBuah = findViewById(R.id.rv_buah);
        rvBuah.setHasFixedSize(true);
        rvBuah.setLayoutManager(new LinearLayoutManager(this));

        // atur data
        String [] namaBuah = {"Alpukat","Apel","Ceri","Durian","Jambu Air", "Manggis", "Strawberry"};
        int [] gambarBuah = {R.drawable.alpukat, R.drawable.apel, R.drawable.ceri, R.drawable.durian,
                             R.drawable.jambuair, R.drawable.manggis, R.drawable.strawberry};
        int [] musikBuah = {R.raw.alpukat, R.raw.apel, R.raw.ceri, R.raw.durian, R.raw.jambuair,
                            R.raw.manggis, R.raw.strawberry};

//        BuahAdapter buahAdapter = new BuahAdapter(namaBuah, gambarBuah, musikBuah);
//        rvBuah.setAdapter(buahAdapter);

        FruitAdapter fruitAdapter = new FruitAdapter(namaBuah, gambarBuah, musikBuah);
        rvBuah.setAdapter(fruitAdapter);
    }

    // panggil layout menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // onclick menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_list){
            rvBuah.setLayoutManager(new LinearLayoutManager(this));
        }
        if (item.getItemId() == R.id.menu_grid){
            rvBuah.setLayoutManager(new GridLayoutManager(this, 2));
        }
        return super.onOptionsItemSelected(item);
    }
}