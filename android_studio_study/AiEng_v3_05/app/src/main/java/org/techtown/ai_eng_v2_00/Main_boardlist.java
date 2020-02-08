package org.techtown.ai_eng_v2_00;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.Arrays;
import java.util.List;

public class Main_boardlist extends Fragment {

    private RecyclerAdapter adapter;
    Toolbar toolbar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.test, container, false);
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.test,
                container,
                false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);


        //toolbar.setTitle("자유게시판");



        getData();

        return view;
    }



    private void getData() {
        // 임의의 데이터입니다.

        List<String> num = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8",
                "9", "10", "11", "12", "13", "14", "15", "16");
        List<String> title = Arrays.asList(
                "[공지사항]2020년 2월 업데이트 내역입니다.",
                "ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ",
                "수국입니다.",
                "해파리입니다.",
                "코알라입니다.",
                "등대입니다.",
                "펭귄입니다.",
                "튤립입니다.",
                "국화입니다.",
                "사막입니다.",
                "수국입니다.",
                "해파리입니다.",
                "이 동물은 코알라입니다.",
                "이것은 등대입니다.",
                "이 동물은 펭귄입니다.",
                "이 꽃은 튤립입니다."
        );
        List<String> writer = Arrays.asList("박민규", "익명", "익명", "익명", "익명", "익명", "익명", "익명",
                "익명", "익명", "익명", "익명", "익명", "익명", "익명", "익명");

        List<String> date = Arrays.asList("2020-2-5", "2020-2-5", "2020-2-6", "2020-2-6", "2020-2-6", "2020-2-7", "2020-2-7", "2020-2-8",
                "2020-2-8", "2020-2-8", "2020-2-8", "2020-2-11", "2020-2-12", "2020-2-13", "2020-2-15", "2020-2-16");

        for (int i = 0; i < num.size(); i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            Data data = new Data();
            data.setTitle(num.get(i));
            data.setContent(title.get(i));
            data.setwriter(writer.get(i));
            data.setdate(date.get(i));


            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter.addItem(data);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter.notifyDataSetChanged();
    }
}