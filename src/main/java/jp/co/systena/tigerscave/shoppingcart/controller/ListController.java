package jp.co.systena.tigerscave.shoppingcart.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.shoppingcart.model.Cart;
import jp.co.systena.tigerscave.shoppingcart.model.Item;
import jp.co.systena.tigerscave.shoppingcart.model.ListForm;
import jp.co.systena.tigerscave.shoppingcart.model.Order;
import jp.co.systena.tigerscave.shoppingcart.service.ListService;

@Controller // Viewあり。Viewを返却するアノテーション
public class ListController {

  @Autowired
  HttpSession session; // セッション管理

  @RequestMapping(value = "/list", method = RequestMethod.GET) // URLとのマッピング
  public ModelAndView index(ModelAndView mav) {

    ListService service = new ListService();
    List<Item> itemList = service.getItemList();

    mav.addObject("itemList", itemList);


    Cart cart = (Cart)session.getAttribute("cart");
    if( cart == null) {
      cart = new Cart();
    }
    mav.addObject("orderList", cart.getOrderList());




    mav.setViewName("ListView");
    return mav;
  }





  @RequestMapping(value="/list", method = RequestMethod.POST)  // URLとのマッピング
  private ModelAndView order(ModelAndView mav, @Valid ListForm listForm, BindingResult bindingResult, HttpServletRequest request) {

    Cart cart = (Cart)session.getAttribute("cart");
    if( cart == null) {
      cart = new Cart();
        session.setAttribute("cart", cart);
    }

    if (bindingResult.getAllErrors().size() > 0) {
      // エラーがある場合はそのまま戻す
      mav.addObject("listForm",listForm);  // 新規クラスを設定

      ListService service = new ListService();
      List<Item> itemList = service.getItemList();


      mav.addObject("itemList", itemList);

      // Viewのテンプレート名を設定
      mav.setViewName("ListView");

      return mav;

    }
    Order order = new Order();
    order.setItemid(listForm.getItemid());
    order.setNum(listForm.getNum());
    cart.add(order);
    // データをセッションへ保存
    session.setAttribute("cart", cart);
    return new ModelAndView("redirect:/list");        // リダイレクト
  }

}
