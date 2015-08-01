package app.yalku.exampledatabasedevf_android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.yalku.exampledatabasedevf_android.R;
import app.yalku.exampledatabasedevf_android.model.ContactModel;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sati on 31/07/2015.
 */
public class ContactRecyclerAdapter extends RecyclerView.Adapter<ContactRecyclerAdapter.ViewHolder> {

    private List<ContactModel> contacts;
    private LayoutInflater inflater;

    public ContactRecyclerAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        contacts = new ArrayList<>();
    }

    public void setContacts(List<ContactModel> contacts) {
        this.contacts = contacts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = inflater.inflate(R.layout.item_list_contact, parent, false);

        return new ViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(contacts.get(position));
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @Bind(R.id.textViewName)
        TextView textViewName;

        @Bind(R.id.textViewPhone)
        TextView textViewPhone;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(ContactModel contactModel) {
            textViewName.setText(contactModel.getName());
            textViewPhone.setText(contactModel.getPhone());
        }

    }


}
