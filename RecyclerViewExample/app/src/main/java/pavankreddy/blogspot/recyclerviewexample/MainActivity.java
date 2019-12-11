package pavankreddy.blogspot.recyclerviewexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int images[];
    String movie_names[];
    String actor_names[];

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up DATA
        setUpData();

        recyclerView = findViewById(R.id.recyclerview);


    }

    private void setUpData() {
        images = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.e, R.drawable.f2,
        R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j};

        movie_names = new String[]{"Arjun Reddy","Bahubali 2","Chatrapati","Damarukam","Eega","F2","Gangleader","Hello","I","Jalsa"};

        actor_names = new String[]{"Vijay","Prabhas","Prabhas","Nagarjuna","Samantha","Venkatesh,varun","Nani","Akhil","Vikram","Pawan Kalyan"};
    }
    
    class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVholder>
    {
        @NonNull
        @Override
        public RVholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(MainActivity.this)
                    .inflate(R.layout.designfile,parent,false);
            RVholder rVholder = new RVholder(v);
            return rVholder;
        }

        @Override
        public void onBindViewHolder(@NonNull RVholder holder, int position) {
            holder.p.setImageResource(images[position]);
            holder.m_n.setText(movie_names[position]);
            holder.m_a.setText(actor_names[position]);
        }

        @Override
        public int getItemCount() {
            return 10;
        }

        public class RVholder extends RecyclerView.ViewHolder {

            ImageView p;
            TextView m_n,m_a;

            public RVholder(@NonNull View itemView) {
                super(itemView);
                p = itemView.findViewById(R.id.movie_poster);
                m_n = itemView.findViewById(R.id.movie_name);
                m_a = itemView.findViewById(R.id.movie_actors);
            }
        }
    }
}
