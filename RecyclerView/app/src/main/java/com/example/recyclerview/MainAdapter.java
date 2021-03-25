package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    //리스트 뷰의 아이템을 담을 arraylist
    //maindata를 가져온다.
    private ArrayList<MainData> arrayList;

    //alt+insert로 생성자

    public MainAdapter(ArrayList<MainData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    //리스트 뷰가 처음 생성될 때 생명주기
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflater는 레이아웃 xml파일로부터 view객체를 얻어낸다
        //해당 기능을 하는 함수 inflate를 수행하기 위해서는 inflater를 구해야 한다.
        //부모인 메인 activity로부터 inflater를 구해 inflate를 수행한다.
        // 첫 인자로 얻고싶은 레이아웃 리소스, 두번째 인자로 뷰를 객체화 하여 추가할 부모 컨테이너 세번째는
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        //생산성등으 위해 viewholder를 사용하기도 하지만 recyclerview에서는 viewholder가 강제됨
        //viewholder는 뷰를 저장하여 findbyid의 비효율적 호출을 막기위해 사용
        CustomViewHolder holder = new CustomViewHolder(view);
        //뷰로부터 뷰홀더로 값을 저장함
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.CustomViewHolder holder, int position) {
        //추가될 때의 생명주기
        holder.iv_profile.setImageResource(arrayList.get(position).getIv_profile());
        holder.tv_name.setText(arrayList.get(position).getTv_name());
        holder.tv_content.setText(arrayList.get(position).getTv_content());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curName = holder.tv_name.getText().toString();
                Toast.makeText(v.getContext(),curName,Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                remove(holder.getAdapterPosition());
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public void remove(int position){
        try {
            arrayList.remove(position);
            //지워진 것을 새로고침
            notifyItemRemoved(position);
        }catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
    }
    public class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView iv_profile;
        protected TextView tv_name;
        protected TextView tv_content;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            //activity 형식의 파일이 아니기 대문에 이와같이 불러와야 함
            //뷰로부터 값을 가져옴
            this.iv_profile = (ImageView)itemView.findViewById(R.id.iv_profile);
            this.tv_name = (TextView)itemView.findViewById(R.id.tv_name);
            this.tv_content = (TextView)itemView.findViewById(R.id.tv_content);
        }
    }
}
