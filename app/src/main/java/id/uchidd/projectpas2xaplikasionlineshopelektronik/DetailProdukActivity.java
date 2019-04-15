package id.uchidd.projectpas2xaplikasionlineshopelektronik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailProdukActivity extends AppCompatActivity {

    @BindView(R.id.ivDetail)
    ImageView ivDetail;
    @BindView(R.id.tvDetail1)
    TextView tvDetail1;
    @BindView(R.id.tvDetail2)
    TextView tvDetail2;
    @BindView(R.id.tvDetail3)
    TextView tvDetail3;
    @BindView(R.id.tvDetail4)
    TextView tvDetail4;
    @BindView(R.id.btnKembali)
    Button btnKembali;
    @BindView(R.id.btnBeli)
    Button btnBeli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_produk);
        ButterKnife.bind(this);

        Bundle getData = getIntent().getExtras();
         final String getText1 = getData.getString("TXT1");
         final String getText2 = getData.getString("TXT2");
         final String getText3 = getData.getString("TXT3");
         final String getText4 = getData.getString("TXT4");
         final Integer getImage = getData.getInt("IMAGE");

        Picasso.get().load(getImage).into(ivDetail);
        tvDetail1.setText(getText1);
        tvDetail2.setText("Rp. " + getText2 + "-,");
        tvDetail3.setText(getText3);
        tvDetail4.setText(getText4);

        btnBeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("TXT1", getText1);
                bundle.putString("TXT2", getText2);
                bundle.putString("TXT3", getText3);
                bundle.putString("TXT4", getText4);
                bundle.putInt("IMAGE", getImage);

                Intent goToBeliProduk = new Intent(DetailProdukActivity.this, BeliProdukActivity.class);
                goToBeliProduk.putExtras(bundle);
                startActivity(goToBeliProduk);
            }
        });

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailProdukActivity.this, RecylerViewActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(DetailProdukActivity.this, RecylerViewActivity.class));
    }
}
