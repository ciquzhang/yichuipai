package com.baichao.yichuipai.fragment.presenter;

import com.my.view.CarouselFigureView;

/**
 * Created by pll on 2017/5/3.
 */

public interface HomePresenter {
    void netForHomeList();
    void netForHomeListMore(int num);
    void headLoading(CarouselFigureView carouselFigureView);
    void addPv(String houseId);

}
