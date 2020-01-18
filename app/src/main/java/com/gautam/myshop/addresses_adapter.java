package com.gautam.myshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.gautam.myshop.MyAccountFragment.MANAGE_ADDRESS;
import static com.gautam.myshop.alladressesactivity.refreshItem;
import static com.gautam.myshop.deliveryActivity.SELECT_ADDRESS;

public class addresses_adapter extends RecyclerView.Adapter<addresses_adapter.Viewholder>{
    private List<addresses_model>  addresses_modelList;
    private int MODE;
    private int preSelectedPosition;


    public addresses_adapter(@NonNull List<addresses_model> addresses_modelList,int MODE) {
        this.addresses_modelList = addresses_modelList;
        this.MODE= MODE;

    }

    @NonNull
    @Override

    public addresses_adapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.addresses_item_layout,parent,false);
         return new Viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull addresses_adapter.Viewholder holder, int position) {
        String name=addresses_modelList.get(position).getFullname();
        String addresses=addresses_modelList.get(position).getAddresses();
        String pincode=addresses_modelList.get(position).getPincode();
        Boolean selected =addresses_modelList.get(position).getSelected();
        holder.setdata(name,addresses,pincode,selected,position);


    }

    @Override
    public int getItemCount() {

        return addresses_modelList.size();
    }
    public class Viewholder extends RecyclerView.ViewHolder{
        private TextView fullname;
        private TextView pincode;
        private TextView addresses;
        private ImageView icon;



        public Viewholder(@NonNull View itemView) {
            super(itemView);
            fullname = itemView.findViewById(R.id.name);
            addresses = itemView.findViewById(R.id.address);
            pincode = itemView.findViewById(R.id.pincode);
            icon=itemView.findViewById(R.id.icon_view);
        }
        private void setdata(String username,String useraddress,String userpincode,Boolean selected , int position)
        {
            fullname.setText(username);
            addresses.setText(useraddress);
            pincode.setText(userpincode);

            if(MODE == SELECT_ADDRESS){
                icon.setImageResource(R.drawable.tick);
                if(selected)
                {
                    icon.setVisibility(View.VISIBLE);
                    preSelectedPosition = position;
                }
                else
                {
                    icon.setVisibility(View.GONE);
                }

            }else  if(MODE == MANAGE_ADDRESS){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        if(preSelectedPosition != position) {
                            addresses_modelList.get(position).setSelected(true);
                            addresses_modelList.get(preSelectedPosition).setSelected(false);
                            refreshItem(preSelectedPosition, position);
                            preSelectedPosition = position;

                        }

                    }
                });
            }

        }
    }
}
