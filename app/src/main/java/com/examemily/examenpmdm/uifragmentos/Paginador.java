package com.examemily.examenpmdm.uifragmentos;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.examemily.examenpmdm.fragmentos.Pagina1;
import com.examemily.examenpmdm.fragmentos.Pagina2;
import com.examemily.examenpmdm.fragmentos.Pagina3;

public class Paginador extends FragmentPagerAdapter {
    private final Context mContext;

    public Paginador(@NonNull FragmentManager fm, Context mContext) {
        super(fm);
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new Pagina1();
            case 1:
                return new Pagina2();
            case 2:
                return new Pagina3();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
