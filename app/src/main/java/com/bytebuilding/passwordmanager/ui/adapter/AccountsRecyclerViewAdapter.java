package com.bytebuilding.passwordmanager.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bytebuilding.passwordmanager.R;
import com.bytebuilding.passwordmanager.mvp.model.pojo.Account;

import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Turkin A. on 21.12.2017.
 */

public class AccountsRecyclerViewAdapter extends RecyclerView.Adapter<AccountsRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = AccountsRecyclerViewAdapter.class.getSimpleName();

    private Context mContext;
    private List<Account> mList;
    private OnItemClickListener mListener;

    public AccountsRecyclerViewAdapter(Context context, List<Account> list, OnItemClickListener onItemClickListener) {
        this.mContext = context;
        this.mList = list;
        this.mListener = onItemClickListener;
    }

    public List<Account> getList() {
        return mList;
    }

    public void setList(List<Account> mList) {
        this.mList = new LinkedList<>();

        this.mList.addAll(mList);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_account, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Account item = mList.get(position);

        holder.mAccountName.setText(item.getAccountName());
        if (!item.isShownLoginInList()) {
            holder.mAccountLogin.setText(item.getAccountLogin());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClick(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Account item);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_account_name)
        TextView mAccountName;

        @BindView(R.id.tv_account_login)
        TextView mAccountLogin;

        @BindView(R.id.ib_redacting)
        ImageButton mRedacting;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}