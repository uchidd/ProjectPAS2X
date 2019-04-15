package id.uchidd.projectpas2xaplikasionlineshopelektronik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class RecylerViewActivity extends AppCompatActivity {

    private ArrayList<String> textList1;
    private ArrayList<String> textList2;
    private ArrayList<String> textList3;
    private ArrayList<String> textList4;
    private ArrayList<Integer> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler_view);
        initItemView();
    }

    private void initItemView(){

        final RecyclerView rvList = (RecyclerView)findViewById(R.id.rvList);
        rvList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvList.setLayoutManager(layoutManager);

        textList1 = new ArrayList<>();
        textList1.add("Laptop ASUS X453MA");
        textList1.add("Laptop VAIO Zi832");
        textList1.add("Laptop ROG GL503GE");

        textList2 = new ArrayList<>();
        textList2.add("3800000");
        textList2.add("4990000");
        textList2.add("14900000");

        textList3 = new ArrayList<>();
        textList3.add("Deskripsi Produk: RAM 4GB, Screen 1366x768 Pixel, Harddisk 500GB, Intel Core i3");
        textList3.add("Deskripsi Produk: RAM 8GB, Screen 1366x768 Pixel, Harddisk 1TB, Intel Core i7");
        textList3.add("Deskripsi Produk: RAM 8GB, Screen 1366x768 Pixel, Harddisk 1TB, Intel Core i7");

        textList4 = new ArrayList<>();
        textList4.add("Diskon 10% Jika Pembelian Lebih Dari 5 Unit");
        textList4.add("Diskon 10% Jika Pembelian Lebih Dari 5 Unit");
        textList4.add("Diskon 10% Jika Pembelian Lebih Dari 5 Unit");

        imageList = new ArrayList<>();
        imageList.add(R.drawable.list1);
        imageList.add(R.drawable.list2);
        imageList.add(R.drawable.list3);

        RecyclerView.Adapter adapter = new AdapterList(textList1, textList2, textList3 , textList4, imageList);
        rvList.setAdapter(adapter);

        rvList.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            GestureDetector gestureDetector = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = rvList.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
                if (child != null && gestureDetector.onTouchEvent(motionEvent)) {
                    int position = rvList.getChildAdapterPosition(child);

                    String text1, text2, text3, text4;
                    Integer image;

                    text1 = textList1.get(position);
                    text2 = textList2.get(position);
                    text3 = textList3.get(position);
                    text4 = textList4.get(position);
                    image = imageList.get(position);

                    pushData(text1, text2, text3, text4, image);

                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean b) {

            }
        });

    }

    private void pushData(String text1, String text2, String text3, String text4, Integer image) {

        Bundle bundle = new Bundle();
        bundle.putString("TXT1", text1);
        bundle.putString("TXT2", text2);
        bundle.putString("TXT3", text3);
        bundle.putString("TXT4", text4);
        bundle.putInt("IMAGE", image);

        Intent goToDetailProduk = new Intent(this, DetailProdukActivity.class);
        goToDetailProduk.putExtras(bundle);
        startActivity(goToDetailProduk);
        return;

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
