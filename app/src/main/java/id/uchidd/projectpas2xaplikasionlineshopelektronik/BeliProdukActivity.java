package id.uchidd.projectpas2xaplikasionlineshopelektronik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeliProdukActivity extends AppCompatActivity {

    @BindView(R.id.tvDetail1)
    TextView tvDetail1;
    @BindView(R.id.tvDetail2)
    TextView tvDetail2;
    @BindView(R.id.tvDetail3)
    TextView tvDetail3;
    @BindView(R.id.spBeli)
    Spinner spBeli;
    @BindView(R.id.etBeli1)
    EditText etBeli1;
    @BindView(R.id.etBeli2)
    EditText etBeli2;
    @BindView(R.id.etBeli3)
    EditText etBeli3;
    @BindView(R.id.btnKembali)
    Button btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli_produk);
        ButterKnife.bind(this);
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BeliProdukActivity.this, DetailProdukActivity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(BeliProdukActivity.this, DetailProdukActivity.class));
        finish();
    }
}
