package id.co.next_innovation.leaseapp.ui.detail;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import javax.inject.Inject;

import agency.tango.android.avatarview.IImageLoader;
import agency.tango.android.avatarview.loader.PicassoLoader;
import agency.tango.android.avatarview.views.AvatarView;
import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.next_innovation.leaseapp.R;
import id.co.next_innovation.leaseapp.data.db.model.Customer;
import id.co.next_innovation.leaseapp.ui.base.BaseActivity;

/**
 * Copyright 2017 Winnerawan T
 * Unauthorized copying of this file, via any medium is strictly
 * prohibited Proprietary and confidential
 * Written by Winnerawan T <winnerawan@gmail.com>, September 2017
 */
public class DetailActivity extends BaseActivity implements DetailView {

    @Inject
    DetailMvpPresenter<DetailView> mPresenter;

    private IImageLoader mImageLoader = new PicassoLoader();

    @BindView(R.id.stnk)
    TextView mStnk;
    @BindView(R.id.unit)
    TextView mUnit;
    @BindView(R.id.nopol)
    TextView mNopol;
    @BindView(R.id.nosin)
    TextView mNosin;
    @BindView(R.id.noka)
    TextView mNoka;
    @BindView(R.id.warna)
    TextView mWarna;
    @BindView(R.id.bank)
    TextView mBank;
    @BindView(R.id.cabang)
    TextView mCabang;
    @BindView(R.id.profile_image)
    AvatarView mAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getActivityComponent().inject(this);
        overridePendingTransition(R.anim.anim_pop_up, R.anim.anim_push_up);
        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);
        setUp();
    }

    @Override
    protected void setUp() {
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        int id = bundle.getInt("customer_id");
        Customer customer = mPresenter.getCustomerDetail(id);

        mImageLoader.loadImage(mAvatar, customer.getStnk(), customer.getStnk());
        mUnit.setText(customer.getUnit());
        mNopol.setText(customer.getNopol());
        mStnk.setText(customer.getStnk());
        mNosin.setText(customer.getNosin());
        mNoka.setText(customer.getNoka());
        mWarna.setText(customer.getWarna());
        mBank.setText(customer.getBank());
        mCabang.setText(customer.getCabang());

    }

    private void finishAction() {
        finish();
        overridePendingTransition(R.anim.anim_pop_down, R.anim.anim_push_down);
    }

    public void onBackPressed() {
        finishAction();
    }
}
