package osg.id.movieproject.view;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import osg.id.movieproject.R;
import osg.id.movieproject.adapter.Contract;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.poster)
    public ImageView tvImg;
    @BindView(R.id.judul)
    public TextView tvJudul;
    @BindView(R.id.desc)
    public TextView tvDesc;
    @BindView(R.id.tgl)
    public TextView tvTgl;
    @BindView(R.id.coordinatorLayout)
    public CoordinatorLayout coordinatorLayout;
    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        setMovie();

        //untuk membuat tombol back button pada toolbar
        toolbar.setTitle("Detail Movie");
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void setMovie() {
        String img = getIntent().getStringExtra("poster_path");
        String judul = getIntent().getStringExtra("title");
        String desc = getIntent().getStringExtra("overview");
        String tgl = getIntent().getStringExtra("release_date");

        Glide.with(getApplicationContext()).load(Contract.LINK_IMAGE + img).into(tvImg);
        tvJudul.setText(judul);
        tvDesc.setText(desc);
        tvTgl.setText(tgl);
    }

    //membuat animasi ketika melakukan tombol back
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                finish();
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    //membuat fungsi tombol back button toolbar berjalan
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

}
