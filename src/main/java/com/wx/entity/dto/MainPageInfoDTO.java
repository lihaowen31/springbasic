package com.wx.entity.dto;

import com.wx.entity.bo.HeadLine;
import com.wx.entity.bo.ShopCategory;
import lombok.Data;

import java.util.List;
@Data
public class MainPageInfoDTO {
    private List<HeadLine> headLineList;
    private List<ShopCategory> shopCategoryList;
}
