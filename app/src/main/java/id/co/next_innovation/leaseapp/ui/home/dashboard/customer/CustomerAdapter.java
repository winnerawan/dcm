package id.co.next_innovation.leaseapp.ui.home.dashboard.customer;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import agency.tango.android.avatarview.IImageLoader;
import agency.tango.android.avatarview.loader.PicassoLoader;
import agency.tango.android.avatarview.views.AvatarView;
import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.next_innovation.leaseapp.R;
import id.co.next_innovation.leaseapp.data.db.model.Customer;
import id.co.next_innovation.leaseapp.ui.base.BaseViewHolder;
import id.co.next_innovation.leaseapp.ui.detail.DetailActivity;

/**
 * Created by Interactive
 * @version 1.0.0
 * @since 6/3/2017
 */

public class CustomerAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private Callback mCallback;
    private List<Customer> mCustomers;
    IImageLoader mImageLoader = new PicassoLoader();


    public CustomerAdapter(List<Customer> customers) {
        mCustomers = customers;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemViewType(int position) {
        if (mCustomers != null && mCustomers.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    public void addItems(List<Customer> items) {
        mCustomers.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mCustomers != null && mCustomers.size() > 0) {
            return mCustomers.size();
        } else {
            return 0;
        }
    }

    public Customer getItem(int position) {
        return mCustomers.get(position);
    }

    public Customer removeItem(int position) {
        final Customer model = mCustomers.remove(position);
        notifyItemRemoved(position);
        return model;
    }

    public interface Callback {
        void onSelectCustomer();
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.avatar_stnk)
        AvatarView mAvatar;

        @BindView(R.id.stnk)
        TextView mStnk;

        @BindView(R.id.unit)
        TextView mUnit;

        @BindView(R.id.nopol)
        TextView mNopol;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            mUnit.setText("");
            mStnk.setText("");
            mNopol.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);
            final Customer customer = mCustomers.get(position);

            if (customer.getStnk() != null) {
                mStnk.setText(customer.getStnk());
                mImageLoader.loadImage(mAvatar, customer.getStnk(), customer.getStnk());
                mNopol.setText(customer.getNopol());
            }

            if (customer.getUnit() != null) {
                mUnit.setText(customer.getUnit());
            }
            itemView.setOnClickListener(v -> {
                if (customer.getId() != null) {
                    Intent i = new Intent(itemView.getContext(), DetailActivity.class);
                    i.putExtra("customer_id", customer.getId());
                    itemView.getContext().startActivity(i);
                }
            });
        }
    }

}
