package id.uchidd.projectpas2xaplikasionlineshopelektronik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    @BindView(R.id.btnProses)
    Button btnProses;

    private String[] pengiriman = {
            "Pilih Metode Pengiriman",
            "JNE Reguler",
            "JNE YES",
            "JNE OK"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli_produk);
        ButterKnife.bind(this);

        Bundle getData = getIntent().getExtras();
        final String getText1 = getData.getString("TXT1");
        final String getText2 = getData.getString("TXT2");
        final String getText3 = getData.getString("TXT3");
        String getText4 = getData.getString("TXT4");
        Integer getImage = getData.getInt("IMAGE");

        tvDetail1.setText(getText1);
        tvDetail2.setText("Rp. " + getText2 + "-,");
        tvDetail3.setText(getText3);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(BeliProdukActivity.this, android.R.layout.simple_list_item_1, pengiriman);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spBeli.setAdapter(adapter);


        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String alamat = etBeli1.getText().toString();
                String penerima = etBeli2.getText().toString();
                String jumlahtext = etBeli3.getText().toString();
                String pengiriman = spBeli.getSelectedItem().toString();


                Bundle bundle = new Bundle();
                bundle.putString("TXT1", getText1);
                bundle.putString("TXT2", getText2);
                bundle.putString("TXT3", getText3);
                bundle.putString("ALAMAT", alamat);
                bundle.putString("PENERIMA", penerima);
                bundle.putString("JUMLAH", jumlahtext);
                bundle.putString("PENGIRIMAN", pengiriman);

                Intent goToCheckout = new Intent(BeliProdukActivity.this, CheckoutTransaksiActivity.class);
                goToCheckout.putExtras(bundle);
                startActivity(goToCheckout);

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
