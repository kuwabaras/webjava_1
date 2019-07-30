package jp.co.systena.tigerscave.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.systena.tigerscave.shoppingcart.model.Item;
import jp.co.systena.tigerscave.shoppingcart.service.ListService;

@Controller  // Viewあり。Viewを返却するアノテーション
public class ListController {

  @Autowired
  HttpSession session;                  // セッション管理

  @RequestMapping(value="/list", method = RequestMethod.GET)          // URLとのマッピング
  public ModelAndView index(ModelAndView mav) {

      ListService service = new ListService();
	  List<Item> itemList = service.getItemList();


	  mav.addObject("itemList", itemList);

      mav.setViewName("ListView");
    return mav;
  }

}
