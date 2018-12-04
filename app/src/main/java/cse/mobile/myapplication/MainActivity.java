package cse.mobile.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {
    boolean isSearch = true;
    int [][] grid = new int [5][5];
    int minecount =5;

    //bool형 배열 하나씩 만들기 5*5로

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random r = new Random();

        for(int x = 0 ; x<5; x++){
            grid[x] = new int[5];
        }

        while(minecount > 0){
            int x= r.nextInt(5);
            int y = r.nextInt(5);

            if(grid[x][y] != -1){
                grid[x][y] = -1;
                minecount--;
            }
        }

    }

    public void onClick(View view){
        if(view.getId()==R.id.button_mine)
            isSearch = true;
        else if(view.getId()==R.id.button_flag)
            isSearch= false;
        Toast.makeText(getApplicationContext(),""+isSearch,Toast.LENGTH_LONG).show();
    }

    public void onClickMap(View view){
        if(isSearch) {
            if(isMine(((Button) view).getText().toString())){
                ((Button) view).setBackgroundResource(R.mipmap.mine_1);
            }
        }
        else
        {
            ((Button) view).setBackgroundResource(R.mipmap.flag);
        }
    }


    public boolean isMine(String s){
        String[] a = s.split(",");
        int x = Integer.parseInt(a[0]);
        int y = Integer.parseInt(a[1]);

        if(grid[x][y] == -1) return true;
        else return false;
    }
}
