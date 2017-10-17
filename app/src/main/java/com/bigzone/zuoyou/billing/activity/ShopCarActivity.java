package com.bigzone.zuoyou.billing.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigzone.zuoyou.R;
import com.bigzone.zuoyou.billing.adapter.ShopcartExpandableListViewAdapter;
import com.bigzone.zuoyou.billing.bean.GroupInfo;
import com.bigzone.zuoyou.billing.bean.ProductInfo;
import com.bigzone.zuoyou.common.BaseActivity;
import com.bigzone.zuoyou.utils.ToastUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bigzone.zuoyou.R.id.ll_empty;

/**
 * Created by sszz on 2017/9/26.
 */

public class ShopCarActivity extends BaseActivity implements ShopcartExpandableListViewAdapter.CheckInterface,
        ShopcartExpandableListViewAdapter.ModifyCountInterface, View.OnClickListener {
    private ExpandableListView exListView;
    private CheckBox cb_check_all;
    private TextView tv_total_price;
    private TextView tv_delete;
    private TextView tv_go_to_pay;
    private Context context;

    private double totalPrice = 0.00;// 购买的商品总价
    private int totalCount = 0;// 购买的商品总数量

    private ShopcartExpandableListViewAdapter selva;
    private List<GroupInfo> groups = new ArrayList<GroupInfo>();// 组元素数据列表
    private Map<String, List<ProductInfo>> children = new HashMap<String, List<ProductInfo>>();// 子元素数据列表
    private AlertDialog alert;
    private Button btn_buy;
    private LinearLayout llEmpty;
    private TextView tv_title;
    private TextView tv_right;
    private List<ProductInfo> toBeDeleteProducts;

    @Override
    protected int bindLayout() {
        return R.layout.activity_shop_car;
    }

    @Override
    protected void initView() {
        virtualData();
        exListView = (ExpandableListView) findViewById(R.id.exListView);
  /*      cb_check_all = (CheckBox) findViewById(R.id.all_chekbox);*/
        tv_total_price = (TextView) findViewById(R.id.tv_total_price);
        tv_delete = (TextView) findViewById(R.id.tv_delete);
        tv_go_to_pay = (TextView) findViewById(R.id.tv_go_to_pay);
        btn_buy = (Button) findViewById(R.id.btn_add);
        llEmpty = (LinearLayout) findViewById(ll_empty);
        llEmpty.setVisibility(View.GONE);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_right = (TextView) findViewById(R.id.tv_top_right);
        tv_title.setText("购物车");
        tv_right.setVisibility(View.VISIBLE);
        tv_right.setText("清空购物车");
        tv_right.setOnClickListener(this);
        btn_buy.setOnClickListener(this);
        initEvents();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_top_right:
                ToastUtils.showShortMsg("dianji le ");
                doDeleteAll();
                break;
            case R.id.tv_go_to_pay:
                if (totalCount == 0) {
                    ToastUtils.showShortMsg("没东西支付哦");
                    return;
                }
                changeActivity(SettleActivity.class);
                break;
            case R.id.tv_delete:
                if (totalCount == 0) {
                    ToastUtils.showShortMsg("没东西删");
                    return;
                }
                doDelete();
                break;
            case R.id.btn_add:
                ToastUtils.showShortMsg("点击了哦");
                changeActivity(SalesOrderActivity.class);
        }

    }
    /**
     * 模拟数据<br>
     * 遵循适配器的数据列表填充原则，组元素被放在一个List中，对应的组元素下辖的子元素被放在Map中，<br>
     * 其键是组元素的Id(通常是一个唯一指定组元素身份的值)
     */
    private void virtualData()
    {

        for (int i = 0; i < 6; i++)
        {

            groups.add(new GroupInfo(i + "", "第八号当铺" + (i + 1) + "号店"));

            List<ProductInfo> products = new ArrayList<ProductInfo>();
            for (int j = 0; j <= i; j++)
            {

                products.add(new ProductInfo(j + "", "商品", "", groups.get(i).getName() + "的第" + (j + 1) + "个商品", 120.00 + i * j, 1));
            }
            children.put(groups.get(i).getId(), products);// 将组元素的一个唯一值，这里取Id，作为子元素List的Key
        }
    }
    private void initEvents()
    {
        selva = new ShopcartExpandableListViewAdapter(groups, children, this);
        selva.setCheckInterface(this);// 关键步骤1,设置复选框接口
        selva.setModifyCountInterface(this);// 关键步骤2,设置数量增减接口
        exListView.setAdapter(selva);

        for (int i = 0; i < selva.getGroupCount(); i++)
        {
            exListView.expandGroup(i);// 关键步骤3,初始化时，将ExpandableListView以展开的方式呈现
        }

      /*  cb_check_all.setOnClickListener(this);*/
        tv_delete.setOnClickListener(this);
        tv_go_to_pay.setOnClickListener(this);

    }



    private void doDeleteAll(){
        List<GroupInfo> toBeDeleteGroups = new ArrayList<GroupInfo>();// 待删除的组元素列表
        for (int i = 0; i < groups.size(); i++) {
            GroupInfo group = groups.get(i);
                toBeDeleteGroups.add(group);

            // 待删除的子元素列表
            toBeDeleteProducts = new ArrayList<ProductInfo>();
            List<ProductInfo> childs = children.get(group.getId());
            for (int j = 0; j < childs.size(); j++) {
                toBeDeleteProducts.add(childs.get(j));
            }
            childs.removeAll(toBeDeleteProducts);
        }

        groups.removeAll(toBeDeleteGroups);
        selva.notifyDataSetChanged();
        calculate();
        if (selva.isEmpty()) {
            llEmpty.setVisibility(View.VISIBLE);
        }
    }
    /**
     * 删除操作<br>
     * 1.不要边遍历边删除，容易出现数组越界的情况<br>
     * 2.现将要删除的对象放进相应的列表容器中，待遍历完后，以removeAll的方式进行删除
     */
    protected void doDelete()
    {
        List<GroupInfo> toBeDeleteGroups = new ArrayList<GroupInfo>();// 待删除的组元素列表
        for (int i = 0; i < groups.size(); i++)
        {  GroupInfo group = groups.get(i);

            if (group.isChoosed())
            {

                toBeDeleteGroups.add(group);
            }
            // 待删除的子元素列表
            toBeDeleteProducts = new ArrayList<ProductInfo>();
            List<ProductInfo> childs = children.get(group.getId());
            for (int j = 0; j < childs.size(); j++)
            {
                if (childs.get(j).isChoosed())
                {
                    toBeDeleteProducts.add(childs.get(j));
                }
            }
            childs.removeAll(toBeDeleteProducts);

        }

        groups.removeAll(toBeDeleteGroups);
        selva.notifyDataSetChanged();
        calculate();
        if (selva.isEmpty()) {
            llEmpty.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void doIncrease(int groupPosition, int childPosition, View showCountView, boolean isChecked)
    {

        ProductInfo product = (ProductInfo) selva.getChild(groupPosition, childPosition);
        int currentCount = product.getCount();
        currentCount++;
        product.setCount(currentCount);
        ((TextView) showCountView).setText(currentCount + "");

        selva.notifyDataSetChanged();
        calculate();
    }

    @Override
    public void doDecrease(int groupPosition, int childPosition, View showCountView, boolean isChecked)
    {

        ProductInfo product = (ProductInfo) selva.getChild(groupPosition, childPosition);
        int currentCount = product.getCount();
        if (currentCount == 1)
            return;
        currentCount--;

        product.setCount(currentCount);
        ((TextView) showCountView).setText(currentCount + "");

        selva.notifyDataSetChanged();
        calculate();
    }

    @Override
    public void checkGroup(int groupPosition, boolean isChecked)
    {
        GroupInfo group = groups.get(groupPosition);
        List<ProductInfo> childs = children.get(group.getId());
        for (int i = 0; i < childs.size(); i++)
        {
            childs.get(i).setChoosed(isChecked);
        }
        /*if (isAllCheck())
            cb_check_all.setChecked(true);
        else
            cb_check_all.setChecked(false);*/
        selva.notifyDataSetChanged();
        calculate();
    }

    @Override
    public void checkChild(int groupPosition, int childPosiTion, boolean isChecked)
    {
        boolean allChildSameState = true;// 判断改组下面的所有子元素是否是同一种状态
        GroupInfo group = groups.get(groupPosition);
        List<ProductInfo> childs = children.get(group.getId());
        for (int i = 0; i < childs.size(); i++)
        {
            if (childs.get(i).isChoosed() != isChecked)
            {
                allChildSameState = false;
                break;
            }
        }
        if (allChildSameState)
        {
            group.setChoosed(isChecked);// 如果所有子元素状态相同，那么对应的组元素被设为这种统一状态
        } else
        {
            group.setChoosed(false);// 否则，组元素一律设置为未选中状态
        }

     /*   if (isAllCheck())
            cb_check_all.setChecked(true);
        else
            cb_check_all.setChecked(false);
        selva.notifyDataSetChanged();*/
        calculate();
    }

    private boolean isAllCheck()
    {

        for (GroupInfo group : groups)
        {
            if (!group.isChoosed())
                return false;

        }

        return true;
    }

    /** 全选与反选 */
    private void doCheckAll()
    {
        for (int i = 0; i < groups.size(); i++)
        {
            groups.get(i).setChoosed(cb_check_all.isChecked());
            GroupInfo group = groups.get(i);
            List<ProductInfo> childs = children.get(group.getId());
            for (int j = 0; j < childs.size(); j++)
            {
                childs.get(j).setChoosed(cb_check_all.isChecked());
            }
        }
        selva.notifyDataSetChanged();
    }

    /**
     * 统计操作<br>
     * 1.先清空全局计数器<br>
     * 2.遍历所有子元素，只要是被选中状态的，就进行相关的计算操作<br>
     * 3.给底部的textView进行数据填充
     */
    private void calculate()
    {
        totalCount = 0;
        totalPrice = 0.00;
        for (int i = 0; i < groups.size(); i++)
        {
            GroupInfo group = groups.get(i);
            List<ProductInfo> childs = children.get(group.getId());
            for (int j = 0; j < childs.size(); j++)
            {
                ProductInfo product = childs.get(j);
                if (product.isChoosed())
                {
                    totalCount++;
                    totalPrice += product.getPrice() * product.getCount();
                }
            }
        }
        tv_total_price.setText("￥" + totalPrice);
        tv_go_to_pay.setText("去支付(" + totalCount + ")");
    }
}
