package org.techtown.ai_eng_v2_00;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Inventory extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // 1. 레이아웃을 정의한 레이아웃 리소스(R.layout)을 사용하여 현재 액티비티의 화면을 구성하도록 합니다.
        setContentView(R.layout.inventory);



        // 2. 레이아웃 파일에 정의된 ListView를 자바 코드에서 사용할 수 있도록 합니다.
        // findViewById 메소드는 레이아웃 파일의 android:id 속성을 이용하여 뷰 객체를 찾아 리턴합니다.
        ListView listview = (ListView)findViewById(R.id.listview);


        // 3. 실제로 문자열 데이터를 저장하는데 사용할 ArrayList 객체를 생성합니다.
        final ArrayList<String> list = new ArrayList<>();



        // 4. ArrayList 객체에 데이터를 집어넣습니다.
        for (int i = 0; i < 50; i++) {
            list.add("카드 " + i);

        }


        // 5. ArrayList 객체와 ListView 객체를 연결하기 위해 ArrayAdapter객체를 사용합니다.
        // 우선 ArrayList 객체를 ArrayAdapter 객체에 연결합니다.
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, //context(액티비티 인스턴스)
                android.R.layout.simple_list_item_1, // 한 줄에 하나의 텍스트 아이템만 보여주는 레이아웃 파일
                // 한 줄에 보여지는 아이템 갯수나 구성을 변경하려면 여기에 새로만든 레이아웃을 지정하면 됩니다.
                list  // 데이터가 저장되어 있는 ArrayList 객체
        );



        // 6. ListView 객체에 adapter 객체를 연결합니다.
        listview.setAdapter(adapter);



        // 7. ListView 객체의 특정 아이템 클릭시 처리를 추가합니다.
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long id) {

                // 8. 클릭한 아이템의 문자열을 가져와서
                String selected_item = (String)adapterView.getItemAtPosition(position);

                // 9. 해당 아이템을 ArrayList 객체에서 제거하고
                list.remove(selected_item);

                // 10. 어댑터 객체에 변경 내용을 반영시켜줘야 에러가 발생하지 않습니다.
                adapter.notifyDataSetChanged();
            }
        });

    }
}

