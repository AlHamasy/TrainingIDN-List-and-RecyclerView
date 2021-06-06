package id.asad.daftarbuah;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.MyViewHolder> {

    // 1, create constructor
    String [] namaBuah;
    int [] gambarBuah;
    int [] musikBuah;

    public FruitAdapter(String[] namaBuah, int[] gambarBuah, int[] musikBuah) {
        this.namaBuah = namaBuah;
        this.gambarBuah = gambarBuah;
        this.musikBuah = musikBuah;
    }

    // 2 call layout
    @NonNull
    @Override
    public FruitAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_buah, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitAdapter.MyViewHolder holder, int position) {
        holder.imgGambarBuah.setImageResource(gambarBuah[position]);
        holder.tvNamaBuah.setText(namaBuah[position]);

        Context context = holder.itemView.getContext();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic(context, musikBuah[position]);
                Toast.makeText(context, "Anda memilih buah " + namaBuah[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    // 4 show data
    @Override
    public int getItemCount() {
        return namaBuah.length;
    }

    // 3. call ID
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvNamaBuah;
        ImageView imgGambarBuah;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNamaBuah = itemView.findViewById(R.id.item_text);
            imgGambarBuah = itemView.findViewById(R.id.item_image);
        }
    }

    private void playMusic(Context context, int musikBuah){

        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        Uri uri = Uri.parse("android.resource://" + getClass().getPackage().getName() + "/" + musikBuah);

        try {
            mediaPlayer.setDataSource(context, uri);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
