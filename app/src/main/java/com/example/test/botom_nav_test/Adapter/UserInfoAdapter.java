package com.example.test.botom_nav_test.Adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.test.botom_nav_test.Model.UserInfo;
import com.example.test.botom_nav_test.R;

import java.util.List;

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.userInfoViewHolder> {

    List<UserInfo> list_u;
    Context context;

    public UserInfoAdapter(Context context, List<UserInfo> userInfoList) {
        this.context = context;
        this.list_u = userInfoList;
    }

    @NonNull
    @Override
    public userInfoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_object_userinfo, viewGroup, false);
        return new userInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull userInfoViewHolder holder, int position) {
        UserInfo userInfo = list_u.get(position);

        holder.lastname.setText(userInfo.getFirstName());
        holder.firstname.setText(userInfo.getLastName());
        holder.userid.setText(userInfo.getUserId());
        holder.admin.setText(userInfo.getAdmin());
        holder.birthday.setText(userInfo.getBirthDay());
        holder.evidence.setText(userInfo.getEvidence());
        holder.company.setText(userInfo.getCompany());
        holder.graduate.setText(userInfo.getGraduate());
        holder.foldername.setText(userInfo.getFolderName());
        holder.imagename.setText(userInfo.getImageName());
    }

    @Override
    public int getItemCount() {
        return list_u.size();
    }

    public class userInfoViewHolder extends RecyclerView.ViewHolder {

        String id;
        TextView firstname, lastname, userid, admin, birthday, evidence, company, graduate, foldername, imagename;

        public userInfoViewHolder(@NonNull View itemView) {
            super(itemView);
            firstname = (TextView) itemView.findViewById(R.id.firstname);
            lastname = (TextView) itemView.findViewById(R.id.lastname);
            userid = (TextView) itemView.findViewById(R.id.userid);
            admin = (TextView) itemView.findViewById(R.id.admin);
            birthday = (TextView) itemView.findViewById(R.id.birthday);
            evidence = (TextView) itemView.findViewById(R.id.evidence);
            company = (TextView) itemView.findViewById(R.id.company);
            graduate = (TextView) itemView.findViewById(R.id.graduate);
            foldername = (TextView) itemView.findViewById(R.id.foldername);
            imagename = (TextView) itemView.findViewById(R.id.imagename);
        }
    }
}
