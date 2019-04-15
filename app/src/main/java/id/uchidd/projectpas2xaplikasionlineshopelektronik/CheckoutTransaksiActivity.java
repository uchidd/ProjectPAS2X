package id.uchidd.projectpas2xaplikasionlineshopelektronik;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckoutTransaksiActivity extends AppCompatActivity {

    @BindView(R.id.tvDetail1)
    TextView tvDetail1;
    @BindView(R.id.tvDetail2)
    TextView tvDetail2;
    @BindView(R.id.tvDetail3)
    TextView tvDetail3;
    @BindView(R.id.tvCheckout1)
    TextView tvCheckout1;
    @BindView(R.id.tvCheckout2)
    TextView tvCheckout2;
    @BindView(R.id.tvCheckout3)
    TextView tvCheckout3;
    @BindView(R.id.tvCheckout4)
    TextView tvCheckout4;
    @BindView(R.id.tvCheckout5)
    TextView tvCheckout5;
    @BindView(R.id.tvCheckout6)
    TextView tvCheckout6;
    @BindView(R.id.tvCheckout7)
    TextView tvCheckout7;
    @BindView(R.id.tvCheckout8)
    TextView tvCheckout8;
    @BindView(R.id.btnProses)
    Button btnProses;
    @BindView(R.id.btnList)
    Button btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_transaksi);
        ButterKnife.bind(this);

        Bundle getData = getIntent().getExtras();
        String getText1 = getData.getString("TXT1");
        String getText2 = getData.getString("TXT2");
        String getText3 = getData.getString("TXT3");
        String getAlamat = getData.getString("ALAMAT");
        String getPenerima = getData.getString("PENERIMA");
        String getJumlahText = getData.getString("JUMLAH");
        String getPengiriman = getData.getString("PENGIRIMAN");

        tvDetail1.setText(getText1);
        tvDetail2.setText("Rp. " + getText2 + "-,");
        tvDetail3.setText(getText3);
        tvCheckout1.setText(": " + getPengiriman);
        tvCheckout2.setText(": " + getAlamat);
        tvCheckout3.setText(": " + getPenerima);
        tvCheckout4.setText(": " + getJumlahText + " Unit");

        int jumlah = Integer.parseInt(getJumlahText);
        int harga = Integer.parseInt(getText2);
        int total = jumlah * harga;
        tvCheckout5.setText(": Rp. " + total + "-,");

        if (jumlah >= 6) {
            tvCheckout6.setText(": 10%");
            int diskon = total * 10 / 100;
            tvCheckout7.setText(": Rp. " + diskon + "-,");
            int bayar = total - diskon;
            tvCheckout8.setText("Rp. " + bayar + "-,");
        } else {
            tvCheckout6.setText(": -");
            tvCheckout7.setText(": -");
            tvCheckout8.setText("Rp. " + total + "-,");
        }

        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CheckoutTransaksiActivity.this);
                builder.setTitle("Penyimpanan Data Transaksi belum Tersedia")
                        .setMessage("Data penyimpanan transaksi untuk sementara belum tersedia, untuk ketersediaan data transaksi silahkan upgrade aplikasi ke berbayar.")
                        .setNegativeButton("Nanti Saja", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("Upgrade", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();
            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckoutTransaksiActivity.this, RecylerViewActivity.class));
                finish();
            }
        });
    }
}
